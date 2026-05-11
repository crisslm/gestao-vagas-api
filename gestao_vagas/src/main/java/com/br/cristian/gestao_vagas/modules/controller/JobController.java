package com.br.cristian.gestao_vagas.modules.controller;

import com.br.cristian.gestao_vagas.modules.models.Job;
import com.br.cristian.gestao_vagas.modules.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Job job){
        try{
            var result =  this.jobService.createJob(job);
            return ResponseEntity.ok().body(result);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
