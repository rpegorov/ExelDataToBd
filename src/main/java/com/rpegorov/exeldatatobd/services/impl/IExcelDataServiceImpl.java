package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.repositories.ProductRepo;
import com.rpegorov.exeldatatobd.services.CreateArrList;
import com.rpegorov.exeldatatobd.services.interf.IExcelDataService;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IExcelDataServiceImpl implements IExcelDataService {

    @Value("${app.upload.file:${user.home}}")
    private String EXCEL_FILE_PATH;

    ProductRepo repo;
    Workbook workbook;

    @Override
    public List<Product> getExcelDataAsList() {

        List<String> list = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();
        try {
            workbook = new XSSFWorkbook(new File(EXCEL_FILE_PATH));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }
        List<Product> productsList = CreateArrList.createList(list, noOfColumns);
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    @Override
    public int saveExcelData(List<Product> products) {
        products = (List<Product>) repo.saveAll(products);
        return products.size();
    }
}
