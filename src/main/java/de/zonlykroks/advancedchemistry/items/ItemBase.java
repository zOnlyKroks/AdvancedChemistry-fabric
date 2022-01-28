package de.zonlykroks.advancedchemistry.items;

import de.zonlykroks.advancedchemistry.AdvancedChemistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemBase extends Item {

    public ItemBase(String name, Settings settings) {
        super(settings.group(AdvancedChemistry.ITEM_GROUP));
        Registry.register(Registry.ITEM, new Identifier("advancedchemistry", name), this);
        ModItems.elements.add(this);
    }
}
