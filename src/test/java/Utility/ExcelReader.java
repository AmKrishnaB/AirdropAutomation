package Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {
    public static List<String> readListFromExcel(String filePath, String sheetName) {
        List<String> values = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the specified sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            // Check if the sheet exists
            if (sheet != null) {
                // Iterate through each row
                for (Row row : sheet) {
                    // Assuming there is only one column in each row
                    Cell cell = row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                    // Check if the cell is not null
                    if (cell != null) {
                        // Add the cell value to the list
                        values.add(cell.toString());
                    }
                }
            } else {
                System.out.println("Sheet not found: " + sheetName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }

    public static String readOneCellPhrase(String filePath, String sheetName, int rowNumber) {
        Sheet sheet;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sheet.getRow(rowNumber).getCell(0).getStringCellValue();
    }

    public static List<String> undonePhrase(String filePath, String sheetName) {
        List<String> values = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Get the specified sheet by name
            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row currentRow= sheet.getRow(i);
                Cell statusCell= currentRow.getCell(13);
                String status = statusCell.getStringCellValue();
                if (status!="Done"){
                    for (int j = 0; j < 12; j++) {
                        Cell phraseCell= row.getCell(j);
                        values.add(phraseCell.getStringCellValue());
                    }
                    }
                }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return values;
    }


}