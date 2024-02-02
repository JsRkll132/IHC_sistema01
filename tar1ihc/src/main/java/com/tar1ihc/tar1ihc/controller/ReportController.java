package com.tar1ihc.tar1ihc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tar1ihc.tar1ihc.model.ReporteNotasTemplate;
import com.tar1ihc.tar1ihc.model.ServiceResponse;
import com.tar1ihc.tar1ihc.repository.IReport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/v1/reports")
@CrossOrigin("*")
public class ReportController {
    @Autowired
    private IReport iReport;

    @GetMapping("/list")
    public ResponseEntity<List<ReporteNotasTemplate>> list(){
        var result = iReport.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody ReporteNotasTemplate reporteNotasTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iReport.save(reporteNotasTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Report saved...");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody ReporteNotasTemplate reporteNotasTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result =iReport.update(reporteNotasTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Report Update..");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }  
    @PostMapping("/mreclamo")
    public ResponseEntity<ServiceResponse> Reclamo(@RequestBody ReporteNotasTemplate reporteNotasTemplate ){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result =iReport.Reclamo(reporteNotasTemplate);
        if (result == 1 ){
            serviceResponse.setMessage("Report Update..");
        }
        return new ResponseEntity<>(serviceResponse ,HttpStatus.OK);
    }    
}
