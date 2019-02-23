package argo.jdom;

import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeDoesNotMatchPathElementsException;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonNodeSelector;
import argo.jdom.JsonNodeSelectors;
import argo.jdom.JsonNodeType;
import java.util.List;
import java.util.Map;

public abstract class JsonNode {

   public abstract JsonNodeType func_27218_a();

   public abstract String func_27216_b();

   public abstract Map func_27214_c();

   public abstract List func_27215_d();

   public final String func_27213_a(Object ... p_27213_1_) {
      return (String)this.func_27219_a(JsonNodeSelectors.func_27349_a(p_27213_1_), this, p_27213_1_);
   }

   public final List func_27217_b(Object ... p_27217_1_) {
      return (List)this.func_27219_a(JsonNodeSelectors.func_27346_b(p_27217_1_), this, p_27217_1_);
   }

   private Object func_27219_a(JsonNodeSelector p_27219_1_, JsonNode p_27219_2_, Object[] p_27219_3_) {
      try {
         return p_27219_1_.func_27357_b(p_27219_2_);
      } catch (JsonNodeDoesNotMatchChainedJsonNodeSelectorException var5) {
         throw JsonNodeDoesNotMatchPathElementsException.func_27319_a(var5, p_27219_3_, JsonNodeFactories.func_27315_a(new JsonNode[]{p_27219_2_}));
      }
   }
}
