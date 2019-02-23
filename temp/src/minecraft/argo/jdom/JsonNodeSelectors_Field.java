package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonStringNode;
import argo.jdom.LeafFunctor;
import java.util.Map;

final class JsonNodeSelectors_Field extends LeafFunctor {

   // $FF: synthetic field
   final JsonStringNode field_27066_a;


   JsonNodeSelectors_Field(JsonStringNode p_i95_1_) {
      this.field_27066_a = p_i95_1_;
   }

   public boolean func_27065_a(Map p_27065_1_) {
      return p_27065_1_.containsKey(this.field_27066_a);
   }

   public String func_27060_a() {
      return "\"" + this.field_27066_a.func_27216_b() + "\"";
   }

   public JsonNode func_27064_b(Map p_27064_1_) {
      return (JsonNode)p_27064_1_.get(this.field_27066_a);
   }

   public String toString() {
      return "a field called [\"" + this.field_27066_a.func_27216_b() + "\"]";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_27063_c(Object p_27063_1_) {
      return this.func_27064_b((Map)p_27063_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_27058_a(Object p_27058_1_) {
      return this.func_27065_a((Map)p_27058_1_);
   }
}
