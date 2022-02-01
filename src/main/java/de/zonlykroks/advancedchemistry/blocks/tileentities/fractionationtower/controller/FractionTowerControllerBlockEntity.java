package de.zonlykroks.advancedchemistry.blocks.tileentities.fractionationtower.controller;

import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.ChemicalReactorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FractionTowerControllerBlockEntity extends BlockEntity {

    public FractionTowerControllerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.fractionTowerControllerBlockEntityBlockEntityType, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state, FractionTowerControllerBlockEntity te) {
        FractionTowerControllerBlock block = (FractionTowerControllerBlock) state.getBlock();
        System.out.println(block.isAssembled());
    }
}
