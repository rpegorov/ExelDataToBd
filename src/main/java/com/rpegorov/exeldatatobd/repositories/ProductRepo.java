package com.rpegorov.exeldatatobd.repositories;

import com.rpegorov.exeldatatobd.models.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("select sum(p.amount) from Product p where p.localDate =:date")
    Long sumAmount(@Param("date") LocalDate dateForSearch);
}
