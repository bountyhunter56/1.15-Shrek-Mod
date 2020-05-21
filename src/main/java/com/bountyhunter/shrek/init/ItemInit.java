package com.bountyhunter.shrek.init;

import java.util.function.Supplier;

import com.bountyhunter.shrek.Shrek;
import com.bountyhunter.shrek.Shrek.ShrekItemGroup;
import com.bountyhunter.shrek.objects.items.SpecialItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;;

@Mod.EventBusSubscriber(modid = Shrek.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Shrek.MOD_ID)
public class ItemInit 
{
	public static final Item shringot = null;
	public static final Item onion = null;
	public static final Item special_item = null;
	
	//Tools
	public static final Item shrek_sword = null;
	public static final Item shrek_axe = null;
	public static final Item shrek_pickaxe = null;
	public static final Item shrek_shovel = null;
	public static final Item shrek_hoe = null;
	
	//Armor
	public static final Item shrek_helmet = null;
	public static final Item shrek_chestplate = null;
	public static final Item shrek_leggings = null;
	public static final Item shrek_boots = null;
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shringot"));
		event.getRegistry().register(new Item(new Item.Properties().group(ShrekItemGroup.instance).food(new Food.Builder().hunger(6).saturation(11).effect(new EffectInstance(Effects.LUCK, 200, 1), 1).build())).setRegistryName("onion"));
		event.getRegistry().register(new SpecialItem(new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("special_item"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.SHREK, 4, -2.6F, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.SHREK, -5, 0.4F, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.SHREK, 6, -2.8F, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.SHREK, -6, -3F, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.SHREK, 0.5F, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_hoe"));
		
		//Armor
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SHREK, EquipmentSlotType.HEAD, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_helmet"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SHREK, EquipmentSlotType.CHEST, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_chestplate"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SHREK, EquipmentSlotType.LEGS, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_leggings"));
		event.getRegistry().register(new ArmorItem(ModArmorMaterial.SHREK, EquipmentSlotType.FEET, new Item.Properties().group(ShrekItemGroup.instance)).setRegistryName("shrek_boots"));



	}
	
	public enum ModItemTier implements IItemTier
	{
		//int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		SHREK(4, 2000, 15, 7, 30, () -> {
			return Ingredient.fromItems(ItemInit.shringot);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return maxUses;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return efficiency;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return harvestLevel;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}
	
	public enum ModArmorMaterial implements IArmorMaterial
	{
		SHREK(Shrek.MOD_ID + ":shrek", 5, new int[] {7, 9, 11, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON ,4F, () -> {
			return Ingredient.fromItems(ItemInit.shringot);
		});
		private static int[] MAX_DAMAGE_ARRAY = new int[] { 120, 140, 160, 100};
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) 
		{
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) 
		{
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) 
		{
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() 
		{
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() 
		{
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() 
		{
			return this.repairMaterial.getValue();
		}
		
		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() 
		{
			return this.name;
		}

		@Override
		public float getToughness() 
		{
			return this.toughness;
		}
	}
}
