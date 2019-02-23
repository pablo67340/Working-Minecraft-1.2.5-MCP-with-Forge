package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentNetherBridgeEnd;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureNetherBridgePieceWeight;
import net.minecraft.src.StructureNetherBridgePieces;

abstract class ComponentNetherBridgePiece extends StructureComponent {

   protected ComponentNetherBridgePiece(int p_i752_1_) {
      super(p_i752_1_);
   }

   private int func_40017_a(List p_40017_1_) {
      boolean var2 = false;
      int var3 = 0;

      StructureNetherBridgePieceWeight var5;
      for(Iterator var4 = p_40017_1_.iterator(); var4.hasNext(); var3 += var5.field_40697_b) {
         var5 = (StructureNetherBridgePieceWeight)var4.next();
         if(var5.field_40695_d > 0 && var5.field_40698_c < var5.field_40695_d) {
            var2 = true;
         }
      }

      return var2?var3:-1;
   }

   private ComponentNetherBridgePiece func_40020_a(ComponentNetherBridgeStartPiece p_40020_1_, List p_40020_2_, List p_40020_3_, Random p_40020_4_, int p_40020_5_, int p_40020_6_, int p_40020_7_, int p_40020_8_, int p_40020_9_) {
      int var10 = this.func_40017_a(p_40020_2_);
      boolean var11 = var10 > 0 && p_40020_9_ <= 30;
      int var12 = 0;

      while(var12 < 5 && var11) {
         ++var12;
         int var13 = p_40020_4_.nextInt(var10);
         Iterator var14 = p_40020_2_.iterator();

         while(var14.hasNext()) {
            StructureNetherBridgePieceWeight var15 = (StructureNetherBridgePieceWeight)var14.next();
            var13 -= var15.field_40697_b;
            if(var13 < 0) {
               if(!var15.func_40693_a(p_40020_9_) || var15 == p_40020_1_.field_40037_a && !var15.field_40696_e) {
                  break;
               }

               ComponentNetherBridgePiece var16 = StructureNetherBridgePieces.func_40688_a(var15, p_40020_3_, p_40020_4_, p_40020_5_, p_40020_6_, p_40020_7_, p_40020_8_, p_40020_9_);
               if(var16 != null) {
                  ++var15.field_40698_c;
                  p_40020_1_.field_40037_a = var15;
                  if(!var15.func_40694_a()) {
                     p_40020_2_.remove(var15);
                  }

                  return var16;
               }
            }
         }
      }

      ComponentNetherBridgeEnd var17 = ComponentNetherBridgeEnd.func_40023_a(p_40020_3_, p_40020_4_, p_40020_5_, p_40020_6_, p_40020_7_, p_40020_8_, p_40020_9_);
      return var17;
   }

   private StructureComponent func_40018_a(ComponentNetherBridgeStartPiece p_40018_1_, List p_40018_2_, Random p_40018_3_, int p_40018_4_, int p_40018_5_, int p_40018_6_, int p_40018_7_, int p_40018_8_, boolean p_40018_9_) {
      if(Math.abs(p_40018_4_ - p_40018_1_.func_35021_b().field_35753_a) <= 112 && Math.abs(p_40018_6_ - p_40018_1_.func_35021_b().field_35752_c) <= 112) {
         List var12 = p_40018_1_.field_40035_b;
         if(p_40018_9_) {
            var12 = p_40018_1_.field_40036_c;
         }

         ComponentNetherBridgePiece var11 = this.func_40020_a(p_40018_1_, var12, p_40018_2_, p_40018_3_, p_40018_4_, p_40018_5_, p_40018_6_, p_40018_7_, p_40018_8_ + 1);
         if(var11 != null) {
            p_40018_2_.add(var11);
            p_40018_1_.field_40034_d.add(var11);
         }

         return var11;
      } else {
         ComponentNetherBridgeEnd var10 = ComponentNetherBridgeEnd.func_40023_a(p_40018_2_, p_40018_3_, p_40018_4_, p_40018_5_, p_40018_6_, p_40018_7_, p_40018_8_);
         return var10;
      }
   }

   protected StructureComponent func_40022_a(ComponentNetherBridgeStartPiece p_40022_1_, List p_40022_2_, Random p_40022_3_, int p_40022_4_, int p_40022_5_, boolean p_40022_6_) {
      switch(this.field_35025_h) {
      case 0:
         return this.func_40018_a(p_40022_1_, p_40022_2_, p_40022_3_, this.field_35024_g.field_35753_a + p_40022_4_, this.field_35024_g.field_35751_b + p_40022_5_, this.field_35024_g.field_35748_f + 1, this.field_35025_h, this.func_35012_c(), p_40022_6_);
      case 1:
         return this.func_40018_a(p_40022_1_, p_40022_2_, p_40022_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_40022_5_, this.field_35024_g.field_35752_c + p_40022_4_, this.field_35025_h, this.func_35012_c(), p_40022_6_);
      case 2:
         return this.func_40018_a(p_40022_1_, p_40022_2_, p_40022_3_, this.field_35024_g.field_35753_a + p_40022_4_, this.field_35024_g.field_35751_b + p_40022_5_, this.field_35024_g.field_35752_c - 1, this.field_35025_h, this.func_35012_c(), p_40022_6_);
      case 3:
         return this.func_40018_a(p_40022_1_, p_40022_2_, p_40022_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_40022_5_, this.field_35024_g.field_35752_c + p_40022_4_, this.field_35025_h, this.func_35012_c(), p_40022_6_);
      default:
         return null;
      }
   }

   protected StructureComponent func_40019_b(ComponentNetherBridgeStartPiece p_40019_1_, List p_40019_2_, Random p_40019_3_, int p_40019_4_, int p_40019_5_, boolean p_40019_6_) {
      switch(this.field_35025_h) {
      case 0:
         return this.func_40018_a(p_40019_1_, p_40019_2_, p_40019_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_40019_4_, this.field_35024_g.field_35752_c + p_40019_5_, 1, this.func_35012_c(), p_40019_6_);
      case 1:
         return this.func_40018_a(p_40019_1_, p_40019_2_, p_40019_3_, this.field_35024_g.field_35753_a + p_40019_5_, this.field_35024_g.field_35751_b + p_40019_4_, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c(), p_40019_6_);
      case 2:
         return this.func_40018_a(p_40019_1_, p_40019_2_, p_40019_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_40019_4_, this.field_35024_g.field_35752_c + p_40019_5_, 1, this.func_35012_c(), p_40019_6_);
      case 3:
         return this.func_40018_a(p_40019_1_, p_40019_2_, p_40019_3_, this.field_35024_g.field_35753_a + p_40019_5_, this.field_35024_g.field_35751_b + p_40019_4_, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c(), p_40019_6_);
      default:
         return null;
      }
   }

   protected StructureComponent func_40016_c(ComponentNetherBridgeStartPiece p_40016_1_, List p_40016_2_, Random p_40016_3_, int p_40016_4_, int p_40016_5_, boolean p_40016_6_) {
      switch(this.field_35025_h) {
      case 0:
         return this.func_40018_a(p_40016_1_, p_40016_2_, p_40016_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_40016_4_, this.field_35024_g.field_35752_c + p_40016_5_, 3, this.func_35012_c(), p_40016_6_);
      case 1:
         return this.func_40018_a(p_40016_1_, p_40016_2_, p_40016_3_, this.field_35024_g.field_35753_a + p_40016_5_, this.field_35024_g.field_35751_b + p_40016_4_, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c(), p_40016_6_);
      case 2:
         return this.func_40018_a(p_40016_1_, p_40016_2_, p_40016_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_40016_4_, this.field_35024_g.field_35752_c + p_40016_5_, 3, this.func_35012_c(), p_40016_6_);
      case 3:
         return this.func_40018_a(p_40016_1_, p_40016_2_, p_40016_3_, this.field_35024_g.field_35753_a + p_40016_5_, this.field_35024_g.field_35751_b + p_40016_4_, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c(), p_40016_6_);
      default:
         return null;
      }
   }

   protected static boolean func_40021_a(StructureBoundingBox p_40021_0_) {
      return p_40021_0_ != null && p_40021_0_.field_35751_b > 10;
   }
}
