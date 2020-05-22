package com.bountyhunter.shrek;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bountyhunter.shrek.init.ItemInit;
import com.bountyhunter.shrek.init.ModTileEntityTypes;
import com.bountyhunter.shrek.world.gen.ShrekOreGen;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bsm")
@Mod.EventBusSubscriber(modid = "bsm", bus = Bus.MOD)
public class Shrek
{
	public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "bsm";
    public static Shrek instance;
    
    public Shrek() 
    {
    	final IEventBus modeventbus = FMLJavaModLoadingContext.get().getModEventBus();
        modeventbus.addListener(this::setup);
        modeventbus.addListener(this::doClientStuff);
        instance = this;
        
        MinecraftForge.EVENT_BUS.register(this);
        
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modeventbus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
        
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) 
    {
    	ShrekOreGen.generateOre();
    }
    
    public static class ShrekItemGroup extends ItemGroup
    {
    	public static final ShrekItemGroup instance = new ShrekItemGroup(ItemGroup.GROUPS.length, "Shrek Mod Tab");
    	private ShrekItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack createIcon() 
    	{
    		return new ItemStack(ItemInit.shringot);
    	}
    }
}
