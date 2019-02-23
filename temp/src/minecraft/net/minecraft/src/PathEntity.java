package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.PathPoint;
import net.minecraft.src.Vec3D;

public class PathEntity {

   private final PathPoint[] field_1764_b;
   private int field_48649_b;
   private int field_1765_a;


   public PathEntity(PathPoint[] p_i652_1_) {
      this.field_1764_b = p_i652_1_;
      this.field_1765_a = p_i652_1_.length;
   }

   public void func_1206_a() {
      ++this.field_48649_b;
   }

   public boolean func_1207_b() {
      return this.field_48649_b >= this.field_1765_a;
   }

   public PathPoint func_48645_c() {
      return this.field_1765_a > 0?this.field_1764_b[this.field_1765_a - 1]:null;
   }

   public PathPoint func_48648_a(int p_48648_1_) {
      return this.field_1764_b[p_48648_1_];
   }

   public int func_48644_d() {
      return this.field_1765_a;
   }

   public void func_48641_b(int p_48641_1_) {
      this.field_1765_a = p_48641_1_;
   }

   public int func_48643_e() {
      return this.field_48649_b;
   }

   public void func_48642_c(int p_48642_1_) {
      this.field_48649_b = p_48642_1_;
   }

   public Vec3D func_48646_a(Entity p_48646_1_, int p_48646_2_) {
      double var3 = (double)this.field_1764_b[p_48646_2_].field_1718_a + (double)((int)(p_48646_1_.field_644_aC + 1.0F)) * 0.5D;
      double var5 = (double)this.field_1764_b[p_48646_2_].field_1717_b;
      double var7 = (double)this.field_1764_b[p_48646_2_].field_1716_c + (double)((int)(p_48646_1_.field_644_aC + 1.0F)) * 0.5D;
      return Vec3D.func_1248_b(var3, var5, var7);
   }

   public Vec3D func_48640_a(Entity p_48640_1_) {
      return this.func_48646_a(p_48640_1_, this.field_48649_b);
   }

   public boolean func_48647_a(PathEntity p_48647_1_) {
      if(p_48647_1_ == null) {
         return false;
      } else if(p_48647_1_.field_1764_b.length != this.field_1764_b.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.field_1764_b.length; ++var2) {
            if(this.field_1764_b[var2].field_1718_a != p_48647_1_.field_1764_b[var2].field_1718_a || this.field_1764_b[var2].field_1717_b != p_48647_1_.field_1764_b[var2].field_1717_b || this.field_1764_b[var2].field_1716_c != p_48647_1_.field_1764_b[var2].field_1716_c) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean func_48639_a(Vec3D p_48639_1_) {
      PathPoint var2 = this.func_48645_c();
      return var2 == null?false:var2.field_1718_a == (int)p_48639_1_.field_1776_a && var2.field_1716_c == (int)p_48639_1_.field_1779_c;
   }
}
