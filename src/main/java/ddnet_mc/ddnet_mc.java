package ddnet_mc;

import net.fabricmc.api.ModInitializer;
// import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
// import net.minecraft.world.item.Item;

// import org.intellij.lang.annotations.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ddnet_mc implements ModInitializer {
    public static final String MOD_ID = "ddnet_mc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // public static final Item CUSTOM_ITEM = new Item(new Item.Settings());
 

    @Override
    public void onInitialize() {
        // 初始化注册类（官方推荐方式）
        ModBlocks.initialize();
        ModItems.initialize();

        LOGGER.info("DDNet MC 模组加载成功！已注册2个方块和1个物品");

        // 对于 1.21 之前的版本，请将 ''Identifier.of'' 替换为 ''new Identifier''
        // Registry.register(Registries.ITEM, Identifier.of("tutorial", "custom_item"), CUSTOM_ITEM);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}