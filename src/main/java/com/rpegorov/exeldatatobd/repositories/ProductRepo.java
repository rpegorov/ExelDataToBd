package com.rpegorov.exeldatatobd.repositories;

import com.rpegorov.exeldatatobd.models.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("select sum(p.amount), p.local_date) * FROM product p WHERE p.local_date = '2022-06-15'")
    void setSumAmountToDate06_15(@Param("sumAmountToDate06_15") String sumAmount, @Param("id") int id);

    Product findAvgDate(String sumAmount);

    -- products by date
    select p.amount, p.local_date
    from product p
    where p.local_date = '2022-06-15'
}
