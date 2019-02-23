package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;

public class RandomPositionGenerator {

   private static Vec3D field_48624_a = Vec3D.func_1260_a(0.0D, 0.0D, 0.0D);


   public static Vec3D func_48622_a(EntityCreature p_48622_0_, int p_48622_1_, int p_48622_2_) {
      return func_48621_c(p_48622_0_, p_48622_1_, p_48622_2_, (Vec3D)null);
   }

   public static Vec3D func_48620_a(EntityCreature p_48620_0_, int p_48620_1_, int p_48620_2_, Vec3D p_48620_3_) {
      field_48624_a.field_1776_a = p_48620_3_.field_1776_a - p_48620_0_.field_611_ak;
      field_48624_a.field_1775_b = p_48620_3_.field_1775_b - p_48620_0_.field_610_al;
      field_48624_a.field_1779_c = p_48620_3_.field_1779_c - p_48620_0_.field_609_am;
      return func_48621_c(p_48620_0_, p_48620_1_, p_48620_2_, field_48624_a);
   }

   public static Vec3D func_48623_b(EntityCreature p_48623_0_, int p_48623_1_, int p_48623_2_, Vec3D p_48623_3_) {
      field_48624_a.field_1776_a = p_48623_0_.field_611_ak - p_48623_3_.field_1776_a;
      field_48624_a.field_1775_b = p_48623_0_.field_610_al - p_48623_3_.field_1775_b;
      field_48624_a.field_1779_c = p_48623_0_.field_609_am - p_48623_3_.field_1779_c;
      return func_48621_c(p_48623_0_, p_48623_1_, p_48623_2_, field_48624_a);
   }

   private static Vec3D func_48621_c(EntityCreature p_48621_0_, int p_48621_1_, int p_48621_2_, Vec3D p_48621_3_) {
      Random var4 = p_48621_0_.func_46004_aK();
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      float var9 = -99999.0F;
      boolean var10;
      if(p_48621_0_.func_48087_aX()) {
         double var11 = p_48621_0_.func_48091_aU().func_27439_a(MathHelper.func_1108_b(p_48621_0_.field_611_ak), MathHelper.func_1108_b(p_48621_0_.field_610_al), MathHelper.func_1108_b(p_48621_0_.field_609_am)) + 4.0D;
         var10 = var11 < (double)(p_48621_0_.func_48099_aV() + (float)p_48621_1_);
      } else {
         var10 = false;
      }

      for(int var16 = 0; var16 < 10; ++var16) {
         int var12 = var4.nextInt(2 * p_48621_1_) - p_48621_1_;
         int var13 = var4.nextInt(2 * p_48621_2_) - p_48621_2_;
         int var14 = var4.nextInt(2 * p_48621_1_) - p_48621_1_;
         if(p_48621_3_ == null || (double)var12 * p_48621_3_.field_1776_a + (double)var14 * p_48621_3_.field_1779_c >= 0.0D) {
            var12 += MathHelper.func_1108_b(p_48621_0_.field_611_ak);
            var13 += MathHelper.func_1108_b(p_48621_0_.field_610_al);
            var14 += MathHelper.func_1108_b(p_48621_0_.field_609_am);
            if(!var10 || p_48621_0_.func_48096_f(var12, var13, var14)) {
               float var15 = p_48621_0_.func_439_a(var12, var13, var14);
               if(var15 > var9) {
                  var9 = var15;
                  var6 = var12;
                  var7 = var13;
                  var8 = var14;
                  var5 = true;
               }
            }
         }
      }

      if(var5) {
         return Vec3D.func_1248_b((double)var6, (double)var7, (double)var8);
      } else {
         return null;
      }
   }

}
