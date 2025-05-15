package com.groupeisi.patientservice;

import com.groupeisi.patientservice.entities.Patient;
import com.groupeisi.patientservice.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder()
                    .nom("Diop")
                    .prenom("Fatou")
                    .dateNaissance(LocalDate.of(1985, 5, 15))
                    .adresse("123 Rue Faidherbe, Dakar")
                    .telephone("77 123 45 67")
                    .email("fatou.diop@example.com")
//                    .medecinId(1L)
                    .build());

            patientRepository.save(Patient.builder()
                    .nom("Sall")
                    .prenom("Mamadou")
                    .dateNaissance(LocalDate.of(1978, 8, 20))
                    .adresse("45 Avenue Lamine Gueye, Dakar")
                    .telephone("78 765 43 21")
                    .email("mamadou.sall@example.com")
//                    .medecinId(2L)
                    .build());

            patientRepository.save(Patient.builder()
                    .nom("Mbaye")
                    .prenom("Aissatou")
                    .dateNaissance(LocalDate.of(1990, 3, 12))
                    .adresse("78 Boulevard de la République, Dakar")
                    .telephone("76 234 56 78")
                    .email("aissatou.mbaye@example.com")
//                    .medecinId(1L)
                    .build());

            patientRepository.save(Patient.builder()
                    .nom("Ndiaye")
                    .prenom("Ousmane")
                    .dateNaissance(LocalDate.of(1982, 11, 25))
                    .adresse("12 Rue Abdou Diouf, Dakar")
                    .telephone("70 876 54 32")
                    .email("ousmane.ndiaye@example.com")
//                    .medecinId(2L)
                    .build());
        };
    }
}
