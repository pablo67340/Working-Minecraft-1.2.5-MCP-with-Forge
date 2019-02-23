package net.minecraft.src;

import net.minecraft.src.NetworkManager;

class NetworkReaderThread extends Thread {

   // $FF: synthetic field
   final NetworkManager field_1085_a;


   NetworkReaderThread(NetworkManager p_i573_1_, String p_i573_2_) {
      super(p_i573_2_);
      this.field_1085_a = p_i573_1_;
   }

   public void run() {
      Object var1 = NetworkManager.field_1478_a;
      synchronized(NetworkManager.field_1478_a) {
         ++NetworkManager.field_1477_b;
      }

      while(true) {
         boolean var12 = false;

         try {
            var12 = true;
            if(!NetworkManager.func_971_a(this.field_1085_a)) {
               var12 = false;
               break;
            }

            if(NetworkManager.func_968_b(this.field_1085_a)) {
               var12 = false;
               break;
            }

            while(NetworkManager.func_966_c(this.field_1085_a)) {
               ;
            }

            try {
               sleep(2L);
            } catch (InterruptedException var15) {
               ;
            }
         } finally {
            if(var12) {
               Object var5 = NetworkManager.field_1478_a;
               synchronized(NetworkManager.field_1478_a) {
                  --NetworkManager.field_1477_b;
               }
            }
         }
      }

      var1 = NetworkManager.field_1478_a;
      synchronized(NetworkManager.field_1478_a) {
         --NetworkManager.field_1477_b;
      }
   }
}
