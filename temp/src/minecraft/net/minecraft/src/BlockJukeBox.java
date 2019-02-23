package net.minecraft.src;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRecordPlayer;
import net.minecraft.src.World;

public class BlockJukeBox extends BlockContainer {

   protected BlockJukeBox(int p_i682_1_, int p_i682_2_) {
      super(p_i682_1_, p_i682_2_, Material.field_1335_c);
   }

   public int func_218_a(int p_218_1_) {
      return this.field_378_bb + (p_218_1_ == 1?1:0);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_) == 0) {
         return false;
      } else {
         this.func_28038_b_(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
         return true;
      }
   }

   public void func_317_e(World p_317_1_, int p_317_2_, int p_317_3_, int p_317_4_, int p_317_5_) {
      if(!p_317_1_.field_1026_y) {
         TileEntityRecordPlayer var6 = (TileEntityRecordPlayer)p_317_1_.func_603_b(p_317_2_, p_317_3_, p_317_4_);
         if(var6 != null) {
            var6.field_28017_a = p_317_5_;
            var6.func_474_j_();
            p_317_1_.func_691_b(p_317_2_, p_317_3_, p_317_4_, 1);
         }
      }
   }

   public void func_28038_b_(World p_28038_1_, int p_28038_2_, int p_28038_3_, int p_28038_4_) {
      if(!p_28038_1_.field_1026_y) {
         TileEntityRecordPlayer var5 = (TileEntityRecordPlayer)p_28038_1_.func_603_b(p_28038_2_, p_28038_3_, p_28038_4_);
         if(var5 != null) {
            int var6 = var5.field_28017_a;
            if(var6 != 0) {
               p_28038_1_.func_28106_e(1005, p_28038_2_, p_28038_3_, p_28038_4_, 0);
               p_28038_1_.func_670_a((String)null, p_28038_2_, p_28038_3_, p_28038_4_);
               var5.field_28017_a = 0;
               var5.func_474_j_();
               p_28038_1_.func_691_b(p_28038_2_, p_28038_3_, p_28038_4_, 0);
               float var8 = 0.7F;
               double var9 = (double)(p_28038_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
               double var11 = (double)(p_28038_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.2D + 0.6D;
               double var13 = (double)(p_28038_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
               EntityItem var15 = new EntityItem(p_28038_1_, (double)p_28038_2_ + var9, (double)p_28038_3_ + var11, (double)p_28038_4_ + var13, new ItemStack(var6, 1, 0));
               var15.field_805_c = 10;
               p_28038_1_.func_674_a(var15);
            }
         }
      }
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      this.func_28038_b_(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      if(!p_216_1_.field_1026_y) {
         super.func_216_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, p_216_5_, p_216_6_, 0);
      }
   }

   public TileEntity func_283_a_() {
      return new TileEntityRecordPlayer();
   }
}
