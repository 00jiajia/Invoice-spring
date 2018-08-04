package com.test.model;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.Date;

public class InvoiceModel {
    //发票代码
    private String invoiceCode;
    //开始号码
    private String startCode;
    //截止号码
    private String endCode;
    //份数
    private int count;
    //购票日期
    private Date date;
    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getStartCode() {
        return startCode;
    }

    public void setStartCode(String startCode) {
        this.startCode = startCode;
    }

    public String getEndCode() {
        return endCode;
    }

    public void setEndCode(String endCode) {
        this.endCode = endCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
