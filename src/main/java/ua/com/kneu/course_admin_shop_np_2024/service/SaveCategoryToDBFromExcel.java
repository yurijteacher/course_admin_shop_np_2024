package ua.com.kneu.course_admin_shop_np_2024.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SaveCategoryToDBFromExcel {


    public List<Category> saveListCategoryToDbFromExcel(String path) {

        List<Category> categories = new ArrayList<>();

        InputStream is = null;
        Workbook wb = null;

        try {
            is = new FileInputStream(path);
            try {
                wb = new HSSFWorkbook(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        Sheet sheet = wb.getSheetAt(0);

        Iterator<Row> ri = sheet.iterator();
        while (ri.hasNext()){
            Row row = ri.next();
            String name = row.getCell(0).getStringCellValue();
            String decription = row.getCell(1).getStringCellValue();
            String image = row.getCell(2).getStringCellValue();

            categories.add(new Category(name, decription, image));
        }

        return categories;
    }


    public List<Category> saveListCategoryToDbFromExcel2(String path) {
        List<Category> categories = new ArrayList<>();

        InputStream is = null;
        XSSFWorkbook wb = null;

        try {
            is = new FileInputStream(path);
            try {
                wb = new XSSFWorkbook(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator ri = sheet.rowIterator();

        while (ri.hasNext()){
            XSSFRow row = (XSSFRow) ri.next();

            String name = row.getCell(0).getStringCellValue();
            String description = row.getCell(1).getStringCellValue();
            String image = row.getCell(2).getStringCellValue();
           // BigDecimal price = new BigDecimal(row.getCell(3).getNumericCellValue());

            categories.add(new Category(name, description, image));
        }


        return categories;
    }

}
