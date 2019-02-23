package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MapGenCaves;
import net.minecraft.src.MapGenMineshaft;
import net.minecraft.src.MapGenRavine;
import net.minecraft.src.MapGenStronghold;
import net.minecraft.src.MapGenVillage;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenDungeons;
import net.minecraft.src.WorldGenLakes;

public class ChunkProviderGenerate implements IChunkProvider {

   private Random field_913_j;
   private NoiseGeneratorOctaves field_912_k;
   private NoiseGeneratorOctaves field_911_l;
   private NoiseGeneratorOctaves field_910_m;
   private NoiseGeneratorOctaves field_908_o;
   public NoiseGeneratorOctaves field_922_a;
   public NoiseGeneratorOctaves field_921_b;
   public NoiseGeneratorOctaves field_920_c;
   private World field_907_p;
   private final boolean field_35389_t;
   private double[] field_4180_q;
   private double[] field_903_t = new double[256];
   private MapGenBase field_902_u = new MapGenCaves();
   private MapGenStronghold field_35386_d = new MapGenStronghold();
   private MapGenVillage field_35387_e = new MapGenVillage(0);
   private MapGenMineshaft field_35385_f = new MapGenMineshaft();
   private MapGenBase field_35390_x = new MapGenRavine();
   private BiomeGenBase[] field_4179_v;
   double[] field_4185_d;
   double[] field_4184_e;
   double[] field_4183_f;
   double[] field_4182_g;
   double[] field_4181_h;
   float[] field_35388_l;
   int[][] field_914_i = new int[32][32];


   public ChunkProviderGenerate(World p_i211_1_, long p_i211_2_, boolean p_i211_4_) {
      this.field_907_p = p_i211_1_;
      this.field_35389_t = p_i211_4_;
      this.field_913_j = new Random(p_i211_2_);
      this.field_912_k = new NoiseGeneratorOctaves(this.field_913_j, 16);
      this.field_911_l = new NoiseGeneratorOctaves(this.field_913_j, 16);
      this.field_910_m = new NoiseGeneratorOctaves(this.field_913_j, 8);
      this.field_908_o = new NoiseGeneratorOctaves(this.field_913_j, 4);
      this.field_922_a = new NoiseGeneratorOctaves(this.field_913_j, 10);
      this.field_921_b = new NoiseGeneratorOctaves(this.field_913_j, 16);
      this.field_920_c = new NoiseGeneratorOctaves(this.field_913_j, 8);
   }

   public void func_4060_a(int p_4060_1_, int p_4060_2_, byte[] p_4060_3_) {
      byte var4 = 4;
      byte var5 = 16;
      byte var6 = 63;
      int var7 = var4 + 1;
      byte var8 = 17;
      int var9 = var4 + 1;
      this.field_4179_v = this.field_907_p.func_4075_a().func_35557_b(this.field_4179_v, p_4060_1_ * 4 - 2, p_4060_2_ * 4 - 2, var7 + 5, var9 + 5);
      this.field_4180_q = this.func_4061_a(this.field_4180_q, p_4060_1_ * var4, 0, p_4060_2_ * var4, var7, var8, var9);

      for(int var10 = 0; var10 < var4; ++var10) {
         for(int var11 = 0; var11 < var4; ++var11) {
            for(int var12 = 0; var12 < var5; ++var12) {
               double var13 = 0.125D;
               double var15 = this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
               double var17 = this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
               double var19 = this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
               double var21 = this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
               double var23 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
               double var25 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
               double var27 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
               double var29 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 8; ++var31) {
                  double var32 = 0.25D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 4; ++var42) {
                     int var43 = var42 + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + var31;
                     short var44 = 128;
                     var43 -= var44;
                     double var45 = 0.25D;
                     double var49 = (var36 - var34) * var45;
                     double var47 = var34 - var49;

                     for(int var51 = 0; var51 < 4; ++var51) {
                        if((var47 += var49) > 0.0D) {
                           p_4060_3_[var43 += var44] = (byte)Block.field_338_u.field_376_bc;
                        } else if(var12 * 8 + var31 < var6) {
                           p_4060_3_[var43 += var44] = (byte)Block.field_399_C.field_376_bc;
                        } else {
                           p_4060_3_[var43 += var44] = 0;
                        }
                     }

                     var34 += var38;
                     var36 += var40;
                  }

                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
                  var21 += var29;
               }
            }
         }
      }

   }

   public void func_4062_a(int p_4062_1_, int p_4062_2_, byte[] p_4062_3_, BiomeGenBase[] p_4062_4_) {
      byte var5 = 63;
      double var6 = 0.03125D;
      this.field_903_t = this.field_908_o.func_807_a(this.field_903_t, p_4062_1_ * 16, p_4062_2_ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            BiomeGenBase var10 = p_4062_4_[var9 + var8 * 16];
            float var11 = var10.func_48411_i();
            int var12 = (int)(this.field_903_t[var8 + var9 * 16] / 3.0D + 3.0D + this.field_913_j.nextDouble() * 0.25D);
            int var13 = -1;
            byte var14 = var10.field_4242_o;
            byte var15 = var10.field_4241_p;

            for(int var16 = 127; var16 >= 0; --var16) {
               int var17 = (var9 * 16 + var8) * 128 + var16;
               if(var16 <= 0 + this.field_913_j.nextInt(5)) {
                  p_4062_3_[var17] = (byte)Block.field_403_A.field_376_bc;
               } else {
                  byte var18 = p_4062_3_[var17];
                  if(var18 == 0) {
                     var13 = -1;
                  } else if(var18 == Block.field_338_u.field_376_bc) {
                     if(var13 == -1) {
                        if(var12 <= 0) {
                           var14 = 0;
                           var15 = (byte)Block.field_338_u.field_376_bc;
                        } else if(var16 >= var5 - 4 && var16 <= var5 + 1) {
                           var14 = var10.field_4242_o;
                           var15 = var10.field_4241_p;
                        }

                        if(var16 < var5 && var14 == 0) {
                           if(var11 < 0.15F) {
                              var14 = (byte)Block.field_4063_aU.field_376_bc;
                           } else {
                              var14 = (byte)Block.field_399_C.field_376_bc;
                           }
                        }

                        var13 = var12;
                        if(var16 >= var5 - 1) {
                           p_4062_3_[var17] = var14;
                        } else {
                           p_4062_3_[var17] = var15;
                        }
                     } else if(var13 > 0) {
                        --var13;
                        p_4062_3_[var17] = var15;
                        if(var13 == 0 && var15 == Block.field_393_F.field_376_bc) {
                           var13 = this.field_913_j.nextInt(4);
                           var15 = (byte)Block.field_9264_Q.field_376_bc;
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public Chunk func_538_d(int p_538_1_, int p_538_2_) {
      return this.func_533_b(p_538_1_, p_538_2_);
   }

   public Chunk func_533_b(int p_533_1_, int p_533_2_) {
      this.field_913_j.setSeed((long)p_533_1_ * 341873128712L + (long)p_533_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.func_4060_a(p_533_1_, p_533_2_, var3);
      this.field_4179_v = this.field_907_p.func_4075_a().func_4070_a(this.field_4179_v, p_533_1_ * 16, p_533_2_ * 16, 16, 16);
      this.func_4062_a(p_533_1_, p_533_2_, var3, this.field_4179_v);
      this.field_902_u.func_867_a(this, this.field_907_p, p_533_1_, p_533_2_, var3);
      this.field_35390_x.func_867_a(this, this.field_907_p, p_533_1_, p_533_2_, var3);
      if(this.field_35389_t) {
         this.field_35385_f.func_867_a(this, this.field_907_p, p_533_1_, p_533_2_, var3);
         this.field_35387_e.func_867_a(this, this.field_907_p, p_533_1_, p_533_2_, var3);
         this.field_35386_d.func_867_a(this, this.field_907_p, p_533_1_, p_533_2_, var3);
      }

      Chunk var4 = new Chunk(this.field_907_p, var3, p_533_1_, p_533_2_);
      byte[] var5 = var4.func_48493_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.field_4179_v[var6].field_35494_y;
      }

      var4.func_1024_c();
      return var4;
   }

   private double[] func_4061_a(double[] p_4061_1_, int p_4061_2_, int p_4061_3_, int p_4061_4_, int p_4061_5_, int p_4061_6_, int p_4061_7_) {
      if(p_4061_1_ == null) {
         p_4061_1_ = new double[p_4061_5_ * p_4061_6_ * p_4061_7_];
      }

      if(this.field_35388_l == null) {
         this.field_35388_l = new float[25];

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               float var10 = 10.0F / MathHelper.func_1113_c((float)(var8 * var8 + var9 * var9) + 0.2F);
               this.field_35388_l[var8 + 2 + (var9 + 2) * 5] = var10;
            }
         }
      }

      double var44 = 684.412D;
      double var45 = 684.412D;
      this.field_4182_g = this.field_922_a.func_4109_a(this.field_4182_g, p_4061_2_, p_4061_4_, p_4061_5_, p_4061_7_, 1.121D, 1.121D, 0.5D);
      this.field_4181_h = this.field_921_b.func_4109_a(this.field_4181_h, p_4061_2_, p_4061_4_, p_4061_5_, p_4061_7_, 200.0D, 200.0D, 0.5D);
      this.field_4185_d = this.field_910_m.func_807_a(this.field_4185_d, p_4061_2_, p_4061_3_, p_4061_4_, p_4061_5_, p_4061_6_, p_4061_7_, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
      this.field_4184_e = this.field_912_k.func_807_a(this.field_4184_e, p_4061_2_, p_4061_3_, p_4061_4_, p_4061_5_, p_4061_6_, p_4061_7_, var44, var45, var44);
      this.field_4183_f = this.field_911_l.func_807_a(this.field_4183_f, p_4061_2_, p_4061_3_, p_4061_4_, p_4061_5_, p_4061_6_, p_4061_7_, var44, var45, var44);
      boolean var43 = false;
      boolean var42 = false;
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < p_4061_5_; ++var14) {
         for(int var15 = 0; var15 < p_4061_7_; ++var15) {
            float var16 = 0.0F;
            float var17 = 0.0F;
            float var18 = 0.0F;
            byte var19 = 2;
            BiomeGenBase var20 = this.field_4179_v[var14 + 2 + (var15 + 2) * (p_4061_5_ + 5)];

            for(int var21 = -var19; var21 <= var19; ++var21) {
               for(int var22 = -var19; var22 <= var19; ++var22) {
                  BiomeGenBase var23 = this.field_4179_v[var14 + var21 + 2 + (var15 + var22 + 2) * (p_4061_5_ + 5)];
                  float var24 = this.field_35388_l[var21 + 2 + (var22 + 2) * 5] / (var23.field_35492_q + 2.0F);
                  if(var23.field_35492_q > var20.field_35492_q) {
                     var24 /= 2.0F;
                  }

                  var16 += var23.field_35491_r * var24;
                  var17 += var23.field_35492_q * var24;
                  var18 += var24;
               }
            }

            var16 /= var18;
            var17 /= var18;
            var16 = var16 * 0.9F + 0.1F;
            var17 = (var17 * 4.0F - 1.0F) / 8.0F;
            double var46 = this.field_4181_h[var13] / 8000.0D;
            if(var46 < 0.0D) {
               var46 = -var46 * 0.3D;
            }

            var46 = var46 * 3.0D - 2.0D;
            if(var46 < 0.0D) {
               var46 /= 2.0D;
               if(var46 < -1.0D) {
                  var46 = -1.0D;
               }

               var46 /= 1.4D;
               var46 /= 2.0D;
            } else {
               if(var46 > 1.0D) {
                  var46 = 1.0D;
               }

               var46 /= 8.0D;
            }

            ++var13;

            for(int var47 = 0; var47 < p_4061_6_; ++var47) {
               double var48 = (double)var17;
               double var26 = (double)var16;
               var48 += var46 * 0.2D;
               var48 = var48 * (double)p_4061_6_ / 16.0D;
               double var28 = (double)p_4061_6_ / 2.0D + var48 * 4.0D;
               double var30 = 0.0D;
               double var32 = ((double)var47 - var28) * 12.0D * 128.0D / 128.0D / var26;
               if(var32 < 0.0D) {
                  var32 *= 4.0D;
               }

               double var34 = this.field_4184_e[var12] / 512.0D;
               double var36 = this.field_4183_f[var12] / 512.0D;
               double var38 = (this.field_4185_d[var12] / 10.0D + 1.0D) / 2.0D;
               if(var38 < 0.0D) {
                  var30 = var34;
               } else if(var38 > 1.0D) {
                  var30 = var36;
               } else {
                  var30 = var34 + (var36 - var34) * var38;
               }

               var30 -= var32;
               if(var47 > p_4061_6_ - 4) {
                  double var40 = (double)((float)(var47 - (p_4061_6_ - 4)) / 3.0F);
                  var30 = var30 * (1.0D - var40) + -10.0D * var40;
               }

               p_4061_1_[var12] = var30;
               ++var12;
            }
         }
      }

      return p_4061_1_;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return true;
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      BlockSand.field_466_a = true;
      int var4 = p_534_2_ * 16;
      int var5 = p_534_3_ * 16;
      BiomeGenBase var6 = this.field_907_p.func_48454_a(var4 + 16, var5 + 16);
      this.field_913_j.setSeed(this.field_907_p.func_22138_q());
      long var7 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      long var9 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      this.field_913_j.setSeed((long)p_534_2_ * var7 + (long)p_534_3_ * var9 ^ this.field_907_p.func_22138_q());
      boolean var11 = false;
      if(this.field_35389_t) {
         this.field_35385_f.func_35629_a(this.field_907_p, this.field_913_j, p_534_2_, p_534_3_);
         var11 = this.field_35387_e.func_35629_a(this.field_907_p, this.field_913_j, p_534_2_, p_534_3_);
         this.field_35386_d.func_35629_a(this.field_907_p, this.field_913_j, p_534_2_, p_534_3_);
      }

      int var12;
      int var13;
      int var14;
      if(!var11 && this.field_913_j.nextInt(4) == 0) {
         var12 = var4 + this.field_913_j.nextInt(16) + 8;
         var13 = this.field_913_j.nextInt(128);
         var14 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenLakes(Block.field_399_C.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var12, var13, var14);
      }

      if(!var11 && this.field_913_j.nextInt(8) == 0) {
         var12 = var4 + this.field_913_j.nextInt(16) + 8;
         var13 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
         var14 = var5 + this.field_913_j.nextInt(16) + 8;
         if(var13 < 63 || this.field_913_j.nextInt(10) == 0) {
            (new WorldGenLakes(Block.field_395_E.field_376_bc)).func_516_a(this.field_907_p, this.field_913_j, var12, var13, var14);
         }
      }

      for(var12 = 0; var12 < 8; ++var12) {
         var13 = var4 + this.field_913_j.nextInt(16) + 8;
         var14 = this.field_913_j.nextInt(128);
         int var15 = var5 + this.field_913_j.nextInt(16) + 8;
         if((new WorldGenDungeons()).func_516_a(this.field_907_p, this.field_913_j, var13, var14, var15)) {
            ;
         }
      }

      var6.func_35477_a(this.field_907_p, this.field_913_j, var4, var5);
      SpawnerAnimals.func_35957_a(this.field_907_p, var6, var4 + 8, var5 + 8, 16, 16, this.field_913_j);
      var4 += 8;
      var5 += 8;

      for(var12 = 0; var12 < 16; ++var12) {
         for(var13 = 0; var13 < 16; ++var13) {
            var14 = this.field_907_p.func_35461_e(var4 + var12, var5 + var13);
            if(this.field_907_p.func_40471_p(var12 + var4, var14 - 1, var13 + var5)) {
               this.field_907_p.func_690_d(var12 + var4, var14 - 1, var13 + var5, Block.field_4063_aU.field_376_bc);
            }

            if(this.field_907_p.func_40478_r(var12 + var4, var14, var13 + var5)) {
               this.field_907_p.func_690_d(var12 + var4, var14, var13 + var5, Block.field_428_aT.field_376_bc);
            }
         }
      }

      BlockSand.field_466_a = false;
   }

   public boolean func_535_a(boolean p_535_1_, IProgressUpdate p_535_2_) {
      return true;
   }

   public boolean func_532_a() {
      return false;
   }

   public boolean func_536_b() {
      return true;
   }

   public String func_21109_c() {
      return "RandomLevelSource";
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      BiomeGenBase var5 = this.field_907_p.func_48454_a(p_40377_2_, p_40377_4_);
      return var5 == null?null:var5.func_25063_a(p_40377_1_);
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return "Stronghold".equals(p_40376_2_) && this.field_35386_d != null?this.field_35386_d.func_40484_a(p_40376_1_, p_40376_3_, p_40376_4_, p_40376_5_):null;
   }
}
