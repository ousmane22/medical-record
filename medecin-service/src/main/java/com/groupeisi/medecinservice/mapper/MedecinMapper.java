package com.groupeisi.medecinservice.mapper;

import com.groupeisi.medecinservice.dtos.MedecinRequest;
import com.groupeisi.medecinservice.entities.Medecin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MedecinMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Medecin from(MedecinRequest medecinRequest) {
        if (medecinRequest == null) {
            throw new IllegalArgumentException("MedecinRequest cannot be null");
        }
        return modelMapper.map(medecinRequest, Medecin.class);
    }
}
