package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonStringNode;

public final class JsonStringNodeBuilder implements JsonNodeBuilder {

   private final String field_27244_a;


   JsonStringNodeBuilder(String p_i317_1_) {
      this.field_27244_a = p_i317_1_;
   }

   public JsonStringNode func_27243_a() {
      return JsonNodeFactories.func_27316_a(this.field_27244_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonNode func_27234_b() {
      return this.func_27243_a();
   }
}
