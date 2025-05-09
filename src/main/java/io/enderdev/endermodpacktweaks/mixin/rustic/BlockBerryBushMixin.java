package io.enderdev.endermodpacktweaks.mixin.rustic;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.enderdev.endermodpacktweaks.EMTConfig;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rustic.common.blocks.crops.BlockBerryBush;

import java.util.Arrays;
import java.util.Objects;

@Mixin(value = BlockBerryBush.class, remap = false)
public abstract class BlockBerryBushMixin {
    @Unique
    private static final ImmutableList<Block> enderModpackTweaks$validBlocks = Arrays.stream(EMTConfig.RUSTIC.listBerryBushBlocks)
            .map(Block::getBlockFromName)
            .filter(Objects::nonNull)
            .collect(ImmutableList.toImmutableList());

    @WrapMethod(method = "canSustainBush")
    private boolean canSustainBushMixin(IBlockState state, Operation<Boolean> original) {
        if (EMTConfig.RUSTIC.overrideBerryBushPlacement) {
            return enderModpackTweaks$validBlocks.contains(state.getBlock());
        }
        return original.call(state);
    }

    @WrapOperation(method = "canPlaceBlockAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;canSustainPlant(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraftforge/common/IPlantable;)Z", remap = false), remap = true)
    private boolean canPlaceBlockAtMixin(Block block, IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side, IPlantable plantable, Operation<Boolean> original) {
        if (EMTConfig.RUSTIC.overrideBerryBushPlacement) {
            return enderModpackTweaks$validBlocks.contains(state.getBlock());
        }
        return original.call(block, state, world, pos, side, plantable);
    }

    @WrapOperation(method = "canBlockStay", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;canSustainPlant(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraftforge/common/IPlantable;)Z"))
    private boolean canBlockStayMixin(Block block, IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side, IPlantable plantable, Operation<Boolean> original) {
        if (EMTConfig.RUSTIC.overrideBerryBushPlacement) {
            return enderModpackTweaks$validBlocks.contains(state.getBlock());
        }
        return original.call(block, state, world, pos, side, plantable);
    }
}
