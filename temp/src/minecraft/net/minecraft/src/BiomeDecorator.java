package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigMushroom;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenClay;
import net.minecraft.src.WorldGenDeadBush;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldGenPumpkin;
import net.minecraft.src.WorldGenReed;
import net.minecraft.src.WorldGenSand;
import net.minecraft.src.WorldGenWaterlily;
import net.minecraft.src.WorldGenerator;

public class BiomeDecorator {

   protected World field_35889_B;
   protected Random field_35890_C;
   protected int field_35885_D;
   protected int field_35886_E;
   protected BiomeGenBase field_35887_F;
   protected WorldGenerator field_35897_a = new WorldGenClay(4);
   protected WorldGenerator field_35895_b;
   protected WorldGenerator field_35896_c;
   protected WorldGenerator field_35893_d;
   protected WorldGenerator field_35894_e;
   protected WorldGenerator field_35891_f;
   protected WorldGenerator field_35892_g;
   protected WorldGenerator field_35904_h;
   protected WorldGenerator field_35905_i;
   protected WorldGenerator field_35902_j;
   protected WorldGenerator field_35903_k;
   protected WorldGenerator field_35900_l;
   protected WorldGenerator field_35901_m;
   protected WorldGenerator field_35898_n;
   protected WorldGenerator field_35899_o;
   protected WorldGenerator field_40720_u;
   protected WorldGenerator field_35913_p;
   protected WorldGenerator field_35912_q;
   protected WorldGenerator field_40722_x;
   protected int field_40721_y;
   protected int field_35911_r;
   protected int field_35910_s;
   protected int field_35909_t;
   protected int field_35908_u;
   protected int field_35907_v;
   protected int field_35906_w;
   protected int field_35916_x;
   protected int field_35915_y;
   protected int field_35914_z;
   protected int field_35888_A;
   protected int field_40718_J;
   public boolean field_40719_K;


   public BiomeDecorator(BiomeGenBase p_i695_1_) {
      this.field_35895_b = new WorldGenSand(7, Block.field_393_F.field_376_bc);
      this.field_35896_c = new WorldGenSand(6, Block.field_392_G.field_376_bc);
      this.field_35893_d = new WorldGenMinable(Block.field_336_w.field_376_bc, 32);
      this.field_35894_e = new WorldGenMinable(Block.field_392_G.field_376_bc, 32);
      this.field_35891_f = new WorldGenMinable(Block.field_386_J.field_376_bc, 16);
      this.field_35892_g = new WorldGenMinable(Block.field_388_I.field_376_bc, 8);
      this.field_35904_h = new WorldGenMinable(Block.field_390_H.field_376_bc, 8);
      this.field_35905_i = new WorldGenMinable(Block.field_433_aO.field_376_bc, 7);
      this.field_35902_j = new WorldGenMinable(Block.field_391_ax.field_376_bc, 7);
      this.field_35903_k = new WorldGenMinable(Block.field_9267_N.field_376_bc, 6);
      this.field_35900_l = new WorldGenFlowers(Block.field_417_ae.field_376_bc);
      this.field_35901_m = new WorldGenFlowers(Block.field_416_af.field_376_bc);
      this.field_35898_n = new WorldGenFlowers(Block.field_415_ag.field_376_bc);
      this.field_35899_o = new WorldGenFlowers(Block.field_414_ah.field_376_bc);
      this.field_40720_u = new WorldGenBigMushroom();
      this.field_35913_p = new WorldGenReed();
      this.field_35912_q = new WorldGenCactus();
      this.field_40722_x = new WorldGenWaterlily();
      this.field_40721_y = 0;
      this.field_35911_r = 0;
      this.field_35910_s = 2;
      this.field_35909_t = 1;
      this.field_35908_u = 0;
      this.field_35907_v = 0;
      this.field_35906_w = 0;
      this.field_35916_x = 0;
      this.field_35915_y = 1;
      this.field_35914_z = 3;
      this.field_35888_A = 1;
      this.field_40718_J = 0;
      this.field_40719_K = true;
      this.field_35887_F = p_i695_1_;
   }

   public void func_35881_a(World p_35881_1_, Random p_35881_2_, int p_35881_3_, int p_35881_4_) {
      if(this.field_35889_B != null) {
         throw new RuntimeException("Already decorating!!");
      } else {
         this.field_35889_B = p_35881_1_;
         this.field_35890_C = p_35881_2_;
         this.field_35885_D = p_35881_3_;
         this.field_35886_E = p_35881_4_;
         this.func_35882_b();
         this.field_35889_B = null;
         this.field_35890_C = null;
      }
   }

   protected void func_35882_b() {
      this.func_35880_a();

      int var1;
      int var2;
      int var3;
      for(var1 = 0; var1 < this.field_35914_z; ++var1) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35895_b.func_516_a(this.field_35889_B, this.field_35890_C, var2, this.field_35889_B.func_4083_e(var2, var3), var3);
      }

      for(var1 = 0; var1 < this.field_35888_A; ++var1) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35897_a.func_516_a(this.field_35889_B, this.field_35890_C, var2, this.field_35889_B.func_4083_e(var2, var3), var3);
      }

      for(var1 = 0; var1 < this.field_35915_y; ++var1) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35895_b.func_516_a(this.field_35889_B, this.field_35890_C, var2, this.field_35889_B.func_4083_e(var2, var3), var3);
      }

      var1 = this.field_35911_r;
      if(this.field_35890_C.nextInt(10) == 0) {
         ++var1;
      }

      int var4;
      for(var2 = 0; var2 < var1; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         WorldGenerator var5 = this.field_35887_F.func_21107_a(this.field_35890_C);
         var5.func_517_a(1.0D, 1.0D, 1.0D);
         var5.func_516_a(this.field_35889_B, this.field_35890_C, var3, this.field_35889_B.func_666_c(var3, var4), var4);
      }

      for(var2 = 0; var2 < this.field_40718_J; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_40720_u.func_516_a(this.field_35889_B, this.field_35890_C, var3, this.field_35889_B.func_666_c(var3, var4), var4);
      }

      int var7;
      for(var2 = 0; var2 < this.field_35910_s; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35890_C.nextInt(128);
         var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35900_l.func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
         if(this.field_35890_C.nextInt(4) == 0) {
            var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
            var4 = this.field_35890_C.nextInt(128);
            var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
            this.field_35901_m.func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
         }
      }

      for(var2 = 0; var2 < this.field_35909_t; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35890_C.nextInt(128);
         var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         WorldGenerator var6 = this.field_35887_F.func_48410_b(this.field_35890_C);
         var6.func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
      }

      for(var2 = 0; var2 < this.field_35908_u; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35890_C.nextInt(128);
         var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         (new WorldGenDeadBush(Block.field_9256_Y.field_376_bc)).func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
      }

      for(var2 = 0; var2 < this.field_40721_y; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;

         for(var7 = this.field_35890_C.nextInt(128); var7 > 0 && this.field_35889_B.func_600_a(var3, var7 - 1, var4) == 0; --var7) {
            ;
         }

         this.field_40722_x.func_516_a(this.field_35889_B, this.field_35890_C, var3, var7, var4);
      }

      for(var2 = 0; var2 < this.field_35907_v; ++var2) {
         if(this.field_35890_C.nextInt(4) == 0) {
            var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
            var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
            var7 = this.field_35889_B.func_666_c(var3, var4);
            this.field_35898_n.func_516_a(this.field_35889_B, this.field_35890_C, var3, var7, var4);
         }

         if(this.field_35890_C.nextInt(8) == 0) {
            var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
            var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
            var7 = this.field_35890_C.nextInt(128);
            this.field_35899_o.func_516_a(this.field_35889_B, this.field_35890_C, var3, var7, var4);
         }
      }

      if(this.field_35890_C.nextInt(4) == 0) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35890_C.nextInt(128);
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35898_n.func_516_a(this.field_35889_B, this.field_35890_C, var2, var3, var4);
      }

      if(this.field_35890_C.nextInt(8) == 0) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35890_C.nextInt(128);
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35899_o.func_516_a(this.field_35889_B, this.field_35890_C, var2, var3, var4);
      }

      for(var2 = 0; var2 < this.field_35906_w; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         var7 = this.field_35890_C.nextInt(128);
         this.field_35913_p.func_516_a(this.field_35889_B, this.field_35890_C, var3, var7, var4);
      }

      for(var2 = 0; var2 < 10; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35890_C.nextInt(128);
         var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35913_p.func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
      }

      if(this.field_35890_C.nextInt(32) == 0) {
         var2 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var3 = this.field_35890_C.nextInt(128);
         var4 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         (new WorldGenPumpkin()).func_516_a(this.field_35889_B, this.field_35890_C, var2, var3, var4);
      }

      for(var2 = 0; var2 < this.field_35916_x; ++var2) {
         var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         var4 = this.field_35890_C.nextInt(128);
         var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         this.field_35912_q.func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
      }

      if(this.field_40719_K) {
         for(var2 = 0; var2 < 50; ++var2) {
            var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
            var4 = this.field_35890_C.nextInt(this.field_35890_C.nextInt(120) + 8);
            var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_401_B.field_376_bc)).func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
         }

         for(var2 = 0; var2 < 20; ++var2) {
            var3 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
            var4 = this.field_35890_C.nextInt(this.field_35890_C.nextInt(this.field_35890_C.nextInt(112) + 8) + 8);
            var7 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_397_D.field_376_bc)).func_516_a(this.field_35889_B, this.field_35890_C, var3, var4, var7);
         }
      }

   }

   protected void func_35884_a(int p_35884_1_, WorldGenerator p_35884_2_, int p_35884_3_, int p_35884_4_) {
      for(int var5 = 0; var5 < p_35884_1_; ++var5) {
         int var6 = this.field_35885_D + this.field_35890_C.nextInt(16);
         int var7 = this.field_35890_C.nextInt(p_35884_4_ - p_35884_3_) + p_35884_3_;
         int var8 = this.field_35886_E + this.field_35890_C.nextInt(16);
         p_35884_2_.func_516_a(this.field_35889_B, this.field_35890_C, var6, var7, var8);
      }

   }

   protected void func_35883_b(int p_35883_1_, WorldGenerator p_35883_2_, int p_35883_3_, int p_35883_4_) {
      for(int var5 = 0; var5 < p_35883_1_; ++var5) {
         int var6 = this.field_35885_D + this.field_35890_C.nextInt(16);
         int var7 = this.field_35890_C.nextInt(p_35883_4_) + this.field_35890_C.nextInt(p_35883_4_) + (p_35883_3_ - p_35883_4_);
         int var8 = this.field_35886_E + this.field_35890_C.nextInt(16);
         p_35883_2_.func_516_a(this.field_35889_B, this.field_35890_C, var6, var7, var8);
      }

   }

   protected void func_35880_a() {
      this.func_35884_a(20, this.field_35893_d, 0, 128);
      this.func_35884_a(10, this.field_35894_e, 0, 128);
      this.func_35884_a(20, this.field_35891_f, 0, 128);
      this.func_35884_a(20, this.field_35892_g, 0, 64);
      this.func_35884_a(2, this.field_35904_h, 0, 32);
      this.func_35884_a(8, this.field_35905_i, 0, 16);
      this.func_35884_a(1, this.field_35902_j, 0, 16);
      this.func_35883_b(1, this.field_35903_k, 16, 16);
   }
}
