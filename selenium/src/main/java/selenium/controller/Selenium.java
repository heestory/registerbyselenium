package selenium.controller;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import selenium.utils.Utils;

@Controller
public class Selenium {
	
   private WebDriver driver;
   private String baseUrl;
   private boolean acceptNextAlert = true;
   private StringBuffer verificationErrors = new StringBuffer();
   String parentHandle="";
   Set<String> PopHandle= null;
   Iterator<String> it = null;
   String ChildHandle = "";
   
   @Value("#{webDriver['webdriver.window_chrome']}")
   private String WEBDRIVER_CHROME_FILE_PATH;
   @Value("#{webDriver['webdriver.window_firefox']}")
   private String WEBDRIVER_FIREFOX_FILE_PATH;
   
   static final Logger LOGGER = LoggerFactory.getLogger(Selenium.class);
   

	
	@RequestMapping("selenium")
	public String selenium(){
		LOGGER.info("-------------------------------------------");
		LOGGER.info("Start Server");
		LOGGER.info("-------------------------------------------");
		
		LOGGER.debug("-------------------------------------------");
		LOGGER.debug("Start Server");
		LOGGER.debug("-------------------------------------------");
		return "selenium";
	}
	
	@RequestMapping("dbcut")
	public ModelAndView dbcut(HttpServletRequest request, HttpServletResponse response)throws Exception { 
		
		String title;
		ModelAndView mv = new ModelAndView();
		
		try {
			
			title = request.getParameter("title"); 
			   // ũ�� ����̹� ���� ���
			//CHROMEDRIVER_FILE_PATH = "/home/ec2-user/bin/geckodriver";
	
		    System.setProperty("webdriver.gecko.driver", WEBDRIVER_FIREFOX_FILE_PATH);
			
			
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
			//String Node = "http://127.0.0.1:4444";
			//driver = new RemoteWebDriver(new URL(Node), cap);
			
		    
		  /*  DesiredCapabilities caps = new FirefoxOptions()
		    	     // For example purposes only
		    	    .setProfile(new FirefoxProfile())
		    	    .addTo(DesiredCapabilities.firefox());
		    caps.setCapability("acceptInsecureCerts", true);*/
		    
		    //String Node = "http://127.0.0.1:4444";
		    //WebDriver driver = new  RemoteWebDriver(new URL(Node), caps);
		    
		    driver = new FirefoxDriver();
		    driver.get("http://www.dbcut.com/bbs/index.php");
		    driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		    //WebDriverWait wait = new WebDriverWait(driver, 120);// 1 minute 
		 //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MB_ID")));
		    driver.findElement(By.id("MB_ID")).clear();
		    driver.findElement(By.id("MB_ID")).sendKeys("jeongh389");
		    driver.findElement(By.id("MB_PW")).clear();
		    driver.findElement(By.id("MB_PW")).sendKeys("wjdgml89");
		    driver.findElement(By.xpath("(//input[@type='image'])[2]")).click();
		    driver.findElement(By.linkText("���α���")).click();
		    driver.findElement(By.xpath("//img[@onclick='getWritePage();']")).click();
		    driver.findElement(By.name("BB_SUBJECT")).clear();
		    driver.findElement(By.name("BB_SUBJECT")).sendKeys(title);
		    driver.switchTo().frame("UploadFrame");
		    driver.findElement(By.xpath("//html/body/form/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input[1]")).sendKeys("C:\\Users\\JH-PC\\Desktop\\selenium\\1.JPG");
		    //driver.findElement(By.xpath("//html/body/form/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input[1]")).sendKeys("/home/ec2-usr/firefox/1.JPG");
		    driver.findElement(By.name("SubmitBtn")).click();
		    
		    driver.switchTo().defaultContent();
		    driver.findElement(By.name("BB_CONTENT")).sendKeys("IT ������");
		    driver.findElement(By.xpath("(//input[@type='image'])[2]")).click();
		    
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		    }
			
			mv.setViewName("selenium");
		}catch(Exception e){
			throw e;
		}
		
		return mv;
		
		
	}
	
	@RequestMapping("gimasa")
	public ModelAndView gimasa(HttpServletRequest request, HttpServletResponse response)throws Exception { 
		
		
		String title;
		ModelAndView mv = new ModelAndView();
		boolean resultFlag = false;
		
		try {
			
			
			System.setProperty("webdriver.chrome.driver", WEBDRIVER_CHROME_FILE_PATH);
			
			resultFlag = Utils.naverModule(driver, "http://cafe.naver.com/newplanmarketing","menuLink69");
			
			mv.setViewName("selenium");
			
		}catch(Exception e){
			throw e;
		}
		
		return mv;
		
		
	}
	
}
