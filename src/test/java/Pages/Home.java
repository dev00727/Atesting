package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;



    @FindBy(xpath="//*[@id=\"draggableview\"]")
    WebElement el;

    @FindBy(xpath="//*[@id=\"droppableview\"]")
    WebElement el2;

    @FindBy(xpath="//*[@id=\"resizable\"]/div[3]")
    WebElement el3;

    @FindBy(xpath="//*[@id=\"menu-item-143\"]/a")
    WebElement er;

    @FindBy(xpath = "//*[@id=\"menu-item-142\"]/a")
    WebElement selectable;

    @FindBy(xpath = "//*[@id=\"selectable\"]/li[7]")
    WebElement item7;



    @FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
    WebElement item1;


    @FindBy(xpath = "//*[@id=\"menu-item-151\"]/a")
    WebElement sortable;

    @FindBy(xpath = "//*[@id=\"sortable\"]/li[7]")
    WebElement seven;

    @FindBy(xpath = "//*[@id=\"sortable\"]/li[1]")
    WebElement one;

    @FindBy(xpath = "//*[@id=\"menu-item-144\"]/a")
    WebElement accordion;

    @FindBy(xpath = "//*[@id=\"ui-id-6\"]")
    WebElement list2;

    @FindBy(xpath = "//*[@id=\"ui-id-10\"]")
    WebElement list4;

    @FindBy(xpath = "//*[@id=\"menu-item-144\"]/a")
    WebElement autocomplete;

    @FindBy(xpath = "//*[@id=\"menu-item-146\"]/a")
    WebElement datapicker;



    public Home(WebDriver driver) {
        this.driver = driver;

        // initalising all the elements with @Findby
        PageFactory.initElements(driver, this);
    }

    public WebElement getEl() {
        return el;
    }

    public WebElement getEl2() {
        return el2;
    }
    public WebElement getEl3() {
        return el3;
    }
    public WebElement getEr() {

        return er;
    }

    public WebElement getSelectable() {
        return selectable;
    }

    public WebElement getSortable() {
        return sortable;
    }

    public WebElement getAccordion() {
        return accordion;
    }

    public WebElement getAutocomplete() {
        return autocomplete;
    }

    public WebElement getDatapicker() {
        return datapicker;
    }
    public WebElement getItem7() {
        return item7;
    }

    public WebElement getItem1() {
        return item1;
    }

    public WebElement getSeven() {
        return seven;
    }

    public WebElement getList2() {
        return list2;
    }

    public WebElement getList4() {
        return list4;
    }

    public WebElement getOne() {

        return one;
    }
}