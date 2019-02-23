package argo.jdom;

import argo.jdom.JsonNode;
import java.util.ArrayList;
import java.util.Iterator;

final class JsonArray_NodeList extends ArrayList {

   // $FF: synthetic field
   final Iterable field_27405_a;


   JsonArray_NodeList(Iterable p_i660_1_) {
      this.field_27405_a = p_i660_1_;
      Iterator var2 = this.field_27405_a.iterator();

      while(var2.hasNext()) {
         JsonNode var3 = (JsonNode)var2.next();
         this.add(var3);
      }

   }
}
