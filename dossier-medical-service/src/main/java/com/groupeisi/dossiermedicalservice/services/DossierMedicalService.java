package com.groupeisi.dossiermedicalservice.services;

import com.groupeisi.dossiermedicalservice.dtos.DossierMedicalRequest;
import com.groupeisi.dossiermedicalservice.entities.DossierMedical;
import com.groupeisi.dossiermedicalservice.mapper.DossierMedicalMapper;
import com.groupeisi.dossiermedicalservice.repositories.DossierMedicalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DossierMedicalService {
    private final DossierMedicalRepository dossierRepository;
    private DossierMedicalMapper dossierMapper;

    public List<DossierMedical> getAllDossiers() {
        return dossierRepository.findAll();
    }

    public Optional<DossierMedical> getDossierById(Long id) {
        return dossierRepository.findById(id);
    }

    public List<DossierMedical> getDossiersByPatientId(Long patientId) {
        return dossierRepository.findByPatientId(patientId);
    }

    public List<DossierMedical> getDossiersByMedecinId(Long medecinId) {
        return dossierRepository.findByMedecinId(medecinId);
    }

    public DossierMedical saveDossier(DossierMedicalRequest dossierRequest) {
        DossierMedical dossier = dossierMapper.from(dossierRequest);

        if (dossier.getNumero() == null || dossier.getNumero().isEmpty()) {
            dossier.setNumero("DM-" + System.currentTimeMillis());
        }

        return dossierRepository.save(dossier);
    }

    public Optional<DossierMedical> updateDossier(Long id, DossierMedicalRequest dossierDetails) {
        if (!dossierRepository.existsById(id)) {
            return Optional.empty();
        }
        DossierMedical dossier = dossierRepository.findById(id).get();

        dossier.setPatientId(dossierDetails.getPatientId());
        dossier.setMedecinId(dossierDetails.getMedecinId());

        return Optional.of(dossierRepository.save(dossier));
    }

    public boolean deleteDossier(Long id) {
        if (!dossierRepository.existsById(id)) {
            return false;
        }
        dossierRepository.deleteById(id);
        return true;
    }
}
