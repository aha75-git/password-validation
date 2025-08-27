package org.example.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldReturnTrue_whenMinLength() {
        assertTrue(PasswordValidator.hasMinLength("Abc1defg", 8));
    }

    @Test
    void hasMinLength_shouldReturnTrue_whenLargerMinLength() {
        assertTrue(PasswordValidator.hasMinLength("Abc1defgrrh", 8));
    }

    @Test
    void hasMinLength_shouldReturnFalse_whenLessMinLength() {
        assertFalse(PasswordValidator.hasMinLength("Abc1def", 8));
    }

    @Test
    @SuppressWarnings("all")
    void isPasswordEmpty_shouldReturnTrue_whenPasswordIsNull() {
        assertTrue(PasswordValidator.isPasswordEmpty(null));
    }

    @Test
    void isPasswordEmpty_shouldReturnTrue_whenPasswordIsEmpty() {
        assertTrue(PasswordValidator.isPasswordEmpty(""));
    }

    @Test
    void isPasswordEmpty_shouldReturnFalse_whenPasswordIsNotEmpty() {
        assertFalse(PasswordValidator.isPasswordEmpty("Abc1def"));
        assertFalse(PasswordValidator.hasMinLength(null, 8));
    }

    @Test
    void hasLeadingTrailingSpaces_shouldReturnTrue_whenPasswordHasLeadingTrailingSpaces() {
        assertTrue(PasswordValidator.hasLeadingTrailingSpaces(" Abc1defg"));
        assertTrue(PasswordValidator.hasLeadingTrailingSpaces("Abc1defg "));
        assertTrue(PasswordValidator.hasLeadingTrailingSpaces(" Abc1defg "));
    }

    @Test
    void hasLeadingTrailingSpaces_shouldReturnFalse_whenPasswordHasNotLeadingTrailingSpaces() {
        assertFalse(PasswordValidator.hasLeadingTrailingSpaces("Abc1defg"));
    }

    @Test
    void containsDigit_shouldReturnTrue_whenPasswordContainsDigit() {
        assertTrue(PasswordValidator.containsDigit("Abc1defg"));
        assertTrue(PasswordValidator.containsDigit("Abc1defg22"));
    }

    @Test
    void containsDigit_shouldReturnFalse_whenPasswordNotContainsDigit() {
        assertFalse(PasswordValidator.containsDigit("Abcdefg"));
    }

    @Test
    void containsUpperAndLower_shouldReturnTrue_whenPasswordContainsUpperAndLower() {
        assertTrue(PasswordValidator.containsUpperAndLower("Abc1defg"));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenPasswordContainsOnlyUpper() {
        assertFalse(PasswordValidator.containsUpperAndLower("ABCDEFG1"));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenPasswordContainsOnlyLower() {
        assertFalse(PasswordValidator.containsUpperAndLower("abc1defg"));
    }

    @Test
    void isCommonPassword_shouldReturnTrue_whenPasswordIsCommon() {
        assertTrue(PasswordValidator.isCommonPassword("Passwort1"));
        assertTrue(PasswordValidator.isCommonPassword("PASSWORD"));
    }

    @Test
    void containsSpecialChar() {
    }

    @Test
    void isValid() {
    }
}