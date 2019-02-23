package net.minecraft.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeMap;

public class StringTranslate {

   private static StringTranslate field_20165_a = new StringTranslate();
   private Properties field_20164_b = new Properties();
   private TreeMap field_44027_c;
   private String field_44026_d;
   private boolean field_46111_e;


   private StringTranslate() {
      this.func_44021_d();
      this.func_44023_a("en_US");
   }

   public static StringTranslate func_20162_a() {
      return field_20165_a;
   }

   private void func_44021_d() {
      TreeMap var1 = new TreeMap();

      try {
         BufferedReader var2 = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/languages.txt"), "UTF-8"));

         for(String var3 = var2.readLine(); var3 != null; var3 = var2.readLine()) {
            String[] var4 = var3.split("=");
            if(var4 != null && var4.length == 2) {
               var1.put(var4[0], var4[1]);
            }
         }
      } catch (IOException var5) {
         var5.printStackTrace();
         return;
      }

      this.field_44027_c = var1;
   }

   public TreeMap func_44022_b() {
      return this.field_44027_c;
   }

   private void func_44025_a(Properties p_44025_1_, String p_44025_2_) throws IOException {
      BufferedReader var3 = new BufferedReader(new InputStreamReader(StringTranslate.class.getResourceAsStream("/lang/" + p_44025_2_ + ".lang"), "UTF-8"));

      for(String var4 = var3.readLine(); var4 != null; var4 = var3.readLine()) {
         var4 = var4.trim();
         if(!var4.startsWith("#")) {
            String[] var5 = var4.split("=");
            if(var5 != null && var5.length == 2) {
               p_44025_1_.setProperty(var5[0], var5[1]);
            }
         }
      }

   }

   public void func_44023_a(String p_44023_1_) {
      if(!p_44023_1_.equals(this.field_44026_d)) {
         Properties var2 = new Properties();

         try {
            this.func_44025_a(var2, "en_US");
         } catch (IOException var8) {
            ;
         }

         this.field_46111_e = false;
         if(!"en_US".equals(p_44023_1_)) {
            try {
               this.func_44025_a(var2, p_44023_1_);
               Enumeration var3 = var2.propertyNames();

               while(var3.hasMoreElements() && !this.field_46111_e) {
                  Object var4 = var3.nextElement();
                  Object var5 = var2.get(var4);
                  if(var5 != null) {
                     String var6 = var5.toString();

                     for(int var7 = 0; var7 < var6.length(); ++var7) {
                        if(var6.charAt(var7) >= 256) {
                           this.field_46111_e = true;
                           break;
                        }
                     }
                  }
               }
            } catch (IOException var9) {
               var9.printStackTrace();
               return;
            }
         }

         this.field_44026_d = p_44023_1_;
         this.field_20164_b = var2;
      }
   }

   public String func_44024_c() {
      return this.field_44026_d;
   }

   public boolean func_46110_d() {
      return this.field_46111_e;
   }

   public String func_20163_a(String p_20163_1_) {
      return this.field_20164_b.getProperty(p_20163_1_, p_20163_1_);
   }

   public String func_20160_a(String p_20160_1_, Object ... p_20160_2_) {
      String var3 = this.field_20164_b.getProperty(p_20160_1_, p_20160_1_);
      return String.format(var3, p_20160_2_);
   }

   public String func_20161_b(String p_20161_1_) {
      return this.field_20164_b.getProperty(p_20161_1_ + ".name", "");
   }

   public static boolean func_46109_d(String p_46109_0_) {
      return "ar_SA".equals(p_46109_0_) || "he_IL".equals(p_46109_0_);
   }

}
