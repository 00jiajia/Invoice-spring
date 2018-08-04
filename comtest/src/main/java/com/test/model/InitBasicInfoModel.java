package com.test.model;

public class InitBasicInfoModel {
    //纳税人名称
    private String NSRMC;
    //纳税人识别码
    private String NSRSBM;
    //主机标志
    private String ZJBZ;
    //行业分类
    private int HYFL;
    //开票种类
    private int KPZL;
    //行业分类名称
    private String HYFLMC;

    public String getNSRMC() {
        return NSRMC;
    }

    public void setNSRMC(String NSRMC) {
        this.NSRMC = NSRMC;
    }

    public String getNSRSBM() {
        return NSRSBM;
    }

    public void setNSRSBM(String NSRSBM) {
        this.NSRSBM = NSRSBM;
    }

    public int getHYFL() {
        return HYFL;
    }

    public void setHYFL(int HYFL) {
        this.HYFL = HYFL;
    }

    public int getKPZL() {
        return KPZL;
    }

    public void setKPZL(int KPZL) {
        this.KPZL = KPZL;
    }

    public String getZJBZ() {
        return ZJBZ;
    }

    public void setZJBZ(String ZJBZ) {
        this.ZJBZ = ZJBZ;
    }

    public String getHYFLMC() {
        return HYFLMC;
    }

    public void setHYFLMC(String HYFLMC) {
        this.HYFLMC = HYFLMC;
    }




}
