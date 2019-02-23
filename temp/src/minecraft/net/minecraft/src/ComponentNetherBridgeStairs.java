package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeStairs extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeStairs(int p_i43_1_, Random p_i43_2_, StructureBoundingBox p_i43_3_, int p_i43_4_) {
      super(p_i43_1_);
      this.field_35025_h = p_i43_4_;
      this.field_35024_g = p_i43_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40016_c((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 6, 2, false);
   }

   public static ComponentNetherBridgeStairs func_40031_a(List p_40031_0_, Random p_40031_1_, int p_40031_2_, int p_40031_3_, int p_40031_4_, int p_40031_5_, int p_40031_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40031_2_, p_40031_3_, p_40031_4_, -2, 0, 0, 7, 11, 7, p_40031_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40031_0_, var7) == null?new ComponentNetherBridgeStairs(p_40031_6_, p_40031_1_, var7, p_40031_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 6, 1, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 6, 10, 6, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 1, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 2, 0, 6, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 1, 0, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 2, 1, 6, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 6, 5, 8, 6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 2, 0, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 3, 2, 6, 5, 2, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 3, 4, 6, 5, 4, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 5, 2, 5, p_35023_3_);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 5, 4, 3, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 2, 5, 3, 4, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 2, 5, 2, 5, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 5, 1, 6, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 7, 1, 5, 7, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 8, 2, 6, 8, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 6, 0, 4, 8, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 5, 0, 4, 5, 0, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);

      for(int var4 = 0; var4 <= 6; ++var4) {
         for(int var5 = 0; var5 <= 6; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
         }
      }

      return true;
   }
}
