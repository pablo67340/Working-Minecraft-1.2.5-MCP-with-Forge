package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;

public class ModelZombie extends ModelBiped {

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
      float var7 = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F);
      float var8 = MathHelper.func_1106_a((1.0F - (1.0F - this.field_1244_k) * (1.0F - this.field_1244_k)) * 3.1415927F);
      this.field_1283_d.field_1405_f = 0.0F;
      this.field_1282_e.field_1405_f = 0.0F;
      this.field_1283_d.field_1406_e = -(0.1F - var7 * 0.6F);
      this.field_1282_e.field_1406_e = 0.1F - var7 * 0.6F;
      this.field_1283_d.field_1407_d = -1.5707964F;
      this.field_1282_e.field_1407_d = -1.5707964F;
      this.field_1283_d.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
      this.field_1282_e.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
      this.field_1283_d.field_1405_f += MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_1282_e.field_1405_f -= MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_1283_d.field_1407_d += MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
      this.field_1282_e.field_1407_d -= MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
   }
}
