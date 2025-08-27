# Passwort-Validator

## Projektbeschreibung
Dieses Projekt ist ein Passwort-Validator, der sicherstellt, 
dass Passwörter bestimmten Sicherheitsanforderungen entsprechen. 
Es überprüft, ob Passwörter sowohl Groß- als auch Kleinbuchstaben, 
Ziffern und optionale Sonderzeichen enthalten.

## Passwort-Policy:
Um die Sicherheit unserer Systeme und Daten zu gewährleisten, 
haben wir die folgende Passwort-Policy definiert. 
Diese Policy legt die Mindestanforderungen für Passwörter fest, 
die von allen Benutzern eingehalten werden müssen.

- **Muss-Kriterien**:

  - mindestens 8 Zeichen,
  - mindestens eine Ziffer (0–9),
  - Groß- und Kleinbuchstaben (beides muss vorkommen),
  - nicht in einer Liste häufiger/schwacher Passwörter.


- **Optional (Bonus-Policy)**:

  - mindestens ein Sonderzeichen: `!@#$%^&*()-_+=?.,;:`
  - Mindestanzahl unterschiedlicher Zeichengruppen (z. B. 3 von 4: Groß, Klein, Ziffer, Sonderzeichen).

## Build/Run/Tests:
### Lokal
Um das Projekt lokal zu bauen und die Tests auszuführen, verwende den folgenden Befehl:

```bash
mvn clean verify
```
### Artefakt
Um das JAR-Artefakt zu erstellen, führe den folgenden Befehl aus:
```bash
mvn package
```
Das Artefakt wird im Verzeichnis target/ gespeichert und hat die Endung .jar.
```markdown
target/*.jar
```
## CI-Status-Badge (Actions)
Ein Badge, das den Status der Continuous Integration (CI) anzeigt.

## Beispiel-Aufrufe

Hier sind einige Beispielaufrufe für die Verwendung des Passwort-Validators:

```java
public class Main {
    public static void main(String[] args) {
        String password = "Test@1234";
        boolean isValid = PasswordValidator.isValid(password);
        System.out.println("Ist das Passwort gültig? " + isValid);
    }
}
```

