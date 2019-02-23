package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.WorldGenerator;

public class BiomeGenSwamp extends BiomeGenBase {

   protected BiomeGenSwamp(int p_i131_1_) {
      super(p_i131_1_);
      this.field_35488_u.field_35911_r = 2;
      this.field_35488_u.field_35910_s = -999;
      this.field_35488_u.field_35908_u = 1;
      this.field_35488_u.field_35907_v = 8;
      this.field_35488_u.field_35906_w = 10;
      this.field_35488_u.field_35888_A = 1;
      this.field_35488_u.field_40721_y = 4;
      this.field_40256_A = 14745518;
   }

   public WorldGenerator func_21107_a(Random p_21107_1_) {
      return this.field_35482_C;
   }

   public int func_48415_j() {
      double var1 = (double)this.func_48411_i();
      double var3 = (double)this.func_48414_h();
      return ((ColorizerGrass.func_4147_a(var1, var3) & 16711422) + 5115470) / 2;
   }

   public int func_48412_k() {
      double var1 = (double)this.func_48411_i();
      double var3 = (double)this.func_48414_h();
      return ((ColorizerFoliage.func_4146_a(var1, var3) & 16711422) + 5115470) / 2;
   }
}
