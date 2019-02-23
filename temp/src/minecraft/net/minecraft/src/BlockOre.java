package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockOre extends Block {

   public BlockOre(int p_i392_1_, int p_i392_2_) {
      super(p_i392_1_, p_i392_2_, Material.field_1334_d);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return this.field_376_bc == Block.field_386_J.field_376_bc?Item.field_225_k.field_291_aS:(this.field_376_bc == Block.field_391_ax.field_376_bc?Item.field_224_l.field_291_aS:(this.field_376_bc == Block.field_9267_N.field_376_bc?Item.field_21021_aU.field_291_aS:this.field_376_bc));
   }

   public int func_229_a(Random p_229_1_) {
      return this.field_376_bc == Block.field_9267_N.field_376_bc?4 + p_229_1_.nextInt(5):1;
   }

   public int func_40198_a(int p_40198_1_, Random p_40198_2_) {
      if(p_40198_1_ > 0 && this.field_376_bc != this.func_240_a(0, p_40198_2_, p_40198_1_)) {
         int var3 = p_40198_2_.nextInt(p_40198_1_ + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.func_229_a(p_40198_2_) * (var3 + 1);
      } else {
         return this.func_229_a(p_40198_2_);
      }
   }

   protected int func_21025_b(int p_21025_1_) {
      return this.field_376_bc == Block.field_9267_N.field_376_bc?4:0;
   }
}
