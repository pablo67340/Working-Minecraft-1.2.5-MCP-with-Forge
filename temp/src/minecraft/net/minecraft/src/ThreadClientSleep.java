package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadClientSleep extends Thread {

   // $FF: synthetic field
   final Minecraft field_1588_a;


   public ThreadClientSleep(Minecraft p_i356_1_, String p_i356_2_) {
      super(p_i356_2_);
      this.field_1588_a = p_i356_1_;
      this.setDaemon(true);
      this.start();
   }

   public void run() {
      while(this.field_1588_a.field_6293_H) {
         try {
            Thread.sleep(2147483647L);
         } catch (InterruptedException var2) {
            ;
         }
      }

   }
}
