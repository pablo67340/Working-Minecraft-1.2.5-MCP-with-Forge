package net.minecraft.src;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.World;

public abstract class TileEntitySpecialRenderer {

   protected TileEntityRenderer field_6509_a;


   public abstract void func_930_a(TileEntity var1, double var2, double var4, double var6, float var8);

   protected void func_6507_a(String p_6507_1_) {
      RenderEngine var2 = this.field_6509_a.field_1550_e;
      if(var2 != null) {
         var2.func_1076_b(var2.func_1070_a(p_6507_1_));
      }

   }

   public void func_928_a(TileEntityRenderer p_928_1_) {
      this.field_6509_a = p_928_1_;
   }

   public void func_31069_a(World p_31069_1_) {}

   public FontRenderer func_6508_a() {
      return this.field_6509_a.func_6516_a();
   }
}
