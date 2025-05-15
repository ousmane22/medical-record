package com.groupeisi.dossiermedicalservice.repositories;

import com.groupeisi.dossiermedicalservice.entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
    List<DossierMedical> findByPatientId(Long patientId);
    List<DossierMedical> findByMedecinId(Long medecinId);
}