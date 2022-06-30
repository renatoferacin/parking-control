package com.api.parkingcontrol;

import com.api.parkingcontrol.integrations.Character;
import com.api.parkingcontrol.integrations.CharacterRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControlApplicationTests {
    @LocalServerPort
    int porta;
    @BeforeEach
    public void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = porta;
    }

	@MockBean
	CharacterRepository characterRepository;


    @Test public void
    testeNomeDePersonagem(){
        Mockito.when(characterRepository.consultarPersonagem(5)).thenReturn(Character.builder().name("Hudson").build());
        Mockito.when(characterRepository.consultarPersonagem(6)).thenReturn(Character.builder().name("Renato").build());
        when().
                get("/api/character/6").
        then().
                statusCode(200).
                body("nomeFormatado", equalTo("Senhor: renato"));

    }

}
