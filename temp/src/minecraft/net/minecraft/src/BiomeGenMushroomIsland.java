package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityMooshroom;
import net.minecraft.src.SpawnListEntry;

public class BiomeGenMushroomIsland extends BiomeGenBase {

   public BiomeGenMushroomIsland(int p_i343_1_) {
      super(p_i343_1_);
      this.field_35488_u.field_35911_r = -100;
      this.field_35488_u.field_35910_s = -100;
      this.field_35488_u.field_35909_t = -100;
      this.field_35488_u.field_35907_v = 1;
      this.field_35488_u.field_40718_J = 1;
      this.field_4242_o = (byte)Block.field_40199_bz.field_376_bc;
      this.field_25066_r.clear();
      this.field_25065_s.clear();
      this.field_25064_t.clear();
      this.field_25065_s.add(new SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
   }
}
