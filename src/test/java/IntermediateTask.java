/**
 * Created by Administrator on 04/09/2017.
 */

import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.List;


import static java.util.concurrent.TimeUnit.SECONDS;

import static org.junit.Assert.assertEquals;

public class IntermediateTask {

    WebDriver wd;
    ExtentTest extentTest = reportManager.setUpTest();
    private static ExtentReportManager reportManager;

    @BeforeClass
    public static void init() {
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report", "Basic Report");
        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML, reportDetails);
    }


    @Before
    public void setUp() {
        //wd= new ChromeDriver();


    }

    @After
    public void tearDown() {
        try {
            wd.quit();
        } catch (WebDriverException w) {
            System.out.println(w.getMessage());
            extentTest.log(Status.WARNING, "Used to report an issue that may cause problems within a system");
        }
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
    public void myTest() throws IOException, InterruptedException {

        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Example_Spreadsheet.xlsx");
        int[] numberOfRows = {0};
        for (int rowNo : numberOfRows) {
            sheetReader.readRow(rowNo, "testing");
        }

        List<String> row = sheetReader.readRow(0, "testing");

//        ExtentTest extentTest = reportManager.setUpTest();
//        extentTest.log(Status.WARNING, "Used to report an issue that may cause problems within a system");
        String u = row.get(0);
        String p = row.get(1);
        if (row.get(2).equals("firefox")) {
            wd = new FirefoxDriver();
            System.out.println("Using firefox");
        } else {
            wd = new ChromeDriver();
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(wd)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);


        wd.navigate().to("http://thedemosite.co.uk");
        String imagePath = ScreenShot.take(wd, "image");
//        Assert.assertTrue(true);
        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")).sendKeys(u);
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")).sendKeys(p);
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys(u);
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys(p);
        Thread.sleep(500);
        wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();
        Thread.sleep(500);
//        WebElement foo = wait.until(new Function() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.id("foo"));
//            }
//        });
        try {
            assertEquals("**Successful Login**", wd.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
            extentTest.pass("Passed");
        } catch (AssertionError e) {
            String details = "Intermediate task failed due to: " + e.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }

    }

    @AfterClass
    public static void cleanUp() {
        reportManager.clearTests();
    }
}
