package com.rpegorov.exeldatatobd.services;

import com.rpegorov.exeldatatobd.models.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CreateArrList {
    public CreateArrList() {
    }

    public static List<Product> createList(List<String> excelData, int noOfColumns) {
        ArrayList<Product> productArrayList = new ArrayList<>();
        int i = noOfColumns;
        do {
            Product prd = new Product();
//            prd.setDataType(DataType.valueOf(excelData.get(i)));
//            prd.setProductType(ProductType.valueOf(excelData.get(i + 1)));
            prd.setDate(Long.valueOf(excelData.get(i + 2)));
//            prd.set(excelData.get(i + 3));
            productArrayList.add(prd);
            i = i + (noOfColumns);

        } while (i < excelData.size());
        return productArrayList;
    }
}