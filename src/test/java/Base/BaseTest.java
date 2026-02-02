package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {


    public static WebDriver driver;

    protected final Logger logger= LogManager.getLogger(getClass());

    @BeforeSuite(alwaysRun = true)
    public void BeforeTest(){
        driver=new ChromeDriver();
        driver.get("https://www.coursera.org");
        driver.manage().window().maximize();
    }
    @AfterSuite(alwaysRun = true)
    public void teardown(){
        if(driver != null) {
            driver.quit();
        }
    }


}
