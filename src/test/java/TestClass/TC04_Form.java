package TestClass;

import Base.BaseTest;
import PageObjects.FormFill;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC04_Form extends BaseTest {
    FormFill f;

    @BeforeClass
    public void init(){
        f=new FormFill(driver);
    }

    @Test(priority = 7)
    public void fill() throws IOException {
        logger.info("Filling the Form with Details");
        boolean status= f.form();
        logger.info("Form Submitted successfully");
        logger.info("Fetching the Error Message");
        f.err();
        logger.info("Error Message Fetched Successfully");
        Assert.assertTrue(status);
    }
}
