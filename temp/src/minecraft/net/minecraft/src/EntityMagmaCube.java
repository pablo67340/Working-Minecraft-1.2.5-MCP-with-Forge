package net.minecraft.src;

import net.minecraft.src.EntitySlime;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class EntityMagmaCube extends EntitySlime {

   public EntityMagmaCube(World p_i137_1_) {
      super(p_i137_1_);
      this.field_9357_z = "/mob/lava.png";
      this.field_9304_bm = true;
      this.field_35169_bv = 0.2F;
   }

   public boolean func_433_a() {
      return this.field_615_ag.field_1039_l > 0 && this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au);
   }

   public int func_40119_ar() {
      return this.func_25027_v() * 3;
   }

   public int func_35115_a(float p_35115_1_) {
      return 15728880;
   }

   public float func_382_a(float p_382_1_) {
      return 1.0F;
   }

   protected String func_40135_ac() {
      return "flame";
   }

   protected EntitySlime func_40132_ae() {
      return new EntityMagmaCube(this.field_615_ag);
   }

   protected int func_422_g() {
      return Item.field_40412_bx.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.func_422_g();
      if(var3 > 0 && this.func_25027_v() > 1) {
         int var4 = this.field_9312_bd.nextInt(4) - 2;
         if(p_21066_2_ > 0) {
            var4 += this.field_9312_bd.nextInt(p_21066_2_ + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.func_367_b(var3, 1);
         }
      }

   }

   public boolean func_21062_U() {
      return false;
   }

   protected int func_40131_af() {
      return super.func_40131_af() * 4;
   }

   protected void func_40136_ag() {
      this.field_40139_a *= 0.9F;
   }

   protected void func_424_C() {
      this.field_607_ao = (double)(0.42F + (float)this.func_25027_v() * 0.1F);
      this.field_35118_ao = true;
   }

   protected void func_400_c(float p_400_1_) {}

   protected boolean func_40137_ah() {
      return true;
   }

   protected int func_40130_ai() {
      return super.func_40130_ai() + 2;
   }

   protected String func_6394_f_() {
      return "mob.slime";
   }

   protected String func_6390_f() {
      return "mob.slime";
   }

   protected String func_40138_aj() {
      return this.func_25027_v() > 1?"mob.magmacube.big":"mob.magmacube.small";
   }

   public boolean func_359_G() {
      return false;
   }

   protected boolean func_40134_ak() {
      return true;
   }
}
