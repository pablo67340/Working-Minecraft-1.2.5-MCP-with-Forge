package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSilverfish;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDamageSource;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Facing;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySilverfish extends EntityMob {

   private int field_35189_a;


   public EntitySilverfish(World p_i551_1_) {
      super(p_i551_1_);
      this.field_9357_z = "/mob/silverfish.png";
      this.func_371_a(0.3F, 0.7F);
      this.field_9333_am = 0.6F;
      this.field_762_e = 1;
   }

   public int func_40117_c() {
      return 8;
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected Entity func_438_i() {
      double var1 = 8.0D;
      return this.field_615_ag.func_40480_b(this, var1);
   }

   protected String func_6389_d() {
      return "mob.silverfish.say";
   }

   protected String func_6394_f_() {
      return "mob.silverfish.hit";
   }

   protected String func_6390_f() {
      return "mob.silverfish.kill";
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(this.field_35189_a <= 0 && p_396_1_ instanceof EntityDamageSource) {
         this.field_35189_a = 20;
      }

      return super.func_396_a(p_396_1_, p_396_2_);
   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {
      if(this.field_9330_P <= 0 && p_437_2_ < 1.2F && p_437_1_.field_601_au.field_1702_e > this.field_601_au.field_1697_b && p_437_1_.field_601_au.field_1697_b < this.field_601_au.field_1702_e) {
         this.field_9330_P = 20;
         p_437_1_.func_396_a(DamageSource.func_35525_a(this), this.field_762_e);
      }

   }

   protected void func_41002_a(int p_41002_1_, int p_41002_2_, int p_41002_3_, int p_41002_4_) {
      this.field_615_ag.func_623_a(this, "mob.silverfish.step", 1.0F, 1.0F);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected int func_422_g() {
      return 0;
   }

   public void func_370_e_() {
      this.field_735_n = this.field_605_aq;
      super.func_370_e_();
   }

   protected void func_418_b_() {
      super.func_418_b_();
      if(!this.field_615_ag.field_1026_y) {
         int var1;
         int var2;
         int var3;
         int var5;
         if(this.field_35189_a > 0) {
            --this.field_35189_a;
            if(this.field_35189_a == 0) {
               var1 = MathHelper.func_1108_b(this.field_611_ak);
               var2 = MathHelper.func_1108_b(this.field_610_al);
               var3 = MathHelper.func_1108_b(this.field_609_am);
               boolean var4 = false;

               for(var5 = 0; !var4 && var5 <= 5 && var5 >= -5; var5 = var5 <= 0?1 - var5:0 - var5) {
                  for(int var6 = 0; !var4 && var6 <= 10 && var6 >= -10; var6 = var6 <= 0?1 - var6:0 - var6) {
                     for(int var7 = 0; !var4 && var7 <= 10 && var7 >= -10; var7 = var7 <= 0?1 - var7:0 - var7) {
                        int var8 = this.field_615_ag.func_600_a(var1 + var6, var2 + var5, var3 + var7);
                        if(var8 == Block.field_35289_bm.field_376_bc) {
                           this.field_615_ag.func_28106_e(2001, var1 + var6, var2 + var5, var3 + var7, Block.field_35289_bm.field_376_bc + (this.field_615_ag.func_602_e(var1 + var6, var2 + var5, var3 + var7) << 12));
                           this.field_615_ag.func_690_d(var1 + var6, var2 + var5, var3 + var7, 0);
                           Block.field_35289_bm.func_252_b(this.field_615_ag, var1 + var6, var2 + var5, var3 + var7, 0);
                           if(this.field_9312_bd.nextBoolean()) {
                              var4 = true;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         if(this.field_751_f == null && !this.func_25031_E()) {
            var1 = MathHelper.func_1108_b(this.field_611_ak);
            var2 = MathHelper.func_1108_b(this.field_610_al + 0.5D);
            var3 = MathHelper.func_1108_b(this.field_609_am);
            int var9 = this.field_9312_bd.nextInt(6);
            var5 = this.field_615_ag.func_600_a(var1 + Facing.field_31056_b[var9], var2 + Facing.field_31059_c[var9], var3 + Facing.field_31058_d[var9]);
            if(BlockSilverfish.func_35305_d(var5)) {
               this.field_615_ag.func_688_b(var1 + Facing.field_31056_b[var9], var2 + Facing.field_31059_c[var9], var3 + Facing.field_31058_d[var9], Block.field_35289_bm.field_376_bc, BlockSilverfish.func_35304_f(var5));
               this.func_415_z();
               this.func_395_F();
            } else {
               this.func_31026_E();
            }
         } else if(this.field_751_f != null && !this.func_25031_E()) {
            this.field_751_f = null;
         }

      }
   }

   public float func_439_a(int p_439_1_, int p_439_2_, int p_439_3_) {
      return this.field_615_ag.func_600_a(p_439_1_, p_439_2_ - 1, p_439_3_) == Block.field_338_u.field_376_bc?10.0F:super.func_439_a(p_439_1_, p_439_2_, p_439_3_);
   }

   protected boolean func_40147_Y() {
      return true;
   }

   public boolean func_433_a() {
      if(super.func_433_a()) {
         EntityPlayer var1 = this.field_615_ag.func_609_a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public EnumCreatureAttribute func_40124_t() {
      return EnumCreatureAttribute.ARTHROPOD;
   }
}
