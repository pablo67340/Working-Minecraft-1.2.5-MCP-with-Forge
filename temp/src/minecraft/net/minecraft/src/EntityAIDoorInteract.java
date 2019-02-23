package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.PathPoint;

public abstract class EntityAIDoorInteract extends EntityAIBase {

   protected EntityLiving field_48325_a;
   protected int field_48323_b;
   protected int field_48324_c;
   protected int field_48321_d;
   protected BlockDoor field_48322_e;
   boolean field_48319_f;
   float field_48320_g;
   float field_48326_h;


   public EntityAIDoorInteract(EntityLiving p_i1045_1_) {
      this.field_48325_a = p_i1045_1_;
   }

   public boolean func_46082_a() {
      if(!this.field_48325_a.field_9297_aI) {
         return false;
      } else {
         PathNavigate var1 = this.field_48325_a.func_48084_aL();
         PathEntity var2 = var1.func_48670_c();
         if(var2 != null && !var2.func_1207_b() && var1.func_48665_b()) {
            for(int var3 = 0; var3 < Math.min(var2.func_48643_e() + 2, var2.func_48644_d()); ++var3) {
               PathPoint var4 = var2.func_48648_a(var3);
               this.field_48323_b = var4.field_1718_a;
               this.field_48324_c = var4.field_1717_b + 1;
               this.field_48321_d = var4.field_1716_c;
               if(this.field_48325_a.func_360_d((double)this.field_48323_b, this.field_48325_a.field_610_al, (double)this.field_48321_d) <= 2.25D) {
                  this.field_48322_e = this.func_48318_a(this.field_48323_b, this.field_48324_c, this.field_48321_d);
                  if(this.field_48322_e != null) {
                     return true;
                  }
               }
            }

            this.field_48323_b = MathHelper.func_1108_b(this.field_48325_a.field_611_ak);
            this.field_48324_c = MathHelper.func_1108_b(this.field_48325_a.field_610_al + 1.0D);
            this.field_48321_d = MathHelper.func_1108_b(this.field_48325_a.field_609_am);
            this.field_48322_e = this.func_48318_a(this.field_48323_b, this.field_48324_c, this.field_48321_d);
            return this.field_48322_e != null;
         } else {
            return false;
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_48319_f;
   }

   public void func_46080_e() {
      this.field_48319_f = false;
      this.field_48320_g = (float)((double)((float)this.field_48323_b + 0.5F) - this.field_48325_a.field_611_ak);
      this.field_48326_h = (float)((double)((float)this.field_48321_d + 0.5F) - this.field_48325_a.field_609_am);
   }

   public void func_46081_b() {
      float var1 = (float)((double)((float)this.field_48323_b + 0.5F) - this.field_48325_a.field_611_ak);
      float var2 = (float)((double)((float)this.field_48321_d + 0.5F) - this.field_48325_a.field_609_am);
      float var3 = this.field_48320_g * var1 + this.field_48326_h * var2;
      if(var3 < 0.0F) {
         this.field_48319_f = true;
      }

   }

   private BlockDoor func_48318_a(int p_48318_1_, int p_48318_2_, int p_48318_3_) {
      int var4 = this.field_48325_a.field_615_ag.func_600_a(p_48318_1_, p_48318_2_, p_48318_3_);
      if(var4 != Block.field_442_aF.field_376_bc) {
         return null;
      } else {
         BlockDoor var5 = (BlockDoor)Block.field_345_n[var4];
         return var5;
      }
   }
}
