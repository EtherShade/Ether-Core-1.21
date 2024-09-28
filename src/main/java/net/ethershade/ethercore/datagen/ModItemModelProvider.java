package net.ethershade.ethercore.datagen;

import net.ethershade.ethercore.EtherCore;
import net.ethershade.ethercore.block.ModBlocks;
import net.ethershade.ethercore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EtherCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        wallItem(ModBlocks.COBBLED_DIORITE_WALL, ModBlocks.COBBLED_DIORITE);
        wallItem(ModBlocks.COBBLED_ANDESITE_WALL, ModBlocks.COBBLED_ANDESITE);
        wallItem(ModBlocks.COBBLED_GRANITE_WALL, ModBlocks.COBBLED_GRANITE);

        basicItem(ModItems.OAK_BARK.get());
        basicItem(ModItems.SPRUCE_BARK.get());
        basicItem(ModItems.BIRCH_BARK.get());
        basicItem(ModItems.ACACIA_BARK.get());
        basicItem(ModItems.JUNGLE_BARK.get());
        basicItem(ModItems.DARK_OAK_BARK.get());

        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.RAW_SILVER.get());
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(EtherCore.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(EtherCore.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(EtherCore.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(EtherCore.MOD_ID,"item/" + item.getId().getPath()));
    }
}
