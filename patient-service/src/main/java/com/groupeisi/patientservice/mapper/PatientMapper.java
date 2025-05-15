package com.groupeisi.patientservice.mapper;

import com.groupeisi.patientservice.dtos.PatientRequest;
import com.groupeisi.patientservice.entities.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Patient from(PatientRequest patientRequest) {
        if (patientRequest == null) {
            throw new IllegalArgumentException("PatientRequest cannot be null");
        }
        return modelMapper.map(patientRequest, Patient.class);
    }
}