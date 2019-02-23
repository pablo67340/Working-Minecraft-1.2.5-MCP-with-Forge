package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentVillageHouse3 extends ComponentVillage {

   private int field_35102_a = -1;


   public ComponentVillageHouse3(int p_i692_1_, Random p_i692_2_, StructureBoundingBox p_i692_3_, int p_i692_4_) {
      super(p_i692_1_);
      this.field_35025_h = p_i692_4_;
      this.field_35024_g = p_i692_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentVillageHouse3 func_35101_a(List p_35101_0_, Random p_35101_1_, int p_35101_2_, int p_35101_3_, int p_35101_4_, int p_35101_5_, int p_35101_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35101_2_, p_35101_3_, p_35101_4_, 0, 0, 0, 9, 7, 12, p_35101_5_);
      return func_35074_a(var7) && StructureComponent.func_35020_a(p_35101_0_, var7) == null?new ComponentVillageHouse3(p_35101_6_, p_35101_1_, var7, p_35101_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.field_35102_a < 0) {
         this.field_35102_a = this.func_35075_b(p_35023_1_, p_35023_3_);
         if(this.field_35102_a < 0) {
            return true;
         }

         this.field_35024_g.func_35745_a(0, this.field_35102_a - this.field_35024_g.field_35750_e + 7 - 1, 0);
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 1, 7, 4, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 1, 6, 8, 4, 10, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 0, 5, 8, 0, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 1, 7, 0, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 0, 3, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 0, 0, 8, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 0, 7, 2, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 5, 2, 1, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 0, 6, 2, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 0, 10, 7, 3, 10, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 0, 7, 3, 0, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 5, 2, 3, 5, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 4, 1, 8, 4, 1, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 4, 4, 3, 4, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 2, 8, 5, 3, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 0, 4, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 0, 4, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 4, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 4, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 4, 4, p_35023_3_);
      int var4 = this.func_35009_c(Block.field_4059_au.field_376_bc, 3);
      int var5 = this.func_35009_c(Block.field_4059_au.field_376_bc, 2);

      int var6;
      int var7;
      for(var6 = -1; var6 <= 2; ++var6) {
         for(var7 = 0; var7 <= 8; ++var7) {
            this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var4, var7, 4 + var6, var6, p_35023_3_);
            if((var6 > -1 || var7 <= 1) && (var6 > 0 || var7 <= 3) && (var6 > 1 || var7 <= 4 || var7 >= 6)) {
               this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var5, var7, 4 + var6, 5 - var6, p_35023_3_);
            }
         }
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 4, 5, 3, 4, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 7, 4, 2, 7, 4, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 5, 4, 4, 5, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 5, 4, 6, 5, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 6, 3, 5, 6, 10, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      var6 = this.func_35009_c(Block.field_4059_au.field_376_bc, 0);

      int var8;
      for(var7 = 4; var7 >= 1; --var7) {
         this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, var7, 2 + var7, 7 - var7, p_35023_3_);

         for(var8 = 8 - var7; var8 <= 10; ++var8) {
            this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var6, var7, 2 + var7, var8, p_35023_3_);
         }
      }

      var7 = this.func_35009_c(Block.field_4059_au.field_376_bc, 1);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 6, 6, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 7, 5, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var7, 6, 6, 4, p_35023_3_);

      int var9;
      for(var8 = 6; var8 <= 8; ++var8) {
         for(var9 = 5; var9 <= 10; ++var9) {
            this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var7, var8, 12 - var8, var9, p_35023_3_);
         }
      }

      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 0, 2, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 0, 2, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 4, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 5, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 6, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 8, 2, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 8, 2, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 2, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 8, 2, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 8, 2, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 2, 2, 6, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 2, 7, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 2, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 2, 2, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 4, 4, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 5, 4, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_385_K.field_376_bc, 0, 6, 4, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 5, 5, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 2, 1, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 2, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 2, 3, 1, p_35023_3_);
      this.func_35002_a(p_35023_1_, p_35023_3_, p_35023_2_, 2, 1, 0, this.func_35009_c(Block.field_442_aF.field_376_bc, 1));
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, -1, 3, 2, -1, 0, 0, false);
      if(this.func_35007_a(p_35023_1_, 2, 0, -1, p_35023_3_) == 0 && this.func_35007_a(p_35023_1_, 2, -1, -1, p_35023_3_) != 0) {
         this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 2, 0, -1, p_35023_3_);
      }

      for(var8 = 0; var8 < 5; ++var8) {
         for(var9 = 0; var9 < 9; ++var9) {
            this.func_35016_b(p_35023_1_, var9, 7, var8, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_335_x.field_376_bc, 0, var9, -1, var8, p_35023_3_);
         }
      }

      for(var8 = 5; var8 < 11; ++var8) {
         for(var9 = 2; var9 < 9; ++var9) {
            this.func_35016_b(p_35023_1_, var9, 7, var8, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_335_x.field_376_bc, 0, var9, -1, var8, p_35023_3_);
         }
      }

      this.func_40044_a(p_35023_1_, p_35023_3_, 4, 1, 2, 2);
      return true;
   }
}
