package de.zonlykroks.advancedchemistry.blocks;

import de.zonlykroks.advancedchemistry.AdvancedChemistry;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.ChemicalReactorBlock;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.ChemicalReactorTileEntity;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller.FractionTowerControllerBlock;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller.FractionTowerControllerBlockEntity;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.support.FractionTowerSupportBlock;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.support.FractionTowerSupportBlockEntity;
import lombok.NoArgsConstructor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

@NoArgsConstructor
public class ModBlocks {

    public static ChemicalReactorBlock reactorBlock = Registry.register(Registry.BLOCK, new Identifier("advancedchemistry", "chemicalreactor"), new ChemicalReactorBlock(FabricBlockSettings.of(Material.METAL)));
    public static BlockItem reactorBlockItem = Registry.register(Registry.ITEM, new Identifier("advancedchemistry", "reactorblockitem"), new BlockItem(reactorBlock, new FabricItemSettings().group(AdvancedChemistry.ITEM_GROUP)));

    public static BlockEntityType<ChemicalReactorTileEntity> chemicalReactorTileEntityBlockEntityType = Registry
            .register(Registry.BLOCK_ENTITY_TYPE, new Identifier("advancedchemistry", "chemicalreactor"), FabricBlockEntityTypeBuilder.create(ChemicalReactorTileEntity::new,reactorBlock).build(null));

    public void registerEnergy() {
        EnergyStorage.SIDED.registerForBlockEntity((ChemicalReactorTileEntity, direction) -> ChemicalReactorTileEntity.energyStorage, chemicalReactorTileEntityBlockEntityType);
    }


    public static FractionTowerControllerBlock fractionTowerControllerBlock = Registry.register(Registry.BLOCK, new Identifier("advancedchemistry", "fractrioncontroller"), new FractionTowerControllerBlock(FabricBlockSettings.of(Material.METAL)));
    public static BlockItem fractionControllerBlockItem = Registry.register(Registry.ITEM, new Identifier("advancedchemistry", "fractioncontrollerblockitem"), new BlockItem(fractionTowerControllerBlock, new FabricItemSettings().group(AdvancedChemistry.ITEM_GROUP)));
    public static BlockEntityType<FractionTowerControllerBlockEntity> fractionTowerControllerBlockEntityBlockEntityType = Registry
            .register(Registry.BLOCK_ENTITY_TYPE, new Identifier("advancedchemistry", "fractrioncontroller"), FabricBlockEntityTypeBuilder.create(FractionTowerControllerBlockEntity::new,fractionTowerControllerBlock).build(null));


    public static FractionTowerSupportBlock fractionTowerSupportBlock = Registry.register(Registry.BLOCK, new Identifier("advancedchemistry", "fractrionsupport"), new FractionTowerSupportBlock(FabricBlockSettings.of(Material.METAL)));
    public static BlockItem fractionTowerSupportItem = Registry.register(Registry.ITEM, new Identifier("advancedchemistry", "fractionitemsupportblockitem"), new BlockItem(fractionTowerSupportBlock, new FabricItemSettings().group(AdvancedChemistry.ITEM_GROUP)));
    public static BlockEntityType<FractionTowerSupportBlockEntity> fractionTowerSupportBlockEntityBlockEntityType = Registry
            .register(Registry.BLOCK_ENTITY_TYPE, new Identifier("advancedchemistry", "fractrionsupport"), FabricBlockEntityTypeBuilder.create(FractionTowerSupportBlockEntity::new,fractionTowerSupportBlock).build(null));
}
