package org.example.validator;

public enum Reason {
    IS_EMPTY("Das Passwort darf nicht leer sein."),
    LEADING_TRAILING_SPACES("Das Passwort darf keine führende und abschließende Leerzeichen enthalten."),
    TOO_SHORT("Das Passwort muss mindestens 8 Zeichen lang sein."),
    NO_UPPERCASE("Das Passwort muss mindestens einen Großbuchstaben enthalten."),
    NO_LOWERCASE("Das Passwort muss mindestens einen Kleinbuchstaben enthalten."),
    NO_DIGIT("Das Passwort muss mindestens eine Ziffer enthalten."),
    NO_SPECIAL_CHAR("Das Passwort muss mindestens ein Sonderzeichen enthalten: !@#$%^&*()-_+=?.,;:"),
    WRONG_SPECIAL_CHAR("Das Passwort darf keine anderen Sonderzeichen außer aus der Liste der erlaubten enthalten: !@#$%^&*()-_+=?.,;:"),
    WEAK_PASSWORD("Das Passwort ist zu schwach und steht auf der Liste häufiger Passwörter.");

    private final String message;

    Reason(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}