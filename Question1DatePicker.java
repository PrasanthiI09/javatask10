package javatask10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1DatePicker {
    static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Calling all related methods to excecute
		instantiatebrowser();
		SwitchToIframe();
		SelectMonthandDate("22");
		driver.close();
		driver.quit();
		
	}

	public static void instantiatebrowser() throws InterruptedException   //Method to open browser and open url
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prabh\\eclipse-workspace\\GuviMavenProject\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker");
		Thread.sleep(5000);
	
	}
	
	public static void SwitchToIframe()//method to switch to frame
	{
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
	}
	public static void SelectMonthandDate(String Date) throws InterruptedException//method to select the month and date
	{
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
		List<WebElement> DateList= driver.findElements(By.xpath("//td[@data-handler='selectDay']//a"));
		for(int index=0;index<DateList.size();index++)
		{
			if(DateList.get(index).getText().equalsIgnoreCase(Date))
			{
				DateList.get(index).click();
				System.out.println("Date Picked is - "+Date);
				break;
			}
			
		}
		Thread.sleep(5000);
	}
}
