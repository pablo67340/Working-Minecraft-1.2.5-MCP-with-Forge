package argo.jdom;

import argo.format.CompactJsonFormatter;
import argo.format.JsonFormatter;
import argo.jdom.JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import argo.jdom.JsonNodeDoesNotMatchJsonNodeSelectorException;
import argo.jdom.JsonRootNode;

public final class JsonNodeDoesNotMatchPathElementsException extends JsonNodeDoesNotMatchJsonNodeSelectorException {

   private static final JsonFormatter field_27320_a = new CompactJsonFormatter();


   static JsonNodeDoesNotMatchPathElementsException func_27319_a(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_27319_0_, Object[] p_27319_1_, JsonRootNode p_27319_2_) {
      return new JsonNodeDoesNotMatchPathElementsException(p_27319_0_, p_27319_1_, p_27319_2_);
   }

   private JsonNodeDoesNotMatchPathElementsException(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_i611_1_, Object[] p_i611_2_, JsonRootNode p_i611_3_) {
      super(func_27318_b(p_i611_1_, p_i611_2_, p_i611_3_));
   }

   private static String func_27318_b(JsonNodeDoesNotMatchChainedJsonNodeSelectorException p_27318_0_, Object[] p_27318_1_, JsonRootNode p_27318_2_) {
      return "Failed to find " + p_27318_0_.field_27326_a.toString() + " at [" + JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27324_a(p_27318_0_.field_27325_b) + "] while resolving [" + func_27317_a(p_27318_1_) + "] in " + field_27320_a.func_27327_a(p_27318_2_) + ".";
   }

   private static String func_27317_a(Object[] p_27317_0_) {
      StringBuilder var1 = new StringBuilder();
      boolean var2 = true;
      Object[] var3 = p_27317_0_;
      int var4 = p_27317_0_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         if(!var2) {
            var1.append(".");
         }

         var2 = false;
         if(var6 instanceof String) {
            var1.append("\"").append(var6).append("\"");
         } else {
            var1.append(var6);
         }
      }

      return var1.toString();
   }

}
