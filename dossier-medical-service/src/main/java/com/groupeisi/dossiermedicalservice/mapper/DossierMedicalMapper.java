package com.groupeisi.dossiermedicalservice.mapper;

import com.groupeisi.dossiermedicalservice.dtos.DossierMedicalRequest;
import com.groupeisi.dossiermedicalservice.entities.DossierMedical;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DossierMedicalMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public DossierMedical from(DossierMedicalRequest dossierMedicalRequest) {
        if (dossierMedicalRequest == null) {
            throw new IllegalArgumentException("DossierMedicalRequest cannot be null");
        }
        return modelMapper.map(dossierMedicalRequest, DossierMedical.class);
    }
}