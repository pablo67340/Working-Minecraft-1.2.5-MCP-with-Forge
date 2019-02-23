package net.minecraft.src;

import java.nio.IntBuffer;
import net.minecraft.src.GLAllocation;
import org.lwjgl.opengl.GL11;

public class RenderList {

   private int field_1242_a;
   private int field_1241_b;
   private int field_1240_c;
   private double field_1239_d;
   private double field_1238_e;
   private double field_1237_f;
   private IntBuffer field_1236_g = GLAllocation.func_1125_c(65536);
   private boolean field_1235_h = false;
   private boolean field_1234_i = false;


   public void func_861_a(int p_861_1_, int p_861_2_, int p_861_3_, double p_861_4_, double p_861_6_, double p_861_8_) {
      this.field_1235_h = true;
      this.field_1236_g.clear();
      this.field_1242_a = p_861_1_;
      this.field_1241_b = p_861_2_;
      this.field_1240_c = p_861_3_;
      this.field_1239_d = p_861_4_;
      this.field_1238_e = p_861_6_;
      this.field_1237_f = p_861_8_;
   }

   public boolean func_862_a(int p_862_1_, int p_862_2_, int p_862_3_) {
      return !this.field_1235_h?false:p_862_1_ == this.field_1242_a && p_862_2_ == this.field_1241_b && p_862_3_ == this.field_1240_c;
   }

   public void func_858_a(int p_858_1_) {
      this.field_1236_g.put(p_858_1_);
      if(this.field_1236_g.remaining() == 0) {
         this.func_860_a();
      }

   }

   public void func_860_a() {
      if(this.field_1235_h) {
         if(!this.field_1234_i) {
            this.field_1236_g.flip();
            this.field_1234_i = true;
         }

         if(this.field_1236_g.remaining() > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((double)this.field_1242_a - this.field_1239_d), (float)((double)this.field_1241_b - this.field_1238_e), (float)((double)this.field_1240_c - this.field_1237_f));
            GL11.glCallLists(this.field_1236_g);
            GL11.glPopMatrix();
         }

      }
   }

   public void func_859_b() {
      this.field_1235_h = false;
      this.field_1234_i = false;
   }
}
