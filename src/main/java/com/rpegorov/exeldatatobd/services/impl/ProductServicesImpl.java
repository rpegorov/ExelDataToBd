package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.repositories.ProductRepo;
import com.rpegorov.exeldatatobd.services.interf.PostService;

public class ProductServicesImpl implements PostService<Product> {
    private ProductRepo productRepo;

    @Override
    public void createEntity(Product product) {
        var entity = Product.builder()
                .company_id(product.getCompany_id())
                .date(product.getDate())
                .productType(product.getProductType())
                .dataType(product.getDataType())
                .build();
        productRepo.save(entity);
    }
}
