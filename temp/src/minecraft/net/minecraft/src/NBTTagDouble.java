package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagDouble extends NBTBase {

   public double field_1089_a;


   public NBTTagDouble(String p_i126_1_) {
      super(p_i126_1_);
   }

   public NBTTagDouble(String p_i127_1_, double p_i127_2_) {
      super(p_i127_1_);
      this.field_1089_a = p_i127_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeDouble(this.field_1089_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1089_a = p_736_1_.readDouble();
   }

   public byte func_733_a() {
      return (byte)6;
   }

   public String toString() {
      return "" + this.field_1089_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagDouble(this.func_737_b(), this.field_1089_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagDouble var2 = (NBTTagDouble)p_equals_1_;
         return this.field_1089_a == var2.field_1089_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.field_1089_a);
      return super.hashCode() ^ (int)(var1 ^ var1 >>> 32);
   }
}
