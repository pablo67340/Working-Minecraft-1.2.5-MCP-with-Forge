package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.IntHashMap;

public class KeyBinding {

   public static List field_35967_a = new ArrayList();
   public static IntHashMap field_35966_b = new IntHashMap();
   public String field_1371_a;
   public int field_1370_b;
   public boolean field_35965_e;
   public int field_35964_f = 0;


   public static void func_35960_a(int p_35960_0_) {
      KeyBinding var1 = (KeyBinding)field_35966_b.func_1057_a(p_35960_0_);
      if(var1 != null) {
         ++var1.field_35964_f;
      }

   }

   public static void func_35963_a(int p_35963_0_, boolean p_35963_1_) {
      KeyBinding var2 = (KeyBinding)field_35966_b.func_1057_a(p_35963_0_);
      if(var2 != null) {
         var2.field_35965_e = p_35963_1_;
      }

   }

   public static void func_35959_a() {
      Iterator var0 = field_35967_a.iterator();

      while(var0.hasNext()) {
         KeyBinding var1 = (KeyBinding)var0.next();
         var1.func_35958_d();
      }

   }

   public static void func_35961_b() {
      field_35966_b.func_1058_a();
      Iterator var0 = field_35967_a.iterator();

      while(var0.hasNext()) {
         KeyBinding var1 = (KeyBinding)var0.next();
         field_35966_b.func_1061_a(var1.field_1370_b, var1);
      }

   }

   public KeyBinding(String p_i91_1_, int p_i91_2_) {
      this.field_1371_a = p_i91_1_;
      this.field_1370_b = p_i91_2_;
      field_35967_a.add(this);
      field_35966_b.func_1061_a(p_i91_2_, this);
   }

   public boolean func_35962_c() {
      if(this.field_35964_f == 0) {
         return false;
      } else {
         --this.field_35964_f;
         return true;
      }
   }

   private void func_35958_d() {
      this.field_35964_f = 0;
      this.field_35965_e = false;
   }

}
