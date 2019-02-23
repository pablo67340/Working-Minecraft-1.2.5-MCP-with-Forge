package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ComponentStrongholdPortalRoom;
import net.minecraft.src.ComponentStrongholdStairs;
import net.minecraft.src.StructureStrongholdPieceWeight;

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs {

   public StructureStrongholdPieceWeight field_35038_a;
   public ComponentStrongholdPortalRoom field_40009_b;
   public ArrayList field_35037_b = new ArrayList();


   public ComponentStrongholdStairs2(int p_i602_1_, Random p_i602_2_, int p_i602_3_, int p_i602_4_) {
      super(0, p_i602_2_, p_i602_3_, p_i602_4_);
   }

   public ChunkPosition func_40008_a_() {
      return this.field_40009_b != null?this.field_40009_b.func_40008_a_():super.func_40008_a_();
   }
}
