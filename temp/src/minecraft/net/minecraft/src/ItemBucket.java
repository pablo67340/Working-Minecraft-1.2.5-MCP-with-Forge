package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class ItemBucket extends Item {

   private int field_331_a;


   public ItemBucket(int p_i238_1_, int p_i238_2_) {
      super(p_i238_1_);
      this.field_290_aT = 1;
      this.field_331_a = p_i238_2_;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      float var4 = 1.0F;
      double var5 = p_193_3_.field_9285_at + (p_193_3_.field_611_ak - p_193_3_.field_9285_at) * (double)var4;
      double var7 = p_193_3_.field_9284_au + (p_193_3_.field_610_al - p_193_3_.field_9284_au) * (double)var4 + 1.62D - (double)p_193_3_.field_9292_aO;
      double var9 = p_193_3_.field_9283_av + (p_193_3_.field_609_am - p_193_3_.field_9283_av) * (double)var4;
      boolean var11 = this.field_331_a == 0;
      MovingObjectPosition var12 = this.func_40402_a(p_193_2_, p_193_3_, var11);
      if(var12 == null) {
         return p_193_1_;
      } else {
         if(var12.field_1167_a == EnumMovingObjectType.TILE) {
            int var13 = var12.field_1166_b;
            int var14 = var12.field_1172_c;
            int var15 = var12.field_1171_d;
            if(!p_193_2_.func_6466_a(p_193_3_, var13, var14, var15)) {
               return p_193_1_;
            }

            if(this.field_331_a == 0) {
               if(!p_193_3_.func_35190_e(var13, var14, var15)) {
                  return p_193_1_;
               }

               if(p_193_2_.func_599_f(var13, var14, var15) == Material.field_1332_f && p_193_2_.func_602_e(var13, var14, var15) == 0) {
                  p_193_2_.func_690_d(var13, var14, var15, 0);
                  if(p_193_3_.field_35212_aW.field_35756_d) {
                     return p_193_1_;
                  }

                  return new ItemStack(Item.field_4016_av);
               }

               if(p_193_2_.func_599_f(var13, var14, var15) == Material.field_1331_g && p_193_2_.func_602_e(var13, var14, var15) == 0) {
                  p_193_2_.func_690_d(var13, var14, var15, 0);
                  if(p_193_3_.field_35212_aW.field_35756_d) {
                     return p_193_1_;
                  }

                  return new ItemStack(Item.field_258_aw);
               }
            } else {
               if(this.field_331_a < 0) {
                  return new ItemStack(Item.field_262_au);
               }

               if(var12.field_1170_e == 0) {
                  --var14;
               }

               if(var12.field_1170_e == 1) {
                  ++var14;
               }

               if(var12.field_1170_e == 2) {
                  --var15;
               }

               if(var12.field_1170_e == 3) {
                  ++var15;
               }

               if(var12.field_1170_e == 4) {
                  --var13;
               }

               if(var12.field_1170_e == 5) {
                  ++var13;
               }

               if(!p_193_3_.func_35190_e(var13, var14, var15)) {
                  return p_193_1_;
               }

               if(p_193_2_.func_20084_d(var13, var14, var15) || !p_193_2_.func_599_f(var13, var14, var15).func_878_a()) {
                  if(p_193_2_.field_4209_q.field_6479_d && this.field_331_a == Block.field_401_B.field_376_bc) {
                     p_193_2_.func_684_a(var5 + 0.5D, var7 + 0.5D, var9 + 0.5D, "random.fizz", 0.5F, 2.6F + (p_193_2_.field_1037_n.nextFloat() - p_193_2_.field_1037_n.nextFloat()) * 0.8F);

                     for(int var16 = 0; var16 < 8; ++var16) {
                        p_193_2_.func_694_a("largesmoke", (double)var13 + Math.random(), (double)var14 + Math.random(), (double)var15 + Math.random(), 0.0D, 0.0D, 0.0D);
                     }
                  } else {
                     p_193_2_.func_688_b(var13, var14, var15, this.field_331_a, 0);
                  }

                  if(p_193_3_.field_35212_aW.field_35756_d) {
                     return p_193_1_;
                  }

                  return new ItemStack(Item.field_262_au);
               }
            }
         } else if(this.field_331_a == 0 && var12.field_1168_g instanceof EntityCow) {
            return new ItemStack(Item.field_305_aE);
         }

         return p_193_1_;
      }
   }
}
