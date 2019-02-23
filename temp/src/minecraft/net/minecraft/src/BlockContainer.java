package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public abstract class BlockContainer extends Block {

   protected BlockContainer(int p_i115_1_, Material p_i115_2_) {
      super(p_i115_1_, p_i115_2_);
      this.field_48207_bU = true;
   }

   protected BlockContainer(int p_i116_1_, int p_i116_2_, Material p_i116_3_) {
      super(p_i116_1_, p_i116_2_, p_i116_3_);
      this.field_48207_bU = true;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      p_235_1_.func_654_a(p_235_2_, p_235_3_, p_235_4_, this.func_283_a_());
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
      p_214_1_.func_692_l(p_214_2_, p_214_3_, p_214_4_);
   }

   public abstract TileEntity func_283_a_();

   public void func_21024_a(World p_21024_1_, int p_21024_2_, int p_21024_3_, int p_21024_4_, int p_21024_5_, int p_21024_6_) {
      super.func_21024_a(p_21024_1_, p_21024_2_, p_21024_3_, p_21024_4_, p_21024_5_, p_21024_6_);
      TileEntity var7 = p_21024_1_.func_603_b(p_21024_2_, p_21024_3_, p_21024_4_);
      if(var7 != null) {
         var7.func_35143_b(p_21024_5_, p_21024_6_);
      }

   }
}
