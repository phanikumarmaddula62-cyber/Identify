package Utilities;

import PageObjects.CourseTypes;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtility {
    protected  int rowNum = 0;
    protected Sheet sheet;
    protected FileOutputStream fileOut;
    protected XSSFWorkbook workbook;
    protected CourseTypes type;

    public void excel() throws FileNotFoundException {
        fileOut = new FileOutputStream("CourseDetails.xlsx");
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Dataaaaaaa");
    }

    public void adddata(List<WebElement> li,List<WebElement>cnt)  {

        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Names");
        headerRow.createCell(1).setCellValue("Count");
        for (int i = 0; i < li.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(li.get(i).getText().replaceAll("\\(.*", ""));
            row.createCell(1).setCellValue(cnt.get(i).getText());
        }
        rowNum++;
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

    }
    public void close() throws IOException {
        workbook.write(fileOut);
        workbook.close();
    }
}
