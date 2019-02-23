package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;

public class PlayerCapabilities {

   public boolean field_35759_a = false;
   public boolean field_35757_b = false;
   public boolean field_35758_c = false;
   public boolean field_35756_d = false;


   public void func_40601_a(NBTTagCompound p_40601_1_) {
      NBTTagCompound var2 = new NBTTagCompound();
      var2.func_748_a("invulnerable", this.field_35759_a);
      var2.func_748_a("flying", this.field_35757_b);
      var2.func_748_a("mayfly", this.field_35758_c);
      var2.func_748_a("instabuild", this.field_35756_d);
      p_40601_1_.func_762_a("abilities", var2);
   }

   public void func_40600_b(NBTTagCompound p_40600_1_) {
      if(p_40600_1_.func_751_b("abilities")) {
         NBTTagCompound var2 = p_40600_1_.func_743_k("abilities");
         this.field_35759_a = var2.func_760_m("invulnerable");
         this.field_35757_b = var2.func_760_m("flying");
         this.field_35758_c = var2.func_760_m("mayfly");
         this.field_35756_d = var2.func_760_m("instabuild");
      }

   }
}
