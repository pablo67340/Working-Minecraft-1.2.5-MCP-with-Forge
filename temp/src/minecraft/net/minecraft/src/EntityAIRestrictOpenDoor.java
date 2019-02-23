package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Village;
import net.minecraft.src.VillageDoorInfo;

public class EntityAIRestrictOpenDoor extends EntityAIBase {

   private EntityCreature field_48365_a;
   private VillageDoorInfo field_48364_b;


   public EntityAIRestrictOpenDoor(EntityCreature p_i1070_1_) {
      this.field_48365_a = p_i1070_1_;
   }

   public boolean func_46082_a() {
      if(this.field_48365_a.field_615_ag.func_624_b()) {
         return false;
      } else {
         Village var1 = this.field_48365_a.field_615_ag.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_48365_a.field_611_ak), MathHelper.func_1108_b(this.field_48365_a.field_610_al), MathHelper.func_1108_b(this.field_48365_a.field_609_am), 16);
         if(var1 == null) {
            return false;
         } else {
            this.field_48364_b = var1.func_48527_b(MathHelper.func_1108_b(this.field_48365_a.field_611_ak), MathHelper.func_1108_b(this.field_48365_a.field_610_al), MathHelper.func_1108_b(this.field_48365_a.field_609_am));
            return this.field_48364_b == null?false:(double)this.field_48364_b.func_48593_b(MathHelper.func_1108_b(this.field_48365_a.field_611_ak), MathHelper.func_1108_b(this.field_48365_a.field_610_al), MathHelper.func_1108_b(this.field_48365_a.field_609_am)) < 2.25D;
         }
      }
   }

   public boolean func_46084_g() {
      return this.field_48365_a.field_615_ag.func_624_b()?false:!this.field_48364_b.field_48595_g && this.field_48364_b.func_48586_a(MathHelper.func_1108_b(this.field_48365_a.field_611_ak), MathHelper.func_1108_b(this.field_48365_a.field_609_am));
   }

   public void func_46080_e() {
      this.field_48365_a.func_48084_aL().func_48673_b(false);
      this.field_48365_a.func_48084_aL().func_48663_c(false);
   }

   public void func_46077_d() {
      this.field_48365_a.func_48084_aL().func_48673_b(true);
      this.field_48365_a.func_48084_aL().func_48663_c(true);
      this.field_48364_b = null;
   }

   public void func_46081_b() {
      this.field_48364_b.func_48589_e();
   }
}
