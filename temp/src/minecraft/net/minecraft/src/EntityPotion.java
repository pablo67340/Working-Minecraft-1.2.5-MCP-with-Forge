package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.Item;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class EntityPotion extends EntityThrowable {

   private int field_40089_d;


   public EntityPotion(World p_i243_1_) {
      super(p_i243_1_);
   }

   public EntityPotion(World p_i244_1_, EntityLiving p_i244_2_, int p_i244_3_) {
      super(p_i244_1_, p_i244_2_);
      this.field_40089_d = p_i244_3_;
   }

   public EntityPotion(World p_i245_1_, double p_i245_2_, double p_i245_4_, double p_i245_6_, int p_i245_8_) {
      super(p_i245_1_, p_i245_2_, p_i245_4_, p_i245_6_);
      this.field_40089_d = p_i245_8_;
   }

   protected float func_40075_e() {
      return 0.05F;
   }

   protected float func_40077_c() {
      return 0.5F;
   }

   protected float func_40074_d() {
      return -20.0F;
   }

   public int func_40088_g() {
      return this.field_40089_d;
   }

   protected void func_40078_a(MovingObjectPosition p_40078_1_) {
      if(!this.field_615_ag.field_1026_y) {
         List var2 = Item.field_40413_bs.func_40431_c_(this.field_40089_d);
         if(var2 != null && !var2.isEmpty()) {
            AxisAlignedBB var3 = this.field_601_au.func_1177_b(4.0D, 2.0D, 4.0D);
            List var4 = this.field_615_ag.func_657_a(EntityLiving.class, var3);
            if(var4 != null && !var4.isEmpty()) {
               Iterator var5 = var4.iterator();

               while(var5.hasNext()) {
                  Entity var6 = (Entity)var5.next();
                  double var7 = this.func_387_e(var6);
                  if(var7 < 16.0D) {
                     double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
                     if(var6 == p_40078_1_.field_1168_g) {
                        var9 = 1.0D;
                     }

                     Iterator var11 = var2.iterator();

                     while(var11.hasNext()) {
                        PotionEffect var12 = (PotionEffect)var11.next();
                        int var13 = var12.func_35799_a();
                        if(Potion.field_35678_a[var13].func_40622_b()) {
                           Potion.field_35678_a[var13].func_40613_a(this.field_40083_c, (EntityLiving)var6, var12.func_35801_c(), var9);
                        } else {
                           int var14 = (int)(var9 * (double)var12.func_35802_b() + 0.5D);
                           if(var14 > 20) {
                              ((EntityLiving)var6).func_35165_a(new PotionEffect(var13, var14, var12.func_35801_c()));
                           }
                        }
                     }
                  }
               }
            }
         }

         this.field_615_ag.func_28106_e(2002, (int)Math.round(this.field_611_ak), (int)Math.round(this.field_610_al), (int)Math.round(this.field_609_am), this.field_40089_d);
         this.func_395_F();
      }

   }
}
