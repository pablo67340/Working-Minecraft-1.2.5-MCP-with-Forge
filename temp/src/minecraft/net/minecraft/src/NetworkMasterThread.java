package net.minecraft.src;

import net.minecraft.src.NetworkManager;

class NetworkMasterThread extends Thread {

   // $FF: synthetic field
   final NetworkManager field_1086_a;


   NetworkMasterThread(NetworkManager p_i570_1_) {
      this.field_1086_a = p_i570_1_;
   }

   public void run() {
      try {
         Thread.sleep(5000L);
         if(NetworkManager.func_969_e(this.field_1086_a).isAlive()) {
            try {
               NetworkManager.func_969_e(this.field_1086_a).stop();
            } catch (Throwable var3) {
               ;
            }
         }

         if(NetworkManager.func_963_f(this.field_1086_a).isAlive()) {
            try {
               NetworkManager.func_963_f(this.field_1086_a).stop();
            } catch (Throwable var2) {
               ;
            }
         }
      } catch (InterruptedException var4) {
         var4.printStackTrace();
      }

   }
}
