package argo.jdom;

import argo.jdom.ChainedFunctor;
import argo.jdom.Functor;

public final class JsonNodeSelector {

   final Functor field_27359_a;


   JsonNodeSelector(Functor p_i762_1_) {
      this.field_27359_a = p_i762_1_;
   }

   public boolean func_27356_a(Object p_27356_1_) {
      return this.field_27359_a.func_27058_a(p_27356_1_);
   }

   public Object func_27357_b(Object p_27357_1_) {
      return this.field_27359_a.func_27059_b(p_27357_1_);
   }

   public JsonNodeSelector func_27355_a(JsonNodeSelector p_27355_1_) {
      return new JsonNodeSelector(new ChainedFunctor(this, p_27355_1_));
   }

   String func_27358_a() {
      return this.field_27359_a.func_27060_a();
   }

   public String toString() {
      return this.field_27359_a.toString();
   }
}
