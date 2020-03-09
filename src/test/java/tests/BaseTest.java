package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
    }


    @AfterClass
    public static void closeApp(){
        driver.quit();
    }
}
