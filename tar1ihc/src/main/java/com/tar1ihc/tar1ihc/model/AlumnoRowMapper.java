package com.tar1ihc.tar1ihc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class AlumnoRowMapper implements RowMapper<AlumnoTemplate>{

    @Override
    @Nullable
    public AlumnoTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
        AlumnoTemplate alumnoTemplate = new AlumnoTemplate();
        alumnoTemplate.setIdAlumno(rs.getString("ID_ALUMNO"));
        alumnoTemplate.setIdDocente(rs.getString("ID_DOCENTE"));
        alumnoTemplate.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
        alumnoTemplate.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
        alumnoTemplate.setNombres(rs.getString("NOMBRES"));
        alumnoTemplate.setCorreoInst(rs.getString("CORREO_INST"));
        alumnoTemplate.setNumTelef(rs.getLong("NUM_TELEF"));
        alumnoTemplate.setRol(rs.getBoolean("ROL"));
        alumnoTemplate.setGrupo(rs.getShort("GRUPO"));
        alumnoTemplate.setNumMatAnt(rs.getShort("NUM_MAT_ANT"));

        return alumnoTemplate;

    }


 


    
}
