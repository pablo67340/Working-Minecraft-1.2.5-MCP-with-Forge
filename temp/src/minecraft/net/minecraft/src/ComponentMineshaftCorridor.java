package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureMineshaftPieces;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;

public class ComponentMineshaftCorridor extends StructureComponent {

   private final boolean field_35070_a;
   private final boolean field_35068_b;
   private boolean field_35069_c;
   private int field_35067_d;


   public ComponentMineshaftCorridor(int p_i488_1_, Random p_i488_2_, StructureBoundingBox p_i488_3_, int p_i488_4_) {
      super(p_i488_1_);
      this.field_35025_h = p_i488_4_;
      this.field_35024_g = p_i488_3_;
      this.field_35070_a = p_i488_2_.nextInt(3) == 0;
      this.field_35068_b = !this.field_35070_a && p_i488_2_.nextInt(23) == 0;
      if(this.field_35025_h != 2 && this.field_35025_h != 0) {
         this.field_35067_d = p_i488_3_.func_35744_b() / 5;
      } else {
         this.field_35067_d = p_i488_3_.func_35739_d() / 5;
      }

   }

   public static StructureBoundingBox func_35066_a(List p_35066_0_, Random p_35066_1_, int p_35066_2_, int p_35066_3_, int p_35066_4_, int p_35066_5_) {
      StructureBoundingBox var6 = new StructureBoundingBox(p_35066_2_, p_35066_3_, p_35066_4_, p_35066_2_, p_35066_3_ + 2, p_35066_4_);

      int var7;
      for(var7 = p_35066_1_.nextInt(3) + 2; var7 > 0; --var7) {
         int var8 = var7 * 5;
         switch(p_35066_5_) {
         case 0:
            var6.field_35749_d = p_35066_2_ + 2;
            var6.field_35748_f = p_35066_4_ + (var8 - 1);
            break;
         case 1:
            var6.field_35753_a = p_35066_2_ - (var8 - 1);
            var6.field_35748_f = p_35066_4_ + 2;
            break;
         case 2:
            var6.field_35749_d = p_35066_2_ + 2;
            var6.field_35752_c = p_35066_4_ - (var8 - 1);
            break;
         case 3:
            var6.field_35749_d = p_35066_2_ + (var8 - 1);
            var6.field_35748_f = p_35066_4_ + 2;
         }

         if(StructureComponent.func_35020_a(p_35066_0_, var6) == null) {
            break;
         }
      }

      return var7 > 0?var6:null;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      int var4 = this.func_35012_c();
      int var5 = p_35004_3_.nextInt(4);
      switch(this.field_35025_h) {
      case 0:
         if(var5 <= 1) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35748_f + 1, this.field_35025_h, var4);
         } else if(var5 == 2) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35748_f - 3, 1, var4);
         } else {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35748_f - 3, 3, var4);
         }
         break;
      case 1:
         if(var5 <= 1) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c, this.field_35025_h, var4);
         } else if(var5 == 2) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c - 1, 2, var4);
         } else {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35748_f + 1, 0, var4);
         }
         break;
      case 2:
         if(var5 <= 1) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c - 1, this.field_35025_h, var4);
         } else if(var5 == 2) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c, 1, var4);
         } else {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c, 3, var4);
         }
         break;
      case 3:
         if(var5 <= 1) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c, this.field_35025_h, var4);
         } else if(var5 == 2) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d - 3, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35752_c - 1, 2, var4);
         } else {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d - 3, this.field_35024_g.field_35751_b - 1 + p_35004_3_.nextInt(3), this.field_35024_g.field_35748_f + 1, 0, var4);
         }
      }

      if(var4 < 8) {
         int var6;
         int var7;
         if(this.field_35025_h != 2 && this.field_35025_h != 0) {
            for(var6 = this.field_35024_g.field_35753_a + 3; var6 + 3 <= this.field_35024_g.field_35749_d; var6 += 5) {
               var7 = p_35004_3_.nextInt(5);
               if(var7 == 0) {
                  StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, var6, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, var4 + 1);
               } else if(var7 == 1) {
                  StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, var6, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, var4 + 1);
               }
            }
         } else {
            for(var6 = this.field_35024_g.field_35752_c + 3; var6 + 3 <= this.field_35024_g.field_35748_f; var6 += 5) {
               var7 = p_35004_3_.nextInt(5);
               if(var7 == 0) {
                  StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, var6, 1, var4 + 1);
               } else if(var7 == 1) {
                  StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, var6, 3, var4 + 1);
               }
            }
         }
      }

   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         int var8 = this.field_35067_d * 5 - 1;
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 2, 1, var8, 0, 0, false);
         this.func_35010_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.8F, 0, 2, 0, 2, 2, var8, 0, 0, false);
         if(this.field_35068_b) {
            this.func_35010_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.6F, 0, 0, 0, 2, 1, var8, Block.field_9258_W.field_376_bc, 0, false);
         }

         int var9;
         int var10;
         int var11;
         for(var9 = 0; var9 < this.field_35067_d; ++var9) {
            var10 = 2 + var9 * 5;
            this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, var10, 0, 1, var10, Block.field_4057_ba.field_376_bc, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 2, 0, var10, 2, 1, var10, Block.field_4057_ba.field_376_bc, 0, false);
            if(p_35023_2_.nextInt(4) != 0) {
               this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, var10, 2, 2, var10, Block.field_334_y.field_376_bc, 0, false);
            } else {
               this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, var10, 0, 2, var10, Block.field_334_y.field_376_bc, 0, false);
               this.func_35011_a(p_35023_1_, p_35023_3_, 2, 2, var10, 2, 2, var10, Block.field_334_y.field_376_bc, 0, false);
            }

            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 0, 2, var10 - 1, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 2, 2, var10 - 1, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 0, 2, var10 + 1, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 2, 2, var10 + 1, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 0, 2, var10 - 2, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 2, 2, var10 - 2, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 0, 2, var10 + 2, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 2, 2, var10 + 2, Block.field_9258_W.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 1, 2, var10 - 1, Block.field_404_ar.field_376_bc, 0);
            this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.05F, 1, 2, var10 + 1, Block.field_404_ar.field_376_bc, 0);
            if(p_35023_2_.nextInt(100) == 0) {
               this.func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 2, 0, var10 - 1, StructureMineshaftPieces.func_35588_a(), 3 + p_35023_2_.nextInt(4));
            }

            if(p_35023_2_.nextInt(100) == 0) {
               this.func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 0, 0, var10 + 1, StructureMineshaftPieces.func_35588_a(), 3 + p_35023_2_.nextInt(4));
            }

            if(this.field_35068_b && !this.field_35069_c) {
               var11 = this.func_35008_a(0);
               int var12 = var10 - 1 + p_35023_2_.nextInt(3);
               int var13 = this.func_35017_a(1, var12);
               var12 = this.func_35006_b(1, var12);
               if(p_35023_3_.func_35742_b(var13, var11, var12)) {
                  this.field_35069_c = true;
                  p_35023_1_.func_690_d(var13, var11, var12, Block.field_400_at.field_376_bc);
                  TileEntityMobSpawner var14 = (TileEntityMobSpawner)p_35023_1_.func_603_b(var13, var11, var12);
                  if(var14 != null) {
                     var14.func_21098_a("CaveSpider");
                  }
               }
            }
         }

         for(var9 = 0; var9 <= 2; ++var9) {
            for(var10 = 0; var10 <= var8; ++var10) {
               var11 = this.func_35007_a(p_35023_1_, var9, -1, var10, p_35023_3_);
               if(var11 == 0) {
                  this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, var9, -1, var10, p_35023_3_);
               }
            }
         }

         if(this.field_35070_a) {
            for(var9 = 0; var9 <= var8; ++var9) {
               var10 = this.func_35007_a(p_35023_1_, 1, -1, var9, p_35023_3_);
               if(var10 > 0 && Block.field_343_p[var10]) {
                  this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.7F, 1, 0, var9, Block.field_440_aH.field_376_bc, this.func_35009_c(Block.field_440_aH.field_376_bc, 0));
               }
            }
         }

         return true;
      }
   }
}
