package com.clickconcepts.service;

import com.clickconcepts.exception.CustomException;
import com.clickconcepts.matcher.CustomCodeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TypicalBusinessServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void justTheExceptionMatcher() {
        thrown.expect(CustomCodeMatcher.hasCode("12345"));
        throw new CustomException("12345");
    }

    @Test
    public void getOurBusinessName_noException() {
        TypicalBusinessService service = new TypicalBusinessService();
        service.getOurBusinessName("12345");
    }

    @Test
    public void getOurBusinessName_exception() {
        thrown.expect(CustomCodeMatcher.hasCode(CustomException.BAD_VERSION_CODE));
        TypicalBusinessService service = new TypicalBusinessService();
        service.getOurBusinessName(TypicalBusinessService.KNOWN_VERSION_ERROR);
    }
}
