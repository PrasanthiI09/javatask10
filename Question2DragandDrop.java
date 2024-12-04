package javatask10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question2DragandDrop {
    static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//Calling all related methods to excecute
		instantiatebroswer();
		DragandDrop();
		driver.close();
		driver.quit();	

	}
    public static void instantiatebroswer() throws InterruptedException  //Method to open browser and open url
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\prabh\\eclipse-workspace\\GuviMavenProject\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");
		Thread.sleep(5000);
		
    } 
    public static void DragandDrop() throws InterruptedException   //Method to Drag and Drop from SOurce to Target
    {
    	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));  // Switch to Frame  	
    	WebElement DragmetomyTarget = driver.findElement(By.id("draggable"));     // Locating Source Element
    	WebElement DropHere = driver.findElement(By.id("droppable"));             // Locating Target Element
    	String backGroundColorBeforeDrop=DropHere.getCssValue("background-color"); // Assigning background color before dropping to variable for later use
    	Actions action=new Actions(driver);
    	action.dragAndDrop(DragmetomyTarget, DropHere).perform();
    	Thread.sleep(5000);
    	WebElement myLinkText=driver.findElement(By.id("droppable"));
    	String changedLinkText = myLinkText.getText();
    	String verifyLinkText="Dropped!";
    	if(changedLinkText.equalsIgnoreCase(verifyLinkText))                // Verifyinf Text after dropped
    	{
    		System.out.println("The Text after dropping the Source is -- "+changedLinkText+"--The Text is changed to Dropped ");
    
    	}
    	else
    	{
    		System.out.println("Text is not changed to Dropped");
    	}
    	String backgroundcolorafterdropped=myLinkText.getCssValue("background-color");
    	if(backGroundColorBeforeDrop.equalsIgnoreCase(backgroundcolorafterdropped))    // Verifying color before and after drop action - should not match
    	{
    		System.out.println("Background color is mot chnaged after droppping--FAIL ");
    	}
    	else
    	{
    		System.out.println("Background color is changed after dropping -- PASS");
    	}
    }
   

}

