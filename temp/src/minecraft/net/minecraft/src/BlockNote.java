package net.minecraft.src;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityNote;
import net.minecraft.src.World;

public class BlockNote extends BlockContainer {

   public BlockNote(int p_i88_1_) {
      super(p_i88_1_, 74, Material.field_1335_c);
   }

   public int func_218_a(int p_218_1_) {
      return this.field_378_bb;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(p_226_5_ > 0) {
         boolean var6 = p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_);
         TileEntityNote var7 = (TileEntityNote)p_226_1_.func_603_b(p_226_2_, p_226_3_, p_226_4_);
         if(var7 != null && var7.field_21096_b != var6) {
            if(var6) {
               var7.func_21094_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
            }

            var7.field_21096_b = var6;
         }
      }

   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         TileEntityNote var6 = (TileEntityNote)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_);
         if(var6 != null) {
            var6.func_21095_a();
            var6.func_21094_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
         }

         return true;
      }
   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      if(!p_233_1_.field_1026_y) {
         TileEntityNote var6 = (TileEntityNote)p_233_1_.func_603_b(p_233_2_, p_233_3_, p_233_4_);
         if(var6 != null) {
            var6.func_21094_a(p_233_1_, p_233_2_, p_233_3_, p_233_4_);
         }

      }
   }

   public TileEntity func_283_a_() {
      return new TileEntityNote();
   }

   public void func_21024_a(World p_21024_1_, int p_21024_2_, int p_21024_3_, int p_21024_4_, int p_21024_5_, int p_21024_6_) {
      float var7 = (float)Math.pow(2.0D, (double)(p_21024_6_ - 12) / 12.0D);
      String var8 = "harp";
      if(p_21024_5_ == 1) {
         var8 = "bd";
      }

      if(p_21024_5_ == 2) {
         var8 = "snare";
      }

      if(p_21024_5_ == 3) {
         var8 = "hat";
      }

      if(p_21024_5_ == 4) {
         var8 = "bassattack";
      }

      p_21024_1_.func_684_a((double)p_21024_2_ + 0.5D, (double)p_21024_3_ + 0.5D, (double)p_21024_4_ + 0.5D, "note." + var8, 3.0F, var7);
      p_21024_1_.func_694_a("note", (double)p_21024_2_ + 0.5D, (double)p_21024_3_ + 1.2D, (double)p_21024_4_ + 0.5D, (double)p_21024_6_ / 24.0D, 0.0D, 0.0D);
   }
}
