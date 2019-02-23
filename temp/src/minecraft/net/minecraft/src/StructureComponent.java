package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Item;
import net.minecraft.src.ItemDoor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructurePieceBlockSelector;
import net.minecraft.src.StructurePieceTreasure;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.WeightedRandom;
import net.minecraft.src.World;

public abstract class StructureComponent {

   protected StructureBoundingBox field_35024_g;
   protected int field_35025_h;
   protected int field_35026_i;


   protected StructureComponent(int p_i353_1_) {
      this.field_35026_i = p_i353_1_;
      this.field_35025_h = -1;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public abstract boolean func_35023_a(World var1, Random var2, StructureBoundingBox var3);

   public StructureBoundingBox func_35021_b() {
      return this.field_35024_g;
   }

   public int func_35012_c() {
      return this.field_35026_i;
   }

   public static StructureComponent func_35020_a(List p_35020_0_, StructureBoundingBox p_35020_1_) {
      Iterator var2 = p_35020_0_.iterator();

      StructureComponent var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (StructureComponent)var2.next();
      } while(var3.func_35021_b() == null || !var3.func_35021_b().func_35740_a(p_35020_1_));

      return var3;
   }

   public ChunkPosition func_40008_a_() {
      return new ChunkPosition(this.field_35024_g.func_40597_e(), this.field_35024_g.func_40596_f(), this.field_35024_g.func_40598_g());
   }

   protected boolean func_35013_a(World p_35013_1_, StructureBoundingBox p_35013_2_) {
      int var3 = Math.max(this.field_35024_g.field_35753_a - 1, p_35013_2_.field_35753_a);
      int var4 = Math.max(this.field_35024_g.field_35751_b - 1, p_35013_2_.field_35751_b);
      int var5 = Math.max(this.field_35024_g.field_35752_c - 1, p_35013_2_.field_35752_c);
      int var6 = Math.min(this.field_35024_g.field_35749_d + 1, p_35013_2_.field_35749_d);
      int var7 = Math.min(this.field_35024_g.field_35750_e + 1, p_35013_2_.field_35750_e);
      int var8 = Math.min(this.field_35024_g.field_35748_f + 1, p_35013_2_.field_35748_f);

      int var9;
      int var10;
      int var11;
      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var5; var10 <= var8; ++var10) {
            var11 = p_35013_1_.func_600_a(var9, var4, var10);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }

            var11 = p_35013_1_.func_600_a(var9, var7, var10);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }
         }
      }

      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            var11 = p_35013_1_.func_600_a(var9, var10, var5);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }

            var11 = p_35013_1_.func_600_a(var9, var10, var8);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }
         }
      }

      for(var9 = var5; var9 <= var8; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            var11 = p_35013_1_.func_600_a(var3, var10, var9);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }

            var11 = p_35013_1_.func_600_a(var6, var10, var9);
            if(var11 > 0 && Block.field_345_n[var11].field_356_bn.func_879_d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int func_35017_a(int p_35017_1_, int p_35017_2_) {
      switch(this.field_35025_h) {
      case 0:
      case 2:
         return this.field_35024_g.field_35753_a + p_35017_1_;
      case 1:
         return this.field_35024_g.field_35749_d - p_35017_2_;
      case 3:
         return this.field_35024_g.field_35753_a + p_35017_2_;
      default:
         return p_35017_1_;
      }
   }

   protected int func_35008_a(int p_35008_1_) {
      return this.field_35025_h == -1?p_35008_1_:p_35008_1_ + this.field_35024_g.field_35751_b;
   }

   protected int func_35006_b(int p_35006_1_, int p_35006_2_) {
      switch(this.field_35025_h) {
      case 0:
         return this.field_35024_g.field_35752_c + p_35006_2_;
      case 1:
      case 3:
         return this.field_35024_g.field_35752_c + p_35006_1_;
      case 2:
         return this.field_35024_g.field_35748_f - p_35006_2_;
      default:
         return p_35006_2_;
      }
   }

   protected int func_35009_c(int p_35009_1_, int p_35009_2_) {
      if(p_35009_1_ == Block.field_440_aH.field_376_bc) {
         if(this.field_35025_h == 1 || this.field_35025_h == 3) {
            if(p_35009_2_ == 1) {
               return 0;
            }

            return 1;
         }
      } else if(p_35009_1_ != Block.field_442_aF.field_376_bc && p_35009_1_ != Block.field_435_aM.field_376_bc) {
         if(p_35009_1_ != Block.field_4069_aI.field_376_bc && p_35009_1_ != Block.field_4059_au.field_376_bc && p_35009_1_ != Block.field_40204_bD.field_376_bc && p_35009_1_ != Block.field_35279_by.field_376_bc) {
            if(p_35009_1_ == Block.field_441_aG.field_376_bc) {
               if(this.field_35025_h == 0) {
                  if(p_35009_2_ == 2) {
                     return 3;
                  }

                  if(p_35009_2_ == 3) {
                     return 2;
                  }
               } else if(this.field_35025_h == 1) {
                  if(p_35009_2_ == 2) {
                     return 4;
                  }

                  if(p_35009_2_ == 3) {
                     return 5;
                  }

                  if(p_35009_2_ == 4) {
                     return 2;
                  }

                  if(p_35009_2_ == 5) {
                     return 3;
                  }
               } else if(this.field_35025_h == 3) {
                  if(p_35009_2_ == 2) {
                     return 5;
                  }

                  if(p_35009_2_ == 3) {
                     return 4;
                  }

                  if(p_35009_2_ == 4) {
                     return 2;
                  }

                  if(p_35009_2_ == 5) {
                     return 3;
                  }
               }
            } else if(p_35009_1_ == Block.field_4064_aS.field_376_bc) {
               if(this.field_35025_h == 0) {
                  if(p_35009_2_ == 3) {
                     return 4;
                  }

                  if(p_35009_2_ == 4) {
                     return 3;
                  }
               } else if(this.field_35025_h == 1) {
                  if(p_35009_2_ == 3) {
                     return 1;
                  }

                  if(p_35009_2_ == 4) {
                     return 2;
                  }

                  if(p_35009_2_ == 2) {
                     return 3;
                  }

                  if(p_35009_2_ == 1) {
                     return 4;
                  }
               } else if(this.field_35025_h == 3) {
                  if(p_35009_2_ == 3) {
                     return 2;
                  }

                  if(p_35009_2_ == 4) {
                     return 1;
                  }

                  if(p_35009_2_ == 2) {
                     return 3;
                  }

                  if(p_35009_2_ == 1) {
                     return 4;
                  }
               }
            }
         } else if(this.field_35025_h == 0) {
            if(p_35009_2_ == 2) {
               return 3;
            }

            if(p_35009_2_ == 3) {
               return 2;
            }
         } else if(this.field_35025_h == 1) {
            if(p_35009_2_ == 0) {
               return 2;
            }

            if(p_35009_2_ == 1) {
               return 3;
            }

            if(p_35009_2_ == 2) {
               return 0;
            }

            if(p_35009_2_ == 3) {
               return 1;
            }
         } else if(this.field_35025_h == 3) {
            if(p_35009_2_ == 0) {
               return 2;
            }

            if(p_35009_2_ == 1) {
               return 3;
            }

            if(p_35009_2_ == 2) {
               return 1;
            }

            if(p_35009_2_ == 3) {
               return 0;
            }
         }
      } else if(this.field_35025_h == 0) {
         if(p_35009_2_ == 0) {
            return 2;
         }

         if(p_35009_2_ == 2) {
            return 0;
         }
      } else {
         if(this.field_35025_h == 1) {
            return p_35009_2_ + 1 & 3;
         }

         if(this.field_35025_h == 3) {
            return p_35009_2_ + 3 & 3;
         }
      }

      return p_35009_2_;
   }

   protected void func_35018_a(World p_35018_1_, int p_35018_2_, int p_35018_3_, int p_35018_4_, int p_35018_5_, int p_35018_6_, StructureBoundingBox p_35018_7_) {
      int var8 = this.func_35017_a(p_35018_4_, p_35018_6_);
      int var9 = this.func_35008_a(p_35018_5_);
      int var10 = this.func_35006_b(p_35018_4_, p_35018_6_);
      if(p_35018_7_.func_35742_b(var8, var9, var10)) {
         p_35018_1_.func_643_a(var8, var9, var10, p_35018_2_, p_35018_3_);
      }
   }

   protected int func_35007_a(World p_35007_1_, int p_35007_2_, int p_35007_3_, int p_35007_4_, StructureBoundingBox p_35007_5_) {
      int var6 = this.func_35017_a(p_35007_2_, p_35007_4_);
      int var7 = this.func_35008_a(p_35007_3_);
      int var8 = this.func_35006_b(p_35007_2_, p_35007_4_);
      return !p_35007_5_.func_35742_b(var6, var7, var8)?0:p_35007_1_.func_600_a(var6, var7, var8);
   }

   protected void func_35011_a(World p_35011_1_, StructureBoundingBox p_35011_2_, int p_35011_3_, int p_35011_4_, int p_35011_5_, int p_35011_6_, int p_35011_7_, int p_35011_8_, int p_35011_9_, int p_35011_10_, boolean p_35011_11_) {
      for(int var12 = p_35011_4_; var12 <= p_35011_7_; ++var12) {
         for(int var13 = p_35011_3_; var13 <= p_35011_6_; ++var13) {
            for(int var14 = p_35011_5_; var14 <= p_35011_8_; ++var14) {
               if(!p_35011_11_ || this.func_35007_a(p_35011_1_, var13, var12, var14, p_35011_2_) != 0) {
                  if(var12 != p_35011_4_ && var12 != p_35011_7_ && var13 != p_35011_3_ && var13 != p_35011_6_ && var14 != p_35011_5_ && var14 != p_35011_8_) {
                     this.func_35018_a(p_35011_1_, p_35011_10_, 0, var13, var12, var14, p_35011_2_);
                  } else {
                     this.func_35018_a(p_35011_1_, p_35011_9_, 0, var13, var12, var14, p_35011_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_35022_a(World p_35022_1_, StructureBoundingBox p_35022_2_, int p_35022_3_, int p_35022_4_, int p_35022_5_, int p_35022_6_, int p_35022_7_, int p_35022_8_, boolean p_35022_9_, Random p_35022_10_, StructurePieceBlockSelector p_35022_11_) {
      for(int var12 = p_35022_4_; var12 <= p_35022_7_; ++var12) {
         for(int var13 = p_35022_3_; var13 <= p_35022_6_; ++var13) {
            for(int var14 = p_35022_5_; var14 <= p_35022_8_; ++var14) {
               if(!p_35022_9_ || this.func_35007_a(p_35022_1_, var13, var12, var14, p_35022_2_) != 0) {
                  p_35022_11_.func_35706_a(p_35022_10_, var13, var12, var14, var12 == p_35022_4_ || var12 == p_35022_7_ || var13 == p_35022_3_ || var13 == p_35022_6_ || var14 == p_35022_5_ || var14 == p_35022_8_);
                  this.func_35018_a(p_35022_1_, p_35022_11_.func_35707_a(), p_35022_11_.func_35708_b(), var13, var12, var14, p_35022_2_);
               }
            }
         }
      }

   }

   protected void func_35010_a(World p_35010_1_, StructureBoundingBox p_35010_2_, Random p_35010_3_, float p_35010_4_, int p_35010_5_, int p_35010_6_, int p_35010_7_, int p_35010_8_, int p_35010_9_, int p_35010_10_, int p_35010_11_, int p_35010_12_, boolean p_35010_13_) {
      for(int var14 = p_35010_6_; var14 <= p_35010_9_; ++var14) {
         for(int var15 = p_35010_5_; var15 <= p_35010_8_; ++var15) {
            for(int var16 = p_35010_7_; var16 <= p_35010_10_; ++var16) {
               if(p_35010_3_.nextFloat() <= p_35010_4_ && (!p_35010_13_ || this.func_35007_a(p_35010_1_, var15, var14, var16, p_35010_2_) != 0)) {
                  if(var14 != p_35010_6_ && var14 != p_35010_9_ && var15 != p_35010_5_ && var15 != p_35010_8_ && var16 != p_35010_7_ && var16 != p_35010_10_) {
                     this.func_35018_a(p_35010_1_, p_35010_12_, 0, var15, var14, var16, p_35010_2_);
                  } else {
                     this.func_35018_a(p_35010_1_, p_35010_11_, 0, var15, var14, var16, p_35010_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_35014_a(World p_35014_1_, StructureBoundingBox p_35014_2_, Random p_35014_3_, float p_35014_4_, int p_35014_5_, int p_35014_6_, int p_35014_7_, int p_35014_8_, int p_35014_9_) {
      if(p_35014_3_.nextFloat() < p_35014_4_) {
         this.func_35018_a(p_35014_1_, p_35014_8_, p_35014_9_, p_35014_5_, p_35014_6_, p_35014_7_, p_35014_2_);
      }

   }

   protected void func_35015_a(World p_35015_1_, StructureBoundingBox p_35015_2_, int p_35015_3_, int p_35015_4_, int p_35015_5_, int p_35015_6_, int p_35015_7_, int p_35015_8_, int p_35015_9_, boolean p_35015_10_) {
      float var11 = (float)(p_35015_6_ - p_35015_3_ + 1);
      float var12 = (float)(p_35015_7_ - p_35015_4_ + 1);
      float var13 = (float)(p_35015_8_ - p_35015_5_ + 1);
      float var14 = (float)p_35015_3_ + var11 / 2.0F;
      float var15 = (float)p_35015_5_ + var13 / 2.0F;

      for(int var16 = p_35015_4_; var16 <= p_35015_7_; ++var16) {
         float var17 = (float)(var16 - p_35015_4_) / var12;

         for(int var18 = p_35015_3_; var18 <= p_35015_6_; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = p_35015_5_; var20 <= p_35015_8_; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!p_35015_10_ || this.func_35007_a(p_35015_1_, var18, var16, var20, p_35015_2_) != 0) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.func_35018_a(p_35015_1_, p_35015_9_, 0, var18, var16, var20, p_35015_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_35016_b(World p_35016_1_, int p_35016_2_, int p_35016_3_, int p_35016_4_, StructureBoundingBox p_35016_5_) {
      int var6 = this.func_35017_a(p_35016_2_, p_35016_4_);
      int var7 = this.func_35008_a(p_35016_3_);
      int var8 = this.func_35006_b(p_35016_2_, p_35016_4_);
      if(p_35016_5_.func_35742_b(var6, var7, var8)) {
         while(!p_35016_1_.func_20084_d(var6, var7, var8) && var7 < 255) {
            p_35016_1_.func_643_a(var6, var7, var8, 0, 0);
            ++var7;
         }

      }
   }

   protected void func_35005_b(World p_35005_1_, int p_35005_2_, int p_35005_3_, int p_35005_4_, int p_35005_5_, int p_35005_6_, StructureBoundingBox p_35005_7_) {
      int var8 = this.func_35017_a(p_35005_4_, p_35005_6_);
      int var9 = this.func_35008_a(p_35005_5_);
      int var10 = this.func_35006_b(p_35005_4_, p_35005_6_);
      if(p_35005_7_.func_35742_b(var8, var9, var10)) {
         while((p_35005_1_.func_20084_d(var8, var9, var10) || p_35005_1_.func_599_f(var8, var9, var10).func_879_d()) && var9 > 1) {
            p_35005_1_.func_643_a(var8, var9, var10, p_35005_2_, p_35005_3_);
            --var9;
         }

      }
   }

   protected void func_35003_a(World p_35003_1_, StructureBoundingBox p_35003_2_, Random p_35003_3_, int p_35003_4_, int p_35003_5_, int p_35003_6_, StructurePieceTreasure[] p_35003_7_, int p_35003_8_) {
      int var9 = this.func_35017_a(p_35003_4_, p_35003_6_);
      int var10 = this.func_35008_a(p_35003_5_);
      int var11 = this.func_35006_b(p_35003_4_, p_35003_6_);
      if(p_35003_2_.func_35742_b(var9, var10, var11) && p_35003_1_.func_600_a(var9, var10, var11) != Block.field_396_av.field_376_bc) {
         p_35003_1_.func_690_d(var9, var10, var11, Block.field_396_av.field_376_bc);
         TileEntityChest var12 = (TileEntityChest)p_35003_1_.func_603_b(var9, var10, var11);
         if(var12 != null) {
            func_35019_a(p_35003_3_, p_35003_7_, var12, p_35003_8_);
         }
      }

   }

   private static void func_35019_a(Random p_35019_0_, StructurePieceTreasure[] p_35019_1_, TileEntityChest p_35019_2_, int p_35019_3_) {
      for(int var4 = 0; var4 < p_35019_3_; ++var4) {
         StructurePieceTreasure var5 = (StructurePieceTreasure)WeightedRandom.func_35735_a(p_35019_0_, p_35019_1_);
         int var6 = var5.field_35595_c + p_35019_0_.nextInt(var5.field_35593_e - var5.field_35595_c + 1);
         if(Item.field_233_c[var5.field_35596_a].func_200_b() >= var6) {
            p_35019_2_.func_472_a(p_35019_0_.nextInt(p_35019_2_.func_469_c()), new ItemStack(var5.field_35596_a, var6, var5.field_35594_b));
         } else {
            for(int var7 = 0; var7 < var6; ++var7) {
               p_35019_2_.func_472_a(p_35019_0_.nextInt(p_35019_2_.func_469_c()), new ItemStack(var5.field_35596_a, 1, var5.field_35594_b));
            }
         }
      }

   }

   protected void func_35002_a(World p_35002_1_, StructureBoundingBox p_35002_2_, Random p_35002_3_, int p_35002_4_, int p_35002_5_, int p_35002_6_, int p_35002_7_) {
      int var8 = this.func_35017_a(p_35002_4_, p_35002_6_);
      int var9 = this.func_35008_a(p_35002_5_);
      int var10 = this.func_35006_b(p_35002_4_, p_35002_6_);
      if(p_35002_2_.func_35742_b(var8, var9, var10)) {
         ItemDoor.func_35434_a(p_35002_1_, var8, var9, var10, p_35002_7_, Block.field_442_aF);
      }

   }
}
