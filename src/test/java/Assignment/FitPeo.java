package Assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FitPeo {

	public static void main(String[] args) throws Exception {
		
		String ExpectedValue = "110700";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		Robot r = new Robot();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		try {
			
			driver.get("https://www.fitpeo.com/");
			driver.findElement(By.xpath("//div[@class='MuiBox-root css-70qvj9']//div[.='Revenue Calculator']")).click();
			WebElement scrollEle = driver.findElement(By.xpath("//h4[.='Medicare Eligible Patients']"));
	        js.executeScript("arguments[0].scrollIntoView(true);", scrollEle);        
	        WebElement slideEle = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
	        act.dragAndDropBy(slideEle, 94,0).perform();
	        for(int i=1;i<=3;i++)
	        {
	        	r.keyPress(KeyEvent.VK_LEFT);
				r.keyRelease(KeyEvent.VK_LEFT);
	        }
	        System.out.println("Slider moved to 820 POSITION");
	        Thread.sleep(3000);
	        WebElement TextBox = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root MuiSlid')]/following-sibling::div//input[@type='number']"));
	        TextBox.clear();
	        Thread.sleep(1000);
	        TextBox.sendKeys("560");
	        act.dragAndDropBy(slideEle, -38,0).perform();
	        for(int i=1;i<=3;i++)
	        {
	        	r.keyPress(KeyEvent.VK_LEFT);
				r.keyRelease(KeyEvent.VK_LEFT);
	        }
	        System.out.println("Slider moved to 560 POSITION");
	        Thread.sleep(3000);
	        act.dragAndDropBy(slideEle, 40,0).perform();
	        for(int i=1;i<=3;i++)
	        {
	        	r.keyPress(KeyEvent.VK_LEFT);
				r.keyRelease(KeyEvent.VK_LEFT);
	        }
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[.='CPT-99091']/..//input[@type='checkbox']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[.='CPT-99453']/..//input[@type='checkbox']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[.='CPT-99454']/..//input[@type='checkbox']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//p[.='CPT-99474']/..//input[@type='checkbox']")).click();
	        Thread.sleep(2000);
	        String Value = driver.findElement(By.xpath("//p[.='Total Recurring Reimbursement for all Patients Per Month']/following-sibling::p")).getText();
	        
	        Assert.assertTrue(Value.contains(ExpectedValue));
	        System.out.println("Task is PASS");
		} catch (Exception e) {
			System.out.println("Task Failed");
		}
		finally {
			driver.quit();
		}
		
	}
}
