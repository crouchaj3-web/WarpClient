package dev.warp.client;

final class WarpFeatures {
    static boolean fps = true;
    static boolean coordinates = true;
    static boolean keystrokes = true;
    static boolean watermark = true;

    static void toggle(String id) {
        switch (id) {
            case "fps" -> fps = !fps;
            case "coordinates" -> coordinates = !coordinates;
            case "keystrokes" -> keystrokes = !keystrokes;
            case "watermark" -> watermark = !watermark;
        }
    }

    static boolean enabled(String id) {
        return switch (id) {
            case "fps" -> fps;
            case "coordinates" -> coordinates;
            case "keystrokes" -> keystrokes;
            case "watermark" -> watermark;
            default -> false;
        };
    }

    private WarpFeatures() {}
}
