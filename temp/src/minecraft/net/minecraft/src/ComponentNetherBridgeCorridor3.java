package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCorridor3(int p_i588_1_, Random p_i588_2_, StructureBoundingBox p_i588_3_, int p_i588_4_) {
      super(p_i588_1_);
      this.field_35025_h = p_i588_4_;
      this.field_35024_g = p_i588_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 1, 0, true);
   }

   public static ComponentNetherBridgeCorridor3 func_40042_a(List p_40042_0_, Random p_40042_1_, int p_40042_2_, int p_40042_3_, int p_40042_4_, int p_40042_5_, int p_40042_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40042_2_, p_40042_3_, p_40042_4_, -1, -7, 0, 5, 14, 10, p_40042_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40042_0_, var7) == null?new ComponentNetherBridgeCorridor3(p_40042_6_, p_40042_1_, var7, p_40042_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      int var4 = this.func_35009_c(Block.field_40204_bD.field_376_bc, 2);

      for(int var5 = 0; var5 <= 9; ++var5) {
         int var6 = Math.max(1, 7 - var5);
         int var7 = Math.min(Math.max(var6 + 5, 14 - var5), 13);
         int var8 = var5;
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, var5, 4, var6, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 1, var6 + 1, var5, 3, var7 - 1, var5, 0, 0, false);
         if(var5 <= 6) {
            this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var4, 1, var6 + 1, var5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var4, 2, var6 + 1, var5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_40204_bD.field_376_bc, var4, 3, var6 + 1, var5, p_35023_3_);
         }

         this.func_35011_a(p_35023_1_, p_35023_3_, 0, var7, var5, 4, var7, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, var6 + 1, var5, 0, var7 - 1, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 4, var6 + 1, var5, 4, var7 - 1, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         if((var5 & 1) == 0) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 0, var6 + 2, var5, 0, var6 + 3, var5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, var6 + 2, var5, 4, var6 + 3, var5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
         }

         for(int var9 = 0; var9 <= 4; ++var9) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var9, -1, var8, p_35023_3_);
         }
      }

      return true;
   }
}
