@echo off
if not exist gradlew.bat (
  echo Gradle wrapper is not included. Open this folder in IntelliJ IDEA and use its Gradle integration,
  or install Gradle and run: gradle build
  pause
  exit /b 1
)
call gradlew.bat build
pause
