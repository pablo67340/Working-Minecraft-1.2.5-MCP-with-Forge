package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentVillage;
import net.minecraft.src.ComponentVillageChurch;
import net.minecraft.src.ComponentVillageField;
import net.minecraft.src.ComponentVillageField2;
import net.minecraft.src.ComponentVillageHall;
import net.minecraft.src.ComponentVillageHouse1;
import net.minecraft.src.ComponentVillageHouse2;
import net.minecraft.src.ComponentVillageHouse3;
import net.minecraft.src.ComponentVillageHouse4_Garden;
import net.minecraft.src.ComponentVillagePathGen;
import net.minecraft.src.ComponentVillageStartPiece;
import net.minecraft.src.ComponentVillageTorch;
import net.minecraft.src.ComponentVillageWoodHut;
import net.minecraft.src.MapGenVillage;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureVillagePieceWeight;

public class StructureVillagePieces {

   public static ArrayList func_35705_a(Random p_35705_0_, int p_35705_1_) {
      ArrayList var2 = new ArrayList();
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse4_Garden.class, 4, MathHelper.func_35598_a(p_35705_0_, 2 + p_35705_1_, 4 + p_35705_1_ * 2)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageChurch.class, 20, MathHelper.func_35598_a(p_35705_0_, 0 + p_35705_1_, 1 + p_35705_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse1.class, 20, MathHelper.func_35598_a(p_35705_0_, 0 + p_35705_1_, 2 + p_35705_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageWoodHut.class, 3, MathHelper.func_35598_a(p_35705_0_, 2 + p_35705_1_, 5 + p_35705_1_ * 3)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHall.class, 15, MathHelper.func_35598_a(p_35705_0_, 0 + p_35705_1_, 2 + p_35705_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageField.class, 3, MathHelper.func_35598_a(p_35705_0_, 1 + p_35705_1_, 4 + p_35705_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageField2.class, 3, MathHelper.func_35598_a(p_35705_0_, 2 + p_35705_1_, 4 + p_35705_1_ * 2)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse2.class, 15, MathHelper.func_35598_a(p_35705_0_, 0, 1 + p_35705_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse3.class, 8, MathHelper.func_35598_a(p_35705_0_, 0 + p_35705_1_, 3 + p_35705_1_ * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if(((StructureVillagePieceWeight)var3.next()).field_35604_d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static int func_35703_a(ArrayList p_35703_0_) {
      boolean var1 = false;
      int var2 = 0;

      StructureVillagePieceWeight var4;
      for(Iterator var3 = p_35703_0_.iterator(); var3.hasNext(); var2 += var4.field_35605_b) {
         var4 = (StructureVillagePieceWeight)var3.next();
         if(var4.field_35604_d > 0 && var4.field_35606_c < var4.field_35604_d) {
            var1 = true;
         }
      }

      return var1?var2:-1;
   }

   private static ComponentVillage func_35699_a(StructureVillagePieceWeight p_35699_0_, List p_35699_1_, Random p_35699_2_, int p_35699_3_, int p_35699_4_, int p_35699_5_, int p_35699_6_, int p_35699_7_) {
      Class var8 = p_35699_0_.field_35607_a;
      Object var9 = null;
      if(var8 == ComponentVillageHouse4_Garden.class) {
         var9 = ComponentVillageHouse4_Garden.func_35082_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageChurch.class) {
         var9 = ComponentVillageChurch.func_35097_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageHouse1.class) {
         var9 = ComponentVillageHouse1.func_35095_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageWoodHut.class) {
         var9 = ComponentVillageWoodHut.func_35091_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageHall.class) {
         var9 = ComponentVillageHall.func_35078_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageField.class) {
         var9 = ComponentVillageField.func_35080_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageField2.class) {
         var9 = ComponentVillageField2.func_35089_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageHouse2.class) {
         var9 = ComponentVillageHouse2.func_35085_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      } else if(var8 == ComponentVillageHouse3.class) {
         var9 = ComponentVillageHouse3.func_35101_a(p_35699_1_, p_35699_2_, p_35699_3_, p_35699_4_, p_35699_5_, p_35699_6_, p_35699_7_);
      }

      return (ComponentVillage)var9;
   }

   private static ComponentVillage func_35700_c(ComponentVillageStartPiece p_35700_0_, List p_35700_1_, Random p_35700_2_, int p_35700_3_, int p_35700_4_, int p_35700_5_, int p_35700_6_, int p_35700_7_) {
      int var8 = func_35703_a(p_35700_0_.field_35107_d);
      if(var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = p_35700_2_.nextInt(var8);
            Iterator var11 = p_35700_0_.field_35107_d.iterator();

            while(var11.hasNext()) {
               StructureVillagePieceWeight var12 = (StructureVillagePieceWeight)var11.next();
               var10 -= var12.field_35605_b;
               if(var10 < 0) {
                  if(!var12.func_35602_a(p_35700_7_) || var12 == p_35700_0_.field_35110_c && p_35700_0_.field_35107_d.size() > 1) {
                     break;
                  }

                  ComponentVillage var13 = func_35699_a(var12, p_35700_1_, p_35700_2_, p_35700_3_, p_35700_4_, p_35700_5_, p_35700_6_, p_35700_7_);
                  if(var13 != null) {
                     ++var12.field_35606_c;
                     p_35700_0_.field_35110_c = var12;
                     if(!var12.func_35603_a()) {
                        p_35700_0_.field_35107_d.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         StructureBoundingBox var14 = ComponentVillageTorch.func_35099_a(p_35700_1_, p_35700_2_, p_35700_3_, p_35700_4_, p_35700_5_, p_35700_6_);
         if(var14 != null) {
            return new ComponentVillageTorch(p_35700_7_, p_35700_2_, var14, p_35700_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_35702_d(ComponentVillageStartPiece p_35702_0_, List p_35702_1_, Random p_35702_2_, int p_35702_3_, int p_35702_4_, int p_35702_5_, int p_35702_6_, int p_35702_7_) {
      if(p_35702_7_ > 50) {
         return null;
      } else if(Math.abs(p_35702_3_ - p_35702_0_.func_35021_b().field_35753_a) <= 112 && Math.abs(p_35702_5_ - p_35702_0_.func_35021_b().field_35752_c) <= 112) {
         ComponentVillage var8 = func_35700_c(p_35702_0_, p_35702_1_, p_35702_2_, p_35702_3_, p_35702_4_, p_35702_5_, p_35702_6_, p_35702_7_ + 1);
         if(var8 != null) {
            int var9 = (var8.field_35024_g.field_35753_a + var8.field_35024_g.field_35749_d) / 2;
            int var10 = (var8.field_35024_g.field_35752_c + var8.field_35024_g.field_35748_f) / 2;
            int var11 = var8.field_35024_g.field_35749_d - var8.field_35024_g.field_35753_a;
            int var12 = var8.field_35024_g.field_35748_f - var8.field_35024_g.field_35752_c;
            int var13 = var11 > var12?var11:var12;
            if(p_35702_0_.func_35105_a().func_35562_a(var9, var10, var13 / 2 + 4, MapGenVillage.field_35635_a)) {
               p_35702_1_.add(var8);
               p_35702_0_.field_35108_e.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static StructureComponent func_35698_e(ComponentVillageStartPiece p_35698_0_, List p_35698_1_, Random p_35698_2_, int p_35698_3_, int p_35698_4_, int p_35698_5_, int p_35698_6_, int p_35698_7_) {
      if(p_35698_7_ > 3 + p_35698_0_.field_35109_b) {
         return null;
      } else if(Math.abs(p_35698_3_ - p_35698_0_.func_35021_b().field_35753_a) <= 112 && Math.abs(p_35698_5_ - p_35698_0_.func_35021_b().field_35752_c) <= 112) {
         StructureBoundingBox var8 = ComponentVillagePathGen.func_35087_a(p_35698_0_, p_35698_1_, p_35698_2_, p_35698_3_, p_35698_4_, p_35698_5_, p_35698_6_);
         if(var8 != null && var8.field_35751_b > 10) {
            ComponentVillagePathGen var9 = new ComponentVillagePathGen(p_35698_7_, p_35698_2_, var8, p_35698_6_);
            int var10 = (var9.field_35024_g.field_35753_a + var9.field_35024_g.field_35749_d) / 2;
            int var11 = (var9.field_35024_g.field_35752_c + var9.field_35024_g.field_35748_f) / 2;
            int var12 = var9.field_35024_g.field_35749_d - var9.field_35024_g.field_35753_a;
            int var13 = var9.field_35024_g.field_35748_f - var9.field_35024_g.field_35752_c;
            int var14 = var12 > var13?var12:var13;
            if(p_35698_0_.func_35105_a().func_35562_a(var10, var11, var14 / 2 + 4, MapGenVillage.field_35635_a)) {
               p_35698_1_.add(var9);
               p_35698_0_.field_35106_f.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static StructureComponent func_35704_a(ComponentVillageStartPiece p_35704_0_, List p_35704_1_, Random p_35704_2_, int p_35704_3_, int p_35704_4_, int p_35704_5_, int p_35704_6_, int p_35704_7_) {
      return func_35702_d(p_35704_0_, p_35704_1_, p_35704_2_, p_35704_3_, p_35704_4_, p_35704_5_, p_35704_6_, p_35704_7_);
   }

   // $FF: synthetic method
   static StructureComponent func_35701_b(ComponentVillageStartPiece p_35701_0_, List p_35701_1_, Random p_35701_2_, int p_35701_3_, int p_35701_4_, int p_35701_5_, int p_35701_6_, int p_35701_7_) {
      return func_35698_e(p_35701_0_, p_35701_1_, p_35701_2_, p_35701_3_, p_35701_4_, p_35701_5_, p_35701_6_, p_35701_7_);
   }
}
