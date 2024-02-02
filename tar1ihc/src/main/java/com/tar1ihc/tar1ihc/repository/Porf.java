package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tar1ihc.tar1ihc.model.ProfTemplate;
@Repository
public class Porf implements IPorf {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<ProfTemplate> findAll() {
        String qr="SELECT * FROM Profesor";
        return jdbcTemplate.query(qr,BeanPropertyRowMapper.newInstance(ProfTemplate.class));

    }

    @Override
    public int save(ProfTemplate profTemplate) {
        String qr="INSERT INTO Profesor VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(qr,new Object[]{profTemplate.getIdDocente(),profTemplate.getApellidoPaterno(),profTemplate.getApellidoMaterno(),
        profTemplate.getNombres(),profTemplate.getCorreoInst(),profTemplate.getNumTelef()});
    }

    @Override
    public int update(ProfTemplate profTemplate) {
        String qr="UPDATE profesor SET ID_DOCENTE=?,APELLIDO_PATERNO=?,APELLIDO_MATERNO=?,NOMBRES=?,CORREO_INST=?,NUM_TELEF=?";
        return jdbcTemplate.update(qr,new Object[]{profTemplate.getIdDocente(),profTemplate.getApellidoPaterno(),profTemplate.getApellidoMaterno(),
        profTemplate.getNombres(),profTemplate.getCorreoInst(),profTemplate.getNumTelef()});
    }

    @Override
    public int deleteBYID(String id) {
        String qr="DELETE FROM Profesor WHERE ID_DOCENTE = ?";
        return jdbcTemplate.update(qr,new Object[]{id});
    }
    
}
