package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet28EntityVelocity extends Packet {

   public int field_6367_a;
   public int field_6366_b;
   public int field_6369_c;
   public int field_6368_d;


   public Packet28EntityVelocity() {}

   public Packet28EntityVelocity(Entity p_i699_1_) {
      this(p_i699_1_.field_620_ab, p_i699_1_.field_608_an, p_i699_1_.field_607_ao, p_i699_1_.field_606_ap);
   }

   public Packet28EntityVelocity(int p_i700_1_, double p_i700_2_, double p_i700_4_, double p_i700_6_) {
      this.field_6367_a = p_i700_1_;
      double var8 = 3.9D;
      if(p_i700_2_ < -var8) {
         p_i700_2_ = -var8;
      }

      if(p_i700_4_ < -var8) {
         p_i700_4_ = -var8;
      }

      if(p_i700_6_ < -var8) {
         p_i700_6_ = -var8;
      }

      if(p_i700_2_ > var8) {
         p_i700_2_ = var8;
      }

      if(p_i700_4_ > var8) {
         p_i700_4_ = var8;
      }

      if(p_i700_6_ > var8) {
         p_i700_6_ = var8;
      }

      this.field_6366_b = (int)(p_i700_2_ * 8000.0D);
      this.field_6369_c = (int)(p_i700_4_ * 8000.0D);
      this.field_6368_d = (int)(p_i700_6_ * 8000.0D);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_6367_a = p_327_1_.readInt();
      this.field_6366_b = p_327_1_.readShort();
      this.field_6369_c = p_327_1_.readShort();
      this.field_6368_d = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_6367_a);
      p_322_1_.writeShort(this.field_6366_b);
      p_322_1_.writeShort(this.field_6369_c);
      p_322_1_.writeShort(this.field_6368_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_6498_a(this);
   }

   public int func_329_a() {
      return 10;
   }
}
