package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.EnumDoor;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

public class ComponentStrongholdLeftTurn extends ComponentStronghold {

   protected final EnumDoor field_35046_a;


   public ComponentStrongholdLeftTurn(int p_i493_1_, Random p_i493_2_, StructureBoundingBox p_i493_3_, int p_i493_4_) {
      super(p_i493_1_);
      this.field_35025_h = p_i493_4_;
      this.field_35046_a = this.func_35031_a(p_i493_2_);
      this.field_35024_g = p_i493_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      if(this.field_35025_h != 2 && this.field_35025_h != 3) {
         this.func_35029_c((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 1);
      } else {
         this.func_35032_b((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 1);
      }

   }

   public static ComponentStrongholdLeftTurn func_35045_a(List p_35045_0_, Random p_35045_1_, int p_35045_2_, int p_35045_3_, int p_35045_4_, int p_35045_5_, int p_35045_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35045_2_, p_35045_3_, p_35045_4_, -1, -1, 0, 5, 5, 5, p_35045_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_35045_0_, var7) == null?new ComponentStrongholdLeftTurn(p_35045_6_, p_35045_1_, var7, p_35045_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 4, 4, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35046_a, 1, 1, 0);
         if(this.field_35025_h != 2 && this.field_35025_h != 3) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 1, 4, 3, 3, 0, 0, false);
         } else {
            this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 1, 0, 3, 3, 0, 0, false);
         }

         return true;
      }
   }
}
