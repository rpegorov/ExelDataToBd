package com.rpegorov.exeldatatobd.services.interf.product;

import com.rpegorov.exeldatatobd.models.dto.DataColum;
import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.time.LocalDate;

public interface ProductCreator {

    boolean canProcess(int amount);

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
