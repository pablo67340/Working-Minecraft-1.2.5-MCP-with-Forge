package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.World;

public class ComponentNetherBridgeEnd extends ComponentNetherBridgePiece {

   private int field_40024_a;


   public ComponentNetherBridgeEnd(int p_i367_1_, Random p_i367_2_, StructureBoundingBox p_i367_3_, int p_i367_4_) {
      super(p_i367_1_);
      this.field_35025_h = p_i367_4_;
      this.field_35024_g = p_i367_3_;
      this.field_40024_a = p_i367_2_.nextInt();
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentNetherBridgeEnd func_40023_a(List p_40023_0_, Random p_40023_1_, int p_40023_2_, int p_40023_3_, int p_40023_4_, int p_40023_5_, int p_40023_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40023_2_, p_40023_3_, p_40023_4_, -1, -3, 0, 5, 10, 8, p_40023_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40023_0_, var7) == null?new ComponentNetherBridgeEnd(p_40023_6_, p_40023_1_, var7, p_40023_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      Random var4 = new Random((long)this.field_40024_a);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 <= 4; ++var5) {
         for(var6 = 3; var6 <= 4; ++var6) {
            var7 = var4.nextInt(8);
            this.func_35011_a(p_35023_1_, p_35023_3_, var5, var6, 0, var5, var6, var7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         }
      }

      var5 = var4.nextInt(8);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 0, 0, 5, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      var5 = var4.nextInt(8);
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 5, 0, 4, 5, var5, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);

      for(var5 = 0; var5 <= 4; ++var5) {
         var6 = var4.nextInt(5);
         this.func_35011_a(p_35023_1_, p_35023_3_, var5, 2, 0, var5, 2, var6, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      }

      for(var5 = 0; var5 <= 4; ++var5) {
         for(var6 = 0; var6 <= 1; ++var6) {
            var7 = var4.nextInt(3);
            this.func_35011_a(p_35023_1_, p_35023_3_, var5, var6, 0, var5, var6, var7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
         }
      }

      return true;
   }
}
