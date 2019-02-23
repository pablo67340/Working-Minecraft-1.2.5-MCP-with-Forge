package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStart;
import net.minecraft.src.StructureStrongholdPieces;
import net.minecraft.src.World;

class StructureStrongholdStart extends StructureStart {

   public StructureStrongholdStart(World p_i164_1_, Random p_i164_2_, int p_i164_3_, int p_i164_4_) {
      StructureStrongholdPieces.func_35849_a();
      ComponentStrongholdStairs2 var5 = new ComponentStrongholdStairs2(0, p_i164_2_, (p_i164_3_ << 4) + 2, (p_i164_4_ << 4) + 2);
      this.field_35717_a.add(var5);
      var5.func_35004_a(var5, this.field_35717_a, p_i164_2_);
      ArrayList var6 = var5.field_35037_b;

      while(!var6.isEmpty()) {
         int var7 = p_i164_2_.nextInt(var6.size());
         StructureComponent var8 = (StructureComponent)var6.remove(var7);
         var8.func_35004_a(var5, this.field_35717_a, p_i164_2_);
      }

      this.func_35714_b();
      this.func_35713_a(p_i164_1_, p_i164_2_, 10);
   }
}
