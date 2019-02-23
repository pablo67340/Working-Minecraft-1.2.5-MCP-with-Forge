package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class JsonNumberNode extends JsonNode {

   private static final Pattern field_27226_a = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
   private final String field_27225_b;


   JsonNumberNode(String p_i742_1_) {
      if(p_i742_1_ == null) {
         throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
      } else if(!field_27226_a.matcher(p_i742_1_).matches()) {
         throw new IllegalArgumentException("Attempt to construct a JsonNumber with a String [" + p_i742_1_ + "] that does not match the JSON number specification.");
      } else {
         this.field_27225_b = p_i742_1_;
      }
   }

   public JsonNodeType func_27218_a() {
      return JsonNodeType.NUMBER;
   }

   public String func_27216_b() {
      return this.field_27225_b;
   }

   public Map func_27214_c() {
      throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
   }

   public List func_27215_d() {
      throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
   }

   public boolean equals(Object p_equals_1_) {
      if(this == p_equals_1_) {
         return true;
      } else if(p_equals_1_ != null && this.getClass() == p_equals_1_.getClass()) {
         JsonNumberNode var2 = (JsonNumberNode)p_equals_1_;
         return this.field_27225_b.equals(var2.field_27225_b);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_27225_b.hashCode();
   }

   public String toString() {
      return "JsonNumberNode value:[" + this.field_27225_b + "]";
   }

}
