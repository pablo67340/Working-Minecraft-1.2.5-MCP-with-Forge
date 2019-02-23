package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet40EntityMetadata extends Packet {

   public int field_21049_a;
   private List field_21048_b;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_21049_a = p_327_1_.readInt();
      this.field_21048_b = DataWatcher.func_21131_a(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_21049_a);
      DataWatcher.func_21125_a(this.field_21048_b, p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_21148_a(this);
   }

   public int func_329_a() {
      return 5;
   }

   public List func_21047_b() {
      return this.field_21048_b;
   }
}
