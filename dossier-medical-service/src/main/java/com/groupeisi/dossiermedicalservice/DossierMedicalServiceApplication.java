package com.groupeisi.dossiermedicalservice;

import com.groupeisi.dossiermedicalservice.entities.DossierMedical;
import com.groupeisi.dossiermedicalservice.repositories.DossierMedicalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class DossierMedicalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DossierMedicalServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner start(DossierMedicalRepository dossierRepository) {
        return args -> {
            if (dossierRepository.count() == 0) {
                dossierRepository.save(DossierMedical.builder()
                        .numero("DM-2023-001")
                        .patientId(1L)
                        .medecinId(1L)
                        .build());

                dossierRepository.save(DossierMedical.builder()
                        .numero("DM-2023-002")
                        .patientId(2L)
                        .medecinId(2L)
                        .build());

                System.out.println("Base de données initialisée avec 2 dossiers médicaux");
            }
        };
    }
}
