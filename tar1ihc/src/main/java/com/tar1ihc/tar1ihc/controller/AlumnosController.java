package com.tar1ihc.tar1ihc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tar1ihc.tar1ihc.model.AlumnoTemplate;
import com.tar1ihc.tar1ihc.repository.IAlumnos;
import com.tar1ihc.tar1ihc.model.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/alumnos")
@CrossOrigin("*")
public class AlumnosController {
    @Autowired
    private IAlumnos iAlumnos;

    @GetMapping("/list")
    public ResponseEntity<List<AlumnoTemplate>> list(){
        var result = iAlumnos.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody AlumnoTemplate alumnoTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnos.save(alumnoTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Student saved...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody AlumnoTemplate alumnoTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnos.update(alumnoTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Student saved...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable String id ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iAlumnos.delete(id);
        if (result == 1 ){
            serviceResponse.setMessage("Student saved...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }
    @PostMapping("/{idAlumno}/{numTelef}") 
    public ResponseEntity<ServiceResponse> editPhone(@RequestBody Long numTelef,String idAlumno ){
            ServiceResponse serviceResponse = new ServiceResponse();
            int result = iAlumnos.editPhone(numTelef, idAlumno);
            if (result == 1 ){
                serviceResponse.setMessage("Changed number ...");
            }
            return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

    @PostMapping("/LoginAuth")
    public ResponseEntity<AlumnoTemplate> authentication(@RequestBody String correoInst, String password){
        var result = iAlumnos.Auth(correoInst, password);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
