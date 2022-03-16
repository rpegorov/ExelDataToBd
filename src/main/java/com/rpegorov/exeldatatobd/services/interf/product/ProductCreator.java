package com.rpegorov.exeldatatobd.services.interf.product;

import com.rpegorov.exeldatatobd.models.dto.DataColum;
import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.time.LocalDate;

/**
 * Interface create Product
 * Strategy pattern
 */
public interface ProductCreator {

    boolean canProcess(int amount);

    /**
     *
     * @param k index data in List<String> excelData
     * @see com.rpegorov.exeldatatobd.services.CreateArrList
     * @param amount data
     * @param date1 Local date (random date)
     * @param date2 Local date (random date)
     * @param order Setting relationships between tables, setting a pointer to Orders in Product
     * @see Orders
     * @return a new Product
     */
    Product createProduct(int k, int amount, LocalDate date1, LocalDate date2, Orders order);

    default Product createProductObject(ProductType type, DataColum dataColum, DataType dataType, Integer amount, LocalDate date, Orders orders) {
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
