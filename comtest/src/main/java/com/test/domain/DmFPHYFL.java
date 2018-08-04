package com.test.domain;


import java.io.Serializable;


public class DmFPHYFL implements Serializable {
    private int HYFLID;
    private int GSDS;
    private String HYFLDM;
    private String HYFLMC;

    public int getHYFLID() {
        return HYFLID;
    }

    public void setHYFLID(int HYFLID) {
        this.HYFLID = HYFLID;
    }

    public int getGSDS() {
        return GSDS;
    }

    public void setGSDS(int GSDS) {
        this.GSDS = GSDS;
    }

    public String getHYFLDM() {
        return HYFLDM;
    }

    public void setHYFLDM(String HYFLDM) {
        this.HYFLDM = HYFLDM;
    }

    public String getHYFLMC() {
        return HYFLMC;
    }

    public void setHYFLMC(String HYFLMC) {
        this.HYFLMC = HYFLMC;
    }


}
