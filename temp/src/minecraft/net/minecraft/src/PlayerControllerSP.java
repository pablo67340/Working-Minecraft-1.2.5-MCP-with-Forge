package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PlayerController;
import net.minecraft.src.World;

public class PlayerControllerSP extends PlayerController {

   private int field_1074_c = -1;
   private int field_1073_d = -1;
   private int field_1072_e = -1;
   private float field_1071_f = 0.0F;
   private float field_1070_g = 0.0F;
   private float field_1069_h = 0.0F;
   private int field_1068_i = 0;


   public PlayerControllerSP(Minecraft p_i70_1_) {
      super(p_i70_1_);
   }

   public void func_6476_a(EntityPlayer p_6476_1_) {
      p_6476_1_.field_605_aq = -180.0F;
   }

   public boolean func_6469_d() {
      return true;
   }

   public boolean func_729_b(int p_729_1_, int p_729_2_, int p_729_3_, int p_729_4_) {
      int var5 = this.field_1065_a.field_6324_e.func_600_a(p_729_1_, p_729_2_, p_729_3_);
      int var6 = this.field_1065_a.field_6324_e.func_602_e(p_729_1_, p_729_2_, p_729_3_);
      boolean var7 = super.func_729_b(p_729_1_, p_729_2_, p_729_3_, p_729_4_);
      ItemStack var8 = this.field_1065_a.field_6322_g.func_6416_v();
      boolean var9 = this.field_1065_a.field_6322_g.func_454_b(Block.field_345_n[var5]);
      if(var8 != null) {
         var8.func_25191_a(var5, p_729_1_, p_729_2_, p_729_3_, this.field_1065_a.field_6322_g);
         if(var8.field_1615_a == 0) {
            var8.func_1097_a(this.field_1065_a.field_6322_g);
            this.field_1065_a.field_6322_g.func_448_u();
         }
      }

      if(var7 && var9) {
         Block.field_345_n[var5].func_220_a_(this.field_1065_a.field_6324_e, this.field_1065_a.field_6322_g, p_729_1_, p_729_2_, p_729_3_, var6);
      }

      return var7;
   }

   public void func_719_a(int p_719_1_, int p_719_2_, int p_719_3_, int p_719_4_) {
      if(this.field_1065_a.field_6322_g.func_35190_e(p_719_1_, p_719_2_, p_719_3_)) {
         this.field_1065_a.field_6324_e.func_48457_a(this.field_1065_a.field_6322_g, p_719_1_, p_719_2_, p_719_3_, p_719_4_);
         int var5 = this.field_1065_a.field_6324_e.func_600_a(p_719_1_, p_719_2_, p_719_3_);
         if(var5 > 0 && this.field_1071_f == 0.0F) {
            Block.field_345_n[var5].func_233_b(this.field_1065_a.field_6324_e, p_719_1_, p_719_2_, p_719_3_, this.field_1065_a.field_6322_g);
         }

         if(var5 > 0 && Block.field_345_n[var5].func_225_a(this.field_1065_a.field_6322_g) >= 1.0F) {
            this.func_729_b(p_719_1_, p_719_2_, p_719_3_, p_719_4_);
         }

      }
   }

   public void func_6468_a() {
      this.field_1071_f = 0.0F;
      this.field_1068_i = 0;
   }

   public void func_6470_c(int p_6470_1_, int p_6470_2_, int p_6470_3_, int p_6470_4_) {
      if(this.field_1068_i > 0) {
         --this.field_1068_i;
      } else {
         if(p_6470_1_ == this.field_1074_c && p_6470_2_ == this.field_1073_d && p_6470_3_ == this.field_1072_e) {
            int var5 = this.field_1065_a.field_6324_e.func_600_a(p_6470_1_, p_6470_2_, p_6470_3_);
            if(!this.field_1065_a.field_6322_g.func_35190_e(p_6470_1_, p_6470_2_, p_6470_3_)) {
               return;
            }

            if(var5 == 0) {
               return;
            }

            Block var6 = Block.field_345_n[var5];
            this.field_1071_f += var6.func_225_a(this.field_1065_a.field_6322_g);
            if(this.field_1069_h % 4.0F == 0.0F && var6 != null) {
               this.field_1065_a.field_6301_A.func_336_b(var6.field_358_bl.func_1145_d(), (float)p_6470_1_ + 0.5F, (float)p_6470_2_ + 0.5F, (float)p_6470_3_ + 0.5F, (var6.field_358_bl.func_1147_b() + 1.0F) / 8.0F, var6.field_358_bl.func_1144_c() * 0.5F);
            }

            ++this.field_1069_h;
            if(this.field_1071_f >= 1.0F) {
               this.func_729_b(p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_);
               this.field_1071_f = 0.0F;
               this.field_1070_g = 0.0F;
               this.field_1069_h = 0.0F;
               this.field_1068_i = 5;
            }
         } else {
            this.field_1071_f = 0.0F;
            this.field_1070_g = 0.0F;
            this.field_1069_h = 0.0F;
            this.field_1074_c = p_6470_1_;
            this.field_1073_d = p_6470_2_;
            this.field_1072_e = p_6470_3_;
         }

      }
   }

   public void func_6467_a(float p_6467_1_) {
      if(this.field_1071_f <= 0.0F) {
         this.field_1065_a.field_6308_u.field_6446_b = 0.0F;
         this.field_1065_a.field_6323_f.field_1450_i = 0.0F;
      } else {
         float var2 = this.field_1070_g + (this.field_1071_f - this.field_1070_g) * p_6467_1_;
         this.field_1065_a.field_6308_u.field_6446_b = var2;
         this.field_1065_a.field_6323_f.field_1450_i = var2;
      }

   }

   public float func_727_b() {
      return 4.0F;
   }

   public void func_717_a(World p_717_1_) {
      super.func_717_a(p_717_1_);
   }

   public EntityPlayer func_4087_b(World p_4087_1_) {
      EntityPlayer var2 = super.func_4087_b(p_4087_1_);
      return var2;
   }

   public void func_6474_c() {
      this.field_1070_g = this.field_1071_f;
      this.field_1065_a.field_6301_A.func_4033_c();
   }

   public boolean func_722_a(EntityPlayer p_722_1_, World p_722_2_, ItemStack p_722_3_, int p_722_4_, int p_722_5_, int p_722_6_, int p_722_7_) {
      int var8 = p_722_2_.func_600_a(p_722_4_, p_722_5_, p_722_6_);
      return var8 > 0 && Block.field_345_n[var8].func_250_a(p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_1_)?true:(p_722_3_ == null?false:p_722_3_.func_1090_a(p_722_1_, p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_7_));
   }

   public boolean func_35642_f() {
      return true;
   }
}
