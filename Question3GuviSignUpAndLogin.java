package javatask10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question3GuviSignUpAndLogin {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		instantiatebrowser();
		SignUp();
		EnterDetails();
		AboutYourselfDetails();
		close();
		instantiatebrowser();
		LogInLink();
		LogInDetails();
		close();
	}
	public static void instantiatebrowser() throws InterruptedException {
			//Open Chrome Browser. Below is the only way the driver is opening in my Laptop.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prabh\\eclipse-workspace\\GuviMavenProject\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//Open Guvi URL
		driver.get("https://www.guvi.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	public static void SignUp() throws InterruptedException {
	
		//Clicking SignUp Button
		WebElement myElement = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
		myElement.click();
		Thread.sleep(2000);
	}	
	public static void EnterDetails() throws InterruptedException {
		
		//Entering all details and clicking SignUp Button
		WebElement myElement=driver.findElement(By.xpath("//input[@class='form-control']"));
		myElement.sendKeys("Sath");
		myElement.sendKeys(Keys.ENTER);
		myElement=driver.findElement(By.xpath("//input[@type='email']"));
		myElement.sendKeys("abm231c@gmail.com");
		myElement.sendKeys(Keys.ENTER);
		myElement = driver.findElement(By.id("password"));
		myElement.sendKeys("abqbc123");
		myElement.sendKeys(Keys.ENTER);
		myElement=driver.findElement(By.xpath("//input[@id='mobileNumber']"));
		myElement.sendKeys("9876543235");
		myElement.sendKeys(Keys.ENTER);
		myElement=driver.findElement(By.id("signup-btn"));
		myElement.click();
		Thread.sleep(5000);
	}
		public static void AboutYourselfDetails() throws InterruptedException
		{
		// Selecting "Looking for a career" from drop down "Your Current Profile"
		        driver.findElement(By.xpath("//select[@id='profileDrpDwn']")).click();
		        List<WebElement> myElements = driver.findElements(By.xpath("//select[@id='profileDrpDwn']//option"));
		        for(int index=0;index<myElements.size();index++)
		        {
			        if(myElements.get(index).getText().equalsIgnoreCase("Looking for a career"))
			          {						
			             myElements.get(index).click();
			             break;
			          }						
		        }
		Thread.sleep(5000);
		//Selecting "B.E. / B.Tech. Computer Science from Degree dropdown
	driver.findElement(By.xpath("//select[@id='degreeDrpDwn']")).click();
		myElements=driver.findElements(By.xpath("//select[@id='degreeDrpDwn']//option"));
		for(int index=0;index<myElements.size();index++)
		{
			if(myElements.get(index).getText().equalsIgnoreCase("B.E. / B.Tech. Computer Science"))
			{
			myElements.get(index).click();
			break;
		    }
		}
		//Selecting Year PassOut
		WebElement myElement=driver.findElement(By.xpath("//input[@id='year']"));
		myElement.sendKeys("2006");
		myElement.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Select Submit button
		myElement=driver.findElement(By.xpath("//a[@id='details-btn' and @class='btn details-btn']"));
		myElement.click();
		Thread.sleep(10000);
	
		}
		public static void close()
		{
			driver.close();
		}
		
		public static void  LogInLink()
		{
			 driver.findElement(By.id("login-btn")).click();
		}
		
		public static void LogInDetails() throws InterruptedException
		{
			//Enter all details to Login
			WebElement myElement=driver.findElement(By.xpath("//input[@type='email']"));
			myElement.sendKeys("abm231c@gmail.com");
			myElement.sendKeys(Keys.ENTER);
			myElement=driver.findElement(By.xpath("//input[@type='password']"));
			myElement.sendKeys("abqbc123");
			myElement.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			//Click Login Button
			driver.findElement(By.xpath("//a[@id='login-btn']")).click();
			Thread.sleep(8000);
			
			
					
		}
		
}

