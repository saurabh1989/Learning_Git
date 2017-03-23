package Banfield;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import LPP.randomNameGenerate;

public class munual_Enrollment {

	public void ReturningStudentEnrollmentForm(FirefoxDriver driver, int std_id)
	{
		driver.findElement(By.xpath("//input[@id='rdStudentType_1']")).click();
		driver.findElement(By.xpath(".//*[@id='txtSearch']")).sendKeys(""+std_id);
		driver.findElement(By.xpath(".//*[@id='form1']/div[3]/div/div[4]/div[2]/div[1]/div/div/button")).click();
		driver.findElement(By.xpath(".//*[@id='form1']/div[3]/div/div[4]/div[2]/div[1]/div/div/ul/li[2]/a")).click();
		
		
		randomNameGenerate objectName = new randomNameGenerate();
		String firstName=objectName.shuffle();
		String lastName=objectName.shuffle();
		String finalFirstName= "SAR"+firstName;
		String finalLastName = "CHH"+lastName;
		driver.findElement(By.xpath(".//*[@id='txtStudent_firstname']")).sendKeys(finalFirstName);
		driver.findElement(By.xpath(".//*[@id='txtStudent_lastname']")).sendKeys(finalLastName);
		driver.findElement(By.xpath(".//*[@id='txtStudentDOB']")).sendKeys("07/28/1989");
		driver.findElement(By.xpath(".//*[@id='txtStudentGender']")).sendKeys("M");
		driver.findElement(By.xpath(".//*[@id='txtBanFieldEmailAddress']")).clear();
		driver.findElement(By.xpath(".//*[@id='txtBanFieldEmailAddress']")).sendKeys("saurabhchhetri@qainfotech.com");
		driver.findElement(By.xpath(".//*[@id='txtPersonalEmailAddress']")).sendKeys("saurabhchhetri@qainfotech.com");
		driver.findElement(By.xpath(".//*[@id='txtPhone']")).sendKeys("9999999999");
		driver.findElement(By.xpath(".//*[@id='txtCellPhone']")).sendKeys("9999999998");
		driver.findElement(By.xpath(".//*[@id='txtAddress_line_1']")).sendKeys("925 oak st");
		driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys("Scranton");
		Select cityList = new Select(driver.findElement(By.xpath(".//*[@id='ddlState']")));
		cityList.selectByVisibleText("Pennsylvania");
		driver.findElement(By.xpath(".//*[@id='txtZip_Code']")).sendKeys("18515");
		driver.findElement(By.xpath(".//*[@id='txtHospitalNumber']")).sendKeys("123123");
		driver.findElement(By.xpath(".//*[@id='txtBanfieldAssociateID']")).sendKeys("124578");
		driver.findElement(By.xpath(".//*[@id='txtClockNumber']")).sendKeys("1234567890");
		driver.findElement(By.xpath(".//*[@id='chkIAgree']")).click();
		driver.findElement(By.xpath(".//*[@id='agreementLink']")).click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		    driver.switchTo().window(winHandle);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
	}
	
	
	public static void main(String[] args) {
		
		System.out.print("Enter Student Number : ");
		Scanner scan=new Scanner(System.in);
		int sid=scan.nextInt();
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://s-lpp.learnermanagement.com/lppsite");
		driver.findElement(By.xpath(".//*[@id='form1']/p[4]/a")).click();
		munual_Enrollment objectCall = new munual_Enrollment();
		//for(int i=0;i<5;i++)
			objectCall.ReturningStudentEnrollmentForm(driver, sid);
		driver.close();
	}
}
