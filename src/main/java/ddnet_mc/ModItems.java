package ddnet_mc;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;

public final class ModItems {
    private ModItems() {}

    public static Item register(Item item, String id) {
		// Create the identifier for the item.
		ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(ddnet_mc.MOD_ID, id);
		// Register the item.
		Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);
		// Return the registered item!
		return registeredItem;
	}

    public static final Item SUSPICIOUS_SUBSTANCE = register(
		new Item(new Item.Properties()),
		"suspicious_substance"
    );

    public static final Item HOOK_ITEM = register(
        new HookItem(new Item.Properties()),
        "hook_item");

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
		    .register(entries -> entries.accept(SUSPICIOUS_SUBSTANCE));
            
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
            .register(entries -> entries.accept(HOOK_ITEM));
    }
}