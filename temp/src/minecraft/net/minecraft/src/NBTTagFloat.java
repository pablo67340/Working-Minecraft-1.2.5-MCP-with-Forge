package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagFloat extends NBTBase {

   public float field_1097_a;


   public NBTTagFloat(String p_i465_1_) {
      super(p_i465_1_);
   }

   public NBTTagFloat(String p_i466_1_, float p_i466_2_) {
      super(p_i466_1_);
      this.field_1097_a = p_i466_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeFloat(this.field_1097_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      this.field_1097_a = p_736_1_.readFloat();
   }

   public byte func_733_a() {
      return (byte)5;
   }

   public String toString() {
      return "" + this.field_1097_a;
   }

   public NBTBase func_40195_b() {
      return new NBTTagFloat(this.func_737_b(), this.field_1097_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagFloat var2 = (NBTTagFloat)p_equals_1_;
         return this.field_1097_a == var2.field_1097_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.field_1097_a);
   }
}
