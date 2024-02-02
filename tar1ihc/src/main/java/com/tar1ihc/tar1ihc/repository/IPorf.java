package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import com.tar1ihc.tar1ihc.model.ProfTemplate;

public interface IPorf {
    public List<ProfTemplate> findAll();
    public int save(ProfTemplate profTemplate);
    public int update(ProfTemplate profTemplate);
    public int deleteBYID(String id);
    
} 