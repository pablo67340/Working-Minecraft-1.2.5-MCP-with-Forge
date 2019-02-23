package net.minecraft.src;

import net.minecraft.src.CanvasIsomPreview;

class ThreadRunIsoClient extends Thread {

   // $FF: synthetic field
   final CanvasIsomPreview field_1197_a;


   ThreadRunIsoClient(CanvasIsomPreview p_i495_1_) {
      this.field_1197_a = p_i495_1_;
   }

   public void run() {
      while(CanvasIsomPreview.func_1271_a(this.field_1197_a)) {
         this.field_1197_a.func_1265_d();

         try {
            Thread.sleep(1L);
         } catch (Exception var2) {
            ;
         }
      }

   }
}
