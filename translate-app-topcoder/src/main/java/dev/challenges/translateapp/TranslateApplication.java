package dev.challenges.translateapp;

import com.google.auth.oauth2.GoogleCredentials;
import dev.challenges.translateapp.exception.InvalidInputStringException;
import dev.challenges.translateapp.service.TranslateService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TranslateApplication {

    public Map<String, String> parseInputString(String[] args) throws InvalidInputStringException {

        try {
            String input = args[0];
            String path = args[1];

            input = input.trim();
            String[] arguments = input.split(";");
            Map<String, String> inputMap = new HashMap<>();
            for (String argument : arguments) {
                String[] keyValue = argument.split("=");
                inputMap.put(keyValue[0], keyValue[1]);
            }

            inputMap.put("path", path.trim());

            return inputMap;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidInputStringException("Invalid Input String", e);
        }

    }

    public GoogleCredentials getGCPCredentials(String jsonPath) throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath)).createScoped("https://www.googleapis.com/auth/cloud-platform");
        return credentials;
    }

    public String run(String[] args) throws IOException {
        Map<String, String> inputMap = parseInputString(args);
        GoogleCredentials googleCredentials = getGCPCredentials(inputMap.get("path"));
        TranslateService translateService = new TranslateService();
        String translatedText = translateService.translate(inputMap, googleCredentials);
        return translatedText;
    }


    public static void main(String[] args) throws IOException {
        TranslateApplication translateApplication = new TranslateApplication();
        String text = translateApplication.run(args);
        System.out.println(text);
    }

}
