package net.minecraft.src;

import net.minecraft.src.BiomeEndDecorator;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.SpawnListEntry;

public class BiomeGenEnd extends BiomeGenBase {

   public BiomeGenEnd(int p_i333_1_) {
      super(p_i333_1_);
      this.field_25066_r.clear();
      this.field_25065_s.clear();
      this.field_25064_t.clear();
      this.field_25066_r.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
      this.field_4242_o = (byte)Block.field_336_w.field_376_bc;
      this.field_4241_p = (byte)Block.field_336_w.field_376_bc;
      this.field_35488_u = new BiomeEndDecorator(this);
   }

   public int func_4126_a(float p_4126_1_) {
      return 0;
   }
}
