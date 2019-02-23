package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeCorridor4 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCorridor4(int p_i395_1_, Random p_i395_2_, StructureBoundingBox p_i395_3_, int p_i395_4_) {
      super(p_i395_1_);
      this.field_35025_h = p_i395_4_;
      this.field_35024_g = p_i395_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      byte var4 = 1;
      if(this.field_35025_h == 1 || this.field_35025_h == 2) {
         var4 = 5;
      }

      this.func_40019_b((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, var4, p_35004_3_.nextInt(8) > 0);
      this.func_40016_c((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, var4, p_35004_3_.nextInt(8) > 0);
   }

   public static ComponentNetherBridgeCorridor4 func_40039_a(List p_40039_0_, Random p_40039_1_, int p_40039_2_, int p_40039_3_, int p_40039_4_, int p_40039_5_, int p_40039_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40039_2_, p_40039_3_, p_40039_4_, -3, 0, 0, 9, 7, 9, p_40039_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40039_0_, var7) == null?new ComponentNetherBridgeCorridor4(p_40039_6_, p_40039_1_, var7, p_40039_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 8, 1, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 8, 5, 8, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 6, 0, 8, 6, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 2, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 2, 0, 8, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 3, 0, 1, 4, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 3, 0, 7, 4, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 4, 8, 2, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 4, 2, 2, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 1, 4, 7, 2, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 8, 8, 3, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 6, 0, 3, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 3, 6, 8, 3, 7, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 4, 0, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 3, 4, 8, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 3, 5, 2, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 3, 5, 7, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 4, 5, 1, 5, 5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 4, 5, 7, 5, 5, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);

      for(int var4 = 0; var4 <= 5; ++var4) {
         for(int var5 = 0; var5 <= 8; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var5, -1, var4, p_35023_3_);
         }
      }

      return true;
   }
}
