package info.cognit.dvdrental.service;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FilmServiceIntegrationTests {

    @Test
    public void findFilmByIdTest() {
        RestAssured.baseURI = "http://localhost:9990";

        ResponseBody body = RestAssured.when().get("/film/5").getBody();
        FilmEntity filmEntity = body.as(FilmEntity.class);
        Assertions.assertTrue(filmEntity.getTitle().equals("AFRICAN EGG"));
    }
}
