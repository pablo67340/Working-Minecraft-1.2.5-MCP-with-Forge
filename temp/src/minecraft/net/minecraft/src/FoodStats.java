package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemFood;
import net.minecraft.src.NBTTagCompound;

public class FoodStats {

   private int field_35776_a = 20;
   private float field_35774_b = 5.0F;
   private float field_35775_c;
   private int field_35772_d = 0;
   private int field_35773_e = 20;


   public void func_35771_a(int p_35771_1_, float p_35771_2_) {
      this.field_35776_a = Math.min(p_35771_1_ + this.field_35776_a, 20);
      this.field_35774_b = Math.min(this.field_35774_b + (float)p_35771_1_ * p_35771_2_ * 2.0F, (float)this.field_35776_a);
   }

   public void func_35761_a(ItemFood p_35761_1_) {
      this.func_35771_a(p_35761_1_.func_25011_l(), p_35761_1_.func_35426_m());
   }

   public void func_35768_a(EntityPlayer p_35768_1_) {
      int var2 = p_35768_1_.field_615_ag.field_1039_l;
      this.field_35773_e = this.field_35776_a;
      if(this.field_35775_c > 4.0F) {
         this.field_35775_c -= 4.0F;
         if(this.field_35774_b > 0.0F) {
            this.field_35774_b = Math.max(this.field_35774_b - 1.0F, 0.0F);
         } else if(var2 > 0) {
            this.field_35776_a = Math.max(this.field_35776_a - 1, 0);
         }
      }

      if(this.field_35776_a >= 18 && p_35768_1_.func_35194_au()) {
         ++this.field_35772_d;
         if(this.field_35772_d >= 80) {
            p_35768_1_.func_432_b(1);
            this.field_35772_d = 0;
         }
      } else if(this.field_35776_a <= 0) {
         ++this.field_35772_d;
         if(this.field_35772_d >= 80) {
            if(p_35768_1_.func_40114_aH() > 10 || var2 >= 3 || p_35768_1_.func_40114_aH() > 1 && var2 >= 2) {
               p_35768_1_.func_396_a(DamageSource.field_35536_f, 1);
            }

            this.field_35772_d = 0;
         }
      } else {
         this.field_35772_d = 0;
      }

   }

   public void func_35766_a(NBTTagCompound p_35766_1_) {
      if(p_35766_1_.func_751_b("foodLevel")) {
         this.field_35776_a = p_35766_1_.func_756_e("foodLevel");
         this.field_35772_d = p_35766_1_.func_756_e("foodTickTimer");
         this.field_35774_b = p_35766_1_.func_752_g("foodSaturationLevel");
         this.field_35775_c = p_35766_1_.func_752_g("foodExhaustionLevel");
      }

   }

   public void func_35763_b(NBTTagCompound p_35763_1_) {
      p_35763_1_.func_758_a("foodLevel", this.field_35776_a);
      p_35763_1_.func_758_a("foodTickTimer", this.field_35772_d);
      p_35763_1_.func_744_a("foodSaturationLevel", this.field_35774_b);
      p_35763_1_.func_744_a("foodExhaustionLevel", this.field_35775_c);
   }

   public int func_35765_a() {
      return this.field_35776_a;
   }

   public int func_35769_b() {
      return this.field_35773_e;
   }

   public boolean func_35770_c() {
      return this.field_35776_a < 20;
   }

   public void func_35762_a(float p_35762_1_) {
      this.field_35775_c = Math.min(this.field_35775_c + p_35762_1_, 40.0F);
   }

   public float func_35760_d() {
      return this.field_35774_b;
   }

   public void func_35764_a(int p_35764_1_) {
      this.field_35776_a = p_35764_1_;
   }

   public void func_35767_b(float p_35767_1_) {
      this.field_35774_b = p_35767_1_;
   }
}
