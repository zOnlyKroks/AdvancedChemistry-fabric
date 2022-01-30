package de.zonlykroks.advancedchemistry;

import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.tileentities.ModScreenHandlers;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.gui.ChemicalReactorScreen;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.recipe.ChemicalReactorRecipe;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.recipe.ChemicalReactorRecipeSerializer;
import de.zonlykroks.advancedchemistry.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AdvancedChemistry implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("advancedchemistry", "general"),
            () -> new ItemStack(Blocks.COBBLESTONE));

    public static RecipeType recipeType;
    public static RecipeSerializer recipeSerializer;

    @Override
    public void onInitialize() {
        ModItems items = new ModItems();
        ModBlocks blocks = new ModBlocks();
        ModScreenHandlers screenHandlers = new ModScreenHandlers();
        ScreenRegistry.register(ModScreenHandlers.chemicalReactorScreenHandlerScreenHandlerType, ChemicalReactorScreen::new);

        //TODO: Input Amounts!!!!
        recipeSerializer = Registry.register(Registry.RECIPE_SERIALIZER, ChemicalReactorRecipeSerializer.ID,
                ChemicalReactorRecipeSerializer.INSTANCE);
        recipeType = Registry.register(Registry.RECIPE_TYPE, new Identifier("advancedchemistry", ChemicalReactorRecipe.Type.ID), ChemicalReactorRecipe.Type.INSTANCE);
    }
}
