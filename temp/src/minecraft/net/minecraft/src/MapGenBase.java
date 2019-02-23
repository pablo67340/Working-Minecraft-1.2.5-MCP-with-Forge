package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;

public class MapGenBase {

   protected int field_1306_a = 8;
   protected Random field_1305_b = new Random();
   protected World field_35625_d;


   public void func_867_a(IChunkProvider p_867_1_, World p_867_2_, int p_867_3_, int p_867_4_, byte[] p_867_5_) {
      int var6 = this.field_1306_a;
      this.field_35625_d = p_867_2_;
      this.field_1305_b.setSeed(p_867_2_.func_22138_q());
      long var7 = this.field_1305_b.nextLong();
      long var9 = this.field_1305_b.nextLong();

      for(int var11 = p_867_3_ - var6; var11 <= p_867_3_ + var6; ++var11) {
         for(int var12 = p_867_4_ - var6; var12 <= p_867_4_ + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.field_1305_b.setSeed(var13 ^ var15 ^ p_867_2_.func_22138_q());
            this.func_868_a(p_867_2_, var11, var12, p_867_3_, p_867_4_, p_867_5_);
         }
      }

   }

   protected void func_868_a(World p_868_1_, int p_868_2_, int p_868_3_, int p_868_4_, int p_868_5_, byte[] p_868_6_) {}
}
