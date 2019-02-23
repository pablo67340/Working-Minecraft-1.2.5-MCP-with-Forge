package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.src.RegionFile;

public class RegionFileCache {

   private static final Map field_22195_a = new HashMap();


   public static synchronized RegionFile func_22193_a(File p_22193_0_, int p_22193_1_, int p_22193_2_) {
      File var3 = new File(p_22193_0_, "region");
      File var4 = new File(var3, "r." + (p_22193_1_ >> 5) + "." + (p_22193_2_ >> 5) + ".mca");
      Reference var5 = (Reference)field_22195_a.get(var4);
      RegionFile var6;
      if(var5 != null) {
         var6 = (RegionFile)var5.get();
         if(var6 != null) {
            return var6;
         }
      }

      if(!var3.exists()) {
         var3.mkdirs();
      }

      if(field_22195_a.size() >= 256) {
         func_22192_a();
      }

      var6 = new RegionFile(var4);
      field_22195_a.put(var4, new SoftReference(var6));
      return var6;
   }

   public static synchronized void func_22192_a() {
      Iterator var0 = field_22195_a.values().iterator();

      while(var0.hasNext()) {
         Reference var1 = (Reference)var0.next();

         try {
            RegionFile var2 = (RegionFile)var1.get();
            if(var2 != null) {
               var2.func_22196_b();
            }
         } catch (IOException var3) {
            var3.printStackTrace();
         }
      }

      field_22195_a.clear();
   }

   public static DataInputStream func_22194_c(File p_22194_0_, int p_22194_1_, int p_22194_2_) {
      RegionFile var3 = func_22193_a(p_22194_0_, p_22194_1_, p_22194_2_);
      return var3.func_22210_a(p_22194_1_ & 31, p_22194_2_ & 31);
   }

   public static DataOutputStream func_22190_d(File p_22190_0_, int p_22190_1_, int p_22190_2_) {
      RegionFile var3 = func_22193_a(p_22190_0_, p_22190_1_, p_22190_2_);
      return var3.func_22205_b(p_22190_1_ & 31, p_22190_2_ & 31);
   }

}
