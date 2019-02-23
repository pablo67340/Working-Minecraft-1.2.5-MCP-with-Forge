package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelIronGolem extends ModelBase {

   public ModelRenderer field_48234_a;
   public ModelRenderer field_48232_b;
   public ModelRenderer field_48233_c;
   public ModelRenderer field_48230_d;
   public ModelRenderer field_48231_e;
   public ModelRenderer field_48229_f;


   public ModelIronGolem() {
      this(0.0F);
   }

   public ModelIronGolem(float p_i1067_1_) {
      this(p_i1067_1_, -7.0F);
   }

   public ModelIronGolem(float p_i1068_1_, float p_i1068_2_) {
      short var3 = 128;
      short var4 = 128;
      this.field_48234_a = (new ModelRenderer(this)).func_35968_a(var3, var4);
      this.field_48234_a.func_925_a(0.0F, 0.0F + p_i1068_2_, -2.0F);
      this.field_48234_a.func_40602_a(0, 0).func_923_a(-4.0F, -12.0F, -5.5F, 8, 10, 8, p_i1068_1_);
      this.field_48234_a.func_40602_a(24, 0).func_923_a(-1.0F, -5.0F, -7.5F, 2, 4, 2, p_i1068_1_);
      this.field_48232_b = (new ModelRenderer(this)).func_35968_a(var3, var4);
      this.field_48232_b.func_925_a(0.0F, 0.0F + p_i1068_2_, 0.0F);
      this.field_48232_b.func_40602_a(0, 40).func_923_a(-9.0F, -2.0F, -6.0F, 18, 12, 11, p_i1068_1_);
      this.field_48232_b.func_40602_a(0, 70).func_923_a(-4.5F, 10.0F, -3.0F, 9, 5, 6, p_i1068_1_ + 0.5F);
      this.field_48233_c = (new ModelRenderer(this)).func_35968_a(var3, var4);
      this.field_48233_c.func_925_a(0.0F, -7.0F, 0.0F);
      this.field_48233_c.func_40602_a(60, 21).func_923_a(-13.0F, -2.5F, -3.0F, 4, 30, 6, p_i1068_1_);
      this.field_48230_d = (new ModelRenderer(this)).func_35968_a(var3, var4);
      this.field_48230_d.func_925_a(0.0F, -7.0F, 0.0F);
      this.field_48230_d.func_40602_a(60, 58).func_923_a(9.0F, -2.5F, -3.0F, 4, 30, 6, p_i1068_1_);
      this.field_48231_e = (new ModelRenderer(this, 0, 22)).func_35968_a(var3, var4);
      this.field_48231_e.func_925_a(-4.0F, 18.0F + p_i1068_2_, 0.0F);
      this.field_48231_e.func_40602_a(37, 0).func_923_a(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1068_1_);
      this.field_48229_f = (new ModelRenderer(this, 0, 22)).func_35968_a(var3, var4);
      this.field_48229_f.field_1404_g = true;
      this.field_48229_f.func_40602_a(60, 0).func_925_a(5.0F, 18.0F + p_i1068_2_, 0.0F);
      this.field_48229_f.func_923_a(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i1068_1_);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_48234_a.func_922_a(p_864_7_);
      this.field_48232_b.func_922_a(p_864_7_);
      this.field_48231_e.func_922_a(p_864_7_);
      this.field_48229_f.func_922_a(p_864_7_);
      this.field_48233_c.func_922_a(p_864_7_);
      this.field_48230_d.func_922_a(p_864_7_);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_48234_a.field_1406_e = p_863_4_ / 57.295776F;
      this.field_48234_a.field_1407_d = p_863_5_ / 57.295776F;
      this.field_48231_e.field_1407_d = -1.5F * this.func_48228_a(p_863_1_, 13.0F) * p_863_2_;
      this.field_48229_f.field_1407_d = 1.5F * this.func_48228_a(p_863_1_, 13.0F) * p_863_2_;
      this.field_48231_e.field_1406_e = 0.0F;
      this.field_48229_f.field_1406_e = 0.0F;
   }

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      EntityIronGolem var5 = (EntityIronGolem)p_25103_1_;
      int var6 = var5.func_48114_ab();
      if(var6 > 0) {
         this.field_48233_c.field_1407_d = -2.0F + 1.5F * this.func_48228_a((float)var6 - p_25103_4_, 10.0F);
         this.field_48230_d.field_1407_d = -2.0F + 1.5F * this.func_48228_a((float)var6 - p_25103_4_, 10.0F);
      } else {
         int var7 = var5.func_48117_D_();
         if(var7 > 0) {
            this.field_48233_c.field_1407_d = -0.8F + 0.025F * this.func_48228_a((float)var7, 70.0F);
            this.field_48230_d.field_1407_d = 0.0F;
         } else {
            this.field_48233_c.field_1407_d = (-0.2F + 1.5F * this.func_48228_a(p_25103_2_, 13.0F)) * p_25103_3_;
            this.field_48230_d.field_1407_d = (-0.2F - 1.5F * this.func_48228_a(p_25103_2_, 13.0F)) * p_25103_3_;
         }
      }

   }

   private float func_48228_a(float p_48228_1_, float p_48228_2_) {
      return (Math.abs(p_48228_1_ % p_48228_2_ - p_48228_2_ * 0.5F) - p_48228_2_ * 0.25F) / (p_48228_2_ * 0.25F);
   }
}
