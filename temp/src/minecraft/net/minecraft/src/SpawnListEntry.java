package net.minecraft.src;

import net.minecraft.src.WeightedRandomChoice;

public class SpawnListEntry extends WeightedRandomChoice {

   public Class field_25212_a;
   public int field_35591_b;
   public int field_35592_c;


   public SpawnListEntry(Class p_i241_1_, int p_i241_2_, int p_i241_3_, int p_i241_4_) {
      super(p_i241_2_);
      this.field_25212_a = p_i241_1_;
      this.field_35591_b = p_i241_3_;
      this.field_35592_c = p_i241_4_;
   }
}
