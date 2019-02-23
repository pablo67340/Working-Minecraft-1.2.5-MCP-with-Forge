package argo.jdom;

import argo.jdom.JsonNodeType;
import argo.jdom.JsonRootNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class JsonObject extends JsonRootNode {

   private final Map field_27222_a;


   JsonObject(Map p_i363_1_) {
      this.field_27222_a = new HashMap(p_i363_1_);
   }

   public Map func_27214_c() {
      return new HashMap(this.field_27222_a);
   }

   public JsonNodeType func_27218_a() {
      return JsonNodeType.OBJECT;
   }

   public String func_27216_b() {
      throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
   }

   public List func_27215_d() {
      throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         JsonObject var2 = (JsonObject)p_equals_1_;
         return this.field_27222_a.equals(var2.field_27222_a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_27222_a.hashCode();
   }

   public String toString() {
      return "JsonObject fields:[" + this.field_27222_a + "]";
   }
}
