package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.EnumDoor;
import net.minecraft.src.Item;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructurePieceTreasure;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

public class ComponentStrongholdLibrary extends ComponentStronghold {

   private static final StructurePieceTreasure[] field_35056_b = new StructurePieceTreasure[]{new StructurePieceTreasure(Item.field_4028_aJ.field_291_aS, 0, 1, 3, 20), new StructurePieceTreasure(Item.field_4029_aI.field_291_aS, 0, 2, 7, 20), new StructurePieceTreasure(Item.field_28010_bb.field_291_aS, 0, 1, 1, 1), new StructurePieceTreasure(Item.field_4025_aO.field_291_aS, 0, 1, 1, 1)};
   protected final EnumDoor field_35058_a;
   private final boolean field_35057_c;


   public ComponentStrongholdLibrary(int p_i35_1_, Random p_i35_2_, StructureBoundingBox p_i35_3_, int p_i35_4_) {
      super(p_i35_1_);
      this.field_35025_h = p_i35_4_;
      this.field_35058_a = this.func_35031_a(p_i35_2_);
      this.field_35024_g = p_i35_3_;
      this.field_35057_c = p_i35_3_.func_35743_c() > 6;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentStrongholdLibrary func_35055_a(List p_35055_0_, Random p_35055_1_, int p_35055_2_, int p_35055_3_, int p_35055_4_, int p_35055_5_, int p_35055_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35055_2_, p_35055_3_, p_35055_4_, -4, -1, 0, 14, 11, 15, p_35055_5_);
      if(!func_35030_a(var7) || StructureComponent.func_35020_a(p_35055_0_, var7) != null) {
         var7 = StructureBoundingBox.func_35747_a(p_35055_2_, p_35055_3_, p_35055_4_, -4, -1, 0, 14, 6, 15, p_35055_5_);
         if(!func_35030_a(var7) || StructureComponent.func_35020_a(p_35055_0_, var7) != null) {
            return null;
         }
      }

      return new ComponentStrongholdLibrary(p_35055_6_, p_35055_1_, var7, p_35055_5_);
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         byte var4 = 11;
         if(!this.field_35057_c) {
            var4 = 6;
         }

         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 13, var4 - 1, 14, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35058_a, 4, 1, 0);
         this.func_35010_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.07F, 2, 1, 1, 11, 4, 13, Block.field_9258_W.field_376_bc, Block.field_9258_W.field_376_bc, false);

         int var7;
         for(var7 = 1; var7 <= 13; ++var7) {
            if((var7 - 1) % 4 == 0) {
               this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, var7, 1, 4, var7, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
               this.func_35011_a(p_35023_1_, p_35023_3_, 12, 1, var7, 12, 4, var7, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
               this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 2, 3, var7, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 11, 3, var7, p_35023_3_);
               if(this.field_35057_c) {
                  this.func_35011_a(p_35023_1_, p_35023_3_, 1, 6, var7, 1, 9, var7, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
                  this.func_35011_a(p_35023_1_, p_35023_3_, 12, 6, var7, 12, 9, var7, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
               }
            } else {
               this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, var7, 1, 4, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
               this.func_35011_a(p_35023_1_, p_35023_3_, 12, 1, var7, 12, 4, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
               if(this.field_35057_c) {
                  this.func_35011_a(p_35023_1_, p_35023_3_, 1, 6, var7, 1, 9, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
                  this.func_35011_a(p_35023_1_, p_35023_3_, 12, 6, var7, 12, 9, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
               }
            }
         }

         for(var7 = 3; var7 < 12; var7 += 2) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 3, 1, var7, 4, 3, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 6, 1, var7, 7, 3, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 9, 1, var7, 10, 3, var7, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
         }

         if(this.field_35057_c) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 1, 3, 5, 13, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 10, 5, 1, 12, 5, 13, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 5, 1, 9, 5, 2, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 5, 12, 9, 5, 13, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
            this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 9, 5, 11, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 5, 11, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 9, 5, 10, p_35023_3_);
            this.func_35011_a(p_35023_1_, p_35023_3_, 3, 6, 2, 3, 6, 12, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 10, 6, 2, 10, 6, 10, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 6, 2, 9, 6, 2, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 6, 12, 8, 6, 12, Block.field_4057_ba.field_376_bc, Block.field_4057_ba.field_376_bc, false);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 9, 6, 11, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 8, 6, 11, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 9, 6, 10, p_35023_3_);
            var7 = this.func_35009_c(Block.field_441_aG.field_376_bc, 3);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 1, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 2, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 3, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 4, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 5, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 6, 13, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var7, 10, 7, 13, p_35023_3_);
            byte var8 = 7;
            byte var9 = 7;
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 1, 9, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8, 9, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 1, 8, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8, 8, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 1, 7, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8, 7, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 2, 7, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 + 1, 7, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 1, 7, var9 - 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8 - 1, 7, var9 + 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8, 7, var9 - 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, var8, 7, var9 + 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8 - 2, 8, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8 + 1, 8, var9, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8 - 1, 8, var9 - 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8 - 1, 8, var9 + 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8, 8, var9 - 1, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, var8, 8, var9 + 1, p_35023_3_);
         }

         this.func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 3, 3, 5, field_35056_b, 1 + p_35023_2_.nextInt(4));
         if(this.field_35057_c) {
            this.func_35018_a(p_35023_1_, 0, 0, 12, 9, 1, p_35023_3_);
            this.func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 12, 8, 1, field_35056_b, 1 + p_35023_2_.nextInt(4));
         }

         return true;
      }
   }

}
