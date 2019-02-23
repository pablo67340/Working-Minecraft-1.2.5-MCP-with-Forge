package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;

final class JsonNumberNodeBuilder implements JsonNodeBuilder {

   private final JsonNode field_27239_a;


   JsonNumberNodeBuilder(String p_i61_1_) {
      this.field_27239_a = JsonNodeFactories.func_27311_b(p_i61_1_);
   }

   public JsonNode func_27234_b() {
      return this.field_27239_a;
   }
}
