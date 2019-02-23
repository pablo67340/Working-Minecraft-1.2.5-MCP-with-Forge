package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillageRoadPiece;
import net.minecraft.src.ComponentVillageStartPiece;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureVillagePieces;
import net.minecraft.src.World;

public class ComponentVillagePathGen extends ComponentVillageRoadPiece {

   private int field_35088_a;


   public ComponentVillagePathGen(int p_i139_1_, Random p_i139_2_, StructureBoundingBox p_i139_3_, int p_i139_4_) {
      super(p_i139_1_);
      this.field_35025_h = p_i139_4_;
      this.field_35024_g = p_i139_3_;
      this.field_35088_a = Math.max(p_i139_3_.func_35744_b(), p_i139_3_.func_35739_d());
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      boolean var4 = false;

      int var5;
      StructureComponent var6;
      for(var5 = p_35004_3_.nextInt(5); var5 < this.field_35088_a - 8; var5 += 2 + p_35004_3_.nextInt(5)) {
         var6 = this.func_35077_a((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, var5);
         if(var6 != null) {
            var5 += Math.max(var6.field_35024_g.func_35744_b(), var6.field_35024_g.func_35739_d());
            var4 = true;
         }
      }

      for(var5 = p_35004_3_.nextInt(5); var5 < this.field_35088_a - 8; var5 += 2 + p_35004_3_.nextInt(5)) {
         var6 = this.func_35076_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, 0, var5);
         if(var6 != null) {
            var5 += Math.max(var6.field_35024_g.func_35744_b(), var6.field_35024_g.func_35739_d());
            var4 = true;
         }
      }

      if(var4 && p_35004_3_.nextInt(3) > 0) {
         switch(this.field_35025_h) {
         case 0:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f - 2, 1, this.func_35012_c());
            break;
         case 1:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c());
            break;
         case 2:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, 1, this.func_35012_c());
            break;
         case 3:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d - 2, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c());
         }
      }

      if(var4 && p_35004_3_.nextInt(3) > 0) {
         switch(this.field_35025_h) {
         case 0:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f - 2, 3, this.func_35012_c());
            break;
         case 1:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c());
            break;
         case 2:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, 3, this.func_35012_c());
            break;
         case 3:
            StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d - 2, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c());
         }
      }

   }

   public static StructureBoundingBox func_35087_a(ComponentVillageStartPiece p_35087_0_, List p_35087_1_, Random p_35087_2_, int p_35087_3_, int p_35087_4_, int p_35087_5_, int p_35087_6_) {
      for(int var7 = 7 * MathHelper.func_35598_a(p_35087_2_, 3, 5); var7 >= 7; var7 -= 7) {
         StructureBoundingBox var8 = StructureBoundingBox.func_35747_a(p_35087_3_, p_35087_4_, p_35087_5_, 0, 0, 0, 3, 3, var7, p_35087_6_);
         if(StructureComponent.func_35020_a(p_35087_1_, var8) == null) {
            return var8;
         }
      }

      return null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      for(int var4 = this.field_35024_g.field_35753_a; var4 <= this.field_35024_g.field_35749_d; ++var4) {
         for(int var5 = this.field_35024_g.field_35752_c; var5 <= this.field_35024_g.field_35748_f; ++var5) {
            if(p_35023_3_.func_35742_b(var4, 64, var5)) {
               int var6 = p_35023_1_.func_4083_e(var4, var5) - 1;
               p_35023_1_.func_634_a(var4, var6, var5, Block.field_392_G.field_376_bc);
            }
         }
      }

      return true;
   }
}
