package com.rpegorov.exeldatatobd.services.interf;

import com.rpegorov.exeldatatobd.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Product, Long> {
}
