package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentStrongholdCorridor extends ComponentStronghold {

   private final int field_35052_a;


   public ComponentStrongholdCorridor(int p_i412_1_, Random p_i412_2_, StructureBoundingBox p_i412_3_, int p_i412_4_) {
      super(p_i412_1_);
      this.field_35025_h = p_i412_4_;
      this.field_35024_g = p_i412_3_;
      this.field_35052_a = p_i412_4_ != 2 && p_i412_4_ != 0?p_i412_3_.func_35744_b():p_i412_3_.func_35739_d();
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static StructureBoundingBox func_35051_a(List p_35051_0_, Random p_35051_1_, int p_35051_2_, int p_35051_3_, int p_35051_4_, int p_35051_5_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_35051_2_, p_35051_3_, p_35051_4_, -1, -1, 0, 5, 5, 4, p_35051_5_);
      StructureComponent var8 = StructureComponent.func_35020_a(p_35051_0_, var7);
      if(var8 == null) {
         return null;
      } else {
         if(var8.func_35021_b().field_35751_b == var7.field_35751_b) {
            for(int var9 = 3; var9 >= 1; --var9) {
               var7 = StructureBoundingBox.func_35747_a(p_35051_2_, p_35051_3_, p_35051_4_, -1, -1, 0, 5, 5, var9 - 1, p_35051_5_);
               if(!var8.func_35021_b().func_35740_a(var7)) {
                  return StructureBoundingBox.func_35747_a(p_35051_2_, p_35051_3_, p_35051_4_, -1, -1, 0, 5, 5, var9, p_35051_5_);
               }
            }
         }

         return null;
      }
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         for(int var4 = 0; var4 < this.field_35052_a; ++var4) {
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 0, 0, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 0, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 0, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 0, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 4, 0, var4, p_35023_3_);

            for(int var5 = 1; var5 <= 3; ++var5) {
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 0, var5, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, 0, 0, 1, var5, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, 0, 0, 2, var5, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, 0, 0, 3, var5, var4, p_35023_3_);
               this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 4, var5, var4, p_35023_3_);
            }

            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 0, 4, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 1, 4, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 2, 4, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 3, 4, var4, p_35023_3_);
            this.func_35018_a(p_35023_1_, Block.field_35285_bn.field_376_bc, 0, 4, 4, var4, p_35023_3_);
         }

         return true;
      }
   }
}
