package dev.warp.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

final class WarpHud {
    private static final int WHITE = 0xFFFFFFFF;
    private static final int PANEL = 0xC0181425;
    private static final int PURPLE = 0xFFAA72FF;
    private static final int MUTED_PURPLE = 0xFFD7B8FF;

    static void render(GuiGraphics g, DeltaTracker tickCounter) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) return;

        int y = 8;
        if (WarpFeatures.watermark) {
            panel(g, 8, y, 104, 19);
            g.fill(8, y, 10, y + 19, PURPLE);
            g.drawString(mc.font, Component.literal("WARP"), 16, y + 6, WHITE, false);
            y += 24;
        }
        if (WarpFeatures.fps) {
            String s = "FPS  " + mc.getFps();
            panel(g, 8, y, mc.font.width(s) + 14, 18);
            g.drawString(mc.font, s, 14, y + 5, MUTED_PURPLE, false);
            y += 22;
        }
        if (WarpFeatures.coordinates) {
            String s = String.format("XYZ  %.1f  %.1f  %.1f",
                    mc.player.getX(), mc.player.getY(), mc.player.getZ());
            panel(g, 8, y, mc.font.width(s) + 14, 18);
            g.drawString(mc.font, s, 14, y + 5, MUTED_PURPLE, false);
        }
        if (WarpFeatures.keystrokes) {
            int x = 8;
            int ky = mc.getWindow().getGuiScaledHeight() - 58;
            key(g, mc, x + 22, ky, "W", mc.options.keyUp.isDown());
            key(g, mc, x, ky + 20, "A", mc.options.keyLeft.isDown());
            key(g, mc, x + 22, ky + 20, "S", mc.options.keyDown.isDown());
            key(g, mc, x + 44, ky + 20, "D", mc.options.keyRight.isDown());
        }
    }

    private static void key(GuiGraphics g, Minecraft mc, int x, int y, String label, boolean down) {
        int bg = down ? 0xFF7540B8 : PANEL;
        g.fill(x, y, x + 20, y + 18, bg);
        g.fill(x, y, x + 20, y + 1, PURPLE);
        int tx = x + (20 - mc.font.width(label)) / 2;
        g.drawString(mc.font, label, tx, y + 5, WHITE, false);
    }

    private static void panel(GuiGraphics g, int x, int y, int w, int h) {
        g.fill(x, y, x + w, y + h, PANEL);
        g.fill(x, y, x + w, y + 1, 0xFF7540B8);
    }

    private WarpHud() {}
}
