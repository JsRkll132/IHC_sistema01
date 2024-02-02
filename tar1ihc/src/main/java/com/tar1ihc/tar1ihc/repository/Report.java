package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tar1ihc.tar1ihc.model.ReporteNotasTemplate;
@Repository

public class Report implements IReport {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<ReporteNotasTemplate> findAll() {
        String qr="SELECT * FROM reportes_notas";
        return jdbcTemplate.query(qr,BeanPropertyRowMapper.newInstance(ReporteNotasTemplate.class));

    }

    @Override
    public int save(ReporteNotasTemplate reporteNotasTemplate) {
        String qr="INSERT INTO reportes_notas VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(qr,new Object[]{reporteNotasTemplate.getIdReporte(),reporteNotasTemplate.getIdAlumno(),reporteNotasTemplate.getEvaContinua(),
            reporteNotasTemplate.getEvaParcial(),reporteNotasTemplate.getEvaFinal()});
    }

    @Override
    public int update(ReporteNotasTemplate reporteNotasTemplate) {
        String qr="UPDATE reportes_notas set eva_continua=? ,eva_final=?,eva_parcial=? where ID_ALUMNO = ?"
                ;
        return jdbcTemplate.update(qr,new Object[]{reporteNotasTemplate.getEvaContinua(),reporteNotasTemplate.getEvaFinal(),
            reporteNotasTemplate.getEvaParcial(),reporteNotasTemplate.getIdAlumno()});
    }



    @Override
    public List<ReporteNotasTemplate> findByIdList(String id) {
        String qr="SELECT * FROM reportes_notas WHERE ID_ALUMNO=?";
        return jdbcTemplate.query(qr,BeanPropertyRowMapper.newInstance(ReporteNotasTemplate.class));
    }

    @Override
    public int Reclamo(ReporteNotasTemplate reporteNotasTemplate) {
        String qr="UPDATE reportes_notas set reclamo=? where ID_ALUMNO = ?"
                ;
        return jdbcTemplate.update(qr,new Object[]{reporteNotasTemplate.getReclamo(),reporteNotasTemplate.getIdAlumno()});
    }
    
}
