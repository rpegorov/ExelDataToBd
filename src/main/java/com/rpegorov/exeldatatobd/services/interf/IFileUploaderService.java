package com.rpegorov.exeldatatobd.services.interf;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService {

    void uploadFile(MultipartFile file);
}
