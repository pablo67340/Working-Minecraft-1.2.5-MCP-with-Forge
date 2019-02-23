package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentNetherBridgeCorridor;
import net.minecraft.src.ComponentNetherBridgeCorridor2;
import net.minecraft.src.ComponentNetherBridgeCorridor3;
import net.minecraft.src.ComponentNetherBridgeCorridor4;
import net.minecraft.src.ComponentNetherBridgeCorridor5;
import net.minecraft.src.ComponentNetherBridgeCrossing;
import net.minecraft.src.ComponentNetherBridgeCrossing2;
import net.minecraft.src.ComponentNetherBridgeCrossing3;
import net.minecraft.src.ComponentNetherBridgeEntrance;
import net.minecraft.src.ComponentNetherBridgeNetherStalkRoom;
import net.minecraft.src.ComponentNetherBridgePiece;
import net.minecraft.src.ComponentNetherBridgeStairs;
import net.minecraft.src.ComponentNetherBridgeStraight;
import net.minecraft.src.ComponentNetherBridgeThrone;
import net.minecraft.src.StructureNetherBridgePieceWeight;

public class StructureNetherBridgePieces {

   private static final StructureNetherBridgePieceWeight[] field_40692_a = new StructureNetherBridgePieceWeight[]{new StructureNetherBridgePieceWeight(ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeEntrance.class, 5, 1)};
   private static final StructureNetherBridgePieceWeight[] field_40691_b = new StructureNetherBridgePieceWeight[]{new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeNetherStalkRoom.class, 5, 2)};


   private static ComponentNetherBridgePiece func_40690_b(StructureNetherBridgePieceWeight p_40690_0_, List p_40690_1_, Random p_40690_2_, int p_40690_3_, int p_40690_4_, int p_40690_5_, int p_40690_6_, int p_40690_7_) {
      Class var8 = p_40690_0_.field_40699_a;
      Object var9 = null;
      if(var8 == ComponentNetherBridgeStraight.class) {
         var9 = ComponentNetherBridgeStraight.func_40029_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCrossing3.class) {
         var9 = ComponentNetherBridgeCrossing3.func_40033_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCrossing.class) {
         var9 = ComponentNetherBridgeCrossing.func_40028_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeStairs.class) {
         var9 = ComponentNetherBridgeStairs.func_40031_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeThrone.class) {
         var9 = ComponentNetherBridgeThrone.func_40026_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeEntrance.class) {
         var9 = ComponentNetherBridgeEntrance.func_40030_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCorridor5.class) {
         var9 = ComponentNetherBridgeCorridor5.func_40032_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCorridor2.class) {
         var9 = ComponentNetherBridgeCorridor2.func_40041_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCorridor.class) {
         var9 = ComponentNetherBridgeCorridor.func_40038_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCorridor3.class) {
         var9 = ComponentNetherBridgeCorridor3.func_40042_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCorridor4.class) {
         var9 = ComponentNetherBridgeCorridor4.func_40039_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeCrossing2.class) {
         var9 = ComponentNetherBridgeCrossing2.func_40025_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      } else if(var8 == ComponentNetherBridgeNetherStalkRoom.class) {
         var9 = ComponentNetherBridgeNetherStalkRoom.func_40040_a(p_40690_1_, p_40690_2_, p_40690_3_, p_40690_4_, p_40690_5_, p_40690_6_, p_40690_7_);
      }

      return (ComponentNetherBridgePiece)var9;
   }

   // $FF: synthetic method
   static ComponentNetherBridgePiece func_40688_a(StructureNetherBridgePieceWeight p_40688_0_, List p_40688_1_, Random p_40688_2_, int p_40688_3_, int p_40688_4_, int p_40688_5_, int p_40688_6_, int p_40688_7_) {
      return func_40690_b(p_40688_0_, p_40688_1_, p_40688_2_, p_40688_3_, p_40688_4_, p_40688_5_, p_40688_6_, p_40688_7_);
   }

   // $FF: synthetic method
   static StructureNetherBridgePieceWeight[] func_40689_a() {
      return field_40692_a;
   }

   // $FF: synthetic method
   static StructureNetherBridgePieceWeight[] func_40687_b() {
      return field_40691_b;
   }

}
