package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.services.interf.product.ProductCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for decoding received data from Excel and creating a List
 */
@Service
@RequiredArgsConstructor
public class CreateArrList {

    private final List<ProductCreator> productCreatorsList;

    /**
     * @param excelData   data obtained after reading excel workbook
     * @param noOfColumns column counter
     * skipHead - number of header lines to skip
     * @return ordersArrayList
     * @see com.rpegorov.exeldatatobd.services.impl.IExcelDataServiceOrdersImpl
     */
    public List<Orders> createList(List<String> excelData, int noOfColumns) {
        var ordersArrayList = new ArrayList<Orders>();
        var i = noOfColumns;
        var skipHead = 15;

        do {
            for (var k = skipHead; k < excelData.size() - 1; k += 10) {
                var order = new Orders();
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

    private void getProducts(List<String> excelData, int k, LocalDate date1, LocalDate date2, Orders order) {
        var products = order.getProducts();
        for (int i = 3; i <= 10; i++) {
            int finalI = i;
            productCreatorsList.stream()
                    .filter(e -> e.canProcess(finalI))
                    .findFirst()
                    .ifPresent(e -> products.add(
                            e.createProduct(
                                    Integer.parseInt(excelData.get(k + finalI)),
                                    finalI,
                                    date1,
                                    date2,
                                    order)));
        }
    }
}