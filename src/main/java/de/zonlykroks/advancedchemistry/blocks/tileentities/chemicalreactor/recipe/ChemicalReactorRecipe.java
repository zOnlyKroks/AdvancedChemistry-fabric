package de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.recipe;

import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.gui.ChemicalReactorScreen;
import lombok.Getter;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ChemicalReactorRecipe implements Recipe<SimpleInventory> {

    @Getter
    private final Ingredient inputA;
    @Getter
    private final Ingredient inputB;

    private final Identifier id;

    private final ItemStack outPutStack;

    private final int inputNumberA, inputNumberB;

    public ChemicalReactorRecipe(Ingredient inputA, Ingredient inputB,ItemStack outputStack, Identifier id, int inputNumberA, int inputNumberB) {
        this.id = id;
        this.inputA = inputA;
        this.inputB = inputB;
        this.outPutStack = outputStack;
        this.inputNumberA = inputNumberA;
        this.inputNumberB = inputNumberB;
    }

    @Override
    public boolean matches(SimpleInventory inv, World world) {
        if(inv.size() < 2) return false;
        return inputA.test(inv.getStack(0)) && inputB.test(inv.getStack(1));
    }

    public int getInputNumberA() {
        return inputNumberA;
    }

    public int getInputNumberB() {
        return inputNumberB;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return this.outPutStack;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ChemicalReactorRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ChemicalReactorRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "chemical_reactor_recipe";
    }
}
