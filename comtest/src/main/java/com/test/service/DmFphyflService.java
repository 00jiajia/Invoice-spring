package com.test.service;

import com.test.domain.DmFPHYFL;

import java.util.List;


public interface DmFphyflService  {

    List<DmFPHYFL> queryList();
    DmFPHYFL saveByCacheFphyfl(DmFPHYFL dmFPHYFL);
    void remove(int id);
    DmFPHYFL findOne(DmFPHYFL dmFPHYFL);
}
