package argo.format;


final class JsonEscapedString {

   private final String field_27031_a;


   JsonEscapedString(String p_i220_1_) {
      this.field_27031_a = p_i220_1_.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
   }

   public String toString() {
      return this.field_27031_a;
   }
}
