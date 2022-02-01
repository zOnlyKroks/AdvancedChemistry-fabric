package de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.support;

import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller.FractionTowerControllerBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FractionTowerSupportBlock extends BlockWithEntity implements BlockEntityProvider {

    public FractionTowerSupportBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FractionTowerSupportBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlocks.fractionTowerSupportBlockEntityBlockEntityType, (level0, pos, state0, blockEntity) -> blockEntity.tick(level0,pos,state0,blockEntity));
    }
}
