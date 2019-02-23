package net.minecraft.src;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ActiveRenderInfo {

   public static float field_41074_a = 0.0F;
   public static float field_41072_b = 0.0F;
   public static float field_41073_c = 0.0F;
   private static IntBuffer field_41079_i = GLAllocation.func_1125_c(16);
   private static FloatBuffer field_41076_j = GLAllocation.func_1123_d(16);
   private static FloatBuffer field_41077_k = GLAllocation.func_1123_d(16);
   private static FloatBuffer field_41075_l = GLAllocation.func_1123_d(3);
   public static float field_41070_d;
   public static float field_41071_e;
   public static float field_41068_f;
   public static float field_41069_g;
   public static float field_41078_h;


   public static void func_41067_a(EntityPlayer p_41067_0_, boolean p_41067_1_) {
      GL11.glGetFloat(2982, field_41076_j);
      GL11.glGetFloat(2983, field_41077_k);
      GL11.glGetInteger(2978, field_41079_i);
      float var2 = (float)((field_41079_i.get(0) + field_41079_i.get(2)) / 2);
      float var3 = (float)((field_41079_i.get(1) + field_41079_i.get(3)) / 2);
      GLU.gluUnProject(var2, var3, 0.0F, field_41076_j, field_41077_k, field_41079_i, field_41075_l);
      field_41074_a = field_41075_l.get(0);
      field_41072_b = field_41075_l.get(1);
      field_41073_c = field_41075_l.get(2);
      int var4 = p_41067_1_?1:0;
      float var5 = p_41067_0_.field_604_ar;
      float var6 = p_41067_0_.field_605_aq;
      field_41070_d = MathHelper.func_1114_b(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_41068_f = MathHelper.func_1106_a(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_41069_g = -field_41068_f * MathHelper.func_1106_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_41078_h = field_41070_d * MathHelper.func_1106_a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      field_41071_e = MathHelper.func_1114_b(var5 * 3.1415927F / 180.0F);
   }

   public static Vec3D func_41065_a(EntityLiving p_41065_0_, double p_41065_1_) {
      double var3 = p_41065_0_.field_9285_at + (p_41065_0_.field_611_ak - p_41065_0_.field_9285_at) * p_41065_1_;
      double var5 = p_41065_0_.field_9284_au + (p_41065_0_.field_610_al - p_41065_0_.field_9284_au) * p_41065_1_ + (double)p_41065_0_.func_373_s();
      double var7 = p_41065_0_.field_9283_av + (p_41065_0_.field_609_am - p_41065_0_.field_9283_av) * p_41065_1_;
      double var9 = var3 + (double)(field_41074_a * 1.0F);
      double var11 = var5 + (double)(field_41072_b * 1.0F);
      double var13 = var7 + (double)(field_41073_c * 1.0F);
      return Vec3D.func_1248_b(var9, var11, var13);
   }

   public static int func_41066_a(World p_41066_0_, EntityLiving p_41066_1_, float p_41066_2_) {
      Vec3D var3 = func_41065_a(p_41066_1_, (double)p_41066_2_);
      ChunkPosition var4 = new ChunkPosition(var3);
      int var5 = p_41066_0_.func_600_a(var4.field_1111_a, var4.field_1110_b, var4.field_1112_c);
      if(var5 != 0 && Block.field_345_n[var5].field_356_bn.func_879_d()) {
         float var6 = BlockFluid.func_288_b(p_41066_0_.func_602_e(var4.field_1111_a, var4.field_1110_b, var4.field_1112_c)) - 0.11111111F;
         float var7 = (float)(var4.field_1110_b + 1) - var6;
         if(var3.field_1775_b >= (double)var7) {
            var5 = p_41066_0_.func_600_a(var4.field_1111_a, var4.field_1110_b + 1, var4.field_1112_c);
         }
      }

      return var5;
   }

}
