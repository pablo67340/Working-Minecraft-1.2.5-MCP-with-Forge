package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityOtherPlayerMP extends EntityPlayer {

   private boolean field_35218_b = false;
   private int field_785_bg;
   private double field_784_bh;
   private double field_783_bi;
   private double field_782_bj;
   private double field_780_bk;
   private double field_786_bl;


   public EntityOtherPlayerMP(World p_i580_1_, String p_i580_2_) {
      super(p_i580_1_);
      this.field_771_i = p_i580_2_;
      this.field_9292_aO = 0.0F;
      this.field_9286_aZ = 0.0F;
      if(p_i580_2_ != null && p_i580_2_.length() > 0) {
         this.field_20047_bv = "http://s3.amazonaws.com/MinecraftSkins/" + p_i580_2_ + ".png";
      }

      this.field_9314_ba = true;
      this.field_22062_y = 0.25F;
      this.field_619_ac = 10.0D;
   }

   protected void func_22058_C() {
      this.field_9292_aO = 0.0F;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return true;
   }

   public void func_378_a(double p_378_1_, double p_378_3_, double p_378_5_, float p_378_7_, float p_378_8_, int p_378_9_) {
      this.field_784_bh = p_378_1_;
      this.field_783_bi = p_378_3_;
      this.field_782_bj = p_378_5_;
      this.field_780_bk = (double)p_378_7_;
      this.field_786_bl = (double)p_378_8_;
      this.field_785_bg = p_378_9_;
   }

   public void func_370_e_() {
      this.field_22062_y = 0.0F;
      super.func_370_e_();
      this.field_705_Q = this.field_704_R;
      double var1 = this.field_611_ak - this.field_9285_at;
      double var3 = this.field_609_am - this.field_9283_av;
      float var5 = MathHelper.func_1109_a(var1 * var1 + var3 * var3) * 4.0F;
      if(var5 > 1.0F) {
         var5 = 1.0F;
      }

      this.field_704_R += (var5 - this.field_704_R) * 0.4F;
      this.field_703_S += this.field_704_R;
      if(!this.field_35218_b && this.func_35114_R() && this.field_778_b.field_843_a[this.field_778_b.field_847_d] != null) {
         ItemStack var6 = this.field_778_b.field_843_a[this.field_778_b.field_847_d];
         this.func_35199_b(this.field_778_b.field_843_a[this.field_778_b.field_847_d], Item.field_233_c[var6.field_1617_c].func_35411_c(var6));
         this.field_35218_b = true;
      } else if(this.field_35218_b && !this.func_35114_R()) {
         this.func_35207_ac();
         this.field_35218_b = false;
      }

   }

   public float func_392_h_() {
      return 0.0F;
   }

   public void func_425_j() {
      super.func_418_b_();
      if(this.field_785_bg > 0) {
         double var1 = this.field_611_ak + (this.field_784_bh - this.field_611_ak) / (double)this.field_785_bg;
         double var3 = this.field_610_al + (this.field_783_bi - this.field_610_al) / (double)this.field_785_bg;
         double var5 = this.field_609_am + (this.field_782_bj - this.field_609_am) / (double)this.field_785_bg;

         double var7;
         for(var7 = this.field_780_bk - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
            ;
         }

         while(var7 >= 180.0D) {
            var7 -= 360.0D;
         }

         this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_785_bg);
         this.field_604_ar = (float)((double)this.field_604_ar + (this.field_786_bl - (double)this.field_604_ar) / (double)this.field_785_bg);
         --this.field_785_bg;
         this.func_347_a(var1, var3, var5);
         this.func_376_c(this.field_605_aq, this.field_604_ar);
      }

      this.field_775_e = this.field_774_f;
      float var9 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
      float var2 = (float)Math.atan(-this.field_607_ao * 0.20000000298023224D) * 15.0F;
      if(var9 > 0.1F) {
         var9 = 0.1F;
      }

      if(!this.field_9298_aH || this.func_40114_aH() <= 0) {
         var9 = 0.0F;
      }

      if(this.field_9298_aH || this.func_40114_aH() <= 0) {
         var2 = 0.0F;
      }

      this.field_774_f += (var9 - this.field_774_f) * 0.4F;
      this.field_9328_R += (var2 - this.field_9328_R) * 0.8F;
   }

   public void func_20045_c(int p_20045_1_, int p_20045_2_, int p_20045_3_) {
      ItemStack var4 = null;
      if(p_20045_2_ >= 0) {
         var4 = new ItemStack(p_20045_2_, 1, p_20045_3_);
      }

      if(p_20045_1_ == 0) {
         this.field_778_b.field_843_a[this.field_778_b.field_847_d] = var4;
      } else {
         this.field_778_b.field_842_b[p_20045_1_ - 1] = var4;
      }

   }

   public void func_6420_o() {}

   public float func_373_s() {
      return 1.82F;
   }
}
