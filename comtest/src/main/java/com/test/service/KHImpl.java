package com.test.service;

import com.test.domain.KH;
import com.test.mapper.KHMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHImpl implements KHService {
    @Autowired
    KHMapper khMapper;

    @Override
    public void saveKh(KH kh) {
        khMapper.saveKh(kh);
    }

    @Override
    public boolean BatchSaveKh(List<KH> list) {
        try {
            for (KH kh : list) {
                saveKh(kh);
            }
            return true;

        } catch (Exception ex) {
            ex.getMessage();
            return false;
        }

    }

    @Override
    public List<KH> queryKhs() {
        return khMapper.queryKhs();
    }
}
