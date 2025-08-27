package org.example.validator;

import java.util.Locale;

public final class PasswordValidator {

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
        String[] passwords = {"password", "Passwort1", "12345678", "Aa345678"};
        for (String pass :  passwords) {
            if (p.equals(pass.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    // Bonus:
    public static boolean containsSpecialChar(String password, String allowed) {
        return false;
    }

    // Optionale Gesamtsicht:
    // nutzt die obenstehenden Checks
    public static boolean isValid(String password) {
        return false;
    }
}
