package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;

public abstract class WorldSavedData {

   public final String field_28168_a;
   private boolean field_28167_b;


   public WorldSavedData(String p_i717_1_) {
      this.field_28168_a = p_i717_1_;
   }

   public abstract void func_28163_a(NBTTagCompound var1);

   public abstract void func_28162_b(NBTTagCompound var1);

   public void func_28164_a() {
      this.func_28165_a(true);
   }

   public void func_28165_a(boolean p_28165_1_) {
      this.field_28167_b = p_28165_1_;
   }

   public boolean func_28166_b() {
      return this.field_28167_b;
   }
}
