package net.minecraft.src;


public enum EnumToolMaterial {

   WOOD("WOOD", 0, 0, 59, 2.0F, 0, 15),
   STONE("STONE", 1, 1, 131, 4.0F, 1, 5),
   IRON("IRON", 2, 2, 250, 6.0F, 2, 14),
   EMERALD("EMERALD", 3, 3, 1561, 8.0F, 3, 10),
   GOLD("GOLD", 4, 0, 32, 12.0F, 0, 22);
   private final int field_21213_f;
   private final int field_21212_g;
   private final float field_21211_h;
   private final int field_21210_i;
   private final int field_40732_j;
   // $FF: synthetic field
   private static final EnumToolMaterial[] $VALUES = new EnumToolMaterial[]{WOOD, STONE, IRON, EMERALD, GOLD};


   private EnumToolMaterial(String p_i628_1_, int p_i628_2_, int p_i628_3_, int p_i628_4_, float p_i628_5_, int p_i628_6_, int p_i628_7_) {
      this.field_21213_f = p_i628_3_;
      this.field_21212_g = p_i628_4_;
      this.field_21211_h = p_i628_5_;
      this.field_21210_i = p_i628_6_;
      this.field_40732_j = p_i628_7_;
   }

   public int func_21207_a() {
      return this.field_21212_g;
   }

   public float func_21206_b() {
      return this.field_21211_h;
   }

   public int func_21205_c() {
      return this.field_21210_i;
   }

   public int func_21208_d() {
      return this.field_21213_f;
   }

   public int func_40731_e() {
      return this.field_40732_j;
   }

}
