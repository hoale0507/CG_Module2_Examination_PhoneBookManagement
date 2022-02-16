package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneRegexPattern {
    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_REGEX =  "/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/";

    public PhoneRegexPattern() {
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String phone) {
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
