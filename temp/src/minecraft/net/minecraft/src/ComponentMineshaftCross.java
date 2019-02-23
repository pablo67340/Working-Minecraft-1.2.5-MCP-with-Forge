package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureMineshaftPieces;
import net.minecraft.src.World;

public class ComponentMineshaftCross extends StructureComponent {

   private final int field_35073_a;
   private final boolean field_35072_b;


   public ComponentMineshaftCross(int p_i406_1_, Random p_i406_2_, StructureBoundingBox p_i406_3_, int p_i406_4_) {
      super(p_i406_1_);
      this.field_35073_a = p_i406_4_;
      this.field_35024_g = p_i406_3_;
      this.field_35072_b = p_i406_3_.func_35743_c() > 3;
   }

   public static StructureBoundingBox func_35071_a(List p_35071_0_, Random p_35071_1_, int p_35071_2_, int p_35071_3_, int p_35071_4_, int p_35071_5_) {
      StructureBoundingBox var6 = new StructureBoundingBox(p_35071_2_, p_35071_3_, p_35071_4_, p_35071_2_, p_35071_3_ + 2, p_35071_4_);
      if(p_35071_1_.nextInt(4) == 0) {
         var6.field_35750_e += 4;
      }

      switch(p_35071_5_) {
      case 0:
         var6.field_35753_a = p_35071_2_ - 1;
         var6.field_35749_d = p_35071_2_ + 3;
         var6.field_35748_f = p_35071_4_ + 4;
         break;
      case 1:
         var6.field_35753_a = p_35071_2_ - 4;
         var6.field_35752_c = p_35071_4_ - 1;
         var6.field_35748_f = p_35071_4_ + 3;
         break;
      case 2:
         var6.field_35753_a = p_35071_2_ - 1;
         var6.field_35749_d = p_35071_2_ + 3;
         var6.field_35752_c = p_35071_4_ - 4;
         break;
      case 3:
         var6.field_35749_d = p_35071_2_ + 4;
         var6.field_35752_c = p_35071_4_ - 1;
         var6.field_35748_f = p_35071_4_ + 3;
      }

      return StructureComponent.func_35020_a(p_35071_0_, var6) != null?null:var6;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      int var4 = this.func_35012_c();
      switch(this.field_35073_a) {
      case 0:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 1, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 3, var4);
         break;
      case 1:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 1, var4);
         break;
      case 2:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 1, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 3, var4);
         break;
      case 3:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, var4);
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, 3, var4);
      }

      if(this.field_35072_b) {
         if(p_35004_3_.nextBoolean()) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b + 3 + 1, this.field_35024_g.field_35752_c - 1, 2, var4);
         }

         if(p_35004_3_.nextBoolean()) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + 3 + 1, this.field_35024_g.field_35752_c + 1, 1, var4);
         }

         if(p_35004_3_.nextBoolean()) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + 3 + 1, this.field_35024_g.field_35752_c + 1, 3, var4);
         }

         if(p_35004_3_.nextBoolean()) {
            StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b + 3 + 1, this.field_35024_g.field_35748_f + 1, 0, var4);
         }
      }

   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         if(this.field_35072_b) {
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35751_b + 3 - 1, this.field_35024_g.field_35748_f, 0, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35749_d, this.field_35024_g.field_35751_b + 3 - 1, this.field_35024_g.field_35748_f - 1, 0, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35750_e - 2, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f, 0, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35750_e - 2, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35749_d, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f - 1, 0, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b + 3, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35751_b + 3, this.field_35024_g.field_35748_f - 1, 0, 0, false);
         } else {
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f, 0, 0, false);
            this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35749_d, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f - 1, 0, 0, false);
         }

         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35752_c + 1, Block.field_334_y.field_376_bc, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f - 1, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f - 1, Block.field_334_y.field_376_bc, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c + 1, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35752_c + 1, Block.field_334_y.field_376_bc, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f - 1, this.field_35024_g.field_35749_d - 1, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f - 1, Block.field_334_y.field_376_bc, 0, false);

         for(int var4 = this.field_35024_g.field_35753_a; var4 <= this.field_35024_g.field_35749_d; ++var4) {
            for(int var5 = this.field_35024_g.field_35752_c; var5 <= this.field_35024_g.field_35748_f; ++var5) {
               int var6 = this.func_35007_a(p_35023_1_, var4, this.field_35024_g.field_35751_b - 1, var5, p_35023_3_);
               if(var6 == 0) {
                  this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, var4, this.field_35024_g.field_35751_b - 1, var5, p_35023_3_);
               }
            }
         }

         return true;
      }
   }
}
