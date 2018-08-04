package com.test.service;

import com.test.domain.*;
import com.test.mapper.DmKPZLMapper;
import com.test.mapper.SaveBasicInforMapper;
import com.test.model.BillingSettingModel;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DmBasicInfoImpl implements DmBasicInfoService{
    @Autowired
    SaveBasicInforMapper mapper;
    @Autowired
    private DmKPZLMapper dmKPZLMapper;

    @Override
    public void save(Yd yd) {
        mapper.saveYd(yd);
    }

    @Override
    public void save(KPJ kpj) {
        mapper.saveKpj(kpj);
    }

    @Override
    public void save(KPZH kpzh) {
        mapper.savekpzh(kpzh);
    }

    @Override
    public String queryForJs() {
        List<Kprjs> jss= mapper.queryForJs();
        JSONArray array=JSONArray.fromObject(jss);
        return array.toString();

    }

    @Override
    public String queryForMmquestion() {
        List<Mmbhwt> list= mapper.queryForMmquestion();
        JSONArray array=JSONArray.fromObject(list);
        return array.toString();
    }

    @Override
    public String queryForKpxeOptions() {
        List<DmKpxeOption> list=mapper.queryForKpxeOptions();
        JSONArray array=JSONArray.fromObject(list);
        return array.toString();
    }

    @Override
    public List<Kprjs> queryJsForList() {
        return mapper.queryForJs();
    }

    @Override
    public List<BillingSettingModel> getBillingSetting() {
        List<BillingSettingModel> list=new ArrayList<BillingSettingModel>();
        List<DmKPZL> dmkpzls=dmKPZLMapper.queryList();
        List<DmKpxeOption> kpxeOptions=mapper.queryForKpxeOptions();
        if(dmkpzls!=null&&dmkpzls.size()>0){
            for(DmKPZL info:dmkpzls){
                BillingSettingModel model=new BillingSettingModel();
                model.setFPZLDM(info.getFPZLDM());
                model.setGSDS(info.getGSDS());
                model.setHYFLDM(info.getHYFLDM());
                model.setKPZLDM(info.getKPZLDM());
                model.setKPZLID(info.getKPZLID());
                model.setKPZLMC(info.getKPZLMC());
                List<DmKpxeOption> temp=new ArrayList<DmKpxeOption>();
                for (DmKpxeOption kp:kpxeOptions){
                    if(kp.getKPZLID()==info.getKPZLID()){
                        temp.add(kp);
                    }
                }
                model.setKpxeOptions(temp);
                list.add(model);
            }
        }



        return list;
    }

    @Override
    public boolean queryKpr(KPR kpr) {
        boolean isTrue=false;
        int id=mapper.queryKpr(kpr);
        if(id>0) isTrue=true;
        return isTrue;
    }
}
