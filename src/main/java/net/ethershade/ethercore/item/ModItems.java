package net.ethershade.ethercore.item;

import net.ethershade.ethercore.EtherCore;
import net.ethershade.ethercore.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtherCore.MOD_ID);

    public static final RegistryObject<Item> OAK_BARK = ITEMS.register("oak_bark",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> SPRUCE_BARK = ITEMS.register("spruce_bark",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> BIRCH_BARK = ITEMS.register("birch_bark",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> ACACIA_BARK = ITEMS.register("acacia_bark",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> JUNGLE_BARK = ITEMS.register("jungle_bark",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> DARK_OAK_BARK = ITEMS.register("dark_oak_bark",
            () -> new FuelItem(new Item.Properties(), 100));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}