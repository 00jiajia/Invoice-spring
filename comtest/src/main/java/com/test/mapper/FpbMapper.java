package com.test.mapper;

import com.test.domain.FpbLg;
import com.test.domain.FpbTz;
import com.test.domain.KPZH;

import java.util.List;

public interface FpbMapper {
    void  saveFpbLg(FpbLg fpbLg);
    List<FpbTz>queryFpbStockList();
    List<FpbLg>queryFpbLgList();
    KPZH queryKpzh();
}
