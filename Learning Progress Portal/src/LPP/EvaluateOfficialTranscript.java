package LPP;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EvaluateOfficialTranscript {

//	public static void main(String[] args)
	public static void callTEPtoEaluate(String fName, String lName) throws InterruptedException
	{
//		String fName="SARmdzogyk";
//		String lName = "CHHmkygzdo";
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driverTEP = new ChromeDriver();
		driverTEP.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverTEP.manage().window().maximize();
		driverTEP.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		driverTEP.get("http://s-transeval.pennfoster.edu");	
		login(driverTEP);
		assignTranscript(driverTEP, fName, lName);
	}
	
	public static void assignTranscript(WebDriver driverTEP, String fName, String lName) throws InterruptedException
	{
		driverTEP.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(fName+" "+lName);
		driverTEP.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/span/i")).click();
		driverTEP.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor executor = (JavascriptExecutor)driverTEP;
		WebElement element2 = driverTEP.findElement(By.cssSelector(".jqgrid-button.btn.btn-success.ActionAssign"));
		executor.executeScript("document.getElementsByClassName('jqgrid-button btn btn-success ActionAssign')[0].click();");
		
		driverTEP.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		executor.executeScript("document.getElementById('confirm-dialog').style.display='block';");			//making pop up visible
		WebElement element = driverTEP.findElement(By.xpath("//button[text()='Yes']"));
		element.click();
		
		Thread.sleep(2000);
		executor.executeScript("document.getElementsByClassName('jqgrid-button btn btn-primary ActionEvaluate')[0].click();");
		
		int i=0;
		List<WebElement> check = driverTEP.findElements(By.xpath(".//*[@id='TRCredit']/label/span"));
		
		for (WebElement abc : check)  			//Loop starts with counter 1
		{
			
			if (i<4)
				abc.click();
			i++;
		}
	//	((JavascriptExecutor) driverTEP).executeScript("document.getElementById('(Details_EvaluatorComment)[1]').disabled = false");
		
		driverTEP.findElement(By.xpath("(//textarea[@name='Details.EvaluatorComment'])[1]")).clear();
		driverTEP.findElement(By.xpath("(//textarea[@id='Details_EvaluatorComment'])[2]")).sendKeys("This is Evaluaore's Comment");
		driverTEP.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/form[2]/div/div/div/div/div[2]/div/div[11]/input[1]")).click();
		
	//	driverTEP.close();
		
	}
	
	

	public static void login(WebDriver driverTEP)
	{
		driverTEP.findElement(By.xpath(".//*[@id='Username']")).sendKeys("cntr_tkumar");
		driverTEP.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Password@9");
		driverTEP.findElement(By.cssSelector("#btnLogin")).click();
	}
}
