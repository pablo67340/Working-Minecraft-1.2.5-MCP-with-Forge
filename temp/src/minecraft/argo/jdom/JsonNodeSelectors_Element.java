package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.LeafFunctor;
import java.util.List;

final class JsonNodeSelectors_Element extends LeafFunctor {

   // $FF: synthetic field
   final int field_27069_a;


   JsonNodeSelectors_Element(int p_i94_1_) {
      this.field_27069_a = p_i94_1_;
   }

   public boolean func_27067_a(List p_27067_1_) {
      return p_27067_1_.size() > this.field_27069_a;
   }

   public String func_27060_a() {
      return Integer.toString(this.field_27069_a);
   }

   public JsonNode func_27068_b(List p_27068_1_) {
      return (JsonNode)p_27068_1_.get(this.field_27069_a);
   }

   public String toString() {
      return "an element at index [" + this.field_27069_a + "]";
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object func_27063_c(Object p_27063_1_) {
      return this.func_27068_b((List)p_27063_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_27058_a(Object p_27058_1_) {
      return this.func_27067_a((List)p_27058_1_);
   }
}
