package com.tar1ihc.tar1ihc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tar1ihc.tar1ihc.model.ProfTemplate;
import com.tar1ihc.tar1ihc.repository.IPorf;
@Service
@Primary
@Component
public class ProfService implements IPorf {
    @Autowired
    private IPorf iPorf;
    @Override
    public List<ProfTemplate> findAll() {
        List<ProfTemplate> list;
        try{
            list = iPorf.findAll();
        }catch(Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(ProfTemplate profTemplate) {
        int row ;
        try{
            row = iPorf.save(profTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(ProfTemplate profTemplate) {
        int row;
        try{
            row = iPorf.update(profTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;

    }

    @Override
    public int deleteBYID(String id) {
        int row;
        try{
            row = iPorf.deleteBYID(id);
        }catch(Exception e){
            throw e;
        }
        return row;

    }
    
}
