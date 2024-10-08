package net.ethershade.ethercore.datagen;

import net.ethershade.ethercore.block.ModBlocks;
import net.ethershade.ethercore.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.COBBLED_DIORITE.get());
        dropSelf(ModBlocks.COBBLED_ANDESITE.get());
        dropSelf(ModBlocks.COBBLED_GRANITE.get());

        dropSelf(ModBlocks.COBBLED_DIORITE_STAIRS.get());
        dropSelf(ModBlocks.COBBLED_ANDESITE_STAIRS.get());
        dropSelf(ModBlocks.COBBLED_GRANITE_STAIRS.get());

        this.add(ModBlocks.COBBLED_DIORITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_DIORITE_SLAB.get()));
        this.add(ModBlocks.COBBLED_ANDESITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_ANDESITE_SLAB.get()));
        this.add(ModBlocks.COBBLED_GRANITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_GRANITE_SLAB.get()));

        dropSelf(ModBlocks.COBBLED_DIORITE_WALL.get());
        dropSelf(ModBlocks.COBBLED_ANDESITE_WALL.get());
        dropSelf(ModBlocks.COBBLED_GRANITE_WALL.get());

        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.SILVER_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SILVER_DEEPSLATE_ORE.get(), ModItems.RAW_SILVER.get(), 2, 6));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
