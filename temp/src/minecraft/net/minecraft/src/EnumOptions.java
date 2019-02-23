package net.minecraft.src;


public enum EnumOptions {

   MUSIC("MUSIC", 0, "options.music", true, false),
   SOUND("SOUND", 1, "options.sound", true, false),
   INVERT_MOUSE("INVERT_MOUSE", 2, "options.invertMouse", false, true),
   SENSITIVITY("SENSITIVITY", 3, "options.sensitivity", true, false),
   FOV("FOV", 4, "options.fov", true, false),
   GAMMA("GAMMA", 5, "options.gamma", true, false),
   RENDER_DISTANCE("RENDER_DISTANCE", 6, "options.renderDistance", false, false),
   VIEW_BOBBING("VIEW_BOBBING", 7, "options.viewBobbing", false, true),
   ANAGLYPH("ANAGLYPH", 8, "options.anaglyph", false, true),
   ADVANCED_OPENGL("ADVANCED_OPENGL", 9, "options.advancedOpengl", false, true),
   FRAMERATE_LIMIT("FRAMERATE_LIMIT", 10, "options.framerateLimit", false, false),
   DIFFICULTY("DIFFICULTY", 11, "options.difficulty", false, false),
   GRAPHICS("GRAPHICS", 12, "options.graphics", false, false),
   AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 13, "options.ao", false, true),
   GUI_SCALE("GUI_SCALE", 14, "options.guiScale", false, false),
   RENDER_CLOUDS("RENDER_CLOUDS", 15, "options.renderClouds", false, true),
   PARTICLES("PARTICLES", 16, "options.particles", false, false);
   private final boolean field_20144_k;
   private final boolean field_20143_l;
   private final String field_20142_m;
   // $FF: synthetic field
   private static final EnumOptions[] $VALUES = new EnumOptions[]{MUSIC, SOUND, INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, ADVANCED_OPENGL, FRAMERATE_LIMIT, DIFFICULTY, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, RENDER_CLOUDS, PARTICLES};


   public static EnumOptions func_20137_a(int p_20137_0_) {
      EnumOptions[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumOptions var4 = var1[var3];
         if(var4.func_20135_c() == p_20137_0_) {
            return var4;
         }
      }

      return null;
   }

   private EnumOptions(String p_i722_1_, int p_i722_2_, String p_i722_3_, boolean p_i722_4_, boolean p_i722_5_) {
      this.field_20142_m = p_i722_3_;
      this.field_20144_k = p_i722_4_;
      this.field_20143_l = p_i722_5_;
   }

   public boolean func_20136_a() {
      return this.field_20144_k;
   }

   public boolean func_20140_b() {
      return this.field_20143_l;
   }

   public int func_20135_c() {
      return this.ordinal();
   }

   public String func_20138_d() {
      return this.field_20142_m;
   }

}
