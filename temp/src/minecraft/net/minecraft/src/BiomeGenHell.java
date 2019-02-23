package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.SpawnListEntry;

public class BiomeGenHell extends BiomeGenBase {

   public BiomeGenHell(int p_i604_1_) {
      super(p_i604_1_);
      this.field_25066_r.clear();
      this.field_25065_s.clear();
      this.field_25064_t.clear();
      this.field_25066_r.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
      this.field_25066_r.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
   }
}
