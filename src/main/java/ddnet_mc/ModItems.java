package ddnet_mc;

import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
// import ddnet_mc.HookItem;

public final class ModItems {
    private ModItems() {}


    public static final Item HOOK_ITEM = register("hook_item",
            // new HookItem(new Item.Properties().maxCount(16)));
            new HookItem(new Item.Properties()));

    private static <T extends Item> T register(String name, T item) {
        return Registry.register(BuiltInRegistries.ITEM, ddnet_mc.id(name), item);
    }

    public static void initialize() {}
}