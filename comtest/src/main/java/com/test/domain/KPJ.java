package com.test.domain;

import java.io.Serializable;
import java.util.Date;


public class KPJ implements Serializable {
    private int KPJID;
    private String KPJBH;
    private int ZJBZ;
    private String KPJMC;

    public int getKPJID() {
        return KPJID;
    }

    public void setKPJID(int KPJID) {
        this.KPJID = KPJID;
    }

    public String getKPJBH() {
        return KPJBH;
    }

    public void setKPJBH(String KPJBH) {
        this.KPJBH = KPJBH;
    }

    public int getZJBZ() {
        return ZJBZ;
    }

    public void setZJBZ(int ZJBZ) {
        this.ZJBZ = ZJBZ;
    }

    public String getKPJMC() {
        return KPJMC;
    }

    public void setKPJMC(String KPJMC) {
        this.KPJMC = KPJMC;
    }

    public Date getKSRQ() {
        return KSRQ;
    }

    public void setKSRQ(Date KSRQ) {
        this.KSRQ = KSRQ;
    }

    public Date getJYRQ() {
        return JYRQ;
    }

    public void setJYRQ(Date JYRQ) {
        this.JYRQ = JYRQ;
    }

    public Date getSCRQ() {
        return SCRQ;
    }

    public void setSCRQ(Date SCRQ) {
        this.SCRQ = SCRQ;
    }

    public String getKPDZ() {
        return KPDZ;
    }

    public void setKPDZ(String KPDZ) {
        this.KPDZ = KPDZ;
    }

    public String getLXDH() {
        return LXDH;
    }

    public void setLXDH(String LXDH) {
        this.LXDH = LXDH;
    }

    public String getFZR() {
        return FZR;
    }

    public void setFZR(String FZR) {
        this.FZR = FZR;
    }

    private Date KSRQ;
    private Date JYRQ;
    private Date SCRQ;
    private String KPDZ;
    private String LXDH;
    private String FZR;
}
