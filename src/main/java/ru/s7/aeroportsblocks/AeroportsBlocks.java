package ru.s7.aeroportsblocks;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(AeroportsBlocks.MOD_ID)
public final class AeroportsBlocks {
    public static final String MOD_ID = "aeroportsblocks";

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredBlock<Block> RUNWAY_ASPHALT =
            BLOCKS.registerSimpleBlock("runway_asphalt",
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE));
    public static final DeferredItem<BlockItem> RUNWAY_ASPHALT_ITEM =
            ITEMS.registerSimpleBlockItem("runway_asphalt", RUNWAY_ASPHALT);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AIRPORT_TAB =
            TABS.register("airport_blocks", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.aeroportsblocks"))
                    .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
                    .icon(() -> RUNWAY_ASPHALT_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> output.accept(RUNWAY_ASPHALT_ITEM.get()))
                    .build());

    public AeroportsBlocks(IEventBus modBus) {
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        TABS.register(modBus);
    }
}
