package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityEnderCrystal extends Entity {

   public int field_41032_a;
   public int field_41031_b;


   public EntityEnderCrystal(World p_i302_1_) {
      super(p_i302_1_);
      this.field_41032_a = 0;
      this.field_618_ad = true;
      this.func_371_a(2.0F, 2.0F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
      this.field_41031_b = 5;
      this.field_41032_a = this.field_9312_bd.nextInt(100000);
   }

   public EntityEnderCrystal(World p_i303_1_, double p_i303_2_, double p_i303_4_, double p_i303_6_) {
      this(p_i303_1_);
      this.func_347_a(p_i303_2_, p_i303_4_, p_i303_6_);
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected void func_21057_b() {
      this.field_21064_bx.func_21124_a(8, Integer.valueOf(this.field_41031_b));
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      ++this.field_41032_a;
      this.field_21064_bx.func_21129_b(8, Integer.valueOf(this.field_41031_b));
      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_610_al);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      if(this.field_615_ag.func_600_a(var1, var2, var3) != Block.field_402_as.field_376_bc) {
         this.field_615_ag.func_690_d(var1, var2, var3, Block.field_402_as.field_376_bc);
      }

   }

   protected void func_352_a(NBTTagCompound p_352_1_) {}

   protected void func_357_b(NBTTagCompound p_357_1_) {}

   public float func_392_h_() {
      return 0.0F;
   }

   public boolean func_401_c_() {
      return true;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(!this.field_646_aA && !this.field_615_ag.field_1026_y) {
         this.field_41031_b = 0;
         if(this.field_41031_b <= 0) {
            if(!this.field_615_ag.field_1026_y) {
               this.func_395_F();
               this.field_615_ag.func_12243_a((Entity)null, this.field_611_ak, this.field_610_al, this.field_609_am, 6.0F);
            } else {
               this.func_395_F();
            }
         }
      }

      return true;
   }
}
