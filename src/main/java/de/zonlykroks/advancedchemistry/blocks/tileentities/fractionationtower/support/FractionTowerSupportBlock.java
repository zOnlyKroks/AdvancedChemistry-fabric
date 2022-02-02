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
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class FractionTowerSupportBlock extends BlockWithEntity implements BlockEntityProvider {

    public Block[] coreBlocks;

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

    public void setDependencyBlocks(Block[] coreBlocks) {
        this.coreBlocks = coreBlocks;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        update(world,pos,state);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);
        updateNearby((World)world,pos,state,coreBlocks);
    }

    public void update(World world, BlockPos pos, BlockState state) {

        BlockPos[] blockPositions = {
                pos.add(1, 0, 0),
                pos.add(-1, 0, 0),
                pos.add(0, 0, 1),
                pos.add(0, 0, -1)
        };
        for (int i = 0; i < blockPositions.length; i++) {
            BlockPos   blockPosition = blockPositions[i];
            BlockState blockState    = world.getBlockState(blockPosition);
            for (int j = 0; j < coreBlocks.length; j ++) {
                Block coreBlock = coreBlocks[j];
                if (blockState.isOf(coreBlock)) {
                    ((FractionTowerControllerBlock) blockState.getBlock()).update(world, blockPosition);
                }
            }
        }

    }

    public static void updateNearby(World world, BlockPos pos, BlockState state, Block[] coreBlocks) {

        BlockPos[] blockPositions = {
                pos.add(-1, -1, -1),
                pos.add(-1, -1, 0),
                pos.add(-1, -1, 1),
                pos.add(-1, 0, -1),
                pos.add(-1, 0, 0),
                pos.add(-1, 0, 1),
                pos.add(-1, 1, -1),
                pos.add(-1, 1, 0),
                pos.add(-1, 1, 1),
                pos.add(0, -1, -1),
                pos.add(0, -1, 0),
                pos.add(0, -1, 1),
                pos.add(0, 0, -1),
                pos.add(0, 0, 0),
                pos.add(0, 0, 1),
                pos.add(0, 1, -1),
                pos.add(0, 1, 0),
                pos.add(0, 1, 1),
                pos.add(1, -1, -1),
                pos.add(1, -1, 0),
                pos.add(1, -1, 1),
                pos.add(1, 0, -1),
                pos.add(1, 0, 0),
                pos.add(1, 0, 1),
                pos.add(1, 1, -1),
                pos.add(1, 1, 0),
                pos.add(1, 1, 1)
        };
        for (int i = 0; i < blockPositions.length; i++) {
            BlockPos   blockPosition = blockPositions[i];
            BlockState blockState    = world.getBlockState(blockPosition);
            for (int j = 0; j < coreBlocks.length; j++) {
                Block coreBlock = coreBlocks[j];
                if (blockState.isOf(coreBlock)) {
                    ((FractionTowerControllerBlock) blockState.getBlock()).update(world, blockPosition);
                    break;
                }
            }
        }

    }
}
