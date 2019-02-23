package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet26EntityExpOrb extends Packet {

   public int field_35241_a;
   public int field_35239_b;
   public int field_35240_c;
   public int field_35237_d;
   public int field_35238_e;


   public Packet26EntityExpOrb() {}

   public Packet26EntityExpOrb(EntityXPOrb p_i433_1_) {
      this.field_35241_a = p_i433_1_.field_620_ab;
      this.field_35239_b = MathHelper.func_1108_b(p_i433_1_.field_611_ak * 32.0D);
      this.field_35240_c = MathHelper.func_1108_b(p_i433_1_.field_610_al * 32.0D);
      this.field_35237_d = MathHelper.func_1108_b(p_i433_1_.field_609_am * 32.0D);
      this.field_35238_e = p_i433_1_.func_35119_j_();
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35241_a = p_327_1_.readInt();
      this.field_35239_b = p_327_1_.readInt();
      this.field_35240_c = p_327_1_.readInt();
      this.field_35237_d = p_327_1_.readInt();
      this.field_35238_e = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_35241_a);
      p_322_1_.writeInt(this.field_35239_b);
      p_322_1_.writeInt(this.field_35240_c);
      p_322_1_.writeInt(this.field_35237_d);
      p_322_1_.writeShort(this.field_35238_e);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_35778_a(this);
   }

   public int func_329_a() {
      return 18;
   }
}
