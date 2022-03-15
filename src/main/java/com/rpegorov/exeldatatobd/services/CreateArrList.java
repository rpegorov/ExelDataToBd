package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.dto.DataColum;
import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.*;

/**
 * Class for decoding received data from Excel and creating a List
 */
public class CreateArrList {

    /**
     * @param excelData   data obtained after reading excel workbook
     * @param noOfColumns column counter
     *                    skipHead - number of header lines to skip
     * @return ordersArrayList
     * @see com.rpegorov.exeldatatobd.services.impl.IExcelDataServiceOrdersImpl
     */
    public static List<Orders> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Orders> ordersArrayList = new ArrayList<>();
        var i = noOfColumns;
        var skipHead = 15;

        do {
            var k = 0;
            for (k = skipHead; k < excelData.size() - 1; k += 10) {
                Orders order = new Orders();
                order.setId(Long.valueOf(excelData.get(k + 1)));
                order.setCompany(excelData.get(k + 2));
                var date1 = LocalDate.of(2022, 6, 15);
                var date2 = LocalDate.of(2022, 6, 20);
                getProducts(excelData, k, date1, date2, order);

                i = i + (noOfColumns);
                ordersArrayList.add(order);
            }
        } while (i < excelData.size());
        return ordersArrayList;
    }

    private static void getProducts(List<String> excelData, int k, LocalDate date1, LocalDate date2, Orders order) {
        order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA1, DataType.FACT, Integer.valueOf(excelData.get(k + 3)), date1, order));
        order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA2, DataType.FACT, Integer.valueOf(excelData.get(k + 4)), date2, order));
        order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA1, DataType.FACT, Integer.valueOf(excelData.get(k + 5)), date1, order));
        order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA2, DataType.FACT, Integer.valueOf(excelData.get(k + 6)), date2, order));
        order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 7)), date1, order));
        order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 8)), date2, order));
        order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 9)), date1, order));
        order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 10)), date2, order));
    }

    private static Product createProduct(ProductType type, DataColum dataColum, DataType dataType, Integer amount, LocalDate date, Orders orders) {
        Product product = new Product();
        product.setDataColum(dataColum);
        product.setProductType(type);
        product.setDataType(dataType);
        product.setAmount(amount);
        product.setLocalDate(date);
        product.setOrders(orders);
        return product;
    }
}