package com.tar1ihc.tar1ihc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tar1ihc.tar1ihc.model.ProfTemplate;
import com.tar1ihc.tar1ihc.model.ServiceResponse;

import com.tar1ihc.tar1ihc.repository.IPorf;

@RestController
@RequestMapping("api/v1/profesores")
@CrossOrigin("*")
public class ProfController {
    @Autowired
    private IPorf iPorf;

    @GetMapping("/list")
    public ResponseEntity<List<ProfTemplate>> list(){
        var result = iPorf.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody ProfTemplate profTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iPorf.save(profTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Teacher saved...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody ProfTemplate profTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result =iPorf.update(profTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Teacher updated...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable String id ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iPorf.deleteBYID(id);
        if (result == 1 ){
            serviceResponse.setMessage("Deleted teacher...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }    
        
}
