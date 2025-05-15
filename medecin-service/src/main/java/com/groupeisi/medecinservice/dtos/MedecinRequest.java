package com.groupeisi.medecinservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedecinRequest {
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;
    private String email;
    private String adresseCabinet;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresseCabinet() {
        return adresseCabinet;
    }
}
