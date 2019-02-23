package argo.jdom;

import argo.jdom.JsonArray;
import argo.jdom.JsonConstants;
import argo.jdom.JsonNode;
import argo.jdom.JsonNumberNode;
import argo.jdom.JsonObject;
import argo.jdom.JsonRootNode;
import argo.jdom.JsonStringNode;
import java.util.Arrays;
import java.util.Map;

public final class JsonNodeFactories {

   public static JsonNode func_27310_a() {
      return JsonConstants.field_27228_a;
   }

   public static JsonNode func_27313_b() {
      return JsonConstants.field_27227_b;
   }

   public static JsonNode func_27314_c() {
      return JsonConstants.field_27230_c;
   }

   public static JsonStringNode func_27316_a(String p_27316_0_) {
      return new JsonStringNode(p_27316_0_);
   }

   public static JsonNode func_27311_b(String p_27311_0_) {
      return new JsonNumberNode(p_27311_0_);
   }

   public static JsonRootNode func_27309_a(Iterable p_27309_0_) {
      return new JsonArray(p_27309_0_);
   }

   public static JsonRootNode func_27315_a(JsonNode ... p_27315_0_) {
      return func_27309_a(Arrays.asList(p_27315_0_));
   }

   public static JsonRootNode func_27312_a(Map p_27312_0_) {
      return new JsonObject(p_27312_0_);
   }
}
