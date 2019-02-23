package net.minecraft.src;


public class WorldType {

   public static final WorldType[] field_48637_a = new WorldType[16];
   public static final WorldType field_48635_b = (new WorldType(0, "default", 1)).func_48631_f();
   public static final WorldType field_48636_c = new WorldType(1, "flat");
   public static final WorldType field_48634_d = (new WorldType(8, "default_1_1", 0)).func_48625_a(false);
   private final String field_46139_c;
   private final int field_48632_f;
   private boolean field_48633_g;
   private boolean field_48638_h;


   private WorldType(int p_i1080_1_, String p_i1080_2_) {
      this(p_i1080_1_, p_i1080_2_, 0);
   }

   private WorldType(int p_i1081_1_, String p_i1081_2_, int p_i1081_3_) {
      this.field_46139_c = p_i1081_2_;
      this.field_48632_f = p_i1081_3_;
      this.field_48633_g = true;
      field_48637_a[p_i1081_1_] = this;
   }

   public String func_48628_a() {
      return this.field_46139_c;
   }

   public String func_46136_a() {
      return "generator." + this.field_46139_c;
   }

   public int func_48630_c() {
      return this.field_48632_f;
   }

   public WorldType func_48629_a(int p_48629_1_) {
      return this == field_48635_b && p_48629_1_ == 0?field_48634_d:this;
   }

   private WorldType func_48625_a(boolean p_48625_1_) {
      this.field_48633_g = p_48625_1_;
      return this;
   }

   public boolean func_48627_d() {
      return this.field_48633_g;
   }

   private WorldType func_48631_f() {
      this.field_48638_h = true;
      return this;
   }

   public boolean func_48626_e() {
      return this.field_48638_h;
   }

   public static WorldType func_46135_a(String p_46135_0_) {
      for(int var1 = 0; var1 < field_48637_a.length; ++var1) {
         if(field_48637_a[var1] != null && field_48637_a[var1].field_46139_c.equalsIgnoreCase(p_46135_0_)) {
            return field_48637_a[var1];
         }
      }

      return null;
   }

}
