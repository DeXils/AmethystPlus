package fr.dexils.amethystplus.item;

import fr.dexils.amethystplus.AmethystPlus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AmethystPlusItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AmethystPlus.MOD_ID);

    public static final RegistryObject<Item> AMETHYST_GREEN_SHARD = ITEMS.register("amethyst_green_shard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
