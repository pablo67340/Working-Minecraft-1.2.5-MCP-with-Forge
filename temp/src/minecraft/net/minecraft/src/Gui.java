package net.minecraft.src;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class Gui {

   protected float field_923_k = 0.0F;


   protected void func_27100_a(int p_27100_1_, int p_27100_2_, int p_27100_3_, int p_27100_4_) {
      if(p_27100_2_ < p_27100_1_) {
         int var5 = p_27100_1_;
         p_27100_1_ = p_27100_2_;
         p_27100_2_ = var5;
      }

      func_551_a(p_27100_1_, p_27100_3_, p_27100_2_ + 1, p_27100_3_ + 1, p_27100_4_);
   }

   protected void func_27099_b(int p_27099_1_, int p_27099_2_, int p_27099_3_, int p_27099_4_) {
      if(p_27099_3_ < p_27099_2_) {
         int var5 = p_27099_2_;
         p_27099_2_ = p_27099_3_;
         p_27099_3_ = var5;
      }

      func_551_a(p_27099_1_, p_27099_2_ + 1, p_27099_1_ + 1, p_27099_3_, p_27099_4_);
   }

   public static void func_551_a(int p_551_1_, int p_551_2_, int p_551_3_, int p_551_4_, int p_551_5_) {
      int var5;
      if(p_551_1_ < p_551_3_) {
         var5 = p_551_1_;
         p_551_1_ = p_551_3_;
         p_551_3_ = var5;
      }

      if(p_551_2_ < p_551_4_) {
         var5 = p_551_2_;
         p_551_2_ = p_551_4_;
         p_551_4_ = var5;
      }

      float var10 = (float)(p_551_5_ >> 24 & 255) / 255.0F;
      float var6 = (float)(p_551_5_ >> 16 & 255) / 255.0F;
      float var7 = (float)(p_551_5_ >> 8 & 255) / 255.0F;
      float var8 = (float)(p_551_5_ & 255) / 255.0F;
      Tessellator var9 = Tessellator.field_1512_a;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var6, var7, var8, var10);
      var9.func_977_b();
      var9.func_991_a((double)p_551_1_, (double)p_551_4_, 0.0D);
      var9.func_991_a((double)p_551_3_, (double)p_551_4_, 0.0D);
      var9.func_991_a((double)p_551_3_, (double)p_551_2_, 0.0D);
      var9.func_991_a((double)p_551_1_, (double)p_551_2_, 0.0D);
      var9.func_982_a();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   protected void func_549_a(int p_549_1_, int p_549_2_, int p_549_3_, int p_549_4_, int p_549_5_, int p_549_6_) {
      float var7 = (float)(p_549_5_ >> 24 & 255) / 255.0F;
      float var8 = (float)(p_549_5_ >> 16 & 255) / 255.0F;
      float var9 = (float)(p_549_5_ >> 8 & 255) / 255.0F;
      float var10 = (float)(p_549_5_ & 255) / 255.0F;
      float var11 = (float)(p_549_6_ >> 24 & 255) / 255.0F;
      float var12 = (float)(p_549_6_ >> 16 & 255) / 255.0F;
      float var13 = (float)(p_549_6_ >> 8 & 255) / 255.0F;
      float var14 = (float)(p_549_6_ & 255) / 255.0F;
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glDisable(3008);
      GL11.glBlendFunc(770, 771);
      GL11.glShadeModel(7425);
      Tessellator var15 = Tessellator.field_1512_a;
      var15.func_977_b();
      var15.func_986_a(var8, var9, var10, var7);
      var15.func_991_a((double)p_549_3_, (double)p_549_2_, (double)this.field_923_k);
      var15.func_991_a((double)p_549_1_, (double)p_549_2_, (double)this.field_923_k);
      var15.func_986_a(var12, var13, var14, var11);
      var15.func_991_a((double)p_549_1_, (double)p_549_4_, (double)this.field_923_k);
      var15.func_991_a((double)p_549_3_, (double)p_549_4_, (double)this.field_923_k);
      var15.func_982_a();
      GL11.glShadeModel(7424);
      GL11.glDisable(3042);
      GL11.glEnable(3008);
      GL11.glEnable(3553);
   }

   public void func_548_a(FontRenderer p_548_1_, String p_548_2_, int p_548_3_, int p_548_4_, int p_548_5_) {
      p_548_1_.func_50103_a(p_548_2_, p_548_3_ - p_548_1_.func_871_a(p_548_2_) / 2, p_548_4_, p_548_5_);
   }

   public void func_547_b(FontRenderer p_547_1_, String p_547_2_, int p_547_3_, int p_547_4_, int p_547_5_) {
      p_547_1_.func_50103_a(p_547_2_, p_547_3_, p_547_4_, p_547_5_);
   }

   public void func_550_b(int p_550_1_, int p_550_2_, int p_550_3_, int p_550_4_, int p_550_5_, int p_550_6_) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.field_1512_a;
      var9.func_977_b();
      var9.func_983_a((double)(p_550_1_ + 0), (double)(p_550_2_ + p_550_6_), (double)this.field_923_k, (double)((float)(p_550_3_ + 0) * var7), (double)((float)(p_550_4_ + p_550_6_) * var8));
      var9.func_983_a((double)(p_550_1_ + p_550_5_), (double)(p_550_2_ + p_550_6_), (double)this.field_923_k, (double)((float)(p_550_3_ + p_550_5_) * var7), (double)((float)(p_550_4_ + p_550_6_) * var8));
      var9.func_983_a((double)(p_550_1_ + p_550_5_), (double)(p_550_2_ + 0), (double)this.field_923_k, (double)((float)(p_550_3_ + p_550_5_) * var7), (double)((float)(p_550_4_ + 0) * var8));
      var9.func_983_a((double)(p_550_1_ + 0), (double)(p_550_2_ + 0), (double)this.field_923_k, (double)((float)(p_550_3_ + 0) * var7), (double)((float)(p_550_4_ + 0) * var8));
      var9.func_982_a();
   }
}
