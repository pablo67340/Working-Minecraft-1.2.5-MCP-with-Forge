package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.src.NBTBase;

public class NBTTagIntArray extends NBTBase {

   public int[] field_48181_a;


   public NBTTagIntArray(String p_i1036_1_) {
      super(p_i1036_1_);
   }

   public NBTTagIntArray(String p_i1037_1_, int[] p_i1037_2_) {
      super(p_i1037_1_);
      this.field_48181_a = p_i1037_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeInt(this.field_48181_a.length);

      for(int var2 = 0; var2 < this.field_48181_a.length; ++var2) {
         p_735_1_.writeInt(this.field_48181_a[var2]);
      }

   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      int var2 = p_736_1_.readInt();
      this.field_48181_a = new int[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_48181_a[var3] = p_736_1_.readInt();
      }

   }

   public byte func_733_a() {
      return (byte)11;
   }

   public String toString() {
      return "[" + this.field_48181_a.length + " bytes]";
   }

   public NBTBase func_40195_b() {
      int[] var1 = new int[this.field_48181_a.length];
      System.arraycopy(this.field_48181_a, 0, var1, 0, this.field_48181_a.length);
      return new NBTTagIntArray(this.func_737_b(), var1);
   }

   public boolean equals(Object p_equals_1_) {
      if(!super.equals(p_equals_1_)) {
         return false;
      } else {
         NBTTagIntArray var2 = (NBTTagIntArray)p_equals_1_;
         return this.field_48181_a == null && var2.field_48181_a == null || this.field_48181_a != null && this.field_48181_a.equals(var2.field_48181_a);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.field_48181_a);
   }
}
