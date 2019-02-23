package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagShort extends NBTBase {

   public short field_1088_a;


   public NBTTagShort(String p_i504_1_) {
      super(p_i504_1_);
   }

   public NBTTagShort(String p_i505_1_, short p_i505_2_) {
      super(p_i505_1_);
      this.field_1088_a = p_i505_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeShort(this.field_1088_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1088_a = p_736_1_.readShort();
   }

   public byte func_733_a() {
      return (byte)2;
   }

   public String toString() {
      return "" + this.field_1088_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagShort(this.func_737_b(), this.field_1088_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagShort var2 = (NBTTagShort)p_equals_1_;
         return this.field_1088_a == var2.field_1088_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1088_a;
   }
}
