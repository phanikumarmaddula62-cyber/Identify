package PageObjects;

import Base.BaseClass;
import Utilities.ScreenShot_util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class FormFill extends BaseClass {

    protected ScreenShot_util ss;

    public FormFill(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[text()='For Enterprise']")
    WebElement enterprise;
    @FindBy(xpath="//a[@href='https://www.coursera.org/campus']")
    WebElement universities;
    @FindBy(xpath="//input[@id='FirstName']")
    WebElement firstName;
    @FindBy(xpath="//input[@id='LastName']")
    WebElement lastName ;
    @FindBy(xpath="//input[@id='Email']")
    WebElement email;
    @FindBy(xpath="//input[@id='Phone']")
    WebElement phone;
    @FindBy(xpath="//input[@id='Company']")
    WebElement cmpny;
    @FindBy(xpath="//select[@id='Institution_Type__c']")
    WebElement d1;
    @FindBy(xpath="//select[@id='Title']")
    WebElement d2;
    @FindBy(xpath="//select[@id='Department']")
    WebElement d3;
    @FindBy(xpath="//select[@id='Self_Reported_Needs__c']")
    WebElement d4;
    @FindBy(xpath="//select[@id='Country']")
    WebElement d5;
    @FindBy(xpath="//select[@id='State']")
    WebElement d6;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath="//div[@id='ValidMsgEmail']")
    WebElement errmsg;

    public boolean form(){
        action.keyDown(Keys.END).keyUp(Keys.END).build().perform();
        wait.until(ExpectedConditions.visibilityOf(enterprise)).click();
        wait.until(ExpectedConditions.visibilityOf(universities)).click();
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("John");
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Smith");
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys("johnsmithgmail.com");
        wait.until(ExpectedConditions.visibilityOf(phone)).sendKeys("1234567890");
        new Select(d1).selectByValue("University/4 Year College");
        wait.until(ExpectedConditions.visibilityOf(cmpny)).sendKeys("JNTU");
        new Select(d2).selectByValue("Professor");
        new Select(d3).selectByValue("Student Affairs");
        new Select(d4).selectByValue("Courses for myself");
        new Select(d5).selectByValue("India");
        new Select(d6).selectByValue("Andhra Pradesh");
        boolean status=submit.isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(submit)).click();
        return status;
    }

    public void err() throws IOException {
        String msg=wait.until(ExpectedConditions.visibilityOf(errmsg)).getText();
        System.out.println(msg);
        ss=new ScreenShot_util(driver);
        ss.screenshot();
    }
}
