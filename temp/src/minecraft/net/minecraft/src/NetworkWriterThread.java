package net.minecraft.src;

import java.io.IOException;
import net.minecraft.src.NetworkManager;

class NetworkWriterThread extends Thread {

   // $FF: synthetic field
   final NetworkManager field_1063_a;


   NetworkWriterThread(NetworkManager p_i574_1_, String p_i574_2_) {
      super(p_i574_2_);
      this.field_1063_a = p_i574_1_;
   }

   public void run() {
      Object var1 = NetworkManager.field_1478_a;
      synchronized(NetworkManager.field_1478_a) {
         ++NetworkManager.field_1476_c;
      }

      while(true) {
         boolean var13 = false;

         try {
            var13 = true;
            if(!NetworkManager.func_971_a(this.field_1063_a)) {
               var13 = false;
               break;
            }

            while(NetworkManager.func_965_d(this.field_1063_a)) {
               ;
            }

            try {
               if(NetworkManager.func_28140_f(this.field_1063_a) != null) {
                  NetworkManager.func_28140_f(this.field_1063_a).flush();
               }
            } catch (IOException var18) {
               if(!NetworkManager.func_28138_e(this.field_1063_a)) {
                  NetworkManager.func_30005_a(this.field_1063_a, var18);
               }

               var18.printStackTrace();
            }

            try {
               sleep(2L);
            } catch (InterruptedException var16) {
               ;
            }
         } finally {
            if(var13) {
               Object var5 = NetworkManager.field_1478_a;
               synchronized(NetworkManager.field_1478_a) {
                  --NetworkManager.field_1476_c;
               }
            }
         }
      }

      var1 = NetworkManager.field_1478_a;
      synchronized(NetworkManager.field_1478_a) {
         --NetworkManager.field_1476_c;
      }
   }
}
