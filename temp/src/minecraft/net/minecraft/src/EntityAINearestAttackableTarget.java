package net.minecraft.src;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAINearestAttackableTargetSorter;
import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;

public class EntityAINearestAttackableTarget extends EntityAITarget {

   EntityLiving field_48389_a;
   Class field_48388_b;
   int field_48386_f;
   private EntityAINearestAttackableTargetSorter field_48387_g;


   public EntityAINearestAttackableTarget(EntityLiving p_i1022_1_, Class p_i1022_2_, float p_i1022_3_, int p_i1022_4_, boolean p_i1022_5_) {
      this(p_i1022_1_, p_i1022_2_, p_i1022_3_, p_i1022_4_, p_i1022_5_, false);
   }

   public EntityAINearestAttackableTarget(EntityLiving p_i1023_1_, Class p_i1023_2_, float p_i1023_3_, int p_i1023_4_, boolean p_i1023_5_, boolean p_i1023_6_) {
      super(p_i1023_1_, p_i1023_3_, p_i1023_5_, p_i1023_6_);
      this.field_48388_b = p_i1023_2_;
      this.field_48379_d = p_i1023_3_;
      this.field_48386_f = p_i1023_4_;
      this.field_48387_g = new EntityAINearestAttackableTargetSorter(this, p_i1023_1_);
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_48386_f > 0 && this.field_48382_c.func_46004_aK().nextInt(this.field_48386_f) != 0) {
         return false;
      } else {
         if(this.field_48388_b == EntityPlayer.class) {
            EntityPlayer var1 = this.field_48382_c.field_615_ag.func_40480_b(this.field_48382_c, (double)this.field_48379_d);
            if(this.func_48376_a(var1, false)) {
               this.field_48389_a = var1;
               return true;
            }
         } else {
            List var5 = this.field_48382_c.field_615_ag.func_657_a(this.field_48388_b, this.field_48382_c.field_601_au.func_1177_b((double)this.field_48379_d, 4.0D, (double)this.field_48379_d));
            Collections.sort(var5, this.field_48387_g);
            Iterator var2 = var5.iterator();

            while(var2.hasNext()) {
               Entity var3 = (Entity)var2.next();
               EntityLiving var4 = (EntityLiving)var3;
               if(this.func_48376_a(var4, false)) {
                  this.field_48389_a = var4;
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void func_46080_e() {
      this.field_48382_c.func_48092_c(this.field_48389_a);
      super.func_46080_e();
   }
}
