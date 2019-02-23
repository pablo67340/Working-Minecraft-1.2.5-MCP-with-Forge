package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet71Weather extends Packet {

   public int field_27054_a;
   public int field_27053_b;
   public int field_27057_c;
   public int field_27056_d;
   public int field_27055_e;


   public Packet71Weather() {}

   public Packet71Weather(Entity p_i670_1_) {
      this.field_27054_a = p_i670_1_.field_620_ab;
      this.field_27053_b = MathHelper.func_1108_b(p_i670_1_.field_611_ak * 32.0D);
      this.field_27057_c = MathHelper.func_1108_b(p_i670_1_.field_610_al * 32.0D);
      this.field_27056_d = MathHelper.func_1108_b(p_i670_1_.field_609_am * 32.0D);
      if(p_i670_1_ instanceof EntityLightningBolt) {
         this.field_27055_e = 1;
      }

   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_27054_a = p_327_1_.readInt();
      this.field_27055_e = p_327_1_.readByte();
      this.field_27053_b = p_327_1_.readInt();
      this.field_27057_c = p_327_1_.readInt();
      this.field_27056_d = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_27054_a);
      p_322_1_.writeByte(this.field_27055_e);
      p_322_1_.writeInt(this.field_27053_b);
      p_322_1_.writeInt(this.field_27057_c);
      p_322_1_.writeInt(this.field_27056_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_27246_a(this);
   }

   public int func_329_a() {
      return 17;
   }
}
