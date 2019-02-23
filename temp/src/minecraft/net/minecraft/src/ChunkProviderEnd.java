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
import net.minecraft.src.MathHelper;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;

public class ChunkProviderEnd implements IChunkProvider {

   private Random field_40396_i;
   private NoiseGeneratorOctaves field_40393_j;
   private NoiseGeneratorOctaves field_40394_k;
   private NoiseGeneratorOctaves field_40391_l;
   public NoiseGeneratorOctaves field_40388_a;
   public NoiseGeneratorOctaves field_40386_b;
   private World field_40392_m;
   private double[] field_40389_n;
   private BiomeGenBase[] field_40390_o;
   double[] field_40387_c;
   double[] field_40384_d;
   double[] field_40385_e;
   double[] field_40382_f;
   double[] field_40383_g;
   int[][] field_40395_h = new int[32][32];


   public ChunkProviderEnd(World p_i684_1_, long p_i684_2_) {
      this.field_40392_m = p_i684_1_;
      this.field_40396_i = new Random(p_i684_2_);
      this.field_40393_j = new NoiseGeneratorOctaves(this.field_40396_i, 16);
      this.field_40394_k = new NoiseGeneratorOctaves(this.field_40396_i, 16);
      this.field_40391_l = new NoiseGeneratorOctaves(this.field_40396_i, 8);
      this.field_40388_a = new NoiseGeneratorOctaves(this.field_40396_i, 10);
      this.field_40386_b = new NoiseGeneratorOctaves(this.field_40396_i, 16);
   }

   public void func_40380_a(int p_40380_1_, int p_40380_2_, byte[] p_40380_3_, BiomeGenBase[] p_40380_4_) {
      byte var5 = 2;
      int var6 = var5 + 1;
      byte var7 = 33;
      int var8 = var5 + 1;
      this.field_40389_n = this.func_40379_a(this.field_40389_n, p_40380_1_ * var5, 0, p_40380_2_ * var5, var6, var7, var8);

      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var5; ++var10) {
            for(int var11 = 0; var11 < 32; ++var11) {
               double var12 = 0.25D;
               double var14 = this.field_40389_n[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.field_40389_n[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.field_40389_n[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.field_40389_n[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.field_40389_n[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.field_40389_n[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.field_40389_n[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.field_40389_n[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 4; ++var30) {
                  double var31 = 0.125D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 8; ++var41) {
                     int var42 = var41 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var30;
                     short var43 = 128;
                     double var44 = 0.125D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 8; ++var50) {
                        int var51 = 0;
                        if(var46 > 0.0D) {
                           var51 = Block.field_40203_bK.field_376_bc;
                        }

                        p_40380_3_[var42] = (byte)var51;
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

   public void func_40381_b(int p_40381_1_, int p_40381_2_, byte[] p_40381_3_, BiomeGenBase[] p_40381_4_) {
      for(int var5 = 0; var5 < 16; ++var5) {
         for(int var6 = 0; var6 < 16; ++var6) {
            byte var7 = 1;
            int var8 = -1;
            byte var9 = (byte)Block.field_40203_bK.field_376_bc;
            byte var10 = (byte)Block.field_40203_bK.field_376_bc;

            for(int var11 = 127; var11 >= 0; --var11) {
               int var12 = (var6 * 16 + var5) * 128 + var11;
               byte var13 = p_40381_3_[var12];
               if(var13 == 0) {
                  var8 = -1;
               } else if(var13 == Block.field_338_u.field_376_bc) {
                  if(var8 == -1) {
                     if(var7 <= 0) {
                        var9 = 0;
                        var10 = (byte)Block.field_40203_bK.field_376_bc;
                     }

                     var8 = var7;
                     if(var11 >= 0) {
                        p_40381_3_[var12] = var9;
                     } else {
                        p_40381_3_[var12] = var10;
                     }
                  } else if(var8 > 0) {
                     --var8;
                     p_40381_3_[var12] = var10;
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
      this.field_40396_i.setSeed((long)p_533_1_ * 341873128712L + (long)p_533_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.field_40390_o = this.field_40392_m.func_4075_a().func_4070_a(this.field_40390_o, p_533_1_ * 16, p_533_2_ * 16, 16, 16);
      this.func_40380_a(p_533_1_, p_533_2_, var3, this.field_40390_o);
      this.func_40381_b(p_533_1_, p_533_2_, var3, this.field_40390_o);
      Chunk var4 = new Chunk(this.field_40392_m, var3, p_533_1_, p_533_2_);
      byte[] var5 = var4.func_48493_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.field_40390_o[var6].field_35494_y;
      }

      var4.func_1024_c();
      return var4;
   }

   private double[] func_40379_a(double[] p_40379_1_, int p_40379_2_, int p_40379_3_, int p_40379_4_, int p_40379_5_, int p_40379_6_, int p_40379_7_) {
      if(p_40379_1_ == null) {
         p_40379_1_ = new double[p_40379_5_ * p_40379_6_ * p_40379_7_];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.field_40382_f = this.field_40388_a.func_4109_a(this.field_40382_f, p_40379_2_, p_40379_4_, p_40379_5_, p_40379_7_, 1.121D, 1.121D, 0.5D);
      this.field_40383_g = this.field_40386_b.func_4109_a(this.field_40383_g, p_40379_2_, p_40379_4_, p_40379_5_, p_40379_7_, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.field_40387_c = this.field_40391_l.func_807_a(this.field_40387_c, p_40379_2_, p_40379_3_, p_40379_4_, p_40379_5_, p_40379_6_, p_40379_7_, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_40384_d = this.field_40393_j.func_807_a(this.field_40384_d, p_40379_2_, p_40379_3_, p_40379_4_, p_40379_5_, p_40379_6_, p_40379_7_, var8, var10, var8);
      this.field_40385_e = this.field_40394_k.func_807_a(this.field_40385_e, p_40379_2_, p_40379_3_, p_40379_4_, p_40379_5_, p_40379_6_, p_40379_7_, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < p_40379_5_; ++var14) {
         for(int var15 = 0; var15 < p_40379_7_; ++var15) {
            double var16 = (this.field_40382_f[var13] + 256.0D) / 512.0D;
            if(var16 > 1.0D) {
               var16 = 1.0D;
            }

            double var18 = this.field_40383_g[var13] / 8000.0D;
            if(var18 < 0.0D) {
               var18 = -var18 * 0.3D;
            }

            var18 = var18 * 3.0D - 2.0D;
            float var20 = (float)(var14 + p_40379_2_ - 0) / 1.0F;
            float var21 = (float)(var15 + p_40379_4_ - 0) / 1.0F;
            float var22 = 100.0F - MathHelper.func_1113_c(var20 * var20 + var21 * var21) * 8.0F;
            if(var22 > 80.0F) {
               var22 = 80.0F;
            }

            if(var22 < -100.0F) {
               var22 = -100.0F;
            }

            if(var18 > 1.0D) {
               var18 = 1.0D;
            }

            var18 /= 8.0D;
            var18 = 0.0D;
            if(var16 < 0.0D) {
               var16 = 0.0D;
            }

            var16 += 0.5D;
            var18 = var18 * (double)p_40379_6_ / 16.0D;
            ++var13;
            double var23 = (double)p_40379_6_ / 2.0D;

            for(int var25 = 0; var25 < p_40379_6_; ++var25) {
               double var26 = 0.0D;
               double var28 = ((double)var25 - var23) * 8.0D / var16;
               if(var28 < 0.0D) {
                  var28 *= -1.0D;
               }

               double var30 = this.field_40384_d[var12] / 512.0D;
               double var32 = this.field_40385_e[var12] / 512.0D;
               double var34 = (this.field_40387_c[var12] / 10.0D + 1.0D) / 2.0D;
               if(var34 < 0.0D) {
                  var26 = var30;
               } else if(var34 > 1.0D) {
                  var26 = var32;
               } else {
                  var26 = var30 + (var32 - var30) * var34;
               }

               var26 -= 8.0D;
               var26 += (double)var22;
               byte var36 = 2;
               double var37;
               if(var25 > p_40379_6_ / 2 - var36) {
                  var37 = (double)((float)(var25 - (p_40379_6_ / 2 - var36)) / 64.0F);
                  if(var37 < 0.0D) {
                     var37 = 0.0D;
                  }

                  if(var37 > 1.0D) {
                     var37 = 1.0D;
                  }

                  var26 = var26 * (1.0D - var37) + -3000.0D * var37;
               }

               var36 = 8;
               if(var25 < var36) {
                  var37 = (double)((float)(var36 - var25) / ((float)var36 - 1.0F));
                  var26 = var26 * (1.0D - var37) + -30.0D * var37;
               }

               p_40379_1_[var12] = var26;
               ++var12;
            }
         }
      }

      return p_40379_1_;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return true;
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      BlockSand.field_466_a = true;
      int var4 = p_534_2_ * 16;
      int var5 = p_534_3_ * 16;
      BiomeGenBase var6 = this.field_40392_m.func_48454_a(var4 + 16, var5 + 16);
      var6.func_35477_a(this.field_40392_m, this.field_40392_m.field_1037_n, var4, var5);
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
      BiomeGenBase var5 = this.field_40392_m.func_48454_a(p_40377_2_, p_40377_4_);
      return var5 == null?null:var5.func_25063_a(p_40377_1_);
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return null;
   }
}
