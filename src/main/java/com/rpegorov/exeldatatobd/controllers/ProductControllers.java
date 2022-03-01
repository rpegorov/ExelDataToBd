package com.rpegorov.exeldatatobd.controllers;

import com.rpegorov.exeldatatobd.models.entity.Orders;
import com.rpegorov.exeldatatobd.services.interf.IExcelDataServiceOrders;
import com.rpegorov.exeldatatobd.services.interf.IFileUploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * class controllers
 */
@Controller
@RequiredArgsConstructor
public class ProductControllers {

    private final IFileUploaderService fileUploaderService;
    private final IExcelDataServiceOrders excelDataServiceOrders;

    /**
     * Start page
     * @return start page
     */
    @GetMapping("/")
    public String index() {
        return "uploadPage";
    }

    /**
     * UploadPage and output massage
     * @param file to upload original file
     * @param redirectAttributes get attribute file - original file name
     * @return if upload is success redirect to save data page, and completion message output, else redirect to start page
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileUploaderService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    /**
     * Save Data page
     * @param model model entity to save,
     * @see Orders entiry to save
     * @return completion message
     */
    @GetMapping("/saveData")
    public String saveExcelData(Model model) {
        List<Orders> excelDataAsList = excelDataServiceOrders.getExcelDataAsList();
        var noOfRecords = excelDataServiceOrders.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords", noOfRecords);
        return "success";
    }
}
