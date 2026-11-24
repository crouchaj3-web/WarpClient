package dev.warp.client;

final class WarpFeatures {
    static boolean fps = true;
    static boolean coordinates = true;
    static boolean keystrokes = true;
    static boolean watermark = true;

    static boolean blockEsp = false;
    static boolean xray = false;
    static boolean entityEsp = false;
    static boolean fullbright = false;

    static void toggle(String id) {
        switch (id) {
            case "fps" -> fps = !fps;
            case "coordinates" -> coordinates = !coordinates;
            case "keystrokes" -> keystrokes = !keystrokes;
            case "watermark" -> watermark = !watermark;
            case "blockesp" -> blockEsp = !blockEsp;
            case "xray" -> xray = !xray;
            case "entityesp" -> entityEsp = !entityEsp;
            case "fullbright" -> fullbright = !fullbright;
        }
    }

    static boolean enabled(String id) {
        return switch (id) {
            case "fps" -> fps;
            case "coordinates" -> coordinates;
            case "keystrokes" -> keystrokes;
            case "watermark" -> watermark;
            case "blockesp" -> blockEsp;
            case "xray" -> xray;
            case "entityesp" -> entityEsp;
            case "fullbright" -> fullbright;
            default -> false;
        };
    }

    private WarpFeatures() {}
}
