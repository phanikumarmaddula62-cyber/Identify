package Utilities;

import Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot_util extends BaseClass {
    public ScreenShot_util(WebDriver driver) {
        super(driver);
    }

    public void screenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tempimg = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        File img = new File(System.getProperty("user.dir") + "\\screenshot\\"+ timestamp + ".png");
        FileUtils.copyFile(tempimg, img);
    }

}
