package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.*;

public class CreateArrList {

    public static List<Orders> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Orders> companyArrayList = new ArrayList<>();
        var i = noOfColumns;

        var factQliqDate1 = LocalDate.parse(excelData.get(8),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow")));
        var factQliqDate2 = createDate(LocalDate.parse(excelData.get(9),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));

        var factQoilDate1 = createDate(LocalDate.parse(excelData.get(10),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));
        var factQoilDate2 = createDate(LocalDate.parse(excelData.get(11),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));

        var forecastQliqDate1 = createDate(LocalDate.parse(excelData.get(12),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));
        var forecastQliqDate2 = createDate(LocalDate.parse(excelData.get(13),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));

        var forecastQoilDate1 = createDate(LocalDate.parse(excelData.get(14),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));
        var forecastQoilDate2 = createDate(LocalDate.parse(excelData.get(15),
                ofPattern("d/M/yyyy").withZone(ZoneId.of("Europe/Moscow"))));

        do {
            var k = 0;
            for (k = 15; k < excelData.size() - 1; k += 10) {
                Orders order = new Orders();
                order.setId(Long.valueOf(excelData.get(k + 1)));
                order.setCompany(excelData.get(k + 2));
                order.getProducts().add(createProduct(ProductType.QLIQ, factQliqDate1, DataType.FACT, Integer.valueOf(excelData.get(k + 3)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, factQliqDate2, DataType.FACT, Integer.valueOf(excelData.get(k + 4)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, factQoilDate1, DataType.FACT, Integer.valueOf(excelData.get(k + 5)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, factQoilDate2, DataType.FACT, Integer.valueOf(excelData.get(k + 6)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, forecastQliqDate1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 7)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, forecastQliqDate2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 8)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, forecastQoilDate1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 9)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, forecastQoilDate2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 10)), order));

                i = i + (noOfColumns);

                companyArrayList.add(order);
            }
        } while (i < excelData.size());
        return companyArrayList;
    }

    private static Product createProduct(ProductType type, LocalDate date, DataType dataType, Integer amount, Orders orders) {
        Product product = new Product();
        product.setDate(date);
        product.setProductType(type);
        product.setDataType(dataType);
        product.setAmount(amount);
        product.setOrders(orders);
        return product;

    }

    private static LocalDate createDate(LocalDate date) {
        String dateFormat = "dd-MM-yyyy";
        date.atStartOfDay().format(ofPattern(dateFormat));
        return date;
    }
}