package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityHugeExplodeFX extends EntityFX {

   private int field_35139_a = 0;
   private int field_35138_ay = 0;


   public EntityHugeExplodeFX(World p_i188_1_, double p_i188_2_, double p_i188_4_, double p_i188_6_, double p_i188_8_, double p_i188_10_, double p_i188_12_) {
      super(p_i188_1_, p_i188_2_, p_i188_4_, p_i188_6_, 0.0D, 0.0D, 0.0D);
      this.field_35138_ay = 8;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {}

   public void func_370_e_() {
      for(int var1 = 0; var1 < 6; ++var1) {
         double var2 = this.field_611_ak + (this.field_9312_bd.nextDouble() - this.field_9312_bd.nextDouble()) * 4.0D;
         double var4 = this.field_610_al + (this.field_9312_bd.nextDouble() - this.field_9312_bd.nextDouble()) * 4.0D;
         double var6 = this.field_609_am + (this.field_9312_bd.nextDouble() - this.field_9312_bd.nextDouble()) * 4.0D;
         this.field_615_ag.func_694_a("largeexplode", var2, var4, var6, (double)((float)this.field_35139_a / (float)this.field_35138_ay), 0.0D, 0.0D);
      }

      ++this.field_35139_a;
      if(this.field_35139_a == this.field_35138_ay) {
         this.func_395_F();
      }

   }

   public int func_404_c() {
      return 1;
   }
}
