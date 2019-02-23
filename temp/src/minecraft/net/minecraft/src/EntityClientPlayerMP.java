package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet101CloseWindow;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet18Animation;
import net.minecraft.src.Packet19EntityAction;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet9Respawn;
import net.minecraft.src.Session;
import net.minecraft.src.StatBase;
import net.minecraft.src.World;

public class EntityClientPlayerMP extends EntityPlayerSP {

   public NetClientHandler field_797_bg;
   private int field_9380_bx = 0;
   private double field_9379_by;
   private double field_9378_bz;
   private double field_9377_bA;
   private double field_9376_bB;
   private float field_9385_bC;
   private float field_9384_bD;
   private boolean field_9382_bF = false;
   private boolean field_35227_cs = false;
   private boolean field_9381_bG = false;
   private int field_12242_bI = 0;
   private boolean field_21093_bH = false;


   public EntityClientPlayerMP(Minecraft p_i132_1_, World p_i132_2_, Session p_i132_3_, NetClientHandler p_i132_4_) {
      super(p_i132_1_, p_i132_2_, p_i132_3_, 0);
      this.field_797_bg = p_i132_4_;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return false;
   }

   public void func_432_b(int p_432_1_) {}

   public void func_370_e_() {
      if(this.field_615_ag.func_630_d(MathHelper.func_1108_b(this.field_611_ak), 0, MathHelper.func_1108_b(this.field_609_am))) {
         super.func_370_e_();
         this.func_4056_N();
      }
   }

   public void func_4056_N() {
      if(this.field_9380_bx++ == 20) {
         this.field_9380_bx = 0;
      }

      boolean var1 = this.func_35117_Q();
      if(var1 != this.field_9381_bG) {
         if(var1) {
            this.field_797_bg.func_847_a(new Packet19EntityAction(this, 4));
         } else {
            this.field_797_bg.func_847_a(new Packet19EntityAction(this, 5));
         }

         this.field_9381_bG = var1;
      }

      boolean var2 = this.func_381_o();
      if(var2 != this.field_35227_cs) {
         if(var2) {
            this.field_797_bg.func_847_a(new Packet19EntityAction(this, 1));
         } else {
            this.field_797_bg.func_847_a(new Packet19EntityAction(this, 2));
         }

         this.field_35227_cs = var2;
      }

      double var3 = this.field_611_ak - this.field_9379_by;
      double var5 = this.field_601_au.field_1697_b - this.field_9378_bz;
      double var7 = this.field_610_al - this.field_9377_bA;
      double var9 = this.field_609_am - this.field_9376_bB;
      double var11 = (double)(this.field_605_aq - this.field_9385_bC);
      double var13 = (double)(this.field_604_ar - this.field_9384_bD);
      boolean var15 = var5 != 0.0D || var7 != 0.0D || var3 != 0.0D || var9 != 0.0D;
      boolean var16 = var11 != 0.0D || var13 != 0.0D;
      if(this.field_616_af != null) {
         if(var16) {
            this.field_797_bg.func_847_a(new Packet11PlayerPosition(this.field_608_an, -999.0D, -999.0D, this.field_606_ap, this.field_9298_aH));
         } else {
            this.field_797_bg.func_847_a(new Packet13PlayerLookMove(this.field_608_an, -999.0D, -999.0D, this.field_606_ap, this.field_605_aq, this.field_604_ar, this.field_9298_aH));
         }

         var15 = false;
      } else if(var15 && var16) {
         this.field_797_bg.func_847_a(new Packet13PlayerLookMove(this.field_611_ak, this.field_601_au.field_1697_b, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar, this.field_9298_aH));
         this.field_12242_bI = 0;
      } else if(var15) {
         this.field_797_bg.func_847_a(new Packet11PlayerPosition(this.field_611_ak, this.field_601_au.field_1697_b, this.field_610_al, this.field_609_am, this.field_9298_aH));
         this.field_12242_bI = 0;
      } else if(var16) {
         this.field_797_bg.func_847_a(new Packet12PlayerLook(this.field_605_aq, this.field_604_ar, this.field_9298_aH));
         this.field_12242_bI = 0;
      } else {
         this.field_797_bg.func_847_a(new Packet10Flying(this.field_9298_aH));
         if(this.field_9382_bF == this.field_9298_aH && this.field_12242_bI <= 200) {
            ++this.field_12242_bI;
         } else {
            this.field_12242_bI = 0;
         }
      }

      this.field_9382_bF = this.field_9298_aH;
      if(var15) {
         this.field_9379_by = this.field_611_ak;
         this.field_9378_bz = this.field_601_au.field_1697_b;
         this.field_9377_bA = this.field_610_al;
         this.field_9376_bB = this.field_609_am;
      }

      if(var16) {
         this.field_9385_bC = this.field_605_aq;
         this.field_9384_bD = this.field_604_ar;
      }

   }

   public EntityItem func_48152_as() {
      this.field_797_bg.func_847_a(new Packet14BlockDig(4, 0, 0, 0, 0));
      return null;
   }

   protected void func_446_a(EntityItem p_446_1_) {}

   public void func_461_a(String p_461_1_) {
      if(this.field_788_bg.field_6308_u.func_50013_c().size() == 0 || !((String)this.field_788_bg.field_6308_u.func_50013_c().get(this.field_788_bg.field_6308_u.func_50013_c().size() - 1)).equals(p_461_1_)) {
         this.field_788_bg.field_6308_u.func_50013_c().add(p_461_1_);
      }

      this.field_797_bg.func_847_a(new Packet3Chat(p_461_1_));
   }

   public void func_457_w() {
      super.func_457_w();
      this.field_797_bg.func_847_a(new Packet18Animation(this, 1));
   }

   public void func_9367_r() {
      this.field_797_bg.func_847_a(new Packet9Respawn(this.field_4129_m, (byte)this.field_615_ag.field_1039_l, this.field_615_ag.func_22144_v().func_46133_t(), this.field_615_ag.func_48453_b(), 0));
   }

   protected void func_4044_a(DamageSource p_4044_1_, int p_4044_2_) {
      this.func_40121_k(this.func_40114_aH() - p_4044_2_);
   }

   public void func_20059_m() {
      this.field_797_bg.func_847_a(new Packet101CloseWindow(this.field_20068_h.field_1618_c));
      this.field_778_b.func_20076_b((ItemStack)null);
      super.func_20059_m();
   }

   public void func_9372_a_(int p_9372_1_) {
      if(this.field_21093_bH) {
         super.func_9372_a_(p_9372_1_);
      } else {
         this.func_40121_k(p_9372_1_);
         this.field_21093_bH = true;
      }

   }

   public void func_25058_a(StatBase p_25058_1_, int p_25058_2_) {
      if(p_25058_1_ != null) {
         if(p_25058_1_.field_27088_g) {
            super.func_25058_a(p_25058_1_, p_25058_2_);
         }

      }
   }

   public void func_27027_b(StatBase p_27027_1_, int p_27027_2_) {
      if(p_27027_1_ != null) {
         if(!p_27027_1_.field_27088_g) {
            super.func_25058_a(p_27027_1_, p_27027_2_);
         }

      }
   }

   public void func_50009_aI() {
      this.field_797_bg.func_847_a(new Packet202PlayerAbilities(this.field_35212_aW));
   }
}
