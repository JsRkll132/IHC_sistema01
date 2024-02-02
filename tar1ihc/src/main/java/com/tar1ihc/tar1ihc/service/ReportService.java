package com.tar1ihc.tar1ihc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tar1ihc.tar1ihc.model.ReporteNotasTemplate;
import com.tar1ihc.tar1ihc.repository.IReport;
@Service
@Primary
@Component
public class ReportService implements IReport{
    @Autowired
    private IReport  iReport;
    @Override
    public List<ReporteNotasTemplate> findAll() {
        List<ReporteNotasTemplate> list;
        try{
            list = iReport.findAll();
        }catch(Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int save(ReporteNotasTemplate reporteNotasTemplate) {
        int row ;
        try{
            row = iReport.save(reporteNotasTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(ReporteNotasTemplate reporteNotasTemplate) {
        int row;
        try{
            row = iReport.update(reporteNotasTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public List<ReporteNotasTemplate> findByIdList(String id) {
        List<ReporteNotasTemplate> list;
        try{
            list = iReport.findAll();
        }catch(Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public int Reclamo(ReporteNotasTemplate reporteNotasTemplate) {
        int row;
        try{
            row = iReport.Reclamo(reporteNotasTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;
    }
    
}
