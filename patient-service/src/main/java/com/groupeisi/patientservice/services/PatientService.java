package com.groupeisi.patientservice.services;

import com.groupeisi.patientservice.dtos.PatientRequest;
import com.groupeisi.patientservice.entities.Patient;
import com.groupeisi.patientservice.mapper.PatientMapper;
import com.groupeisi.patientservice.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private PatientMapper patientMapper;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(PatientRequest patientRequest) {
        Patient patient = patientMapper.from(patientRequest);
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, PatientRequest patientDetails) {
        if (!patientRepository.existsById(id)) {
            return Optional.empty();
        }
        Patient patient = patientRepository.findById(id).get();
        patient.setNom(patientDetails.getNom());
        patient.setPrenom(patientDetails.getPrenom());
        patient.setDateNaissance(patientDetails.getDateNaissance());
        patient.setAdresse(patientDetails.getAdresse());
        patient.setTelephone(patientDetails.getTelephone());
        patient.setEmail(patientDetails.getEmail());
//        patient.setMedecinId(patientDetails.getMedecinId());

        return Optional.of(patientRepository.save(patient));
    }

    public boolean deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            return false;
        }
        patientRepository.deleteById(id);
        return true;
    }
}