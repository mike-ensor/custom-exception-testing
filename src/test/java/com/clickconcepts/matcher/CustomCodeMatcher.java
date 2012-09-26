package com.clickconcepts.matcher;

import com.clickconcepts.exception.CustomException;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CustomCodeMatcher extends TypeSafeMatcher<CustomException> {

    public static CustomCodeMatcher hasCode(String item) {
        return new CustomCodeMatcher(item);
    }

    private String foundErrorCode;
    private String expectedErrorCode;

    private CustomCodeMatcher(String expectedErrorCode) {
        this.expectedErrorCode = expectedErrorCode;
    }

    @Override
    protected boolean matchesSafely(final CustomException exception) {
        this.foundErrorCode = exception.getErrorCode();
        return foundErrorCode.equalsIgnoreCase(expectedErrorCode);
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(foundErrorCode).appendText(" was not found instead of ").appendValue(expectedErrorCode);
    }
}

