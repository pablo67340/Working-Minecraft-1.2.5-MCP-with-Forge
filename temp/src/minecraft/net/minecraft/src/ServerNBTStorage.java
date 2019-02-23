package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;

public class ServerNBTStorage {

   public String field_35795_a;
   public String field_35793_b;
   public String field_35794_c;
   public String field_35791_d;
   public long field_35792_e;
   public boolean field_35790_f = false;


   public ServerNBTStorage(String p_i489_1_, String p_i489_2_) {
      this.field_35795_a = p_i489_1_;
      this.field_35793_b = p_i489_2_;
   }

   public NBTTagCompound func_35789_a() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.func_754_a("name", this.field_35795_a);
      var1.func_754_a("ip", this.field_35793_b);
      return var1;
   }

   public static ServerNBTStorage func_35788_a(NBTTagCompound p_35788_0_) {
      return new ServerNBTStorage(p_35788_0_.func_755_i("name"), p_35788_0_.func_755_i("ip"));
   }
}
