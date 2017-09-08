import Pages.AdvancedHome;
import Pages.ProjectHome;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Function;
import org.apache.xpath.functions.FuncExtElementAvailable;
import org.junit.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 08/09/2017.
 */
public class ProjectTask {

    WebDriver driver;
    ProjectHome a;
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
        driver = new ChromeDriver();
        driver.navigate().to("http://www.autotrader.co.uk/");

    }
    @After
    public void tearDown() {
        try {
            driver.quit();
        } catch (WebDriverException w) {
            System.out.println(w.getMessage());
            extentTest.log(Status.WARNING, "Used to report an issue that may cause problems within a system");
        }
    }

    @Test
    public void front(){
        a= new ProjectHome(driver);
        WebElement el= a.getLogo();

        try {
           Assert.assertEquals(true,el.isDisplayed());
//            assertEquals("AutoTrader", el.getText());

            extentTest.pass("Passed");
        } catch (AssertionError e) {
            String details = "Failed due to: " + e.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }

    }
    @Test
    public void sell(){
        a= new ProjectHome(driver);
        WebElement e= a.getSell();
        WebElement e1= a.getAtSell();

        Actions builder= new Actions(driver);
        builder.moveToElement(e).click();
        builder.build().perform();

//        e.click();

        try {
//            Assert.assertEquals(true,e1.isDisplayed());
//            assertEquals("It's not any car. It's your car.\n" +
//                    "Valued at £1000 or less and\n" +
//                    "we'll sell it for free.", e1.getText());
            Assert.assertEquals(true,e1.isDisplayed());
            extentTest.pass("Passed");
        } catch (AssertionError ex) {
            String details = "Failed due to: " + ex.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }

    }

    @Test
    public void search(){
        a= new ProjectHome(driver);
        WebElement e= a.getPostcode();
        WebElement e1= a.getDistance();
        WebElement e2= a.getMake();
        WebElement e3= a.getSearch();
        WebElement e4= a.getFound();


//        e.sendKeys("M50 2EQ");
//        e1.sendKeys("Within 5 miles");
//        e2.sendKeys("Audi");

        Actions builder= new Actions(driver);
        builder.moveToElement(e).sendKeys("M50 2EQ");
        builder.moveToElement(e1).click().sendKeys("Within 5 miles");
        builder.moveToElement(e2).click().sendKeys("Audi");
        builder.moveToElement(e3).click().perform();

//        e3.click();

        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        wait.until(new Function<WebDriver, Boolean>(){
            public Boolean apply(WebDriver webDriver){
                return webDriver.getCurrentUrl().equals("http://www.autotrader.co.uk/");
            }
        });
        try {
//
            Assert.assertEquals(true,e4.isDisplayed());
            extentTest.pass("Passed");
        } catch (AssertionError ex) {
            String details = "Failed due to: " + ex.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }



    }
    @Test
    public void dealer(){

        a= new ProjectHome(driver);
        WebElement e= a.getDealer();
        WebElement e1= a.getDealerpost();
        WebElement e2= a.getDealermake();
        WebElement e3= a.getDealersearch();
        WebElement e4= a.getDealerfound();


        Actions builder= new Actions(driver);
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/project.xlsx");
        int[] numberOfRows = {0};
        for (int rowNo : numberOfRows) {
            sheetReader.readRow(rowNo, "autoTrader");
        }

        List<String> row = sheetReader.readRow(0, "autoTrader");


        String u = row.get(0);
        String p = row.get(1);




        builder.moveToElement(e).click().perform();


        builder.moveToElement(e1).sendKeys(u);
        builder.moveToElement(e2).click();

        builder.moveToElement(e2).sendKeys(p);

        builder.moveToElement(e3).click().perform();
        builder.build().perform();

        try {

            Assert.assertEquals(true,e4.isDisplayed());
            extentTest.pass("Passed");
        } catch (AssertionError ex) {
            String details = "Failed due to: " + ex.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }

    }





}
