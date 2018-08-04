package com.test.controller;

import com.test.domain.KH;
import com.test.service.BatchImportService;
import com.test.service.ExportExcel;
import com.test.service.KHService;
import com.test.tool.ExcelImportUtils;
import com.test.tool.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    KHService khService;
    @Autowired
    ExportExcel exportExcel;
    @Autowired
    BatchImportService batchImportService;

    @PutMapping("/postPhoto")
    public String getImage(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes,HttpServletRequest request) {
        if (!file.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String dateTime = dateFormat.format(new Date());


            String path = request.getSession().getServletContext().getRealPath("/uploadimage/");
            String orgName=file.getOriginalFilename();
            String fileName=dateTime+orgName.substring(orgName.length()-8);
            //String suffixName=fileName.substring(fileName.lastIndexOf("."));
            File dest=new File(path + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try{
                file.transferTo(dest);
                return "http://192.168.1.215:8080/uploadimage/"+fileName;

            }catch (Exception ex){
                ex.printStackTrace();
            }

            return "ok";
        } else {
            return "文件不能为空";
        }
    }

    //excel (仅限于客户)下载
    @RequestMapping(value = "/fileExport", method = RequestMethod.GET)
    public void fileExport(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<KH> list = khService.queryKhs();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateTime = dateFormat.format(new Date());
        String fileName = "hk" + dateTime + ".xls";
        ServletUtil su = new ServletUtil(fileName, req, resp);
        su.poiExcelServlet();

        if (list != null && list.size() > 0) {

            exportExcel.Export(list, resp.getOutputStream());
        }

    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file) {

        String result="";

        if (file == null) {
            result="文件不能为空";
            return result;
        }
        String fileName = file.getOriginalFilename();
        if (!ExcelImportUtils.validateExcel(fileName)) {
            result="文件必须是excel格式！";
            return result;
        }

        long size = file.getSize();
        if (StringUtils.isEmpty(fileName) || size == 0) {
            result="文件不能为空！";
            return result;
        }

        List<KH> list = batchImportService.batchImport(fileName, file);
        if (list != null && list.size() > 0) {
            khService.BatchSaveKh(list);
        }

        result="成功";
        return result;

    }

}
