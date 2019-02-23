package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntitySmallFireball extends EntityFireball {

   public EntitySmallFireball(World p_i534_1_) {
      super(p_i534_1_);
      this.func_371_a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World p_i535_1_, EntityLiving p_i535_2_, double p_i535_3_, double p_i535_5_, double p_i535_7_) {
      super(p_i535_1_, p_i535_2_, p_i535_3_, p_i535_5_, p_i535_7_);
      this.func_371_a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World p_i536_1_, double p_i536_2_, double p_i536_4_, double p_i536_6_, double p_i536_8_, double p_i536_10_, double p_i536_12_) {
      super(p_i536_1_, p_i536_2_, p_i536_4_, p_i536_6_, p_i536_8_, p_i536_10_, p_i536_12_);
      this.func_371_a(0.3125F, 0.3125F);
   }

   protected void func_40071_a(MovingObjectPosition p_40071_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(p_40071_1_.field_1168_g != null) {
            if(!p_40071_1_.field_1168_g.func_40047_D() && p_40071_1_.field_1168_g.func_396_a(DamageSource.func_35530_a(this, this.field_9397_j), 5)) {
               p_40071_1_.field_1168_g.func_40046_d(5);
            }
         } else {
            int var2 = p_40071_1_.field_1166_b;
            int var3 = p_40071_1_.field_1172_c;
            int var4 = p_40071_1_.field_1171_d;
            switch(p_40071_1_.field_1170_e) {
            case 0:
               --var3;
               break;
            case 1:
               ++var3;
               break;
            case 2:
               --var4;
               break;
            case 3:
               ++var4;
               break;
            case 4:
               --var2;
               break;
            case 5:
               ++var2;
            }

            if(this.field_615_ag.func_20084_d(var2, var3, var4)) {
               this.field_615_ag.func_690_d(var2, var3, var4, Block.field_402_as.field_376_bc);
            }
         }

         this.func_395_F();
      }

   }

   public boolean func_401_c_() {
      return false;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return false;
   }
}
