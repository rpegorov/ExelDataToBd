package com.rpegorov.exeldatatobd.services.impl.product;

import com.rpegorov.exeldatatobd.models.dto.DataColum;
import com.rpegorov.exeldatatobd.models.dto.DataType;
import com.rpegorov.exeldatatobd.models.dto.ProductType;
import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.services.interf.product.ProductCreator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Class a create all QLIQ Forecast Product implements ProductCreator
 * Strategy pattern
 */
@Service
public class ProductQOILForecastCreator implements ProductCreator {
    @Override
    public boolean canProcess(int amount) {
        return Stream.of(9, 10).anyMatch(e -> e == amount);
    }

    @Override
    public Product createProduct(int k, int amount, LocalDate date1, LocalDate date2, Orders order) {
        if (amount == 8) {
            return createQOILForecastProduct(k, date1, order, DataColum.DATA1);
        } else {
            return createQOILForecastProduct(k, date2, order, DataColum.DATA2);
        }
    }

    private Product createQOILForecastProduct(Integer amount, LocalDate date, Orders order, DataColum dataColum) {
        return createProductObject(ProductType.QOIL, dataColum, DataType.FORECAST, amount, date, order);
    }
}
