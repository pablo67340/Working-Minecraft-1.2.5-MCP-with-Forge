package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class EntityAIBeg extends EntityAIBase {

   private EntityWolf field_48350_a;
   private EntityPlayer field_48348_b;
   private World field_48349_c;
   private float field_48346_d;
   private int field_48347_e;


   public EntityAIBeg(EntityWolf p_i1085_1_, float p_i1085_2_) {
      this.field_48350_a = p_i1085_1_;
      this.field_48349_c = p_i1085_1_.field_615_ag;
      this.field_48346_d = p_i1085_2_;
      this.func_46079_a(2);
   }

   public boolean func_46082_a() {
      this.field_48348_b = this.field_48349_c.func_609_a(this.field_48350_a, (double)this.field_48346_d);
      return this.field_48348_b == null?false:this.func_48345_a(this.field_48348_b);
   }

   public boolean func_46084_g() {
      return !this.field_48348_b.func_354_B()?false:(this.field_48350_a.func_387_e(this.field_48348_b) > (double)(this.field_48346_d * this.field_48346_d)?false:this.field_48347_e > 0 && this.func_48345_a(this.field_48348_b));
   }

   public void func_46080_e() {
      this.field_48350_a.func_48150_h(true);
      this.field_48347_e = 40 + this.field_48350_a.func_46004_aK().nextInt(40);
   }

   public void func_46077_d() {
      this.field_48350_a.func_48150_h(false);
      this.field_48348_b = null;
   }

   public void func_46081_b() {
      this.field_48350_a.func_46008_aG().func_46143_a(this.field_48348_b.field_611_ak, this.field_48348_b.field_610_al + (double)this.field_48348_b.func_373_s(), this.field_48348_b.field_609_am, 10.0F, (float)this.field_48350_a.func_25026_x());
      --this.field_48347_e;
   }

   private boolean func_48345_a(EntityPlayer p_48345_1_) {
      ItemStack var2 = p_48345_1_.field_778_b.func_494_a();
      return var2 == null?false:(!this.field_48350_a.func_48139_F_() && var2.field_1617_c == Item.field_21020_aV.field_291_aS?true:this.field_48350_a.func_40143_a(var2));
   }
}
