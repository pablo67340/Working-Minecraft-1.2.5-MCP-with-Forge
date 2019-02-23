package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockBed;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;

public class EntityAIOcelotSit extends EntityAIBase {

   private final EntityOcelot field_50085_a;
   private final float field_50083_b;
   private int field_50084_c = 0;
   private int field_52011_h = 0;
   private int field_50081_d = 0;
   private int field_50082_e = 0;
   private int field_50079_f = 0;
   private int field_50080_g = 0;


   public EntityAIOcelotSit(EntityOcelot p_i1206_1_, float p_i1206_2_) {
      this.field_50085_a = p_i1206_1_;
      this.field_50083_b = p_i1206_2_;
      this.func_46079_a(5);
   }

   public boolean func_46082_a() {
      return this.field_50085_a.func_48139_F_() && !this.field_50085_a.func_48141_af() && this.field_50085_a.func_46004_aK().nextDouble() <= 0.006500000134110451D && this.func_50077_h();
   }

   public boolean func_46084_g() {
      return this.field_50084_c <= this.field_50081_d && this.field_52011_h <= 60 && this.func_50078_a(this.field_50085_a.field_615_ag, this.field_50082_e, this.field_50079_f, this.field_50080_g);
   }

   public void func_46080_e() {
      this.field_50085_a.func_48084_aL().func_48666_a((double)((float)this.field_50082_e) + 0.5D, (double)(this.field_50079_f + 1), (double)((float)this.field_50080_g) + 0.5D, this.field_50083_b);
      this.field_50084_c = 0;
      this.field_52011_h = 0;
      this.field_50081_d = this.field_50085_a.func_46004_aK().nextInt(this.field_50085_a.func_46004_aK().nextInt(1200) + 1200) + 1200;
      this.field_50085_a.func_50008_ai().func_48407_a(false);
   }

   public void func_46077_d() {
      this.field_50085_a.func_48140_f(false);
   }

   public void func_46081_b() {
      ++this.field_50084_c;
      this.field_50085_a.func_50008_ai().func_48407_a(false);
      if(this.field_50085_a.func_360_d((double)this.field_50082_e, (double)(this.field_50079_f + 1), (double)this.field_50080_g) > 1.0D) {
         this.field_50085_a.func_48140_f(false);
         this.field_50085_a.func_48084_aL().func_48666_a((double)((float)this.field_50082_e) + 0.5D, (double)(this.field_50079_f + 1), (double)((float)this.field_50080_g) + 0.5D, this.field_50083_b);
         ++this.field_52011_h;
      } else if(!this.field_50085_a.func_48141_af()) {
         this.field_50085_a.func_48140_f(true);
      } else {
         --this.field_52011_h;
      }

   }

   private boolean func_50077_h() {
      int var1 = (int)this.field_50085_a.field_610_al;
      double var2 = 2.147483647E9D;

      for(int var4 = (int)this.field_50085_a.field_611_ak - 8; (double)var4 < this.field_50085_a.field_611_ak + 8.0D; ++var4) {
         for(int var5 = (int)this.field_50085_a.field_609_am - 8; (double)var5 < this.field_50085_a.field_609_am + 8.0D; ++var5) {
            if(this.func_50078_a(this.field_50085_a.field_615_ag, var4, var1, var5) && this.field_50085_a.field_615_ag.func_20084_d(var4, var1 + 1, var5)) {
               double var6 = this.field_50085_a.func_360_d((double)var4, (double)var1, (double)var5);
               if(var6 < var2) {
                  this.field_50082_e = var4;
                  this.field_50079_f = var1;
                  this.field_50080_g = var5;
                  var2 = var6;
               }
            }
         }
      }

      return var2 < 2.147483647E9D;
   }

   private boolean func_50078_a(World p_50078_1_, int p_50078_2_, int p_50078_3_, int p_50078_4_) {
      int var5 = p_50078_1_.func_600_a(p_50078_2_, p_50078_3_, p_50078_4_);
      int var6 = p_50078_1_.func_602_e(p_50078_2_, p_50078_3_, p_50078_4_);
      if(var5 == Block.field_396_av.field_376_bc) {
         TileEntityChest var7 = (TileEntityChest)p_50078_1_.func_603_b(p_50078_2_, p_50078_3_, p_50078_4_);
         if(var7.field_35156_h < 1) {
            return true;
         }
      } else {
         if(var5 == Block.field_444_aD.field_376_bc) {
            return true;
         }

         if(var5 == Block.field_9262_S.field_376_bc && !BlockBed.func_22032_d(var6)) {
            return true;
         }
      }

      return false;
   }
}
