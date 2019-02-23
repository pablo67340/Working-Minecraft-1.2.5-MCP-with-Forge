package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.IsoImageBuffer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class TerrainTextureManager {

   private float[] field_1181_a = new float[768];
   private int[] field_1180_b = new int[17408];
   private int[] field_1186_c = new int[17408];
   private int[] field_1185_d = new int[17408];
   private int[] field_1184_e = new int[17408];
   private int[] field_1183_f = new int[34];
   private int[] field_1182_g = new int[768];


   public TerrainTextureManager() {
      try {
         BufferedImage var1 = ImageIO.read(TerrainTextureManager.class.getResource("/terrain.png"));
         int[] var2 = new int[65536];
         var1.getRGB(0, 0, 256, 256, var2, 0, 256);

         for(int var3 = 0; var3 < 256; ++var3) {
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = var3 % 16 * 16;
            int var8 = var3 / 16 * 16;
            int var9 = 0;

            for(int var10 = 0; var10 < 16; ++var10) {
               for(int var11 = 0; var11 < 16; ++var11) {
                  int var12 = var2[var11 + var7 + (var10 + var8) * 256];
                  int var13 = var12 >> 24 & 255;
                  if(var13 > 128) {
                     var4 += var12 >> 16 & 255;
                     var5 += var12 >> 8 & 255;
                     var6 += var12 & 255;
                     ++var9;
                  }
               }

               if(var9 == 0) {
                  ++var9;
               }

               this.field_1181_a[var3 * 3 + 0] = (float)(var4 / var9);
               this.field_1181_a[var3 * 3 + 1] = (float)(var5 / var9);
               this.field_1181_a[var3 * 3 + 2] = (float)(var6 / var9);
            }
         }
      } catch (IOException var14) {
         var14.printStackTrace();
      }

      for(int var15 = 0; var15 < 4096; ++var15) {
         if(Block.field_345_n[var15] != null) {
            this.field_1182_g[var15 * 3 + 0] = Block.field_345_n[var15].func_218_a(1);
            this.field_1182_g[var15 * 3 + 1] = Block.field_345_n[var15].func_218_a(2);
            this.field_1182_g[var15 * 3 + 2] = Block.field_345_n[var15].func_218_a(3);
         }
      }

   }

   public void func_799_a(IsoImageBuffer p_799_1_) {
      World var2 = p_799_1_.field_1347_b;
      if(var2 == null) {
         p_799_1_.field_1351_f = true;
         p_799_1_.field_1352_e = true;
      } else {
         int var3 = p_799_1_.field_1354_c * 16;
         int var4 = p_799_1_.field_1353_d * 16;
         int var5 = var3 + 16;
         int var6 = var4 + 16;
         Chunk var7 = var2.func_704_b(p_799_1_.field_1354_c, p_799_1_.field_1353_d);
         if(var7.func_21167_h()) {
            p_799_1_.field_1351_f = true;
            p_799_1_.field_1352_e = true;
         } else {
            p_799_1_.field_1351_f = false;
            Arrays.fill(this.field_1186_c, 0);
            Arrays.fill(this.field_1185_d, 0);
            Arrays.fill(this.field_1183_f, 544);

            for(int var8 = var6 - 1; var8 >= var4; --var8) {
               for(int var9 = var5 - 1; var9 >= var3; --var9) {
                  int var10 = var9 - var3;
                  int var11 = var8 - var4;
                  int var12 = var10 + var11;
                  boolean var13 = true;

                  for(int var14 = 0; var14 < 128; ++var14) {
                     int var15 = var11 - var10 - var14 + 544 - 16;
                     if(var15 < this.field_1183_f[var12] || var15 < this.field_1183_f[var12 + 1]) {
                        Block var16 = Block.field_345_n[var2.func_600_a(var9, var14, var8)];
                        if(var16 == null) {
                           var13 = false;
                        } else if(var16.field_356_bn == Material.field_1332_f) {
                           int var17 = var2.func_600_a(var9, var14 + 1, var8);
                           if(var17 == 0 || Block.field_345_n[var17].field_356_bn != Material.field_1332_f) {
                              float var18 = (float)var14 / 127.0F * 0.6F + 0.4F;
                              float var19 = var2.func_598_c(var9, var14 + 1, var8) * var18;
                              if(var15 >= 0 && var15 < 544) {
                                 int var20 = var12 + var15 * 32;
                                 if(var12 >= 0 && var12 <= 32 && this.field_1185_d[var20] <= var14) {
                                    this.field_1185_d[var20] = var14;
                                    this.field_1184_e[var20] = (int)(var19 * 127.0F);
                                 }

                                 if(var12 >= -1 && var12 <= 31 && this.field_1185_d[var20 + 1] <= var14) {
                                    this.field_1185_d[var20 + 1] = var14;
                                    this.field_1184_e[var20 + 1] = (int)(var19 * 127.0F);
                                 }

                                 var13 = false;
                              }
                           }
                        } else {
                           if(var13) {
                              if(var15 < this.field_1183_f[var12]) {
                                 this.field_1183_f[var12] = var15;
                              }

                              if(var15 < this.field_1183_f[var12 + 1]) {
                                 this.field_1183_f[var12 + 1] = var15;
                              }
                           }

                           float var24 = (float)var14 / 127.0F * 0.6F + 0.4F;
                           float var22;
                           int var25;
                           int var26;
                           float var27;
                           if(var15 >= 0 && var15 < 544) {
                              var25 = var12 + var15 * 32;
                              var26 = this.field_1182_g[var16.field_376_bc * 3 + 0];
                              var27 = (var2.func_598_c(var9, var14 + 1, var8) * 0.8F + 0.2F) * var24;
                              if(var12 >= 0 && this.field_1186_c[var25] <= var14) {
                                 this.field_1186_c[var25] = var14;
                                 this.field_1180_b[var25] = -16777216 | (int)(this.field_1181_a[var26 * 3 + 0] * var27) << 16 | (int)(this.field_1181_a[var26 * 3 + 1] * var27) << 8 | (int)(this.field_1181_a[var26 * 3 + 2] * var27);
                              }

                              if(var12 < 31) {
                                 var22 = var27 * 0.9F;
                                 if(this.field_1186_c[var25 + 1] <= var14) {
                                    this.field_1186_c[var25 + 1] = var14;
                                    this.field_1180_b[var25 + 1] = -16777216 | (int)(this.field_1181_a[var26 * 3 + 0] * var22) << 16 | (int)(this.field_1181_a[var26 * 3 + 1] * var22) << 8 | (int)(this.field_1181_a[var26 * 3 + 2] * var22);
                                 }
                              }
                           }

                           if(var15 >= -1 && var15 < 543) {
                              var25 = var12 + (var15 + 1) * 32;
                              var26 = this.field_1182_g[var16.field_376_bc * 3 + 1];
                              var27 = var2.func_598_c(var9 - 1, var14, var8) * 0.8F + 0.2F;
                              int var21 = this.field_1182_g[var16.field_376_bc * 3 + 2];
                              var22 = var2.func_598_c(var9, var14, var8 + 1) * 0.8F + 0.2F;
                              float var23;
                              if(var12 >= 0) {
                                 var23 = var27 * var24 * 0.6F;
                                 if(this.field_1186_c[var25] <= var14 - 1) {
                                    this.field_1186_c[var25] = var14 - 1;
                                    this.field_1180_b[var25] = -16777216 | (int)(this.field_1181_a[var26 * 3 + 0] * var23) << 16 | (int)(this.field_1181_a[var26 * 3 + 1] * var23) << 8 | (int)(this.field_1181_a[var26 * 3 + 2] * var23);
                                 }
                              }

                              if(var12 < 31) {
                                 var23 = var22 * 0.9F * var24 * 0.4F;
                                 if(this.field_1186_c[var25 + 1] <= var14 - 1) {
                                    this.field_1186_c[var25 + 1] = var14 - 1;
                                    this.field_1180_b[var25 + 1] = -16777216 | (int)(this.field_1181_a[var21 * 3 + 0] * var23) << 16 | (int)(this.field_1181_a[var21 * 3 + 1] * var23) << 8 | (int)(this.field_1181_a[var21 * 3 + 2] * var23);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            this.func_800_a();
            if(p_799_1_.field_1348_a == null) {
               p_799_1_.field_1348_a = new BufferedImage(32, 544, 2);
            }

            p_799_1_.field_1348_a.setRGB(0, 0, 32, 544, this.field_1180_b, 0, 32);
            p_799_1_.field_1352_e = true;
         }
      }
   }

   private void func_800_a() {
      for(int var1 = 0; var1 < 32; ++var1) {
         for(int var2 = 0; var2 < 544; ++var2) {
            int var3 = var1 + var2 * 32;
            if(this.field_1186_c[var3] == 0) {
               this.field_1180_b[var3] = 0;
            }

            if(this.field_1185_d[var3] > this.field_1186_c[var3]) {
               int var4 = this.field_1180_b[var3] >> 24 & 255;
               this.field_1180_b[var3] = ((this.field_1180_b[var3] & 16711422) >> 1) + this.field_1184_e[var3];
               if(var4 < 128) {
                  this.field_1180_b[var3] = Integer.MIN_VALUE + this.field_1184_e[var3] * 2;
               } else {
                  this.field_1180_b[var3] |= -16777216;
               }
            }
         }
      }

   }
}
