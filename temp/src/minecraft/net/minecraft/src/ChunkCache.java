package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class ChunkCache implements IBlockAccess {

   private int field_1060_a;
   private int field_1059_b;
   private Chunk[][] field_1062_c;
   private boolean field_48467_d;
   private World field_1061_d;


   public ChunkCache(World p_i291_1_, int p_i291_2_, int p_i291_3_, int p_i291_4_, int p_i291_5_, int p_i291_6_, int p_i291_7_) {
      this.field_1061_d = p_i291_1_;
      this.field_1060_a = p_i291_2_ >> 4;
      this.field_1059_b = p_i291_4_ >> 4;
      int var8 = p_i291_5_ >> 4;
      int var9 = p_i291_7_ >> 4;
      this.field_1062_c = new Chunk[var8 - this.field_1060_a + 1][var9 - this.field_1059_b + 1];
      this.field_48467_d = true;

      for(int var10 = this.field_1060_a; var10 <= var8; ++var10) {
         for(int var11 = this.field_1059_b; var11 <= var9; ++var11) {
            Chunk var12 = p_i291_1_.func_704_b(var10, var11);
            if(var12 != null) {
               this.field_1062_c[var10 - this.field_1060_a][var11 - this.field_1059_b] = var12;
               if(!var12.func_48492_c(p_i291_3_, p_i291_6_)) {
                  this.field_48467_d = false;
               }
            }
         }
      }

   }

   public boolean func_48452_a() {
      return this.field_48467_d;
   }

   public int func_600_a(int p_600_1_, int p_600_2_, int p_600_3_) {
      if(p_600_2_ < 0) {
         return 0;
      } else if(p_600_2_ >= 256) {
         return 0;
      } else {
         int var4 = (p_600_1_ >> 4) - this.field_1060_a;
         int var5 = (p_600_3_ >> 4) - this.field_1059_b;
         if(var4 >= 0 && var4 < this.field_1062_c.length && var5 >= 0 && var5 < this.field_1062_c[var4].length) {
            Chunk var6 = this.field_1062_c[var4][var5];
            return var6 == null?0:var6.func_1008_a(p_600_1_ & 15, p_600_2_, p_600_3_ & 15);
         } else {
            return 0;
         }
      }
   }

   public TileEntity func_603_b(int p_603_1_, int p_603_2_, int p_603_3_) {
      int var4 = (p_603_1_ >> 4) - this.field_1060_a;
      int var5 = (p_603_3_ >> 4) - this.field_1059_b;
      return this.field_1062_c[var4][var5].func_1002_d(p_603_1_ & 15, p_603_2_, p_603_3_ & 15);
   }

   public float func_28099_a(int p_28099_1_, int p_28099_2_, int p_28099_3_, int p_28099_4_) {
      int var5 = this.func_4086_d(p_28099_1_, p_28099_2_, p_28099_3_);
      if(var5 < p_28099_4_) {
         var5 = p_28099_4_;
      }

      return this.field_1061_d.field_4209_q.field_4219_d[var5];
   }

   public int func_35451_b(int p_35451_1_, int p_35451_2_, int p_35451_3_, int p_35451_4_) {
      int var5 = this.func_35454_a(EnumSkyBlock.Sky, p_35451_1_, p_35451_2_, p_35451_3_);
      int var6 = this.func_35454_a(EnumSkyBlock.Block, p_35451_1_, p_35451_2_, p_35451_3_);
      if(var6 < p_35451_4_) {
         var6 = p_35451_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public float func_598_c(int p_598_1_, int p_598_2_, int p_598_3_) {
      return this.field_1061_d.field_4209_q.field_4219_d[this.func_4086_d(p_598_1_, p_598_2_, p_598_3_)];
   }

   public int func_4086_d(int p_4086_1_, int p_4086_2_, int p_4086_3_) {
      return this.func_716_a(p_4086_1_, p_4086_2_, p_4086_3_, true);
   }

   public int func_716_a(int p_716_1_, int p_716_2_, int p_716_3_, boolean p_716_4_) {
      if(p_716_1_ >= -30000000 && p_716_3_ >= -30000000 && p_716_1_ < 30000000 && p_716_3_ <= 30000000) {
         int var5;
         int var6;
         if(p_716_4_) {
            var5 = this.func_600_a(p_716_1_, p_716_2_, p_716_3_);
            if(var5 == Block.field_410_al.field_376_bc || var5 == Block.field_446_aB.field_376_bc || var5 == Block.field_4059_au.field_376_bc || var5 == Block.field_4069_aI.field_376_bc) {
               var6 = this.func_716_a(p_716_1_, p_716_2_ + 1, p_716_3_, false);
               int var7 = this.func_716_a(p_716_1_ + 1, p_716_2_, p_716_3_, false);
               int var8 = this.func_716_a(p_716_1_ - 1, p_716_2_, p_716_3_, false);
               int var9 = this.func_716_a(p_716_1_, p_716_2_, p_716_3_ + 1, false);
               int var10 = this.func_716_a(p_716_1_, p_716_2_, p_716_3_ - 1, false);
               if(var7 > var6) {
                  var6 = var7;
               }

               if(var8 > var6) {
                  var6 = var8;
               }

               if(var9 > var6) {
                  var6 = var9;
               }

               if(var10 > var6) {
                  var6 = var10;
               }

               return var6;
            }
         }

         if(p_716_2_ < 0) {
            return 0;
         } else if(p_716_2_ >= 256) {
            var5 = 15 - this.field_1061_d.field_1046_e;
            if(var5 < 0) {
               var5 = 0;
            }

            return var5;
         } else {
            var5 = (p_716_1_ >> 4) - this.field_1060_a;
            var6 = (p_716_3_ >> 4) - this.field_1059_b;
            return this.field_1062_c[var5][var6].func_1019_c(p_716_1_ & 15, p_716_2_, p_716_3_ & 15, this.field_1061_d.field_1046_e);
         }
      } else {
         return 15;
      }
   }

   public int func_602_e(int p_602_1_, int p_602_2_, int p_602_3_) {
      if(p_602_2_ < 0) {
         return 0;
      } else if(p_602_2_ >= 256) {
         return 0;
      } else {
         int var4 = (p_602_1_ >> 4) - this.field_1060_a;
         int var5 = (p_602_3_ >> 4) - this.field_1059_b;
         return this.field_1062_c[var4][var5].func_1021_b(p_602_1_ & 15, p_602_2_, p_602_3_ & 15);
      }
   }

   public Material func_599_f(int p_599_1_, int p_599_2_, int p_599_3_) {
      int var4 = this.func_600_a(p_599_1_, p_599_2_, p_599_3_);
      return var4 == 0?Material.field_1337_a:Block.field_345_n[var4].field_356_bn;
   }

   public BiomeGenBase func_48454_a(int p_48454_1_, int p_48454_2_) {
      return this.field_1061_d.func_48454_a(p_48454_1_, p_48454_2_);
   }

   public boolean func_601_g(int p_601_1_, int p_601_2_, int p_601_3_) {
      Block var4 = Block.field_345_n[this.func_600_a(p_601_1_, p_601_2_, p_601_3_)];
      return var4 == null?false:var4.func_217_b();
   }

   public boolean func_28100_h(int p_28100_1_, int p_28100_2_, int p_28100_3_) {
      Block var4 = Block.field_345_n[this.func_600_a(p_28100_1_, p_28100_2_, p_28100_3_)];
      return var4 == null?false:var4.field_356_bn.func_880_c() && var4.func_242_c();
   }

   public boolean func_20084_d(int p_20084_1_, int p_20084_2_, int p_20084_3_) {
      Block var4 = Block.field_345_n[this.func_600_a(p_20084_1_, p_20084_2_, p_20084_3_)];
      return var4 == null;
   }

   public int func_35454_a(EnumSkyBlock p_35454_1_, int p_35454_2_, int p_35454_3_, int p_35454_4_) {
      if(p_35454_3_ < 0) {
         p_35454_3_ = 0;
      }

      if(p_35454_3_ >= 256) {
         p_35454_3_ = 255;
      }

      if(p_35454_3_ >= 0 && p_35454_3_ < 256 && p_35454_2_ >= -30000000 && p_35454_4_ >= -30000000 && p_35454_2_ < 30000000 && p_35454_4_ <= 30000000) {
         int var5;
         int var6;
         if(Block.field_40201_bL[this.func_600_a(p_35454_2_, p_35454_3_, p_35454_4_)]) {
            var5 = this.func_35453_b(p_35454_1_, p_35454_2_, p_35454_3_ + 1, p_35454_4_);
            var6 = this.func_35453_b(p_35454_1_, p_35454_2_ + 1, p_35454_3_, p_35454_4_);
            int var7 = this.func_35453_b(p_35454_1_, p_35454_2_ - 1, p_35454_3_, p_35454_4_);
            int var8 = this.func_35453_b(p_35454_1_, p_35454_2_, p_35454_3_, p_35454_4_ + 1);
            int var9 = this.func_35453_b(p_35454_1_, p_35454_2_, p_35454_3_, p_35454_4_ - 1);
            if(var6 > var5) {
               var5 = var6;
            }

            if(var7 > var5) {
               var5 = var7;
            }

            if(var8 > var5) {
               var5 = var8;
            }

            if(var9 > var5) {
               var5 = var9;
            }

            return var5;
         } else {
            var5 = (p_35454_2_ >> 4) - this.field_1060_a;
            var6 = (p_35454_4_ >> 4) - this.field_1059_b;
            return this.field_1062_c[var5][var6].func_1025_a(p_35454_1_, p_35454_2_ & 15, p_35454_3_, p_35454_4_ & 15);
         }
      } else {
         return p_35454_1_.field_1722_c;
      }
   }

   public int func_35453_b(EnumSkyBlock p_35453_1_, int p_35453_2_, int p_35453_3_, int p_35453_4_) {
      if(p_35453_3_ < 0) {
         p_35453_3_ = 0;
      }

      if(p_35453_3_ >= 256) {
         p_35453_3_ = 255;
      }

      if(p_35453_3_ >= 0 && p_35453_3_ < 256 && p_35453_2_ >= -30000000 && p_35453_4_ >= -30000000 && p_35453_2_ < 30000000 && p_35453_4_ <= 30000000) {
         int var5 = (p_35453_2_ >> 4) - this.field_1060_a;
         int var6 = (p_35453_4_ >> 4) - this.field_1059_b;
         return this.field_1062_c[var5][var6].func_1025_a(p_35453_1_, p_35453_2_ & 15, p_35453_3_, p_35453_4_ & 15);
      } else {
         return p_35453_1_.field_1722_c;
      }
   }

   public int func_48453_b() {
      return 256;
   }
}
