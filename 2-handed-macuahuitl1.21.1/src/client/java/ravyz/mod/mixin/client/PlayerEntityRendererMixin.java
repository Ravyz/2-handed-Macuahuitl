package ravyz.mod.mixin.client;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
	@Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
	private static void TwoHandedMacuahuitl$getArmPoseDR(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
		ItemStack itemStack = player.getMainHandStack();
        if (itemStack.getName().equals(Text.literal("Ravyz Blade")) && itemStack.getItem() instanceof SwordItem) {
            cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
        }
        }}