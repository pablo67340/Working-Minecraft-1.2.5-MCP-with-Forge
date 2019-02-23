package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenLakes extends WorldGenerator {

   private int field_15235_a;


   public WorldGenLakes(int p_i270_1_) {
      this.field_15235_a = p_i270_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      p_516_3_ -= 8;

      for(p_516_5_ -= 8; p_516_4_ > 5 && p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_); --p_516_4_) {
         ;
      }

      if(p_516_4_ <= 4) {
         return false;
      } else {
         p_516_4_ -= 4;
         boolean[] var6 = new boolean[2048];
         int var7 = p_516_2_.nextInt(4) + 4;

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            double var9 = p_516_2_.nextDouble() * 6.0D + 3.0D;
            double var11 = p_516_2_.nextDouble() * 4.0D + 2.0D;
            double var13 = p_516_2_.nextDouble() * 6.0D + 3.0D;
            double var15 = p_516_2_.nextDouble() * (16.0D - var9 - 2.0D) + 1.0D + var9 / 2.0D;
            double var17 = p_516_2_.nextDouble() * (8.0D - var11 - 4.0D) + 2.0D + var11 / 2.0D;
            double var19 = p_516_2_.nextDouble() * (16.0D - var13 - 2.0D) + 1.0D + var13 / 2.0D;

            for(int var21 = 1; var21 < 15; ++var21) {
               for(int var22 = 1; var22 < 15; ++var22) {
                  for(int var23 = 1; var23 < 7; ++var23) {
                     double var24 = ((double)var21 - var15) / (var9 / 2.0D);
                     double var26 = ((double)var23 - var17) / (var11 / 2.0D);
                     double var28 = ((double)var22 - var19) / (var13 / 2.0D);
                     double var30 = var24 * var24 + var26 * var26 + var28 * var28;
                     if(var30 < 1.0D) {
                        var6[(var21 * 16 + var22) * 8 + var23] = true;
                     }
                  }
               }
            }
         }

         int var10;
         int var32;
         boolean var33;
         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 0; var10 < 8; ++var10) {
                  var33 = !var6[(var8 * 16 + var32) * 8 + var10] && (var8 < 15 && var6[((var8 + 1) * 16 + var32) * 8 + var10] || var8 > 0 && var6[((var8 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var8 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var8 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var8 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var8 * 16 + var32) * 8 + (var10 - 1)]);
                  if(var33) {
                     Material var12 = p_516_1_.func_599_f(p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32);
                     if(var10 >= 4 && var12.func_879_d()) {
                        return false;
                     }

                     if(var10 < 4 && !var12.func_878_a() && p_516_1_.func_600_a(p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32) != this.field_15235_a) {
                        return false;
                     }
                  }
               }
            }
         }

         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 0; var10 < 8; ++var10) {
                  if(var6[(var8 * 16 + var32) * 8 + var10]) {
                     p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32, var10 >= 4?0:this.field_15235_a);
                  }
               }
            }
         }

         for(var8 = 0; var8 < 16; ++var8) {
            for(var32 = 0; var32 < 16; ++var32) {
               for(var10 = 4; var10 < 8; ++var10) {
                  if(var6[(var8 * 16 + var32) * 8 + var10] && p_516_1_.func_600_a(p_516_3_ + var8, p_516_4_ + var10 - 1, p_516_5_ + var32) == Block.field_336_w.field_376_bc && p_516_1_.func_641_a(EnumSkyBlock.Sky, p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32) > 0) {
                     BiomeGenBase var34 = p_516_1_.func_48454_a(p_516_3_ + var8, p_516_5_ + var32);
                     if(var34.field_4242_o == Block.field_40199_bz.field_376_bc) {
                        p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var10 - 1, p_516_5_ + var32, Block.field_40199_bz.field_376_bc);
                     } else {
                        p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var10 - 1, p_516_5_ + var32, Block.field_337_v.field_376_bc);
                     }
                  }
               }
            }
         }

         if(Block.field_345_n[this.field_15235_a].field_356_bn == Material.field_1331_g) {
            for(var8 = 0; var8 < 16; ++var8) {
               for(var32 = 0; var32 < 16; ++var32) {
                  for(var10 = 0; var10 < 8; ++var10) {
                     var33 = !var6[(var8 * 16 + var32) * 8 + var10] && (var8 < 15 && var6[((var8 + 1) * 16 + var32) * 8 + var10] || var8 > 0 && var6[((var8 - 1) * 16 + var32) * 8 + var10] || var32 < 15 && var6[(var8 * 16 + var32 + 1) * 8 + var10] || var32 > 0 && var6[(var8 * 16 + (var32 - 1)) * 8 + var10] || var10 < 7 && var6[(var8 * 16 + var32) * 8 + var10 + 1] || var10 > 0 && var6[(var8 * 16 + var32) * 8 + (var10 - 1)]);
                     if(var33 && (var10 < 4 || p_516_2_.nextInt(2) != 0) && p_516_1_.func_599_f(p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32).func_878_a()) {
                        p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var10, p_516_5_ + var32, Block.field_338_u.field_376_bc);
                     }
                  }
               }
            }
         }

         if(Block.field_345_n[this.field_15235_a].field_356_bn == Material.field_1332_f) {
            for(var8 = 0; var8 < 16; ++var8) {
               for(var32 = 0; var32 < 16; ++var32) {
                  byte var35 = 4;
                  if(p_516_1_.func_40471_p(p_516_3_ + var8, p_516_4_ + var35, p_516_5_ + var32)) {
                     p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var35, p_516_5_ + var32, Block.field_4063_aU.field_376_bc);
                  }
               }
            }
         }

         return true;
      }
   }
}
