package ddnet_mc;

// import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
// import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;

public final class ModBlocks {
    private ModBlocks() {}

    public static Block register(Block block, String name) {
		// Register the block and its item.
		ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ddnet_mc.MOD_ID, name);

		BlockItem blockItem = new BlockItem(block, new Item.Properties());
		Registry.register(BuiltInRegistries.ITEM, id, blockItem);

		return Registry.register(BuiltInRegistries.BLOCK, id, block);
	}

    public static final Block HOOKABLE_BLOCK = register(
            new Block(BlockBehaviour.Properties.of().strength(4.0f)), "hookable_block");

    public static final Block UNHOOKABLE_BLOCK = register(
            new Block(BlockBehaviour.Properties.of().strength(4.0f)), "unhookable_block");

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
		    .register(entries -> entries.accept(HOOKABLE_BLOCK));
            
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
            .register(entries -> entries.accept(UNHOOKABLE_BLOCK));
    }
}