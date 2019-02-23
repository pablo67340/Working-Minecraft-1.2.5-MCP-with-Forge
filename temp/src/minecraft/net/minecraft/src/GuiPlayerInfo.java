package net.minecraft.src;


public class GuiPlayerInfo {

   public final String field_35624_a;
   private final String field_50099_c;
   public int field_35623_b;


   public GuiPlayerInfo(String p_i119_1_) {
      this.field_35624_a = p_i119_1_;
      this.field_50099_c = p_i119_1_.toLowerCase();
   }

   public boolean func_50098_a(String p_50098_1_) {
      return this.field_50099_c.startsWith(p_50098_1_);
   }
}
