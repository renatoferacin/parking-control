package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.integrations.Character;
import com.api.parkingcontrol.integrations.CharacterRepository;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RickMortyController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping(value = "/character/{idPersonagem}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Character consultarPersonagem(@PathVariable Integer idPersonagem) {
        return characterRepository.consultarPersonagem(idPersonagem);

    }


}
