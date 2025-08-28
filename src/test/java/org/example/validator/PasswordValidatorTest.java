package org.example.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    /*
     *  Mindestlänge
     */

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


    /*
     *  Passwort ist leer/null, führende/abschließende Leerzeichen
     */

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


    /*
     *  Ziffer enthalten
     */

    @Test
    void containsDigit_shouldReturnTrue_whenPasswordContainsDigit() {
        assertTrue(PasswordValidator.containsDigit("Abc1defg"));
        assertTrue(PasswordValidator.containsDigit("Abc1defg22"));
    }

    @Test
    void containsDigit_shouldReturnFalse_whenPasswordNotContainsDigit() {
        assertFalse(PasswordValidator.containsDigit("Abcdefg"));
    }


    /*
     *  Groß und Kleinbuchstaben
     */

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


    /*
     *  Häufige Passwörter
     */

    @Test
    void isCommonPassword_shouldReturnTrue_whenPasswordIsCommon() {
        assertTrue(PasswordValidator.isCommonPassword("Passwort1"));
        assertTrue(PasswordValidator.isCommonPassword("PASSWORD"));
    }

    @Test
    void isCommonPassword_shouldReturnFalse_whenPasswordIsNotCommon() {
        assertFalse(PasswordValidator.isCommonPassword("Abc44zzudA##"));
        assertFalse(PasswordValidator.isCommonPassword("sfd5gdg?dsAA6"));
    }


    /*
     *  Sonderzeichen
     */

    @Test
    void containsSpecialChar_shouldReturnTrue_whenPasswordContainsAllowedSpecialChar() {
        assertTrue(PasswordValidator.containsSpecialChar("sfd;B5gdg?dsAA6#", "!@#$%^&*()-_+=?.,;:"));
    }

    @Test
    void containsSpecialChar_shouldReturnFalse_whenPasswordNotContainsAllowedSpecialChar() {
        assertFalse(PasswordValidator.containsSpecialChar("sfdB5gdgdsAA6", "!@#$%^&*()-_+=?.,;:"));
    }

    /*
     *  Gesamte Validierung ohne Sonderzeichen
     */

    @Test
    void isValid_shouldReturnTrue_whenPasswordIsValid() {
        assertTrue(PasswordValidator.isValid("sfdB5gdg?dsAA6"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsCommon() {
        assertFalse(PasswordValidator.isValid("Passwort1"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsEmpty() {
        assertFalse(PasswordValidator.isValid(""));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsNull() {
        assertFalse(PasswordValidator.isValid(null));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordHasLeadingTrailingSpaces() {
        assertFalse(PasswordValidator.isValid(" sfdB5gdg?dsAA6"));
        assertFalse(PasswordValidator.isValid(" sfdB5gdg?dsAA6 "));
        assertFalse(PasswordValidator.isValid("sfdB5gdg?dsAA6 "));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordHasLessMinLength() {
        assertFalse(PasswordValidator.isValid("g?dsAA6"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordNotContainsDigit() {
        assertFalse(PasswordValidator.isValid("g?dsAAvvH"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordNotContainsUpper() {
        assertFalse(PasswordValidator.isValid("g?dsaa77vvaf"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordNotContainsLower() {
        assertFalse(PasswordValidator.isValid("G?DSAA77VVAF"));
    }


    /*
     *  Gesamte Validierung mit Sonderzeichen
     */
    @Test
    void isValid_shouldReturnTrue_whenPasswordIsValidAndContainsAllowedSpecialChar() {
        assertTrue(PasswordValidator.isValid("sfd;B5gdg?dsAA6#", "!@#$%^&*()-_+=?.,;:"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordNotContainsAllowedSpecialChar() {
        assertFalse(PasswordValidator.isValid("sfdB5gdgdsAA6", "!@#$%^&*()-_+=?.,;:"));
        assertFalse(PasswordValidator.isValid("sfdB5{gdgds}AA6", "!@#$%^&*()-_+=?.,;:"));
    }


    /*
     *  Bonuspaket
     */

    @Test
    void generateSecurePassword_shouldGenerateSecurePassword() {
        String password = PasswordValidator.generateSecurePassword( 8, "!@#$%^&*()-_+=?.,;:");
        assertTrue(PasswordValidator.isValid(password, "!@#$%^&*()-_+=?.,;:"), password);
    }

    @Test
    void generateSecurePassword_shouldThrowException_whenLengthIsLessThan8() {
        //String password = PasswordValidator.generateSecurePassword( 7, "!@#$%^&*()-_+=?.,;:");
        assertThrows(IllegalArgumentException.class, () -> PasswordValidator.generateSecurePassword( 7, "!@#$%^&*()-_+=?.,;:"));
    }


    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsValid() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfd;B5gdg?dsAA6#", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.isValid());
    }

    @Test
    void validatePassword_shouldReturnFalse_whenPasswordIsNotValid() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfd;B5gdg?dsAA6#{[}", "!@#$%^&*()-_+=?.,;:");
        assertFalse(validationResult.isValid());
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonIsEmpty() {
        ValidationResult validationResult = PasswordValidator.validatePassword("", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.IS_EMPTY));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonLeadingTrailingSpaces() {
        String allowed = "!@#$%^&*()-_+=?.,;:";
        // Test 1
        ValidationResult validationResult = PasswordValidator.validatePassword(" sfd;B5gdg?dsAA6#", allowed);
        assertTrue(validationResult.getReasons().contains(Reason.LEADING_TRAILING_SPACES));

        // Test 2
        validationResult = PasswordValidator.validatePassword(" sfd;B5gdg?dsAA6# ", allowed);
        assertTrue(validationResult.getReasons().contains(Reason.LEADING_TRAILING_SPACES));

        // Test 3
        validationResult = PasswordValidator.validatePassword("sfd;B5gdg?dsAA6# ", allowed);
        assertTrue(validationResult.getReasons().contains(Reason.LEADING_TRAILING_SPACES));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonToShort() {
        ValidationResult validationResult = PasswordValidator.validatePassword("B5gdg?", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.TOO_SHORT));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonNoLowercase() {
        ValidationResult validationResult = PasswordValidator.validatePassword("SFD;B5GDG?DSAA6#", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.NO_LOWERCASE));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonNoUppercase() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfd;b5gdg?dsaa6#", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.NO_UPPERCASE));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonNoDigit() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfd;bgdg?dsaa#", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.NO_DIGIT));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonWeakPassword() {
        ValidationResult validationResult = PasswordValidator.validatePassword("Passwort1", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.WEAK_PASSWORD));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonWrongSpecialChar() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfd;B5gdg?dsAA6#{[}", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.WRONG_SPECIAL_CHAR));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndReasonNoSpecialChar() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfdB5gdgdsAA6", "!@#$%^&*()-_+=?.,;:");
        assertTrue(validationResult.getReasons().contains(Reason.NO_SPECIAL_CHAR));
    }

    @Test
    void validatePassword_shouldReturnTrue_whenPasswordIsNotValidAndHasSomeReasons() {
        ValidationResult validationResult = PasswordValidator.validatePassword("sfdg ", "!@#$%^&*()-_+=?.,;:");
        boolean result = validationResult.getReasons().contains(Reason.NO_DIGIT) &&
                validationResult.getReasons().contains(Reason.NO_SPECIAL_CHAR) &&
                validationResult.getReasons().contains(Reason.LEADING_TRAILING_SPACES) &&
                validationResult.getReasons().contains(Reason.NO_UPPERCASE) &&
                validationResult.getReasons().contains(Reason.TOO_SHORT);

        assertTrue(result);
    }
}