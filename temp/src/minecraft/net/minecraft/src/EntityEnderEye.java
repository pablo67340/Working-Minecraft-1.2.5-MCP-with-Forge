package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityEnderEye extends Entity {

   public int field_40096_a = 0;
   private double field_40094_b;
   private double field_40095_c;
   private double field_40091_d;
   private int field_40092_e;
   private boolean field_40093_ao;


   public EntityEnderEye(World p_i636_1_) {
      super(p_i636_1_);
      this.func_371_a(0.25F, 0.25F);
   }

   protected void func_21057_b() {}

   public boolean func_384_a(double p_384_1_) {
      double var3 = this.field_601_au.func_1164_b() * 4.0D;
      var3 *= 64.0D;
      return p_384_1_ < var3 * var3;
   }

   public EntityEnderEye(World p_i637_1_, double p_i637_2_, double p_i637_4_, double p_i637_6_) {
      super(p_i637_1_);
      this.field_40092_e = 0;
      this.func_371_a(0.25F, 0.25F);
      this.func_347_a(p_i637_2_, p_i637_4_, p_i637_6_);
      this.field_9292_aO = 0.0F;
   }

   public void func_40090_a(double p_40090_1_, int p_40090_3_, double p_40090_4_) {
      double var6 = p_40090_1_ - this.field_611_ak;
      double var8 = p_40090_4_ - this.field_609_am;
      float var10 = MathHelper.func_1109_a(var6 * var6 + var8 * var8);
      if(var10 > 12.0F) {
         this.field_40094_b = this.field_611_ak + var6 / (double)var10 * 12.0D;
         this.field_40091_d = this.field_609_am + var8 / (double)var10 * 12.0D;
         this.field_40095_c = this.field_610_al + 8.0D;
      } else {
         this.field_40094_b = p_40090_1_;
         this.field_40095_c = (double)p_40090_3_;
         this.field_40091_d = p_40090_4_;
      }

      this.field_40092_e = 0;
      this.field_40093_ao = this.field_9312_bd.nextInt(5) > 0;
   }

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_608_an = p_6375_1_;
      this.field_607_ao = p_6375_3_;
      this.field_606_ap = p_6375_5_;
      if(this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
         float var7 = MathHelper.func_1109_a(p_6375_1_ * p_6375_1_ + p_6375_5_ * p_6375_5_);
         this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_6375_1_, p_6375_5_) * 180.0D / 3.1415927410125732D);
         this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_6375_3_, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void func_370_e_() {
      this.field_638_aI = this.field_611_ak;
      this.field_637_aJ = this.field_610_al;
      this.field_636_aK = this.field_609_am;
      super.func_370_e_();
      this.field_611_ak += this.field_608_an;
      this.field_610_al += this.field_607_ao;
      this.field_609_am += this.field_606_ap;
      float var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
      this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

      for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var1) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
         ;
      }

      while(this.field_604_ar - this.field_602_at >= 180.0F) {
         this.field_602_at += 360.0F;
      }

      while(this.field_605_aq - this.field_603_as < -180.0F) {
         this.field_603_as -= 360.0F;
      }

      while(this.field_605_aq - this.field_603_as >= 180.0F) {
         this.field_603_as += 360.0F;
      }

      this.field_604_ar = this.field_602_at + (this.field_604_ar - this.field_602_at) * 0.2F;
      this.field_605_aq = this.field_603_as + (this.field_605_aq - this.field_603_as) * 0.2F;
      if(!this.field_615_ag.field_1026_y) {
         double var2 = this.field_40094_b - this.field_611_ak;
         double var4 = this.field_40091_d - this.field_609_am;
         float var6 = (float)Math.sqrt(var2 * var2 + var4 * var4);
         float var7 = (float)Math.atan2(var4, var2);
         double var8 = (double)var1 + (double)(var6 - var1) * 0.0025D;
         if(var6 < 1.0F) {
            var8 *= 0.8D;
            this.field_607_ao *= 0.8D;
         }

         this.field_608_an = Math.cos((double)var7) * var8;
         this.field_606_ap = Math.sin((double)var7) * var8;
         if(this.field_610_al < this.field_40095_c) {
            this.field_607_ao += (1.0D - this.field_607_ao) * 0.014999999664723873D;
         } else {
            this.field_607_ao += (-1.0D - this.field_607_ao) * 0.014999999664723873D;
         }
      }

      float var10 = 0.25F;
      if(this.func_27013_ag()) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var10, this.field_610_al - this.field_607_ao * (double)var10, this.field_609_am - this.field_606_ap * (double)var10, this.field_608_an, this.field_607_ao, this.field_606_ap);
         }
      } else {
         this.field_615_ag.func_694_a("portal", this.field_611_ak - this.field_608_an * (double)var10 + this.field_9312_bd.nextDouble() * 0.6D - 0.3D, this.field_610_al - this.field_607_ao * (double)var10 - 0.5D, this.field_609_am - this.field_606_ap * (double)var10 + this.field_9312_bd.nextDouble() * 0.6D - 0.3D, this.field_608_an, this.field_607_ao, this.field_606_ap);
      }

      if(!this.field_615_ag.field_1026_y) {
         this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
         ++this.field_40092_e;
         if(this.field_40092_e > 80 && !this.field_615_ag.field_1026_y) {
            this.func_395_F();
            if(this.field_40093_ao) {
               this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_40420_bA)));
            } else {
               this.field_615_ag.func_28106_e(2003, (int)Math.round(this.field_611_ak), (int)Math.round(this.field_610_al), (int)Math.round(this.field_609_am), 0);
            }
         }
      }

   }

   public void func_352_a(NBTTagCompound p_352_1_) {}

   public void func_357_b(NBTTagCompound p_357_1_) {}

   public void func_6378_b(EntityPlayer p_6378_1_) {}

   public float func_392_h_() {
      return 0.0F;
   }

   public float func_382_a(float p_382_1_) {
      return 1.0F;
   }

   public int func_35115_a(float p_35115_1_) {
      return 15728880;
   }

   public boolean func_48080_j() {
      return false;
   }
}
