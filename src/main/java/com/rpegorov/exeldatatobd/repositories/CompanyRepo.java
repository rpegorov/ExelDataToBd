package com.rpegorov.exeldatatobd.repositories;

import com.rpegorov.exeldatatobd.models.entity.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company, Long> {
}
