package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CreateArrList {

    public static List<Company> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Company> companyArrayList = new ArrayList<>();
        var i = noOfColumns;
        var j = 0;
        do {
            Company company = new Company();
            for (j = 17; j < excelData.size(); j += 10) {
                company.setCompany(excelData.get(j));
                companyArrayList.add(company);
                i = j + (noOfColumns);
            }
        } while (i < excelData.size());
        return companyArrayList;
    }
}