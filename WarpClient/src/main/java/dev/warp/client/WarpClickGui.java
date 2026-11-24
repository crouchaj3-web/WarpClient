package dev.warp.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class WarpClickGui extends Screen {
    private static final int PURPLE = 0xFFAA72FF;
    private static final int PANEL = 0xF0181425;
    private static final int ROW = 0xFF292039;
    private static final int TEXT = 0xFFFFFFFF;
    private static final String[] IDS = {"watermark", "fps", "coordinates", "keystrokes"};
    private static final String[] NAMES = {"Warp watermark", "FPS counter", "Coordinates", "Keystrokes"};

    public WarpClickGui() {
        super(Component.literal("Warp"));
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float delta) {
        this.renderBackground(g, mouseX, mouseY, delta);

        int cx = this.width / 2;
        int left = cx - 112;
        int top = this.height / 2 - 91;

        g.fill(left, top, left + 224, top + 182, PANEL);
        g.fill(left, top, left + 224, top + 2, PURPLE);
        g.drawCenteredString(this.font, "W A R P", cx, top + 13, TEXT);
        g.drawCenteredString(this.font, "CLIENT SETTINGS", cx, top + 29, 0xFFD7B8FF);

        for (int i = 0; i < IDS.length; i++) {
            int y = top + 51 + i * 29;
            boolean enabled = WarpFeatures.enabled(IDS[i]);
            g.fill(left + 12, y, left + 212, y + 23, ROW);
            g.drawString(this.font, NAMES[i], left + 20, y + 8, TEXT, false);

            int color = enabled ? 0xFF7540B8 : 0xFF554E60;
            g.fill(left + 171, y + 5, left + 204, y + 18, color);
            g.drawCenteredString(this.font, enabled ? "ON" : "OFF", left + 187, y + 8, TEXT);
        }

        g.drawCenteredString(this.font, "Right Shift: open/close  •  Click a row to toggle",
                cx, top + 165, 0xFFB9A9CC);
        super.render(g, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int left = this.width / 2 - 112;
            int top = this.height / 2 - 91;
            for (int i = 0; i < IDS.length; i++) {
                int y = top + 51 + i * 29;
                if (mouseX >= left + 12 && mouseX <= left + 212
                        && mouseY >= y && mouseY <= y + 23) {
                    WarpFeatures.toggle(IDS[i]);
                    return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
