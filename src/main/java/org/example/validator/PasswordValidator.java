package org.example.validator;

import org.jetbrains.annotations.NotNull;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class PasswordValidator {

    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrsßtuvwxyz";
    private static final String ALPHABET_NUMBERS = "0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();


    public static boolean hasLeadingTrailingSpaces(String password) {
        return password.length() != password.trim().length();
    }

    public static boolean isPasswordEmpty(String password) {
        return password == null || password.isEmpty();
    }

    public static boolean hasMinLength(String password, int min) {
        if (isPasswordEmpty(password)) {
            return false;
        }
        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }

    // kleine interne Liste
    public static boolean isCommonPassword(String password) {
        String p = password == null ? "" : password.trim().toLowerCase(Locale.ROOT);
        for (String pass :  getCommonPasswords()) {
            if (p.equals(pass.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    // Bonus:
    public static boolean containsSpecialChar(String password, String allowed) {
        //String s = ".*[" + allowed + "].*";
        //return password.matches(s);

        char[] allowedChars = allowed.toCharArray();

        // Überprüfe jedes Zeichen im Passwort
        for (char c : password.toCharArray()) {
            for (char allowedChar : allowedChars) {
                if (c == allowedChar) {
                    return true; // Sonderzeichen gefunden
                }
            }
        }
        return false;
    }

    // Optionale Gesamtsicht:
    // nutzt die obenstehenden Checks
    public static boolean isValid(String password) {
        return !isPasswordEmpty(password) &&
                !hasLeadingTrailingSpaces(password) &&
                !isCommonPassword(password) &&
                hasMinLength(password, 8) &&
                containsDigit(password) &&
                containsUpperAndLower(password);
    }

    public static boolean isValid(String password, String allowed) {
        return isValid(password) && containsSpecialChar(password, allowed);
    }

    private static @NotNull Set<String> getCommonPasswords () {
        Set<String> commonPasswords = new HashSet<>();
        commonPasswords.add("Passwort1");
        commonPasswords.add("password");
        commonPasswords.add("12345678");
        commonPasswords.add("Aa345678");
        return commonPasswords;
    }


    public static String generateSecurePassword(int length, String allowedSpecials) {
        if (length < 8) {
            throw new IllegalArgumentException("Das Passwort muss mindestens 8 Zeichen lang sein.");
        }
        StringBuilder securePassword = new StringBuilder();
        for (int i = 0; i < length; i+=4) {
            securePassword.append(getRandomCharacterUpper());
            securePassword.append(getRandomCharacterOfSpecialCharacter(allowedSpecials));
            securePassword.append(getRandomCharacterLower());
            securePassword.append(getRandomCharacterNumber());
        }
        return securePassword.toString();
    }

    private static char getRandomCharacterUpper() {
        return ALPHABET_UPPER.charAt(SECURE_RANDOM.nextInt(ALPHABET_UPPER.length()));
    }

    private static char getRandomCharacterLower() {
        return ALPHABET_LOWER.charAt(SECURE_RANDOM.nextInt(ALPHABET_LOWER.length()));
    }

    private static char getRandomCharacterNumber() {
        return ALPHABET_NUMBERS.charAt(SECURE_RANDOM.nextInt(ALPHABET_NUMBERS.length()));
    }

    private static char getRandomCharacterOfSpecialCharacter(String allowedSpecials) {
        return allowedSpecials.charAt(SECURE_RANDOM.nextInt(allowedSpecials.length()));
    }
}
