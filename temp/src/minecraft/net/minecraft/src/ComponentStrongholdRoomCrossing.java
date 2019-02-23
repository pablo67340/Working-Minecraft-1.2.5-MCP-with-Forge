package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.EnumDoor;
import net.minecraft.src.Item;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructurePieceTreasure;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

public class ComponentStrongholdRoomCrossing extends ComponentStronghold {

   private static final StructurePieceTreasure[] field_35061_c = new StructurePieceTreasure[]{new StructurePieceTreasure(Item.field_223_m.field_291_aS, 0, 1, 5, 10), new StructurePieceTreasure(Item.field_222_n.field_291_aS, 0, 1, 3, 5), new StructurePieceTreasure(Item.field_309_aA.field_291_aS, 0, 4, 9, 5), new StructurePieceTreasure(Item.field_225_k.field_291_aS, 0, 3, 8, 10), new StructurePieceTreasure(Item.field_242_S.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_228_h.field_291_aS, 0, 1, 3, 15), new StructurePieceTreasure(Item.field_231_e.field_291_aS, 0, 1, 1, 1)};
   protected final EnumDoor field_35062_a;
   protected final int field_35060_b;


   public ComponentStrongholdRoomCrossing(int p_i4_1_, Random p_i4_2_, StructureBoundingBox p_i4_3_, int p_i4_4_) {
      super(p_i4_1_);
      this.field_35025_h = p_i4_4_;
      this.field_35062_a = this.func_35031_a(p_i4_2_);
      this.field_35024_g = p_i4_3_;
      this.field_35060_b = p_i4_2_.nextInt(5);
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      this.func_35028_a((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 4, 1);
      this.func_35032_b((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 4);
      this.func_35029_c((ComponentStrongholdStairs2)p_35004_1_, p_35004_2_, p_35004_3_, 1, 4);
   }

   public static ComponentStrongholdRoomCrossing func_35059_a(List p_35059_0_, Random p_35059_1_, int p_35059_2_, int p_35059_3_, int p_35059_4_, int p_35059_5_, int p_35059_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35059_2_, p_35059_3_, p_35059_4_, -4, -1, 0, 11, 7, 11, p_35059_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_35059_0_, var7) == null?new ComponentStrongholdRoomCrossing(p_35059_6_, p_35059_1_, var7, p_35059_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 10, 6, 10, true, p_35023_2_, StructureStrongholdPieces.func_35852_b());
         this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, this.field_35062_a, 4, 1, 0);
         this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 10, 6, 3, 10, 0, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 1, 4, 0, 3, 6, 0, 0, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 10, 1, 4, 10, 3, 6, 0, 0, false);
         int var4;
         switch(this.field_35060_b) {
         case 0:
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 2, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 3, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 4, 3, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 6, 3, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 5, 3, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 5, 3, 6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 4, 1, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 4, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 4, 1, 6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 6, 1, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 6, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 6, 1, 6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 5, 1, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_410_al.field_376_bc, 0, 5, 1, 6, p_35023_3_);
            break;
         case 1:
            for(var4 = 0; var4 < 5; ++var4) {
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 1, 3 + var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 7, 1, 3 + var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3 + var4, 1, 3, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3 + var4, 1, 7, p_35023_3_);
            }

            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 2, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 5, 3, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_401_B.field_376_bc, 0, 5, 4, 5, p_35023_3_);
            break;
         case 2:
            for(var4 = 1; var4 <= 9; ++var4) {
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 1, 3, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 9, 3, var4, p_35023_3_);
            }

            for(var4 = 1; var4 <= 9; ++var4) {
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, var4, 3, 1, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, var4, 3, 9, p_35023_3_);
            }

            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 5, 1, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 5, 1, 6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 5, 3, 4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 5, 3, 6, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 4, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 6, 1, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 4, 3, 5, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 6, 3, 5, p_35023_3_);

            for(var4 = 1; var4 <= 3; ++var4) {
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 4, var4, 4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 6, var4, 4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 4, var4, 6, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_335_x.field_376_bc, 0, 6, var4, 6, p_35023_3_);
            }

            this.func_35018_a(p_35023_1_, Block.field_404_ar.field_376_bc, 0, 5, 3, 5, p_35023_3_);

            for(var4 = 2; var4 <= 8; ++var4) {
               this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 2, 3, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 3, 3, var4, p_35023_3_);
               if(var4 <= 3 || var4 >= 7) {
                  this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 4, 3, var4, p_35023_3_);
                  this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 5, 3, var4, p_35023_3_);
                  this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 6, 3, var4, p_35023_3_);
               }

               this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 7, 3, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_334_y.field_376_bc, 0, 8, 3, var4, p_35023_3_);
            }

            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, this.func_35009_c(Block.field_441_aG.field_376_bc, 4), 9, 1, 3, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, this.func_35009_c(Block.field_441_aG.field_376_bc, 4), 9, 2, 3, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_441_aG.field_376_bc, this.func_35009_c(Block.field_441_aG.field_376_bc, 4), 9, 3, 3, p_35023_3_);
            this.func_35003_a(p_35023_1_, p_35023_3_, p_35023_2_, 3, 4, 8, field_35061_c, 1 + p_35023_2_.nextInt(4));
         }

         return true;
      }
   }

}
