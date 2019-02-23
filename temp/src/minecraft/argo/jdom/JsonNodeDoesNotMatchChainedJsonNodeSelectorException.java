package argo.jdom;

import argo.jdom.Functor;
import argo.jdom.JsonNodeDoesNotMatchJsonNodeSelectorException;
import argo.jdom.JsonNodeSelector;
import java.util.LinkedList;
import java.util.List;

public final class JsonNodeDoesNotMatchChainedJsonNodeSelectorException extends JsonNodeDoesNotMatchJsonNodeSelectorException {

   final Functor field_27326_a;
   final List field_27325_b;


   static JsonNodeDoesNotMatchJsonNodeSelectorException func_27322_a(Functor p_27322_0_) {
      return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_27322_0_, new LinkedList());
   }

   static JsonNodeDoesNotMatchJsonNodeSelectorException func_27323_a(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_27323_0_, JsonNodeSelector p_27323_1_) {
      LinkedList var2 = new LinkedList(p_27323_0_.field_27325_b);
      var2.add(p_27323_1_);
      return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_27323_0_.field_27326_a, var2);
   }

   static JsonNodeDoesNotMatchJsonNodeSelectorException func_27321_b(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_27321_0_, JsonNodeSelector p_27321_1_) {
      LinkedList var2 = new LinkedList();
      var2.add(p_27321_1_);
      return new JsonNodeDoesNotMatchChainedJsonNodeSelectorException(p_27321_0_.field_27326_a, var2);
   }

   private JsonNodeDoesNotMatchChainedJsonNodeSelectorException(Functor p_i40_1_, List p_i40_2_) {
      super("Failed to match any JSON node at [" + func_27324_a(p_i40_2_) + "]");
      this.field_27326_a = p_i40_1_;
      this.field_27325_b = p_i40_2_;
   }

   static String func_27324_a(List p_27324_0_) {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = p_27324_0_.size() - 1; var2 >= 0; --var2) {
         var1.append(((JsonNodeSelector)p_27324_0_.get(var2)).func_27358_a());
         if(var2 != 0) {
            var1.append(".");
         }
      }

      return var1.toString();
   }

   public String toString() {
      return "JsonNodeDoesNotMatchJsonNodeSelectorException{failedNode=" + this.field_27326_a + ", failPath=" + this.field_27325_b + '}';
   }
}
