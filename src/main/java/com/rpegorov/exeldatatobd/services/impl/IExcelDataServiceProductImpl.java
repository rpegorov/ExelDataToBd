//package com.rpegorov.exeldatatobd.services.impl;
//
//import com.rpegorov.exeldatatobd.models.entity.Company;
//import com.rpegorov.exeldatatobd.models.entity.Product;
//import com.rpegorov.exeldatatobd.repositories.ProductRepo;
//import com.rpegorov.exeldatatobd.services.interf.IExcelDataServiceProduct;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class IExcelDataServiceProductImpl implements IExcelDataServiceProduct {
//
//    @Value("${app.upload.file:${user.home}}")
//    private String EXCEL_FILE_PATH;
//
//    ProductRepo repo;
//    Workbook workbook;
//
//    @Override
//    public List<Product> getExcelDataAsList() {
//
////        DataFormatter dataFormatter = new DataFormatter();
//        try {
//            workbook = new XSSFWorkbook(new File(EXCEL_FILE_PATH));
//        } catch (IOException | InvalidFormatException e) {
//            e.printStackTrace();
//        }
//        List<Product> productList = new ArrayList<>();
//        XSSFSheet worksheet = (XSSFSheet) workbook.getSheetAt(0);
//        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
//            if (index > 0) {
//                Product product = new Product();
//                XSSFRow row = worksheet.getRow(index);
//                Integer id = (int) row.getCell(0).getNumericCellValue();
//
////                product.setId(Long.valueOf(id.toString()));
////                product.setDataType(row.getCell(3).getDateCellValue(FACT);
////                product.setProductType(ProductType.valueOf(String.valueOf(row.getCell(2).getNumericCellValue())));
////                product.setDate(Long.valueOf(row.getCell(3).getStringCellValue()));
////
////                productList.add(product);
//
//
//            }
//        }
//        try {
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return productList;
//}
//
//    @Override
//    public int saveExcelData(List<Product> products) {
//        products = (List<Product>) repo.saveAll(products);
//        return products.size();
//    }
//}
