package net.ethershade.ethercore.item;

import net.ethershade.ethercore.EtherCore;
import net.ethershade.ethercore.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EtherCore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ETHERCORE_ITEMS_TAB = CREATIVE_MODE_TABS.register("ether_core_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILVER_INGOT.get()))
                    .title(Component.translatable("creativetab.ethercore.ether_core_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.DIORITE_PEBBLE.get());
                        output.accept(ModItems.ANDESITE_PEBBLE.get());
                        output.accept(ModItems.GRANITE_PEBBLE.get());

                        output.accept(ModBlocks.COBBLED_DIORITE.get());
                        output.accept(ModBlocks.COBBLED_ANDESITE.get());
                        output.accept(ModBlocks.COBBLED_GRANITE.get());

                        output.accept(ModBlocks.COBBLED_DIORITE_STAIRS.get());
                        output.accept(ModBlocks.COBBLED_ANDESITE_STAIRS.get());
                        output.accept(ModBlocks.COBBLED_GRANITE_STAIRS.get());

                        output.accept(ModBlocks.COBBLED_DIORITE_SLAB.get());
                        output.accept(ModBlocks.COBBLED_ANDESITE_SLAB.get());
                        output.accept(ModBlocks.COBBLED_GRANITE_SLAB.get());

                        output.accept(ModBlocks.COBBLED_DIORITE_WALL.get());
                        output.accept(ModBlocks.COBBLED_ANDESITE_WALL.get());
                        output.accept(ModBlocks.COBBLED_GRANITE_WALL.get());

                        output.accept(ModItems.OAK_BARK.get());
                        output.accept(ModItems.SPRUCE_BARK.get());
                        output.accept(ModItems.BIRCH_BARK.get());
                        output.accept(ModItems.ACACIA_BARK.get());
                        output.accept(ModItems.JUNGLE_BARK.get());
                        output.accept(ModItems.DARK_OAK_BARK.get());

                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.SILVER_DEEPSLATE_ORE.get());
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
