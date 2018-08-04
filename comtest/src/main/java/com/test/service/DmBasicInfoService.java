package com.test.service;

import com.test.domain.*;
import com.test.model.BillingSettingModel;

import java.util.List;

public interface DmBasicInfoService {
    void save(Yd yd);
    void save(KPJ kpj);
    void save(KPZH kpzh);
    String queryForJs();
    String queryForMmquestion();
    String queryForKpxeOptions();
    List<Kprjs> queryJsForList();
    List<BillingSettingModel> getBillingSetting();
    boolean queryKpr(KPR kpr);
}
