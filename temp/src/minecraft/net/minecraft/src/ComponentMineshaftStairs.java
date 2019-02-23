package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureMineshaftPieces;
import net.minecraft.src.World;

public class ComponentMineshaftStairs extends StructureComponent {

   public ComponentMineshaftStairs(int p_i368_1_, Random p_i368_2_, StructureBoundingBox p_i368_3_, int p_i368_4_) {
      super(p_i368_1_);
      this.field_35025_h = p_i368_4_;
      this.field_35024_g = p_i368_3_;
   }

   public static StructureBoundingBox func_35027_a(List p_35027_0_, Random p_35027_1_, int p_35027_2_, int p_35027_3_, int p_35027_4_, int p_35027_5_) {
      StructureBoundingBox var6 = new StructureBoundingBox(p_35027_2_, p_35027_3_ - 5, p_35027_4_, p_35027_2_, p_35027_3_ + 2, p_35027_4_);
      switch(p_35027_5_) {
      case 0:
         var6.field_35749_d = p_35027_2_ + 2;
         var6.field_35748_f = p_35027_4_ + 8;
         break;
      case 1:
         var6.field_35753_a = p_35027_2_ - 8;
         var6.field_35748_f = p_35027_4_ + 2;
         break;
      case 2:
         var6.field_35749_d = p_35027_2_ + 2;
         var6.field_35752_c = p_35027_4_ - 8;
         break;
      case 3:
         var6.field_35749_d = p_35027_2_ + 8;
         var6.field_35748_f = p_35027_4_ + 2;
      }

      return StructureComponent.func_35020_a(p_35027_0_, var6) != null?null:var6;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      int var4 = this.func_35012_c();
      switch(this.field_35025_h) {
      case 0:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, var4);
         break;
      case 1:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, 1, var4);
         break;
      case 2:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, var4);
         break;
      case 3:
         StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, 3, var4);
      }

   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 2, 7, 1, 0, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 0, 7, 2, 2, 8, 0, 0, false);

         for(int var4 = 0; var4 < 5; ++var4) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, 0, 0, false);
         }

         return true;
      }
   }
}
