package LPP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LPP_Login extends EvaluateOfficialTranscript{

	static randomNameGenerate obj = new randomNameGenerate();
	static String firstName = obj.shuffle();
	static String lastName = obj.shuffle();
	static String finalFirstName= "SAR"+firstName;
	static String finalLastName = "CHH"+lastName;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LPPUserLogin(driver);
		preparingUserForEnrollmentUnderManage(driver);
		admissionsTile(driver);
		addTranscript(driver);
	}

	public static void admissionsTile(WebDriver driver) {
		
		// BEGIN ENROLLMENT
		
		
		driver.findElement(By.xpath(".//*[@id='snadmissions']/a")).click();
		driver.findElement(By.xpath("//a[@href='NewEnrollments.aspx']")).click();
		Select ProgramdIdList = new Select(driver.findElement(By.xpath("//select[@name='ctl00$ContentPlaceHolder1$LeadControl$ddlBook']")));
		ProgramdIdList.selectByIndex(1);
		driver.findElement(By.xpath(".//*[@id='s2id_ContentPlaceHolder1_LeadControl_txtClient_number']/a/span[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'FLINT/GENESEE JOB CORPS CENTER')]")).click();
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtStudent_firstname")).sendKeys(finalFirstName);
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtStudent_lastname")).sendKeys(finalLastName);
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtAddress_line_1")).sendKeys("925");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtAddress_line_2")).sendKeys("oat st");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_LeadControl_txtCity']")).sendKeys("Scranton");
		Select cityList = new Select(driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_ddlState")));
		cityList.selectByVisibleText("Pennsylvania");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtZip_Code")).sendKeys("18515");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtStudentDOB")).sendKeys("07/28/1989");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtStudentGender")).sendKeys("m");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtPhone")).sendKeys("9999999999");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_LeadControl_txtStudentEmailAddress")).sendKeys("garvitsharma@qainfotech.com");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_LeadControl_btnSaveLeadExit']")).click();		
		
	}
	
	
	
	public static void addTranscript(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='form1']/div[3]/div[3]/div/div[3]/div[2]/div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_ContentPlaceHolder1_TranscriptControl_txtStudent_number']/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/div/input")).sendKeys(finalFirstName+" "+finalLastName);
		driver.findElement(By.cssSelector("div.select2-result-label")).click();
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtTabeReading")).sendKeys("21.2");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtTabeMath")).sendKeys("231");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtTranscriptComment")).sendKeys("Transcript Comments");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtInstituteName")).sendKeys("Graphic Era");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtCampusName")).sendKeys("Dehradun");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_TranscriptControl_txtStudentName']")).sendKeys(finalFirstName+" "+finalLastName);
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtTranscriptName")).sendKeys("English");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_FileUpload1")).sendKeys("C:/Users/saurabhchhetri/Desktop/mini.jpg");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_chkIAgree")).click();
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_txtUserInitial")).sendKeys("User Initials");
		driver.findElement(By.cssSelector("#ContentPlaceHolder1_TranscriptControl_btnSend")).click();
		
		callTEPtoEaluate(finalFirstName,finalLastName);
	}
	
	
	public static void preparingUserForEnrollmentUnderManage(WebDriver driver) {
		driver.findElement(By.xpath(".//*[@id='usermgtlink']/a")).click();
		driver.findElement(By.xpath(".//*[@id='searchtype']")).sendKeys("sarlpp");
		driver.findElement(By.xpath(".//*[@id='usersTab']/div[2]/div[1]/div/button")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='edituserlevel editable editable-click']")).click();

		// Select TOP LEVEL user
		Select UserLevels = new Select(driver.findElement(By.cssSelector("select.form-control.input-sm")));
		UserLevels.selectByValue("Administrator");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm editable-submit']")).click();

		// Selecting PREFIX
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@class='edituserprefix editable editable-click']")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_autogen14']/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[3]/div")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm editable-submit']")).click();
	}

	public static void LPPUserLogin(WebDriver driver) {
		driver.get("http://s-lpp.learnermanagement.com/lppsite");
		driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("sarlpp");
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("Password1");
		driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
	}

}
