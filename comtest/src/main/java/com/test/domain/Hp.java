package com.test.domain;

import java.util.Date;

public class Hp {
    private int HPID;
    private String HPBM;
    private String HPMC;
    private String MCPYSX;
    private int KPZLID;
    private String FJBH;
    private String GGXH;
    private String DW;

    public int getHPID() {
        return HPID;
    }

    public void setHPID(int HPID) {
        this.HPID = HPID;
    }

    public String getHPBM() {
        return HPBM;
    }

    public void setHPBM(String HPBM) {
        this.HPBM = HPBM;
    }

    public String getHPMC() {
        return HPMC;
    }

    public void setHPMC(String HPMC) {
        this.HPMC = HPMC;
    }

    public String getMCPYSX() {
        return MCPYSX;
    }

    public void setMCPYSX(String MCPYSX) {
        this.MCPYSX = MCPYSX;
    }

    public int getKPZLID() {
        return KPZLID;
    }

    public void setKPZLID(int KPZLID) {
        this.KPZLID = KPZLID;
    }

    public String getFJBH() {
        return FJBH;
    }

    public void setFJBH(String FJBH) {
        this.FJBH = FJBH;
    }

    public String getGGXH() {
        return GGXH;
    }

    public void setGGXH(String GGXH) {
        this.GGXH = GGXH;
    }

    public String getDW() {
        return DW;
    }

    public void setDW(String DW) {
        this.DW = DW;
    }

    public double getDJ() {
        return DJ;
    }

    public void setDJ(double DJ) {
        this.DJ = DJ;
    }

    public double getSL() {
        return SL;
    }

    public void setSL(double SL) {
        this.SL = SL;
    }

    public String getLRKPJBH() {
        return LRKPJBH;
    }

    public void setLRKPJBH(String LRKPJBH) {
        this.LRKPJBH = LRKPJBH;
    }

    public Date getLRRQ() {
        return LRRQ;
    }

    public void setLRRQ(Date LRRQ) {
        this.LRRQ = LRRQ;
    }

    private double DJ;
    private double SL;
    private String LRKPJBH;
    private Date LRRQ;
}
