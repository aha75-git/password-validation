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
    void hasMinLength_shouldReturnFalse_whenPasswordIsNull() {
        assertFalse(PasswordValidator.hasMinLength("", 8));
        assertFalse(PasswordValidator.hasMinLength(null, 8));
    }

    @Test
    void hasMinLength_shouldReturnFalse_whenPasswordHasLeadingTrailingSpaces() {
        assertFalse(PasswordValidator.hasMinLength(" Abc1defg", 8));
        assertFalse(PasswordValidator.hasMinLength("Abc1defg ", 8));
        assertFalse(PasswordValidator.hasMinLength(" Abc1defg ", 8));
    }

    @Test
    void containsDigit() {
    }

    @Test
    void containsUpperAndLower() {
    }

    @Test
    void isCommonPassword() {
    }

    @Test
    void containsSpecialChar() {
    }

    @Test
    void isValid() {
    }
}