package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;

public class ChunkPosition {

   public final int field_1111_a;
   public final int field_1110_b;
   public final int field_1112_c;


   public ChunkPosition(int p_i552_1_, int p_i552_2_, int p_i552_3_) {
      this.field_1111_a = p_i552_1_;
      this.field_1110_b = p_i552_2_;
      this.field_1112_c = p_i552_3_;
   }

   public ChunkPosition(Vec3D p_i553_1_) {
      this(MathHelper.func_1108_b(p_i553_1_.field_1776_a), MathHelper.func_1108_b(p_i553_1_.field_1775_b), MathHelper.func_1108_b(p_i553_1_.field_1779_c));
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof ChunkPosition)) {
         return false;
      } else {
         ChunkPosition var2 = (ChunkPosition)p_equals_1_;
         return var2.field_1111_a == this.field_1111_a && var2.field_1110_b == this.field_1110_b && var2.field_1112_c == this.field_1112_c;
      }
   }

   public int hashCode() {
      return this.field_1111_a * 8976890 + this.field_1110_b * 981131 + this.field_1112_c;
   }
}
