package net.minecraft.src;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.src.ChatLine;
import net.minecraft.src.FontRenderer;

public class ChatClickData {

   public static final Pattern field_50097_a = Pattern.compile("^(?:(https?)://)?([-\\w_\\.]{2,}\\.[a-z]{2,3})(/\\S*)?$");
   private final FontRenderer field_50095_b;
   private final ChatLine field_50096_c;
   private final int field_50093_d;
   private final int field_50094_e;
   private final String field_50091_f;
   private final String field_50092_g;


   public ChatClickData(FontRenderer p_i1203_1_, ChatLine p_i1203_2_, int p_i1203_3_, int p_i1203_4_) {
      this.field_50095_b = p_i1203_1_;
      this.field_50096_c = p_i1203_2_;
      this.field_50093_d = p_i1203_3_;
      this.field_50094_e = p_i1203_4_;
      this.field_50091_f = p_i1203_1_.func_50107_a(p_i1203_2_.field_1297_a, p_i1203_3_);
      this.field_50092_g = this.func_50090_c();
   }

   public String func_50088_a() {
      return this.field_50092_g;
   }

   public URI func_50089_b() {
      String var1 = this.func_50088_a();
      if(var1 == null) {
         return null;
      } else {
         Matcher var2 = field_50097_a.matcher(var1);
         if(var2.matches()) {
            try {
               String var3 = var2.group(0);
               if(var2.group(1) == null) {
                  var3 = "http://" + var3;
               }

               return new URI(var3);
            } catch (URISyntaxException var4) {
               Logger.getLogger("Minecraft").log(Level.SEVERE, "Couldn\'t create URI from chat", var4);
            }
         }

         return null;
      }
   }

   private String func_50090_c() {
      int var1 = this.field_50091_f.lastIndexOf(" ", this.field_50091_f.length()) + 1;
      if(var1 < 0) {
         var1 = 0;
      }

      int var2 = this.field_50096_c.field_1297_a.indexOf(" ", var1);
      if(var2 < 0) {
         var2 = this.field_50096_c.field_1297_a.length();
      }

      FontRenderer var10000 = this.field_50095_b;
      return FontRenderer.func_52014_d(this.field_50096_c.field_1297_a.substring(var1, var2));
   }

}
