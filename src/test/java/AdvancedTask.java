import Pages.Home;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 07/09/2017.
 */
public class AdvancedTask {
    WebDriver driver;
    Home homePage;
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
        driver.navigate().to("http://demoqa.com/droppable/");

    }
    @Test
    public void shirtTest(){

    }



}
