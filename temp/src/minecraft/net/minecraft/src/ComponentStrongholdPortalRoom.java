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
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;

public class ComponentStrongholdPortalRoom extends ComponentStronghold {

   private boolean field_40015_a;


   public ComponentStrongholdPortalRoom(int p_i15_1_, Random p_i15_2_, StructureBoundingBox p_i15_3_, int p_i15_4_) {
      super(p_i15_1_);
      this.field_35025_h = p_i15_4_;
      this.field_35024_g = p_i15_3_;
   }

   public void func_35004_a(StructureComponent p_35004_1_, List p_35004_2_, Random p_35004_3_) {
      if(p_35004_1_ != null) {
         ((ComponentStrongholdStairs2)p_35004_1_).field_40009_b = this;
      }

   }

   public static ComponentStrongholdPortalRoom func_40014_a(List p_40014_0_, Random p_40014_1_, int p_40014_2_, int p_40014_3_, int p_40014_4_, int p_40014_5_, int p_40014_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_35747_a(p_40014_2_, p_40014_3_, p_40014_4_, -4, -1, 0, 11, 8, 16, p_40014_5_);
      return func_35030_a(var7) && StructureComponent.func_35020_a(p_40014_0_, var7) == null?new ComponentStrongholdPortalRoom(p_40014_6_, p_40014_1_, var7, p_40014_5_):null;
   }

   public boolean func_35023_a(World p_35023_1_, Random p_35023_2_, StructureBoundingBox p_35023_3_) {
      this.func_35022_a(p_35023_1_, p_35023_3_, 0, 0, 0, 10, 7, 15, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35033_a(p_35023_1_, p_35023_2_, p_35023_3_, EnumDoor.GRATES, 4, 1, 0);
      byte var4 = 6;
      this.func_35022_a(p_35023_1_, p_35023_3_, 1, var4, 1, 1, var4, 14, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 9, var4, 1, 9, var4, 14, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 2, var4, 1, 8, var4, 2, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 2, var4, 14, 8, var4, 14, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 1, 1, 1, 2, 1, 4, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 8, 1, 1, 9, 1, 4, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35011_a(p_35023_1_, p_35023_3_, 1, 1, 1, 1, 1, 3, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);
      this.func_35011_a(p_35023_1_, p_35023_3_, 9, 1, 1, 9, 1, 3, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);
      this.func_35022_a(p_35023_1_, p_35023_3_, 3, 1, 8, 7, 1, 12, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35011_a(p_35023_1_, p_35023_3_, 4, 1, 9, 6, 1, 11, Block.field_397_D.field_376_bc, Block.field_397_D.field_376_bc, false);

      int var5;
      for(var5 = 3; var5 < 14; var5 += 2) {
         this.func_35011_a(p_35023_1_, p_35023_3_, 0, 3, var5, 0, 4, var5, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
         this.func_35011_a(p_35023_1_, p_35023_3_, 10, 3, var5, 10, 4, var5, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
      }

      for(var5 = 2; var5 < 9; var5 += 2) {
         this.func_35011_a(p_35023_1_, p_35023_3_, var5, 3, 15, var5, 4, 15, Block.field_35288_bq.field_376_bc, Block.field_35288_bq.field_376_bc, false);
      }

      var5 = this.func_35009_c(Block.field_35279_by.field_376_bc, 3);
      this.func_35022_a(p_35023_1_, p_35023_3_, 4, 1, 5, 6, 1, 7, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 4, 2, 6, 6, 2, 7, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());
      this.func_35022_a(p_35023_1_, p_35023_3_, 4, 3, 7, 6, 3, 7, false, p_35023_2_, StructureStrongholdPieces.func_35852_b());

      for(int var6 = 4; var6 <= 6; ++var6) {
         this.func_35018_a(p_35023_1_, Block.field_35279_by.field_376_bc, var5, var6, 1, 4, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35279_by.field_376_bc, var5, var6, 2, 5, p_35023_3_);
         this.func_35018_a(p_35023_1_, Block.field_35279_by.field_376_bc, var5, var6, 3, 6, p_35023_3_);
      }

      byte var14 = 2;
      byte var7 = 0;
      byte var8 = 3;
      byte var9 = 1;
      switch(this.field_35025_h) {
      case 0:
         var14 = 0;
         var7 = 2;
         break;
      case 1:
         var14 = 1;
         var7 = 3;
         var8 = 0;
         var9 = 2;
      case 2:
      default:
         break;
      case 3:
         var14 = 3;
         var7 = 1;
         var8 = 0;
         var9 = 2;
      }

      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var14 + (p_35023_2_.nextFloat() > 0.9F?4:0), 4, 3, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var14 + (p_35023_2_.nextFloat() > 0.9F?4:0), 5, 3, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var14 + (p_35023_2_.nextFloat() > 0.9F?4:0), 6, 3, 8, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var7 + (p_35023_2_.nextFloat() > 0.9F?4:0), 4, 3, 12, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var7 + (p_35023_2_.nextFloat() > 0.9F?4:0), 5, 3, 12, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var7 + (p_35023_2_.nextFloat() > 0.9F?4:0), 6, 3, 12, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var8 + (p_35023_2_.nextFloat() > 0.9F?4:0), 3, 3, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var8 + (p_35023_2_.nextFloat() > 0.9F?4:0), 3, 3, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var8 + (p_35023_2_.nextFloat() > 0.9F?4:0), 3, 3, 11, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var9 + (p_35023_2_.nextFloat() > 0.9F?4:0), 7, 3, 9, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var9 + (p_35023_2_.nextFloat() > 0.9F?4:0), 7, 3, 10, p_35023_3_);
      this.func_35018_a(p_35023_1_, Block.field_40202_bJ.field_376_bc, var9 + (p_35023_2_.nextFloat() > 0.9F?4:0), 7, 3, 11, p_35023_3_);
      if(!this.field_40015_a) {
         int var13 = this.func_35008_a(3);
         int var10 = this.func_35017_a(5, 6);
         int var11 = this.func_35006_b(5, 6);
         if(p_35023_3_.func_35742_b(var10, var13, var11)) {
            this.field_40015_a = true;
            p_35023_1_.func_690_d(var10, var13, var11, Block.field_400_at.field_376_bc);
            TileEntityMobSpawner var12 = (TileEntityMobSpawner)p_35023_1_.func_603_b(var10, var13, var11);
            if(var12 != null) {
               var12.func_21098_a("Silverfish");
            }
         }
      }

      return true;
   }
}
