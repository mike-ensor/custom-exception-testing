package com.clickconcepts.service;

import com.clickconcepts.exception.CustomException;

public class TypicalBusinessService {

    public static final String KNOWN_VERSION_ERROR = "v12.53.1";

    public String getOurBusinessName(String version) {
        if (KNOWN_VERSION_ERROR.equals(version)) {
            throw new CustomException(CustomException.BAD_VERSION_CODE);
        }
        return "Ah Yeah!";
    }
}
