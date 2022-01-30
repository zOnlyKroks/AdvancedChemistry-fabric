package de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ChemicalReactorRecipeSerializer implements RecipeSerializer<ChemicalReactorRecipe> {

    private ChemicalReactorRecipeSerializer() {
    }

    public static final ChemicalReactorRecipeSerializer INSTANCE = new ChemicalReactorRecipeSerializer();

    public static final Identifier ID = new Identifier("advancedchemistry:chemical_reactor_recipe");

    @Override
    public ChemicalReactorRecipe read(Identifier id, JsonObject json) {
        ExampleRecipeJsonFormat recipeJson = new Gson().fromJson(json, ExampleRecipeJsonFormat.class);
        // Validate all fields are there
        if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }
        // We'll allow to not specify the output, and default it to 1.
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                // Validate the inputted item actually exists
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new ChemicalReactorRecipe(inputA, inputB, output, id);
    }

    @Override
    public ChemicalReactorRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient inputA = Ingredient.fromPacket(buf);
        Ingredient inputB = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new ChemicalReactorRecipe(inputA, inputB, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, ChemicalReactorRecipe recipe) {
        recipe.getInputA().write(buf);
        recipe.getInputB().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }

    class ExampleRecipeJsonFormat {
        JsonObject inputA;
        JsonObject inputB;
        String outputItem;
        int outputAmount;
    }
}
