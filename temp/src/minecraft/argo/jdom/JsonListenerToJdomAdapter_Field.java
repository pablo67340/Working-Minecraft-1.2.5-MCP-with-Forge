package argo.jdom;

import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonListenerToJdomAdapter;
import argo.jdom.JsonListenerToJdomAdapter_NodeContainer;
import argo.jdom.JsonNodeBuilder;

class JsonListenerToJdomAdapter_Field implements JsonListenerToJdomAdapter_NodeContainer {

   // $FF: synthetic field
   final JsonFieldBuilder field_27292_a;
   // $FF: synthetic field
   final JsonListenerToJdomAdapter field_27291_b;


   JsonListenerToJdomAdapter_Field(JsonListenerToJdomAdapter p_i41_1_, JsonFieldBuilder p_i41_2_) {
      this.field_27291_b = p_i41_1_;
      this.field_27292_a = p_i41_2_;
   }

   public void func_27290_a(JsonNodeBuilder p_27290_1_) {
      this.field_27292_a.func_27300_b(p_27290_1_);
   }

   public void func_27289_a(JsonFieldBuilder p_27289_1_) {
      throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to a field.");
   }
}
