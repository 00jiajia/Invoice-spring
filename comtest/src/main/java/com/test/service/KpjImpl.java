package com.test.service;

import com.test.domain.KpjlMx;
import com.test.mapper.KPJLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class KpjImpl implements   KpjService {

    @Autowired
    KPJLMapper kpjlMapper;

    @Override
    public List<KpjlMx> queryFpjl() {
        return  kpjlMapper.queryFpjl();
    }
}
