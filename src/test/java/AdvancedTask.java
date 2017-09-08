import Pages.AdvancedHome;
import Pages.Home;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 07/09/2017.
 */
public class AdvancedTask {
    WebDriver driver;
    AdvancedHome a;
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
        driver.navigate().to("http://automationpractice.com/index.php");

    }
    @Test
    public void shirtTest(){
        a= new AdvancedHome(driver);
        WebElement el= a.getSearch();
        WebElement el1= a.getFound();
        WebElement el2= a.getGo();
        Actions builder= new Actions(driver);
        el.sendKeys("shirts");
        el2.click();
        try {
            assertEquals("Showing 1 - 1 of 1 item", el1.getText());
            extentTest.pass("Passed");
        } catch (AssertionError e) {
            String details = "Failed due to: " + e.getMessage();
            extentTest.fail(details);
            Assert.fail(details);
        }

    }





}
