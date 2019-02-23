package net.minecraft.src;

import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureMineshaftStart;
import net.minecraft.src.StructureStart;

public class MapGenMineshaft extends MapGenStructure {

   protected boolean func_35628_a(int p_35628_1_, int p_35628_2_) {
      return this.field_1305_b.nextInt(100) == 0 && this.field_1305_b.nextInt(80) < Math.max(Math.abs(p_35628_1_), Math.abs(p_35628_2_));
   }

   protected StructureStart func_35630_b(int p_35630_1_, int p_35630_2_) {
      return new StructureMineshaftStart(this.field_35625_d, this.field_1305_b, p_35630_1_, p_35630_2_);
   }
}
