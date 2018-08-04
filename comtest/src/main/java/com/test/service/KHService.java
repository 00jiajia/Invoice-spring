package com.test.service;

import com.test.domain.KH;

import java.util.List;

public interface KHService {
    void saveKh(KH kh);
    boolean BatchSaveKh(List<KH> list);
    List<KH> queryKhs();
}
