package de.zonlykroks.advancedchemistry.items;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.zonlykroks.advancedchemistry.items.enums.Phase;
import de.zonlykroks.advancedchemistry.items.enums.Type;
import lombok.NoArgsConstructor;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@NoArgsConstructor
public class ModItems {

    public static List<ItemBase> elements = new ArrayList<>();

    public static ElementItem hydrogen = new ElementItem(1,"hydrogen", "H",1.007,0,1,1,1,1,Phase.GAS,false,true,false,true,false,Type.NONMETAL,0.79,2.2,13.5984,0.0000899,14.175,20.28,3,"Cavendish", 1766,14.304,1,1);

    public static ElementItem helium = new ElementItem(2,"helium", "He",4.002,2,2,2,1,18,Phase.GAS,false,true,false,true,false,Type.NOBLE_GAS,0.49,0,24.22,0.000179,0,4.22,5,"Janssen", 1868,5.193,1,0);

    public static ElementItem lithium = new ElementItem(3,"lithium", "Li", 6.941,4,3,3,2,1,Phase.SOLID,false,true,true,false,false,Type.ALKALI_METAL,2.1,0.98,5.3917,0.534,453.85,1615,5,"Arfvedson", 1817,3.582,2,1);

    public static ElementItem beryllium = new ElementItem(4, "beryllium", "Be",9.012,5,4,4,2,2,Phase.SOLID,false,true,true,false,false,Type.ALKALI_EARTH_METAL,1.4,1.57,9.3227,1.85,1560.15,2742,6,"Vaulquelin", 1798, 1.825,2,2);

    public static ElementItem boron = new ElementItem(5,"boron", "B",10.811,6,5,5,2,13,Phase.SOLID,false,true,false,false,true,Type.METALLOID,1.2,2.04,8.298,2.34,2573.15,4200,6,"Gay-Lussac",1808,1.026,2,3);

    public static ElementItem carbon = new ElementItem(6,"carbon", "C", 12.011,6,6,6,2,14,Phase.SOLID,false,true,false,true,false,Type.NONMETAL,0.91,2.55,11.2603,2.26,3948.15,4300,7,"Prehistoric",0,0.709,2,4);

    public static ElementItem nitrogen = new ElementItem(7, "nitrogen", "N", 14.007,7,7,7,2,15,Phase.GAS,false,true,false,true,false,Type.NONMETAL,0.75,3.04, 14.5341,0.00215,63.29,77.36,8, "Rutherford", 1772,1.04,2,2);

    public static ElementItem oxygen = new ElementItem(8, "oxygen", "O", 15.999,8,8,8,2,16,Phase.GAS,false,true,false,true,false,Type.NONMETAL,0.65,3.44,14.6181,0.00143,50.5,90.2,8,"Priestley/Scheele", 1774,0.918,2,6);

    public static ElementItem flourine = new ElementItem(9,"flourine", "F", 18.998,10,9,9,2,17,Phase.GAS,false,true,false,true,false, Type.HALOGEN,0.57,3.98,17.4228,0.0017,53.63,85.03,6,"Moissan",1886,0.824,2,7);

    public static ElementItem neon = new ElementItem(10,"neon", "Ne",20.18,10,10,10,2,18,Phase.GAS,false,true,false,true,false,Type.NOBLE_GAS,0.51,0,21.5645,0.009,24.703,27.07,8,"Ramsay and Travers",1898,1.03,2,8);

    public static ElementItem sodium = new ElementItem(11,"sodium", "Na", 22.99,12,11,11,3,1,Phase.SOLID,false,true,true,false,false,Type.ALKALI_METAL,2.2,0.93,5.1391,0.971,371.15,1156,7,"Davy",1807,1.228,3,1);

    public static ElementItem magnesium = new ElementItem(12,"magnesium", "Mg",24.305,12,12,12,3,2,Phase.SOLID,false,true,true,false,false, Type.ALKALI_EARTH_METAL,1.7,1.31,7.6462,1.74,923.15,1363,8,"Black",1755, 1.023,3,2);

    public static ElementItem aluminum = new ElementItem(13, "aluminum", "Al", 26.982,14,13,13,3,13,Phase.SOLID,false,true,true,false,false,Type.METAL,1.8,1.61,5.9858,2.7,933.4,2792,8,"Wshler", 1827,0.897,3,3);

    public static ElementItem silicon = new ElementItem(14, "silicon", "Si", 28.086,13,13,13,3,14,Phase.SOLID,false,true,false,false,true,Type.METALLOID, 1.5, 1.9,8.1517,2.33,1683.15,3538,8,"Berzelius", 1824,0.705,3,4);

    public static ElementItem phosphorus = new ElementItem(15, "phosphorus","P", 30.974,16,16,15,3,15,Phase.SOLID,false,true,false,true,false,Type.NONMETAL, 1.2,2.19,10.4867,1.82,317.25,553,7,"Hennig Brand", 1669,0.769,3,5);

    public static ElementItem sulfur = new ElementItem(16,"sulfur", "S",32.065,16,16,16,3,16,Phase.SOLID,false,true,false,true,false,Type.NONMETAL,1.1,2.58,10.36,2.07,388.51,717.8,10,"Prehistoric",0,0.71,3,6);

    public static ElementItem chlorine = new ElementItem(17,"chlorine", "Cl", 35.453,18,17,17,3,17,Phase.GAS,false,true,false,true,false,Type.HALOGEN,0.97,3.16,12.9676, 0.00321, 172.31,239.11,11,"Scheele", 1774,0.479,3,7);

    public static ElementItem argon = new ElementItem(18,"argon", "Ar",39.948,22,18,18,3,18,Phase.GAS,false,true,false,true,false,Type.NOBLE_GAS,0.88,0,15.7597,0.00178,83.96,87.3,8,"Rayleigh and Ramsay", 1894,0.52,3,8);
}
