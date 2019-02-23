package net.minecraft.src;

import net.minecraft.src.BiomeCache;
import net.minecraft.src.BiomeGenBase;

public class BiomeCacheBlock {

   public float[] field_35659_a;
   public float[] field_35657_b;
   public BiomeGenBase[] field_35658_c;
   public int field_35655_d;
   public int field_35656_e;
   public long field_35653_f;
   // $FF: synthetic field
   final BiomeCache field_35654_g;


   public BiomeCacheBlock(BiomeCache p_i147_1_, int p_i147_2_, int p_i147_3_) {
      this.field_35654_g = p_i147_1_;
      this.field_35659_a = new float[256];
      this.field_35657_b = new float[256];
      this.field_35658_c = new BiomeGenBase[256];
      this.field_35655_d = p_i147_2_;
      this.field_35656_e = p_i147_3_;
      BiomeCache.func_35721_a(p_i147_1_).func_4071_a(this.field_35659_a, p_i147_2_ << 4, p_i147_3_ << 4, 16, 16);
      BiomeCache.func_35721_a(p_i147_1_).func_35560_b(this.field_35657_b, p_i147_2_ << 4, p_i147_3_ << 4, 16, 16);
      BiomeCache.func_35721_a(p_i147_1_).func_35555_a(this.field_35658_c, p_i147_2_ << 4, p_i147_3_ << 4, 16, 16, false);
   }

   public BiomeGenBase func_35651_a(int p_35651_1_, int p_35651_2_) {
      return this.field_35658_c[p_35651_1_ & 15 | (p_35651_2_ & 15) << 4];
   }
}
