package dev.challenges.translateapp;

import com.google.auth.oauth2.GoogleCredentials;
import dev.challenges.translateapp.service.TranslateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class TranslateServiceTranslationTest {

    TranslateService translateService;

    @BeforeEach
    public void init(){
        translateService = Mockito.mock(TranslateService.class);
    }


    @Test
    public void translateTextSuccessfullyTest(){

        Map<String, String> map = new HashMap<>();
        map.put("text", "hello");
        map.put("sl", "en");
        map.put("tl", "de");
        Mockito.when(translateService.translate(Mockito.any(),Mockito.any())).thenReturn("Hallo");

        GoogleCredentials credentials = Mockito.mock(GoogleCredentials.class);
        translateService.translate(map, credentials);

        Assertions.assertEquals("Hallo", translateService.translate(map, credentials));


    }



}
