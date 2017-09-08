package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 08/09/2017.
 */
public class ProjectHome {
    WebDriver driver;

    @FindBy (xpath = "//*[@id=\"js-header-nav\"]/a")
    WebElement logo;

    @FindBy (xpath = "/html/body/a/img")
    WebElement sell;

    @FindBy (xpath = "/html/body/section/section[1]/div/h1")
    WebElement atSell;
    @FindBy (xpath = "//*[@id=\"postcode\"]")
    WebElement postcode;
    @FindBy (xpath = "//*[@id=\"radius\"]")
    WebElement distance;

    @FindBy (xpath = "//*[@id=\"searchVehiclesMake\"]")
    WebElement make;
    @FindBy (xpath = "//*[@id=\"search\"]/span")
    WebElement search;

    @FindBy (xpath = "/html/body/main/section[1]/div[1]/form/div/div/h1")
    WebElement found;
    @FindBy (xpath = "//*[@id=\"js-editorial-content\"]/section[2]/a[3]/span")
    WebElement dealer;
    @FindBy (xpath = "//*[@id=\"postcode\"]")
    WebElement dealerpost;
    @FindBy (xpath = "/html/body/section[1]/div/form/div[1]/div[3]/div/select")
    WebElement dealermake;
    @FindBy (xpath = "//*[@id=\"submit\"]")
    WebElement dealersearch;
    @FindBy (xpath = "/html/body/section[1]/section[1]/header/span")
    WebElement dealerfound;
//    @FindBy (xpath = "//*[@id=\"searchVehiclesMake\"]")
//    WebElement make;


    public ProjectHome(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSell() {
        return sell;
    }

    public WebElement getAtSell() {
        return atSell;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getDistance() {
        return distance;
    }

    public WebElement getMake() {
        return make;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getFound() {
        return found;
    }

    public WebElement getDealer() {
        return dealer;
    }

    public WebElement getDealerpost() {
        return dealerpost;
    }

    public WebElement getDealermake() {
        return dealermake;
    }

    public WebElement getDealersearch() {
        return dealersearch;
    }

    public WebElement getDealerfound() {
        return dealerfound;
    }
}
