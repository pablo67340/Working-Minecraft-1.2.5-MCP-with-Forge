package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeEntrance extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeEntrance(int p_i514_1_, Random p_i514_2_, StructureBoundingBox p_i514_3_, int p_i514_4_) {
      super(p_i514_1_);
      this.field_35025_h = p_i514_4_;
      this.field_35024_g = p_i514_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 5, 3, true);
   }

   public static ComponentNetherBridgeEntrance func_40030_a(List p_40030_0_, Random p_40030_1_, int p_40030_2_, int p_40030_3_, int p_40030_4_, int p_40030_5_, int p_40030_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40030_2_, p_40030_3_, p_40030_4_, -5, -3, 0, 13, 14, 13, p_40030_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40030_0_, var7) == null?new ComponentNetherBridgeEntrance(p_40030_6_, p_40030_1_, var7, p_40030_5_):null;
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
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 8, 0, 7, 8, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);

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

      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 0, 8, 2, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 4, 12, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 0, 8, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 9, 8, 1, 12, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 4, 3, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 9, 0, 4, 12, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      int var5;
      for(var4 = 4; var4 <= 8; ++var4) {
         for(var5 = 0; var5 <= 2; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, 12 - var5, p_35023_3_);
         }
      }

      for(var4 = 0; var4 <= 2; ++var4) {
         for(var5 = 4; var5 <= 8; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 12 - var4, -1, var5, p_35023_3_);
         }
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 5, 5, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 1, 6, 6, 4, 6, 0, 0, false);
      this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 6, 0, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_397_D.field_376_bc, 0, 6, 5, 6, p_35023_3_);
      var4 = this.func_35017_a(6, 6);
      var5 = this.func_35008_a(5);
      int var6 = this.func_35006_b(6, 6);
      if(p_35023_3_.func_35742_b(var4, var5, var6)) {
         p_35023_1_.field_4214_a = true;
         Block.field_345_n[Block.field_397_D.field_376_bc].func_208_a(p_35023_1_, var4, var5, var6, p_35023_2_);
         p_35023_1_.field_4214_a = false;
      }

      return true;
   }
}
