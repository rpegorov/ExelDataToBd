package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.repositories.ProductRepo;
import com.rpegorov.exeldatatobd.services.interf.ProductServices;

public class ProductServicesImpl implements ProductServices {
    private ProductRepo productRepo;

    @Override
    public void postProduct(Product product) {
        var entity = Product.builder()
                .company_id(product.getCompany_id())
                .date(product.getDate())
                .productType(product.getProductType())
                .dataType(product.getDataType())
                .build();
        productRepo.save(entity);
    }
}
