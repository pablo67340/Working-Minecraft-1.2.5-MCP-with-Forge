package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class PacketCount {

   public static boolean field_40565_a = true;
   private static final Map field_40563_b = new HashMap();
   private static final Map field_40564_c = new HashMap();
   private static final Object field_40562_d = new Object();


   public static void func_40561_a(int p_40561_0_, long p_40561_1_) {
      if(field_40565_a) {
         Object var3 = field_40562_d;
         synchronized(field_40562_d) {
            if(field_40563_b.containsKey(Integer.valueOf(p_40561_0_))) {
               field_40563_b.put(Integer.valueOf(p_40561_0_), Long.valueOf(((Long)field_40563_b.get(Integer.valueOf(p_40561_0_))).longValue() + 1L));
               field_40564_c.put(Integer.valueOf(p_40561_0_), Long.valueOf(((Long)field_40564_c.get(Integer.valueOf(p_40561_0_))).longValue() + p_40561_1_));
            } else {
               field_40563_b.put(Integer.valueOf(p_40561_0_), Long.valueOf(1L));
               field_40564_c.put(Integer.valueOf(p_40561_0_), Long.valueOf(p_40561_1_));
            }

         }
      }
   }

}
