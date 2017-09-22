//
//
//import static org.junit.Assert.fail;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class dbcutTest {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//  private String CHROMEDRIVER_FILE_PATH = "";
//
//  @Before
//  public void setUp() throws Exception {
//	  
//      // 크롬 드라이버 파일 경로
//    CHROMEDRIVER_FILE_PATH = "C:\\Users\\JH-PC\\Desktop\\selenium\\chromedriver.exe";
//
//    System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
//    
//
//    driver = new ChromeDriver();
//    baseUrl = "https://www.naver.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testDbcut() throws Exception {
//    driver.get("https://www.dbcut.com/bbs/index.php");
//    driver.findElement(By.id("MB_ID")).clear();
//    driver.findElement(By.id("MB_ID")).sendKeys("jeongh389");
//    driver.findElement(By.id("MB_PW")).clear();
//    driver.findElement(By.id("MB_PW")).sendKeys("wjdgml89");
//    driver.findElement(By.xpath("(//input[@type='image'])[2]")).click();
//    driver.findElement(By.linkText("구인구직")).click();
//    driver.findElement(By.xpath("//img[@onclick='getWritePage();']")).click();
//    driver.findElement(By.name("BB_SUBJECT")).clear();
//    driver.findElement(By.name("BB_SUBJECT")).sendKeys("IT 디자인채용공고");
////    WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
////    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("upFile")));
//    driver.switchTo().frame("UploadFrame");
//    driver.findElement(By.xpath("//html/body/form/table/tbody/tr/td[3]/table/tbody/tr[2]/td/input[1]")).sendKeys("C:\\Users\\JH-PC\\Desktop\\selenium\\1.JPG");
//    
////    driver.findElement(By.name("upFile")).sendKeys("C:\\Users\\JH-PC\\Desktop\\selenium\\1.JPG");
//    driver.findElement(By.name("SubmitBtn")).click();
//    
//    driver.switchTo().defaultContent();
//    driver.findElement(By.name("BB_CONTENT")).sendKeys("IT 개발자");
//    driver.findElement(By.xpath("(//input[@type='image'])[2]")).click();
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
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
