package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderFlat;
import net.minecraft.src.ChunkProviderGenerate;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldProviderEnd;
import net.minecraft.src.WorldProviderHell;
import net.minecraft.src.WorldProviderSurface;
import net.minecraft.src.WorldType;

public abstract class WorldProvider {

   public World field_4216_a;
   public WorldType field_46067_b;
   public WorldChunkManager field_4215_b;
   public boolean field_6479_d = false;
   public boolean field_6478_e = false;
   public float[] field_4219_d = new float[16];
   public int field_4218_e = 0;
   private float[] field_4217_f = new float[4];


   public final void func_4095_a(World p_4095_1_) {
      this.field_4216_a = p_4095_1_;
      this.field_46067_b = p_4095_1_.func_22144_v().func_46133_t();
      this.func_4098_a();
      this.func_4093_b();
   }

   protected void func_4093_b() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_4219_d[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   protected void func_4098_a() {
      if(this.field_4216_a.func_22144_v().func_46133_t() == WorldType.field_48636_c) {
         this.field_4215_b = new WorldChunkManagerHell(BiomeGenBase.field_35485_c, 0.5F, 0.5F);
      } else {
         this.field_4215_b = new WorldChunkManager(this.field_4216_a);
      }

   }

   public IChunkProvider func_4094_c() {
      return (IChunkProvider)(this.field_46067_b == WorldType.field_48636_c?new ChunkProviderFlat(this.field_4216_a, this.field_4216_a.func_22138_q(), this.field_4216_a.func_22144_v().func_35917_r()):new ChunkProviderGenerate(this.field_4216_a, this.field_4216_a.func_22138_q(), this.field_4216_a.func_22144_v().func_35917_r()));
   }

   public boolean func_4102_a(int p_4102_1_, int p_4102_2_) {
      int var3 = this.field_4216_a.func_614_g(p_4102_1_, p_4102_2_);
      return var3 == Block.field_337_v.field_376_bc;
   }

   public float func_4100_a(long p_4100_1_, float p_4100_3_) {
      int var4 = (int)(p_4100_1_ % 24000L);
      float var5 = ((float)var4 + p_4100_3_) / 24000.0F - 0.25F;
      if(var5 < 0.0F) {
         ++var5;
      }

      if(var5 > 1.0F) {
         --var5;
      }

      float var6 = var5;
      var5 = 1.0F - (float)((Math.cos((double)var5 * 3.141592653589793D) + 1.0D) / 2.0D);
      var5 = var6 + (var5 - var6) / 3.0F;
      return var5;
   }

   public int func_40470_b(long p_40470_1_, float p_40470_3_) {
      return (int)(p_40470_1_ / 24000L) % 8;
   }

   public boolean func_48217_e() {
      return true;
   }

   public float[] func_4097_b(float p_4097_1_, float p_4097_2_) {
      float var3 = 0.4F;
      float var4 = MathHelper.func_1114_b(p_4097_1_ * 3.1415927F * 2.0F) - 0.0F;
      float var5 = -0.0F;
      if(var4 >= var5 - var3 && var4 <= var5 + var3) {
         float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
         float var7 = 1.0F - (1.0F - MathHelper.func_1106_a(var6 * 3.1415927F)) * 0.99F;
         var7 *= var7;
         this.field_4217_f[0] = var6 * 0.3F + 0.7F;
         this.field_4217_f[1] = var6 * var6 * 0.7F + 0.2F;
         this.field_4217_f[2] = var6 * var6 * 0.0F + 0.2F;
         this.field_4217_f[3] = var7;
         return this.field_4217_f;
      } else {
         return null;
      }
   }

   public Vec3D func_4096_a(float p_4096_1_, float p_4096_2_) {
      float var3 = MathHelper.func_1114_b(p_4096_1_ * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = 0.7529412F;
      float var5 = 0.84705883F;
      float var6 = 1.0F;
      var4 *= var3 * 0.94F + 0.06F;
      var5 *= var3 * 0.94F + 0.06F;
      var6 *= var3 * 0.91F + 0.09F;
      return Vec3D.func_1248_b((double)var4, (double)var5, (double)var6);
   }

   public boolean func_6477_d() {
      return true;
   }

   public static WorldProvider func_4101_a(int p_4101_0_) {
      return (WorldProvider)(p_4101_0_ == -1?new WorldProviderHell():(p_4101_0_ == 0?new WorldProviderSurface():(p_4101_0_ == 1?new WorldProviderEnd():null)));
   }

   public float func_28111_d() {
      return 128.0F;
   }

   public boolean func_28112_c() {
      return true;
   }

   public ChunkCoordinates func_40469_f() {
      return null;
   }

   public int func_46066_g() {
      return this.field_46067_b == WorldType.field_48636_c?4:64;
   }

   public boolean func_46064_i() {
      return this.field_46067_b != WorldType.field_48636_c && !this.field_6478_e;
   }

   public double func_46065_j() {
      return this.field_46067_b == WorldType.field_48636_c?1.0D:0.03125D;
   }

   public boolean func_48218_b(int p_48218_1_, int p_48218_2_) {
      return false;
   }
}
