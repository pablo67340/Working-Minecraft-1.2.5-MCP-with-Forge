package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentVillageHouse1 extends ComponentVillage {

   private int field_35096_a = -1;


   public ComponentVillageHouse1(int p_i176_1_, Random p_i176_2_, StructureBoundingBox p_i176_3_, int p_i176_4_) {
      super(p_i176_1_);
      this.field_35025_h = p_i176_4_;
      this.field_35024_g = p_i176_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentVillageHouse1 func_35095_a(List p_35095_0_, Random p_35095_1_, int p_35095_2_, int p_35095_3_, int p_35095_4_, int p_35095_5_, int p_35095_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35095_2_, p_35095_3_, p_35095_4_, 0, 0, 0, 9, 9, 6, p_35095_5_);
      return func_35074_a(var7) && StructureComponent.func_35020_a(p_35095_0_, var7) == null?new ComponentVillageHouse1(p_35095_6_, p_35095_1_, var7, p_35095_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.field_35096_a < 0) {
         this.field_35096_a = this.func_35075_b(p_35023_1_, p_35023_3_);
         if(this.field_35096_a < 0) {
            return true;
         }

         this.field_35024_g.func_35745_a(0, this.field_35096_a - this.field_35024_g.field_35750_e + 9 - 1, 0);
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 1, 7, 5, 4, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 8, 0, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 8, 5, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 6, 1, 8, 6, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 7, 2, 8, 7, 3, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      int var4 = this.func_35009_c(Block.field_4059_au.field_376_bc, 3);
      int var5 = this.func_35009_c(Block.field_4059_au.field_376_bc, 2);

      int var6;
      int var7;
      for(var6 = -1; var6 <= 2; ++var6) {
         for(var7 = 0; var7 <= 8; ++var7) {
            this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var4, var7, 6 + var6, var6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var5, var7, 6 + var6, 5 - var6, p_35023_3_);
         }
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 0, 0, 1, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 5, 8, 1, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 1, 0, 8, 1, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 1, 0, 7, 1, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 0, 4, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 5, 0, 4, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 2, 5, 8, 4, 5, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 2, 0, 8, 4, 0, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 1, 0, 4, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 5, 7, 4, 5, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 8, 2, 1, 8, 4, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 0, 7, 4, 0, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 5, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 6, 2, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 4, 3, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 5, 3, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 6, 3, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 3, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 0, 3, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 3, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 8, 3, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 2, 2, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 3, 2, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 5, 2, 5, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_35282_br.field_376_bc, 0, 6, 2, 5, p_35023_3_);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 4, 1, 7, 4, 1, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 4, 4, 7, 4, 4, Block.field_334_y.field_376_bc, Block.field_334_y.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 3, 4, 7, 3, 4, Block.field_407_ao.field_376_bc, Block.field_407_ao.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 7, 1, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, this.func_35009_c(Block.field_4059_au.field_376_bc, 0), 7, 1, 3, p_35023_3_);
      var6 = this.func_35009_c(Block.field_4059_au.field_376_bc, 3);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var6, 6, 1, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var6, 5, 1, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var6, 4, 1, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4059_au.field_376_bc, var6, 3, 1, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 6, 1, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4065_aN.field_376_bc, 0, 6, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 4, 1, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4065_aN.field_376_bc, 0, 4, 2, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_387_az.field_376_bc, 0, 7, 1, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 1, 1, 0, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 1, 2, 0, p_35023_3_);
      this.func_35002_a(p_35023_1_, p_35023_3_, p_35023_2_, 1, 1, 0, this.func_35009_c(Block.field_442_aF.field_376_bc, 1));
      if(this.func_35007_a(p_35023_1_, 1, 0, -1, p_35023_3_) == 0 && this.func_35007_a(p_35023_1_, 1, -1, -1, p_35023_3_) != 0) {
         this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, this.func_35009_c(Block.field_4069_aI.field_376_bc, 3), 1, 0, -1, p_35023_3_);
      }

      for(var7 = 0; var7 < 6; ++var7) {
         for(int var8 = 0; var8 < 9; ++var8) {
            this.func_35016_b(p_35023_1_, var8, 9, var7, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_335_x.field_376_bc, 0, var8, -1, var7, p_35023_3_);
         }
      }

      this.func_40044_a(p_35023_1_, p_35023_3_, 2, 1, 2, 1);
      return true;
   }

   protected int func_40043_a(int p_40043_1_) {
      return 1;
   }
}
