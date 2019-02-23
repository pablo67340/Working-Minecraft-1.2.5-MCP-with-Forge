package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagInt extends NBTBase {

   public int field_1093_a;


   public NBTTagInt(String p_i85_1_) {
      super(p_i85_1_);
   }

   public NBTTagInt(String p_i86_1_, int p_i86_2_) {
      super(p_i86_1_);
      this.field_1093_a = p_i86_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeInt(this.field_1093_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1093_a = p_736_1_.readInt();
   }

   public byte func_733_a() {
      return (byte)3;
   }

   public String toString() {
      return "" + this.field_1093_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagInt(this.func_737_b(), this.field_1093_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagInt var2 = (NBTTagInt)p_equals_1_;
         return this.field_1093_a == var2.field_1093_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1093_a;
   }
}
