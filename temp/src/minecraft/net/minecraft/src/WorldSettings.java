package net.minecraft.src;

import net.minecraft.src.WorldType;

public final class WorldSettings {

   private final long field_35523_a;
   private final int field_35521_b;
   private final boolean field_35522_c;
   private final boolean field_40558_d;
   private final WorldType field_46108_e;


   public WorldSettings(long p_i1033_1_, int p_i1033_3_, boolean p_i1033_4_, boolean p_i1033_5_, WorldType p_i1033_6_) {
      this.field_35523_a = p_i1033_1_;
      this.field_35521_b = p_i1033_3_;
      this.field_35522_c = p_i1033_4_;
      this.field_40558_d = p_i1033_5_;
      this.field_46108_e = p_i1033_6_;
   }

   public long func_35518_a() {
      return this.field_35523_a;
   }

   public int func_35519_b() {
      return this.field_35521_b;
   }

   public boolean func_40557_c() {
      return this.field_40558_d;
   }

   public boolean func_35520_c() {
      return this.field_35522_c;
   }

   public WorldType func_46107_e() {
      return this.field_46108_e;
   }
}
