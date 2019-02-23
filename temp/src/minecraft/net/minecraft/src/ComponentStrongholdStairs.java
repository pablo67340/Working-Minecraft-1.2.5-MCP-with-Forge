package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.ComponentStrongholdCrossing;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.EnumDoor;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

public class ComponentStrongholdStairs extends ComponentStronghold {

   private final boolean field_35036_a;
   private final EnumDoor field_35035_b;


   public ComponentStrongholdStairs(int p_i336_1_, Random p_i336_2_, int p_i336_3_, int p_i336_4_) {
      super(p_i336_1_);
      this.field_35036_a = true;
      this.field_35025_h = p_i336_2_.nextInt(4);
      this.field_35035_b = EnumDoor.OPENING;
      switch(this.field_35025_h) {
      case 0:
      case 2:
         this.field_35024_g = new StructureBoundingBox(p_i336_3_, 64, p_i336_4_, p_i336_3_ + 5 - 1, 74, p_i336_4_ + 5 - 1);
         break;
      default:
         this.field_35024_g = new StructureBoundingBox(p_i336_3_, 64, p_i336_4_, p_i336_3_ + 5 - 1, 74, p_i336_4_ + 5 - 1);
      }

   }

   public ComponentStrongholdStairs(int p_i337_1_, Random p_i337_2_, StructureBoundingBox p_i337_3_, int p_i337_4_) {
      super(p_i337_1_);
      this.field_35036_a = false;
      this.field_35025_h = p_i337_4_;
      this.field_35035_b = this.func_35031_a(p_i337_2_);
      this.field_35024_g = p_i337_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      if(this.field_35036_a) {
         StructureStrongholdPieces.func_40751_a(ComponentStrongholdCrossing.class);
      }

      this.func_35028_a((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 1);
   }

   public static ComponentStrongholdStairs func_35034_a(List p_35034_0_, Random p_35034_1_, int p_35034_2_, int p_35034_3_, int p_35034_4_, int p_35034_5_, int p_35034_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35034_2_, p_35034_3_, p_35034_4_, -1, -7, 0, 5, 11, 5, p_35034_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_35034_0_, var7) == null?new ComponentStrongholdStairs(p_35034_6_, p_35034_1_, var7, p_35034_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         if(this.field_35036_a) {
            ;
         }

         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 4, 10, 4, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35035_b, 1, 7, 0);
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, EnumDoor.OPENING, 1, 1, 4);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 6, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 5, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 1, 6, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 5, 2, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 4, 3, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 1, 5, 3, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 4, 3, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 3, 3, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 3, 4, 3, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 3, 2, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 2, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 3, 3, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 2, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 1, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 1, 2, 1, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 1, 2, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 1, 1, 3, p_35023_3_);
         return true;
      }
   }
}
