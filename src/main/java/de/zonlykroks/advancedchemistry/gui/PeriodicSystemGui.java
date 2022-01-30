package de.zonlykroks.advancedchemistry.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PeriodicSystemGui extends LightweightGuiDescription{

    private final BackgroundPainter painter = (matrices, left, top, widget) -> ScreenDrawing.texturedRect(matrices, left, top, widget.getWidth(), widget.getHeight(), new Identifier("advancedchemistry", "textures/gui/periodic_table.png"), 0xFF_FFFFFF);

    WGridPanel root;

    public PeriodicSystemGui() {
        root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);
        root.validate(this);
    }

    @Override
    public void addPainters() {
        root.setBackgroundPainter(painter);
    }
}
