package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagEnd extends NBTBase {

   public NBTTagEnd() {
      super((String)null);
   }

   void func_736_a(DataInput p_736_1_) throws IOException {}

   void func_735_a(DataOutput p_735_1_) throws IOException {}

   public byte func_733_a() {
      return (byte)0;
   }

   public String toString() {
      return "END";
   }

   public NBTBase func_40195_b() {
      return new NBTTagEnd();
   }

   public boolean equals(Object p_equals_1_) {
      return super.equals(p_equals_1_);
   }
}
