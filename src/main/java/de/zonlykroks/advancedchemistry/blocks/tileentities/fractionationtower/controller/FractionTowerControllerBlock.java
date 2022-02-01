package de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller;

import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.ChemicalReactorTileEntity;
import de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.support.FractionTowerSupportBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;

public class FractionTowerControllerBlock extends BlockWithEntity implements BlockEntityProvider {

    public Block[] supportBlocks   = {};
    public HashMap<Block, Boolean> assembled = new HashMap<>();

    public FractionTowerControllerBlock(Settings settings) {
        super(settings);
    }

    public void setDependencies(Block[] supportBlocks) {
        this.supportBlocks = supportBlocks;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ChemicalReactorTileEntity) {
                ItemScatterer.spawn(world, pos, (ChemicalReactorTileEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FractionTowerControllerBlockEntity(pos,state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlocks.fractionTowerControllerBlockEntityBlockEntityType, (level0, pos, state0, blockEntity) -> blockEntity.tick(level0,pos,state0,blockEntity));
    }

    public void update(World world, BlockPos pos) {
        assembled.clear();
        BlockPos[] neededBlocks;

        neededBlocks = new BlockPos[] {
                //i = x;
                //j = y;
                //k = z;
               pos.add(0,1,0)
        };

        for (int i = 0; i < neededBlocks.length; i++) {
            BlockPos blockPosition = neededBlocks[i];
            BlockState blockState = world.getBlockState(blockPosition);
            for (int j = 0; j < neededBlocks.length; j++) {
                Block block = supportBlocks[j];
                if(blockState.getBlock() == block) {
                    assembled.put(block, true);
                }else{
                    assembled.put(block,false);
                }
            }
        }
    }

    public boolean isAssembled() {
        return assembled.values().stream().anyMatch(assembled -> true);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        update(world, pos);
    }
}
