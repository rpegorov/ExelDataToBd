package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CreateArrList {

    public static List<Company> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Company> companyArrayList = new ArrayList<>();
        var i = noOfColumns;

        var date =
                LocalDate.parse(excelData.get(6), DateTimeFormatter.ofPattern("yyyyMMdd"));
        String dateFormat = "yyyy-MM-dd";
        date.atStartOfDay().format(DateTimeFormatter.ofPattern(dateFormat));

        do {
            Orders order = new Orders();
            order.setId(Long.valueOf(excelData.get(1)));
            order.setCompany(excelData.get(2));
            order.getProducts().add(createProduct(ProductType.QLIQ, OffsetDateTime.from(date), DataType.FACT, Integer.valueOf(excelData.get(2))));
            order.getProducts().add(createProduct(ProductType.QLIQ, OffsetDateTime.from(date), DataType.FACT, Integer.valueOf(excelData.get(3))));
            order.getProducts().add(createProduct(ProductType.QOIL, OffsetDateTime.from(date), DataType.FACT, Integer.valueOf(excelData.get(4))));
            order.getProducts().add(createProduct(ProductType.QOIL, OffsetDateTime.from(date), DataType.FACT, Integer.valueOf(excelData.get(5))));
            order.getProducts().add(createProduct(ProductType.QLIQ, OffsetDateTime.from(date), DataType.FORECAST, Integer.valueOf(excelData.get(6))));
            order.getProducts().add(createProduct(ProductType.QLIQ, OffsetDateTime.from(date), DataType.FORECAST, Integer.valueOf(excelData.get(7))));
            order.getProducts().add(createProduct(ProductType.QOIL, OffsetDateTime.from(date), DataType.FORECAST, Integer.valueOf(excelData.get(8))));
            order.getProducts().add(createProduct(ProductType.QOIL, OffsetDateTime.from(date), DataType.FORECAST, Integer.valueOf(excelData.get(9))));


                i = i + (noOfColumns);

            companyArrayList.add(order);
        } while (i < excelData.size());
        return companyArrayList;
    }
}