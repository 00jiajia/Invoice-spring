package com.test.service;

import com.test.domain.KH;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component
public class ExportExcel {

    private static void CreateTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row=sheet.createRow(0);
        sheet.setColumnWidth(12,12*256);

        HSSFCell cell;
        cell=row.createCell(0);
        cell.setCellValue("客户名称");
        cell=row.createCell(1);
        cell.setCellValue("纳税人识别码");
        cell=row.createCell(2);
        cell.setCellValue("联系电话");
        cell=row.createCell(3);
        cell.setCellValue("联系人");
        cell=row.createCell(4);
        cell.setCellValue("联系地址");
        cell=row.createCell(5);
        cell.setCellValue("开会银行");
        cell=row.createCell(6);
        cell.setCellValue("银行账号");
        cell=row.createCell(7);
        cell.setCellValue("工商登记号");

    }
    public static void Export(List<KH> list, OutputStream out) throws IOException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateTime = dateFormat.format(new Date());

        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("kh"+dateTime);


        CreateTitle(workbook,sheet);
        int rowNum = 1;
        for (KH kh:list) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(kh.getKHMC());
            row.createCell(1).setCellValue(kh.getNSRSBM());
            row.createCell(2).setCellValue(kh.getLXDH());
            row.createCell(3).setCellValue(kh.getLXR());
            row.createCell(4).setCellValue(kh.getLXDZ());
            row.createCell(5).setCellValue(kh.getKHYH());
            row.createCell(6).setCellValue(kh.getYHZH());
            row.createCell(7).setCellValue(kh.getGSDJH());
            rowNum++;
        }


        try{
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
