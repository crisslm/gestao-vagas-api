package com.br.cristian.gestao_vagas.modules.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "job")
@Data
public class Job{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;

    @NotBlank(message = "Esse campo é obrigatório")
    private String level;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Company company;

    @NotNull
    @Column(name = "company_id")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
