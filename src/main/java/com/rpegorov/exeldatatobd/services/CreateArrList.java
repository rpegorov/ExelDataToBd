package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Company;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreateArrList {

    public static List<Orders> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Orders> companyArrayList = new ArrayList<>();
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

    private static Product createProduct(ProductType type, OffsetDateTime data, DataType dataType, Integer amount) {
        Product product = new Product();
        product.setDate(data);
        product.setProductType(type);
        product.setDataType(dataType);
        product.setAmount(amount);
        return product;

    }
}