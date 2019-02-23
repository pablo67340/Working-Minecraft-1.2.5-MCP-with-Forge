package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentVillageStartPiece;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureVillagePieces;
import net.minecraft.src.World;

abstract class ComponentVillage extends StructureComponent {

   private int field_39009_a;


   protected ComponentVillage(int p_i142_1_) {
      super(p_i142_1_);
   }

   protected StructureComponent func_35077_a(ComponentVillageStartPiece p_35077_1_, List p_35077_2_, Random p_35077_3_, int p_35077_4_, int p_35077_5_) {
      switch(this.field_35025_h) {
      case 0:
         return StructureVillagePieces.func_35704_a(p_35077_1_, p_35077_2_, p_35077_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_35077_4_, this.field_35024_g.field_35752_c + p_35077_5_, 1, this.func_35012_c());
      case 1:
         return StructureVillagePieces.func_35704_a(p_35077_1_, p_35077_2_, p_35077_3_, this.field_35024_g.field_35753_a + p_35077_5_, this.field_35024_g.field_35751_b + p_35077_4_, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c());
      case 2:
         return StructureVillagePieces.func_35704_a(p_35077_1_, p_35077_2_, p_35077_3_, this.field_35024_g.field_35753_a - 1, this.field_35024_g.field_35751_b + p_35077_4_, this.field_35024_g.field_35752_c + p_35077_5_, 1, this.func_35012_c());
      case 3:
         return StructureVillagePieces.func_35704_a(p_35077_1_, p_35077_2_, p_35077_3_, this.field_35024_g.field_35753_a + p_35077_5_, this.field_35024_g.field_35751_b + p_35077_4_, this.field_35024_g.field_35752_c - 1, 2, this.func_35012_c());
      default:
         return null;
      }
   }

   protected StructureComponent func_35076_b(ComponentVillageStartPiece p_35076_1_, List p_35076_2_, Random p_35076_3_, int p_35076_4_, int p_35076_5_) {
      switch(this.field_35025_h) {
      case 0:
         return StructureVillagePieces.func_35704_a(p_35076_1_, p_35076_2_, p_35076_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_35076_4_, this.field_35024_g.field_35752_c + p_35076_5_, 3, this.func_35012_c());
      case 1:
         return StructureVillagePieces.func_35704_a(p_35076_1_, p_35076_2_, p_35076_3_, this.field_35024_g.field_35753_a + p_35076_5_, this.field_35024_g.field_35751_b + p_35076_4_, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c());
      case 2:
         return StructureVillagePieces.func_35704_a(p_35076_1_, p_35076_2_, p_35076_3_, this.field_35024_g.field_35749_d + 1, this.field_35024_g.field_35751_b + p_35076_4_, this.field_35024_g.field_35752_c + p_35076_5_, 3, this.func_35012_c());
      case 3:
         return StructureVillagePieces.func_35704_a(p_35076_1_, p_35076_2_, p_35076_3_, this.field_35024_g.field_35753_a + p_35076_5_, this.field_35024_g.field_35751_b + p_35076_4_, this.field_35024_g.field_35748_f + 1, 0, this.func_35012_c());
      default:
         return null;
      }
   }

   protected int func_35075_b(World p_35075_1_, StructureBoundingBox p_35075_2_) {
      int var3 = 0;
      int var4 = 0;

      for(int var5 = this.field_35024_g.field_35752_c; var5 <= this.field_35024_g.field_35748_f; ++var5) {
         for(int var6 = this.field_35024_g.field_35753_a; var6 <= this.field_35024_g.field_35749_d; ++var6) {
            if(p_35075_2_.func_35742_b(var6, 64, var5)) {
               var3 += Math.max(p_35075_1_.func_4083_e(var6, var5), p_35075_1_.field_4209_q.func_46066_g());
               ++var4;
            }
         }
      }

      if(var4 == 0) {
         return -1;
      } else {
         return var3 / var4;
      }
   }

   protected static boolean func_35074_a(StructureBoundingBox p_35074_0_) {
      return p_35074_0_ != null && p_35074_0_.field_35751_b > 10;
   }

   protected void func_40044_a(World p_40044_1_, StructureBoundingBox p_40044_2_, int p_40044_3_, int p_40044_4_, int p_40044_5_, int p_40044_6_) {
      if(this.field_39009_a < p_40044_6_) {
         for(int var7 = this.field_39009_a; var7 < p_40044_6_; ++var7) {
            int var8 = this.func_35017_a(p_40044_3_ + var7, p_40044_5_);
            int var9 = this.func_35008_a(p_40044_4_);
            int var10 = this.func_35006_b(p_40044_3_ + var7, p_40044_5_);
            if(!p_40044_2_.func_35742_b(var8, var9, var10)) {
               break;
            }

            ++this.field_39009_a;
            EntityVillager var11 = new EntityVillager(p_40044_1_, this.func_40043_a(var7));
            var11.func_365_c((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
            p_40044_1_.func_674_a(var11);
         }

      }
   }

   protected int func_40043_a(int p_40043_1_) {
      return 0;
   }
}
