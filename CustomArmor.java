package mod.customarmortest;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class CustomArmor extends ItemArmor {

	public CustomArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}
	
	public String getTextureFile() {
		return CommonProxy.cat_png;
	}
}
