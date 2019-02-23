package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.ComponentVillageStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureVillagePieces;
import net.minecraft.src.World;

public class ComponentVillageWell extends ComponentVillage {

   private final boolean field_35104_a = true;
   private int field_35103_b = -1;


   public ComponentVillageWell(int p_i84_1_, Random p_i84_2_, int p_i84_3_, int p_i84_4_) {
      super(p_i84_1_);
      this.field_35025_h = p_i84_2_.nextInt(4);
      switch(this.field_35025_h) {
      case 0:
      case 2:
         this.field_35024_g = new StructureBoundingBox(p_i84_3_, 64, p_i84_4_, p_i84_3_ + 6 - 1, 78, p_i84_4_ + 6 - 1);
         break;
      default:
         this.field_35024_g = new StructureBoundingBox(p_i84_3_, 64, p_i84_4_, p_i84_3_ + 6 - 1, 78, p_i84_4_ + 6 - 1);
      }

   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35750_e - 4, this.field_35024_g.field_35752_c + 1, 1, this.func_35012_c());
      StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35750_e - 4, this.field_35024_g.field_35752_c + 1, 3, this.func_35012_c());
      StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35750_e - 4, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c());
      StructureVillagePieces.func_35701_b((ComponentVillageStartPiece)p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + 1, this.field_35024_g.field_35750_e - 4, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c());
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.field_35103_b < 0) {
         this.field_35103_b = this.func_35075_b(p_35023_1_, p_35023_3_);
         if(this.field_35103_b < 0) {
            return true;
         }

         this.field_35024_g.func_35745_a(0, this.field_35103_b - this.field_35024_g.field_35750_e + 3, 0);
      }

      if(this.field_35104_a) {
         ;
      }

      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 1, 4, 12, 4, Block.field_335_x.field_376_bc, Block.field_401_B.field_376_bc, false);
      this.func_35018_a(p_35023_1_, 0, 0, 2, 12, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 3, 12, 2, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 2, 12, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, 0, 0, 3, 12, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 1, 13, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 1, 14, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 4, 13, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 4, 14, 1, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 1, 13, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 1, 14, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 4, 13, 4, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_4057_ba.field_376_bc, 0, 4, 14, 4, p_35023_3_);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 15, 1, 4, 15, 4, Block.field_335_x.field_376_bc, Block.field_335_x.field_376_bc, false);

      for(int var4 = 0; var4 <= 5; ++var4) {
         for(int var5 = 0; var5 <= 5; ++var5) {
            if(var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
               this.func_35018_a(p_35023_1_, Block.field_392_G.field_376_bc, 0, var5, 11, var4, p_35023_3_);
               this.func_35016_b(p_35023_1_, var5, 12, var4, p_35023_3_);
            }
         }
      }

      return true;
   }
}
