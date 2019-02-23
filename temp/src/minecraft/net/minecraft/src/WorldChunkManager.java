package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeCache;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.World;
import net.minecraft.src.WorldType;

public class WorldChunkManager {

   private GenLayer field_34903_b;
   private GenLayer field_34902_c;
   private BiomeCache field_35563_f;
   private List field_35564_g;


   protected WorldChunkManager() {
      this.field_35563_f = new BiomeCache(this);
      this.field_35564_g = new ArrayList();
      this.field_35564_g.add(BiomeGenBase.field_4253_d);
      this.field_35564_g.add(BiomeGenBase.field_35485_c);
      this.field_35564_g.add(BiomeGenBase.field_4250_g);
      this.field_35564_g.add(BiomeGenBase.field_46047_u);
      this.field_35564_g.add(BiomeGenBase.field_46048_t);
      this.field_35564_g.add(BiomeGenBase.field_48416_w);
      this.field_35564_g.add(BiomeGenBase.field_48417_x);
   }

   public WorldChunkManager(long p_i1063_1_, WorldType p_i1063_3_) {
      this();
      GenLayer[] var4 = GenLayer.func_48425_a(p_i1063_1_, p_i1063_3_);
      this.field_34903_b = var4[0];
      this.field_34902_c = var4[1];
   }

   public WorldChunkManager(World p_i578_1_) {
      this(p_i578_1_.func_22138_q(), p_i578_1_.func_22144_v().func_46133_t());
   }

   public List func_35559_a() {
      return this.field_35564_g;
   }

   public BiomeGenBase func_4073_a(int p_4073_1_, int p_4073_2_) {
      return this.field_35563_f.func_35725_a(p_4073_1_, p_4073_2_);
   }

   public float[] func_35560_b(float[] p_35560_1_, int p_35560_2_, int p_35560_3_, int p_35560_4_, int p_35560_5_) {
      IntCache.func_35268_a();
      if(p_35560_1_ == null || p_35560_1_.length < p_35560_4_ * p_35560_5_) {
         p_35560_1_ = new float[p_35560_4_ * p_35560_5_];
      }

      int[] var6 = this.field_34902_c.func_35500_a(p_35560_2_, p_35560_3_, p_35560_4_, p_35560_5_);

      for(int var7 = 0; var7 < p_35560_4_ * p_35560_5_; ++var7) {
         float var8 = (float)BiomeGenBase.field_35486_a[var6[var7]].func_35476_e() / 65536.0F;
         if(var8 > 1.0F) {
            var8 = 1.0F;
         }

         p_35560_1_[var7] = var8;
      }

      return p_35560_1_;
   }

   public float func_40540_a(float p_40540_1_, int p_40540_2_) {
      return p_40540_1_;
   }

   public float[] func_4071_a(float[] p_4071_1_, int p_4071_2_, int p_4071_3_, int p_4071_4_, int p_4071_5_) {
      IntCache.func_35268_a();
      if(p_4071_1_ == null || p_4071_1_.length < p_4071_4_ * p_4071_5_) {
         p_4071_1_ = new float[p_4071_4_ * p_4071_5_];
      }

      int[] var6 = this.field_34902_c.func_35500_a(p_4071_2_, p_4071_3_, p_4071_4_, p_4071_5_);

      for(int var7 = 0; var7 < p_4071_4_ * p_4071_5_; ++var7) {
         float var8 = (float)BiomeGenBase.field_35486_a[var6[var7]].func_35474_f() / 65536.0F;
         if(var8 > 1.0F) {
            var8 = 1.0F;
         }

         p_4071_1_[var7] = var8;
      }

      return p_4071_1_;
   }

   public BiomeGenBase[] func_35557_b(BiomeGenBase[] p_35557_1_, int p_35557_2_, int p_35557_3_, int p_35557_4_, int p_35557_5_) {
      IntCache.func_35268_a();
      if(p_35557_1_ == null || p_35557_1_.length < p_35557_4_ * p_35557_5_) {
         p_35557_1_ = new BiomeGenBase[p_35557_4_ * p_35557_5_];
      }

      int[] var6 = this.field_34903_b.func_35500_a(p_35557_2_, p_35557_3_, p_35557_4_, p_35557_5_);

      for(int var7 = 0; var7 < p_35557_4_ * p_35557_5_; ++var7) {
         p_35557_1_[var7] = BiomeGenBase.field_35486_a[var6[var7]];
      }

      return p_35557_1_;
   }

   public BiomeGenBase[] func_4070_a(BiomeGenBase[] p_4070_1_, int p_4070_2_, int p_4070_3_, int p_4070_4_, int p_4070_5_) {
      return this.func_35555_a(p_4070_1_, p_4070_2_, p_4070_3_, p_4070_4_, p_4070_5_, true);
   }

   public BiomeGenBase[] func_35555_a(BiomeGenBase[] p_35555_1_, int p_35555_2_, int p_35555_3_, int p_35555_4_, int p_35555_5_, boolean p_35555_6_) {
      IntCache.func_35268_a();
      if(p_35555_1_ == null || p_35555_1_.length < p_35555_4_ * p_35555_5_) {
         p_35555_1_ = new BiomeGenBase[p_35555_4_ * p_35555_5_];
      }

      if(p_35555_6_ && p_35555_4_ == 16 && p_35555_5_ == 16 && (p_35555_2_ & 15) == 0 && (p_35555_3_ & 15) == 0) {
         BiomeGenBase[] var9 = this.field_35563_f.func_35723_d(p_35555_2_, p_35555_3_);
         System.arraycopy(var9, 0, p_35555_1_, 0, p_35555_4_ * p_35555_5_);
         return p_35555_1_;
      } else {
         int[] var7 = this.field_34902_c.func_35500_a(p_35555_2_, p_35555_3_, p_35555_4_, p_35555_5_);

         for(int var8 = 0; var8 < p_35555_4_ * p_35555_5_; ++var8) {
            p_35555_1_[var8] = BiomeGenBase.field_35486_a[var7[var8]];
         }

         return p_35555_1_;
      }
   }

   public boolean func_35562_a(int p_35562_1_, int p_35562_2_, int p_35562_3_, List p_35562_4_) {
      int var5 = p_35562_1_ - p_35562_3_ >> 2;
      int var6 = p_35562_2_ - p_35562_3_ >> 2;
      int var7 = p_35562_1_ + p_35562_3_ >> 2;
      int var8 = p_35562_2_ + p_35562_3_ >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.field_34903_b.func_35500_a(var5, var6, var9, var10);

      for(int var12 = 0; var12 < var9 * var10; ++var12) {
         BiomeGenBase var13 = BiomeGenBase.field_35486_a[var11[var12]];
         if(!p_35562_4_.contains(var13)) {
            return false;
         }
      }

      return true;
   }

   public ChunkPosition func_35556_a(int p_35556_1_, int p_35556_2_, int p_35556_3_, List p_35556_4_, Random p_35556_5_) {
      int var6 = p_35556_1_ - p_35556_3_ >> 2;
      int var7 = p_35556_2_ - p_35556_3_ >> 2;
      int var8 = p_35556_1_ + p_35556_3_ >> 2;
      int var9 = p_35556_2_ + p_35556_3_ >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.field_34903_b.func_35500_a(var6, var7, var10, var11);
      ChunkPosition var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var12.length; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         BiomeGenBase var18 = BiomeGenBase.field_35486_a[var12[var15]];
         if(p_35556_4_.contains(var18) && (var13 == null || p_35556_5_.nextInt(var14 + 1) == 0)) {
            var13 = new ChunkPosition(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }

   public void func_35561_b() {
      this.field_35563_f.func_35724_a();
   }
}
