package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeCrossing3 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCrossing3(int p_i443_1_, Random p_i443_2_, StructureBoundingBox p_i443_3_, int p_i443_4_) {
      super(p_i443_1_);
      this.field_35025_h = p_i443_4_;
      this.field_35024_g = p_i443_3_;
   }

   protected ComponentNetherBridgeCrossing3(Random p_i444_1_, int p_i444_2_, int p_i444_3_) {
      super(0);
      this.field_35025_h = p_i444_1_.nextInt(4);
      switch(this.field_35025_h) {
      case 0:
      case 2:
         this.field_35024_g = new StructureBoundingBox(p_i444_2_, 64, p_i444_3_, p_i444_2_ + 19 - 1, 73, p_i444_3_ + 19 - 1);
         break;
      default:
         this.field_35024_g = new StructureBoundingBox(p_i444_2_, 64, p_i444_3_, p_i444_2_ + 19 - 1, 73, p_i444_3_ + 19 - 1);
      }

   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_40022_a((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 8, 3, false);
      this.func_40019_b((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 3, 8, false);
      this.func_40016_c((ComponentNetherBridgeStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 3, 8, false);
   }

   public static ComponentNetherBridgeCrossing3 func_40033_a(List p_40033_0_, Random p_40033_1_, int p_40033_2_, int p_40033_3_, int p_40033_4_, int p_40033_5_, int p_40033_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40033_2_, p_40033_3_, p_40033_4_, -8, -3, 0, 19, 10, 19, p_40033_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40033_0_, var7) == null?new ComponentNetherBridgeCrossing3(p_40033_6_, p_40033_1_, var7, p_40033_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 3, 0, 11, 4, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, 7, 18, 4, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 5, 0, 10, 7, 18, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 8, 18, 7, 10, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 5, 0, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 5, 11, 7, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 0, 11, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 11, 11, 5, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 7, 7, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 7, 18, 5, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 11, 7, 5, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 11, 5, 11, 18, 5, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 2, 0, 11, 2, 5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 2, 13, 11, 2, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 0, 0, 11, 1, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 0, 15, 11, 1, 18, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      int var4;
      int var5;
      for(var4 = 7; var4 <= 11; ++var4) {
         for(var5 = 0; var5 <= 2; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, 18 - var5, p_35023_3_);
         }
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 7, 5, 2, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 13, 2, 7, 18, 2, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 7, 3, 1, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 15, 0, 7, 18, 1, 11, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      for(var4 = 0; var4 <= 2; ++var4) {
         for(var5 = 7; var5 <= 11; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, 18 - var4, -1, var5, p_35023_3_);
         }
      }

      return true;
   }
}
