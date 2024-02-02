package com.tar1ihc.tar1ihc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tar1ihc.tar1ihc.model.AlumnoTemplate;

public interface IAlumnos {
    @Autowired
    public List<AlumnoTemplate> findAll();
    public int save(AlumnoTemplate alumnoTemplate);
    public int update(AlumnoTemplate alumnoTemplate);
    public int delete(String idAlumno);
    public int editPhone(Long numTelf,String idAlumno);
    public AlumnoTemplate Auth(String correoInst,String password);
}
