package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet24MobSpawn extends Packet {

   public int field_547_a;
   public int field_546_b;
   public int field_552_c;
   public int field_551_d;
   public int field_550_e;
   public byte field_549_f;
   public byte field_548_g;
   public byte field_48169_h;
   private DataWatcher field_21055_h;
   private List field_21054_i;


   public Packet24MobSpawn() {}

   public Packet24MobSpawn(EntityLiving p_i757_1_) {
      this.field_547_a = p_i757_1_.field_620_ab;
      this.field_546_b = (byte)EntityList.func_1082_a(p_i757_1_);
      this.field_552_c = MathHelper.func_1108_b(p_i757_1_.field_611_ak * 32.0D);
      this.field_551_d = MathHelper.func_1108_b(p_i757_1_.field_610_al * 32.0D);
      this.field_550_e = MathHelper.func_1108_b(p_i757_1_.field_609_am * 32.0D);
      this.field_549_f = (byte)((int)(p_i757_1_.field_605_aq * 256.0F / 360.0F));
      this.field_548_g = (byte)((int)(p_i757_1_.field_604_ar * 256.0F / 360.0F));
      this.field_48169_h = (byte)((int)(p_i757_1_.field_46015_bf * 256.0F / 360.0F));
      this.field_21055_h = p_i757_1_.func_21061_O();
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_547_a = p_327_1_.readInt();
      this.field_546_b = p_327_1_.readByte() & 255;
      this.field_552_c = p_327_1_.readInt();
      this.field_551_d = p_327_1_.readInt();
      this.field_550_e = p_327_1_.readInt();
      this.field_549_f = p_327_1_.readByte();
      this.field_548_g = p_327_1_.readByte();
      this.field_48169_h = p_327_1_.readByte();
      this.field_21054_i = DataWatcher.func_21131_a(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_547_a);
      p_322_1_.writeByte(this.field_546_b & 255);
      p_322_1_.writeInt(this.field_552_c);
      p_322_1_.writeInt(this.field_551_d);
      p_322_1_.writeInt(this.field_550_e);
      p_322_1_.writeByte(this.field_549_f);
      p_322_1_.writeByte(this.field_548_g);
      p_322_1_.writeByte(this.field_48169_h);
      this.field_21055_h.func_21127_a(p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_828_a(this);
   }

   public int func_329_a() {
      return 20;
   }

   public List func_21053_b() {
      return this.field_21054_i;
   }
}
