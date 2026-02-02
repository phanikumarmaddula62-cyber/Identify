package TestClass;

import Base.BaseTest;
import PageObjects.Search;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_Search extends BaseTest {
    Search hm;
    @BeforeClass
    public void init(){
        hm=new Search(driver);
    }

    @Test(priority = 1)
    public void search(){
        logger.info("Searching for Web Development Courses");
        String url = hm.searchCourse("Web Development");
        logger.info("Results shown for Web Development Courses");
        Assert.assertEquals( url,"https://www.coursera.org/search?query=Web%20Development");
    }
}
