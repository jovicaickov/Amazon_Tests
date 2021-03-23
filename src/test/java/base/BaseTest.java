package base;

import framework.Configuration;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    
    public BaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.init();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.get(Configuration.userUrl);
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    
}
