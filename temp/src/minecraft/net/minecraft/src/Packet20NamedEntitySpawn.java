package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet20NamedEntitySpawn extends Packet {

   public int field_534_a;
   public String field_533_b;
   public int field_540_c;
   public int field_539_d;
   public int field_538_e;
   public byte field_537_f;
   public byte field_536_g;
   public int field_535_h;


   public Packet20NamedEntitySpawn() {}

   public Packet20NamedEntitySpawn(EntityPlayer p_i382_1_) {
      this.field_534_a = p_i382_1_.field_620_ab;
      this.field_533_b = p_i382_1_.field_771_i;
      this.field_540_c = MathHelper.func_1108_b(p_i382_1_.field_611_ak * 32.0D);
      this.field_539_d = MathHelper.func_1108_b(p_i382_1_.field_610_al * 32.0D);
      this.field_538_e = MathHelper.func_1108_b(p_i382_1_.field_609_am * 32.0D);
      this.field_537_f = (byte)((int)(p_i382_1_.field_605_aq * 256.0F / 360.0F));
      this.field_536_g = (byte)((int)(p_i382_1_.field_604_ar * 256.0F / 360.0F));
      ItemStack var2 = p_i382_1_.field_778_b.func_494_a();
      this.field_535_h = var2 == null?0:var2.field_1617_c;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_534_a = p_327_1_.readInt();
      this.field_533_b = func_27048_a(p_327_1_, 16);
      this.field_540_c = p_327_1_.readInt();
      this.field_539_d = p_327_1_.readInt();
      this.field_538_e = p_327_1_.readInt();
      this.field_537_f = p_327_1_.readByte();
      this.field_536_g = p_327_1_.readByte();
      this.field_535_h = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_534_a);
      func_27049_a(this.field_533_b, p_322_1_);
      p_322_1_.writeInt(this.field_540_c);
      p_322_1_.writeInt(this.field_539_d);
      p_322_1_.writeInt(this.field_538_e);
      p_322_1_.writeByte(this.field_537_f);
      p_322_1_.writeByte(this.field_536_g);
      p_322_1_.writeShort(this.field_535_h);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_820_a(this);
   }

   public int func_329_a() {
      return 28;
   }
}
