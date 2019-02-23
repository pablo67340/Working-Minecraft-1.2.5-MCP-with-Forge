package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityXPOrb extends Entity {

   public int field_35127_a;
   public int field_35124_b = 0;
   public int field_35126_c;
   private int field_35123_e = 5;
   private int field_35125_ap;


   public EntityXPOrb(World p_i255_1_, double p_i255_2_, double p_i255_4_, double p_i255_6_, int p_i255_8_) {
      super(p_i255_1_);
      this.func_371_a(0.5F, 0.5F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
      this.func_347_a(p_i255_2_, p_i255_4_, p_i255_6_);
      this.field_605_aq = (float)(Math.random() * 360.0D);
      this.field_608_an = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_607_ao = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.field_606_ap = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.field_35125_ap = p_i255_8_;
   }

   protected boolean func_25021_m() {
      return false;
   }

   public EntityXPOrb(World p_i256_1_) {
      super(p_i256_1_);
      this.func_371_a(0.25F, 0.25F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
   }

   protected void func_21057_b() {}

   public int func_35115_a(float p_35115_1_) {
      float var2 = 0.5F;
      if(var2 < 0.0F) {
         var2 = 0.0F;
      }

      if(var2 > 1.0F) {
         var2 = 1.0F;
      }

      int var3 = super.func_35115_a(p_35115_1_);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if(var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public void func_370_e_() {
      super.func_370_e_();
      if(this.field_35126_c > 0) {
         --this.field_35126_c;
      }

      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.field_607_ao -= 0.029999999329447746D;
      if(this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) == Material.field_1331_g) {
         this.field_607_ao = 0.20000000298023224D;
         this.field_608_an = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
         this.field_606_ap = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
         this.field_615_ag.func_623_a(this, "random.fizz", 0.4F, 2.0F + this.field_9312_bd.nextFloat() * 0.4F);
      }

      this.func_28014_c(this.field_611_ak, (this.field_601_au.field_1697_b + this.field_601_au.field_1702_e) / 2.0D, this.field_609_am);
      double var1 = 8.0D;
      EntityPlayer var3 = this.field_615_ag.func_609_a(this, var1);
      if(var3 != null) {
         double var4 = (var3.field_611_ak - this.field_611_ak) / var1;
         double var6 = (var3.field_610_al + (double)var3.func_373_s() - this.field_610_al) / var1;
         double var8 = (var3.field_609_am - this.field_609_am) / var1;
         double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
         double var12 = 1.0D - var10;
         if(var12 > 0.0D) {
            var12 *= var12;
            this.field_608_an += var4 / var10 * var12 * 0.1D;
            this.field_607_ao += var6 / var10 * var12 * 0.1D;
            this.field_606_ap += var8 / var10 * var12 * 0.1D;
         }
      }

      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      float var14 = 0.98F;
      if(this.field_9298_aH) {
         var14 = 0.58800006F;
         int var5 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
         if(var5 > 0) {
            var14 = Block.field_345_n[var5].field_355_bo * 0.98F;
         }
      }

      this.field_608_an *= (double)var14;
      this.field_607_ao *= 0.9800000190734863D;
      this.field_606_ap *= (double)var14;
      if(this.field_9298_aH) {
         this.field_607_ao *= -0.8999999761581421D;
      }

      ++this.field_35127_a;
      ++this.field_35124_b;
      if(this.field_35124_b >= 6000) {
         this.func_395_F();
      }

   }

   public boolean func_397_g_() {
      return this.field_615_ag.func_682_a(this.field_601_au, Material.field_1332_f, this);
   }

   protected void func_355_a(int p_355_1_) {
      this.func_396_a(DamageSource.field_35542_a, p_355_1_);
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.func_9281_M();
      this.field_35123_e -= p_396_2_;
      if(this.field_35123_e <= 0) {
         this.func_395_F();
      }

      return false;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("Health", (short)((byte)this.field_35123_e));
      p_352_1_.func_749_a("Age", (short)this.field_35124_b);
      p_352_1_.func_749_a("Value", (short)this.field_35125_ap);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_35123_e = p_357_1_.func_745_d("Health") & 255;
      this.field_35124_b = p_357_1_.func_745_d("Age");
      this.field_35125_ap = p_357_1_.func_745_d("Value");
   }

   public void func_6378_b(EntityPlayer p_6378_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(this.field_35126_c == 0 && p_6378_1_.field_35214_aG == 0) {
            p_6378_1_.field_35214_aG = 2;
            this.field_615_ag.func_623_a(this, "random.orb", 0.1F, 0.5F * ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.8F));
            p_6378_1_.func_443_a_(this, 1);
            p_6378_1_.func_35204_c(this.field_35125_ap);
            this.func_395_F();
         }

      }
   }

   public int func_35119_j_() {
      return this.field_35125_ap;
   }

   public int func_35120_i() {
      return this.field_35125_ap >= 2477?10:(this.field_35125_ap >= 1237?9:(this.field_35125_ap >= 617?8:(this.field_35125_ap >= 307?7:(this.field_35125_ap >= 149?6:(this.field_35125_ap >= 73?5:(this.field_35125_ap >= 37?4:(this.field_35125_ap >= 17?3:(this.field_35125_ap >= 7?2:(this.field_35125_ap >= 3?1:0)))))))));
   }

   public static int func_35121_b(int p_35121_0_) {
      return p_35121_0_ >= 2477?2477:(p_35121_0_ >= 1237?1237:(p_35121_0_ >= 617?617:(p_35121_0_ >= 307?307:(p_35121_0_ >= 149?149:(p_35121_0_ >= 73?73:(p_35121_0_ >= 37?37:(p_35121_0_ >= 17?17:(p_35121_0_ >= 7?7:(p_35121_0_ >= 3?3:1)))))))));
   }

   public boolean func_48080_j() {
      return false;
   }
}
