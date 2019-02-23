package net.minecraft.src;

import java.awt.image.BufferedImage;
import net.minecraft.src.World;

public class IsoImageBuffer {

   public BufferedImage field_1348_a;
   public World field_1347_b;
   public int field_1354_c;
   public int field_1353_d;
   public boolean field_1352_e = false;
   public boolean field_1351_f = false;
   public int field_1350_g = 0;
   public boolean field_1349_h = false;


   public IsoImageBuffer(World p_i462_1_, int p_i462_2_, int p_i462_3_) {
      this.field_1347_b = p_i462_1_;
      this.func_889_a(p_i462_2_, p_i462_3_);
   }

   public void func_889_a(int p_889_1_, int p_889_2_) {
      this.field_1352_e = false;
      this.field_1354_c = p_889_1_;
      this.field_1353_d = p_889_2_;
      this.field_1350_g = 0;
      this.field_1349_h = false;
   }

   public void func_888_a(World p_888_1_, int p_888_2_, int p_888_3_) {
      this.field_1347_b = p_888_1_;
      this.func_889_a(p_888_2_, p_888_3_);
   }
}
