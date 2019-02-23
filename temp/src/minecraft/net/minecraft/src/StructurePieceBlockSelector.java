package net.minecraft.src;

import java.util.Random;

public abstract class StructurePieceBlockSelector {

   protected int field_35710_a;
   protected int field_35709_b;


   public abstract void func_35706_a(Random var1, int var2, int var3, int var4, boolean var5);

   public int func_35707_a() {
      return this.field_35710_a;
   }

   public int func_35708_b() {
      return this.field_35709_b;
   }
}
