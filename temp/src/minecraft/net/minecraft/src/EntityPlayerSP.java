package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityCrit2FX;
import net.minecraft.src.EntityPickupFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiBrewingStand;
import net.minecraft.src.GuiChest;
import net.minecraft.src.GuiCrafting;
import net.minecraft.src.GuiDispenser;
import net.minecraft.src.GuiEditSign;
import net.minecraft.src.GuiEnchantment;
import net.minecraft.src.GuiFurnace;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiWinGame;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MouseFilter;
import net.minecraft.src.MovementInput;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Potion;
import net.minecraft.src.Session;
import net.minecraft.src.StatBase;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class EntityPlayerSP extends EntityPlayer {

   public MovementInput field_787_a;
   protected Minecraft field_788_bg;
   protected int field_35224_c = 0;
   public int field_35221_d = 0;
   public float field_35222_e;
   public float field_35223_ap;
   public float field_35226_aq;
   public float field_35225_ar;
   private MouseFilter field_21903_bJ = new MouseFilter();
   private MouseFilter field_21904_bK = new MouseFilter();
   private MouseFilter field_21902_bL = new MouseFilter();


   public EntityPlayerSP(Minecraft p_i650_1_, World p_i650_2_, Session p_i650_3_, int p_i650_4_) {
      super(p_i650_2_);
      this.field_788_bg = p_i650_1_;
      this.field_4129_m = p_i650_4_;
      if(p_i650_3_ != null && p_i650_3_.field_1666_b != null && p_i650_3_.field_1666_b.length() > 0) {
         this.field_20047_bv = "http://s3.amazonaws.com/MinecraftSkins/" + p_i650_3_.field_1666_b + ".png";
      }

      this.field_771_i = p_i650_3_.field_1666_b;
   }

   public void func_349_c(double p_349_1_, double p_349_3_, double p_349_5_) {
      super.func_349_c(p_349_1_, p_349_3_, p_349_5_);
   }

   public void func_418_b_() {
      super.func_418_b_();
      this.field_9342_ah = this.field_787_a.field_1174_a;
      this.field_9340_ai = this.field_787_a.field_1173_b;
      this.field_9336_ak = this.field_787_a.field_1176_d;
      this.field_35226_aq = this.field_35222_e;
      this.field_35225_ar = this.field_35223_ap;
      this.field_35223_ap = (float)((double)this.field_35223_ap + (double)(this.field_604_ar - this.field_35223_ap) * 0.5D);
      this.field_35222_e = (float)((double)this.field_35222_e + (double)(this.field_605_aq - this.field_35222_e) * 0.5D);
   }

   protected boolean func_44001_ad() {
      return true;
   }

   public void func_425_j() {
      if(this.field_35221_d > 0) {
         --this.field_35221_d;
         if(this.field_35221_d == 0) {
            this.func_35113_c(false);
         }
      }

      if(this.field_35224_c > 0) {
         --this.field_35224_c;
      }

      if(this.field_788_bg.field_6327_b.func_35643_e()) {
         this.field_611_ak = this.field_609_am = 0.5D;
         this.field_611_ak = 0.0D;
         this.field_609_am = 0.0D;
         this.field_605_aq = (float)this.field_9311_be / 12.0F;
         this.field_604_ar = 10.0F;
         this.field_610_al = 68.5D;
      } else {
         if(!this.field_788_bg.field_25001_G.func_27183_a(AchievementList.field_25195_b)) {
            this.field_788_bg.field_25002_t.func_27101_b(AchievementList.field_25195_b);
         }

         this.field_28025_B = this.field_28026_A;
         boolean var1;
         if(this.field_28023_z) {
            if(!this.field_615_ag.field_1026_y && this.field_616_af != null) {
               this.func_6377_h((Entity)null);
            }

            if(this.field_788_bg.field_6313_p != null) {
               this.field_788_bg.func_6272_a((GuiScreen)null);
            }

            if(this.field_28026_A == 0.0F) {
               this.field_788_bg.field_6301_A.func_337_a("portal.trigger", 1.0F, this.field_9312_bd.nextFloat() * 0.4F + 0.8F);
            }

            this.field_28026_A += 0.0125F;
            if(this.field_28026_A >= 1.0F) {
               this.field_28026_A = 1.0F;
               if(!this.field_615_ag.field_1026_y) {
                  this.field_28024_y = 10;
                  this.field_788_bg.field_6301_A.func_337_a("portal.travel", 1.0F, this.field_9312_bd.nextFloat() * 0.4F + 0.8F);
                  var1 = false;
                  byte var5;
                  if(this.field_4129_m == -1) {
                     var5 = 0;
                  } else {
                     var5 = -1;
                  }

                  this.field_788_bg.func_6237_k(var5);
                  this.func_27026_a(AchievementList.field_40467_x);
               }
            }

            this.field_28023_z = false;
         } else if(this.func_35160_a(Potion.field_35684_k) && this.func_35167_b(Potion.field_35684_k).func_35802_b() > 60) {
            this.field_28026_A += 0.006666667F;
            if(this.field_28026_A > 1.0F) {
               this.field_28026_A = 1.0F;
            }
         } else {
            if(this.field_28026_A > 0.0F) {
               this.field_28026_A -= 0.05F;
            }

            if(this.field_28026_A < 0.0F) {
               this.field_28026_A = 0.0F;
            }
         }

         if(this.field_28024_y > 0) {
            --this.field_28024_y;
         }

         var1 = this.field_787_a.field_1176_d;
         float var2 = 0.8F;
         boolean var3 = this.field_787_a.field_1173_b >= var2;
         this.field_787_a.func_52013_a();
         if(this.func_35196_Z()) {
            this.field_787_a.field_1174_a *= 0.2F;
            this.field_787_a.field_1173_b *= 0.2F;
            this.field_35224_c = 0;
         }

         if(this.field_787_a.field_1175_e && this.field_9287_aY < 0.2F) {
            this.field_9287_aY = 0.2F;
         }

         this.func_28014_c(this.field_611_ak - (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am + (double)this.field_644_aC * 0.35D);
         this.func_28014_c(this.field_611_ak - (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am - (double)this.field_644_aC * 0.35D);
         this.func_28014_c(this.field_611_ak + (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am - (double)this.field_644_aC * 0.35D);
         this.func_28014_c(this.field_611_ak + (double)this.field_644_aC * 0.35D, this.field_601_au.field_1697_b + 0.5D, this.field_609_am + (double)this.field_644_aC * 0.35D);
         boolean var4 = (float)this.func_35191_at().func_35765_a() > 6.0F;
         if(this.field_9298_aH && !var3 && this.field_787_a.field_1173_b >= var2 && !this.func_35117_Q() && var4 && !this.func_35196_Z() && !this.func_35160_a(Potion.field_35693_q)) {
            if(this.field_35224_c == 0) {
               this.field_35224_c = 7;
            } else {
               this.func_35113_c(true);
               this.field_35224_c = 0;
            }
         }

         if(this.func_381_o()) {
            this.field_35224_c = 0;
         }

         if(this.func_35117_Q() && (this.field_787_a.field_1173_b < var2 || this.field_9297_aI || !var4)) {
            this.func_35113_c(false);
         }

         if(this.field_35212_aW.field_35758_c && !var1 && this.field_787_a.field_1176_d) {
            if(this.field_35216_aw == 0) {
               this.field_35216_aw = 7;
            } else {
               this.field_35212_aW.field_35757_b = !this.field_35212_aW.field_35757_b;
               this.func_50009_aI();
               this.field_35216_aw = 0;
            }
         }

         if(this.field_35212_aW.field_35757_b) {
            if(this.field_787_a.field_1175_e) {
               this.field_607_ao -= 0.15D;
            }

            if(this.field_787_a.field_1176_d) {
               this.field_607_ao += 0.15D;
            }
         }

         super.func_425_j();
         if(this.field_9298_aH && this.field_35212_aW.field_35757_b) {
            this.field_35212_aW.field_35757_b = false;
            this.func_50009_aI();
         }

      }
   }

   public void func_40182_b(int p_40182_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(this.field_4129_m == 1 && p_40182_1_ == 1) {
            this.func_27026_a(AchievementList.field_40463_C);
            this.field_788_bg.func_6272_a(new GuiWinGame());
         } else {
            this.func_27026_a(AchievementList.field_40462_B);
            this.field_788_bg.field_6301_A.func_337_a("portal.travel", 1.0F, this.field_9312_bd.nextFloat() * 0.4F + 0.8F);
            this.field_788_bg.func_6237_k(1);
         }

      }
   }

   public float func_35220_u_() {
      float var1 = 1.0F;
      if(this.field_35212_aW.field_35757_b) {
         var1 *= 1.1F;
      }

      var1 *= (this.field_35169_bv * this.func_35166_t_() / this.field_35215_ba + 1.0F) / 2.0F;
      if(this.func_35196_Z() && this.func_35195_X().field_1617_c == Item.field_227_i.field_291_aS) {
         int var2 = this.func_35192_aa();
         float var3 = (float)var2 / 20.0F;
         if(var3 > 1.0F) {
            var3 = 1.0F;
         } else {
            var3 *= var3;
         }

         var1 *= 1.0F - var3 * 0.15F;
      }

      return var1;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("Score", this.field_9370_g);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.field_9370_g = p_357_1_.func_756_e("Score");
   }

   public void func_20059_m() {
      super.func_20059_m();
      this.field_788_bg.func_6272_a((GuiScreen)null);
   }

   public void func_4052_a(TileEntitySign p_4052_1_) {
      this.field_788_bg.func_6272_a(new GuiEditSign(p_4052_1_));
   }

   public void func_452_a(IInventory p_452_1_) {
      this.field_788_bg.func_6272_a(new GuiChest(this.field_778_b, p_452_1_));
   }

   public void func_445_l(int p_445_1_, int p_445_2_, int p_445_3_) {
      this.field_788_bg.func_6272_a(new GuiCrafting(this.field_778_b, this.field_615_ag, p_445_1_, p_445_2_, p_445_3_));
   }

   public void func_40181_c(int p_40181_1_, int p_40181_2_, int p_40181_3_) {
      this.field_788_bg.func_6272_a(new GuiEnchantment(this.field_778_b, this.field_615_ag, p_40181_1_, p_40181_2_, p_40181_3_));
   }

   public void func_453_a(TileEntityFurnace p_453_1_) {
      this.field_788_bg.func_6272_a(new GuiFurnace(this.field_778_b, p_453_1_));
   }

   public void func_40180_a(TileEntityBrewingStand p_40180_1_) {
      this.field_788_bg.func_6272_a(new GuiBrewingStand(this.field_778_b, p_40180_1_));
   }

   public void func_21092_a(TileEntityDispenser p_21092_1_) {
      this.field_788_bg.func_6272_a(new GuiDispenser(this.field_778_b, p_21092_1_));
   }

   public void func_35200_b(Entity p_35200_1_) {
      this.field_788_bg.field_6321_h.func_1192_a(new EntityCrit2FX(this.field_788_bg.field_6324_e, p_35200_1_));
   }

   public void func_40183_c(Entity p_40183_1_) {
      EntityCrit2FX var2 = new EntityCrit2FX(this.field_788_bg.field_6324_e, p_40183_1_, "magicCrit");
      this.field_788_bg.field_6321_h.func_1192_a(var2);
   }

   public void func_443_a_(Entity p_443_1_, int p_443_2_) {
      this.field_788_bg.field_6321_h.func_1192_a(new EntityPickupFX(this.field_788_bg.field_6324_e, p_443_1_, this, -0.5F));
   }

   public void func_461_a(String p_461_1_) {}

   public boolean func_381_o() {
      return this.field_787_a.field_1175_e && !this.field_21901_a;
   }

   public void func_9372_a_(int p_9372_1_) {
      int var2 = this.func_40114_aH() - p_9372_1_;
      if(var2 <= 0) {
         this.func_40121_k(p_9372_1_);
         if(var2 < 0) {
            this.field_9306_bj = this.field_9366_o / 2;
         }
      } else {
         this.field_9346_af = var2;
         this.func_40121_k(this.func_40114_aH());
         this.field_9306_bj = this.field_9366_o;
         this.func_4044_a(DamageSource.field_35547_j, var2);
         this.field_715_G = this.field_9332_M = 10;
      }

   }

   public void func_9367_r() {
      this.field_788_bg.func_6239_p(false, 0, false);
   }

   public void func_6420_o() {}

   public void func_22055_b(String p_22055_1_) {
      this.field_788_bg.field_6308_u.func_22064_c(p_22055_1_);
   }

   public void func_25058_a(StatBase p_25058_1_, int p_25058_2_) {
      if(p_25058_1_ != null) {
         if(p_25058_1_.func_25067_a()) {
            Achievement var3 = (Achievement)p_25058_1_;
            if(var3.field_25076_c == null || this.field_788_bg.field_25001_G.func_27183_a(var3.field_25076_c)) {
               if(!this.field_788_bg.field_25001_G.func_27183_a(var3)) {
                  this.field_788_bg.field_25002_t.func_27102_a(var3);
               }

               this.field_788_bg.field_25001_G.func_25100_a(p_25058_1_, p_25058_2_);
            }
         } else {
            this.field_788_bg.field_25001_G.func_25100_a(p_25058_1_, p_25058_2_);
         }

      }
   }

   private boolean func_28027_d(int p_28027_1_, int p_28027_2_, int p_28027_3_) {
      return this.field_615_ag.func_28100_h(p_28027_1_, p_28027_2_, p_28027_3_);
   }

   protected boolean func_28014_c(double p_28014_1_, double p_28014_3_, double p_28014_5_) {
      int var7 = MathHelper.func_1108_b(p_28014_1_);
      int var8 = MathHelper.func_1108_b(p_28014_3_);
      int var9 = MathHelper.func_1108_b(p_28014_5_);
      double var10 = p_28014_1_ - (double)var7;
      double var12 = p_28014_5_ - (double)var9;
      if(this.func_28027_d(var7, var8, var9) || this.func_28027_d(var7, var8 + 1, var9)) {
         boolean var14 = !this.func_28027_d(var7 - 1, var8, var9) && !this.func_28027_d(var7 - 1, var8 + 1, var9);
         boolean var15 = !this.func_28027_d(var7 + 1, var8, var9) && !this.func_28027_d(var7 + 1, var8 + 1, var9);
         boolean var16 = !this.func_28027_d(var7, var8, var9 - 1) && !this.func_28027_d(var7, var8 + 1, var9 - 1);
         boolean var17 = !this.func_28027_d(var7, var8, var9 + 1) && !this.func_28027_d(var7, var8 + 1, var9 + 1);
         byte var18 = -1;
         double var19 = 9999.0D;
         if(var14 && var10 < var19) {
            var19 = var10;
            var18 = 0;
         }

         if(var15 && 1.0D - var10 < var19) {
            var19 = 1.0D - var10;
            var18 = 1;
         }

         if(var16 && var12 < var19) {
            var19 = var12;
            var18 = 4;
         }

         if(var17 && 1.0D - var12 < var19) {
            var19 = 1.0D - var12;
            var18 = 5;
         }

         float var21 = 0.1F;
         if(var18 == 0) {
            this.field_608_an = (double)(-var21);
         }

         if(var18 == 1) {
            this.field_608_an = (double)var21;
         }

         if(var18 == 4) {
            this.field_606_ap = (double)(-var21);
         }

         if(var18 == 5) {
            this.field_606_ap = (double)var21;
         }
      }

      return false;
   }

   public void func_35113_c(boolean p_35113_1_) {
      super.func_35113_c(p_35113_1_);
      this.field_35221_d = p_35113_1_?600:0;
   }

   public void func_35219_c(float p_35219_1_, int p_35219_2_, int p_35219_3_) {
      this.field_35211_aX = p_35219_1_;
      this.field_35209_aZ = p_35219_2_;
      this.field_35210_aY = p_35219_3_;
   }
}
