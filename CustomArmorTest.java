package mod.customarmortest;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CAT", name = "Custom Armor Test", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

//As this is only for proof of concept, I used files already contained within Minecraft.jar for the purpose of this test.
//cat.png is merely gui\items.png, and the test images are copies of the diamond and chain armor skins found in \armor\.

public class CustomArmorTest {
	@Instance("CAT")
	public static CustomArmorTest instance;
	
	@SidedProxy(clientSide = "mod.customarmortest.client.ClientProxy", serverSide = "mod.customarmortest.CommonProxy")
	public static CommonProxy proxy;
	
	//syntax: (name, durability, reductionAmounts, enchantability)
	EnumArmorMaterial customArmorMaterial = EnumHelper.addArmorMaterial("customArmorMaterial", 40, new int[]{5, 14, 9, 5}, 15);
	
	public static Item customHelmetTest;
	public static Item customChestplateTest;
	public static Item customLeggingsTest;
	public static Item customBootsTest;
	
	@PreInit
	public void preInit (FMLPreInitializationEvent event) {
		// Stub Method
	}
	 
	@Init
	public void load (FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		//the "test" prefix uses the supplied diamond armor skins 
		RenderingRegistry.addNewArmourRendererPrefix("test");
		//the "testalt" prefix uses the supplied chain armor skins
		RenderingRegistry.addNewArmourRendererPrefix("testalt");
		
		//syntax: (ID, EnumArmorMaterial, renderIndex, armorType)
		//This makes it so that, with the supplied files, the top half of the armor will be rendered on the player as diamond and the bottom half will be chain.
		//However, we're intentionally using .setIconCoord(int, int) to make all the parts show up as golden armor items in the inventory. 
		customHelmetTest = new CustomArmor(6000, customArmorMaterial, ModLoader.addArmor("test"), 0).setIconCoord(4, 0).setItemName("customHelmetTest");
		customChestplateTest = new CustomArmor(6001, customArmorMaterial, ModLoader.addArmor("test"), 1).setIconCoord(4, 1).setItemName("customChestplateTest");
		customLeggingsTest = new CustomArmor(6002, customArmorMaterial, ModLoader.addArmor("testalt"), 2).setIconCoord(4, 2).setItemName("customLeggingsTest");
		customBootsTest = new CustomArmor(6003, customArmorMaterial, ModLoader.addArmor("testalt"), 3).setIconCoord(4, 3).setItemName("customBootsTest");
		
		LanguageRegistry.addName(customHelmetTest, "Custom Helmet Test");
		LanguageRegistry.addName(customChestplateTest, "Custom Chestplate Test");
		LanguageRegistry.addName(customLeggingsTest, "Custom Leggings Test");
		LanguageRegistry.addName(customBootsTest, "Custom Boots Test");
		
	}
	 
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	} 
}
