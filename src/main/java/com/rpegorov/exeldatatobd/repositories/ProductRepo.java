package com.rpegorov.exeldatatobd.repositories;

import com.rpegorov.exeldatatobd.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
