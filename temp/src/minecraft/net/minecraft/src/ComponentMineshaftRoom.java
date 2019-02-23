package net.minecraft.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureMineshaftPieces;
import net.minecraft.src.World;

public class ComponentMineshaftRoom extends StructureComponent {

   private LinkedList field_35065_a = new LinkedList();


   public ComponentMineshaftRoom(int p_i596_1_, Random p_i596_2_, int p_i596_3_, int p_i596_4_) {
      super(p_i596_1_);
      this.field_35024_g = new StructureBoundingBox(p_i596_3_, 50, p_i596_4_, p_i596_3_ + 7 + p_i596_2_.nextInt(6), 54 + p_i596_2_.nextInt(6), p_i596_4_ + 7 + p_i596_2_.nextInt(6));
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      int var4 = this.func_35012_c();
      int var6 = this.field_35024_g.func_35743_c() - 3 - 1;
      if(var6 <= 0) {
         var6 = 1;
      }

      int var5;
      StructureComponent var7;
      StructureBoundingBox var8;
      for(var5 = 0; var5 < this.field_35024_g.func_35744_b(); var5 += 4) {
         var5 += p_35004_3_.nextInt(this.field_35024_g.func_35744_b());
         if(var5 + 3 > this.field_35024_g.func_35744_b()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + var5, this.field_35024_g.field_35751_b + p_35004_3_.nextInt(var6) + 1, this.field_35024_g.field_35752_c - 1, 2, var4);
         if(var7 != null) {
            var8 = var7.func_35021_b();
            this.field_35065_a.add(new StructureBoundingBox(var8.field_35753_a, var8.field_35751_b, this.field_35024_g.field_35752_c, var8.field_35749_d, var8.field_35750_e, this.field_35024_g.field_35752_c + 1));
         }
      }

      for(var5 = 0; var5 < this.field_35024_g.func_35744_b(); var5 += 4) {
         var5 += p_35004_3_.nextInt(this.field_35024_g.func_35744_b());
         if(var5 + 3 > this.field_35024_g.func_35744_b()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a + var5, this.field_35024_g.field_35751_b + p_35004_3_.nextInt(var6) + 1, this.field_35024_g.field_35748_f + 1, 0, var4);
         if(var7 != null) {
            var8 = var7.func_35021_b();
            this.field_35065_a.add(new StructureBoundingBox(var8.field_35753_a, var8.field_35751_b, this.field_35024_g.field_35748_f - 1, var8.field_35749_d, var8.field_35750_e, this.field_35024_g.field_35748_f));
         }
      }

      for(var5 = 0; var5 < this.field_35024_g.func_35739_d(); var5 += 4) {
         var5 += p_35004_3_.nextInt(this.field_35024_g.func_35739_d());
         if(var5 + 3 > this.field_35024_g.func_35739_d()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_35004_3_.nextInt(var6) + 1, this.field_35024_g.field_35752_c + var5, 1, var4);
         if(var7 != null) {
            var8 = var7.func_35021_b();
            this.field_35065_a.add(new StructureBoundingBox(this.field_35024_g.field_35753_a, var8.field_35751_b, var8.field_35752_c, this.field_35024_g.field_35753_a + 1, var8.field_35750_e, var8.field_35748_f));
         }
      }

      for(var5 = 0; var5 < this.field_35024_g.func_35739_d(); var5 += 4) {
         var5 += p_35004_3_.nextInt(this.field_35024_g.func_35739_d());
         if(var5 + 3 > this.field_35024_g.func_35739_d()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_35585_a(p_35004_1_, p_35004_2_, p_35004_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_35004_3_.nextInt(var6) + 1, this.field_35024_g.field_35752_c + var5, 3, var4);
         if(var7 != null) {
            var8 = var7.func_35021_b();
            this.field_35065_a.add(new StructureBoundingBox(this.field_35024_g.field_35749_d - 1, var8.field_35751_b, var8.field_35752_c, this.field_35024_g.field_35749_d, var8.field_35750_e, var8.field_35748_f));
         }
      }

   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      if(this.func_35013_a(p_35023_1_, p_35023_3_)) {
         return false;
      } else {
         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d, this.field_35024_g.field_35751_b, this.field_35024_g.field_35748_f, Block.field_336_w.field_376_bc, 0, true);
         this.func_35011_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b + 1, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d, Math.min(this.field_35024_g.field_35751_b + 3, this.field_35024_g.field_35750_e), this.field_35024_g.field_35748_f, 0, 0, false);
         Iterator var4 = this.field_35065_a.iterator();

         while(var4.hasNext()) {
            StructureBoundingBox var5 = (StructureBoundingBox)var4.next();
            this.func_35011_a(p_35023_1_, p_35023_3_, var5.field_35753_a, var5.field_35750_e - 2, var5.field_35752_c, var5.field_35749_d, var5.field_35750_e, var5.field_35748_f, 0, 0, false);
         }

         this.func_35015_a(p_35023_1_, p_35023_3_, this.field_35024_g.field_35753_a, this.field_35024_g.field_35751_b + 4, this.field_35024_g.field_35752_c, this.field_35024_g.field_35749_d, this.field_35024_g.field_35750_e, this.field_35024_g.field_35748_f, 0, false);
         return true;
      }
   }
}
