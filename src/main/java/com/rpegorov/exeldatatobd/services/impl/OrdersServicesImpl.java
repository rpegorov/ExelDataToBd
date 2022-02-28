package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.repositories.OrdersRepository;
import com.rpegorov.exeldatatobd.services.interf.PostService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServicesImpl implements PostService<Orders> {
    private OrdersRepository ordersRepository;

    @Override
    public void createEntity(Orders orders) {
        var entity = Orders
                .builder()
                .id(orders.getId())
                .company(orders.getCompany())
                .products(orders.getProducts())
                .build();
        ordersRepository.save(entity);
    }
}

