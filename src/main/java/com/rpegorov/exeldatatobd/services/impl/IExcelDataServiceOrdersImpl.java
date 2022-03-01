package com.rpegorov.exeldatatobd.services.impl;

import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.repositories.OrdersRepository;
import com.rpegorov.exeldatatobd.services.interf.IExcelDataServiceOrders;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.rpegorov.exeldatatobd.services.CreateArrList.createList;

@Service
@RequiredArgsConstructor
public class IExcelDataServiceOrdersImpl implements IExcelDataServiceOrders {

    @Value("${app.upload.file:${user.home}}")
    private String EXCEL_FILE_PATH;

    private final OrdersRepository repo;
    private Workbook workbook;

    @Override
    public List<Orders> getExcelDataAsList() {
        DataFormatter dataFormatter = new DataFormatter();
        try {
            workbook = new XSSFWorkbook(new File(EXCEL_FILE_PATH));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                if (!cellValue.isEmpty()) {
                    list.add(cellValue);
                }
            }
        }
        System.out.println(list);
        var ordersList = createList(list, noOfColumns);
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public int saveExcelData(List<Orders> orders) {
        List<Orders> saved = repo.saveAll(orders);
        return saved.size();
    }
}
