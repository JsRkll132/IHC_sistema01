package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.tar1ihc.tar1ihc.model.AlumnoRowMapper;
import com.tar1ihc.tar1ihc.model.AlumnoTemplate;

@Repository
public class Alumnos implements IAlumnos {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<AlumnoTemplate> findAll() {
        String qr = "SELECT * FROM Alumnos";
        return jdbcTemplate.query(qr,BeanPropertyRowMapper.newInstance(AlumnoTemplate.class));
    }

    @Override
    public int save(AlumnoTemplate alumnoTemplate) {
        String qr = "INSERT INTO Alumnos VALUES(?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(qr,new Object[] {alumnoTemplate.getIdAlumno(),alumnoTemplate.getIdDocente(),alumnoTemplate.getApellidoPaterno()
        ,alumnoTemplate.getApellidoMaterno(),alumnoTemplate.getNombres(),alumnoTemplate.getCorreoInst(),alumnoTemplate.getNumTelef(),
    alumnoTemplate.getRol(),alumnoTemplate.getGrupo(),alumnoTemplate.getNumMatAnt()} );
    }

    @Override
    public int update(AlumnoTemplate alumnoTemplate) {
        String qr = "UPDATE Alumnos SET APELLIDO_PATERNO=? ,APELLIDO_MATERNO=?,NOMBRES=?,CORREO_INST=?"+
        ",NUM_TELEF=?,GRUPO=?,NUM_MAT_ANT=? WHERE ID_ALUMNO=?";
        return jdbcTemplate.update(qr,new Object[] {alumnoTemplate.getApellidoPaterno()
        ,alumnoTemplate.getApellidoMaterno(),alumnoTemplate.getNombres(),alumnoTemplate.getCorreoInst(),alumnoTemplate.getNumTelef(),
    alumnoTemplate.getGrupo(),alumnoTemplate.getNumMatAnt(),alumnoTemplate.getIdAlumno()} );
    }

    @Override
    public int delete(String ID_ALUMNO) {
        String qr = "DELETE FROM REPORTES_NOTAS WHERE ID_ALUMNO=? ;DELETE FROM Alumnos WHERE ID_ALUMNO=? ";
        return jdbcTemplate.update(qr,new Object[]{ID_ALUMNO,ID_ALUMNO});
    }

    @Override
    public int editPhone(Long numTelf,String idAlumno) {
        String qr = "UPDATE Alumnos SET NUM_TELEF=? WHERE ID_ALUMNO = ?";
        return jdbcTemplate.update(qr,new Object[]{numTelf,idAlumno});
    }

    @Override
    public AlumnoTemplate Auth(String correoInst, String password) {

        String qr = "SELECT * FROM alumnos WHERE correo_inst=? AND id_alumno=?";
        AlumnoTemplate alumnoTemplate = (AlumnoTemplate) jdbcTemplate.query(qr,new AlumnoRowMapper(),new Object[]{correoInst,password});
        return alumnoTemplate ;
    }
    
}
