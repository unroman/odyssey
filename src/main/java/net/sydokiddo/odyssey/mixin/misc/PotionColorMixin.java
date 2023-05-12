package net.sydokiddo.odyssey.mixin.misc;

import net.minecraft.world.effect.MobEffect;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEffect.class)
public abstract class PotionColorMixin {

    // Changes the color of certain status effects

    @Shadow @Final private int color;

    @Inject(at = @At("RETURN"), method = "getColor", cancellable = true)
    private void odyssey_changeEffectColors(CallbackInfoReturnable<Integer> cir) {

        // Haste

        if (this.color == 14270531) {
            cir.setReturnValue(16758911);
        }

        // Mining Fatigue

        if (this.color == 4866583) {
            cir.setReturnValue(5855666);
        }
    }
}