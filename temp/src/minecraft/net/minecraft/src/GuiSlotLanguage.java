package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import net.minecraft.src.GuiLanguage;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;

class GuiSlotLanguage extends GuiSlot {

   private ArrayList field_44013_b;
   private TreeMap field_44014_c;
   // $FF: synthetic field
   final GuiLanguage field_44015_a;


   public GuiSlotLanguage(GuiLanguage p_i697_1_) {
      super(p_i697_1_.field_945_b, p_i697_1_.field_951_c, p_i697_1_.field_950_d, 32, p_i697_1_.field_950_d - 65 + 4, 18);
      this.field_44015_a = p_i697_1_;
      this.field_44014_c = StringTranslate.func_20162_a().func_44022_b();
      this.field_44013_b = new ArrayList();
      Iterator var2 = this.field_44014_c.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.field_44013_b.add(var3);
      }

   }

   protected int func_22249_a() {
      return this.field_44013_b.size();
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {
      StringTranslate.func_20162_a().func_44023_a((String)this.field_44013_b.get(p_22247_1_));
      this.field_44015_a.field_945_b.field_6314_o.func_44032_a(StringTranslate.func_20162_a().func_46110_d());
      GuiLanguage.func_44005_a(this.field_44015_a).field_44018_Q = (String)this.field_44013_b.get(p_22247_1_);
      this.field_44015_a.field_6451_g.func_46123_b(StringTranslate.func_46109_d(GuiLanguage.func_44005_a(this.field_44015_a).field_44018_Q));
      GuiLanguage.func_46028_b(this.field_44015_a).field_939_e = StringTranslate.func_20162_a().func_20163_a("gui.done");
   }

   protected boolean func_22246_a(int p_22246_1_) {
      return ((String)this.field_44013_b.get(p_22246_1_)).equals(StringTranslate.func_20162_a().func_44024_c());
   }

   protected int func_22245_b() {
      return this.func_22249_a() * 18;
   }

   protected void func_22248_c() {
      this.field_44015_a.func_578_i();
   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      this.field_44015_a.field_6451_g.func_46123_b(true);
      this.field_44015_a.func_548_a(this.field_44015_a.field_6451_g, (String)this.field_44014_c.get(this.field_44013_b.get(p_22242_1_)), this.field_44015_a.field_951_c / 2, p_22242_3_ + 1, 16777215);
      this.field_44015_a.field_6451_g.func_46123_b(StringTranslate.func_46109_d(GuiLanguage.func_44005_a(this.field_44015_a).field_44018_Q));
   }
}
