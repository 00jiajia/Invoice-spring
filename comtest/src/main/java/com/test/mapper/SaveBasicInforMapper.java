package com.test.mapper;

import com.test.domain.*;

import java.util.List;

public interface SaveBasicInforMapper {

   void  saveYd(Yd yd);
   void  saveKpj(KPJ kpj);
   void  savekpzh(KPZH kpzh);
   List<Kprjs> queryForJs();
   List<Mmbhwt> queryForMmquestion();
   List<DmKpxeOption> queryForKpxeOptions();
   int queryKpr(KPR kpr);
}
