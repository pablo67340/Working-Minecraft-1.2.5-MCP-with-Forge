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

public class ComponentStrongholdStairsStraight extends ComponentStronghold {

   private final EnumDoor field_35054_a;


   public ComponentStrongholdStairsStraight(int p_i59_1_, Random p_i59_2_, StructureBoundingBox p_i59_3_, int p_i59_4_) {
      super(p_i59_1_);
      this.field_35025_h = p_i59_4_;
      this.field_35054_a = this.func_35031_a(p_i59_2_);
      this.field_35024_g = p_i59_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_35028_a((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 1);
   }

   public static ComponentStrongholdStairsStraight func_35053_a(List p_35053_0_, Random p_35053_1_, int p_35053_2_, int p_35053_3_, int p_35053_4_, int p_35053_5_, int p_35053_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35053_2_, p_35053_3_, p_35053_4_, -1, -7, 0, 5, 11, 8, p_35053_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_35053_0_, var7) == null?new ComponentStrongholdStairsStraight(p_35053_6_, p_35053_1_, var7, p_35053_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 10, 7, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35054_a, 1, 7, 0);
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, EnumDoor.OPENING, 1, 1, 7);
         int var4 = this.func_35009_c(Block.field_4069_aI.field_376_bc, 2);

         for(int var5 = 0; var5 < 6; ++var5) {
            this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, var4, 1, 6 - var5, 1 + var5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, var4, 2, 6 - var5, 1 + var5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_4069_aI.field_376_bc, var4, 3, 6 - var5, 1 + var5, p_35023_3_);
            if(var5 < 5) {
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 5 - var5, 1 + var5, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 5 - var5, 1 + var5, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 5 - var5, 1 + var5, p_35023_3_);
            }
         }

         return true;
      }
   }
}
