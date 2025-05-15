package com.groupeisi.dossiermedicalservice.web;

import com.groupeisi.dossiermedicalservice.dtos.DossierMedicalRequest;
import com.groupeisi.dossiermedicalservice.entities.DossierMedical;
import com.groupeisi.dossiermedicalservice.mapper.DossierMedicalMapper;
import com.groupeisi.dossiermedicalservice.services.DossierMedicalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DossierMedicalRestController {

    private final DossierMedicalService dossierService;
    private DossierMedicalMapper dossierMapper;

    @GetMapping("/dossiers")
    public ResponseEntity<List<DossierMedical>> getAllDossiers() {
        List<DossierMedical> dossiers = dossierService.getAllDossiers();
        return ResponseEntity.ok(dossiers);
    }

    @GetMapping("/dossiers/patient/{patientId}")
    public ResponseEntity<List<DossierMedical>> getDossiersByPatient(@PathVariable Long patientId) {
        List<DossierMedical> dossiers = dossierService.getDossiersByPatientId(patientId);
        return ResponseEntity.ok(dossiers);
    }

    @GetMapping("/dossiers/medecin/{medecinId}")
    public ResponseEntity<List<DossierMedical>> getDossiersByMedecin(@PathVariable Long medecinId) {
        List<DossierMedical> dossiers = dossierService.getDossiersByMedecinId(medecinId);
        return ResponseEntity.ok(dossiers);
    }

    @GetMapping("/dossier/{id}")
    public ResponseEntity<DossierMedical> getDossier(@PathVariable Long id) {
        return dossierService.getDossierById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/dossier")
    public ResponseEntity<DossierMedical> addDossier(@RequestBody DossierMedicalRequest dossierRequest) {
        DossierMedical savedDossier = dossierService.saveDossier(dossierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDossier);
    }

    @PutMapping("/dossier/{id}")
    public ResponseEntity<DossierMedical> updateDossier(@PathVariable Long id, @RequestBody DossierMedicalRequest dossier) {
        return dossierService.updateDossier(id, dossier)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/dossier/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable Long id) {
        if (!dossierService.deleteDossier(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
