package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagLong extends NBTBase {

   public long field_1095_a;


   public NBTTagLong(String p_i30_1_) {
      super(p_i30_1_);
   }

   public NBTTagLong(String p_i31_1_, long p_i31_2_) {
      super(p_i31_1_);
      this.field_1095_a = p_i31_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeLong(this.field_1095_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1095_a = p_736_1_.readLong();
   }

   public byte func_733_a() {
      return (byte)4;
   }

   public String toString() {
      return "" + this.field_1095_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagLong(this.func_737_b(), this.field_1095_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagLong var2 = (NBTTagLong)p_equals_1_;
         return this.field_1095_a == var2.field_1095_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ (int)(this.field_1095_a ^ this.field_1095_a >>> 32);
   }
}
