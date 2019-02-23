package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters {

   public static final String field_20157_a = func_20156_a();
   public static final char[] field_22286_b = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};


   private static String func_20156_a() {
      String var0 = "";

      try {
         BufferedReader var1 = new BufferedReader(new InputStreamReader(ChatAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            if(!var2.startsWith("#")) {
               var0 = var0 + var2;
            }
         }

         var1.close();
      } catch (Exception var3) {
         ;
      }

      return var0;
   }

   public static final boolean func_48614_a(char p_48614_0_) {
      return p_48614_0_ != 167 && (field_20157_a.indexOf(p_48614_0_) >= 0 || p_48614_0_ > 32);
   }

   public static String func_52019_a(String p_52019_0_) {
      StringBuilder var1 = new StringBuilder();
      char[] var2 = p_52019_0_.toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var2[var4];
         if(func_48614_a(var5)) {
            var1.append(var5);
         }
      }

      return var1.toString();
   }

}
