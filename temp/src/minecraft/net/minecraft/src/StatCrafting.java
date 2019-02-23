package net.minecraft.src;

import net.minecraft.src.StatBase;

public class StatCrafting extends StatBase {

   private final int field_25073_a;


   public StatCrafting(int p_i143_1_, String p_i143_2_, int p_i143_3_) {
      super(p_i143_1_, p_i143_2_);
      this.field_25073_a = p_i143_3_;
   }

   public int func_25072_b() {
      return this.field_25073_a;
   }
}
