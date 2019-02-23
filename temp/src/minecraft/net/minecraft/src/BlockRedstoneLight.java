package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneLight extends Block {

   private final boolean field_48215_a;


   public BlockRedstoneLight(int p_i1044_1_, boolean p_i1044_2_) {
      super(p_i1044_1_, 211, Material.field_48468_r);
      this.field_48215_a = p_i1044_2_;
      if(p_i1044_2_) {
         this.func_215_a(1.0F);
         ++this.field_378_bb;
      }

   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      if(!p_235_1_.field_1026_y) {
         if(this.field_48215_a && !p_235_1_.func_625_o(p_235_2_, p_235_3_, p_235_4_)) {
            p_235_1_.func_22136_c(p_235_2_, p_235_3_, p_235_4_, this.field_376_bc, 4);
         } else if(!this.field_48215_a && p_235_1_.func_625_o(p_235_2_, p_235_3_, p_235_4_)) {
            p_235_1_.func_690_d(p_235_2_, p_235_3_, p_235_4_, Block.field_48210_bM.field_376_bc);
         }
      }

   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y) {
         if(this.field_48215_a && !p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_)) {
            p_226_1_.func_22136_c(p_226_2_, p_226_3_, p_226_4_, this.field_376_bc, 4);
         } else if(!this.field_48215_a && p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_)) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, Block.field_48210_bM.field_376_bc);
         }
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y && this.field_48215_a && !p_208_1_.func_625_o(p_208_2_, p_208_3_, p_208_4_)) {
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_48209_bL.field_376_bc);
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_48209_bL.field_376_bc;
   }
}
