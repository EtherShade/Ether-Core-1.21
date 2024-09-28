package net.ethershade.ethercore.datagen;

import net.ethershade.ethercore.EtherCore;
import net.ethershade.ethercore.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EtherCore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COBBLED_DIORITE);
        blockWithItem(ModBlocks.COBBLED_ANDESITE);
        blockWithItem(ModBlocks.COBBLED_GRANITE);

        stairsBlock(ModBlocks.COBBLED_DIORITE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_DIORITE.get()));
        stairsBlock(ModBlocks.COBBLED_ANDESITE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_ANDESITE.get()));
        stairsBlock(ModBlocks.COBBLED_GRANITE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_GRANITE.get()));
        blockItem(ModBlocks.COBBLED_DIORITE_STAIRS);
        blockItem(ModBlocks.COBBLED_ANDESITE_STAIRS);
        blockItem(ModBlocks.COBBLED_GRANITE_STAIRS);

        slabBlock(ModBlocks.COBBLED_DIORITE_SLAB.get(), blockTexture(ModBlocks.COBBLED_DIORITE.get()), blockTexture(ModBlocks.COBBLED_DIORITE.get()));
        slabBlock(ModBlocks.COBBLED_ANDESITE_SLAB.get(), blockTexture(ModBlocks.COBBLED_ANDESITE.get()), blockTexture(ModBlocks.COBBLED_ANDESITE.get()));
        slabBlock(ModBlocks.COBBLED_GRANITE_SLAB.get(), blockTexture(ModBlocks.COBBLED_GRANITE.get()), blockTexture(ModBlocks.COBBLED_GRANITE.get()));
        blockItem(ModBlocks.COBBLED_DIORITE_SLAB);
        blockItem(ModBlocks.COBBLED_ANDESITE_SLAB);
        blockItem(ModBlocks.COBBLED_GRANITE_SLAB);

        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);

        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.SILVER_DEEPSLATE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("ethercore:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("ethercore:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
