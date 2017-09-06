import Pages.Home;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Administrator on 06/09/2017.
 */
public class Mousetest2 {

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
    public void draganddrop(){
        homePage = new Home(driver);
        WebElement el= homePage.getEl();
        WebElement el2= homePage.getEl2();
        Actions builder = new Actions(driver);

        builder.moveToElement(el);
        builder.clickAndHold();
//        builder.moveByOffset(el.getLocation().getX()-150, el.getLocation().getY()-300);
        builder.dragAndDrop(el,el2);
        builder.release();
        builder.build().perform();

    }
    @Test
    public void resize(){
       homePage = new Home(driver);
        WebElement el= homePage.getEl3();
        WebElement el2= homePage.getEr();
        el2.click();
        Actions builder = new Actions(driver);

        builder.moveToElement(el);
        builder.clickAndHold();
        builder.moveByOffset(el.getLocation().getX()+10, el.getLocation().getY()+10);
        builder.release();
        builder.build().perform();

    }
    @Test
    public void selectable(){
        homePage = new Home(driver);
        WebElement el= homePage.getItem7();
        WebElement el1= homePage.getItem1();
        WebElement el2= homePage.getSelectable();
        el2.click();
        Actions builder = new Actions(driver);
        builder.moveToElement(el);
        builder.clickAndHold();
//        builder.moveByOffset(el.getLocation().getX()-150, el.getLocation().getY()-300);
        builder.dragAndDrop(el,el1);
        builder.release();
        builder.build().perform();
    }
    @Test
    public void sortable(){
        homePage = new Home(driver);
        WebElement el= homePage.getSeven();
        WebElement el1= homePage.getOne();
        WebElement el2= homePage.getSortable();
        el2.click();
        Actions builder = new Actions(driver);
        builder.moveToElement(el);
        builder.clickAndHold();
//        builder.moveByOffset(el.getLocation().getX()-150, el.getLocation().getY()-300);
        builder.dragAndDrop(el,el1);
        builder.release();
        builder.build().perform();
    }
    @Test
    public void accordion(){
        homePage = new Home(driver);
        WebElement el= homePage.getList2();
        WebElement el1= homePage.getList4();
        WebElement el2= homePage.getAccordion();
        el2.click();
        Actions builder = new Actions(driver);
        builder.moveToElement(el).click();

        builder.release();
        builder.moveToElement(el1).click();
        builder.release();
        builder.build().perform();
    }
    @Test
    public void autocomplete(){
        homePage = new Home(driver);
        WebElement el= homePage.getItem7();
        WebElement el1= homePage.getItem1();
        WebElement el2= homePage.getAutocomplete();
        el2.click();
        Actions builder = new Actions(driver);

    }


}
