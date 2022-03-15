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
     * @param excelData data obtained after reading excel workbook
     * @see com.rpegorov.exeldatatobd.services.impl.IExcelDataServiceOrdersImpl
     * @param noOfColumns column counter
     * skipHead - number of header lines to skip
     * @return ordersArrayList
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
                order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA1, DataType.FACT, Integer.valueOf(excelData.get(k + 3)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA2, DataType.FACT, Integer.valueOf(excelData.get(k + 4)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA1, DataType.FACT, Integer.valueOf(excelData.get(k + 5)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA2, DataType.FACT, Integer.valueOf(excelData.get(k + 6)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 7)), order));
                order.getProducts().add(createProduct(ProductType.QLIQ, DataColum.DATA2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 8)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA1, DataType.FORECAST, Integer.valueOf(excelData.get(k + 9)), order));
                order.getProducts().add(createProduct(ProductType.QOIL, DataColum.DATA2, DataType.FORECAST, Integer.valueOf(excelData.get(k + 10)), order));

                i = i + (noOfColumns);
                ordersArrayList.add(order);
            }
        } while (i < excelData.size());
        return ordersArrayList;
    }

    private static Product createProduct(ProductType type, DataColum dataColum, DataType dataType, Integer amount, Orders orders) {
        Product product = new Product();
        product.setDataColum(dataColum);
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