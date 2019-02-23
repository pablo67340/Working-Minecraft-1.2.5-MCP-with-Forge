package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet104WindowItems extends Packet {

   public int field_20036_a;
   public ItemStack[] field_20035_b;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20036_a = p_327_1_.readByte();
      short var2 = p_327_1_.readShort();
      this.field_20035_b = new ItemStack[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_20035_b[var3] = this.func_40187_b(p_327_1_);
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20036_a);
      p_322_1_.writeShort(this.field_20035_b.length);

      for(int var2 = 0; var2 < this.field_20035_b.length; ++var2) {
         this.func_40188_a(this.field_20035_b[var2], p_322_1_);
      }

   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20094_a(this);
   }

   public int func_329_a() {
      return 3 + this.field_20035_b.length * 5;
   }
}
