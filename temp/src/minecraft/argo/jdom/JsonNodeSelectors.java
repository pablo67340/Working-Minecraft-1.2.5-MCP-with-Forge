package argo.jdom;

import argo.jdom.ChainedFunctor;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonNodeSelector;
import argo.jdom.JsonNodeSelectors_Array;
import argo.jdom.JsonNodeSelectors_Element;
import argo.jdom.JsonNodeSelectors_Field;
import argo.jdom.JsonNodeSelectors_Object;
import argo.jdom.JsonNodeSelectors_String;
import argo.jdom.JsonStringNode;
import java.util.Arrays;

public final class JsonNodeSelectors {

   public static JsonNodeSelector func_27349_a(Object ... p_27349_0_) {
      return func_27352_a(p_27349_0_, new JsonNodeSelector(new JsonNodeSelectors_String()));
   }

   public static JsonNodeSelector func_27346_b(Object ... p_27346_0_) {
      return func_27352_a(p_27346_0_, new JsonNodeSelector(new JsonNodeSelectors_Array()));
   }

   public static JsonNodeSelector func_27353_c(Object ... p_27353_0_) {
      return func_27352_a(p_27353_0_, new JsonNodeSelector(new JsonNodeSelectors_Object()));
   }

   public static JsonNodeSelector func_27348_a(String p_27348_0_) {
      return func_27350_a(JsonNodeFactories.func_27316_a(p_27348_0_));
   }

   public static JsonNodeSelector func_27350_a(JsonStringNode p_27350_0_) {
      return new JsonNodeSelector(new JsonNodeSelectors_Field(p_27350_0_));
   }

   public static JsonNodeSelector func_27351_b(String p_27351_0_) {
      return func_27353_c(new Object[0]).func_27355_a(func_27348_a(p_27351_0_));
   }

   public static JsonNodeSelector func_27347_a(int p_27347_0_) {
      return new JsonNodeSelector(new JsonNodeSelectors_Element(p_27347_0_));
   }

   public static JsonNodeSelector func_27354_b(int p_27354_0_) {
      return func_27346_b(new Object[0]).func_27355_a(func_27347_a(p_27354_0_));
   }

   private static JsonNodeSelector func_27352_a(Object[] p_27352_0_, JsonNodeSelector p_27352_1_) {
      JsonNodeSelector var2 = p_27352_1_;

      for(int var3 = p_27352_0_.length - 1; var3 >= 0; --var3) {
         if(p_27352_0_[var3] instanceof Integer) {
            var2 = func_27345_a(func_27354_b(((Integer)p_27352_0_[var3]).intValue()), var2);
         } else {
            if(!(p_27352_0_[var3] instanceof String)) {
               throw new IllegalArgumentException("Element [" + p_27352_0_[var3] + "] of path elements" + " [" + Arrays.toString(p_27352_0_) + "] was of illegal type [" + p_27352_0_[var3].getClass().getCanonicalName() + "]; only Integer and String are valid.");
            }

            var2 = func_27345_a(func_27351_b((String)p_27352_0_[var3]), var2);
         }
      }

      return var2;
   }

   private static JsonNodeSelector func_27345_a(JsonNodeSelector p_27345_0_, JsonNodeSelector p_27345_1_) {
      return new JsonNodeSelector(new ChainedFunctor(p_27345_0_, p_27345_1_));
   }
}
