package com.br.cristian.gestao_vagas.modules.service;
import com.br.cristian.gestao_vagas.modules.exception.UserFoundException;
import com.br.cristian.gestao_vagas.modules.models.Candidate;
import com.br.cristian.gestao_vagas.modules.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Candidate createCandidate(Candidate candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user)->{
                    throw new UserFoundException();
                });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
}
