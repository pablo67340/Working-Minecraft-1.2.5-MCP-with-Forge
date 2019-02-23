package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ComponentNetherBridgeCrossing3;
import net.minecraft.src.StructureNetherBridgePieceWeight;
import net.minecraft.src.StructureNetherBridgePieces;

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3 {

   public StructureNetherBridgePieceWeight field_40037_a;
   public List field_40035_b = new ArrayList();
   public List field_40036_c;
   public ArrayList field_40034_d = new ArrayList();


   public ComponentNetherBridgeStartPiece(Random p_i96_1_, int p_i96_2_, int p_i96_3_) {
      super(p_i96_1_, p_i96_2_, p_i96_3_);
      StructureNetherBridgePieceWeight[] var4 = StructureNetherBridgePieces.func_40689_a();
      int var5 = var4.length;

      int var6;
      StructureNetherBridgePieceWeight var7;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         var7.field_40698_c = 0;
         this.field_40035_b.add(var7);
      }

      this.field_40036_c = new ArrayList();
      var4 = StructureNetherBridgePieces.func_40687_b();
      var5 = var4.length;

      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         var7.field_40698_c = 0;
         this.field_40036_c.add(var7);
      }

   }
}
