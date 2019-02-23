package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderEnd;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldProvider;

public class WorldProviderEnd extends WorldProvider {

   public void func_4098_a() {
      this.field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_28057_m, 0.5F, 0.0F);
      this.field_4218_e = 1;
      this.field_6478_e = true;
   }

   public IChunkProvider func_4094_c() {
      return new ChunkProviderEnd(this.field_4216_a, this.field_4216_a.func_22138_q());
   }

   public float func_4100_a(long p_4100_1_, float p_4100_3_) {
      return 0.0F;
   }

   public float[] func_4097_b(float p_4097_1_, float p_4097_2_) {
      return null;
   }

   public Vec3D func_4096_a(float p_4096_1_, float p_4096_2_) {
      int var3 = 8421536;
      float var4 = MathHelper.func_1114_b(p_4096_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      float var5 = (float)(var3 >> 16 & 255) / 255.0F;
      float var6 = (float)(var3 >> 8 & 255) / 255.0F;
      float var7 = (float)(var3 & 255) / 255.0F;
      var5 *= var4 * 0.0F + 0.15F;
      var6 *= var4 * 0.0F + 0.15F;
      var7 *= var4 * 0.0F + 0.15F;
      return Vec3D.func_1248_b((double)var5, (double)var6, (double)var7);
   }

   public boolean func_28112_c() {
      return false;
   }

   public boolean func_6477_d() {
      return false;
   }

   public boolean func_48217_e() {
      return false;
   }

   public float func_28111_d() {
      return 8.0F;
   }

   public boolean func_4102_a(int p_4102_1_, int p_4102_2_) {
      int var3 = this.field_4216_a.func_614_g(p_4102_1_, p_4102_2_);
      return var3 == 0?false:Block.field_345_n[var3].field_356_bn.func_880_c();
   }

   public ChunkCoordinates func_40469_f() {
      return new ChunkCoordinates(100, 50, 0);
   }

   public int func_46066_g() {
      return 50;
   }

   public boolean func_48218_b(int p_48218_1_, int p_48218_2_) {
      return true;
   }
}
