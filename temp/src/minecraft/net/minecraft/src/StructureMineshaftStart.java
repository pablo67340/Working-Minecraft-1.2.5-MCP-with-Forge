package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.ComponentMineshaftRoom;
import net.minecraft.src.StructureStart;
import net.minecraft.src.World;

public class StructureMineshaftStart extends StructureStart {

   public StructureMineshaftStart(World p_i178_1_, Random p_i178_2_, int p_i178_3_, int p_i178_4_) {
      ComponentMineshaftRoom var5 = new ComponentMineshaftRoom(0, p_i178_2_, (p_i178_3_ << 4) + 2, (p_i178_4_ << 4) + 2);
      this.field_35717_a.add(var5);
      var5.func_35004_a(var5, this.field_35717_a, p_i178_2_);
      this.func_35714_b();
      this.func_35713_a(p_i178_1_, p_i178_2_, 10);
   }
}
