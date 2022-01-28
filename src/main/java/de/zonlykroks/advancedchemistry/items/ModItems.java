package de.zonlykroks.advancedchemistry.items;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.zonlykroks.advancedchemistry.items.enums.Phase;
import de.zonlykroks.advancedchemistry.items.enums.Type;
import lombok.NoArgsConstructor;
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

    public static ElementItem hydrogen = new ElementItem(1,"Hydrogen", "H",1.007,0,1,1,1,1,Phase.GAS,false,true,false,true,false,Type.NONMETAL,0.79,2.2,13.5984,0.0000899,14.175,20.28,3,"Cavendish", 1766,14.304,1,1);

    public static ElementItem helium = new ElementItem(2,"Helium", "He",4.002,2,2,2,1,18,Phase.GAS,false,true,false,true,false,Type.NOBLE_GAS,0.49,0,24.22,0.000179,0,4.22,5,"Janssen", 1868,5.193,1,0);

    public static ElementItem lithium = new ElementItem(3,"Lithium", "Li", 6.941,4,3,3,2,1,Phase.SOLID,false,true,true,false,false,Type.ALKALI_METAL,2.1,0.98,5.3917,0.534,453.85,1615,5,"Arfvedson", 1817,3.582,2,1);

    public static ElementItem beryllium = new ElementItem(4, "Beryllium", "Be",9.012,5,4,4,2,2,Phase.SOLID,false,true,true,false,false,Type.ALKALI_EARTH_METAL,1.4,1.57,9.3227,1.85,1560.15,2742,6,"Vaulquelin", 1798, 1.825,2,2);

    public static ElementItem boron = new ElementItem(5,"Boron", "B",10.811,6,5,5,2,13,Phase.SOLID,false,true,false,false,true,Type.METALLOID,1.2,2.04,8.298,2.34,2573.15,4200,6,"Gay-Lussac",1808,1.026,2,3);

    public static ElementItem carbon = new ElementItem(6,"Carbon", "C", 12.011,6,6,6,2,14,Phase.SOLID,false,true,false,true,false,Type.NONMETAL,0.91,2.55,11.2603,2.26,3948.15,4300,7,"Prehistoric",0,0.709,2,4);

}
