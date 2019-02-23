package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.WorldChunkManager;

public class WorldChunkManagerHell extends WorldChunkManager {

   private BiomeGenBase field_4201_e;
   private float field_4200_f;
   private float field_4199_g;


   public WorldChunkManagerHell(BiomeGenBase p_i323_1_, float p_i323_2_, float p_i323_3_) {
      this.field_4201_e = p_i323_1_;
      this.field_4200_f = p_i323_2_;
      this.field_4199_g = p_i323_3_;
   }

   public BiomeGenBase func_4073_a(int p_4073_1_, int p_4073_2_) {
      return this.field_4201_e;
   }

   public BiomeGenBase[] func_35557_b(BiomeGenBase[] p_35557_1_, int p_35557_2_, int p_35557_3_, int p_35557_4_, int p_35557_5_) {
      if(p_35557_1_ == null || p_35557_1_.length < p_35557_4_ * p_35557_5_) {
         p_35557_1_ = new BiomeGenBase[p_35557_4_ * p_35557_5_];
      }

      Arrays.fill(p_35557_1_, 0, p_35557_4_ * p_35557_5_, this.field_4201_e);
      return p_35557_1_;
   }

   public float[] func_4071_a(float[] p_4071_1_, int p_4071_2_, int p_4071_3_, int p_4071_4_, int p_4071_5_) {
      if(p_4071_1_ == null || p_4071_1_.length < p_4071_4_ * p_4071_5_) {
         p_4071_1_ = new float[p_4071_4_ * p_4071_5_];
      }

      Arrays.fill(p_4071_1_, 0, p_4071_4_ * p_4071_5_, this.field_4200_f);
      return p_4071_1_;
   }

   public float[] func_35560_b(float[] p_35560_1_, int p_35560_2_, int p_35560_3_, int p_35560_4_, int p_35560_5_) {
      if(p_35560_1_ == null || p_35560_1_.length < p_35560_4_ * p_35560_5_) {
         p_35560_1_ = new float[p_35560_4_ * p_35560_5_];
      }

      Arrays.fill(p_35560_1_, 0, p_35560_4_ * p_35560_5_, this.field_4199_g);
      return p_35560_1_;
   }

   public BiomeGenBase[] func_4070_a(BiomeGenBase[] p_4070_1_, int p_4070_2_, int p_4070_3_, int p_4070_4_, int p_4070_5_) {
      if(p_4070_1_ == null || p_4070_1_.length < p_4070_4_ * p_4070_5_) {
         p_4070_1_ = new BiomeGenBase[p_4070_4_ * p_4070_5_];
      }

      Arrays.fill(p_4070_1_, 0, p_4070_4_ * p_4070_5_, this.field_4201_e);
      return p_4070_1_;
   }

   public BiomeGenBase[] func_35555_a(BiomeGenBase[] p_35555_1_, int p_35555_2_, int p_35555_3_, int p_35555_4_, int p_35555_5_, boolean p_35555_6_) {
      return this.func_4070_a(p_35555_1_, p_35555_2_, p_35555_3_, p_35555_4_, p_35555_5_);
   }

   public ChunkPosition func_35556_a(int p_35556_1_, int p_35556_2_, int p_35556_3_, List p_35556_4_, Random p_35556_5_) {
      return p_35556_4_.contains(this.field_4201_e)?new ChunkPosition(p_35556_1_ - p_35556_3_ + p_35556_5_.nextInt(p_35556_3_ * 2 + 1), 0, p_35556_2_ - p_35556_3_ + p_35556_5_.nextInt(p_35556_3_ * 2 + 1)):null;
   }

   public boolean func_35562_a(int p_35562_1_, int p_35562_2_, int p_35562_3_, List p_35562_4_) {
      return p_35562_4_.contains(this.field_4201_e);
   }
}
