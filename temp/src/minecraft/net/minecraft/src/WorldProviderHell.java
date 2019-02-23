package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkProviderHell;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Vec3D;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldProvider;

public class WorldProviderHell extends WorldProvider {

   public void func_4098_a() {
      this.field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_4245_l, 1.0F, 0.0F);
      this.field_6479_d = true;
      this.field_6478_e = true;
      this.field_4218_e = -1;
   }

   public Vec3D func_4096_a(float p_4096_1_, float p_4096_2_) {
      return Vec3D.func_1248_b(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
   }

   protected void func_4093_b() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_4219_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public IChunkProvider func_4094_c() {
      return new ChunkProviderHell(this.field_4216_a, this.field_4216_a.func_22138_q());
   }

   public boolean func_48217_e() {
      return false;
   }

   public boolean func_4102_a(int p_4102_1_, int p_4102_2_) {
      return false;
   }

   public float func_4100_a(long p_4100_1_, float p_4100_3_) {
      return 0.5F;
   }

   public boolean func_6477_d() {
      return false;
   }

   public boolean func_48218_b(int p_48218_1_, int p_48218_2_) {
      return true;
   }
}
