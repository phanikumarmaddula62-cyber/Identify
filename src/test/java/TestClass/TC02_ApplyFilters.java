package TestClass;

import Base.BaseTest;
import PageObjects.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_ApplyFilters extends BaseTest {
    SearchResultsPage sp;

    @BeforeClass
    public void initPage() {
        sp = new SearchResultsPage(driver);
    }

    @Test(priority = 2)
    public void levelfilter() {
        logger.info("Selecting level as 'Beginner'");
        boolean status=sp.levelSelect();
        logger.info("Selected level as 'Beginner' and closed the level Dropdown");
        Assert.assertTrue(status);
    }

    @Test(priority = 3)
    public void languagefilter() {
        logger.info("Selecting language as 'English'");
        boolean status=sp.languageSelect();
       logger.info("Selected language as 'English' and closed the language Dropdown");
       Assert.assertTrue(status);
    }

    @Test(priority = 4)
    public void Data() {
        logger.info("Printing the Title,Rating,Duration of first 2 courses");
        sp.courseData();
    }
}
