package fr.dexils.amethystplus.block;

import fr.dexils.amethystplus.AmethystPlus;
import fr.dexils.amethystplus.block.custom.BuddingAmethystGreenBlock;
import fr.dexils.amethystplus.item.AmethystPlusItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AmethystPlusBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AmethystPlus.MOD_ID);

    // Amethyst Green
    public static final RegistryObject<Block> AMETHYST_GREEN_BLOCK = registerBlock("amethyst_green_block",
            ()-> new AmethystBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));

    public static final RegistryObject<Block> BUDDING_AMETHYST_GREEN = registerBlock("budding_amethyst_green",
            () -> new BuddingAmethystGreenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BUDDING_AMETHYST)));

    public static final RegistryObject<Block> AMETHYST_GREEN_CLUSTER = registerBlock("amethyst_green_cluster",
            ()-> new AmethystClusterBlock(7,3,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> LARGE_AMETHYST_GREEN_BUD = registerBlock("large_amethyst_green_bud",
            ()-> new AmethystClusterBlock(5,3,BlockBehaviour.Properties.ofFullCopy(Blocks.LARGE_AMETHYST_BUD)));

    public static final RegistryObject<Block> MEDIUM_AMETHYST_GREEN_BUD = registerBlock("medium_amethyst_green_bud",
            ()-> new AmethystClusterBlock(6,3,BlockBehaviour.Properties.ofFullCopy(Blocks.MEDIUM_AMETHYST_BUD)));

    public static final RegistryObject<Block> SMALL_AMETHYST_GREEN_BUD = registerBlock("small_amethyst_green_bud",
            ()-> new AmethystClusterBlock(3,4,BlockBehaviour.Properties.ofFullCopy(Blocks.SMALL_AMETHYST_BUD)));

    public static final RegistryObject<Block> CACLITE_GREEN = registerBlock("calcite_green",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));



    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return AmethystPlusItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
