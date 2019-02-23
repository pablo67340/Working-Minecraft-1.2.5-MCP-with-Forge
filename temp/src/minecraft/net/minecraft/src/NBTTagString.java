package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagString extends NBTBase {

   public String field_1098_a;


   public NBTTagString(String p_i191_1_) {
      super(p_i191_1_);
   }

   public NBTTagString(String p_i192_1_, String p_i192_2_) {
      super(p_i192_1_);
      this.field_1098_a = p_i192_2_;
      if(p_i192_2_ == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeUTF(this.field_1098_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1098_a = p_736_1_.readUTF();
   }

   public byte func_733_a() {
      return (byte)8;
   }

   public String toString() {
      return "" + this.field_1098_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagString(this.func_737_b(), this.field_1098_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(!super.equals(p_equals_1_)) {
         return false;
      } else {
         NBTTagString var2 = (NBTTagString)p_equals_1_;
         return this.field_1098_a == null && var2.field_1098_a == null || this.field_1098_a != null && this.field_1098_a.equals(var2.field_1098_a);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1098_a.hashCode();
   }
}
