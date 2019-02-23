package net.minecraft.src;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityWaterMob;
import net.minecraft.src.IMob;
import net.minecraft.src.Material;

public enum EnumCreatureType {

   monster("monster", 0, IMob.class, 70, Material.field_1337_a, false),
   creature("creature", 1, EntityAnimal.class, 15, Material.field_1337_a, true),
   waterCreature("waterCreature", 2, EntityWaterMob.class, 5, Material.field_1332_f, true);
   private final Class field_4278_c;
   private final int field_4277_d;
   private final Material field_21173_f;
   private final boolean field_21172_g;
   // $FF: synthetic field
   private static final EnumCreatureType[] $VALUES = new EnumCreatureType[]{monster, creature, waterCreature};


   private EnumCreatureType(String p_i10_1_, int p_i10_2_, Class p_i10_3_, int p_i10_4_, Material p_i10_5_, boolean p_i10_6_) {
      this.field_4278_c = p_i10_3_;
      this.field_4277_d = p_i10_4_;
      this.field_21173_f = p_i10_5_;
      this.field_21172_g = p_i10_6_;
   }

   public Class func_21170_a() {
      return this.field_4278_c;
   }

   public int func_21169_b() {
      return this.field_4277_d;
   }

   public Material func_21171_c() {
      return this.field_21173_f;
   }

   public boolean func_21168_d() {
      return this.field_21172_g;
   }

}
