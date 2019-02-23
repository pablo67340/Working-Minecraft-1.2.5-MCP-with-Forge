package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Vec3D;

public class MovingObjectPosition {

   public EnumMovingObjectType field_1167_a;
   public int field_1166_b;
   public int field_1172_c;
   public int field_1171_d;
   public int field_1170_e;
   public Vec3D field_1169_f;
   public Entity field_1168_g;


   public MovingObjectPosition(int p_i516_1_, int p_i516_2_, int p_i516_3_, int p_i516_4_, Vec3D p_i516_5_) {
      this.field_1167_a = EnumMovingObjectType.TILE;
      this.field_1166_b = p_i516_1_;
      this.field_1172_c = p_i516_2_;
      this.field_1171_d = p_i516_3_;
      this.field_1170_e = p_i516_4_;
      this.field_1169_f = Vec3D.func_1248_b(p_i516_5_.field_1776_a, p_i516_5_.field_1775_b, p_i516_5_.field_1779_c);
   }

   public MovingObjectPosition(Entity p_i517_1_) {
      this.field_1167_a = EnumMovingObjectType.ENTITY;
      this.field_1168_g = p_i517_1_;
      this.field_1169_f = Vec3D.func_1248_b(p_i517_1_.field_611_ak, p_i517_1_.field_610_al, p_i517_1_.field_609_am);
   }
}
