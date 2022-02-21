package com.rpegorov.exeldatatobd.services.interf;

import com.rpegorov.exeldatatobd.models.entity.Product;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface IExcelDataService {

    List<Product> getExcelDataAsList();

    int saveExcelData(List<Product> products);
}
