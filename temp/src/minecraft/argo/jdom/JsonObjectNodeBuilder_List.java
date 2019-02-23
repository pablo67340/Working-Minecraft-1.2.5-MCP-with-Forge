package argo.jdom;

import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonObjectNodeBuilder;
import java.util.HashMap;
import java.util.Iterator;

class JsonObjectNodeBuilder_List extends HashMap {

   // $FF: synthetic field
   final JsonObjectNodeBuilder field_27308_a;


   JsonObjectNodeBuilder_List(JsonObjectNodeBuilder p_i425_1_) {
      this.field_27308_a = p_i425_1_;
      Iterator var2 = JsonObjectNodeBuilder.func_27236_a(this.field_27308_a).iterator();

      while(var2.hasNext()) {
         JsonFieldBuilder var3 = (JsonFieldBuilder)var2.next();
         this.put(var3.func_27303_b(), var3.func_27302_c());
      }

   }
}
