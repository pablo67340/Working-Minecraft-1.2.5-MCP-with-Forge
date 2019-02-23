package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;

public class ComponentNetherBridgeThrone extends ComponentNetherBridgePiece {

   private boolean field_40027_a;


   public ComponentNetherBridgeThrone(int p_i175_1_, Random p_i175_2_, StructureBoundingBox p_i175_3_, int p_i175_4_) {
      super(p_i175_1_);
      this.field_35025_h = p_i175_4_;
      this.field_35024_g = p_i175_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {}

   public static ComponentNetherBridgeThrone func_40026_a(List p_40026_0_, Random p_40026_1_, int p_40026_2_, int p_40026_3_, int p_40026_4_, int p_40026_5_, int p_40026_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40026_2_, p_40026_3_, p_40026_4_, -2, 0, 0, 7, 8, 9, p_40026_5_);
      return func_40021_a(var7) && StructureComponent.func_35020_a(p_40026_0_, var7) == null?new ComponentNetherBridgeThrone(p_40026_6_, p_40026_1_, var7, p_40026_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 2, 0, 6, 7, 7, 0, 0, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 0, 0, 5, 1, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 1, 5, 2, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 3, 2, 5, 3, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 4, 3, 5, 4, 7, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 2, 0, 1, 4, 2, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 2, 0, 5, 4, 2, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 2, 1, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 5, 5, 2, 5, 5, 3, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 5, 3, 0, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 5, 3, 6, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 5, 8, 5, 5, 8, Block.field_40206_bB.field_376_bc, Block.field_40206_bB.field_376_bc, false);
      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 1, 6, 3, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40207_bC.field_376_bc, 0, 5, 6, 3, p_35023_3_);
      this.func_35011_a(p_35023_1_, p_35023_3_, 0, 6, 3, 0, 6, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 6, 6, 3, 6, 6, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 6, 8, 5, 7, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 2, 8, 8, 4, 8, 8, Block.field_40207_bC.field_376_bc, Block.field_40207_bC.field_376_bc, false);
      int var4;
      int var5;
      if(!this.field_40027_a) {
         var4 = this.func_35008_a(5);
         var5 = this.func_35017_a(3, 5);
         int var6 = this.func_35006_b(3, 5);
         if(p_35023_3_.func_35742_b(var5, var4, var6)) {
            this.field_40027_a = true;
            p_35023_1_.func_690_d(var5, var4, var6, Block.field_400_at.field_376_bc);
            TileEntityMobSpawner var7 = (TileEntityMobSpawner)p_35023_1_.func_603_b(var5, var4, var6);
            if(var7 != null) {
               var7.func_21098_a("Blaze");
            }
         }
      }

      for(var4 = 0; var4 <= 6; ++var4) {
         for(var5 = 0; var5 <= 6; ++var5) {
            this.func_35005_b(p_35023_1_, Block.field_40206_bB.field_376_bc, 0, var4, -1, var5, p_35023_3_);
         }
      }

      return true;
   }
}
