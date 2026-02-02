package PageObjects;

import Base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Search extends BaseClass {
    public Search(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='search-autocomplete-input']")
    WebElement Searchbar;

    public String searchCourse(String coursename){
        wait.until(ExpectedConditions.visibilityOf(Searchbar)).sendKeys(coursename);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        return driver.getCurrentUrl();
    }

}
