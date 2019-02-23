package argo.jdom;

import argo.jdom.JsonArrayNodeBuilder;
import argo.jdom.JsonFieldBuilder;
import argo.jdom.JsonListenerToJdomAdapter_Array;
import argo.jdom.JsonListenerToJdomAdapter_Field;
import argo.jdom.JsonListenerToJdomAdapter_NodeContainer;
import argo.jdom.JsonListenerToJdomAdapter_Object;
import argo.jdom.JsonNodeBuilder;
import argo.jdom.JsonNodeBuilders;
import argo.jdom.JsonObjectNodeBuilder;
import argo.jdom.JsonRootNode;
import argo.saj.JsonListener;
import java.util.Stack;

final class JsonListenerToJdomAdapter implements JsonListener {

   private final Stack field_27210_a = new Stack();
   private JsonNodeBuilder field_27209_b;


   JsonRootNode func_27208_a() {
      return (JsonRootNode)this.field_27209_b.func_27234_b();
   }

   public void func_27195_b() {}

   public void func_27204_c() {}

   public void func_27200_d() {
      JsonArrayNodeBuilder var1 = JsonNodeBuilders.func_27249_e();
      this.func_27207_a(var1);
      this.field_27210_a.push(new JsonListenerToJdomAdapter_Array(this, var1));
   }

   public void func_27197_e() {
      this.field_27210_a.pop();
   }

   public void func_27194_f() {
      JsonObjectNodeBuilder var1 = JsonNodeBuilders.func_27253_d();
      this.func_27207_a(var1);
      this.field_27210_a.push(new JsonListenerToJdomAdapter_Object(this, var1));
   }

   public void func_27203_g() {
      this.field_27210_a.pop();
   }

   public void func_27205_a(String p_27205_1_) {
      JsonFieldBuilder var2 = JsonFieldBuilder.func_27301_a().func_27304_a(JsonNodeBuilders.func_27254_b(p_27205_1_));
      ((JsonListenerToJdomAdapter_NodeContainer)this.field_27210_a.peek()).func_27289_a(var2);
      this.field_27210_a.push(new JsonListenerToJdomAdapter_Field(this, var2));
   }

   public void func_27199_h() {
      this.field_27210_a.pop();
   }

   public void func_27201_b(String p_27201_1_) {
      this.func_27206_b(JsonNodeBuilders.func_27250_a(p_27201_1_));
   }

   public void func_27196_i() {
      this.func_27206_b(JsonNodeBuilders.func_27251_b());
   }

   public void func_27198_c(String p_27198_1_) {
      this.func_27206_b(JsonNodeBuilders.func_27254_b(p_27198_1_));
   }

   public void func_27193_j() {
      this.func_27206_b(JsonNodeBuilders.func_27252_c());
   }

   public void func_27202_k() {
      this.func_27206_b(JsonNodeBuilders.func_27248_a());
   }

   private void func_27207_a(JsonNodeBuilder p_27207_1_) {
      if(this.field_27209_b == null) {
         this.field_27209_b = p_27207_1_;
      } else {
         this.func_27206_b(p_27207_1_);
      }

   }

   private void func_27206_b(JsonNodeBuilder p_27206_1_) {
      ((JsonListenerToJdomAdapter_NodeContainer)this.field_27210_a.peek()).func_27290_a(p_27206_1_);
   }
}
