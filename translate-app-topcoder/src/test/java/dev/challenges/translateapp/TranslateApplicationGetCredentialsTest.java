package dev.challenges.translateapp;

import com.google.auth.oauth2.GoogleCredentials;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class TranslateApplicationGetCredentialsTest {

    TranslateApplication translateApplication;

    @BeforeEach
    public void init(){
        translateApplication = Mockito.mock(TranslateApplication.class);
    }

    @Test
    public void getCredentialsSuccessfullyNonNullTest() throws IOException {
        URL keyPath = getClass().getResource("/testKeyJSON");
        GoogleCredentials googleCredentials = Mockito.mock(GoogleCredentials.class);
        Mockito.when(translateApplication.getGCPCredentials(Mockito.anyString())).thenReturn(googleCredentials);
        Assertions.assertNotNull(translateApplication.getGCPCredentials(keyPath.getPath()));
    }

    @Test
    public void getCredentialsThrowsExceptionTest() throws IOException {
        String keyPath = "abc";
        TranslateApplication translateApplication = new TranslateApplication();
        Assertions.assertThrows(FileNotFoundException.class, () -> translateApplication.getGCPCredentials(keyPath));
    }

}
