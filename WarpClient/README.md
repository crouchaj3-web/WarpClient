# Warp Client

A purple-themed, client-side Fabric mod starter for Minecraft Java 1.21.11.

## Features
- Purple/black Warp ClickGUI
- Press **Right Shift** to open or close the UI
- Toggleable Warp watermark, FPS counter, coordinates, and WASD keystrokes HUD
- Client-side HUD and settings only

## Build the Modrinth upload JAR
Modrinth uploads need the compiled `.jar` file, not this source ZIP.

1. Install **Java 21**.
2. Open this folder in IntelliJ IDEA and import it as a Gradle project.
3. Let Gradle download the Fabric/Minecraft dependencies.
4. Run the Gradle task **build** (or run `gradle build` in a terminal with Gradle installed).
5. Find the compiled mod at `build/libs/warp-client-1.0.0.jar`.
6. Test it in a Fabric 1.21.11 profile with Fabric API installed.
7. On Modrinth, create a project, choose **Client-side** and **Fabric**, then upload that JAR as a version.

## Included files
- `fabric.mod.json`: Fabric mod metadata, including the Warp icon and MIT license
- `src/main/resources/icon.png`: Warp purple icon
- `LICENSE`: MIT license
- `CHANGELOG.md`: release notes

This archive is the complete mod source project. It is not a compiled JAR.
