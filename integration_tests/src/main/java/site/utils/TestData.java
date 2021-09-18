package site.utils;

import java.util.UUID;

public class TestData {

    public static String getRandomEmail() {
        return "email" + UUID.randomUUID() + "@gmail.com";
    }

    public static String getRandomPassword() {
        return UUID.randomUUID().toString();
    }
}
