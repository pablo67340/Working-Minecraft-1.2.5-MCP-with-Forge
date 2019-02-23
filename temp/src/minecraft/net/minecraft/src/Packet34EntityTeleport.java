package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet34EntityTeleport extends Packet {

   public int field_509_a;
   public int field_508_b;
   public int field_513_c;
   public int field_512_d;
   public byte field_511_e;
   public byte field_510_f;


   public Packet34EntityTeleport() {}

   public Packet34EntityTeleport(Entity p_i464_1_) {
      this.field_509_a = p_i464_1_.field_620_ab;
      this.field_508_b = MathHelper.func_1108_b(p_i464_1_.field_611_ak * 32.0D);
      this.field_513_c = MathHelper.func_1108_b(p_i464_1_.field_610_al * 32.0D);
      this.field_512_d = MathHelper.func_1108_b(p_i464_1_.field_609_am * 32.0D);
      this.field_511_e = (byte)((int)(p_i464_1_.field_605_aq * 256.0F / 360.0F));
      this.field_510_f = (byte)((int)(p_i464_1_.field_604_ar * 256.0F / 360.0F));
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_509_a = p_327_1_.readInt();
      this.field_508_b = p_327_1_.readInt();
      this.field_513_c = p_327_1_.readInt();
      this.field_512_d = p_327_1_.readInt();
      this.field_511_e = (byte)p_327_1_.read();
      this.field_510_f = (byte)p_327_1_.read();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_509_a);
      p_322_1_.writeInt(this.field_508_b);
      p_322_1_.writeInt(this.field_513_c);
      p_322_1_.writeInt(this.field_512_d);
      p_322_1_.write(this.field_511_e);
      p_322_1_.write(this.field_510_f);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_829_a(this);
   }

   public int func_329_a() {
      return 34;
   }
}
