package argo.jdom;

import argo.jdom.JsonListenerToJdomAdapter;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import argo.saj.SajParser;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JdomParser {

   public JsonRootNode func_27366_a(Reader p_27366_1_) throws InvalidSyntaxException, IOException {
      JsonListenerToJdomAdapter var2 = new JsonListenerToJdomAdapter();
      (new SajParser()).func_27463_a(p_27366_1_, var2);
      return var2.func_27208_a();
   }

   public JsonRootNode func_27367_a(String p_27367_1_) throws InvalidSyntaxException {
      try {
         JsonRootNode var2 = this.func_27366_a(new StringReader(p_27367_1_));
         return var2;
      } catch (IOException var4) {
         throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", var4);
      }
   }
}
