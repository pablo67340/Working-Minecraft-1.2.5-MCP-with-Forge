package argo.jdom;

import argo.jdom.JsonArray_NodeList;
import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class JsonArray extends JsonRootNode {

   private final List field_27221_a;


   JsonArray(Iterable p_i65_1_) {
      this.field_27221_a = func_27220_a(p_i65_1_);
   }

   public JsonNodeType func_27218_a() {
      return JsonNodeType.ARRAY;
   }

   public List func_27215_d() {
      return new ArrayList(this.field_27221_a);
   }

   public String func_27216_b() {
      throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
   }

   public Map func_27214_c() {
      throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         JsonArray var2 = (JsonArray)p_equals_1_;
         return this.field_27221_a.equals(var2.field_27221_a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_27221_a.hashCode();
   }

   public String toString() {
      return "JsonArray elements:[" + this.field_27221_a + "]";
   }

   private static List func_27220_a(Iterable p_27220_0_) {
      return new JsonArray_NodeList(p_27220_0_);
   }
}
