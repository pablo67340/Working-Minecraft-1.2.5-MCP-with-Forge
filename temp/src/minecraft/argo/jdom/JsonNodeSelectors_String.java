package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.LeafFunctor;

final class JsonNodeSelectors_String extends LeafFunctor {

   public boolean func_27072_a(JsonNode p_27072_1_) {
      return JsonNodeType.STRING == p_27072_1_.func_27218_a();
   }

   public String func_27060_a() {
      return "A short form string";
   }

   public String func_27073_b(JsonNode p_27073_1_) {
      return p_27073_1_.func_27216_b();
   }

   public String toString() {
      return "a value that is a string";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_27063_c(Object p_27063_1_) {
      return this.func_27073_b((JsonNode)p_27063_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_27058_a(Object p_27058_1_) {
      return this.func_27072_a((JsonNode)p_27058_1_);
   }
}
