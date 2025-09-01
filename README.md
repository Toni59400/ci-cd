# Calculator (Maven + JUnit 4)

Projet Maven minimal propre pour valider TP3/TP4 avec Jenkins.

## Structure
```
calculator/
├─ pom.xml
├─ src/
│  ├─ main/java/com/toni/Calculator.java
│  └─ test/java/com/toni/CalculatorTest.java
```

## Build local
```bash
mvn clean test package
```
Les rapports de tests sont générés dans `target/surefire-reports/`.

## Jenkins (Freestyle)
- Source Code Management: Git (branche `*/main`)
- Build step: **Invoke top-level Maven targets** → `clean test package`
- Post-build actions:
  - **Publish JUnit test result report**: `target/surefire-reports/*.xml`
  - **Archive the artifacts**: `target/*.jar`

## Jenkins (Pipeline) — optionnel
Place ce fichier `Jenkinsfile` à la racine et crée un job Pipeline "script from SCM".
