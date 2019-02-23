package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;

public class BlockLeavesBase extends Block {

   protected boolean field_6359_a;


   protected BlockLeavesBase(int p_i409_1_, int p_i409_2_, Material p_i409_3_, boolean p_i409_4_) {
      super(p_i409_1_, p_i409_2_, p_i409_3_);
      this.field_6359_a = p_i409_4_;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      int var6 = p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_);
      return !this.field_6359_a && var6 == this.field_376_bc?false:super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
   }
}
