package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WorldGenerator;

public class BiomeGenForest extends BiomeGenBase {

   public BiomeGenForest(int p_i107_1_) {
      super(p_i107_1_);
      this.field_25065_s.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
      this.field_35488_u.field_35911_r = 10;
      this.field_35488_u.field_35909_t = 2;
   }

   public WorldGenerator func_21107_a(Random p_21107_1_) {
      return (WorldGenerator)(p_21107_1_.nextInt(5) == 0?this.field_35481_B:(p_21107_1_.nextInt(10) == 0?this.field_35480_A:this.field_35493_z));
   }
}
