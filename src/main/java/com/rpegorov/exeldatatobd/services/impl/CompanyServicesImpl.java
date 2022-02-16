package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Company;
import com.rpegorov.exeldatatobd.repositories.CompanyRepo;
import com.rpegorov.exeldatatobd.services.interf.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServicesImpl implements PostService<Company> {
    private CompanyRepo companyRepo;

    @Override
    public void createEntity(Company company) {
        var entity = Company.builder()
                .company(company.getCompany())
                .build();
        companyRepo.save(entity);
    }
}

