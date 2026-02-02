package PageObjects;

import Base.BaseClass;
import Utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.List;

public class CourseTypes extends BaseClass {
    protected ExcelUtility ei;

    public CourseTypes(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Clear all']")
    WebElement clearall;
    @FindBy(xpath="//div[text()='Level']")
    WebElement level;
    @FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']")
    List<WebElement> t_levels;
    @FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']//span[@class='css-s63saa']")
    List<WebElement> c_level;
    @FindBy(xpath="//button[@class='cds-149 cds-button-disableElevation cds-button-primary css-1fsvlah']")
    WebElement view1;
    @FindBy(xpath="//div[text()='Language']")
    WebElement language;
    @FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']/span")
    List<WebElement> t_languages;
    @FindBy(xpath="//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']//span[@class='css-s63saa']")
    List<WebElement> c_language;
    @FindBy(xpath="//span[@class='cds-button-label' and text()='View']")
    WebElement view2;

    public void clear_filters(){
        wait.until(ExpectedConditions.visibilityOf(clearall)).click();
    }

    public void levels_list() throws IOException {
        ei=new ExcelUtility();
        ei.excel();

        wait.until(ExpectedConditions.visibilityOf(level)).click();

        List<WebElement> total_levels = wait.until(ExpectedConditions.visibilityOfAllElements(t_levels));
        List<WebElement> level_count = wait.until(ExpectedConditions.visibilityOfAllElements(c_level));

        ei.adddata(total_levels,level_count);

        wait.until(ExpectedConditions.visibilityOf(view1)).click();

    }

    public void languages_list() throws IOException {

        wait.until(ExpectedConditions.visibilityOf(language)).click();

        List<WebElement> total_languages = wait.until(ExpectedConditions.visibilityOfAllElements(t_languages));
        List<WebElement> language_count = wait.until(ExpectedConditions.visibilityOfAllElements(c_language));
        ei.adddata(total_languages,language_count);

        wait.until(ExpectedConditions.visibilityOf(view2)).click();

    }
    public void closeBook() throws IOException {
        ei.close();
    }

}
