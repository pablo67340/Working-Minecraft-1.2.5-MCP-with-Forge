package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.ComponentVillageWell;
import net.minecraft.src.StructureVillagePieceWeight;
import net.minecraft.src.WorldChunkManager;

public class ComponentVillageStartPiece extends ComponentVillageWell {

   public WorldChunkManager field_35111_a;
   public int field_35109_b;
   public StructureVillagePieceWeight field_35110_c;
   public ArrayList field_35107_d;
   public ArrayList field_35108_e = new ArrayList();
   public ArrayList field_35106_f = new ArrayList();


   public ComponentVillageStartPiece(WorldChunkManager p_i342_1_, int p_i342_2_, Random p_i342_3_, int p_i342_4_, int p_i342_5_, ArrayList p_i342_6_, int p_i342_7_) {
      super(0, p_i342_3_, p_i342_4_, p_i342_5_);
      this.field_35111_a = p_i342_1_;
      this.field_35107_d = p_i342_6_;
      this.field_35109_b = p_i342_7_;
   }

   public WorldChunkManager func_35105_a() {
      return this.field_35111_a;
   }
}
