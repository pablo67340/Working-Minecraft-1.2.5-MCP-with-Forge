package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet102WindowClick;
import net.minecraft.src.Packet107CreativeSetSlot;
import net.minecraft.src.Packet108EnchantItem;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet16BlockItemSwitch;
import net.minecraft.src.Packet7UseEntity;
import net.minecraft.src.PlayerController;
import net.minecraft.src.PlayerControllerCreative;
import net.minecraft.src.World;

public class PlayerControllerMP extends PlayerController {

   private int field_9445_c = -1;
   private int field_9444_d = -1;
   private int field_9443_e = -1;
   private float field_9442_f = 0.0F;
   private float field_1080_g = 0.0F;
   private float field_9441_h = 0.0F;
   private int field_9440_i = 0;
   private boolean field_9439_j = false;
   private boolean field_35649_k;
   private NetClientHandler field_9438_k;
   private int field_1075_l = 0;


   public PlayerControllerMP(Minecraft p_i572_1_, NetClientHandler p_i572_2_) {
      super(p_i572_1_);
      this.field_9438_k = p_i572_2_;
   }

   public void func_35648_a(boolean p_35648_1_) {
      this.field_35649_k = p_35648_1_;
      if(this.field_35649_k) {
         PlayerControllerCreative.func_35646_d(this.field_1065_a.field_6322_g);
      } else {
         PlayerControllerCreative.func_35645_e(this.field_1065_a.field_6322_g);
      }

   }

   public void func_6476_a(EntityPlayer p_6476_1_) {
      p_6476_1_.field_605_aq = -180.0F;
   }

   public boolean func_6469_d() {
      return !this.field_35649_k;
   }

   public boolean func_729_b(int p_729_1_, int p_729_2_, int p_729_3_, int p_729_4_) {
      if(this.field_35649_k) {
         return super.func_729_b(p_729_1_, p_729_2_, p_729_3_, p_729_4_);
      } else {
         int var5 = this.field_1065_a.field_6324_e.func_600_a(p_729_1_, p_729_2_, p_729_3_);
         boolean var6 = super.func_729_b(p_729_1_, p_729_2_, p_729_3_, p_729_4_);
         ItemStack var7 = this.field_1065_a.field_6322_g.func_6416_v();
         if(var7 != null) {
            var7.func_25191_a(var5, p_729_1_, p_729_2_, p_729_3_, this.field_1065_a.field_6322_g);
            if(var7.field_1615_a == 0) {
               var7.func_1097_a(this.field_1065_a.field_6322_g);
               this.field_1065_a.field_6322_g.func_448_u();
            }
         }

         return var6;
      }
   }

   public void func_719_a(int p_719_1_, int p_719_2_, int p_719_3_, int p_719_4_) {
      if(this.field_35649_k) {
         this.field_9438_k.func_847_a(new Packet14BlockDig(0, p_719_1_, p_719_2_, p_719_3_, p_719_4_));
         PlayerControllerCreative.func_35644_a(this.field_1065_a, this, p_719_1_, p_719_2_, p_719_3_, p_719_4_);
         this.field_9440_i = 5;
      } else if(!this.field_9439_j || p_719_1_ != this.field_9445_c || p_719_2_ != this.field_9444_d || p_719_3_ != this.field_9443_e) {
         this.field_9438_k.func_847_a(new Packet14BlockDig(0, p_719_1_, p_719_2_, p_719_3_, p_719_4_));
         int var5 = this.field_1065_a.field_6324_e.func_600_a(p_719_1_, p_719_2_, p_719_3_);
         if(var5 > 0 && this.field_9442_f == 0.0F) {
            Block.field_345_n[var5].func_233_b(this.field_1065_a.field_6324_e, p_719_1_, p_719_2_, p_719_3_, this.field_1065_a.field_6322_g);
         }

         if(var5 > 0 && Block.field_345_n[var5].func_225_a(this.field_1065_a.field_6322_g) >= 1.0F) {
            this.func_729_b(p_719_1_, p_719_2_, p_719_3_, p_719_4_);
         } else {
            this.field_9439_j = true;
            this.field_9445_c = p_719_1_;
            this.field_9444_d = p_719_2_;
            this.field_9443_e = p_719_3_;
            this.field_9442_f = 0.0F;
            this.field_1080_g = 0.0F;
            this.field_9441_h = 0.0F;
         }
      }

   }

   public void func_6468_a() {
      this.field_9442_f = 0.0F;
      this.field_9439_j = false;
   }

   public void func_6470_c(int p_6470_1_, int p_6470_2_, int p_6470_3_, int p_6470_4_) {
      this.func_730_e();
      if(this.field_9440_i > 0) {
         --this.field_9440_i;
      } else if(this.field_35649_k) {
         this.field_9440_i = 5;
         this.field_9438_k.func_847_a(new Packet14BlockDig(0, p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_));
         PlayerControllerCreative.func_35644_a(this.field_1065_a, this, p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_);
      } else {
         if(p_6470_1_ == this.field_9445_c && p_6470_2_ == this.field_9444_d && p_6470_3_ == this.field_9443_e) {
            int var5 = this.field_1065_a.field_6324_e.func_600_a(p_6470_1_, p_6470_2_, p_6470_3_);
            if(var5 == 0) {
               this.field_9439_j = false;
               return;
            }

            Block var6 = Block.field_345_n[var5];
            this.field_9442_f += var6.func_225_a(this.field_1065_a.field_6322_g);
            if(this.field_9441_h % 4.0F == 0.0F && var6 != null) {
               this.field_1065_a.field_6301_A.func_336_b(var6.field_358_bl.func_1145_d(), (float)p_6470_1_ + 0.5F, (float)p_6470_2_ + 0.5F, (float)p_6470_3_ + 0.5F, (var6.field_358_bl.func_1147_b() + 1.0F) / 8.0F, var6.field_358_bl.func_1144_c() * 0.5F);
            }

            ++this.field_9441_h;
            if(this.field_9442_f >= 1.0F) {
               this.field_9439_j = false;
               this.field_9438_k.func_847_a(new Packet14BlockDig(2, p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_));
               this.func_729_b(p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_);
               this.field_9442_f = 0.0F;
               this.field_1080_g = 0.0F;
               this.field_9441_h = 0.0F;
               this.field_9440_i = 5;
            }
         } else {
            this.func_719_a(p_6470_1_, p_6470_2_, p_6470_3_, p_6470_4_);
         }

      }
   }

   public void func_6467_a(float p_6467_1_) {
      if(this.field_9442_f <= 0.0F) {
         this.field_1065_a.field_6308_u.field_6446_b = 0.0F;
         this.field_1065_a.field_6323_f.field_1450_i = 0.0F;
      } else {
         float var2 = this.field_1080_g + (this.field_9442_f - this.field_1080_g) * p_6467_1_;
         this.field_1065_a.field_6308_u.field_6446_b = var2;
         this.field_1065_a.field_6323_f.field_1450_i = var2;
      }

   }

   public float func_727_b() {
      return this.field_35649_k?5.0F:4.5F;
   }

   public void func_717_a(World p_717_1_) {
      super.func_717_a(p_717_1_);
   }

   public void func_6474_c() {
      this.func_730_e();
      this.field_1080_g = this.field_9442_f;
      this.field_1065_a.field_6301_A.func_4033_c();
   }

   private void func_730_e() {
      int var1 = this.field_1065_a.field_6322_g.field_778_b.field_847_d;
      if(var1 != this.field_1075_l) {
         this.field_1075_l = var1;
         this.field_9438_k.func_847_a(new Packet16BlockItemSwitch(this.field_1075_l));
      }

   }

   public boolean func_722_a(EntityPlayer p_722_1_, World p_722_2_, ItemStack p_722_3_, int p_722_4_, int p_722_5_, int p_722_6_, int p_722_7_) {
      this.func_730_e();
      this.field_9438_k.func_847_a(new Packet15Place(p_722_4_, p_722_5_, p_722_6_, p_722_7_, p_722_1_.field_778_b.func_494_a()));
      int var8 = p_722_2_.func_600_a(p_722_4_, p_722_5_, p_722_6_);
      if(var8 > 0 && Block.field_345_n[var8].func_250_a(p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_1_)) {
         return true;
      } else if(p_722_3_ == null) {
         return false;
      } else if(this.field_35649_k) {
         int var9 = p_722_3_.func_21181_i();
         int var10 = p_722_3_.field_1615_a;
         boolean var11 = p_722_3_.func_1090_a(p_722_1_, p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_7_);
         p_722_3_.func_28156_b(var9);
         p_722_3_.field_1615_a = var10;
         return var11;
      } else {
         return p_722_3_.func_1090_a(p_722_1_, p_722_2_, p_722_4_, p_722_5_, p_722_6_, p_722_7_);
      }
   }

   public boolean func_6471_a(EntityPlayer p_6471_1_, World p_6471_2_, ItemStack p_6471_3_) {
      this.func_730_e();
      this.field_9438_k.func_847_a(new Packet15Place(-1, -1, -1, 255, p_6471_1_.field_778_b.func_494_a()));
      boolean var4 = super.func_6471_a(p_6471_1_, p_6471_2_, p_6471_3_);
      return var4;
   }

   public EntityPlayer func_4087_b(World p_4087_1_) {
      return new EntityClientPlayerMP(this.field_1065_a, p_4087_1_, this.field_1065_a.field_6320_i, this.field_9438_k);
   }

   public void func_6472_b(EntityPlayer p_6472_1_, Entity p_6472_2_) {
      this.func_730_e();
      this.field_9438_k.func_847_a(new Packet7UseEntity(p_6472_1_.field_620_ab, p_6472_2_.field_620_ab, 1));
      p_6472_1_.func_463_a(p_6472_2_);
   }

   public void func_6475_a(EntityPlayer p_6475_1_, Entity p_6475_2_) {
      this.func_730_e();
      this.field_9438_k.func_847_a(new Packet7UseEntity(p_6475_1_.field_620_ab, p_6475_2_.field_620_ab, 0));
      p_6475_1_.func_6415_a_(p_6475_2_);
   }

   public ItemStack func_27174_a(int p_27174_1_, int p_27174_2_, int p_27174_3_, boolean p_27174_4_, EntityPlayer p_27174_5_) {
      short var6 = p_27174_5_.field_20068_h.func_20111_a(p_27174_5_.field_778_b);
      ItemStack var7 = super.func_27174_a(p_27174_1_, p_27174_2_, p_27174_3_, p_27174_4_, p_27174_5_);
      this.field_9438_k.func_847_a(new Packet102WindowClick(p_27174_1_, p_27174_2_, p_27174_3_, p_27174_4_, var7, var6));
      return var7;
   }

   public void func_40593_a(int p_40593_1_, int p_40593_2_) {
      this.field_9438_k.func_847_a(new Packet108EnchantItem(p_40593_1_, p_40593_2_));
   }

   public void func_35637_a(ItemStack p_35637_1_, int p_35637_2_) {
      if(this.field_35649_k) {
         this.field_9438_k.func_847_a(new Packet107CreativeSetSlot(p_35637_2_, p_35637_1_));
      }

   }

   public void func_35639_a(ItemStack p_35639_1_) {
      if(this.field_35649_k && p_35639_1_ != null) {
         this.field_9438_k.func_847_a(new Packet107CreativeSetSlot(-1, p_35639_1_));
      }

   }

   public void func_20086_a(int p_20086_1_, EntityPlayer p_20086_2_) {
      if(p_20086_1_ != -9999) {
         ;
      }
   }

   public void func_35638_c(EntityPlayer p_35638_1_) {
      this.func_730_e();
      this.field_9438_k.func_847_a(new Packet14BlockDig(5, 0, 0, 0, 255));
      super.func_35638_c(p_35638_1_);
   }

   public boolean func_35642_f() {
      return true;
   }

   public boolean func_35641_g() {
      return !this.field_35649_k;
   }

   public boolean func_35640_h() {
      return this.field_35649_k;
   }

   public boolean func_35636_i() {
      return this.field_35649_k;
   }
}
