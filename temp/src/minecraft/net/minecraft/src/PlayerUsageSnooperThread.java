package net.minecraft.src;

import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.PostHttp;

class PlayerUsageSnooperThread extends Thread {

   // $FF: synthetic field
   final PlayerUsageSnooper field_52012_a;


   PlayerUsageSnooperThread(PlayerUsageSnooper p_i1050_1_, String p_i1050_2_) {
      super(p_i1050_2_);
      this.field_52012_a = p_i1050_1_;
   }

   public void run() {
      PostHttp.func_52018_a(PlayerUsageSnooper.func_52023_a(this.field_52012_a), PlayerUsageSnooper.func_52020_b(this.field_52012_a), true);
   }
}
