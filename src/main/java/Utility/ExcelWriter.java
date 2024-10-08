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
import static AirdropAutomation.Metamask.AccountCreator.log;

public class ExcelWriter {
    public static void writeListToExcel(List<String> values, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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

    public static void writeListAndStringToExcel(List<String> phrase,String address, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            for (int i = 0; i < phrase.size(); i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(phrase.get(i));
            }

            Cell cell = newRow.createCell(phrase.size());
            cell.setCellValue(address);


            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePhraseAddressKeyToExcel(List<String> phrase, String address, String key , String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            for (int i = 0; i < phrase.size(); i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(phrase.get(i));
            }

            Cell cell = newRow.createCell(phrase.size());
            cell.setCellValue(address);

            Cell cell1 = newRow.createCell(phrase.size()+1);
            cell1.setCellValue(key);

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void writeTwoStringArraysToExcel(String[] phrase,String[] credentials , String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            for (int i = 0; i < phrase.length; i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(phrase[i]);
            }

            for (int i = phrase.length; i < phrase.length+credentials.length; i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(credentials[i-phrase.length]);
            }

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAddressAndTokenToExcel(String address,String token, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            Cell cell = newRow.createCell(0);
            cell.setCellValue(address);

            Cell cell2 = newRow.createCell(1);
            cell2.setCellValue(token);

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePhraseArrayToExcel(String[] phrase, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            for (int i = 0; i < phrase.length; i++) {
                Cell cell = newRow.createCell(i);
                cell.setCellValue(phrase[i]);
            }

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringsToExcel(String[] wallet, String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            // Get the existing sheet by name
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();
            // Create a new row
            Row newRow = sheet.createRow(lastRow + 1);
            newRow.createCell(0).setCellValue(wallet[0]);
            newRow.createCell(1).setCellValue(wallet[1]);
            newRow.createCell(2).setCellValue(wallet[2]);
            newRow.createCell(3).setCellValue(wallet[3]);
            workbook.write(fos);
        }
    }

    public static void writeDoneToExcel(String filePath, String sheetName, int rowNumber, int columnNumber) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            // Get the existing sheet by name
            Sheet sheet = workbook.getSheet(sheetName);
            Row currentRow= sheet.getRow(rowNumber);
            Cell currentCell= currentRow.createCell(columnNumber);
            currentCell.setCellValue("Done");
            workbook.write(fos);
        }
    }

    public static void writeFourStringsToExcel(String address, String token, String phrase, String privateKey, String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(filePath)) {
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
            Cell cell = newRow.createCell(0);
            cell.setCellValue(address);

            Cell cell2 = newRow.createCell(1);
            cell2.setCellValue(token);

            Cell cell3 = newRow.createCell(2);
            cell3.setCellValue(phrase);

            Cell cell4 = newRow.createCell(3);
            cell4.setCellValue(privateKey);

            // Write the updated workbook to a file
            workbook.write(fos);
            System.out.println("Values appended to existing sheet in Excel file successfully.");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}