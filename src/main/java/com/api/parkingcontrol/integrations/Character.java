package com.api.parkingcontrol.integrations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    private String name;
    private String status;
    private String gender;
    private Integer id;
    private Location location;

    public String getNomeFromatado(){
        return "Senhor: " + name;
    }
}
