package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeStraight extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeStraight(int p_i277_1_, Random p_i277_2_, StructureBoundingBox p_i277_3_, int p_i277_4_) {
      super(p_i277_1_);
      this.field_35025_h = p_i277_4_;
      this.field_35024_g = p_i277_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 1, 3, false);
   }

   public static ComponentNetherBridgeStraight func_40029_a(List p_40029_0_, Random p_40029_1_, int p_40029_2_, int p_40029_3_, int p_40029_4_, int p_40029_5_, int p_40029_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40029_2_, p_40029_3_, p_40029_4_, -1, -3, 0, 5, 10, 19, p_40029_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40029_0_, var7) == null?new ComponentNetherBridgeStraight(p_40029_6_, p_40029_1_, var7, p_40029_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 0, 4, 4, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 0, 3, 7, 18, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 0, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 5, 0, 4, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 4, 2, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 13, 4, 2, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 15, 4, 1, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      for(int var4 = 0; var4 <= 4; ++var4) {
         for(int var5 = 0; var5 <= 2; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, 18 - var5, p_35023_3_);
         }
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 1, 0, 4, 1, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 4, 0, 4, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 14, 0, 4, 14, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 17, 0, 4, 17, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 1, 4, 4, 1, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 3, 4, 4, 4, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 3, 14, 4, 4, 14, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 17, 4, 4, 17, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      return true;
   }
}
