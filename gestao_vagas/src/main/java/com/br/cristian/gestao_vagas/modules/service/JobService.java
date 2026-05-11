package com.br.cristian.gestao_vagas.modules.service;

import com.br.cristian.gestao_vagas.modules.models.Job;
import com.br.cristian.gestao_vagas.modules.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
