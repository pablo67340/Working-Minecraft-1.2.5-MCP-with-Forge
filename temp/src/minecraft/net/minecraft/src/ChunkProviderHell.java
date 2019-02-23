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
import net.minecraft.src.MapGenCavesHell;
import net.minecraft.src.MapGenNetherBridge;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenFire;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenGlowStone1;
import net.minecraft.src.WorldGenGlowStone2;
import net.minecraft.src.WorldGenHellLava;

public class ChunkProviderHell implements IChunkProvider {

   private Random field_4170_h;
   private NoiseGeneratorOctaves field_4169_i;
   private NoiseGeneratorOctaves field_4168_j;
   private NoiseGeneratorOctaves field_4167_k;
   private NoiseGeneratorOctaves field_4166_l;
   private NoiseGeneratorOctaves field_4165_m;
   public NoiseGeneratorOctaves field_4177_a;
   public NoiseGeneratorOctaves field_4176_b;
   private World field_4164_n;
   private double[] field_4163_o;
   public MapGenNetherBridge field_40378_c = new MapGenNetherBridge();
   private double[] field_4162_p = new double[256];
   private double[] field_4161_q = new double[256];
   private double[] field_4160_r = new double[256];
   private MapGenBase field_4159_s = new MapGenCavesHell();
   double[] field_4175_c;
   double[] field_4174_d;
   double[] field_4173_e;
   double[] field_4172_f;
   double[] field_4171_g;


   public ChunkProviderHell(World p_i98_1_, long p_i98_2_) {
      this.field_4164_n = p_i98_1_;
      this.field_4170_h = new Random(p_i98_2_);
      this.field_4169_i = new NoiseGeneratorOctaves(this.field_4170_h, 16);
      this.field_4168_j = new NoiseGeneratorOctaves(this.field_4170_h, 16);
      this.field_4167_k = new NoiseGeneratorOctaves(this.field_4170_h, 8);
      this.field_4166_l = new NoiseGeneratorOctaves(this.field_4170_h, 4);
      this.field_4165_m = new NoiseGeneratorOctaves(this.field_4170_h, 4);
      this.field_4177_a = new NoiseGeneratorOctaves(this.field_4170_h, 10);
      this.field_4176_b = new NoiseGeneratorOctaves(this.field_4170_h, 16);
   }

   public void func_4059_a(int p_4059_1_, int p_4059_2_, byte[] p_4059_3_) {
      byte var4 = 4;
      byte var5 = 32;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.field_4163_o = this.func_4057_a(this.field_4163_o, p_4059_1_ * var4, 0, p_4059_2_ * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.field_4163_o[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.field_4163_o[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.field_4163_o[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.field_4163_o[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.field_4163_o[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.field_4163_o[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.field_4163_o[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.field_4163_o[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 8; ++var30) {
                  double var31 = 0.25D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 4; ++var41) {
                     int var42 = var41 + var9 * 4 << 11 | 0 + var10 * 4 << 7 | var11 * 8 + var30;
                     short var43 = 128;
                     double var44 = 0.25D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 4; ++var50) {
                        int var51 = 0;
                        if(var11 * 8 + var30 < var5) {
                           var51 = Block.field_395_E.field_376_bc;
                        }

                        if(var46 > 0.0D) {
                           var51 = Block.field_4053_bc.field_376_bc;
                        }

                        p_4059_3_[var42] = (byte)var51;
                        var42 += var43;
                        var46 += var48;
                     }

                     var33 += var37;
                     var35 += var39;
                  }

                  var14 += var22;
                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
               }
            }
         }
      }

   }

   public void func_4058_b(int p_4058_1_, int p_4058_2_, byte[] p_4058_3_) {
      byte var4 = 64;
      double var5 = 0.03125D;
      this.field_4162_p = this.field_4166_l.func_807_a(this.field_4162_p, p_4058_1_ * 16, p_4058_2_ * 16, 0, 16, 16, 1, var5, var5, 1.0D);
      this.field_4161_q = this.field_4166_l.func_807_a(this.field_4161_q, p_4058_1_ * 16, 109, p_4058_2_ * 16, 16, 1, 16, var5, 1.0D, var5);
      this.field_4160_r = this.field_4165_m.func_807_a(this.field_4160_r, p_4058_1_ * 16, p_4058_2_ * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.field_4162_p[var7 + var8 * 16] + this.field_4170_h.nextDouble() * 0.2D > 0.0D;
            boolean var10 = this.field_4161_q[var7 + var8 * 16] + this.field_4170_h.nextDouble() * 0.2D > 0.0D;
            int var11 = (int)(this.field_4160_r[var7 + var8 * 16] / 3.0D + 3.0D + this.field_4170_h.nextDouble() * 0.25D);
            int var12 = -1;
            byte var13 = (byte)Block.field_4053_bc.field_376_bc;
            byte var14 = (byte)Block.field_4053_bc.field_376_bc;

            for(int var15 = 127; var15 >= 0; --var15) {
               int var16 = (var8 * 16 + var7) * 128 + var15;
               if(var15 >= 127 - this.field_4170_h.nextInt(5)) {
                  p_4058_3_[var16] = (byte)Block.field_403_A.field_376_bc;
               } else if(var15 <= 0 + this.field_4170_h.nextInt(5)) {
                  p_4058_3_[var16] = (byte)Block.field_403_A.field_376_bc;
               } else {
                  byte var17 = p_4058_3_[var16];
                  if(var17 == 0) {
                     var12 = -1;
                  } else if(var17 == Block.field_4053_bc.field_376_bc) {
                     if(var12 == -1) {
                        if(var11 <= 0) {
                           var13 = 0;
                           var14 = (byte)Block.field_4053_bc.field_376_bc;
                        } else if(var15 >= var4 - 4 && var15 <= var4 + 1) {
                           var13 = (byte)Block.field_4053_bc.field_376_bc;
                           var14 = (byte)Block.field_4053_bc.field_376_bc;
                           if(var10) {
                              var13 = (byte)Block.field_392_G.field_376_bc;
                           }

                           if(var10) {
                              var14 = (byte)Block.field_4053_bc.field_376_bc;
                           }

                           if(var9) {
                              var13 = (byte)Block.field_4051_bd.field_376_bc;
                           }

                           if(var9) {
                              var14 = (byte)Block.field_4051_bd.field_376_bc;
                           }
                        }

                        if(var15 < var4 && var13 == 0) {
                           var13 = (byte)Block.field_395_E.field_376_bc;
                        }

                        var12 = var11;
                        if(var15 >= var4 - 1) {
                           p_4058_3_[var16] = var13;
                        } else {
                           p_4058_3_[var16] = var14;
                        }
                     } else if(var12 > 0) {
                        --var12;
                        p_4058_3_[var16] = var14;
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
      this.field_4170_h.setSeed((long)p_533_1_ * 341873128712L + (long)p_533_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.func_4059_a(p_533_1_, p_533_2_, var3);
      this.func_4058_b(p_533_1_, p_533_2_, var3);
      this.field_4159_s.func_867_a(this, this.field_4164_n, p_533_1_, p_533_2_, var3);
      this.field_40378_c.func_867_a(this, this.field_4164_n, p_533_1_, p_533_2_, var3);
      Chunk var4 = new Chunk(this.field_4164_n, var3, p_533_1_, p_533_2_);
      BiomeGenBase[] var5 = this.field_4164_n.func_4075_a().func_4070_a((BiomeGenBase[])null, p_533_1_ * 16, p_533_2_ * 16, 16, 16);
      byte[] var6 = var4.func_48493_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].field_35494_y;
      }

      var4.func_48496_n();
      return var4;
   }

   private double[] func_4057_a(double[] p_4057_1_, int p_4057_2_, int p_4057_3_, int p_4057_4_, int p_4057_5_, int p_4057_6_, int p_4057_7_) {
      if(p_4057_1_ == null) {
         p_4057_1_ = new double[p_4057_5_ * p_4057_6_ * p_4057_7_];
      }

      double var8 = 684.412D;
      double var10 = 2053.236D;
      this.field_4172_f = this.field_4177_a.func_807_a(this.field_4172_f, p_4057_2_, p_4057_3_, p_4057_4_, p_4057_5_, 1, p_4057_7_, 1.0D, 0.0D, 1.0D);
      this.field_4171_g = this.field_4176_b.func_807_a(this.field_4171_g, p_4057_2_, p_4057_3_, p_4057_4_, p_4057_5_, 1, p_4057_7_, 100.0D, 0.0D, 100.0D);
      this.field_4175_c = this.field_4167_k.func_807_a(this.field_4175_c, p_4057_2_, p_4057_3_, p_4057_4_, p_4057_5_, p_4057_6_, p_4057_7_, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
      this.field_4174_d = this.field_4169_i.func_807_a(this.field_4174_d, p_4057_2_, p_4057_3_, p_4057_4_, p_4057_5_, p_4057_6_, p_4057_7_, var8, var10, var8);
      this.field_4173_e = this.field_4168_j.func_807_a(this.field_4173_e, p_4057_2_, p_4057_3_, p_4057_4_, p_4057_5_, p_4057_6_, p_4057_7_, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;
      double[] var14 = new double[p_4057_6_];

      int var15;
      for(var15 = 0; var15 < p_4057_6_; ++var15) {
         var14[var15] = Math.cos((double)var15 * 3.141592653589793D * 6.0D / (double)p_4057_6_) * 2.0D;
         double var16 = (double)var15;
         if(var15 > p_4057_6_ / 2) {
            var16 = (double)(p_4057_6_ - 1 - var15);
         }

         if(var16 < 4.0D) {
            var16 = 4.0D - var16;
            var14[var15] -= var16 * var16 * var16 * 10.0D;
         }
      }

      for(var15 = 0; var15 < p_4057_5_; ++var15) {
         for(int var36 = 0; var36 < p_4057_7_; ++var36) {
            double var17 = (this.field_4172_f[var13] + 256.0D) / 512.0D;
            if(var17 > 1.0D) {
               var17 = 1.0D;
            }

            double var19 = 0.0D;
            double var21 = this.field_4171_g[var13] / 8000.0D;
            if(var21 < 0.0D) {
               var21 = -var21;
            }

            var21 = var21 * 3.0D - 3.0D;
            if(var21 < 0.0D) {
               var21 /= 2.0D;
               if(var21 < -1.0D) {
                  var21 = -1.0D;
               }

               var21 /= 1.4D;
               var21 /= 2.0D;
               var17 = 0.0D;
            } else {
               if(var21 > 1.0D) {
                  var21 = 1.0D;
               }

               var21 /= 6.0D;
            }

            var17 += 0.5D;
            var21 = var21 * (double)p_4057_6_ / 16.0D;
            ++var13;

            for(int var23 = 0; var23 < p_4057_6_; ++var23) {
               double var24 = 0.0D;
               double var26 = var14[var23];
               double var28 = this.field_4174_d[var12] / 512.0D;
               double var30 = this.field_4173_e[var12] / 512.0D;
               double var32 = (this.field_4175_c[var12] / 10.0D + 1.0D) / 2.0D;
               if(var32 < 0.0D) {
                  var24 = var28;
               } else if(var32 > 1.0D) {
                  var24 = var30;
               } else {
                  var24 = var28 + (var30 - var28) * var32;
               }

               var24 -= var26;
               double var34;
               if(var23 > p_4057_6_ - 4) {
                  var34 = (double)((float)(var23 - (p_4057_6_ - 4)) / 3.0F);
                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               if((double)var23 < var19) {
                  var34 = (var19 - (double)var23) / 4.0D;
                  if(var34 < 0.0D) {
                     var34 = 0.0D;
                  }

                  if(var34 > 1.0D) {
                     var34 = 1.0D;
                  }

                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               p_4057_1_[var12] = var24;
               ++var12;
            }
         }
      }

      return p_4057_1_;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return true;
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      BlockSand.field_466_a = true;
      int var4 = p_534_2_ * 16;
      int var5 = p_534_3_ * 16;
      this.field_40378_c.func_35629_a(this.field_4164_n, this.field_4170_h, p_534_2_, p_534_3_);

      int var6;
      int var7;
      int var8;
      int var9;
      for(var6 = 0; var6 < 8; ++var6) {
         var7 = var4 + this.field_4170_h.nextInt(16) + 8;
         var8 = this.field_4170_h.nextInt(120) + 4;
         var9 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenHellLava(Block.field_397_D.field_376_bc)).func_516_a(this.field_4164_n, this.field_4170_h, var7, var8, var9);
      }

      var6 = this.field_4170_h.nextInt(this.field_4170_h.nextInt(10) + 1) + 1;

      int var10;
      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var4 + this.field_4170_h.nextInt(16) + 8;
         var9 = this.field_4170_h.nextInt(120) + 4;
         var10 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenFire()).func_516_a(this.field_4164_n, this.field_4170_h, var8, var9, var10);
      }

      var6 = this.field_4170_h.nextInt(this.field_4170_h.nextInt(10) + 1);

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var4 + this.field_4170_h.nextInt(16) + 8;
         var9 = this.field_4170_h.nextInt(120) + 4;
         var10 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenGlowStone1()).func_516_a(this.field_4164_n, this.field_4170_h, var8, var9, var10);
      }

      for(var7 = 0; var7 < 10; ++var7) {
         var8 = var4 + this.field_4170_h.nextInt(16) + 8;
         var9 = this.field_4170_h.nextInt(128);
         var10 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenGlowStone2()).func_516_a(this.field_4164_n, this.field_4170_h, var8, var9, var10);
      }

      if(this.field_4170_h.nextInt(1) == 0) {
         var7 = var4 + this.field_4170_h.nextInt(16) + 8;
         var8 = this.field_4170_h.nextInt(128);
         var9 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_415_ag.field_376_bc)).func_516_a(this.field_4164_n, this.field_4170_h, var7, var8, var9);
      }

      if(this.field_4170_h.nextInt(1) == 0) {
         var7 = var4 + this.field_4170_h.nextInt(16) + 8;
         var8 = this.field_4170_h.nextInt(128);
         var9 = var5 + this.field_4170_h.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_414_ah.field_376_bc)).func_516_a(this.field_4164_n, this.field_4170_h, var7, var8, var9);
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
      return "HellRandomLevelSource";
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      if(p_40377_1_ == EnumCreatureType.monster && this.field_40378_c.func_40483_a(p_40377_2_, p_40377_3_, p_40377_4_)) {
         return this.field_40378_c.func_40485_b();
      } else {
         BiomeGenBase var5 = this.field_4164_n.func_48454_a(p_40377_2_, p_40377_4_);
         return var5 == null?null:var5.func_25063_a(p_40377_1_);
      }
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return null;
   }
}
