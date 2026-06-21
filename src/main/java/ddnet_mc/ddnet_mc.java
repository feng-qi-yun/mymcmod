package ddnet_mc;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ddnet_mc implements ModInitializer {
    public static final String MOD_ID = "ddnet_mc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 初始化注册类（官方推荐方式）
        ModBlocks.initialize();
        ModItems.initialize();

        LOGGER.info("DDNet MC 模组加载成功！已注册2个方块和1个物品");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}