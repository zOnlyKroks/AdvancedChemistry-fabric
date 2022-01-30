package de.zonlykroks.advancedchemistry.items;

import com.google.gson.*;
import de.zonlykroks.advancedchemistry.items.enums.Phase;
import de.zonlykroks.advancedchemistry.items.enums.Type;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElementItem extends ItemBase implements IChemical{

    private int atomicNumber;
    private double atomicMass;
    public String internalName;
    public String symbol;

    public int numberOfNeutrons;
    public int numberOfProtons;
    public int numberOfElectrons;

    public int period;
    public int group;
    public Phase phase;

    public boolean radioactive;
    public boolean natural;
    public boolean metal;
    public boolean nonMetal;
    public boolean metalliod;

    //https://gist.github.com/GoodmanSciences/c2dd862cd38f21b0ad36b8f96b4bf1ee
    public Type type;

    public double atomicRadius;
    public double electronegativity;
    public double firstIonization;
    public double density;
    public double meltingPoint;
    public double boilingPoint;
    public double numberOfIsotopes;
    public String discoverer;
    public int year;
    public double specificHeat;
    public int numberOfShells;
    public int numberOfValance;

    public ElementItem(int atomicNumber, String elementName, String symbol, double atomicMass, int numberOfNeutrons, int numberOfProtons, int numberOfElectrons, int period, int group, Phase phase, boolean radioactive, boolean natural, boolean metal, boolean nonMetal, boolean metalloid, Type type, double atomicRadius, double electroNegativity, double firstIonization, double density, double meltingPoint, double boilingPoint, double numberOfIsotopes, String discoverer, int year, double specificHeat, int numberOfShells, int numberOfValence) {
        super(elementName, new FabricItemSettings());
        this.atomicNumber = atomicNumber;
        this.internalName = elementName;
        this.symbol = symbol;
        this.atomicMass = atomicMass;
        this.numberOfNeutrons = numberOfNeutrons;
        this.numberOfProtons = numberOfProtons;
        this.numberOfElectrons = numberOfElectrons;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.radioactive = radioactive;
        this.natural = natural;
        this.metal = metal;
        this.nonMetal = nonMetal;
        this.metalliod = metalloid;
        this.type = type;
        this.atomicRadius = atomicRadius;
        this.electronegativity = electroNegativity;
        this.firstIonization = firstIonization;
        this.density = density;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.numberOfIsotopes = numberOfIsotopes;
        this.discoverer = discoverer;
        this.year = year;
        this.specificHeat = specificHeat;
        this.numberOfShells = numberOfShells;
        this.numberOfValance = numberOfValence;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.advancedchemistry." + getChemicalName() + ".tooltip").formatted(Formatting.GRAY));
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    @Override
    public String getAbbreviation() {
        return this.symbol;
    }

    @Override
    public String getChemicalName() {
        return this.internalName;
    }
}
