package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ActiveRenderInfo;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDiggingFX;
import net.minecraft.src.EntityFX;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {

   protected World field_1729_a;
   private List[] field_1728_b = new List[4];
   private RenderEngine field_1731_c;
   private Random field_1730_d = new Random();


   public EffectRenderer(World p_i275_1_, RenderEngine p_i275_2_) {
      if(p_i275_1_ != null) {
         this.field_1729_a = p_i275_1_;
      }

      this.field_1731_c = p_i275_2_;

      for(int var3 = 0; var3 < 4; ++var3) {
         this.field_1728_b[var3] = new ArrayList();
      }

   }

   public void func_1192_a(EntityFX p_1192_1_) {
      int var2 = p_1192_1_.func_404_c();
      if(this.field_1728_b[var2].size() >= 4000) {
         this.field_1728_b[var2].remove(0);
      }

      this.field_1728_b[var2].add(p_1192_1_);
   }

   public void func_1193_a() {
      for(int var1 = 0; var1 < 4; ++var1) {
         for(int var2 = 0; var2 < this.field_1728_b[var1].size(); ++var2) {
            EntityFX var3 = (EntityFX)this.field_1728_b[var1].get(var2);
            var3.func_370_e_();
            if(var3.field_646_aA) {
               this.field_1728_b[var1].remove(var2--);
            }
         }
      }

   }

   public void func_1189_a(Entity p_1189_1_, float p_1189_2_) {
      float var3 = ActiveRenderInfo.field_41070_d;
      float var4 = ActiveRenderInfo.field_41068_f;
      float var5 = ActiveRenderInfo.field_41069_g;
      float var6 = ActiveRenderInfo.field_41078_h;
      float var7 = ActiveRenderInfo.field_41071_e;
      EntityFX.field_660_l = p_1189_1_.field_638_aI + (p_1189_1_.field_611_ak - p_1189_1_.field_638_aI) * (double)p_1189_2_;
      EntityFX.field_659_m = p_1189_1_.field_637_aJ + (p_1189_1_.field_610_al - p_1189_1_.field_637_aJ) * (double)p_1189_2_;
      EntityFX.field_658_n = p_1189_1_.field_636_aK + (p_1189_1_.field_609_am - p_1189_1_.field_636_aK) * (double)p_1189_2_;

      for(int var8 = 0; var8 < 3; ++var8) {
         if(this.field_1728_b[var8].size() != 0) {
            int var9 = 0;
            if(var8 == 0) {
               var9 = this.field_1731_c.func_1070_a("/particles.png");
            }

            if(var8 == 1) {
               var9 = this.field_1731_c.func_1070_a("/terrain.png");
            }

            if(var8 == 2) {
               var9 = this.field_1731_c.func_1070_a("/gui/items.png");
            }

            GL11.glBindTexture(3553, var9);
            Tessellator var10 = Tessellator.field_1512_a;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            var10.func_977_b();

            for(int var11 = 0; var11 < this.field_1728_b[var8].size(); ++var11) {
               EntityFX var12 = (EntityFX)this.field_1728_b[var8].get(var11);
               var10.func_35835_b(var12.func_35115_a(p_1189_2_));
               var12.func_406_a(var10, p_1189_2_, var3, var7, var4, var5, var6);
            }

            var10.func_982_a();
         }
      }

   }

   public void func_1187_b(Entity p_1187_1_, float p_1187_2_) {
      float var4 = MathHelper.func_1114_b(p_1187_1_.field_605_aq * 0.017453292F);
      float var5 = MathHelper.func_1106_a(p_1187_1_.field_605_aq * 0.017453292F);
      float var6 = -var5 * MathHelper.func_1106_a(p_1187_1_.field_604_ar * 0.017453292F);
      float var7 = var4 * MathHelper.func_1106_a(p_1187_1_.field_604_ar * 0.017453292F);
      float var8 = MathHelper.func_1114_b(p_1187_1_.field_604_ar * 0.017453292F);
      byte var9 = 3;
      if(this.field_1728_b[var9].size() != 0) {
         Tessellator var10 = Tessellator.field_1512_a;

         for(int var11 = 0; var11 < this.field_1728_b[var9].size(); ++var11) {
            EntityFX var12 = (EntityFX)this.field_1728_b[var9].get(var11);
            var10.func_35835_b(var12.func_35115_a(p_1187_2_));
            var12.func_406_a(var10, p_1187_2_, var4, var8, var5, var6, var7);
         }

      }
   }

   public void func_1188_a(World p_1188_1_) {
      this.field_1729_a = p_1188_1_;

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_1728_b[var2].clear();
      }

   }

   public void func_1186_a(int p_1186_1_, int p_1186_2_, int p_1186_3_, int p_1186_4_, int p_1186_5_) {
      if(p_1186_4_ != 0) {
         Block var6 = Block.field_345_n[p_1186_4_];
         byte var7 = 4;

         for(int var8 = 0; var8 < var7; ++var8) {
            for(int var9 = 0; var9 < var7; ++var9) {
               for(int var10 = 0; var10 < var7; ++var10) {
                  double var11 = (double)p_1186_1_ + ((double)var8 + 0.5D) / (double)var7;
                  double var13 = (double)p_1186_2_ + ((double)var9 + 0.5D) / (double)var7;
                  double var15 = (double)p_1186_3_ + ((double)var10 + 0.5D) / (double)var7;
                  int var17 = this.field_1730_d.nextInt(6);
                  this.func_1192_a((new EntityDiggingFX(this.field_1729_a, var11, var13, var15, var11 - (double)p_1186_1_ - 0.5D, var13 - (double)p_1186_2_ - 0.5D, var15 - (double)p_1186_3_ - 0.5D, var6, var17, p_1186_5_)).func_4041_a(p_1186_1_, p_1186_2_, p_1186_3_));
               }
            }
         }

      }
   }

   public void func_1191_a(int p_1191_1_, int p_1191_2_, int p_1191_3_, int p_1191_4_) {
      int var5 = this.field_1729_a.func_600_a(p_1191_1_, p_1191_2_, p_1191_3_);
      if(var5 != 0) {
         Block var6 = Block.field_345_n[var5];
         float var7 = 0.1F;
         double var8 = (double)p_1191_1_ + this.field_1730_d.nextDouble() * (var6.field_364_bi - var6.field_370_bf - (double)(var7 * 2.0F)) + (double)var7 + var6.field_370_bf;
         double var10 = (double)p_1191_2_ + this.field_1730_d.nextDouble() * (var6.field_362_bj - var6.field_368_bg - (double)(var7 * 2.0F)) + (double)var7 + var6.field_368_bg;
         double var12 = (double)p_1191_3_ + this.field_1730_d.nextDouble() * (var6.field_360_bk - var6.field_366_bh - (double)(var7 * 2.0F)) + (double)var7 + var6.field_366_bh;
         if(p_1191_4_ == 0) {
            var10 = (double)p_1191_2_ + var6.field_368_bg - (double)var7;
         }

         if(p_1191_4_ == 1) {
            var10 = (double)p_1191_2_ + var6.field_362_bj + (double)var7;
         }

         if(p_1191_4_ == 2) {
            var12 = (double)p_1191_3_ + var6.field_366_bh - (double)var7;
         }

         if(p_1191_4_ == 3) {
            var12 = (double)p_1191_3_ + var6.field_360_bk + (double)var7;
         }

         if(p_1191_4_ == 4) {
            var8 = (double)p_1191_1_ + var6.field_370_bf - (double)var7;
         }

         if(p_1191_4_ == 5) {
            var8 = (double)p_1191_1_ + var6.field_364_bi + (double)var7;
         }

         this.func_1192_a((new EntityDiggingFX(this.field_1729_a, var8, var10, var12, 0.0D, 0.0D, 0.0D, var6, p_1191_4_, this.field_1729_a.func_602_e(p_1191_1_, p_1191_2_, p_1191_3_))).func_4041_a(p_1191_1_, p_1191_2_, p_1191_3_).func_407_b(0.2F).func_405_d(0.6F));
      }
   }

   public String func_1190_b() {
      return "" + (this.field_1728_b[0].size() + this.field_1728_b[1].size() + this.field_1728_b[2].size());
   }
}
