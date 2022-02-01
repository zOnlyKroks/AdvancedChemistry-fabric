package de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.support;

import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller.FractionTowerControllerBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FractionTowerSupportBlockEntity extends BlockEntity {

    public FractionTowerSupportBlockEntity( BlockPos pos, BlockState state) {
        super(ModBlocks.fractionTowerControllerBlockEntityBlockEntityType, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state, FractionTowerSupportBlockEntity te) {

    }
}
