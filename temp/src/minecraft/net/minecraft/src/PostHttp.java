package net.minecraft.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostHttp {

   public static String func_52016_a(Map p_52016_0_) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = p_52016_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if(var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String func_52018_a(URL p_52018_0_, Map p_52018_1_, boolean p_52018_2_) {
      return func_52017_a(p_52018_0_, func_52016_a(p_52018_1_), p_52018_2_);
   }

   public static String func_52017_a(URL p_52017_0_, String p_52017_1_, boolean p_52017_2_) {
      try {
         HttpURLConnection var4 = (HttpURLConnection)p_52017_0_.openConnection();
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4.setRequestProperty("Content-Length", "" + p_52017_1_.getBytes().length);
         var4.setRequestProperty("Content-Language", "en-US");
         var4.setUseCaches(false);
         var4.setDoInput(true);
         var4.setDoOutput(true);
         DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
         var5.writeBytes(p_52017_1_);
         var5.flush();
         var5.close();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
         StringBuffer var8 = new StringBuffer();

         String var7;
         while((var7 = var6.readLine()) != null) {
            var8.append(var7);
            var8.append('\r');
         }

         var6.close();
         return var8.toString();
      } catch (Exception var9) {
         if(!p_52017_2_) {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not post to " + p_52017_0_, var9);
         }

         return "";
      }
   }
}
