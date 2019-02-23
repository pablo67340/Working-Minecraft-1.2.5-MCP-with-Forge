package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class ItemBoat extends Item {

   public ItemBoat(int p_i160_1_) {
      super(p_i160_1_);
      this.field_290_aT = 1;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      float var4 = 1.0F;
      float var5 = p_193_3_.field_602_at + (p_193_3_.field_604_ar - p_193_3_.field_602_at) * var4;
      float var6 = p_193_3_.field_603_as + (p_193_3_.field_605_aq - p_193_3_.field_603_as) * var4;
      double var7 = p_193_3_.field_9285_at + (p_193_3_.field_611_ak - p_193_3_.field_9285_at) * (double)var4;
      double var9 = p_193_3_.field_9284_au + (p_193_3_.field_610_al - p_193_3_.field_9284_au) * (double)var4 + 1.62D - (double)p_193_3_.field_9292_aO;
      double var11 = p_193_3_.field_9283_av + (p_193_3_.field_609_am - p_193_3_.field_9283_av) * (double)var4;
      Vec3D var13 = Vec3D.func_1248_b(var7, var9, var11);
      float var14 = MathHelper.func_1114_b(-var6 * 0.017453292F - 3.1415927F);
      float var15 = MathHelper.func_1106_a(-var6 * 0.017453292F - 3.1415927F);
      float var16 = -MathHelper.func_1114_b(-var5 * 0.017453292F);
      float var17 = MathHelper.func_1106_a(-var5 * 0.017453292F);
      float var18 = var15 * var16;
      float var20 = var14 * var16;
      double var21 = 5.0D;
      Vec3D var23 = var13.func_1257_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
      MovingObjectPosition var24 = p_193_2_.func_642_a(var13, var23, true);
      if(var24 == null) {
         return p_193_1_;
      } else {
         Vec3D var25 = p_193_3_.func_430_f(var4);
         boolean var26 = false;
         float var27 = 1.0F;
         List var28 = p_193_2_.func_659_b(p_193_3_, p_193_3_.field_601_au.func_1170_a(var25.field_1776_a * var21, var25.field_1775_b * var21, var25.field_1779_c * var21).func_1177_b((double)var27, (double)var27, (double)var27));

         for(int var29 = 0; var29 < var28.size(); ++var29) {
            Entity var30 = (Entity)var28.get(var29);
            if(var30.func_401_c_()) {
               float var31 = var30.func_4035_j_();
               AxisAlignedBB var32 = var30.field_601_au.func_1177_b((double)var31, (double)var31, (double)var31);
               if(var32.func_4150_a(var13)) {
                  var26 = true;
               }
            }
         }

         if(var26) {
            return p_193_1_;
         } else {
            if(var24.field_1167_a == EnumMovingObjectType.TILE) {
               int var33 = var24.field_1166_b;
               int var34 = var24.field_1172_c;
               int var35 = var24.field_1171_d;
               if(!p_193_2_.field_1026_y) {
                  if(p_193_2_.func_600_a(var33, var34, var35) == Block.field_428_aT.field_376_bc) {
                     --var34;
                  }

                  p_193_2_.func_674_a(new EntityBoat(p_193_2_, (double)((float)var33 + 0.5F), (double)((float)var34 + 1.0F), (double)((float)var35 + 0.5F)));
               }

               if(!p_193_3_.field_35212_aW.field_35756_d) {
                  --p_193_1_.field_1615_a;
               }
            }

            return p_193_1_;
         }
      }
   }
}
