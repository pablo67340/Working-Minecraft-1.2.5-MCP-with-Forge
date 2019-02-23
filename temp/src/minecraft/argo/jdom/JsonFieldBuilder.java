package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonStringNode;

final class JsonFieldBuilder {

   private JsonNodeBuilder field_27306_a;
   private JsonNodeBuilder field_27305_b;


   static JsonFieldBuilder func_27301_a() {
      return new JsonFieldBuilder();
   }

   JsonFieldBuilder func_27304_a(JsonNodeBuilder p_27304_1_) {
      this.field_27306_a = p_27304_1_;
      return this;
   }

   JsonFieldBuilder func_27300_b(JsonNodeBuilder p_27300_1_) {
      this.field_27305_b = p_27300_1_;
      return this;
   }

   JsonStringNode func_27303_b() {
      return (JsonStringNode)this.field_27306_a.func_27234_b();
   }

   JsonNode func_27302_c() {
      return this.field_27305_b.func_27234_b();
   }
}
