package com.bountyhunter.shrek.init;

import com.bountyhunter.shrek.Shrek;

import com.bountyhunter.shrek.Shrek.ShrekItemGroup;
import com.bountyhunter.shrek.objects.blocks.SpecialBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Shrek.MOD_ID)
@Mod.EventBusSubscriber(modid = Shrek.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block shrek_ore = null;
	public static final Block special_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("shrek_ore"));
		event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3F).harvestLevel(0).harvestTool(ToolType.AXE).sound(SoundType.WOOD)).setRegistryName("special_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(shrek_ore, new Item.Properties().maxStackSize(69).group(ShrekItemGroup.instance)).setRegistryName("shrek_ore"));
		event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("special_block"));
	}
}
