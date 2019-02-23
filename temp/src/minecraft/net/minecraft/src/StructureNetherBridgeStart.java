package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.ComponentNetherBridgeStartPiece;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStart;
import net.minecraft.src.World;

class StructureNetherBridgeStart extends StructureStart {

   public StructureNetherBridgeStart(World p_i237_1_, Random p_i237_2_, int p_i237_3_, int p_i237_4_) {
      ComponentNetherBridgeStartPiece var5 = new ComponentNetherBridgeStartPiece(p_i237_2_, (p_i237_3_ << 4) + 2, (p_i237_4_ << 4) + 2);
      this.field_35717_a.add(var5);
      var5.func_35004_a(var5, this.field_35717_a, p_i237_2_);
      ArrayList var6 = var5.field_40034_d;

      while(!var6.isEmpty()) {
         int var7 = p_i237_2_.nextInt(var6.size());
         StructureComponent var8 = (StructureComponent)var6.remove(var7);
         var8.func_35004_a(var5, this.field_35717_a, p_i237_2_);
      }

      this.func_35714_b();
      this.func_40559_a(p_i237_1_, p_i237_2_, 48, 70);
   }
}
