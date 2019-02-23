package net.minecraft.src;

import net.minecraft.src.NetworkManager;

class ThreadMonitorConnection extends Thread {

   // $FF: synthetic field
   final NetworkManager field_28109_a;


   ThreadMonitorConnection(NetworkManager p_i571_1_) {
      this.field_28109_a = p_i571_1_;
   }

   public void run() {
      try {
         Thread.sleep(2000L);
         if(NetworkManager.func_971_a(this.field_28109_a)) {
            NetworkManager.func_963_f(this.field_28109_a).interrupt();
            this.field_28109_a.func_974_a("disconnect.closed", new Object[0]);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }
}
