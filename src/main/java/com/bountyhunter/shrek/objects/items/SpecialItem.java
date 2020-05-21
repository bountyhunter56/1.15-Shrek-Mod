package com.bountyhunter.shrek.objects.items;

import java.util.List;

import com.bountyhunter.shrek.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SpecialItem extends Item
{

	public SpecialItem(Properties properties) 
	{
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		if(KeyboardHelper.isHoldingShift()) 
		{
			tooltip.add(new StringTextComponent("\u00A72" + "Shrek is Love, Shrek is Life"));
		}else {
			tooltip.add(new StringTextComponent("\u00A72" + "Hold Shift for Onions"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		if(playerIn.getAIMoveSpeed() == 0.1F) 
		{
		playerIn.abilities.setWalkSpeed(0.4F);
		}else 
		{
			playerIn.abilities.setWalkSpeed(0.1F);
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
		
	}
	@Override
	public boolean onDroppedByPlayer(ItemStack item, PlayerEntity player) {
		player.abilities.setWalkSpeed(0.1F);
		return super.onDroppedByPlayer(item, player);
	}
}
