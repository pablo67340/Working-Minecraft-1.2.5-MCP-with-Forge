package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeFactories;
import argo.jdom.JsonRootNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class JsonArrayNodeBuilder implements JsonNodeBuilder {

   private final List field_27242_a = new LinkedList();


   public JsonArrayNodeBuilder func_27240_a(JsonNodeBuilder p_27240_1_) {
      this.field_27242_a.add(p_27240_1_);
      return this;
   }

   public JsonRootNode func_27241_a() {
      LinkedList var1 = new LinkedList();
      Iterator var2 = this.field_27242_a.iterator();

      while(var2.hasNext()) {
         JsonNodeBuilder var3 = (JsonNodeBuilder)var2.next();
         var1.add(var3.func_27234_b());
      }

      return JsonNodeFactories.func_27309_a(var1);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public JsonNode func_27234_b() {
      return this.func_27241_a();
   }
}
