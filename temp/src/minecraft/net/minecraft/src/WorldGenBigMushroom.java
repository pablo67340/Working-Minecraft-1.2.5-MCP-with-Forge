package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenBigMushroom extends WorldGenerator {

   private int field_35266_a = -1;


   public WorldGenBigMushroom(int p_i550_1_) {
      super(true);
      this.field_35266_a = p_i550_1_;
   }

   public WorldGenBigMushroom() {
      super(false);
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(2);
      if(this.field_35266_a >= 0) {
         var6 = this.field_35266_a;
      }

      int var7 = p_516_2_.nextInt(3) + 4;
      boolean var8 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var7 + 1 < 256) {
         int var9;
         int var11;
         int var12;
         int var13;
         for(var9 = p_516_4_; var9 <= p_516_4_ + 1 + var7; ++var9) {
            byte var10 = 3;
            if(var9 == p_516_4_) {
               var10 = 0;
            }

            for(var11 = p_516_3_ - var10; var11 <= p_516_3_ + var10 && var8; ++var11) {
               for(var12 = p_516_5_ - var10; var12 <= p_516_5_ + var10 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     var13 = p_516_1_.func_600_a(var11, var9, var12);
                     if(var13 != 0 && var13 != Block.field_384_L.field_376_bc) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            var9 = p_516_1_.func_600_a(p_516_3_, p_516_4_ - 1, p_516_5_);
            if(var9 != Block.field_336_w.field_376_bc && var9 != Block.field_337_v.field_376_bc && var9 != Block.field_40199_bz.field_376_bc) {
               return false;
            } else if(!Block.field_415_ag.func_243_a(p_516_1_, p_516_3_, p_516_4_, p_516_5_)) {
               return false;
            } else {
               this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc, 0);
               int var16 = p_516_4_ + var7;
               if(var6 == 1) {
                  var16 = p_516_4_ + var7 - 3;
               }

               for(var11 = var16; var11 <= p_516_4_ + var7; ++var11) {
                  var12 = 1;
                  if(var11 < p_516_4_ + var7) {
                     ++var12;
                  }

                  if(var6 == 0) {
                     var12 = 3;
                  }

                  for(var13 = p_516_3_ - var12; var13 <= p_516_3_ + var12; ++var13) {
                     for(int var14 = p_516_5_ - var12; var14 <= p_516_5_ + var12; ++var14) {
                        int var15 = 5;
                        if(var13 == p_516_3_ - var12) {
                           --var15;
                        }

                        if(var13 == p_516_3_ + var12) {
                           ++var15;
                        }

                        if(var14 == p_516_5_ - var12) {
                           var15 -= 3;
                        }

                        if(var14 == p_516_5_ + var12) {
                           var15 += 3;
                        }

                        if(var6 == 0 || var11 < p_516_4_ + var7) {
                           if((var13 == p_516_3_ - var12 || var13 == p_516_3_ + var12) && (var14 == p_516_5_ - var12 || var14 == p_516_5_ + var12)) {
                              continue;
                           }

                           if(var13 == p_516_3_ - (var12 - 1) && var14 == p_516_5_ - var12) {
                              var15 = 1;
                           }

                           if(var13 == p_516_3_ - var12 && var14 == p_516_5_ - (var12 - 1)) {
                              var15 = 1;
                           }

                           if(var13 == p_516_3_ + (var12 - 1) && var14 == p_516_5_ - var12) {
                              var15 = 3;
                           }

                           if(var13 == p_516_3_ + var12 && var14 == p_516_5_ - (var12 - 1)) {
                              var15 = 3;
                           }

                           if(var13 == p_516_3_ - (var12 - 1) && var14 == p_516_5_ + var12) {
                              var15 = 7;
                           }

                           if(var13 == p_516_3_ - var12 && var14 == p_516_5_ + (var12 - 1)) {
                              var15 = 7;
                           }

                           if(var13 == p_516_3_ + (var12 - 1) && var14 == p_516_5_ + var12) {
                              var15 = 9;
                           }

                           if(var13 == p_516_3_ + var12 && var14 == p_516_5_ + (var12 - 1)) {
                              var15 = 9;
                           }
                        }

                        if(var15 == 5 && var11 < p_516_4_ + var7) {
                           var15 = 0;
                        }

                        if((var15 != 0 || p_516_4_ >= p_516_4_ + var7 - 1) && !Block.field_343_p[p_516_1_.func_600_a(var13, var11, var14)]) {
                           this.func_41060_a(p_516_1_, var13, var11, var14, Block.field_35286_bo.field_376_bc + var6, var15);
                        }
                     }
                  }
               }

               for(var11 = 0; var11 < var7; ++var11) {
                  var12 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var11, p_516_5_);
                  if(!Block.field_343_p[var12]) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var11, p_516_5_, Block.field_35286_bo.field_376_bc + var6, 10);
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
