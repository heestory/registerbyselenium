//
//
//import static org.junit.Assert.fail;
//
//import java.util.Iterator;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class gimasa {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//  private String CHROMEDRIVER_FILE_PATH = "";
//  String parentHandle="";
//  Set<String> PopHandle= null;
//  Iterator<String> it = null;
//  String ChildHandle = "";
//  @Before
//  public void setUp() throws Exception {
//	  
//	  CHROMEDRIVER_FILE_PATH = "C:\\Users\\JH-PC\\Desktop\\selenium\\chromedriver.exe";
//
//	   System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
//	   
//	   DesiredCapabilities caps = DesiredCapabilities.firefox();
//		caps.setBrowserName("firefox");
//		
//    driver = new ChromeDriver();
//    baseUrl = "https://www.google.co.kr/";
//    parentHandle = driver.getWindowHandle();
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    
//  }
//
//  @Test
//  public void testGimasa() throws Exception {
//    driver.get("http://cafe.naver.com/newplanmarketing");
//    driver.findElement(By.cssSelector("span.gnb_txt")).click();
//    driver.findElement(By.id("id")).clear();
//    driver.findElement(By.id("id")).sendKeys("multimedia89");
//    driver.findElement(By.id("pw")).clear();
//    driver.findElement(By.id("pw")).sendKeys("picture89");
//    driver.findElement(By.cssSelector("input.btn_global")).click();
//    driver.findElement(By.id("menuLink69")).click();
//    driver.switchTo().frame("cafe_main");
//    WebDriverWait wait4 = new WebDriverWait(driver, 30);// 1 minute 
//    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("글쓰기")));
//    driver.findElement(By.linkText("글쓰기")).click();
//    WebDriverWait wait5 = new WebDriverWait(driver, 30);// 1 minute 
//    wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
//    driver.findElement(By.id("subject")).clear();
//    driver.findElement(By.id("subject")).sendKeys("It 인재모집");
//    
//    
//    driver.findElement(By.cssSelector("a.ico_pic > strong")).click();
//    
//    PopHandle =  driver.getWindowHandles();
//    it = PopHandle.iterator();
//    
//    while(it.hasNext())
//    {   
//        if (it.next() != parentHandle)
//        {   
//            ChildHandle = it.next().toString();
//            // because the new window will be the last one opened
//            driver.switchTo().window(ChildHandle);
//            WebDriverWait wait = new WebDriverWait(driver, 30);// 1 minute 
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.npe_alert_btn_close")));
//            driver.findElement(By.cssSelector("button.npe_alert_btn_close")).click();
//            driver.findElement(By.id("pc_image_file")).clear();
//            driver.findElement(By.id("pc_image_file")).sendKeys("C:\\Users\\JH-PC\\Desktop\\selenium\\1.JPG");
//            Thread.sleep(1000);
//            driver.findElement(By.cssSelector("button.npu_btn.npu_btn_submit")).click();
//            Thread.sleep(1000);
//        }
//    }
//    driver.switchTo().window(parentHandle);
//    driver.switchTo().frame("cafe_main");
//    Thread.sleep(1000);
//    driver.findElement(By.id("cafewritebtn")).click();
//    Thread.sleep(3000);
//  }
//
//  @After
//  public void tearDown() throws Exception {
//	  driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
