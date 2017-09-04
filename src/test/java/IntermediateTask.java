/**
 * Created by Administrator on 04/09/2017.
 */
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class IntermediateTask {

    WebDriver wd;
    private static ExtentReportManager reportManager;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
      reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }


    @Before
    public void setUp(){
        wd= new ChromeDriver();

    }
    @After
    public void tearDown(){
        wd.quit();
    }
//    @Test
//    public void passingLogLevelTest(){
//        ExtentTest passingLogLevelTest = reportManager.setUpTest();
//        passingLogLevelTest.log(Status.INFO,"Info level message to show information that allows a NON-TECHNICAL" +
//                " person to understand what the test is doing");
//        passingLogLevelTest.log(Status.DEBUG,
//                "Debug level message to display any information a TECHNICAL person might need to know");
//        passingLogLevelTest.pass("Training.Example passing test");
//    }
    @Test
    public void myTest()throws IOException {
        ExtentTest extentTest = reportManager.setUpTest();
//        extentTest.log(Status.WARNING, "Used to report an issue that may cause problems within a system");
        String u = "testing";
        String p = "1234";
        wd.navigate().to("http://thedemosite.co.uk");
        String imagePath = ScreenShot.take(wd, "image");
//        Assert.assertTrue(true);
        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys(u);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys(p);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys(u);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys(p);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        try {
            assertEquals("**Successfull Login**", wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
            extentTest.pass("Passed");
        } catch (AssertionError e) {
            String details = "Intermediate task failed due to: " + e.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }
    }
    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }
}
