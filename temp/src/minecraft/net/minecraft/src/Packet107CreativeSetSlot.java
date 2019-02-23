package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet107CreativeSetSlot extends Packet {

   public int field_35236_a;
   public ItemStack field_40190_b;


   public Packet107CreativeSetSlot() {}

   public Packet107CreativeSetSlot(int p_i279_1_, ItemStack p_i279_2_) {
      this.field_35236_a = p_i279_1_;
      this.field_40190_b = p_i279_2_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_35781_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35236_a = p_327_1_.readShort();
      this.field_40190_b = this.func_40187_b(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeShort(this.field_35236_a);
      this.func_40188_a(this.field_40190_b, p_322_1_);
   }

   public int func_329_a() {
      return 8;
   }
}
