package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 05/09/2017.
 */
public class AddUser {

    WebDriver driver;

    @FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
    WebElement title;

    @FindBy(className = "nav-menu__item__link")
    WebElement solutionsLink;

    public AddUser(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public void clickSolutionsLink() {
        driver.get(solutionsLink.getAttribute("href"));
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
