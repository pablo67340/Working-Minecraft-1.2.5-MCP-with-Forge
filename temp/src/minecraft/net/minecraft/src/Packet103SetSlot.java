package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet103SetSlot extends Packet {

   public int field_20042_a;
   public int field_20041_b;
   public ItemStack field_20043_c;


   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20088_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20042_a = p_327_1_.readByte();
      this.field_20041_b = p_327_1_.readShort();
      this.field_20043_c = this.func_40187_b(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20042_a);
      p_322_1_.writeShort(this.field_20041_b);
      this.func_40188_a(this.field_20043_c, p_322_1_);
   }

   public int func_329_a() {
      return 8;
   }
}
