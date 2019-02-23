package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIAvoidEntity extends EntityAIBase {

   private EntityCreature field_48244_a;
   private float field_48242_b;
   private float field_48243_c;
   private Entity field_48240_d;
   private float field_48241_e;
   private PathEntity field_48238_f;
   private PathNavigate field_48239_g;
   private Class field_48245_h;


   public EntityAIAvoidEntity(EntityCreature p_i1032_1_, Class p_i1032_2_, float p_i1032_3_, float p_i1032_4_, float p_i1032_5_) {
      this.field_48244_a = p_i1032_1_;
      this.field_48245_h = p_i1032_2_;
      this.field_48241_e = p_i1032_3_;
      this.field_48242_b = p_i1032_4_;
      this.field_48243_c = p_i1032_5_;
      this.field_48239_g = p_i1032_1_.func_48084_aL();
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_48245_h == EntityPlayer.class) {
         if(this.field_48244_a instanceof EntityTameable && ((EntityTameable)this.field_48244_a).func_48139_F_()) {
            return false;
         }

         this.field_48240_d = this.field_48244_a.field_615_ag.func_609_a(this.field_48244_a, (double)this.field_48241_e);
         if(this.field_48240_d == null) {
            return false;
         }
      } else {
         List var1 = this.field_48244_a.field_615_ag.func_657_a(this.field_48245_h, this.field_48244_a.field_601_au.func_1177_b((double)this.field_48241_e, 3.0D, (double)this.field_48241_e));
         if(var1.size() == 0) {
            return false;
         }

         this.field_48240_d = (Entity)var1.get(0);
      }

      if(!this.field_48244_a.func_48090_aM().func_48480_a(this.field_48240_d)) {
         return false;
      } else {
         Vec3D var2 = RandomPositionGenerator.func_48623_b(this.field_48244_a, 16, 7, Vec3D.func_1248_b(this.field_48240_d.field_611_ak, this.field_48240_d.field_610_al, this.field_48240_d.field_609_am));
         if(var2 == null) {
            return false;
         } else if(this.field_48240_d.func_360_d(var2.field_1776_a, var2.field_1775_b, var2.field_1779_c) < this.field_48240_d.func_387_e(this.field_48244_a)) {
            return false;
         } else {
            this.field_48238_f = this.field_48239_g.func_48671_a(var2.field_1776_a, var2.field_1775_b, var2.field_1779_c);
            return this.field_48238_f == null?false:this.field_48238_f.func_48639_a(var2);
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_48239_g.func_46072_b();
   }

   public void func_46080_e() {
      this.field_48239_g.func_48678_a(this.field_48238_f, this.field_48242_b);
   }

   public void func_46077_d() {
      this.field_48240_d = null;
   }

   public void func_46081_b() {
      if(this.field_48244_a.func_387_e(this.field_48240_d) < 49.0D) {
         this.field_48244_a.func_48084_aL().func_48660_a(this.field_48243_c);
      } else {
         this.field_48244_a.func_48084_aL().func_48660_a(this.field_48242_b);
      }

   }
}
