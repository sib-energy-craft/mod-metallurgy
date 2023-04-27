package com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.handler;

import com.github.sib_energy_craft.iron_craft_table.api.IronCraftTableTags;
import com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.slot.IronCraftingTableOutputSlot;
import com.github.sib_energy_craft.recipes.recipe.IronCraftingTableRecipeType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

/**
 * @since 0.0.1
 * @author sibmaks
 */
public abstract class AbstractIronCraftingTableScreenHandler extends ScreenHandler {
    public static final int OUTPUT_SLOT_ID = 0;
    public static final int TOOLS_SLOT_ID = 1;
    public static final int SOURCE_SLOT_ID = 2;

    private final CraftingInventory input;
    private final CraftingResultInventory result;
    private final ScreenHandlerContext context;
    private final PlayerEntity player;

    protected AbstractIronCraftingTableScreenHandler(@NotNull ScreenHandlerType<?> type,
                                                     int syncId,
                                                     @NotNull PlayerInventory playerInventory) {
        this(type, syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    protected AbstractIronCraftingTableScreenHandler(@NotNull ScreenHandlerType<?> type,
                                                     int syncId,
                                                     @NotNull PlayerInventory playerInventory,
                                                     @NotNull ScreenHandlerContext context) {
        super(type, syncId);
        this.context = context;
        this.input = new CraftingInventory(this, 1, 2);
        this.player = playerInventory.player;
        this.result = new CraftingResultInventory();

        var outputSlot = new IronCraftingTableOutputSlot(playerInventory.player, this.input, this.result,
                0, 134, 47, this::onContentChanged);
        this.addSlot(outputSlot);

        var toolSlot = new Slot(input, 0, 27, 47) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return IronCraftTableTags.isIronCraftingTableTool(stack);
            }
        };
        this.addSlot(toolSlot);

        this.addSlot(new Slot(input, 1, 76, 47));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canUse(@NotNull PlayerEntity player) {
        return true;
    }

    @Override
    @NotNull
    public ItemStack quickMove(@NotNull PlayerEntity player, int index) {
        var itemStack = ItemStack.EMPTY;
        var slot = this.slots.get(index);
        if (!slot.hasStack()) {
            return itemStack;
        }
        var playerStack = slot.getStack();
        itemStack = playerStack.copy();
        if(index == OUTPUT_SLOT_ID) {
            this.context.run((world, pos) -> playerStack.getItem().onCraft(playerStack, world, player));
            if (this.insertItem(playerStack, SOURCE_SLOT_ID + 1, 39, true)) {
                slot.onQuickTransfer(playerStack, itemStack);
            } else {
                return ItemStack.EMPTY;
            }
        } else if(index == SOURCE_SLOT_ID || index == TOOLS_SLOT_ID) {
            if(!this.insertItem(playerStack, SOURCE_SLOT_ID + 1, 39, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index >= SOURCE_SLOT_ID + 1 && index < 39) {
            if(IronCraftTableTags.isIronCraftingTableTool(playerStack) &&
                    !this.insertItem(playerStack, TOOLS_SLOT_ID, TOOLS_SLOT_ID + 1, false)) {
                return ItemStack.EMPTY;
            } else if(!this.insertItem(playerStack, SOURCE_SLOT_ID, SOURCE_SLOT_ID + 1, false)) {
                if (index < 30) {
                    if (!this.insertItem(playerStack, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.insertItem(playerStack, SOURCE_SLOT_ID + 1, 30, false)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (playerStack.isEmpty()) {
            slot.setStack(ItemStack.EMPTY);
        } else {
            slot.markDirty();
        }
        if (playerStack.getCount() == itemStack.getCount()) {
            return ItemStack.EMPTY;
        }
        slot.onTakeItem(player, playerStack);
        return itemStack;
    }

    @Override
    public void onContentChanged(@NotNull Inventory inventory) {
        this.context.run((world, pos) -> updateResult(this, world, player, this.input, this.result));
    }

    @Override
    public boolean canInsertIntoSlot(@NotNull ItemStack stack, @NotNull Slot slot) {
        return slot.inventory != this.result && super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public void onClosed(@NotNull PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }

    protected static void updateResult(@NotNull ScreenHandler handler,
                                       @NotNull World world,
                                       @NotNull PlayerEntity player,
                                       @NotNull CraftingInventory craftingInventory,
                                       @NotNull CraftingResultInventory resultInventory) {
        if (!world.isClient && world instanceof ServerWorld) {
            var serverPlayerEntity = (ServerPlayerEntity)player;
            var resultStack = ItemStack.EMPTY;

            var server = world.getServer();
            if(server == null) {
                return;
            }
            var recipeManager = server.getRecipeManager();
            var optional = recipeManager.getFirstMatch(IronCraftingTableRecipeType.INSTANCE,
                    craftingInventory, world);
            if (optional.isPresent()) {
                var recipe = optional.get();
                if (resultInventory.shouldCraftRecipe(world, serverPlayerEntity, recipe)) {
                    var output = recipe.craft(craftingInventory, world.getRegistryManager());
                    if (output.isItemEnabled(world.getEnabledFeatures())) {
                        resultStack = output;
                    }
                }
            }

            resultInventory.setStack(OUTPUT_SLOT_ID, resultStack);
            handler.setPreviousTrackedSlot(OUTPUT_SLOT_ID, resultStack);
            var screenHandlerSlotUpdateS2CPacket = new ScreenHandlerSlotUpdateS2CPacket(handler.syncId,
                    handler.nextRevision(), OUTPUT_SLOT_ID, resultStack);
            serverPlayerEntity.networkHandler.sendPacket(screenHandlerSlotUpdateS2CPacket);
        }
    }
}

