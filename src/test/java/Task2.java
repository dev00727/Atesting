/**
 * Created by Administrator on 04/09/2017.
 */
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    WebDriver wd;

    @Before
    public void setUp(){
        wd= new ChromeDriver();

    }
    @After
    public void tearDown(){
        wd.quit();
    }

    @Test
    public void myTest(){
        wd.navigate().to("http://www.qa.com");
        Assert.assertEquals("IT Training | Project Management Training | Business Skills Training | QA", wd.getTitle());

    }
}
