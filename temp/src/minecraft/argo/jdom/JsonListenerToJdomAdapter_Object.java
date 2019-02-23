package argo.jdom;

import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonListenerToJdomAdapter;
import argo.jdom.JsonListenerToJdomAdapter_NodeContainer;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonObjectNodeBuilder;

class JsonListenerToJdomAdapter_Object implements JsonListenerToJdomAdapter_NodeContainer {

   // $FF: synthetic field
   final JsonObjectNodeBuilder field_27296_a;
   // $FF: synthetic field
   final JsonListenerToJdomAdapter field_27295_b;


   JsonListenerToJdomAdapter_Object(JsonListenerToJdomAdapter p_i38_1_, JsonObjectNodeBuilder p_i38_2_) {
      this.field_27295_b = p_i38_1_;
      this.field_27296_a = p_i38_2_;
   }

   public void func_27290_a(JsonNodeBuilder p_27290_1_) {
      throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
   }

   public void func_27289_a(JsonFieldBuilder p_27289_1_) {
      this.field_27296_a.func_27237_a(p_27289_1_);
   }
}
