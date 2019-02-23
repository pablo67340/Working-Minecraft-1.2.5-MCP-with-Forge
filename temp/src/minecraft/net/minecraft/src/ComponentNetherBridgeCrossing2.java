package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeCrossing2 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCrossing2(int p_i210_1_, Random p_i210_2_, StructureBoundingBox p_i210_3_, int p_i210_4_) {
      super(p_i210_1_);
      this.field_35025_h = p_i210_4_;
      this.field_35024_g = p_i210_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 1, 0, true);
      this.func_40019_b((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, 1, true);
      this.func_40016_c((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, 1, true);
   }

   public static ComponentNetherBridgeCrossing2 func_40025_a(List p_40025_0_, Random p_40025_1_, int p_40025_2_, int p_40025_3_, int p_40025_4_, int p_40025_5_, int p_40025_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40025_2_, p_40025_3_, p_40025_4_, -1, 0, 0, 5, 7, 5, p_40025_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40025_0_, var7) == null?new ComponentNetherBridgeCrossing2(p_40025_6_, p_40025_1_, var7, p_40025_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 1, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 4, 5, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 0, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 0, 4, 5, 0, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 4, 0, 5, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 2, 4, 4, 5, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 6, 0, 4, 6, 4, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      for(int var4 = 0; var4 <= 4; ++var4) {
         for(int var5 = 0; var5 <= 4; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
         }
      }

      return true;
   }
}
