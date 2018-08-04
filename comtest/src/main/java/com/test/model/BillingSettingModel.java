package com.test.model;

import com.test.domain.DmKpxeOption;

import java.util.ArrayList;
import java.util.List;

public class BillingSettingModel {


    private List<DmKpxeOption> KpxeOptions;
    public BillingSettingModel(){
        KpxeOptions=new ArrayList<DmKpxeOption>();
    }
    public List<DmKpxeOption> getKpxeOptions() {
        return KpxeOptions;
    }

    public void setKpxeOptions(List<DmKpxeOption> kpxeOptions) {
        KpxeOptions = kpxeOptions;
    }

    private int KPZLID;
    private String KPZLMC;
    private String KPZLDM;
    private int GSDS;
    private String FPZLDM;
    private String HYFLDM;

    public int getKPZLID() {
        return KPZLID;
    }

    public void setKPZLID(int KPZLID) {
        this.KPZLID = KPZLID;
    }

    public String getKPZLMC() {
        return KPZLMC;
    }

    public void setKPZLMC(String KPZLMC) {
        this.KPZLMC = KPZLMC;
    }

    public String getKPZLDM() {
        return KPZLDM;
    }

    public void setKPZLDM(String KPZLDM) {
        this.KPZLDM = KPZLDM;
    }

    public int getGSDS() {
        return GSDS;
    }

    public void setGSDS(int GSDS) {
        this.GSDS = GSDS;
    }

    public String getFPZLDM() {
        return FPZLDM;
    }

    public void setFPZLDM(String FPZLDM) {
        this.FPZLDM = FPZLDM;
    }

    public String getHYFLDM() {
        return HYFLDM;
    }

    public void setHYFLDM(String HYFLDM) {
        this.HYFLDM = HYFLDM;
    }

}
