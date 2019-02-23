package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;
import net.minecraft.src.Village;
import net.minecraft.src.VillageDoorInfo;

public class EntityAIMoveThroughVillage extends EntityAIBase {

   private EntityCreature field_48292_a;
   private float field_48290_b;
   private PathEntity field_48291_c;
   private VillageDoorInfo field_48288_d;
   private boolean field_48289_e;
   private List field_48287_f = new ArrayList();


   public EntityAIMoveThroughVillage(EntityCreature p_i1019_1_, float p_i1019_2_, boolean p_i1019_3_) {
      this.field_48292_a = p_i1019_1_;
      this.field_48290_b = p_i1019_2_;
      this.field_48289_e = p_i1019_3_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      this.func_48286_h();
      if(this.field_48289_e && this.field_48292_a.field_615_ag.func_624_b()) {
         return false;
      } else {
         Village var1 = this.field_48292_a.field_615_ag.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_48292_a.field_611_ak), MathHelper.func_1108_b(this.field_48292_a.field_610_al), MathHelper.func_1108_b(this.field_48292_a.field_609_am), 0);
         if(var1 == null) {
            return false;
         } else {
            this.field_48288_d = this.func_48284_a(var1);
            if(this.field_48288_d == null) {
               return false;
            } else {
               boolean var2 = this.field_48292_a.func_48084_aL().func_48665_b();
               this.field_48292_a.func_48084_aL().func_48673_b(false);
               this.field_48291_c = this.field_48292_a.func_48084_aL().func_48671_a((double)this.field_48288_d.field_48600_a, (double)this.field_48288_d.field_48598_b, (double)this.field_48288_d.field_48599_c);
               this.field_48292_a.func_48084_aL().func_48673_b(var2);
               if(this.field_48291_c != null) {
                  return true;
               } else {
                  Vec3D var3 = RandomPositionGenerator.func_48620_a(this.field_48292_a, 10, 7, Vec3D.func_1248_b((double)this.field_48288_d.field_48600_a, (double)this.field_48288_d.field_48598_b, (double)this.field_48288_d.field_48599_c));
                  if(var3 == null) {
                     return false;
                  } else {
                     this.field_48292_a.func_48084_aL().func_48673_b(false);
                     this.field_48291_c = this.field_48292_a.func_48084_aL().func_48671_a(var3.field_1776_a, var3.field_1775_b, var3.field_1779_c);
                     this.field_48292_a.func_48084_aL().func_48673_b(var2);
                     return this.field_48291_c != null;
                  }
               }
            }
         }
      }
   }

   public boolean func_46084_g() {
      if(this.field_48292_a.func_48084_aL().func_46072_b()) {
         return false;
      } else {
         float var1 = this.field_48292_a.field_644_aC + 4.0F;
         return this.field_48292_a.func_360_d((double)this.field_48288_d.field_48600_a, (double)this.field_48288_d.field_48598_b, (double)this.field_48288_d.field_48599_c) > (double)(var1 * var1);
      }
   }

   public void func_46080_e() {
      this.field_48292_a.func_48084_aL().func_48678_a(this.field_48291_c, this.field_48290_b);
   }

   public void func_46077_d() {
      if(this.field_48292_a.func_48084_aL().func_46072_b() || this.field_48292_a.func_360_d((double)this.field_48288_d.field_48600_a, (double)this.field_48288_d.field_48598_b, (double)this.field_48288_d.field_48599_c) < 16.0D) {
         this.field_48287_f.add(this.field_48288_d);
      }

   }

   private VillageDoorInfo func_48284_a(Village p_48284_1_) {
      VillageDoorInfo var2 = null;
      int var3 = Integer.MAX_VALUE;
      List var4 = p_48284_1_.func_48521_f();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         VillageDoorInfo var6 = (VillageDoorInfo)var5.next();
         int var7 = var6.func_48588_a(MathHelper.func_1108_b(this.field_48292_a.field_611_ak), MathHelper.func_1108_b(this.field_48292_a.field_610_al), MathHelper.func_1108_b(this.field_48292_a.field_609_am));
         if(var7 < var3 && !this.func_48285_a(var6)) {
            var2 = var6;
            var3 = var7;
         }
      }

      return var2;
   }

   private boolean func_48285_a(VillageDoorInfo p_48285_1_) {
      Iterator var2 = this.field_48287_f.iterator();

      VillageDoorInfo var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (VillageDoorInfo)var2.next();
      } while(p_48285_1_.field_48600_a != var3.field_48600_a || p_48285_1_.field_48598_b != var3.field_48598_b || p_48285_1_.field_48599_c != var3.field_48599_c);

      return true;
   }

   private void func_48286_h() {
      if(this.field_48287_f.size() > 15) {
         this.field_48287_f.remove(0);
      }

   }
}
