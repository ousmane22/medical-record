package com.groupeisi.medecinservice.services;

import com.groupeisi.medecinservice.dtos.MedecinRequest;
import com.groupeisi.medecinservice.entities.Medecin;
import com.groupeisi.medecinservice.mapper.MedecinMapper;
import com.groupeisi.medecinservice.repositories.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedecinService {
    private final MedecinRepository medecinRepository;
    private MedecinMapper medecinMapper;

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Optional<Medecin> getMedecinById(Long id) {
        return medecinRepository.findById(id);
    }

    public Medecin saveMedecin(MedecinRequest medecinRequest) {
        Medecin medecin = medecinMapper.from(medecinRequest);
        return medecinRepository.save(medecin);
    }

    public Optional<Medecin> updateMedecin(Long id, MedecinRequest medecinDetails) {
        if (!medecinRepository.existsById(id)) {
            return Optional.empty();
        }
        Medecin medecin = medecinRepository.findById(id).get();
        medecin.setNom(medecinDetails.getNom());
        medecin.setPrenom(medecinDetails.getPrenom());
        medecin.setSpecialite(medecinDetails.getSpecialite());
        medecin.setTelephone(medecinDetails.getTelephone());
        medecin.setEmail(medecinDetails.getEmail());
        medecin.setAdresseCabinet(medecinDetails.getAdresseCabinet());

        return Optional.of(medecinRepository.save(medecin));
    }

    public boolean deleteMedecin(Long id) {
        if (!medecinRepository.existsById(id)) {
            return false;
        }
        medecinRepository.deleteById(id);
        return true;
    }
}
