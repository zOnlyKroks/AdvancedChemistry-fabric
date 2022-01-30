package de.zonlykroks.advancedchemistry.items.item.periodicsystem;

import de.zonlykroks.advancedchemistry.AdvancedChemistry;
import de.zonlykroks.advancedchemistry.gui.PeriodicSystemGui;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class PeriodicSystemItem extends Item {

    public PeriodicSystemItem() {
        super(new FabricItemSettings().group(AdvancedChemistry.ITEM_GROUP));
        Registry.register(Registry.ITEM, new Identifier("advancedchemistry", "periodicsystemitem"), this);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new PeriodicSystemGui()));
        }
        return super.use(world, user, hand);
    }
}
