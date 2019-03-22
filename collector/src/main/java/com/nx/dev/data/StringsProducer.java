package com.nx.dev.data;

import lombok.experimental.UtilityClass;

import java.util.Random;

/**
 * String producer.
 */
@UtilityClass
public class StringsProducer {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    /**
     * Get static array of strings.
     */
    public static String[] staticArrayOfStrings() {
        return new String[]{"a", "bb", "bb", "c", "abc", "a", "a"};
    }

    /**
     * Get random array of strings.
     */
    public static String[] randomArrayOfStrings(int arrayLength, int maxStringLength) {
        var randomStringArray = new String[arrayLength];
        for (int i = 0; i < randomStringArray.length; i++) {
            randomStringArray[i] = randomString(maxStringLength);
        }

        return randomStringArray;
    }

    /**
     * Get random string.
     */
    private static String randomString(int maxLength) {
        var resultString = "";
        for (int i = 0; i < random.nextInt(maxLength); i++) {
            var character = random.nextInt(ALPHA_NUMERIC_STRING.length());
            // String concat with '+' is more efficient then StringBuilder in Java 9+
            resultString += ALPHA_NUMERIC_STRING.charAt(character);
        }

        return resultString;
    }
}
