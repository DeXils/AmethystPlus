package fr.dexils.amethystplus.item;

import fr.dexils.amethystplus.AmethystPlus;
import fr.dexils.amethystplus.block.AmethystPlusBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AmethystPlusCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AmethystPlus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AMETHYSTPLUS_TAB = CREATIVE_MODE_TABS.register("amethystplus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(AmethystPlusItems.AMETHYST_GREEN_SHARD.get()))
                    .title(Component.translatable("creativetab.amethystplus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //Amethyst Green
                        pOutput.accept(AmethystPlusItems.AMETHYST_GREEN_SHARD.get());
                        pOutput.accept(AmethystPlusBlocks.AMETHYST_GREEN_BLOCK.get());
                        pOutput.accept(AmethystPlusBlocks.BUDDING_AMETHYST_GREEN.get());
                        pOutput.accept(AmethystPlusBlocks.AMETHYST_GREEN_CLUSTER.get());
                        pOutput.accept(AmethystPlusBlocks.LARGE_AMETHYST_GREEN_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.MEDIUM_AMETHYST_GREEN_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.SMALL_AMETHYST_GREEN_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.CACLITE_GREEN.get());

                        //Amethyst Blue
                        pOutput.accept(AmethystPlusItems.AMETHYST_BLUE_SHARD.get());
                        pOutput.accept(AmethystPlusBlocks.AMETHYST_BLUE_BLOCK.get());
                        pOutput.accept(AmethystPlusBlocks.BUDDING_AMETHYST_BLUE.get());
                        pOutput.accept(AmethystPlusBlocks.AMETHYST_BLUE_CLUSTER.get());
                        pOutput.accept(AmethystPlusBlocks.LARGE_AMETHYST_BLUE_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.MEDIUM_AMETHYST_BLUE_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.SMALL_AMETHYST_BLUE_BUD.get());
                        pOutput.accept(AmethystPlusBlocks.CACLITE_BLUE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
