package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.World;

public class BlockEnchantmentTable extends BlockContainer {

   protected BlockEnchantmentTable(int p_i698_1_) {
      super(p_i698_1_, 166, Material.field_1334_d);
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.func_256_d(0);
   }

   public boolean func_242_c() {
      return false;
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      super.func_247_b(p_247_1_, p_247_2_, p_247_3_, p_247_4_, p_247_5_);

      for(int var6 = p_247_2_ - 2; var6 <= p_247_2_ + 2; ++var6) {
         for(int var7 = p_247_4_ - 2; var7 <= p_247_4_ + 2; ++var7) {
            if(var6 > p_247_2_ - 2 && var6 < p_247_2_ + 2 && var7 == p_247_4_ - 1) {
               var7 = p_247_4_ + 2;
            }

            if(p_247_5_.nextInt(16) == 0) {
               for(int var8 = p_247_3_; var8 <= p_247_3_ + 1; ++var8) {
                  if(p_247_1_.func_600_a(var6, var8, var7) == Block.field_407_ao.field_376_bc) {
                     if(!p_247_1_.func_20084_d((var6 - p_247_2_) / 2 + p_247_2_, var8, (var7 - p_247_4_) / 2 + p_247_4_)) {
                        break;
                     }

                     p_247_1_.func_694_a("enchantmenttable", (double)p_247_2_ + 0.5D, (double)p_247_3_ + 2.0D, (double)p_247_4_ + 0.5D, (double)((float)(var6 - p_247_2_) + p_247_5_.nextFloat()) - 0.5D, (double)((float)(var8 - p_247_3_) - p_247_5_.nextFloat() - 1.0F), (double)((float)(var7 - p_247_4_) + p_247_5_.nextFloat()) - 0.5D);
                  }
               }
            }
         }
      }

   }

   public boolean func_217_b() {
      return false;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return this.func_218_a(p_232_1_);
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 0?this.field_378_bb + 17:(p_218_1_ == 1?this.field_378_bb:this.field_378_bb + 16);
   }

   public TileEntity func_283_a_() {
      return new TileEntityEnchantmentTable();
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         p_250_5_.func_40181_c(p_250_2_, p_250_3_, p_250_4_);
         return true;
      }
   }
}
