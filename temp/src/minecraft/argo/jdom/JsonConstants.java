package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import java.util.List;
import java.util.Map;

final class JsonConstants extends JsonNode {

   static final JsonConstants field_27228_a = new JsonConstants(JsonNodeType.NULL);
   static final JsonConstants field_27227_b = new JsonConstants(JsonNodeType.TRUE);
   static final JsonConstants field_27230_c = new JsonConstants(JsonNodeType.FALSE);
   private final JsonNodeType field_27229_d;


   private JsonConstants(JsonNodeType p_i527_1_) {
      this.field_27229_d = p_i527_1_;
   }

   public JsonNodeType func_27218_a() {
      return this.field_27229_d;
   }

   public String func_27216_b() {
      throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
   }

   public Map func_27214_c() {
      throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
   }

   public List func_27215_d() {
      throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
   }

}
