package net.minecraft.src;

import net.minecraft.src.EntityAISit;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityTameable extends EntityAnimal {

   protected EntityAISit field_48146_a = new EntityAISit(this);


   public EntityTameable(World p_i1082_1_) {
      super(p_i1082_1_);
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
      this.field_21064_bx.func_21124_a(17, "");
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      if(this.func_48145_ag() == null) {
         p_352_1_.func_754_a("Owner", "");
      } else {
         p_352_1_.func_754_a("Owner", this.func_48145_ag());
      }

      p_352_1_.func_748_a("Sitting", this.func_48141_af());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      String var2 = p_357_1_.func_755_i("Owner");
      if(var2.length() > 0) {
         this.func_48143_a(var2);
         this.func_48138_b(true);
      }

      this.field_48146_a.func_48407_a(p_357_1_.func_760_m("Sitting"));
   }

   protected void func_48142_a(boolean p_48142_1_) {
      String var2 = "heart";
      if(!p_48142_1_) {
         var2 = "smoke";
      }

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
         double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
         double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
         this.field_615_ag.func_694_a(var2, this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + 0.5D + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var4, var6, var8);
      }

   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 7) {
         this.func_48142_a(true);
      } else if(p_9282_1_ == 6) {
         this.func_48142_a(false);
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   public boolean func_48139_F_() {
      return (this.field_21064_bx.func_21130_a(16) & 4) != 0;
   }

   public void func_48138_b(boolean p_48138_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_48138_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 | 4)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & -5)));
      }

   }

   public boolean func_48141_af() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   public void func_48140_f(boolean p_48140_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_48140_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public String func_48145_ag() {
      return this.field_21064_bx.func_25116_c(17);
   }

   public void func_48143_a(String p_48143_1_) {
      this.field_21064_bx.func_21129_b(17, p_48143_1_);
   }

   public EntityLiving func_48144_ah() {
      return this.field_615_ag.func_25099_a(this.func_48145_ag());
   }

   public EntityAISit func_50008_ai() {
      return this.field_48146_a;
   }
}
