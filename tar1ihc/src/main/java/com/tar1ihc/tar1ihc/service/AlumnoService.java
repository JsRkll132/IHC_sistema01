package com.tar1ihc.tar1ihc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tar1ihc.tar1ihc.model.AlumnoTemplate;
import com.tar1ihc.tar1ihc.repository.IAlumnos;
@Service
@Primary
@Component
public class AlumnoService implements IAlumnos  {
    @Autowired
    private IAlumnos iAlumnos;
    @Override
    public List<AlumnoTemplate> findAll() {
        List<AlumnoTemplate> list;
        try{
            list= iAlumnos.findAll();
        }catch(Exception e){
            System.out.println(e.toString());
            throw e;
        }
        return list;
    }

    @Override
    public int save(AlumnoTemplate alumnoTemplate) {

        int row;
        try{
            row = iAlumnos.save(alumnoTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(AlumnoTemplate alumnoTemplate) {
        int row;
        try{
            row = iAlumnos.update(alumnoTemplate);
        }catch(Exception e){
            throw e;
        }
        return row;

    }

    @Override
    public int delete(String idAlumno) {
        int row;
        try{
            row = iAlumnos.delete(idAlumno);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int editPhone(Long numTelf, String idAlumno) {
        int row;
        try{
            row = iAlumnos.editPhone(numTelf, idAlumno);
        }catch(Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public AlumnoTemplate Auth(String correoInst, String password) {
        AlumnoTemplate alumnoTemplate;
        try{
            alumnoTemplate = iAlumnos.Auth(correoInst, password);
        }catch(Exception e ){
            throw e;
        }
        return alumnoTemplate;
    }

     
}