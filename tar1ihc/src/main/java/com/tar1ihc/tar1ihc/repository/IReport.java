package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import com.tar1ihc.tar1ihc.model.ReporteNotasTemplate;

public interface IReport {
    public List<ReporteNotasTemplate> findAll();
    public List<ReporteNotasTemplate> findByIdList(String id);
    public int save(ReporteNotasTemplate reporteNotasTemplate);
    public int update(ReporteNotasTemplate reporteNotasTemplate);
    public int Reclamo(ReporteNotasTemplate reporteNotasTemplate);
    
}