package org.example.validator;

public final class PasswordValidator {
    public static boolean hasMinLength(String password, int min) {
        return false;
    }

    public static boolean containsDigit(String password) {
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        return false;
    }

    // kleine interne Liste
    public static boolean isCommonPassword(String password) {
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
