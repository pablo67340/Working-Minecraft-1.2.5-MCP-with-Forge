package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.EnumDoor;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

public class ComponentStrongholdStraight extends ComponentStronghold {

   private final EnumDoor field_35050_a;
   private final boolean field_35048_b;
   private final boolean field_35049_c;


   public ComponentStrongholdStraight(int p_i417_1_, Random p_i417_2_, StructureBoundingBox p_i417_3_, int p_i417_4_) {
      super(p_i417_1_);
      this.field_35025_h = p_i417_4_;
      this.field_35050_a = this.func_35031_a(p_i417_2_);
      this.field_35024_g = p_i417_3_;
      this.field_35048_b = p_i417_2_.nextInt(2) == 0;
      this.field_35049_c = p_i417_2_.nextInt(2) == 0;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_35028_a((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 1);
      if(this.field_35048_b) {
         this.func_35032_b((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 2);
      }

      if(this.field_35049_c) {
         this.func_35029_c((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 2);
      }

   }

   public static ComponentStrongholdStraight func_35047_a(List p_35047_0_, Random p_35047_1_, int p_35047_2_, int p_35047_3_, int p_35047_4_, int p_35047_5_, int p_35047_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35047_2_, p_35047_3_, p_35047_4_, -1, -1, 0, 5, 5, 7, p_35047_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_35047_0_, var7) == null?new ComponentStrongholdStraight(p_35047_6_, p_35047_1_, var7, p_35047_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 4, 6, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35050_a, 1, 1, 0);
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, EnumDoor.OPENING, 1, 1, 6);
         this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 1, 2, 1, Block.field_404_ar.field_376_bc, 0);
         this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 3, 2, 1, Block.field_404_ar.field_376_bc, 0);
         this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 1, 2, 5, Block.field_404_ar.field_376_bc, 0);
         this.func_35014_a(p_35023_1_, p_35023_3_, p_35023_2_, 0.1F, 3, 2, 5, Block.field_404_ar.field_376_bc, 0);
         if(this.field_35048_b) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 2, 0, 3, 4, 0, 0, false);
         }

         if(this.field_35049_c) {
            this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 2, 4, 3, 4, 0, 0, false);
         }

         return true;
      }
   }
}
