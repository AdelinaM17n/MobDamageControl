package io.github.adelinam17n.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Explosion;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Explosion.class)
public class ExplosionMixin {
    @Shadow @Final private @Nullable Entity source;

    // Stops the loop from starting, more performant efficient as blocks are uselessly added to a list
    @ModifyVariable(
            method = "explode",
            at = @At("STORE"),
            ordinal = 1
    )
    private int doNotLetTheLoopRun(int value){
        return this.source instanceof Creeper ? 100 : value;
    }
}
