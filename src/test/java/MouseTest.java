import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 05/09/2017.
 */
public class MouseTest {
    ExtentTest extentTest = reportManager.setUpTest();
    private static ExtentReportManager reportManager;
    WebDriver driver;


//    @FindBy(xpath="//*[@id=\"draggableview\"]")
//    WebElement el;
    @BeforeClass
    public static void init(){

        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report", "Basic Report");
        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML, reportDetails);
    }
    @Before
    public void setUp() {
        driver= new ChromeDriver();

    }
//    @After
//    public void tearDown() {
//        try {
//            driver.quit();
//        } catch (WebDriverException w) {
//            System.out.println(w.getMessage());
//            extentTest.log(Status.WARNING, "Used to report an issue that may cause problems within a system");
//        }
//    }
    @Test
    public void draganddrop() throws InterruptedException {

        driver.navigate().to("http://demoqa.com/droppable/");
        WebElement el=  driver.findElement(By.xpath("//*[@id=\"draggableview\"]"));
        WebElement el2=  driver.findElement(By.xpath("//*[@id=\"droppableview\"]"));
        Actions builder = new Actions(driver);

        builder.moveToElement(el);
        builder.clickAndHold();
//        builder.moveByOffset(el.getLocation().getX()-150, el.getLocation().getY()-300);
        builder.dragAndDrop(el,el2);
        builder.release();
        builder.build().perform();

    }
    @Test
    public void dragItem() throws InterruptedException {
        driver.navigate().to("http://demoqa.com/droppable/");
        WebElement el1=  driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        WebElement el=  driver.findElement(By.xpath("//*[@id=\"ui-id-10\"]/a"));
        WebElement el2=  driver.findElement(By.xpath("//*[@id=\"ui-id-11\"]/ul/li[1]"));
        WebElement el3=  driver.findElement(By.xpath("//*[@id=\"cart\"]/div/ol"));
        WebElement el4=  driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/a"));
        WebElement el5=  driver.findElement(By.xpath("//*[@id=\"ui-id-7\"]/ul/li[2]"));


        Actions builder = new Actions(driver);
        builder.moveToElement(el1).click();
        builder.moveToElement(el).click();
        builder.moveToElement(el2).clickAndHold();
        builder.dragAndDrop(el2,el3);
        builder.release();
       // builder.build().perform();
//Thread.sleep(1000);
        builder.moveToElement(el4).click();
        builder.moveToElement(el5).clickAndHold();
        builder.dragAndDrop(el5,el3);
        builder.release();
        builder.build().perform();
    }
}
