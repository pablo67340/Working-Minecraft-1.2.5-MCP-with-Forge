package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.src.ProfilerResult;

public class Profiler {

   public static boolean field_40669_a = false;
   private static List field_40667_b = new ArrayList();
   private static List field_40668_c = new ArrayList();
   private static String field_40665_d = "";
   private static Map field_40666_e = new HashMap();


   public static void func_40660_a() {
      field_40666_e.clear();
   }

   public static void func_40663_a(String p_40663_0_) {
      if(field_40669_a) {
         if(field_40665_d.length() > 0) {
            field_40665_d = field_40665_d + ".";
         }

         field_40665_d = field_40665_d + p_40663_0_;
         field_40667_b.add(field_40665_d);
         field_40668_c.add(Long.valueOf(System.nanoTime()));
      }
   }

   public static void func_40662_b() {
      if(field_40669_a) {
         long var0 = System.nanoTime();
         long var2 = ((Long)field_40668_c.remove(field_40668_c.size() - 1)).longValue();
         field_40667_b.remove(field_40667_b.size() - 1);
         long var4 = var0 - var2;
         if(field_40666_e.containsKey(field_40665_d)) {
            field_40666_e.put(field_40665_d, Long.valueOf(((Long)field_40666_e.get(field_40665_d)).longValue() + var4));
         } else {
            field_40666_e.put(field_40665_d, Long.valueOf(var4));
         }

         field_40665_d = field_40667_b.size() > 0?(String)field_40667_b.get(field_40667_b.size() - 1):"";
         if(var4 > 100000000L) {
            System.out.println(field_40665_d + " " + var4);
         }

      }
   }

   public static List func_40664_b(String p_40664_0_) {
      if(!field_40669_a) {
         return null;
      } else {
         long var2 = field_40666_e.containsKey("root")?((Long)field_40666_e.get("root")).longValue():0L;
         long var4 = field_40666_e.containsKey(p_40664_0_)?((Long)field_40666_e.get(p_40664_0_)).longValue():-1L;
         ArrayList var6 = new ArrayList();
         if(p_40664_0_.length() > 0) {
            p_40664_0_ = p_40664_0_ + ".";
         }

         long var7 = 0L;
         Iterator var9 = field_40666_e.keySet().iterator();

         while(var9.hasNext()) {
            String var10 = (String)var9.next();
            if(var10.length() > p_40664_0_.length() && var10.startsWith(p_40664_0_) && var10.indexOf(".", p_40664_0_.length() + 1) < 0) {
               var7 += ((Long)field_40666_e.get(var10)).longValue();
            }
         }

         float var19 = (float)var7;
         if(var7 < var4) {
            var7 = var4;
         }

         if(var2 < var7) {
            var2 = var7;
         }

         Iterator var20 = field_40666_e.keySet().iterator();

         String var11;
         while(var20.hasNext()) {
            var11 = (String)var20.next();
            if(var11.length() > p_40664_0_.length() && var11.startsWith(p_40664_0_) && var11.indexOf(".", p_40664_0_.length() + 1) < 0) {
               long var12 = ((Long)field_40666_e.get(var11)).longValue();
               double var14 = (double)var12 * 100.0D / (double)var7;
               double var16 = (double)var12 * 100.0D / (double)var2;
               String var18 = var11.substring(p_40664_0_.length());
               var6.add(new ProfilerResult(var18, var14, var16));
            }
         }

         var20 = field_40666_e.keySet().iterator();

         while(var20.hasNext()) {
            var11 = (String)var20.next();
            field_40666_e.put(var11, Long.valueOf(((Long)field_40666_e.get(var11)).longValue() * 999L / 1000L));
         }

         if((float)var7 > var19) {
            var6.add(new ProfilerResult("unspecified", (double)((float)var7 - var19) * 100.0D / (double)var7, (double)((float)var7 - var19) * 100.0D / (double)var2));
         }

         Collections.sort(var6);
         var6.add(0, new ProfilerResult(p_40664_0_, 100.0D, (double)var7 * 100.0D / (double)var2));
         return var6;
      }
   }

   public static void func_40661_c(String p_40661_0_) {
      func_40662_b();
      func_40663_a(p_40661_0_);
   }

}
