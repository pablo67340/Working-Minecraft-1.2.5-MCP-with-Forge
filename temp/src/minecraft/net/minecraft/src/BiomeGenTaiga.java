package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WorldGenTaiga1;
import net.minecraft.src.WorldGenTaiga2;
import net.minecraft.src.WorldGenerator;

public class BiomeGenTaiga extends BiomeGenBase {

   public BiomeGenTaiga(int p_i597_1_) {
      super(p_i597_1_);
      this.field_25065_s.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
      this.field_35488_u.field_35911_r = 10;
      this.field_35488_u.field_35909_t = 1;
   }

   public WorldGenerator func_21107_a(Random p_21107_1_) {
      return (WorldGenerator)(p_21107_1_.nextInt(3) == 0?new WorldGenTaiga1():new WorldGenTaiga2(false));
   }
}
