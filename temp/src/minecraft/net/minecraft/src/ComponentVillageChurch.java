package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentVillageChurch extends ComponentVillage {

   private int field_35098_a = -1;


   public ComponentVillageChurch(int p_i72_1_, Random p_i72_2_, StructureBoundingBox p_i72_3_, int p_i72_4_) {
      super(p_i72_1_);
      this.field_35025_h = p_i72_4_;
      this.field_35024_g = p_i72_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentVillageChurch func_35097_a(List p_35097_0_, Random p_35097_1_, int p_35097_2_, int p_35097_3_, int p_35097_4_, int p_35097_5_, int p_35097_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35097_2_, p_35097_3_, p_35097_4_, 0, 0, 0, 5, 12, 9, p_35097_5_);
      return func_35074_a(var7) && StructureComponent.func_35020_a(p_35097_0_, var7) == null?new ComponentVillageChurch(p_35097_6_, p_35097_1_, var7, p_35097_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.field_35098_a < 0) {
         this.field_35098_a = this.func_35075_b(p_35023_1_, p_35023_3_);
         if(this.field_35098_a < 0) {
            return true;
         }

         this.field_35024_g.func_35745_a(0, this.field_35098_a - this.field_35024_g.field_35750_e + 12 - 1, 0);
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 1, 3, 3, 7, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 1, 3, 9, 3, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 0, 3, 0, 8, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 0, 3, 10, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 1, 0, 10, 3, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 1, 4, 10, 3, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 4, 0, 4, 7, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 4, 4, 4, 7, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 8, 3, 4, 8, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 4, 3, 10, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 5, 3, 5, 7, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 9, 0, 4, 9, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 4, 0, 4, 4, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 0, 11, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 4, 11, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 2, 11, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 2, 11, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 1, 1, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 1, 1, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 2, 1, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 3, 1, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 3, 1, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 1, 1, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 2, 1, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 3, 1, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 1), 1, 2, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 0), 3, 2, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 3, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 3, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 6, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 7, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 6, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 7, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 6, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 7, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 6, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 7, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 3, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 3, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 3, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 2, 4, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 1, 4, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 3, 4, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 2, 4, 5, p_35023_3_);
      int var4 = this.func_35009_c(Block.field_441_aG.field_376_bc, 4);

      int var5;
      for(var5 = 1; var5 <= 9; ++var5) {
         this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, var4, 3, var5, 3, p_35023_3_);
      }

      this.func_35018_a(p_35023_1_, 0, 0, 2, 1, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 2, 2, 0, p_35023_3_);
      this.func_35002_a(p_35023_1_, p_35023_3_, p_35023_2_, 2, 1, 0, this.func_35009_c(Block.field_442_aF.field_376_bc, 1));
      if(this.func_35007_a(p_35023_1_, 2, 0, -1, p_35023_3_) == 0 && this.func_35007_a(p_35023_1_, 2, -1, -1, p_35023_3_) != 0) {
         this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 2, 0, -1, p_35023_3_);
      }

      for(var5 = 0; var5 < 9; ++var5) {
         for(int var6 = 0; var6 < 5; ++var6) {
            this.func_35016_b(p_35023_1_, var6, 12, var5, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_335_x.field_376_bc, 0, var6, -1, var5, p_35023_3_);
         }
      }

      this.func_40044_a(p_35023_1_, p_35023_3_, 2, 1, 2, 1);
      return true;
   }

   protected int func_40043_a(int p_40043_1_) {
      return 2;
   }
}
