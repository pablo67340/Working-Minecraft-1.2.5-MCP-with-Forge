package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.LeafFunctor;
import java.util.List;

final class JsonNodeSelectors_Array extends LeafFunctor {

   public boolean func_27074_a(JsonNode p_27074_1_) {
      return JsonNodeType.ARRAY == p_27074_1_.func_27218_a();
   }

   public String func_27060_a() {
      return "A short form array";
   }

   public List func_27075_b(JsonNode p_27075_1_) {
      return p_27075_1_.func_27215_d();
   }

   public String toString() {
      return "an array";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_27063_c(Object p_27063_1_) {
      return this.func_27075_b((JsonNode)p_27063_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_27058_a(Object p_27058_1_) {
      return this.func_27074_a((JsonNode)p_27058_1_);
   }
}
