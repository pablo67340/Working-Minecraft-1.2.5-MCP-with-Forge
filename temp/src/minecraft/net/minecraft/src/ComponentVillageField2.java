package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentVillageField2 extends ComponentVillage {

   private int field_35090_a = -1;


   public ComponentVillageField2(int p_i542_1_, Random p_i542_2_, StructureBoundingBox p_i542_3_, int p_i542_4_) {
      super(p_i542_1_);
      this.field_35025_h = p_i542_4_;
      this.field_35024_g = p_i542_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentVillageField2 func_35089_a(List p_35089_0_, Random p_35089_1_, int p_35089_2_, int p_35089_3_, int p_35089_4_, int p_35089_5_, int p_35089_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35089_2_, p_35089_3_, p_35089_4_, 0, 0, 0, 7, 4, 9, p_35089_5_);
      return func_35074_a(var7) && StructureComponent.func_35020_a(p_35089_0_, var7) == null?new ComponentVillageField2(p_35089_6_, p_35089_1_, var7, p_35089_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.field_35090_a < 0) {
         this.field_35090_a = this.func_35075_b(p_35023_1_, p_35023_3_);
         if(this.field_35090_a < 0) {
            return true;
         }

         this.field_35024_g.func_35745_a(0, this.field_35090_a - this.field_35024_g.field_35750_e + 4 - 1, 0);
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 0, 6, 4, 8, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 1, 2, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 0, 1, 5, 0, 7, Block.field_446_aB.field_376_bc, Block.field_446_aB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 0, 0, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 0, 0, 6, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 0, 5, 0, 0, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 8, 5, 0, 8, Block.field_385_K.field_376_bc, Block.field_385_K.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 3, 0, 1, 3, 0, 7, Block.field_401_B.field_376_bc, Block.field_401_B.field_376_bc, false);

      int var4;
      for(var4 = 1; var4 <= 7; ++var4) {
         this.func_35018_a(p_35023_1_, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(p_35023_2_, 2, 7), 1, 1, var4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(p_35023_2_, 2, 7), 2, 1, var4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(p_35023_2_, 2, 7), 4, 1, var4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_447_aA.field_376_bc, MathHelper.func_35598_a(p_35023_2_, 2, 7), 5, 1, var4, p_35023_3_);
      }

      for(var4 = 0; var4 < 9; ++var4) {
         for(int var5 = 0; var5 < 7; ++var5) {
            this.func_35016_b(p_35023_1_, var5, 4, var4, p_35023_3_);
            this.func_35005_b(p_35023_1_, Block.field_336_w.field_376_bc, 0, var5, -1, var4, p_35023_3_);
         }
      }

      return true;
   }
}
