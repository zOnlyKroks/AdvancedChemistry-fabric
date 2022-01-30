package de.zonlykroks.advancedchemistry.blocks.tileentities;

import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.gui.ChemicalReactorScreenHandler;
import lombok.NoArgsConstructor;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

@NoArgsConstructor
public class ModScreenHandlers {

    public static ScreenHandlerType<ChemicalReactorScreenHandler> chemicalReactorScreenHandlerScreenHandlerType =
            ScreenHandlerRegistry.registerSimple(new Identifier("advancedchemistry", "chemicalreactor"), ChemicalReactorScreenHandler::new);

}
