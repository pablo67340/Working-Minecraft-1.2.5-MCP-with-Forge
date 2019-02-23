package argo.format;

import argo.format.CompactJsonFormatter_JsonNodeType;
import argo.format.JsonEscapedString;
import argo.format.JsonFormatter;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.TreeSet;

public final class CompactJsonFormatter implements JsonFormatter {

   public String func_27327_a(JsonRootNode p_27327_1_) {
      StringWriter var2 = new StringWriter();

      try {
         this.func_27329_a(p_27327_1_, var2);
      } catch (IOException var4) {
         throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", var4);
      }

      return var2.toString();
   }

   public void func_27329_a(JsonRootNode p_27329_1_, Writer p_27329_2_) throws IOException {
      this.func_27328_a(p_27329_1_, p_27329_2_);
   }

   private void func_27328_a(JsonNode p_27328_1_, Writer p_27328_2_) throws IOException {
      boolean var3 = true;
      Iterator var4;
      switch(CompactJsonFormatter_JsonNodeType.field_27341_a[p_27328_1_.func_27218_a().ordinal()]) {
      case 1:
         p_27328_2_.append('[');
         var4 = p_27328_1_.func_27215_d().iterator();

         while(var4.hasNext()) {
            JsonNode var6 = (JsonNode)var4.next();
            if(!var3) {
               p_27328_2_.append(',');
            }

            var3 = false;
            this.func_27328_a(var6, p_27328_2_);
         }

         p_27328_2_.append(']');
         break;
      case 2:
         p_27328_2_.append('{');
         var4 = (new TreeSet(p_27328_1_.func_27214_c().keySet())).iterator();

         while(var4.hasNext()) {
            JsonStringNode var5 = (JsonStringNode)var4.next();
            if(!var3) {
               p_27328_2_.append(',');
            }

            var3 = false;
            this.func_27328_a(var5, p_27328_2_);
            p_27328_2_.append(':');
            this.func_27328_a((JsonNode)p_27328_1_.func_27214_c().get(var5), p_27328_2_);
         }

         p_27328_2_.append('}');
         break;
      case 3:
         p_27328_2_.append('\"').append((new JsonEscapedString(p_27328_1_.func_27216_b())).toString()).append('\"');
         break;
      case 4:
         p_27328_2_.append(p_27328_1_.func_27216_b());
         break;
      case 5:
         p_27328_2_.append("false");
         break;
      case 6:
         p_27328_2_.append("true");
         break;
      case 7:
         p_27328_2_.append("null");
         break;
      default:
         throw new RuntimeException("Coding failure in Argo:  Attempt to format a JsonNode of unknown type [" + p_27328_1_.func_27218_a() + "];");
      }

   }
}
