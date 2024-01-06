package Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {
    public static void writeValuesToExcel(List<String> values, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            // Create a new sheet
            // Get the existing sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            // If the sheet doesn't exist, create a new one
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            // Find the last row index
            int lastRow = sheet.getLastRowNum();

            // Create a new row
            Row newRow = sheet.createRow(lastRow + 1);

            // Create a cell and set the value for each column
            for (int i = 0; i < values.size(); i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(values.get(i));
            }

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}