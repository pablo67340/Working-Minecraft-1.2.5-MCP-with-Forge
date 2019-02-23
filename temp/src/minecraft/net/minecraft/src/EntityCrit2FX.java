package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityCrit2FX extends EntityFX {

   private Entity field_35134_a;
   private int field_35133_ay;
   private int field_35132_az;
   private String field_40105_ay;


   public EntityCrit2FX(World p_i329_1_, Entity p_i329_2_) {
      this(p_i329_1_, p_i329_2_, "crit");
   }

   public EntityCrit2FX(World p_i330_1_, Entity p_i330_2_, String p_i330_3_) {
      super(p_i330_1_, p_i330_2_.field_611_ak, p_i330_2_.field_601_au.field_1697_b + (double)(p_i330_2_.field_643_aD / 2.0F), p_i330_2_.field_609_am, p_i330_2_.field_608_an, p_i330_2_.field_607_ao, p_i330_2_.field_606_ap);
      this.field_35133_ay = 0;
      this.field_35132_az = 0;
      this.field_35134_a = p_i330_2_;
      this.field_35132_az = 3;
      this.field_40105_ay = p_i330_3_;
      this.func_370_e_();
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {}

   public void func_370_e_() {
      for(int var1 = 0; var1 < 16; ++var1) {
         double var2 = (double)(this.field_9312_bd.nextFloat() * 2.0F - 1.0F);
         double var4 = (double)(this.field_9312_bd.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(this.field_9312_bd.nextFloat() * 2.0F - 1.0F);
         if(var2 * var2 + var4 * var4 + var6 * var6 <= 1.0D) {
            double var8 = this.field_35134_a.field_611_ak + var2 * (double)this.field_35134_a.field_644_aC / 4.0D;
            double var10 = this.field_35134_a.field_601_au.field_1697_b + (double)(this.field_35134_a.field_643_aD / 2.0F) + var4 * (double)this.field_35134_a.field_643_aD / 4.0D;
            double var12 = this.field_35134_a.field_609_am + var6 * (double)this.field_35134_a.field_644_aC / 4.0D;
            this.field_615_ag.func_694_a(this.field_40105_ay, var8, var10, var12, var2, var4 + 0.2D, var6);
         }
      }

      ++this.field_35133_ay;
      if(this.field_35133_ay >= this.field_35132_az) {
         this.func_395_F();
      }

   }

   public int func_404_c() {
      return 3;
   }
}
