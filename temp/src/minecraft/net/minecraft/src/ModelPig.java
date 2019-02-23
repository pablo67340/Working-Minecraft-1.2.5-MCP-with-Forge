package net.minecraft.src;

import net.minecraft.src.ModelQuadruped;

public class ModelPig extends ModelQuadruped {

   public ModelPig() {
      this(0.0F);
   }

   public ModelPig(float p_i286_1_) {
      super(6, p_i286_1_);
      this.field_1266_d.func_40602_a(16, 16).func_923_a(-2.0F, 0.0F, -9.0F, 4, 3, 1, p_i286_1_);
      this.field_40331_g = 4.0F;
   }
}
