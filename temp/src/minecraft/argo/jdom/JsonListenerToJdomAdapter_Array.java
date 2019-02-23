package argo.jdom;

import argo.jdom.JsonArrayNodeBuilder;
import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonListenerToJdomAdapter;
import argo.jdom.JsonListenerToJdomAdapter_NodeContainer;
import argo.jdom.JsonNodeBuilder;

class JsonListenerToJdomAdapter_Array implements JsonListenerToJdomAdapter_NodeContainer {

   // $FF: synthetic field
   final JsonArrayNodeBuilder field_27294_a;
   // $FF: synthetic field
   final JsonListenerToJdomAdapter field_27293_b;


   JsonListenerToJdomAdapter_Array(JsonListenerToJdomAdapter p_i39_1_, JsonArrayNodeBuilder p_i39_2_) {
      this.field_27293_b = p_i39_1_;
      this.field_27294_a = p_i39_2_;
   }

   public void func_27290_a(JsonNodeBuilder p_27290_1_) {
      this.field_27294_a.func_27240_a(p_27290_1_);
   }

   public void func_27289_a(JsonFieldBuilder p_27289_1_) {
      throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
   }
}
