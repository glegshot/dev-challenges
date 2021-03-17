package dev.challenges.translateapp.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.Map;

public class TranslateService {

    public String translate(Map<String, String> input, GoogleCredentials credentials) {
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).build().getService();
        Translation translation = translate.translate(input.get("text"), Translate.TranslateOption.sourceLanguage(input.get("sl")), Translate.TranslateOption.targetLanguage(input.get("tl")));
        return translation.getTranslatedText();
    }

}
