package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet15Place extends Packet {

   public int field_566_a;
   public int field_565_b;
   public int field_569_c;
   public int field_568_d;
   public ItemStack field_567_e;


   public Packet15Place() {}

   public Packet15Place(int p_i316_1_, int p_i316_2_, int p_i316_3_, int p_i316_4_, ItemStack p_i316_5_) {
      this.field_566_a = p_i316_1_;
      this.field_565_b = p_i316_2_;
      this.field_569_c = p_i316_3_;
      this.field_568_d = p_i316_4_;
      this.field_567_e = p_i316_5_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_566_a = p_327_1_.readInt();
      this.field_565_b = p_327_1_.read();
      this.field_569_c = p_327_1_.readInt();
      this.field_568_d = p_327_1_.read();
      this.field_567_e = this.func_40187_b(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_566_a);
      p_322_1_.write(this.field_565_b);
      p_322_1_.writeInt(this.field_569_c);
      p_322_1_.write(this.field_568_d);
      this.func_40188_a(this.field_567_e, p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_819_a(this);
   }

   public int func_329_a() {
      return 15;
   }
}
