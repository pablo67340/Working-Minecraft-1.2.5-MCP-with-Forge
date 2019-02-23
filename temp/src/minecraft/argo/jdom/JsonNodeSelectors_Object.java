package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.LeafFunctor;
import java.util.Map;

final class JsonNodeSelectors_Object extends LeafFunctor {

   public boolean func_27070_a(JsonNode p_27070_1_) {
      return JsonNodeType.OBJECT == p_27070_1_.func_27218_a();
   }

   public String func_27060_a() {
      return "A short form object";
   }

   public Map func_27071_b(JsonNode p_27071_1_) {
      return p_27071_1_.func_27214_c();
   }

   public String toString() {
      return "an object";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_27063_c(Object p_27063_1_) {
      return this.func_27071_b((JsonNode)p_27063_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_27058_a(Object p_27058_1_) {
      return this.func_27070_a((JsonNode)p_27058_1_);
   }
}
