package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Path;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathPoint;

public class PathFinder {

   private IBlockAccess field_1674_a;
   private Path field_1673_b = new Path();
   private IntHashMap field_1676_c = new IntHashMap();
   private PathPoint[] field_1675_d = new PathPoint[32];
   private boolean field_48617_e;
   private boolean field_48615_f;
   private boolean field_48616_g;
   private boolean field_48618_h;


   public PathFinder(IBlockAccess p_i1089_1_, boolean p_i1089_2_, boolean p_i1089_3_, boolean p_i1089_4_, boolean p_i1089_5_) {
      this.field_1674_a = p_i1089_1_;
      this.field_48617_e = p_i1089_2_;
      this.field_48615_f = p_i1089_3_;
      this.field_48616_g = p_i1089_4_;
      this.field_48618_h = p_i1089_5_;
   }

   public PathEntity func_1137_a(Entity p_1137_1_, Entity p_1137_2_, float p_1137_3_) {
      return this.func_1130_a(p_1137_1_, p_1137_2_.field_611_ak, p_1137_2_.field_601_au.field_1697_b, p_1137_2_.field_609_am, p_1137_3_);
   }

   public PathEntity func_1131_a(Entity p_1131_1_, int p_1131_2_, int p_1131_3_, int p_1131_4_, float p_1131_5_) {
      return this.func_1130_a(p_1131_1_, (double)((float)p_1131_2_ + 0.5F), (double)((float)p_1131_3_ + 0.5F), (double)((float)p_1131_4_ + 0.5F), p_1131_5_);
   }

   private PathEntity func_1130_a(Entity p_1130_1_, double p_1130_2_, double p_1130_4_, double p_1130_6_, float p_1130_8_) {
      this.field_1673_b.func_1038_a();
      this.field_1676_c.func_1058_a();
      boolean var9 = this.field_48616_g;
      int var10 = MathHelper.func_1108_b(p_1130_1_.field_601_au.field_1697_b + 0.5D);
      if(this.field_48618_h && p_1130_1_.func_27013_ag()) {
         var10 = (int)p_1130_1_.field_601_au.field_1697_b;

         for(int var11 = this.field_1674_a.func_600_a(MathHelper.func_1108_b(p_1130_1_.field_611_ak), var10, MathHelper.func_1108_b(p_1130_1_.field_609_am)); var11 == Block.field_401_B.field_376_bc || var11 == Block.field_399_C.field_376_bc; var11 = this.field_1674_a.func_600_a(MathHelper.func_1108_b(p_1130_1_.field_611_ak), var10, MathHelper.func_1108_b(p_1130_1_.field_609_am))) {
            ++var10;
         }

         var9 = this.field_48616_g;
         this.field_48616_g = false;
      } else {
         var10 = MathHelper.func_1108_b(p_1130_1_.field_601_au.field_1697_b + 0.5D);
      }

      PathPoint var15 = this.func_1136_a(MathHelper.func_1108_b(p_1130_1_.field_601_au.field_1698_a), var10, MathHelper.func_1108_b(p_1130_1_.field_601_au.field_1704_c));
      PathPoint var12 = this.func_1136_a(MathHelper.func_1108_b(p_1130_2_ - (double)(p_1130_1_.field_644_aC / 2.0F)), MathHelper.func_1108_b(p_1130_4_), MathHelper.func_1108_b(p_1130_6_ - (double)(p_1130_1_.field_644_aC / 2.0F)));
      PathPoint var13 = new PathPoint(MathHelper.func_1110_d(p_1130_1_.field_644_aC + 1.0F), MathHelper.func_1110_d(p_1130_1_.field_643_aD + 1.0F), MathHelper.func_1110_d(p_1130_1_.field_644_aC + 1.0F));
      PathEntity var14 = this.func_1129_a(p_1130_1_, var15, var12, var13, p_1130_8_);
      this.field_48616_g = var9;
      return var14;
   }

   private PathEntity func_1129_a(Entity p_1129_1_, PathPoint p_1129_2_, PathPoint p_1129_3_, PathPoint p_1129_4_, float p_1129_5_) {
      p_1129_2_.field_1713_f = 0.0F;
      p_1129_2_.field_1712_g = p_1129_2_.func_1180_a(p_1129_3_);
      p_1129_2_.field_1711_h = p_1129_2_.field_1712_g;
      this.field_1673_b.func_1038_a();
      this.field_1673_b.func_1034_a(p_1129_2_);
      PathPoint var6 = p_1129_2_;

      while(!this.field_1673_b.func_1039_c()) {
         PathPoint var7 = this.field_1673_b.func_1036_b();
         if(var7.equals(p_1129_3_)) {
            return this.func_1134_a(p_1129_2_, p_1129_3_);
         }

         if(var7.func_1180_a(p_1129_3_) < var6.func_1180_a(p_1129_3_)) {
            var6 = var7;
         }

         var7.field_1709_j = true;
         int var8 = this.func_1133_b(p_1129_1_, var7, p_1129_4_, p_1129_3_, p_1129_5_);

         for(int var9 = 0; var9 < var8; ++var9) {
            PathPoint var10 = this.field_1675_d[var9];
            float var11 = var7.field_1713_f + var7.func_1180_a(var10);
            if(!var10.func_1179_a() || var11 < var10.field_1713_f) {
               var10.field_1710_i = var7;
               var10.field_1713_f = var11;
               var10.field_1712_g = var10.func_1180_a(p_1129_3_);
               if(var10.func_1179_a()) {
                  this.field_1673_b.func_1035_a(var10, var10.field_1713_f + var10.field_1712_g);
               } else {
                  var10.field_1711_h = var10.field_1713_f + var10.field_1712_g;
                  this.field_1673_b.func_1034_a(var10);
               }
            }
         }
      }

      if(var6 == p_1129_2_) {
         return null;
      } else {
         return this.func_1134_a(p_1129_2_, var6);
      }
   }

   private int func_1133_b(Entity p_1133_1_, PathPoint p_1133_2_, PathPoint p_1133_3_, PathPoint p_1133_4_, float p_1133_5_) {
      int var6 = 0;
      byte var7 = 0;
      if(this.func_1132_a(p_1133_1_, p_1133_2_.field_1718_a, p_1133_2_.field_1717_b + 1, p_1133_2_.field_1716_c, p_1133_3_) == 1) {
         var7 = 1;
      }

      PathPoint var8 = this.func_1135_a(p_1133_1_, p_1133_2_.field_1718_a, p_1133_2_.field_1717_b, p_1133_2_.field_1716_c + 1, p_1133_3_, var7);
      PathPoint var9 = this.func_1135_a(p_1133_1_, p_1133_2_.field_1718_a - 1, p_1133_2_.field_1717_b, p_1133_2_.field_1716_c, p_1133_3_, var7);
      PathPoint var10 = this.func_1135_a(p_1133_1_, p_1133_2_.field_1718_a + 1, p_1133_2_.field_1717_b, p_1133_2_.field_1716_c, p_1133_3_, var7);
      PathPoint var11 = this.func_1135_a(p_1133_1_, p_1133_2_.field_1718_a, p_1133_2_.field_1717_b, p_1133_2_.field_1716_c - 1, p_1133_3_, var7);
      if(var8 != null && !var8.field_1709_j && var8.func_1180_a(p_1133_4_) < p_1133_5_) {
         this.field_1675_d[var6++] = var8;
      }

      if(var9 != null && !var9.field_1709_j && var9.func_1180_a(p_1133_4_) < p_1133_5_) {
         this.field_1675_d[var6++] = var9;
      }

      if(var10 != null && !var10.field_1709_j && var10.func_1180_a(p_1133_4_) < p_1133_5_) {
         this.field_1675_d[var6++] = var10;
      }

      if(var11 != null && !var11.field_1709_j && var11.func_1180_a(p_1133_4_) < p_1133_5_) {
         this.field_1675_d[var6++] = var11;
      }

      return var6;
   }

   private PathPoint func_1135_a(Entity p_1135_1_, int p_1135_2_, int p_1135_3_, int p_1135_4_, PathPoint p_1135_5_, int p_1135_6_) {
      PathPoint var7 = null;
      int var8 = this.func_1132_a(p_1135_1_, p_1135_2_, p_1135_3_, p_1135_4_, p_1135_5_);
      if(var8 == 2) {
         return this.func_1136_a(p_1135_2_, p_1135_3_, p_1135_4_);
      } else {
         if(var8 == 1) {
            var7 = this.func_1136_a(p_1135_2_, p_1135_3_, p_1135_4_);
         }

         if(var7 == null && p_1135_6_ > 0 && var8 != -3 && var8 != -4 && this.func_1132_a(p_1135_1_, p_1135_2_, p_1135_3_ + p_1135_6_, p_1135_4_, p_1135_5_) == 1) {
            var7 = this.func_1136_a(p_1135_2_, p_1135_3_ + p_1135_6_, p_1135_4_);
            p_1135_3_ += p_1135_6_;
         }

         if(var7 != null) {
            int var9 = 0;
            int var10 = 0;

            while(p_1135_3_ > 0) {
               var10 = this.func_1132_a(p_1135_1_, p_1135_2_, p_1135_3_ - 1, p_1135_4_, p_1135_5_);
               if(this.field_48616_g && var10 == -1) {
                  return null;
               }

               if(var10 != 1) {
                  break;
               }

               ++var9;
               if(var9 >= 4) {
                  return null;
               }

               --p_1135_3_;
               if(p_1135_3_ > 0) {
                  var7 = this.func_1136_a(p_1135_2_, p_1135_3_, p_1135_4_);
               }
            }

            if(var10 == -2) {
               return null;
            }
         }

         return var7;
      }
   }

   private final PathPoint func_1136_a(int p_1136_1_, int p_1136_2_, int p_1136_3_) {
      int var4 = PathPoint.func_22329_a(p_1136_1_, p_1136_2_, p_1136_3_);
      PathPoint var5 = (PathPoint)this.field_1676_c.func_1057_a(var4);
      if(var5 == null) {
         var5 = new PathPoint(p_1136_1_, p_1136_2_, p_1136_3_);
         this.field_1676_c.func_1061_a(var4, var5);
      }

      return var5;
   }

   private int func_1132_a(Entity p_1132_1_, int p_1132_2_, int p_1132_3_, int p_1132_4_, PathPoint p_1132_5_) {
      boolean var6 = false;

      for(int var7 = p_1132_2_; var7 < p_1132_2_ + p_1132_5_.field_1718_a; ++var7) {
         for(int var8 = p_1132_3_; var8 < p_1132_3_ + p_1132_5_.field_1717_b; ++var8) {
            for(int var9 = p_1132_4_; var9 < p_1132_4_ + p_1132_5_.field_1716_c; ++var9) {
               int var10 = this.field_1674_a.func_600_a(var7, var8, var9);
               if(var10 > 0) {
                  if(var10 == Block.field_28033_bl.field_376_bc) {
                     var6 = true;
                  } else if(var10 != Block.field_401_B.field_376_bc && var10 != Block.field_399_C.field_376_bc) {
                     if(!this.field_48617_e && var10 == Block.field_442_aF.field_376_bc) {
                        return 0;
                     }
                  } else {
                     if(this.field_48616_g) {
                        return -1;
                     }

                     var6 = true;
                  }

                  Block var11 = Block.field_345_n[var10];
                  if(!var11.func_48204_b(this.field_1674_a, var7, var8, var9) && (!this.field_48615_f || var10 != Block.field_442_aF.field_376_bc)) {
                     if(var10 == Block.field_4057_ba.field_376_bc || var10 == Block.field_35277_bw.field_376_bc) {
                        return -3;
                     }

                     if(var10 == Block.field_28033_bl.field_376_bc) {
                        return -4;
                     }

                     Material var12 = var11.field_356_bn;
                     if(var12 != Material.field_1331_g) {
                        return 0;
                     }

                     if(!p_1132_1_.func_359_G()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var6?2:1;
   }

   private PathEntity func_1134_a(PathPoint p_1134_1_, PathPoint p_1134_2_) {
      int var3 = 1;

      PathPoint var4;
      for(var4 = p_1134_2_; var4.field_1710_i != null; var4 = var4.field_1710_i) {
         ++var3;
      }

      PathPoint[] var5 = new PathPoint[var3];
      var4 = p_1134_2_;
      --var3;

      for(var5[var3] = p_1134_2_; var4.field_1710_i != null; var5[var3] = var4) {
         var4 = var4.field_1710_i;
         --var3;
      }

      return new PathEntity(var5);
   }
}
