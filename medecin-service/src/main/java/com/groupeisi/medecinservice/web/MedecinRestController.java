package com.groupeisi.medecinservice.web;

import com.groupeisi.medecinservice.dtos.MedecinRequest;
import com.groupeisi.medecinservice.entities.Medecin;
import com.groupeisi.medecinservice.mapper.MedecinMapper;
import com.groupeisi.medecinservice.services.MedecinService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MedecinRestController {

    private final MedecinService medecinService;
    private MedecinMapper medecinMapper;

    @GetMapping("/medecins")
    public ResponseEntity<List<Medecin>> getAllMedecins() {
        List<Medecin> medecins = medecinService.getAllMedecins();
        return ResponseEntity.ok(medecins);
    }

    @GetMapping("/medecin/{id}")
    public ResponseEntity<Medecin> getMedecin(@PathVariable Long id) {
        return medecinService.getMedecinById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/medecin")
    public ResponseEntity<Medecin> addMedecin(@RequestBody MedecinRequest medecinRequest) {
        Medecin savedMedecin = medecinService.saveMedecin(medecinRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedecin);
    }

    @PutMapping("/medecin/{id}")
    public ResponseEntity<Medecin> updateMedecin(@PathVariable Long id, @RequestBody MedecinRequest medecin) {
        return medecinService.updateMedecin(id, medecin)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/medecin/{id}")
    public ResponseEntity<Void> deleteMedecin(@PathVariable Long id) {
        if (!medecinService.deleteMedecin(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
