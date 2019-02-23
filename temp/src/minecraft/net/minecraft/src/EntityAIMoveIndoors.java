package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;
import net.minecraft.src.Village;
import net.minecraft.src.VillageDoorInfo;

public class EntityAIMoveIndoors extends EntityAIBase {

   private EntityCreature field_48256_a;
   private VillageDoorInfo field_48254_b;
   private int field_48255_c = -1;
   private int field_48253_d = -1;


   public EntityAIMoveIndoors(EntityCreature p_i1027_1_) {
      this.field_48256_a = p_i1027_1_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if((!this.field_48256_a.field_615_ag.func_624_b() || this.field_48256_a.field_615_ag.func_27161_C()) && !this.field_48256_a.field_615_ag.field_4209_q.field_6478_e) {
         if(this.field_48256_a.func_46004_aK().nextInt(50) != 0) {
            return false;
         } else if(this.field_48255_c != -1 && this.field_48256_a.func_360_d((double)this.field_48255_c, this.field_48256_a.field_610_al, (double)this.field_48253_d) < 4.0D) {
            return false;
         } else {
            Village var1 = this.field_48256_a.field_615_ag.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_48256_a.field_611_ak), MathHelper.func_1108_b(this.field_48256_a.field_610_al), MathHelper.func_1108_b(this.field_48256_a.field_609_am), 14);
            if(var1 == null) {
               return false;
            } else {
               this.field_48254_b = var1.func_48540_c(MathHelper.func_1108_b(this.field_48256_a.field_611_ak), MathHelper.func_1108_b(this.field_48256_a.field_610_al), MathHelper.func_1108_b(this.field_48256_a.field_609_am));
               return this.field_48254_b != null;
            }
         }
      } else {
         return false;
      }
   }

   public boolean func_46084_g() {
      return !this.field_48256_a.func_48084_aL().func_46072_b();
   }

   public void func_46080_e() {
      this.field_48255_c = -1;
      if(this.field_48256_a.func_360_d((double)this.field_48254_b.func_48590_a(), (double)this.field_48254_b.field_48598_b, (double)this.field_48254_b.func_48591_c()) > 256.0D) {
         Vec3D var1 = RandomPositionGenerator.func_48620_a(this.field_48256_a, 14, 3, Vec3D.func_1248_b((double)this.field_48254_b.func_48590_a() + 0.5D, (double)this.field_48254_b.func_48592_b(), (double)this.field_48254_b.func_48591_c() + 0.5D));
         if(var1 != null) {
            this.field_48256_a.func_48084_aL().func_48666_a(var1.field_1776_a, var1.field_1775_b, var1.field_1779_c, 0.3F);
         }
      } else {
         this.field_48256_a.func_48084_aL().func_48666_a((double)this.field_48254_b.func_48590_a() + 0.5D, (double)this.field_48254_b.func_48592_b(), (double)this.field_48254_b.func_48591_c() + 0.5D, 0.3F);
      }

   }

   public void func_46077_d() {
      this.field_48255_c = this.field_48254_b.func_48590_a();
      this.field_48253_d = this.field_48254_b.func_48591_c();
      this.field_48254_b = null;
   }
}
