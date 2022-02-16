package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.repositories.ProductRepo;
import com.rpegorov.exeldatatobd.services.interf.IExcelDataService;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
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

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // Create the Workbook
        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Getting number of columns in the Sheet
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        // Using for-each loop to iterate over the rows and columns
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }

        // filling excel data and creating list as List<Product>
        List<Product> productsList = createList(list, noOfColumns);

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productsList;
    }

    private List<Product> createList(List<String> excelData, int noOfColumns) {

        ArrayList<Product> productArrayList = new ArrayList<>();

        int i = noOfColumns;
        do {
            Product prd = new Product();

            prd.setDataType(DataType.valueOf(excelData.get(i)));
            prd.setProductType(ProductType.valueOf(excelData.get(i + 1)));
            prd.setDate(Long.valueOf(excelData.get(i + 2)));
//            prd.set(excelData.get(i + 3));

            productArrayList.add(prd);
            i = i + (noOfColumns);

        } while (i < excelData.size());
        return productArrayList;
    }

    @Override
    public int saveExcelData(List<Product> products) {
        products = (List<Product>) repo.saveAll(products);
        return products.size();
    }
    }
