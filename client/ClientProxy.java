package mod.customarmortest.client;

import net.minecraftforge.client.MinecraftForgeClient;
import mod.customarmortest.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
    public void registerRenderers() {
        	MinecraftForgeClient.preloadTexture(cat_png);
    }  
}
