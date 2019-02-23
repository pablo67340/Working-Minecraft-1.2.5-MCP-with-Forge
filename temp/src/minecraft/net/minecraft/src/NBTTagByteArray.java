package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.src.NBTBase;

public class NBTTagByteArray extends NBTBase {

   public byte[] field_1096_a;


   public NBTTagByteArray(String p_i718_1_) {
      super(p_i718_1_);
   }

   public NBTTagByteArray(String p_i719_1_, byte[] p_i719_2_) {
      super(p_i719_1_);
      this.field_1096_a = p_i719_2_;
   }

   void func_735_a(DataOutput p_735_1_) throws IOException {
      p_735_1_.writeInt(this.field_1096_a.length);
      p_735_1_.write(this.field_1096_a);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {
      int var2 = p_736_1_.readInt();
      this.field_1096_a = new byte[var2];
      p_736_1_.readFully(this.field_1096_a);
   }

   public byte func_733_a() {
      return (byte)7;
   }

   public String toString() {
      return "[" + this.field_1096_a.length + " bytes]";
   }

   public NBTBase func_40195_b() {
      byte[] var1 = new byte[this.field_1096_a.length];
      System.arraycopy(this.field_1096_a, 0, var1, 0, this.field_1096_a.length);
      return new NBTTagByteArray(this.func_737_b(), var1);
   }

   public boolean equals(Object p_equals_1_) {
      return super.equals(p_equals_1_)?Arrays.equals(this.field_1096_a, ((NBTTagByteArray)p_equals_1_).field_1096_a):false;
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.field_1096_a);
   }
}
