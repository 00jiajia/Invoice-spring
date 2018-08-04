package com.test.service;

import com.test.domain.DmFPHYFL;
import com.test.mapper.DmFphyflMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmFphyflImpl implements DmFphyflService{
    @Autowired
    private DmFphyflMapper dmFphyflMapper;

   /* @Autowired
    private FphyflRepository fphyflRepository;*/
    @Override
    public List<DmFPHYFL> queryList() {
        return dmFphyflMapper.queryList();
    }

    @Override
    public DmFPHYFL saveByCacheFphyfl(DmFPHYFL dmFPHYFL) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public DmFPHYFL findOne(DmFPHYFL dmFPHYFL) {
        return null;
    }

    /*@Override
    @CachePut(value="DmFPHYFL",key="#DmFPHYFL.HYFLID")
    public DmFPHYFL saveByCacheFphyfl(DmFPHYFL dmFPHYFL) {
        DmFPHYFL dm=fphyflRepository.save(dmFPHYFL);
        return dmFPHYFL;
    }

    @Override
    @CacheEvict(value="DmFPHYFL")
    public void remove(int id){

    }

    @Override
    @Cacheable(value="DmFPHYFL",key="#DmFPHYFL.HYFLID")
    public DmFPHYFL findOne(DmFPHYFL dmFPHYFL) {
        //DmFPHYFL dm=fphyflRepository.findOne(dmFPHYFL.getHYFLID());
        return dmFPHYFL;
    }*/
}
