package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentStronghold;
import net.minecraft.src.ComponentStrongholdChestCorridor;
import net.minecraft.src.ComponentStrongholdCorridor;
import net.minecraft.src.ComponentStrongholdCrossing;
import net.minecraft.src.ComponentStrongholdLeftTurn;
import net.minecraft.src.ComponentStrongholdLibrary;
import net.minecraft.src.ComponentStrongholdPortalRoom;
import net.minecraft.src.ComponentStrongholdPrison;
import net.minecraft.src.ComponentStrongholdRightTurn;
import net.minecraft.src.ComponentStrongholdRoomCrossing;
import net.minecraft.src.ComponentStrongholdStairs;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.ComponentStrongholdStairsStraight;
import net.minecraft.src.ComponentStrongholdStraight;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStrongholdPieceWeight;
import net.minecraft.src.StructureStrongholdPieceWeight2;
import net.minecraft.src.StructureStrongholdPieceWeight3;
import net.minecraft.src.StructureStrongholdStones;

public class StructureStrongholdPieces {

   private static final StructureStrongholdPieceWeight[] field_35855_b = new StructureStrongholdPieceWeight[]{new StructureStrongholdPieceWeight(ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(ComponentStrongholdStairsStraight.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdStairs.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight(ComponentStrongholdChestCorridor.class, 5, 4), new StructureStrongholdPieceWeight2(ComponentStrongholdLibrary.class, 10, 2), new StructureStrongholdPieceWeight3(ComponentStrongholdPortalRoom.class, 20, 1)};
   private static List field_35856_c;
   private static Class field_40752_d;
   static int field_35857_a = 0;
   private static final StructureStrongholdStones field_35854_d = new StructureStrongholdStones((StructureStrongholdPieceWeight2)null);


   public static void func_35849_a() {
      field_35856_c = new ArrayList();
      StructureStrongholdPieceWeight[] var0 = field_35855_b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         StructureStrongholdPieceWeight var3 = var0[var2];
         var3.field_35617_c = 0;
         field_35856_c.add(var3);
      }

      field_40752_d = null;
   }

   private static boolean func_35853_c() {
      boolean var0 = false;
      field_35857_a = 0;

      StructureStrongholdPieceWeight var2;
      for(Iterator var1 = field_35856_c.iterator(); var1.hasNext(); field_35857_a += var2.field_35616_b) {
         var2 = (StructureStrongholdPieceWeight)var1.next();
         if(var2.field_35615_d > 0 && var2.field_35617_c < var2.field_35615_d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static ComponentStronghold func_35851_a(Class p_35851_0_, List p_35851_1_, Random p_35851_2_, int p_35851_3_, int p_35851_4_, int p_35851_5_, int p_35851_6_, int p_35851_7_) {
      Object var8 = null;
      if(p_35851_0_ == ComponentStrongholdStraight.class) {
         var8 = ComponentStrongholdStraight.func_35047_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdPrison.class) {
         var8 = ComponentStrongholdPrison.func_35063_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdLeftTurn.class) {
         var8 = ComponentStrongholdLeftTurn.func_35045_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdRightTurn.class) {
         var8 = ComponentStrongholdRightTurn.func_35045_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdRoomCrossing.class) {
         var8 = ComponentStrongholdRoomCrossing.func_35059_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdStairsStraight.class) {
         var8 = ComponentStrongholdStairsStraight.func_35053_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdStairs.class) {
         var8 = ComponentStrongholdStairs.func_35034_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdCrossing.class) {
         var8 = ComponentStrongholdCrossing.func_35039_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdChestCorridor.class) {
         var8 = ComponentStrongholdChestCorridor.func_40010_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdLibrary.class) {
         var8 = ComponentStrongholdLibrary.func_35055_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      } else if(p_35851_0_ == ComponentStrongholdPortalRoom.class) {
         var8 = ComponentStrongholdPortalRoom.func_40014_a(p_35851_1_, p_35851_2_, p_35851_3_, p_35851_4_, p_35851_5_, p_35851_6_, p_35851_7_);
      }

      return (ComponentStronghold)var8;
   }

   private static ComponentStronghold func_35847_b(ComponentStrongholdStairs2 p_35847_0_, List p_35847_1_, Random p_35847_2_, int p_35847_3_, int p_35847_4_, int p_35847_5_, int p_35847_6_, int p_35847_7_) {
      if(!func_35853_c()) {
         return null;
      } else {
         if(field_40752_d != null) {
            ComponentStronghold var8 = func_35851_a(field_40752_d, p_35847_1_, p_35847_2_, p_35847_3_, p_35847_4_, p_35847_5_, p_35847_6_, p_35847_7_);
            field_40752_d = null;
            if(var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = p_35847_2_.nextInt(field_35857_a);
            Iterator var10 = field_35856_c.iterator();

            while(var10.hasNext()) {
               StructureStrongholdPieceWeight var11 = (StructureStrongholdPieceWeight)var10.next();
               var9 -= var11.field_35616_b;
               if(var9 < 0) {
                  if(!var11.func_35613_a(p_35847_7_) || var11 == p_35847_0_.field_35038_a) {
                     break;
                  }

                  ComponentStronghold var12 = func_35851_a(var11.field_35618_a, p_35847_1_, p_35847_2_, p_35847_3_, p_35847_4_, p_35847_5_, p_35847_6_, p_35847_7_);
                  if(var12 != null) {
                     ++var11.field_35617_c;
                     p_35847_0_.field_35038_a = var11;
                     if(!var11.func_35614_a()) {
                        field_35856_c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         StructureBoundingBox var14 = ComponentStrongholdCorridor.func_35051_a(p_35847_1_, p_35847_2_, p_35847_3_, p_35847_4_, p_35847_5_, p_35847_6_);
         if(var14 != null && var14.field_35751_b > 1) {
            return new ComponentStrongholdCorridor(p_35847_7_, p_35847_2_, var14, p_35847_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_35848_c(ComponentStrongholdStairs2 p_35848_0_, List p_35848_1_, Random p_35848_2_, int p_35848_3_, int p_35848_4_, int p_35848_5_, int p_35848_6_, int p_35848_7_) {
      if(p_35848_7_ > 50) {
         return null;
      } else if(Math.abs(p_35848_3_ - p_35848_0_.func_35021_b().field_35753_a) <= 112 && Math.abs(p_35848_5_ - p_35848_0_.func_35021_b().field_35752_c) <= 112) {
         ComponentStronghold var8 = func_35847_b(p_35848_0_, p_35848_1_, p_35848_2_, p_35848_3_, p_35848_4_, p_35848_5_, p_35848_6_, p_35848_7_ + 1);
         if(var8 != null) {
            p_35848_1_.add(var8);
            p_35848_0_.field_35037_b.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static StructureComponent func_35850_a(ComponentStrongholdStairs2 p_35850_0_, List p_35850_1_, Random p_35850_2_, int p_35850_3_, int p_35850_4_, int p_35850_5_, int p_35850_6_, int p_35850_7_) {
      return func_35848_c(p_35850_0_, p_35850_1_, p_35850_2_, p_35850_3_, p_35850_4_, p_35850_5_, p_35850_6_, p_35850_7_);
   }

   // $FF: synthetic method
   static Class func_40751_a(Class p_40751_0_) {
      field_40752_d = p_40751_0_;
      return p_40751_0_;
   }

   // $FF: synthetic method
   static StructureStrongholdStones func_35852_b() {
      return field_35854_d;
   }

}
