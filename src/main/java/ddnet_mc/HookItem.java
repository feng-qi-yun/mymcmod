package ddnet_mc;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class HookItem extends Item {
    private static final double MAX_RANGE = 20.0;
    private static final double PULL_SPEED = 0.8;
    private static final int COOLDOWN = 20;

    public HookItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);

        if (level.isClientSide()) {
            return InteractionResultHolder.success(stack);
        }

        HitResult hitResult = user.pick(MAX_RANGE, 1.0F, false);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hitResult;

            if (level.getBlockState(blockHit.getBlockPos()).is(ModBlocks.HOOKABLE_BLOCK)) {
                level.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.FISHING_BOBBER_RETRIEVE, SoundSource.PLAYERS,
                        1.0F, 1.0F);

                Vec3 targetPos = blockHit.getLocation();
                Vec3 playerPos = user.position();
                Vec3 direction = targetPos.subtract(playerPos).normalize();

                user.setDeltaMovement(direction.scale(PULL_SPEED));
                user.hasImpulse = true;

                user.getCooldowns().addCooldown(this, COOLDOWN);
                return InteractionResultHolder.success(stack);
            } else if (level.getBlockState(blockHit.getBlockPos()).is(ModBlocks.UNHOOKABLE_BLOCK)) {
                level.playSound(null, user.getX(), user.getY(), user.getZ(),
                        SoundEvents.ANVIL_LAND, SoundSource.PLAYERS,
                        0.5F, 2.0F);

                Vec3 dir = user.getViewVector(1.0F).scale(-0.3);
                user.setDeltaMovement(dir);
                user.hasImpulse = true;
                return InteractionResultHolder.success(stack);
            }
        }

        level.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.FISHING_BOBBER_THROW, SoundSource.PLAYERS,
                0.5F, 0.8F);
        return InteractionResultHolder.pass(stack);
    }
}