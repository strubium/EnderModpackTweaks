package io.enderdev.endermodpacktweaks.mixin.rustic;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.enderdev.endermodpacktweaks.config.CfgMinecraft;
import io.enderdev.endermodpacktweaks.config.CfgTweaks;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = rustic.client.EventHandlerClient.class, remap = false)
public class EventHandlerClientMixin {
    @WrapOperation(method = "onRenderArmorToughnessEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawTexturedModalRect(IIIIII)V", remap = true))
    private void wrapDrawTexturedModalRect(GuiIngame instance, int x, int y, int textureX, int textureY, int width, int height, Operation<Void> original) {
        x += CfgTweaks.RUSTIC.armorToughnessXOffset;
        y += CfgTweaks.RUSTIC.armorToughnessYOffset;
        original.call(instance, x, y, textureX, textureY, width, height);
    }

    @WrapOperation(method = "onRenderArmorOverlayEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawTexturedModalRect(IIIIII)V", remap = true))
    private void wrapDrawTexturedModalRect2(GuiIngame instance, int x, int y, int textureX, int textureY, int width, int height, Operation<Void> original) {
        x += CfgTweaks.RUSTIC.armorXOffset;
        y += CfgTweaks.RUSTIC.armorYOffset;
        original.call(instance, x, y, textureX, textureY, width, height);
    }

    @Inject(method = "onRenderArmorOverlayEvent", at = @At("HEAD"), cancellable = true)
    private void wrapArmor(RenderGameOverlayEvent.Pre event, CallbackInfo ci) {
        if (CfgMinecraft.CLIENT.hideArmorBar) ci.cancel();
    }

    @Inject(method = "onRenderArmorToughnessEvent", at = @At("HEAD"), cancellable = true)
    private void wrapToughness(RenderGameOverlayEvent.Post event, CallbackInfo ci) {
        if (CfgMinecraft.CLIENT.hideArmorBar) ci.cancel();
    }
}
