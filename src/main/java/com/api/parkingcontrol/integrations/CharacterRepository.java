package com.api.parkingcontrol.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "rickMortyApi", url = "https://rickandmortyapi.com/api")
public interface CharacterRepository {
    @GetMapping(value = "/character/{idPersonagem}", produces = MediaType.APPLICATION_JSON_VALUE)
    Character consultarPersonagem(@PathVariable Integer idPersonagem);

}
