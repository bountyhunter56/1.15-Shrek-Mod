package com.bountyhunter.shrek.world.gen;

import com.bountyhunter.shrek.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ShrekOreGen 
{
	public static void generateOre() 
	{
		for (Biome biome : ForgeRegistries.BIOMES) 
		{
			if( biome == Biomes.SWAMP) {
				
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 5, 20));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.shrek_ore.getDefaultState(), 4)).withPlacement(customConfig));
		
			}
		}	
	}
}
