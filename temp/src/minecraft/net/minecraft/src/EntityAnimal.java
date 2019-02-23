package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityAnimal extends EntityAgeable {

   private int field_39004_a;
   private int field_39005_b = 0;


   public EntityAnimal(World p_i239_1_) {
      super(p_i239_1_);
   }

   protected void func_48097_s_() {
      if(this.func_48123_at() != 0) {
         this.field_39004_a = 0;
      }

      super.func_48097_s_();
   }

   public void func_425_j() {
      super.func_425_j();
      if(this.func_48123_at() != 0) {
         this.field_39004_a = 0;
      }

      if(this.field_39004_a > 0) {
         --this.field_39004_a;
         String var1 = "heart";
         if(this.field_39004_a % 10 == 0) {
            double var2 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            this.field_615_ag.func_694_a(var1, this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var2, var4, var6);
         }
      } else {
         this.field_39005_b = 0;
      }

   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {
      if(p_437_1_ instanceof EntityPlayer) {
         if(p_437_2_ < 3.0F) {
            double var3 = p_437_1_.field_611_ak - this.field_611_ak;
            double var5 = p_437_1_.field_609_am - this.field_609_am;
            this.field_605_aq = (float)(Math.atan2(var5, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_750_g = true;
         }

         EntityPlayer var7 = (EntityPlayer)p_437_1_;
         if(var7.func_6416_v() == null || !this.func_40143_a(var7.func_6416_v())) {
            this.field_751_f = null;
         }
      } else if(p_437_1_ instanceof EntityAnimal) {
         EntityAnimal var8 = (EntityAnimal)p_437_1_;
         if(this.func_48123_at() > 0 && var8.func_48123_at() < 0) {
            if((double)p_437_2_ < 2.5D) {
               this.field_750_g = true;
            }
         } else if(this.field_39004_a > 0 && var8.field_39004_a > 0) {
            if(var8.field_751_f == null) {
               var8.field_751_f = this;
            }

            if(var8.field_751_f == this && (double)p_437_2_ < 3.5D) {
               ++var8.field_39004_a;
               ++this.field_39004_a;
               ++this.field_39005_b;
               if(this.field_39005_b % 4 == 0) {
                  this.field_615_ag.func_694_a("heart", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, 0.0D, 0.0D, 0.0D);
               }

               if(this.field_39005_b == 60) {
                  this.func_40144_b((EntityAnimal)p_437_1_);
               }
            } else {
               this.field_39005_b = 0;
            }
         } else {
            this.field_39005_b = 0;
            this.field_751_f = null;
         }
      }

   }

   private void func_40144_b(EntityAnimal p_40144_1_) {
      EntityAnimal var2 = this.func_40145_a(p_40144_1_);
      if(var2 != null) {
         this.func_48122_d(6000);
         p_40144_1_.func_48122_d(6000);
         this.field_39004_a = 0;
         this.field_39005_b = 0;
         this.field_751_f = null;
         p_40144_1_.field_751_f = null;
         p_40144_1_.field_39005_b = 0;
         p_40144_1_.field_39004_a = 0;
         var2.func_48122_d(-24000);
         var2.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
            this.field_615_ag.func_694_a("heart", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var4, var6, var8);
         }

         this.field_615_ag.func_674_a(var2);
      }

   }

   public abstract EntityAnimal func_40145_a(EntityAnimal var1);

   protected void func_28022_b(Entity p_28022_1_, float p_28022_2_) {}

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.field_35174_at = 60;
      this.field_751_f = null;
      this.field_39004_a = 0;
      return super.func_396_a(p_396_1_, p_396_2_);
   }

   public float func_439_a(int p_439_1_, int p_439_2_, int p_439_3_) {
      return this.field_615_ag.func_600_a(p_439_1_, p_439_2_ - 1, p_439_3_) == Block.field_337_v.field_376_bc?10.0F:this.field_615_ag.func_598_c(p_439_1_, p_439_2_, p_439_3_) - 0.5F;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("InLove", this.field_39004_a);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.field_39004_a = p_357_1_.func_756_e("InLove");
   }

   protected Entity func_438_i() {
      if(this.field_35174_at > 0) {
         return null;
      } else {
         float var1 = 8.0F;
         List var2;
         int var3;
         EntityAnimal var4;
         if(this.field_39004_a > 0) {
            var2 = this.field_615_ag.func_657_a(this.getClass(), this.field_601_au.func_1177_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = (EntityAnimal)var2.get(var3);
               if(var4 != this && var4.field_39004_a > 0) {
                  return var4;
               }
            }
         } else if(this.func_48123_at() == 0) {
            var2 = this.field_615_ag.func_657_a(EntityPlayer.class, this.field_601_au.func_1177_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               EntityPlayer var5 = (EntityPlayer)var2.get(var3);
               if(var5.func_6416_v() != null && this.func_40143_a(var5.func_6416_v())) {
                  return var5;
               }
            }
         } else if(this.func_48123_at() > 0) {
            var2 = this.field_615_ag.func_657_a(this.getClass(), this.field_601_au.func_1177_b((double)var1, (double)var1, (double)var1));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = (EntityAnimal)var2.get(var3);
               if(var4 != this && var4.func_48123_at() < 0) {
                  return var4;
               }
            }
         }

         return null;
      }
   }

   public boolean func_433_a() {
      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      return this.field_615_ag.func_600_a(var1, var2 - 1, var3) == Block.field_337_v.field_376_bc && this.field_615_ag.func_28104_m(var1, var2, var3) > 8 && super.func_433_a();
   }

   public int func_421_b() {
      return 120;
   }

   protected boolean func_25023_u() {
      return false;
   }

   protected int func_36001_a(EntityPlayer p_36001_1_) {
      return 1 + this.field_615_ag.field_1037_n.nextInt(3);
   }

   public boolean func_40143_a(ItemStack p_40143_1_) {
      return p_40143_1_.field_1617_c == Item.field_243_R.field_291_aS;
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(var2 != null && this.func_40143_a(var2) && this.func_48123_at() == 0) {
         if(!p_353_1_.field_35212_aW.field_35756_d) {
            --var2.field_1615_a;
            if(var2.field_1615_a <= 0) {
               p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, (ItemStack)null);
            }
         }

         this.field_39004_a = 600;
         this.field_751_f = null;

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
            this.field_615_ag.func_694_a("heart", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var4, var6, var8);
         }

         return true;
      } else {
         return super.func_353_a(p_353_1_);
      }
   }

   public boolean func_48136_o_() {
      return this.field_39004_a > 0;
   }

   public void func_48134_p_() {
      this.field_39004_a = 0;
   }

   public boolean func_48135_b(EntityAnimal p_48135_1_) {
      return p_48135_1_ == this?false:(p_48135_1_.getClass() != this.getClass()?false:this.func_48136_o_() && p_48135_1_.func_48136_o_());
   }
}
