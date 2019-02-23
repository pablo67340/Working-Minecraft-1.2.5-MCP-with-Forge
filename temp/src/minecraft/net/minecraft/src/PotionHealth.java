package net.minecraft.src;

import net.minecraft.src.Potion;

public class PotionHealth extends Potion {

   public PotionHealth(int p_i153_1_, boolean p_i153_2_, int p_i153_3_) {
      super(p_i153_1_, p_i153_2_, p_i153_3_);
   }

   public boolean func_40622_b() {
      return true;
   }

   public boolean func_35660_a(int p_35660_1_, int p_35660_2_) {
      return p_35660_1_ >= 1;
   }
}
