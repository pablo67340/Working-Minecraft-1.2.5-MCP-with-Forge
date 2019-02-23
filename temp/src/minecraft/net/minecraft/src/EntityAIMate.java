package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.World;

public class EntityAIMate extends EntityAIBase {

   private EntityAnimal field_48259_d;
   World field_48263_a;
   private EntityAnimal field_48260_e;
   int field_48261_b = 0;
   float field_48262_c;


   public EntityAIMate(EntityAnimal p_i1021_1_, float p_i1021_2_) {
      this.field_48259_d = p_i1021_1_;
      this.field_48263_a = p_i1021_1_.field_615_ag;
      this.field_48262_c = p_i1021_2_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      if(!this.field_48259_d.func_48136_o_()) {
         return false;
      } else {
         this.field_48260_e = this.func_48258_h();
         return this.field_48260_e != null;
      }
   }

   public boolean func_46084_g() {
      return this.field_48260_e.func_354_B() && this.field_48260_e.func_48136_o_() && this.field_48261_b < 60;
   }

   public void func_46077_d() {
      this.field_48260_e = null;
      this.field_48261_b = 0;
   }

   public void func_46081_b() {
      this.field_48259_d.func_46008_aG().func_46141_a(this.field_48260_e, 10.0F, (float)this.field_48259_d.func_25026_x());
      this.field_48259_d.func_48084_aL().func_48667_a(this.field_48260_e, this.field_48262_c);
      ++this.field_48261_b;
      if(this.field_48261_b == 60) {
         this.func_48257_i();
      }

   }

   private EntityAnimal func_48258_h() {
      float var1 = 8.0F;
      List var2 = this.field_48263_a.func_657_a(this.field_48259_d.getClass(), this.field_48259_d.field_601_au.func_1177_b((double)var1, (double)var1, (double)var1));
      Iterator var3 = var2.iterator();

      EntityAnimal var5;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         Entity var4 = (Entity)var3.next();
         var5 = (EntityAnimal)var4;
      } while(!this.field_48259_d.func_48135_b(var5));

      return var5;
   }

   private void func_48257_i() {
      EntityAnimal var1 = this.field_48259_d.func_40145_a(this.field_48260_e);
      if(var1 != null) {
         this.field_48259_d.func_48122_d(6000);
         this.field_48260_e.func_48122_d(6000);
         this.field_48259_d.func_48134_p_();
         this.field_48260_e.func_48134_p_();
         var1.func_48122_d(-24000);
         var1.func_365_c(this.field_48259_d.field_611_ak, this.field_48259_d.field_610_al, this.field_48259_d.field_609_am, 0.0F, 0.0F);
         this.field_48263_a.func_674_a(var1);
         Random var2 = this.field_48259_d.func_46004_aK();

         for(int var3 = 0; var3 < 7; ++var3) {
            double var4 = var2.nextGaussian() * 0.02D;
            double var6 = var2.nextGaussian() * 0.02D;
            double var8 = var2.nextGaussian() * 0.02D;
            this.field_48263_a.func_694_a("heart", this.field_48259_d.field_611_ak + (double)(var2.nextFloat() * this.field_48259_d.field_644_aC * 2.0F) - (double)this.field_48259_d.field_644_aC, this.field_48259_d.field_610_al + 0.5D + (double)(var2.nextFloat() * this.field_48259_d.field_643_aD), this.field_48259_d.field_609_am + (double)(var2.nextFloat() * this.field_48259_d.field_644_aC * 2.0F) - (double)this.field_48259_d.field_644_aC, var4, var6, var8);
         }

      }
   }
}
