package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.PotionHealth;

public class Potion {

   public static final Potion[] field_35678_a = new Potion[32];
   public static final Potion field_35676_b = null;
   public static final Potion field_35677_c = (new Potion(1, false, 8171462)).func_35661_a("potion.moveSpeed").func_40618_a(0, 0);
   public static final Potion field_35674_d = (new Potion(2, true, 5926017)).func_35661_a("potion.moveSlowdown").func_40618_a(1, 0);
   public static final Potion field_35675_e = (new Potion(3, false, 14270531)).func_35661_a("potion.digSpeed").func_40618_a(2, 0).func_40614_a(1.5D);
   public static final Potion field_35672_f = (new Potion(4, true, 4866583)).func_35661_a("potion.digSlowDown").func_40618_a(3, 0);
   public static final Potion field_35673_g = (new Potion(5, false, 9643043)).func_35661_a("potion.damageBoost").func_40618_a(4, 0);
   public static final Potion field_35685_h = (new PotionHealth(6, false, 16262179)).func_35661_a("potion.heal");
   public static final Potion field_35686_i = (new PotionHealth(7, true, 4393481)).func_35661_a("potion.harm");
   public static final Potion field_35683_j = (new Potion(8, false, 7889559)).func_35661_a("potion.jump").func_40618_a(2, 1);
   public static final Potion field_35684_k = (new Potion(9, true, 5578058)).func_35661_a("potion.confusion").func_40618_a(3, 1).func_40614_a(0.25D);
   public static final Potion field_35681_l = (new Potion(10, false, 13458603)).func_35661_a("potion.regeneration").func_40618_a(7, 0).func_40614_a(0.25D);
   public static final Potion field_35682_m = (new Potion(11, false, 10044730)).func_35661_a("potion.resistance").func_40618_a(6, 1);
   public static final Potion field_35679_n = (new Potion(12, false, 14981690)).func_35661_a("potion.fireResistance").func_40618_a(7, 1);
   public static final Potion field_35680_o = (new Potion(13, false, 3035801)).func_35661_a("potion.waterBreathing").func_40618_a(0, 2);
   public static final Potion field_35694_p = (new Potion(14, false, 8356754)).func_35661_a("potion.invisibility").func_40618_a(0, 1).func_40616_h();
   public static final Potion field_35693_q = (new Potion(15, true, 2039587)).func_35661_a("potion.blindness").func_40618_a(5, 1).func_40614_a(0.25D);
   public static final Potion field_35692_r = (new Potion(16, false, 2039713)).func_35661_a("potion.nightVision").func_40618_a(4, 1).func_40616_h();
   public static final Potion field_35691_s = (new Potion(17, true, 5797459)).func_35661_a("potion.hunger").func_40618_a(1, 1);
   public static final Potion field_35690_t = (new Potion(18, true, 4738376)).func_35661_a("potion.weakness").func_40618_a(5, 0);
   public static final Potion field_35689_u = (new Potion(19, true, 5149489)).func_35661_a("potion.poison").func_40618_a(6, 0).func_40614_a(0.25D);
   public static final Potion field_35688_v = null;
   public static final Potion field_35687_w = null;
   public static final Potion field_35697_x = null;
   public static final Potion field_35696_y = null;
   public static final Potion field_35695_z = null;
   public static final Potion field_35667_A = null;
   public static final Potion field_35668_B = null;
   public static final Potion field_35669_C = null;
   public static final Potion field_35663_D = null;
   public static final Potion field_35664_E = null;
   public static final Potion field_35665_F = null;
   public static final Potion field_35666_G = null;
   public final int field_35670_H;
   private String field_35671_I = "";
   private int field_40627_J = -1;
   private final boolean field_40628_K;
   private double field_40624_L;
   private boolean field_40625_M;
   private final int field_40626_N;


   protected Potion(int p_i734_1_, boolean p_i734_2_, int p_i734_3_) {
      this.field_35670_H = p_i734_1_;
      field_35678_a[p_i734_1_] = this;
      this.field_40628_K = p_i734_2_;
      if(p_i734_2_) {
         this.field_40624_L = 0.5D;
      } else {
         this.field_40624_L = 1.0D;
      }

      this.field_40626_N = p_i734_3_;
   }

   protected Potion func_40618_a(int p_40618_1_, int p_40618_2_) {
      this.field_40627_J = p_40618_1_ + p_40618_2_ * 8;
      return this;
   }

   public int func_40619_a() {
      return this.field_35670_H;
   }

   public void func_35662_a(EntityLiving p_35662_1_, int p_35662_2_) {
      if(this.field_35670_H == field_35681_l.field_35670_H) {
         if(p_35662_1_.func_40114_aH() < p_35662_1_.func_40117_c()) {
            p_35662_1_.func_432_b(1);
         }
      } else if(this.field_35670_H == field_35689_u.field_35670_H) {
         if(p_35662_1_.func_40114_aH() > 1) {
            p_35662_1_.func_396_a(DamageSource.field_35545_l, 1);
         }
      } else if(this.field_35670_H == field_35691_s.field_35670_H && p_35662_1_ instanceof EntityPlayer) {
         ((EntityPlayer)p_35662_1_).func_35198_d(0.025F * (float)(p_35662_2_ + 1));
      } else if((this.field_35670_H != field_35685_h.field_35670_H || p_35662_1_.func_40122_aP()) && (this.field_35670_H != field_35686_i.field_35670_H || !p_35662_1_.func_40122_aP())) {
         if(this.field_35670_H == field_35686_i.field_35670_H && !p_35662_1_.func_40122_aP() || this.field_35670_H == field_35685_h.field_35670_H && p_35662_1_.func_40122_aP()) {
            p_35662_1_.func_396_a(DamageSource.field_35545_l, 6 << p_35662_2_);
         }
      } else {
         p_35662_1_.func_432_b(6 << p_35662_2_);
      }

   }

   public void func_40613_a(EntityLiving p_40613_1_, EntityLiving p_40613_2_, int p_40613_3_, double p_40613_4_) {
      int var6;
      if((this.field_35670_H != field_35685_h.field_35670_H || p_40613_2_.func_40122_aP()) && (this.field_35670_H != field_35686_i.field_35670_H || !p_40613_2_.func_40122_aP())) {
         if(this.field_35670_H == field_35686_i.field_35670_H && !p_40613_2_.func_40122_aP() || this.field_35670_H == field_35685_h.field_35670_H && p_40613_2_.func_40122_aP()) {
            var6 = (int)(p_40613_4_ * (double)(6 << p_40613_3_) + 0.5D);
            if(p_40613_1_ == null) {
               p_40613_2_.func_396_a(DamageSource.field_35545_l, var6);
            } else {
               p_40613_2_.func_396_a(DamageSource.func_40542_b(p_40613_2_, p_40613_1_), var6);
            }
         }
      } else {
         var6 = (int)(p_40613_4_ * (double)(6 << p_40613_3_) + 0.5D);
         p_40613_2_.func_432_b(var6);
      }

   }

   public boolean func_40622_b() {
      return false;
   }

   public boolean func_35660_a(int p_35660_1_, int p_35660_2_) {
      if(this.field_35670_H != field_35681_l.field_35670_H && this.field_35670_H != field_35689_u.field_35670_H) {
         return this.field_35670_H == field_35691_s.field_35670_H;
      } else {
         int var3 = 25 >> p_35660_2_;
         return var3 > 0?p_35660_1_ % var3 == 0:true;
      }
   }

   public Potion func_35661_a(String p_35661_1_) {
      this.field_35671_I = p_35661_1_;
      return this;
   }

   public String func_40623_c() {
      return this.field_35671_I;
   }

   public boolean func_40617_d() {
      return this.field_40627_J >= 0;
   }

   public int func_40611_e() {
      return this.field_40627_J;
   }

   public boolean func_40615_f() {
      return this.field_40628_K;
   }

   public static String func_40620_a(PotionEffect p_40620_0_) {
      int var1 = p_40620_0_.func_35802_b();
      int var2 = var1 / 20;
      int var3 = var2 / 60;
      var2 %= 60;
      return var2 < 10?var3 + ":0" + var2:var3 + ":" + var2;
   }

   protected Potion func_40614_a(double p_40614_1_) {
      this.field_40624_L = p_40614_1_;
      return this;
   }

   public double func_40610_g() {
      return this.field_40624_L;
   }

   public Potion func_40616_h() {
      this.field_40625_M = true;
      return this;
   }

   public boolean func_40612_i() {
      return this.field_40625_M;
   }

   public int func_40621_j() {
      return this.field_40626_N;
   }

}
