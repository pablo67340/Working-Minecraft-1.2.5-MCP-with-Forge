package argo.jdom;

import argo.jdom.JsonArrayNodeBuilder;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeBuilders_False;
import argo.jdom.JsonNodeBuilders_Null;
import argo.jdom.JsonNodeBuilders_True;
import argo.jdom.JsonNumberNodeBuilder;
import argo.jdom.JsonObjectNodeBuilder;
import argo.jdom.JsonStringNodeBuilder;

public final class JsonNodeBuilders {

   public static JsonNodeBuilder func_27248_a() {
      return new JsonNodeBuilders_Null();
   }

   public static JsonNodeBuilder func_27251_b() {
      return new JsonNodeBuilders_True();
   }

   public static JsonNodeBuilder func_27252_c() {
      return new JsonNodeBuilders_False();
   }

   public static JsonNodeBuilder func_27250_a(String p_27250_0_) {
      return new JsonNumberNodeBuilder(p_27250_0_);
   }

   public static JsonStringNodeBuilder func_27254_b(String p_27254_0_) {
      return new JsonStringNodeBuilder(p_27254_0_);
   }

   public static JsonObjectNodeBuilder func_27253_d() {
      return new JsonObjectNodeBuilder();
   }

   public static JsonArrayNodeBuilder func_27249_e() {
      return new JsonArrayNodeBuilder();
   }
}
