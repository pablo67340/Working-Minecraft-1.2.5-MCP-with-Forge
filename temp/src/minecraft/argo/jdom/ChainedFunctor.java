package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeSelector;

final class ChainedFunctor implements Functor {

   private final JsonNodeSelector field_27062_a;
   private final JsonNodeSelector field_27061_b;


   ChainedFunctor(JsonNodeSelector p_i600_1_, JsonNodeSelector p_i600_2_) {
      this.field_27062_a = p_i600_1_;
      this.field_27061_b = p_i600_2_;
   }

   public boolean func_27058_a(Object p_27058_1_) {
      return this.field_27062_a.func_27356_a(p_27058_1_) && this.field_27061_b.func_27356_a(this.field_27062_a.func_27357_b(p_27058_1_));
   }

   public Object func_27059_b(Object p_27059_1_) {
      Object var2;
      try {
         var2 = this.field_27062_a.func_27357_b(p_27059_1_);
      } catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException var6) {
         throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27321_b(var6, this.field_27062_a);
      }

      try {
         Object var3 = this.field_27061_b.func_27357_b(var2);
         return var3;
      } catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
         throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27323_a(var5, this.field_27062_a);
      }
   }

   public String func_27060_a() {
      return this.field_27061_b.func_27358_a();
   }

   public String toString() {
      return this.field_27062_a.toString() + ", with " + this.field_27061_b.toString();
   }
}
