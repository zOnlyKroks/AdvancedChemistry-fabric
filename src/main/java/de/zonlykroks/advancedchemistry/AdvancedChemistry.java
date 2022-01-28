package de.zonlykroks.advancedchemistry;

import de.zonlykroks.advancedchemistry.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class AdvancedChemistry implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("advancedchemistry", "general"),
            () -> new ItemStack(Blocks.COBBLESTONE));

    @Override
    public void onInitialize() {
        ModItems items = new ModItems();
    }
}
