package de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor;

import de.zonlykroks.advancedchemistry.AdvancedChemistry;
import de.zonlykroks.advancedchemistry.blocks.ModBlocks;
import de.zonlykroks.advancedchemistry.blocks.impl.ImplementedInventory;
import de.zonlykroks.advancedchemistry.blocks.tileentities.TileEntityBase;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.gui.ChemicalReactorScreenHandler;
import de.zonlykroks.advancedchemistry.blocks.tileentities.chemicalreactor.recipe.ChemicalReactorRecipe;
import de.zonlykroks.advancedchemistry.items.ModItems;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;
import java.util.function.Supplier;

public class ChemicalReactorTileEntity extends TileEntityBase {

    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxProgress = 63;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public ChemicalReactorTileEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.chemicalReactorTileEntityBlockEntityType, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return ChemicalReactorTileEntity.this.progress;
                    case 1: return ChemicalReactorTileEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: ChemicalReactorTileEntity.this.progress = value; break;
                    case 1: ChemicalReactorTileEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(200000, 200, 0) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };

    @Nullable
    @Override
    public SimpleEnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Chemical Reactor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ChemicalReactorScreenHandler(syncId,inv,this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    public void tick(World world, BlockPos pos, BlockState state, ChemicalReactorTileEntity te) {
        if(hasRecipe(te) && energyStorage.amount >= 10) {
            te.progress++;
            if(te.progress > te.maxProgress) {
                craftItem(te);
            }
            try (var transaction = Transaction.openOuter()) {
                energyStorage.amount -= 10;
                transaction.commit();
            }
        } else {
            te.resetProgress();
        }
    }

    private static void craftItem(ChemicalReactorTileEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ChemicalReactorRecipe> match = world.getRecipeManager()
                .getFirstMatch(AdvancedChemistry.recipeType, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(0,match.get().getInputNumberA());
            entity.removeStack(1,match.get().getInputNumberB());
            entity.setStack(2, new ItemStack(match.get().getOutput().copy().getItem(),
                    entity.getStack(2).getCount() + match.get().getOutput().copy().getCount()));
            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }


    private boolean hasRecipe(ChemicalReactorTileEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ChemicalReactorRecipe> match = world.getRecipeManager()
                .getFirstMatch(AdvancedChemistry.recipeType, inventory, world);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(inventory)
                && hasEnoughItems(inventory,match)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(2).getItem() == output.getItem() || inventory.getStack(2).isEmpty();
    }

    private static boolean hasEnoughItems(SimpleInventory inventory, Optional<ChemicalReactorRecipe> match) {
        return inventory.getStack(0).getCount() == match.get().getInputNumberA() && inventory.getStack(1).getCount() == match.get().getInputNumberB();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }

}
