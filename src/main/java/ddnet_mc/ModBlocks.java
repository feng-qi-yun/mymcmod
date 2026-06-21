package ddnet_mc;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public final class ModBlocks {
    private ModBlocks() {}

    public static final Block HOOKABLE_BLOCK = register("hookable_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0f, 6.0f)));

    public static final Block UNHOOKABLE_BLOCK = register("unhookable_block",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).strength(50.0f, 1200.0f)));

    private static Block register(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ddnet_mc.id(name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ddnet_mc.id(name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void initialize() {}
}