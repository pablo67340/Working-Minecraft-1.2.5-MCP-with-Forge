package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenDungeons extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      byte var6 = 3;
      int var7 = p_516_2_.nextInt(2) + 2;
      int var8 = p_516_2_.nextInt(2) + 2;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      for(var10 = p_516_3_ - var7 - 1; var10 <= p_516_3_ + var7 + 1; ++var10) {
         for(var11 = p_516_4_ - 1; var11 <= p_516_4_ + var6 + 1; ++var11) {
            for(var12 = p_516_5_ - var8 - 1; var12 <= p_516_5_ + var8 + 1; ++var12) {
               Material var13 = p_516_1_.func_599_f(var10, var11, var12);
               if(var11 == p_516_4_ - 1 && !var13.func_878_a()) {
                  return false;
               }

               if(var11 == p_516_4_ + var6 + 1 && !var13.func_878_a()) {
                  return false;
               }

               if((var10 == p_516_3_ - var7 - 1 || var10 == p_516_3_ + var7 + 1 || var12 == p_516_5_ - var8 - 1 || var12 == p_516_5_ + var8 + 1) && var11 == p_516_4_ && p_516_1_.func_20084_d(var10, var11, var12) && p_516_1_.func_20084_d(var10, var11 + 1, var12)) {
                  ++var9;
               }
            }
         }
      }

      if(var9 >= 1 && var9 <= 5) {
         for(var10 = p_516_3_ - var7 - 1; var10 <= p_516_3_ + var7 + 1; ++var10) {
            for(var11 = p_516_4_ + var6; var11 >= p_516_4_ - 1; --var11) {
               for(var12 = p_516_5_ - var8 - 1; var12 <= p_516_5_ + var8 + 1; ++var12) {
                  if(var10 != p_516_3_ - var7 - 1 && var11 != p_516_4_ - 1 && var12 != p_516_5_ - var8 - 1 && var10 != p_516_3_ + var7 + 1 && var11 != p_516_4_ + var6 + 1 && var12 != p_516_5_ + var8 + 1) {
                     p_516_1_.func_690_d(var10, var11, var12, 0);
                  } else if(var11 >= 0 && !p_516_1_.func_599_f(var10, var11 - 1, var12).func_878_a()) {
                     p_516_1_.func_690_d(var10, var11, var12, 0);
                  } else if(p_516_1_.func_599_f(var10, var11, var12).func_878_a()) {
                     if(var11 == p_516_4_ - 1 && p_516_2_.nextInt(4) != 0) {
                        p_516_1_.func_690_d(var10, var11, var12, Block.field_406_ap.field_376_bc);
                     } else {
                        p_516_1_.func_690_d(var10, var11, var12, Block.field_335_x.field_376_bc);
                     }
                  }
               }
            }
         }

         var10 = 0;

         while(var10 < 2) {
            var11 = 0;

            while(true) {
               if(var11 < 3) {
                  label113: {
                     var12 = p_516_3_ + p_516_2_.nextInt(var7 * 2 + 1) - var7;
                     int var14 = p_516_5_ + p_516_2_.nextInt(var8 * 2 + 1) - var8;
                     if(p_516_1_.func_20084_d(var12, p_516_4_, var14)) {
                        int var15 = 0;
                        if(p_516_1_.func_599_f(var12 - 1, p_516_4_, var14).func_878_a()) {
                           ++var15;
                        }

                        if(p_516_1_.func_599_f(var12 + 1, p_516_4_, var14).func_878_a()) {
                           ++var15;
                        }

                        if(p_516_1_.func_599_f(var12, p_516_4_, var14 - 1).func_878_a()) {
                           ++var15;
                        }

                        if(p_516_1_.func_599_f(var12, p_516_4_, var14 + 1).func_878_a()) {
                           ++var15;
                        }

                        if(var15 == 1) {
                           p_516_1_.func_690_d(var12, p_516_4_, var14, Block.field_396_av.field_376_bc);
                           TileEntityChest var16 = (TileEntityChest)p_516_1_.func_603_b(var12, p_516_4_, var14);
                           if(var16 != null) {
                              for(int var17 = 0; var17 < 8; ++var17) {
                                 ItemStack var18 = this.func_530_a(p_516_2_);
                                 if(var18 != null) {
                                    var16.func_472_a(p_516_2_.nextInt(var16.func_469_c()), var18);
                                 }
                              }
                           }
                           break label113;
                        }
                     }

                     ++var11;
                     continue;
                  }
               }

               ++var10;
               break;
            }
         }

         p_516_1_.func_690_d(p_516_3_, p_516_4_, p_516_5_, Block.field_400_at.field_376_bc);
         TileEntityMobSpawner var19 = (TileEntityMobSpawner)p_516_1_.func_603_b(p_516_3_, p_516_4_, p_516_5_);
         if(var19 != null) {
            var19.func_21098_a(this.func_531_b(p_516_2_));
         } else {
            System.err.println("Failed to fetch mob spawner entity at (" + p_516_3_ + ", " + p_516_4_ + ", " + p_516_5_ + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private ItemStack func_530_a(Random p_530_1_) {
      int var2 = p_530_1_.nextInt(11);
      return var2 == 0?new ItemStack(Item.field_254_ay):(var2 == 1?new ItemStack(Item.field_223_m, p_530_1_.nextInt(4) + 1):(var2 == 2?new ItemStack(Item.field_242_S):(var2 == 3?new ItemStack(Item.field_243_R, p_530_1_.nextInt(4) + 1):(var2 == 4?new ItemStack(Item.field_250_K, p_530_1_.nextInt(4) + 1):(var2 == 5?new ItemStack(Item.field_253_I, p_530_1_.nextInt(4) + 1):(var2 == 6?new ItemStack(Item.field_262_au):(var2 == 7 && p_530_1_.nextInt(100) == 0?new ItemStack(Item.field_269_ar):(var2 == 8 && p_530_1_.nextInt(2) == 0?new ItemStack(Item.field_309_aA, p_530_1_.nextInt(4) + 1):(var2 == 9 && p_530_1_.nextInt(10) == 0?new ItemStack(Item.field_233_c[Item.field_293_aQ.field_291_aS + p_530_1_.nextInt(2)]):(var2 == 10?new ItemStack(Item.field_21021_aU, 1, 3):null))))))))));
   }

   private String func_531_b(Random p_531_1_) {
      int var2 = p_531_1_.nextInt(4);
      return var2 == 0?"Skeleton":(var2 == 1?"Zombie":(var2 == 2?"Zombie":(var2 == 3?"Spider":"")));
   }
}
