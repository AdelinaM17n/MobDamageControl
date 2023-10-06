package io.github.adelinam17n.mixin;

import net.minecraft.world.level.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Explosion.class)
public class ExplosionMixin {
    // Stops the loop from starting, more performant efficient as blocks are uselessly added to a list
    @ModifyVariable(
            method = "explode",
            at = @At("STORE"),
            ordinal = 1
    )
    private int doNotLetTheLoopRun(int value){
        return 100;
    }
}
