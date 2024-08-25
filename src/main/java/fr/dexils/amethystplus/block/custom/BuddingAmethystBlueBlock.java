package fr.dexils.amethystplus.block.custom;

import com.mojang.serialization.MapCodec;
import fr.dexils.amethystplus.block.AmethystPlusBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingAmethystBlueBlock extends AmethystBlock {
    public static final MapCodec<BuddingAmethystBlock> CODEC = simpleCodec(BuddingAmethystBlock::new);
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public MapCodec<BuddingAmethystBlock> codec() {
        return CODEC;
    }

    public BuddingAmethystBlueBlock(Properties p_152726_) {
        super(p_152726_);
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = AmethystPlusBlocks.SMALL_AMETHYST_BLUE_BUD.get();
            } else if (blockstate.is(AmethystPlusBlocks.SMALL_AMETHYST_BLUE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AmethystPlusBlocks.MEDIUM_AMETHYST_BLUE_BUD.get();
            } else if (blockstate.is(AmethystPlusBlocks.MEDIUM_AMETHYST_BLUE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AmethystPlusBlocks.LARGE_AMETHYST_BLUE_BUD.get();
            } else if (blockstate.is(AmethystPlusBlocks.LARGE_AMETHYST_BLUE_BUD.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = AmethystPlusBlocks.AMETHYST_BLUE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState()
                        .setValue(AmethystClusterBlock.FACING, direction)
                        .setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }

    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }
}