package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;
import net.minecraft.src.PlayerCapabilities;

public class Packet202PlayerAbilities extends Packet {

   public boolean field_50072_a = false;
   public boolean field_50070_b = false;
   public boolean field_50071_c = false;
   public boolean field_50069_d = false;


   public Packet202PlayerAbilities() {}

   public Packet202PlayerAbilities(PlayerCapabilities p_i1208_1_) {
      this.field_50072_a = p_i1208_1_.field_35759_a;
      this.field_50070_b = p_i1208_1_.field_35757_b;
      this.field_50071_c = p_i1208_1_.field_35758_c;
      this.field_50069_d = p_i1208_1_.field_35756_d;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_50072_a = p_327_1_.readBoolean();
      this.field_50070_b = p_327_1_.readBoolean();
      this.field_50071_c = p_327_1_.readBoolean();
      this.field_50069_d = p_327_1_.readBoolean();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeBoolean(this.field_50072_a);
      p_322_1_.writeBoolean(this.field_50070_b);
      p_322_1_.writeBoolean(this.field_50071_c);
      p_322_1_.writeBoolean(this.field_50069_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_50100_a(this);
   }

   public int func_329_a() {
      return 1;
   }
}
