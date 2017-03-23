package B2BStudentEnrollment;

import java.awt.Desktop.Action;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import LPP.randomNameGenerate;

public class B2BEnrollmentStudent {

	public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException, IOException {

		call();
	}
	
	public static void call() throws InterruptedException, UnsupportedFlavorException, IOException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please provide Parent Number : ");
		int parentNumber = scanner.nextInt();
		
		scanner.nextLine();
		System.out.print("Please provide Industry Class/Prefix : ");
		String prefix = scanner.nextLine();

		System.out.print("Please provide ProgramID :");
		int programId =scanner.nextInt();

		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("http://i622dka:lenovo1@10.168.8.6:8081/profoundui/atrium/menu"); // Handling
																						// POP
																						// UPs
																						// where
																						// we
																						// can
																						// not
																						// navigate
																						// through
																						// FIREBUG
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Domestic Stage']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='selector'])[2]")));

		driver.findElement(By.cssSelector("#I_21_52")).sendKeys("I622DKA");
		driver.findElement(By.xpath(".//*[@id='I_22_52']")).sendKeys("lenovo1");

		clickEnter(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		clickEnter(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickEnter(driver);
		driver.switchTo().defaultContent();

		enrollment(driver, parentNumber, prefix, programId);
	}

	public static void enrollment(FirefoxDriver driver, int parentNumber, String prefix, int programId)
			throws InterruptedException, UnsupportedFlavorException, IOException {
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='selector'])[2]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='D_10_6']/a")).click();

		driver.findElement(By.xpath(".//*[@id='I_16_9']")).sendKeys("1"); // ENTERING
																			// B&I
																			// STAGING
																			// ENVIRONMENT
		clickEnter(driver);
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='I_19_6']")).sendKeys("BNICS");
		clickEnter(driver);
		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='D_6_3']/a[1]")).click();
		fillingAddressBookInformationForm(driver, parentNumber, prefix, programId);
	
		
	}

	public static void fillingAddressBookInformationForm(FirefoxDriver driver, int parentNumber, String prefix, int programId)
			throws IOException, InterruptedException {

		driver.findElement(By.xpath(".//*[@id='I_3_18']")).sendKeys("A");
		randomNameGenerate obj = new randomNameGenerate();
		String fName = obj.shuffle();
		String lName = obj.shuffle();

		driver.findElement(By.xpath("//input[@id='I_4_18']")).sendKeys(fName + " " + lName); // Entering
																								// MAILING
																								// NAME
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='I_6_18']")).sendKeys(fName + " " + lName); // Entering
																							// ALPHA
																							// NAME

		driver.findElement(By.xpath(".//*[@id='I_8_18']")).sendKeys("925 oak st"); // ADDRESS
		driver.findElement(By.xpath(".//*[@id='I_12_18']")).sendKeys("18515"); // POSTAL
																				// CODE
		driver.findElement(By.xpath(".//*[@id='I_12_54']")).sendKeys("Scranton"); // CITY
		driver.findElement(By.xpath(".//*[@id='I_13_54']")).sendKeys("PA"); // STATE
		driver.findElement(By.xpath(".//*[@id='I_14_18']")).sendKeys("TR"); // SEARCH
																			// TYPE
		driver.findElement(By.xpath(".//*[@id='I_14_54']")).sendKeys("USA"); // COUNTRY
		driver.findElement(By.xpath(".//*[@id='I_17_54']")).sendKeys("" + parentNumber); // "Passing
																							// an
																							// Integer
																							// value
																							// to
																							// Sendkeys"
		driver.findElement(By.xpath(".//*[@id='I_19_18']")).sendKeys("Y");
		driver.findElement(By.xpath(".//*[@id='I_20_18']")).sendKeys("Y");
		driver.findElement(By.xpath(".//*[@id='I_21_18']")).sendKeys("N");
		driver.findElement(By.xpath(".//*[@id='I_22_18']")).sendKeys("N");
		driver.findElement(By.xpath("//input[@name='InputField31']")).sendKeys(prefix); // Entering
																						// Prefix
		clickEnter(driver);
		Thread.sleep(1000);

		// "Category Codes" page
		String value = driver.findElement(By.xpath("//input[@id='I_4_18']")).getAttribute("value");
		int studentId=Integer.parseInt(value.trim());
		

		
		 clickEnter(driver); Thread.sleep(1000); 
		 Actions act=new Actions(driver); 
		 act.sendKeys(Keys.F3).build().perform();
		 
		 //Customer Master Information page
		  
		 clickEnter(driver); 
		 Thread.sleep(1000); 
		 clickEnter(driver);
		 Thread.sleep(1000); act.sendKeys(Keys.F3).build().perform();
		  
		 // Back to "Customer Master Information" 
		 clickEnter(driver);
		 Thread.sleep(1000); 
		 act.sendKeys(Keys.F3).build().perform();
		 clickEnter(driver); 
		 Thread.sleep(1000); 
		 
		 //Supplier Master Information page 
		 //Address Book -Additional Info page
		 
		 act.sendKeys(Keys.F3).build().perform();
		 clickEnter(driver); 
		 Thread.sleep(1000);
		 act.sendKeys(Keys.F3).build().perform();
		  
		 //Student Supplemental page
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='I_6_22']")).sendKeys("HS");		 //School Type 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='I_10_22']")).sendKeys("N");		 //Degree Student Code 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='I_19_56']")).sendKeys("M");		 //Gender 
		 Thread.sleep(2000); 
		 clickEnter(driver); 
		 Thread.sleep(1000);
		 act.sendKeys(Keys.F3).build().perform(); 
		 clickEnter(driver);
		 Thread.sleep(1000); 
		 act.sendKeys(Keys.F3).build().perform();
		 bnimainEnrollment(driver, studentId, programId, prefix, parentNumber);
		 
	}

	public static void bnimainEnrollment(FirefoxDriver driver, int studentId, int programId, String prefix, int parentNumber) throws InterruptedException {
		
		Actions act1=new Actions(driver); 
		driver.findElement(By.xpath(".//*[@id='I_19_6']")).sendKeys("BNIMAIN");
		clickEnter(driver); 
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='D_11_3']/a[2]")).click();		//Enrollment/Order Entry

		driver.findElement(By.xpath(".//*[@id='I_3_19']")).clear();
		driver.findElement(By.xpath(".//*[@id='I_3_19']")).sendKeys("A");
		driver.findElement(By.xpath(".//*[@id='I_4_19']")).sendKeys(""+studentId);
		driver.findElement(By.xpath(".//*[@id='I_6_19']")).sendKeys("5001");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='I_7_19']")).sendKeys(""+programId);
		Thread.sleep(1000);
		clickEnter(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='I_4_3_W1']")).sendKeys("1");
		clickEnter(driver);
		Thread.sleep(1000);
		clickEnter(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='I_4_27_W1']")).sendKeys("Y");
		clickEnter(driver);
		Thread.sleep(1000);
		act1.sendKeys(Keys.F11).build().perform();
		
		driver.findElement(By.xpath(".//*[@id='I_11_10']")).sendKeys("TR");
		driver.findElement(By.xpath(".//*[@id='I_11_15']")).sendKeys("TUI");
		driver.findElement(By.xpath(".//*[@id='I_11_53']")).sendKeys("500.00");
		
		driver.findElement(By.xpath(".//*[@id='I_12_10']")).sendKeys("PA");
		driver.findElement(By.xpath(".//*[@id='I_12_15']")).sendKeys("BOK");
		driver.findElement(By.xpath(".//*[@id='I_12_53']")).sendKeys("100.00");
		
		act1.sendKeys(Keys.F11).build().perform();
		clickEnter(driver);
		Thread.sleep(1000);
		clickEnter(driver);
		Thread.sleep(1000);
		act1.sendKeys(Keys.F3).build().perform();
		Thread.sleep(1000);
		act1.sendKeys(Keys.F11).build().perform();
		Thread.sleep(1000);
		act1.sendKeys(Keys.F3).build().perform();
		System.out.println("");
		System.out.println("StudentID for ProgramId "+programId+" from Prefix "+prefix+" and with Parent number "+parentNumber+" is :");
		System.out.println(studentId);
		
	}

	public static void clickEnter(FirefoxDriver driver) {
		driver.findElement(By.xpath("(//input[@value='Enter'])[1]")).click();
	}

}
