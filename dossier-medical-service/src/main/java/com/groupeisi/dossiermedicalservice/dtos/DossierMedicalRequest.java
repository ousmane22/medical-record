package com.groupeisi.dossiermedicalservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DossierMedicalRequest {
    private String numero;
    private Long patientId;
    private Long medecinId;

    public String getNumero() {
        return numero;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getMedecinId() {
        return medecinId;
    }
}