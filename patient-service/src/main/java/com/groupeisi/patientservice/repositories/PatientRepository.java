package com.groupeisi.patientservice.repositories;

import com.groupeisi.patientservice.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
