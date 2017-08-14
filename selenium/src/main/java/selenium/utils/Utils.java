package selenium.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static boolean naverModule(WebDriver driver, String siteUrl, String menuName) throws InterruptedException{
		
		String parentHandle="";
		Set<String> PopHandle= null;
		Iterator<String> it = null;
		String ChildHandle = "";
		
		driver = new ChromeDriver();
		driver.get(siteUrl);
	    driver.findElement(By.cssSelector("span.gnb_txt")).click();
	    driver.findElement(By.id("id")).clear();
	    driver.findElement(By.id("id")).sendKeys("multimedia89");
	    driver.findElement(By.id("pw")).clear();
	    driver.findElement(By.id("pw")).sendKeys("picture89");
	    driver.findElement(By.cssSelector("input.btn_global")).click();
	    driver.findElement(By.id(menuName)).click();
	    driver.switchTo().frame("cafe_main");
	    WebDriverWait wait4 = new WebDriverWait(driver, 30);// 1 minute 
	    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("글쓰기")));
	    driver.findElement(By.linkText("글쓰기")).click();
	    WebDriverWait wait5 = new WebDriverWait(driver, 30);// 1 minute 
	    wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
	    driver.findElement(By.id("subject")).clear();
	    driver.findElement(By.id("subject")).sendKeys("It 인재모집");
	    
	    
	    driver.findElement(By.cssSelector("a.ico_pic > strong")).click();
	    
	    PopHandle =  driver.getWindowHandles();
	    it = PopHandle.iterator();
	    
	    while(it.hasNext())
	    {   
	        if (it.next() != parentHandle)
	        {   
	            ChildHandle = it.next().toString();
	            // because the new window will be the last one opened
	            driver.switchTo().window(ChildHandle);
	            WebDriverWait wait = new WebDriverWait(driver, 30);// 1 minute 
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.npe_alert_btn_close")));
	            driver.findElement(By.cssSelector("button.npe_alert_btn_close")).click();
	            driver.findElement(By.id("pc_image_file")).clear();
	            driver.findElement(By.id("pc_image_file")).sendKeys("C:\\Users\\JH-PC\\Desktop\\selenium\\1.JPG");
	            Thread.sleep(1000);
	            driver.findElement(By.cssSelector("button.npu_btn.npu_btn_submit")).click();
	            Thread.sleep(1000);
	        }
	    }
	    driver.switchTo().window(parentHandle);
	    driver.switchTo().frame("cafe_main");
	    Thread.sleep(1000);
	    driver.findElement(By.id("cafewritebtn")).click();
	    Thread.sleep(3000);
	    

	    driver.quit();
		
		return false;
	}
}
