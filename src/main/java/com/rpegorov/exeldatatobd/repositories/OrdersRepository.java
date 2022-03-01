package com.rpegorov.exeldatatobd.repositories;

import com.rpegorov.exeldatatobd.models.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
