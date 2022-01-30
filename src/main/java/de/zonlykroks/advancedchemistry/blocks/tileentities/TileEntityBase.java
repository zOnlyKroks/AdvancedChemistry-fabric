package de.zonlykroks.advancedchemistry.blocks.tileentities;

import de.zonlykroks.advancedchemistry.blocks.impl.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import javax.annotation.Nullable;

public abstract class TileEntityBase extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, Tickable {

    protected boolean isActive = false;

    protected SimpleEnergyStorage energyStorage = null;

    public TileEntityBase(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
    }

    @Override
    public void tick() {
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {

        if (energyStorage == null) return;
        var energyStorageNbt = new NbtCompound();

        energyStorageNbt.putLong("Amount", energyStorage.amount);
        energyStorageNbt.putLong("Capacity", energyStorage.capacity);
        energyStorageNbt.putLong("MaxInsert", energyStorage.maxInsert);
        energyStorageNbt.putLong("MaxExtract", energyStorage.maxExtract);
        nbt.put("EnergyStorage", energyStorageNbt);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("EnergyStorage")) {
            var energyStorageNbt = nbt.getCompound("EnergyStorage");

            energyStorage.amount = energyStorageNbt.getLong("Amount");
        }
        super.readNbt(nbt);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public boolean hasEnergyStorage() {
        return getEnergyStorage() != null;
    }

    @Nullable
    public SimpleEnergyStorage getEnergyStorage() {
        return energyStorage;
    }
}
