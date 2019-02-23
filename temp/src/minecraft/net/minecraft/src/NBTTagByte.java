package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagByte extends NBTBase {

   public byte field_1092_a;


   public NBTTagByte(String p_i449_1_) {
      super(p_i449_1_);
   }

   public NBTTagByte(String p_i450_1_, byte p_i450_2_) {
      super(p_i450_1_);
      this.field_1092_a = p_i450_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeByte(this.field_1092_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1092_a = p_736_1_.readByte();
   }

   public byte func_733_a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.field_1092_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagByte(this.func_737_b(), this.field_1092_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagByte var2 = (NBTTagByte)p_equals_1_;
         return this.field_1092_a == var2.field_1092_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_1092_a;
   }
}
