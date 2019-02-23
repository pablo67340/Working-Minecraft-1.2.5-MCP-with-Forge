package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import java.util.List;
import java.util.Map;

public final class JsonStringNode extends JsonNode implements Comparable {

   private final String field_27224_a;


   JsonStringNode(String p_i439_1_) {
      if(p_i439_1_ == null) {
         throw new NullPointerException("Attempt to construct a JsonString with a null value.");
      } else {
         this.field_27224_a = p_i439_1_;
      }
   }

   public JsonNodeType func_27218_a() {
      return JsonNodeType.STRING;
   }

   public String func_27216_b() {
      return this.field_27224_a;
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
         JsonStringNode var2 = (JsonStringNode)p_equals_1_;
         return this.field_27224_a.equals(var2.field_27224_a);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field_27224_a.hashCode();
   }

   public String toString() {
      return "JsonStringNode value:[" + this.field_27224_a + "]";
   }

   public int func_27223_a(JsonStringNode p_27223_1_) {
      return this.field_27224_a.compareTo(p_27223_1_.field_27224_a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_27223_a((JsonStringNode)p_compareTo_1_);
   }
}
