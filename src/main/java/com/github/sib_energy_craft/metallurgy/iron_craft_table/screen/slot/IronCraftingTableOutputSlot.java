package com.github.sib_energy_craft.metallurgy.iron_craft_table.screen.slot;

import com.github.sib_energy_craft.iron_craft_table.api.IronCraftingTableTool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 /**
 * @since 0.0.1
 * @author sibmaks
 */
public final class IronCraftingTableOutputSlot extends CraftingResultSlot {
    private final CraftingInventory input;
    private final Consumer<Inventory> contentChangedListener;

    public IronCraftingTableOutputSlot(@NotNull PlayerEntity player,
                                       @NotNull CraftingInventory input,
                                       @NotNull Inventory inventory,
                                       int index,
                                       int x,
                                       int y,
                                       @NotNull Consumer<Inventory> contentChangedListener) {
        super(player, input, inventory, index, x, y);
        this.input = input;
        this.contentChangedListener = contentChangedListener;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public void onTakeItem(@NotNull PlayerEntity player, @NotNull ItemStack stack) {
        this.onCrafted(stack);

        var toolStack = input.getStack(0);
        var sourceStack = input.getStack(1);

        var count = Math.min(toolStack.getMaxDamage() - toolStack.getDamage(), sourceStack.getCount());
        if(count > 0) {
            var item = toolStack.getItem();
            if(item instanceof IronCraftingTableTool tableTool) {
                tableTool.onUse(player, toolStack, stack);
            }
        }

        sourceStack.decrement(1);
        if (sourceStack.getCount() <= 0) {
            input.setStack(1, ItemStack.EMPTY);
        }

        toolStack.damage(1, player.getRandom(), null);
        if (toolStack.getMaxDamage() <= toolStack.getDamage()) {
            input.setStack(0, ItemStack.EMPTY);
        }

        stack.getItem().onCraft(stack, player.getWorld(), player);
        contentChangedListener.accept(input);
    }
}
