package com.test.service;

import com.test.domain.FpbLg;
import com.test.domain.FpbTz;
import com.test.domain.KPZH;
import com.test.mapper.FpbMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FpbImpl implements  FpbService {

    @Autowired
    FpbMapper fpbMapper;

    @Override
    public void saveFpbLg(FpbLg fpbLg) {
        fpbMapper.saveFpbLg(fpbLg);
    }

    @Override
    public List<FpbTz> queryFpbStockList() {
        return fpbMapper.queryFpbStockList();
        //return null;
    }

    @Override
    public List<FpbLg> queryFpbLgList() {
        return null;
    }

    @Override
    public String queryFpbStocks() {
        List<FpbTz> fpbTzList=fpbMapper.queryFpbStockList();
        JSONArray array=JSONArray.fromObject(fpbTzList);
        return array.toString();
    }

    @Override
    public String queryFpbLgs() {
        List<FpbLg> list=fpbMapper.queryFpbLgList();
        JSONArray array=JSONArray.fromObject(list);
        return array.toString();
    }
    @Override
    public boolean updateFpbTz() {


        return false;
    }

    @Override
    public String queryKpzh() {
        KPZH kpzh =fpbMapper.queryKpzh();
        JSONObject obj=JSONObject.fromObject(kpzh);
        return obj.toString();
    }

    @Override
    public String queryKpbTzs() {
        List<FpbTz> list=fpbMapper.queryFpbStockList();
        JSONArray array=JSONArray.fromObject(list);
        return array.toString();
    }


}
