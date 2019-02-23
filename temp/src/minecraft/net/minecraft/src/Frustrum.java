package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.ClippingHelper;
import net.minecraft.src.ClippingHelperImpl;
import net.minecraft.src.ICamera;

public class Frustrum implements ICamera {

   private ClippingHelper field_593_a = ClippingHelperImpl.func_1155_a();
   private double field_592_b;
   private double field_595_c;
   private double field_594_d;


   public void func_343_a(double p_343_1_, double p_343_3_, double p_343_5_) {
      this.field_592_b = p_343_1_;
      this.field_595_c = p_343_3_;
      this.field_594_d = p_343_5_;
   }

   public boolean func_344_a(double p_344_1_, double p_344_3_, double p_344_5_, double p_344_7_, double p_344_9_, double p_344_11_) {
      return this.field_593_a.func_1152_a(p_344_1_ - this.field_592_b, p_344_3_ - this.field_595_c, p_344_5_ - this.field_594_d, p_344_7_ - this.field_592_b, p_344_9_ - this.field_595_c, p_344_11_ - this.field_594_d);
   }

   public boolean func_342_a(AxisAlignedBB p_342_1_) {
      return this.func_344_a(p_342_1_.field_1698_a, p_342_1_.field_1697_b, p_342_1_.field_1704_c, p_342_1_.field_1703_d, p_342_1_.field_1702_e, p_342_1_.field_1701_f);
   }
}
