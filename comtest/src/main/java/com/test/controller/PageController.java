package com.test.controller;


import com.test.domain.KH;
import com.test.domain.KpjlMx;
import com.test.service.*;
import com.test.tool.ExcelImportUtils;
import com.test.tool.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    FpbService fpbService;
    @Autowired
    ExcelImportUtils utils;
    @Autowired
    BatchImportService batchImportService;
    @Autowired
    KHService khService;
    @Autowired
    ExportExcel exportExcel;
    @Autowired
    KpjService kpjService;


    @RequestMapping(value = "getInvoice")
    public String getInvoice(Model model) {
        model.addAttribute("users", "张三");
        //fpbService.queryFpbLgs();
//        mav = new ModelAndView("redirect:resources/static/invoiceHtml.html");
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("zhangsan", "北京");
//        map.put("lisi", "上海");
//        map.put("wangwu", "深圳");
//        mav.addObject("map",map);
//        mav.setViewName("invoiceHtml");
        //return "invoiceHtml.html";
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", "张三");
        mav.setViewName("invoice");
        return "index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/invoice")
    public String invoice(Model model) {
        //model.addAttribute("name", "张三");
        List<KpjlMx> kpjlMxList=kpjService.queryFpjl();
        model.addAttribute("kpjlMxList",kpjlMxList);
        return "invoiceHtml";
    }

    @RequestMapping(value = "/fileInit", method = RequestMethod.GET)
    public String fileUploadInit() {
        return "excelUpload";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) {

        if (file == null) {
            model.addAttribute("result", "文件不能为空");
            return "success";
        }
        String fileName = file.getOriginalFilename();
        if (!ExcelImportUtils.validateExcel(fileName)) {
            model.addAttribute("result", "文件必须是excel格式！");
            return "success";
        }

        long size = file.getSize();
        if (StringUtils.isEmpty(fileName) || size == 0) {
            model.addAttribute("result", "文件不能为空!");
            return "success";
        }

        List<KH> list = batchImportService.batchImport(fileName, file);
        if (list != null && list.size() > 0) {
            khService.BatchSaveKh(list);
        }
        model.addAttribute("result","成功!");

        return "success";

    }

    @RequestMapping(value = "/fileExport",method = RequestMethod.GET)
    public void fileExport(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<KH> list=khService.queryKhs();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateTime = dateFormat.format(new Date());
        String fileName="hk"+dateTime+".xls";
        ServletUtil su = new ServletUtil(fileName, req, resp);
        su.poiExcelServlet();

        if(list!=null&&list.size()>0){

            exportExcel.Export(list,resp.getOutputStream());
        }

    }


}
