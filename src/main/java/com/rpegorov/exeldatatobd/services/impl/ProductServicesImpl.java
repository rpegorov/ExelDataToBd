package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Product;
import com.rpegorov.exeldatatobd.repositories.ProductRepo;
import com.rpegorov.exeldatatobd.services.interf.PostService;
import org.springframework.stereotype.Service;

/**
 * Class create Entity Product
 */
@Service
public class ProductServicesImpl implements PostService<Product> {
    private ProductRepo productRepo;

    @Override
    public void createEntity(Product product) {
        var entity = Product.builder()
                .dataColum(product.getDataColum())
                .productType(product.getProductType())
                .dataType(product.getDataType())
                .build();
        productRepo.save(entity);
    }
}
