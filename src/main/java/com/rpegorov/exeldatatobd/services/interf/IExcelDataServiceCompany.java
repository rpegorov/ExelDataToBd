package com.rpegorov.exeldatatobd.services.interf;

import com.rpegorov.exeldatatobd.models.entity.Orders;

import java.util.List;

public interface IExcelDataServiceCompany {

    List<Orders> getExcelDataAsList();

    int saveExcelData(List<Orders> orders);
}
