package dev.challenges.translateapp;

import dev.challenges.translateapp.exception.InvalidInputStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TranslateApplicationInputParsingTest {

    TranslateApplication translateApplication;

    @BeforeEach
    public void init() {
        translateApplication = new TranslateApplication();
    }

    @Test
    public void inputMapConstructionTest() {
        String path = "/testfile";
        String[] args = new String[]{"text=hello;sl=en;tl=de;",path};
        Map<String, String> map = new HashMap<>();
        map.put("text", "hello");
        map.put("sl", "en");
        map.put("tl", "de");
        map.put("path", "/testfile");
        Assertions.assertEquals(map, translateApplication.parseInputString(args));
    }

    @Test
    public void inputMapConstructionThrowInvalidInputExceptionTest() {
        String[] args = new String[]{";sd;"};
        Assertions.assertThrows(InvalidInputStringException.class, () -> translateApplication.parseInputString(args));

    }


}