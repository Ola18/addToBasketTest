package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown-toggle")
    private List<WebElement> category;

    @FindBy(css = ".see-all")
    private List<WebElement> elements;

    @FindBy(xpath = "//button[contains(@onclick, '45')]")
    private List<WebElement> products;

    @FindBy(css = ".btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
    private WebElement cartButton;

    @FindBy(xpath = "//div/div/a[1]")
    List<WebElement> alert;

    @FindBy(css = ".text-left")
    private List<WebElement> productInCart;

    public MainPage mouseHoverCategory() {
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(category.get(4)).perform();
        return this;
    }

    public MainPage clickOnSubcategory() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elements.get(1)));
        elements.get(1).click();
        return this;
    }

    public MainPage addToCart() {
        products.get(0).click();
        return this;
    }

    public String getAlertText() {
        return alert.get(1).getText();
    }

    public String verifyCartContent() {
        cartButton.click();
        wait.until(ExpectedConditions.visibilityOf(productInCart.get(0)));
        return productInCart.get(0).getText();
    }
}
