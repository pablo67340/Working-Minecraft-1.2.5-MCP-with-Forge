package net.minecraft.src;

import net.minecraft.src.GameSettings;
import net.minecraft.src.MovementInput;

public class MovementInputFromOptions extends MovementInput {

   private GameSettings field_1178_g;


   public MovementInputFromOptions(GameSettings p_i372_1_) {
      this.field_1178_g = p_i372_1_;
   }

   public void func_52013_a() {
      this.field_1174_a = 0.0F;
      this.field_1173_b = 0.0F;
      if(this.field_1178_g.field_1575_j.field_35965_e) {
         ++this.field_1173_b;
      }

      if(this.field_1178_g.field_1573_l.field_35965_e) {
         --this.field_1173_b;
      }

      if(this.field_1178_g.field_1574_k.field_35965_e) {
         ++this.field_1174_a;
      }

      if(this.field_1178_g.field_1572_m.field_35965_e) {
         --this.field_1174_a;
      }

      this.field_1176_d = this.field_1178_g.field_1571_n.field_35965_e;
      this.field_1175_e = this.field_1178_g.field_1565_s.field_35965_e;
      if(this.field_1175_e) {
         this.field_1174_a = (float)((double)this.field_1174_a * 0.3D);
         this.field_1173_b = (float)((double)this.field_1173_b * 0.3D);
      }

   }
}
