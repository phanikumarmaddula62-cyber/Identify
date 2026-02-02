package TestClass;

import Base.BaseTest;
import PageObjects.CourseTypes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC03_CourseData extends BaseTest {
    CourseTypes types;

    @BeforeClass
    public void inittt(){
        types=new CourseTypes(driver);
    }
    @Test(priority= 5)
    public void data() throws IOException {
        logger.info("Clearing the filters");
        types.clear_filters();
        logger.info("Fetching the 'Levels'");
        types.levels_list();
        logger.info("'Levels' Fetched Successfully");
      }

    @Test(priority= 6)
    public void data1() throws IOException {
        logger.info("Fetching the 'Languages'");
        types.languages_list();
        logger.info("'Languages' Fetched Successfully");
        types.closeBook();
        logger.info("Levels and Languages stored in Excel File Successfully");
    }

}
