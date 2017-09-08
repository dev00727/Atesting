package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;

/**
 * Created by Administrator on 07/09/2017.
 */
public class AdvancedHome {
    WebDriver driver;
    @FindBy (xpath = "//*[@id=\"search_query_top\"]")
    WebElement search;

    @FindBy (xpath = "//*[@id=\"center_column\"]/div[1]/div[2]/div[2]")
    WebElement found;
    @FindBy (xpath = "//*[@id=\"searchbox\"]/button")
    WebElement go;


    public AdvancedHome(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getFound() {
        return found;
    }

    public WebElement getGo() {
        return go;
    }
}
