package argo.jdom;

import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonObjectNodeBuilder_List;
import argo.jdom.JsonRootNode;
import java.util.LinkedList;
import java.util.List;

public final class JsonObjectNodeBuilder implements JsonNodeBuilder {

   private final List field_27238_a = new LinkedList();


   public JsonObjectNodeBuilder func_27237_a(JsonFieldBuilder p_27237_1_) {
      this.field_27238_a.add(p_27237_1_);
      return this;
   }

   public JsonRootNode func_27235_a() {
      return JsonNodeFactories.func_27312_a(new JsonObjectNodeBuilder_List(this));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonNode func_27234_b() {
      return this.func_27235_a();
   }

   // $FF: synthetic method
   static List func_27236_a(JsonObjectNodeBuilder p_27236_0_) {
      return p_27236_0_.field_27238_a;
   }
}
