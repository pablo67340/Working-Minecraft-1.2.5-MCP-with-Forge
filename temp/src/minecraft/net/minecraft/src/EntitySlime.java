package net.minecraft.src;

import net.minecraft.src.Chunk;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IMob;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySlime extends EntityLiving implements IMob {

   public float field_40139_a;
   public float field_768_a;
   public float field_767_b;
   private int field_769_d = 0;


   public EntitySlime(World p_i151_1_) {
      super(p_i151_1_);
      this.field_9357_z = "/mob/slime.png";
      int var2 = 1 << this.field_9312_bd.nextInt(3);
      this.field_9292_aO = 0.0F;
      this.field_769_d = this.field_9312_bd.nextInt(20) + 10;
      this.func_441_c(var2);
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Byte((byte)1));
   }

   public void func_441_c(int p_441_1_) {
      this.field_21064_bx.func_21129_b(16, new Byte((byte)p_441_1_));
      this.func_371_a(0.6F * (float)p_441_1_, 0.6F * (float)p_441_1_);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.func_40121_k(this.func_40117_c());
      this.field_35171_bJ = p_441_1_;
   }

   public int func_40117_c() {
      int var1 = this.func_25027_v();
      return var1 * var1;
   }

   public int func_25027_v() {
      return this.field_21064_bx.func_21130_a(16);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("Size", this.func_25027_v() - 1);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_441_c(p_357_1_.func_756_e("Size") + 1);
   }

   protected String func_40135_ac() {
      return "slime";
   }

   protected String func_40138_aj() {
      return "mob.slime";
   }

   public void func_370_e_() {
      if(!this.field_615_ag.field_1026_y && this.field_615_ag.field_1039_l == 0 && this.func_25027_v() > 0) {
         this.field_646_aA = true;
      }

      this.field_768_a += (this.field_40139_a - this.field_768_a) * 0.5F;
      this.field_767_b = this.field_768_a;
      boolean var1 = this.field_9298_aH;
      super.func_370_e_();
      if(this.field_9298_aH && !var1) {
         int var2 = this.func_25027_v();

         for(int var3 = 0; var3 < var2 * 8; ++var3) {
            float var4 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
            float var5 = this.field_9312_bd.nextFloat() * 0.5F + 0.5F;
            float var6 = MathHelper.func_1106_a(var4) * (float)var2 * 0.5F * var5;
            float var7 = MathHelper.func_1114_b(var4) * (float)var2 * 0.5F * var5;
            this.field_615_ag.func_694_a(this.func_40135_ac(), this.field_611_ak + (double)var6, this.field_601_au.field_1697_b, this.field_609_am + (double)var7, 0.0D, 0.0D, 0.0D);
         }

         if(this.func_40134_ak()) {
            this.field_615_ag.func_623_a(this, this.func_40138_aj(), this.func_6393_h(), ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.field_40139_a = -0.5F;
      }

      this.func_40136_ag();
   }

   protected void func_418_b_() {
      this.func_27021_X();
      EntityPlayer var1 = this.field_615_ag.func_40480_b(this, 16.0D);
      if(var1 != null) {
         this.func_426_b(var1, 10.0F, 20.0F);
      }

      if(this.field_9298_aH && this.field_769_d-- <= 0) {
         this.field_769_d = this.func_40131_af();
         if(var1 != null) {
            this.field_769_d /= 3;
         }

         this.field_9336_ak = true;
         if(this.func_40133_ao()) {
            this.field_615_ag.func_623_a(this, this.func_40138_aj(), this.func_6393_h(), ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) * 0.8F);
         }

         this.field_40139_a = 1.0F;
         this.field_9342_ah = 1.0F - this.field_9312_bd.nextFloat() * 2.0F;
         this.field_9340_ai = (float)(1 * this.func_25027_v());
      } else {
         this.field_9336_ak = false;
         if(this.field_9298_aH) {
            this.field_9342_ah = this.field_9340_ai = 0.0F;
         }
      }

   }

   protected void func_40136_ag() {
      this.field_40139_a *= 0.6F;
   }

   protected int func_40131_af() {
      return this.field_9312_bd.nextInt(20) + 10;
   }

   protected EntitySlime func_40132_ae() {
      return new EntitySlime(this.field_615_ag);
   }

   public void func_395_F() {
      int var1 = this.func_25027_v();
      if(!this.field_615_ag.field_1026_y && var1 > 1 && this.func_40114_aH() <= 0) {
         int var2 = 2 + this.field_9312_bd.nextInt(3);

         for(int var3 = 0; var3 < var2; ++var3) {
            float var4 = ((float)(var3 % 2) - 0.5F) * (float)var1 / 4.0F;
            float var5 = ((float)(var3 / 2) - 0.5F) * (float)var1 / 4.0F;
            EntitySlime var6 = this.func_40132_ae();
            var6.func_441_c(var1 / 2);
            var6.func_365_c(this.field_611_ak + (double)var4, this.field_610_al + 0.5D, this.field_609_am + (double)var5, this.field_9312_bd.nextFloat() * 360.0F, 0.0F);
            this.field_615_ag.func_674_a(var6);
         }
      }

      super.func_395_F();
   }

   public void func_6378_b(EntityPlayer p_6378_1_) {
      if(this.func_40137_ah()) {
         int var2 = this.func_25027_v();
         if(this.func_420_c(p_6378_1_) && (double)this.func_379_d(p_6378_1_) < 0.6D * (double)var2 && p_6378_1_.func_396_a(DamageSource.func_35525_a(this), this.func_40130_ai())) {
            this.field_615_ag.func_623_a(this, "mob.slimeattack", 1.0F, (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
         }
      }

   }

   protected boolean func_40137_ah() {
      return this.func_25027_v() > 1;
   }

   protected int func_40130_ai() {
      return this.func_25027_v();
   }

   protected String func_6394_f_() {
      return "mob.slime";
   }

   protected String func_6390_f() {
      return "mob.slime";
   }

   protected int func_422_g() {
      return this.func_25027_v() == 1?Item.field_299_aK.field_291_aS:0;
   }

   public boolean func_433_a() {
      Chunk var1 = this.field_615_ag.func_673_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_609_am));
      return (this.func_25027_v() == 1 || this.field_615_ag.field_1039_l > 0) && this.field_9312_bd.nextInt(10) == 0 && var1.func_997_a(987234911L).nextInt(10) == 0 && this.field_610_al < 40.0D?super.func_433_a():false;
   }

   protected float func_6393_h() {
      return 0.4F * (float)this.func_25027_v();
   }

   public int func_25026_x() {
      return 0;
   }

   protected boolean func_40133_ao() {
      return this.func_25027_v() > 1;
   }

   protected boolean func_40134_ak() {
      return this.func_25027_v() > 2;
   }
}
