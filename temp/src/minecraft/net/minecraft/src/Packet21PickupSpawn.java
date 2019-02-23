package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityItem;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet21PickupSpawn extends Packet {

   public int field_531_a;
   public int field_530_b;
   public int field_529_c;
   public int field_528_d;
   public byte field_527_e;
   public byte field_526_f;
   public byte field_525_g;
   public int field_524_h;
   public int field_523_i;
   public int field_21052_l;


   public Packet21PickupSpawn() {}

   public Packet21PickupSpawn(EntityItem p_i398_1_) {
      this.field_531_a = p_i398_1_.field_620_ab;
      this.field_524_h = p_i398_1_.field_801_a.field_1617_c;
      this.field_523_i = p_i398_1_.field_801_a.field_1615_a;
      this.field_21052_l = p_i398_1_.field_801_a.func_21181_i();
      this.field_530_b = MathHelper.func_1108_b(p_i398_1_.field_611_ak * 32.0D);
      this.field_529_c = MathHelper.func_1108_b(p_i398_1_.field_610_al * 32.0D);
      this.field_528_d = MathHelper.func_1108_b(p_i398_1_.field_609_am * 32.0D);
      this.field_527_e = (byte)((int)(p_i398_1_.field_608_an * 128.0D));
      this.field_526_f = (byte)((int)(p_i398_1_.field_607_ao * 128.0D));
      this.field_525_g = (byte)((int)(p_i398_1_.field_606_ap * 128.0D));
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_531_a = p_327_1_.readInt();
      this.field_524_h = p_327_1_.readShort();
      this.field_523_i = p_327_1_.readByte();
      this.field_21052_l = p_327_1_.readShort();
      this.field_530_b = p_327_1_.readInt();
      this.field_529_c = p_327_1_.readInt();
      this.field_528_d = p_327_1_.readInt();
      this.field_527_e = p_327_1_.readByte();
      this.field_526_f = p_327_1_.readByte();
      this.field_525_g = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_531_a);
      p_322_1_.writeShort(this.field_524_h);
      p_322_1_.writeByte(this.field_523_i);
      p_322_1_.writeShort(this.field_21052_l);
      p_322_1_.writeInt(this.field_530_b);
      p_322_1_.writeInt(this.field_529_c);
      p_322_1_.writeInt(this.field_528_d);
      p_322_1_.writeByte(this.field_527_e);
      p_322_1_.writeByte(this.field_526_f);
      p_322_1_.writeByte(this.field_525_g);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_832_a(this);
   }

   public int func_329_a() {
      return 24;
   }
}
