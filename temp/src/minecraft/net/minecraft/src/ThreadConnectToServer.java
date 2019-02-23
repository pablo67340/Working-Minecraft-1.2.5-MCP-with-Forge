package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiDisconnected;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet2Handshake;

class ThreadConnectToServer extends Thread {

   // $FF: synthetic field
   final Minecraft field_1102_a;
   // $FF: synthetic field
   final String field_48479_b;
   // $FF: synthetic field
   final int field_1104_c;
   // $FF: synthetic field
   final GuiConnecting field_1103_d;


   ThreadConnectToServer(GuiConnecting p_i190_1_, Minecraft p_i190_2_, String p_i190_3_, int p_i190_4_) {
      this.field_1103_d = p_i190_1_;
      this.field_1102_a = p_i190_2_;
      this.field_48479_b = p_i190_3_;
      this.field_1104_c = p_i190_4_;
   }

   public void run() {
      try {
         GuiConnecting.func_582_a(this.field_1103_d, new NetClientHandler(this.field_1102_a, this.field_48479_b, this.field_1104_c));
         if(GuiConnecting.func_581_a(this.field_1103_d)) {
            return;
         }

         GuiConnecting.func_583_b(this.field_1103_d).func_847_a(new Packet2Handshake(this.field_1102_a.field_6320_i.field_1666_b, this.field_48479_b, this.field_1104_c));
      } catch (UnknownHostException var2) {
         if(GuiConnecting.func_581_a(this.field_1103_d)) {
            return;
         }

         this.field_1102_a.func_6272_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[]{"Unknown host \'" + this.field_48479_b + "\'"}));
      } catch (ConnectException var3) {
         if(GuiConnecting.func_581_a(this.field_1103_d)) {
            return;
         }

         this.field_1102_a.func_6272_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[]{var3.getMessage()}));
      } catch (Exception var4) {
         if(GuiConnecting.func_581_a(this.field_1103_d)) {
            return;
         }

         var4.printStackTrace();
         this.field_1102_a.func_6272_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[]{var4.toString()}));
      }

   }
}
