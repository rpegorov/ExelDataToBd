package com.rpegorov.exeldatatobd.services.interf;

import com.rpegorov.exeldatatobd.models.entity.Company;
import com.rpegorov.exeldatatobd.models.entity.Product;

import java.util.List;

public interface IExcelDataServiceCompany {

    List<Company> getExcelDataAsList();

    int saveExcelData(List<Orders> orders);
}
