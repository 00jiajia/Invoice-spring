package com.test.service;

import com.test.domain.KH;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BatchImportService {

    List<KH> readExcelValue(Workbook wb);
    List<KH> batchImport(String fileName, MultipartFile mfile);

}
