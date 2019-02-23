package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemColored extends ItemBlock {

   private final Block field_35436_a;
   private String[] field_41034_b;


   public ItemColored(int p_i189_1_, boolean p_i189_2_) {
      super(p_i189_1_);
      this.field_35436_a = Block.field_345_n[this.func_35435_b()];
      if(p_i189_2_) {
         this.func_21013_d(0);
         this.func_21015_a(true);
      }

   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      return this.field_35436_a.func_31030_b(p_27010_1_);
   }

   public int func_27009_a(int p_27009_1_) {
      return this.field_35436_a.func_232_a(0, p_27009_1_);
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_;
   }

   public ItemColored func_41033_a(String[] p_41033_1_) {
      this.field_41034_b = p_41033_1_;
      return this;
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      if(this.field_41034_b == null) {
         return super.func_21011_b(p_21011_1_);
      } else {
         int var2 = p_21011_1_.func_21181_i();
         return var2 >= 0 && var2 < this.field_41034_b.length?super.func_21011_b(p_21011_1_) + "." + this.field_41034_b[var2]:super.func_21011_b(p_21011_1_);
      }
   }
}
