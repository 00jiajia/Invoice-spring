package com.test.service;

import com.test.domain.DmKPZL;
import com.test.mapper.DmKPZLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmKpzlImpl implements DmKpzlService {

    @Autowired
    private DmKPZLMapper dmKPZLMapper;

    @Override
    public List<DmKPZL> queryList() {
        return dmKPZLMapper.queryList();
    }
}
