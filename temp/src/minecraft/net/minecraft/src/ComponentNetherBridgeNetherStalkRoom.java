package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeNetherStalkRoom extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeNetherStalkRoom(int p_i669_1_, Random p_i669_2_, StructureBoundingBox p_i669_3_, int p_i669_4_) {
      super(p_i669_1_);
      this.field_35025_h = p_i669_4_;
      this.field_35024_g = p_i669_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 5, 3, true);
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 5, 11, true);
   }

   public static ComponentNetherBridgeNetherStalkRoom func_40040_a(List p_40040_0_, Random p_40040_1_, int p_40040_2_, int p_40040_3_, int p_40040_4_, int p_40040_5_, int p_40040_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40040_2_, p_40040_3_, p_40040_4_, -5, -3, 0, 13, 14, 13, p_40040_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40040_0_, var7) == null?new ComponentNetherBridgeNetherStalkRoom(p_40040_6_, p_40040_1_, var7, p_40040_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 0, 12, 4, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 12, 13, 12, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 1, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 0, 12, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 11, 4, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 11, 10, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 9, 11, 7, 12, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 0, 4, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 0, 10, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 9, 0, 7, 12, 1, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 11, 2, 10, 12, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      int var4;
      for(var4 = 1; var4 <= 11; var4 += 2) {
         this.func_35011_a(p_35023_1_, p_35023_3_, var4, 10, 0, var4, 11, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, var4, 10, 12, var4, 11, 12, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 10, var4, 0, 11, var4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 12, 10, var4, 12, 11, var4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, 13, 0, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, 13, 12, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 0, 13, var4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 12, 13, var4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, var4 + 1, 13, 0, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, var4 + 1, 13, 12, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, var4 + 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 12, 13, var4 + 1, p_35023_3_);
      }

      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 12, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 0, 13, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 12, 13, 0, p_35023_3_);

      for(var4 = 3; var4 <= 9; var4 += 2) {
         this.func_35011_a(p_35023_1_, p_35023_3_, 1, 7, var4, 1, 8, var4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 11, 7, var4, 11, 8, var4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      }

      var4 = this.func_35009_c(Block.field_40204_bD.field_376_bc, 3);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 <= 6; ++var5) {
         var6 = var5 + 4;

         for(var7 = 5; var7 <= 7; ++var7) {
            this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var4, var7, 5 + var5, var6, p_35023_3_);
         }

         if(var6 >= 5 && var6 <= 8) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 5, 5, var6, 7, var5 + 4, var6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         } else if(var6 >= 9 && var6 <= 10) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 5, 8, var6, 7, var5 + 4, var6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         }

         if(var5 >= 1) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 5, 6 + var5, var6, 7, 9 + var5, var6, 0, 0, false);
         }
      }

      for(var5 = 5; var5 <= 7; ++var5) {
         this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var4, var5, 12, 11, p_35023_3_);
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 6, 7, 5, 7, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 6, 7, 7, 7, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 13, 12, 7, 13, 12, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 2, 3, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 9, 3, 5, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 4, 2, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 9, 5, 2, 10, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 9, 5, 9, 10, 5, 10, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 10, 5, 4, 10, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      var5 = this.func_35009_c(Block.field_40204_bD.field_376_bc, 0);
      var6 = this.func_35009_c(Block.field_40204_bD.field_376_bc, 1);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var6, 4, 5, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var6, 4, 5, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var6, 4, 5, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var6, 4, 5, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var5, 8, 5, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var5, 8, 5, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var5, 8, 5, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var5, 8, 5, 10, p_35023_3_);
      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 4, 4, 4, 4, 8, Block.field_4051_bd.field_376_bc, Block.field_4051_bd.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 4, 4, 9, 4, 8, Block.field_4051_bd.field_376_bc, Block.field_4051_bd.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 5, 4, 4, 5, 8, Block.field_40205_bE.field_376_bc, Block.field_40205_bE.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 4, 9, 5, 8, Block.field_40205_bE.field_376_bc, Block.field_40205_bE.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 0, 8, 2, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 4, 12, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 0, 8, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 9, 8, 1, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 4, 3, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 9, 0, 4, 12, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      int var8;
      for(var7 = 4; var7 <= 8; ++var7) {
         for(var8 = 0; var8 <= 2; ++var8) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var7, -1, var8, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var7, -1, 12 - var8, p_35023_3_);
         }
      }

      for(var7 = 0; var7 <= 2; ++var7) {
         for(var8 = 4; var8 <= 8; ++var8) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var7, -1, var8, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 12 - var7, -1, var8, p_35023_3_);
         }
      }

      return true;
   }
}
