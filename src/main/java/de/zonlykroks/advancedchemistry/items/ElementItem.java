package de.zonlykroks.advancedchemistry.items;

import com.google.gson.*;
import de.zonlykroks.advancedchemistry.items.enums.Phase;
import de.zonlykroks.advancedchemistry.items.enums.Type;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ElementItem extends ItemBase{

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


    /*@Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!(entity instanceof PlayerEntity)) return;
        System.out.println(stack.getItem() + "");
        if(stack.getItem() != ModItems.hydrogen) return;

        int i = 1;
        while(i <= 9) {
            ItemStack stack1 = ((PlayerEntity) entity).getInventory().getStack(i);
            if(stack1.getItem() == Items.FLINT_AND_STEEL) {
                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();
                world.createExplosion(entity, x,y,z, 2, Explosion.DestructionType.BREAK);
                stack.setCount(0);
            }
            i++;
        }
    }*/

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.advancedchemistry." + getInternalName() + ".tooltip").formatted(Formatting.GRAY));
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getInternalName() {
        return internalName;
    }
}
