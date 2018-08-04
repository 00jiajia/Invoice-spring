package com.test.mapper;

import com.test.domain.KH;

import java.util.List;

public interface KHMapper {
    //批量插入数据
    void saveKh(KH kh);
    List<KH> queryKhs();
}
