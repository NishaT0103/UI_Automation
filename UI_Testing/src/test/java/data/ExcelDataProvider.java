package data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    private static final String EXCEL_PATH = "src/test/resources/TestData.xlsx"; // Static path

    @DataProvider(name = "testData")
    public static Iterator<Object[]> testData() {
        List<Object[]> testData = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(EXCEL_PATH)) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String searchQuery = row.getCell(0).getStringCellValue();
                String title = row.getCell(1).getStringCellValue();
                testData.add(new Object[]{searchQuery, title});
               // testData.add(new Object[]{searchQuery});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData.iterator();
    }
    
    @DataProvider(name= "testData2")
    public static Iterator<Object[]> testData2() {
        List<Object[]> testData = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(EXCEL_PATH)) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(1);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                String searchQuery = row.getCell(0).getStringCellValue();
                //String product = row.getCell(1).getStringCellValue();
               // testData.add(new Object[]{searchQuery, product});
               testData.add(new Object[]{searchQuery});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData.iterator();
    }
//    @DataProvider(name= "testdatatitle")
//    public static Iterator<Object[]> testdatatitle() {
//        List<Object[]> testData = new ArrayList<>();
//        try (FileInputStream file = new FileInputStream(EXCEL_PATH)) {
//            Workbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheetAt(1);
//            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//                Row row = sheet.getRow(rowIndex);
//                String searchQuery = row.getCell(1).getStringCellValue();
//                //String product = row.getCell(1).getStringCellValue();
//               // testData.add(new Object[]{searchQuery, product});
//               testData.add(new Object[]{searchQuery});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return testData.iterator();
//    
//}
}
