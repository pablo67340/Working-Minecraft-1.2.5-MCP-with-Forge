package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;

abstract class LeafFunctor implements Functor {

   public final Object func_27059_b(Object p_27059_1_) {
      if(!this.func_27058_a(p_27059_1_)) {
         throw JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27322_a(this);
      } else {
         return this.func_27063_c(p_27059_1_);
      }
   }

   protected abstract Object func_27063_c(Object var1);
}
