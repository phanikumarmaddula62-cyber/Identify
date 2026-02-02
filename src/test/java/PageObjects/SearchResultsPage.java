package PageObjects;

import Base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends BaseClass {
  public SearchResultsPage(WebDriver driver){
      super(driver);

      PageFactory.initElements(driver, this);
  }
  @FindBy(xpath="//div[text()='Level']")
  WebElement level;
  @FindBy(xpath="//span[text()='Beginner']")
  WebElement beginner;
  @FindBy(xpath="//button[@class='cds-149 cds-button-disableElevation cds-button-primary css-1fsvlah']")
  WebElement view1;
  @FindBy(xpath="//div[text()='Language']")
  WebElement language;
  @FindBy(xpath="//span[text()='English']")
  WebElement english;
  @FindBy(xpath="//span[@class='cds-button-label' and text()='View']")
  WebElement view2;
  @FindBy(xpath="//h3[@class='cds-CommonCard-title css-6ecy9b']")
  List<WebElement> title;
  @FindBy(xpath="//span[@class='css-4s48ix']")
  List<WebElement> rating;
  @FindBy(xpath="//p[@class='css-vac8rf']/parent::div[@class='cds-CommonCard-metadata']")
  List<WebElement> duration;


  public boolean levelSelect(){

      wait.until(ExpectedConditions.visibilityOf(level)).click();
      wait.until(ExpectedConditions.visibilityOf(beginner)).click();
      boolean status=view1.isDisplayed();
      wait.until(ExpectedConditions.visibilityOf(view1)).click();
      return status;

  }
  public boolean languageSelect(){

      wait.until(ExpectedConditions.visibilityOf(language)).click();
      wait.until(ExpectedConditions.visibilityOf(english)).click();
      boolean status=view2.isDisplayed();
      wait.until(ExpectedConditions.visibilityOf(view2)).click();
      return status;

  }
public void courseData(){

    List<WebElement> titlelist=wait.until(ExpectedConditions.visibilityOfAllElements(title));
    System.out.println("Title : "+titlelist.get(0).getText());
    List<WebElement>ratinglist= wait.until(ExpectedConditions.visibilityOfAllElements(rating));
    System.out.println("Rating : "+ratinglist.get(0).getText());
    List<WebElement>durationlist=wait.until(ExpectedConditions.visibilityOfAllElements(duration));
    System.out.println("Duration : "+durationlist.get(0).getText().replaceAll(".*?(\\d.*)", "$1"));
    System.out.println("............................................................");
    System.out.println("Title : "+titlelist.get(1).getText());
    System.out.println("Rating : "+ratinglist.get(1).getText());
    System.out.println("Duration : "+durationlist.get(1).getText().replaceAll(".*?(\\d.*)", "$1"));

 }
}
