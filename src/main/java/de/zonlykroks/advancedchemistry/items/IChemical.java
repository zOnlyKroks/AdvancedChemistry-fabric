package de.zonlykroks.advancedchemistry.items;

import net.minecraft.item.Item;

public interface IChemical {

    Item asItem();

    String getAbbreviation();

    String getChemicalName();

}
