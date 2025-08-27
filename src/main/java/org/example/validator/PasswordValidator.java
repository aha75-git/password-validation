package org.example.validator;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

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
        for (String pass :  getCommonPasswords()) {
            if (p.equals(pass.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    // Bonus:
    // TODO
    public static boolean containsSpecialChar(String password, String allowed) {
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

    private static @NotNull Set<String> getCommonPasswords () {
        Set<String> commonPasswords = new HashSet<String>();
        commonPasswords.add("Passwort1");
        commonPasswords.add("password");
        commonPasswords.add("12345678");
        commonPasswords.add("Aa345678");
        return commonPasswords;
    }
}
