package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class IntCache {

   private static int field_35273_a = 256;
   private static List field_35271_b = new ArrayList();
   private static List field_35272_c = new ArrayList();
   private static List field_35269_d = new ArrayList();
   private static List field_35270_e = new ArrayList();


   public static int[] func_35267_a(int p_35267_0_) {
      int[] var1;
      if(p_35267_0_ <= 256) {
         if(field_35271_b.size() == 0) {
            var1 = new int[256];
            field_35272_c.add(var1);
            return var1;
         } else {
            var1 = (int[])field_35271_b.remove(field_35271_b.size() - 1);
            field_35272_c.add(var1);
            return var1;
         }
      } else if(p_35267_0_ > field_35273_a) {
         field_35273_a = p_35267_0_;
         field_35269_d.clear();
         field_35270_e.clear();
         var1 = new int[field_35273_a];
         field_35270_e.add(var1);
         return var1;
      } else if(field_35269_d.size() == 0) {
         var1 = new int[field_35273_a];
         field_35270_e.add(var1);
         return var1;
      } else {
         var1 = (int[])field_35269_d.remove(field_35269_d.size() - 1);
         field_35270_e.add(var1);
         return var1;
      }
   }

   public static void func_35268_a() {
      if(field_35269_d.size() > 0) {
         field_35269_d.remove(field_35269_d.size() - 1);
      }

      if(field_35271_b.size() > 0) {
         field_35271_b.remove(field_35271_b.size() - 1);
      }

      field_35269_d.addAll(field_35270_e);
      field_35271_b.addAll(field_35272_c);
      field_35270_e.clear();
      field_35272_c.clear();
   }

}
