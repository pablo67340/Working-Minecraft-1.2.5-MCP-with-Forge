package net.minecraft.src;


public class ClippingHelper {

   public float[][] field_1688_a = new float[16][16];
   public float[] field_1687_b = new float[16];
   public float[] field_1690_c = new float[16];
   public float[] field_1689_d = new float[16];


   public boolean func_1152_a(double p_1152_1_, double p_1152_3_, double p_1152_5_, double p_1152_7_, double p_1152_9_, double p_1152_11_) {
      for(int var13 = 0; var13 < 6; ++var13) {
         if((double)this.field_1688_a[var13][0] * p_1152_1_ + (double)this.field_1688_a[var13][1] * p_1152_3_ + (double)this.field_1688_a[var13][2] * p_1152_5_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_7_ + (double)this.field_1688_a[var13][1] * p_1152_3_ + (double)this.field_1688_a[var13][2] * p_1152_5_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_1_ + (double)this.field_1688_a[var13][1] * p_1152_9_ + (double)this.field_1688_a[var13][2] * p_1152_5_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_7_ + (double)this.field_1688_a[var13][1] * p_1152_9_ + (double)this.field_1688_a[var13][2] * p_1152_5_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_1_ + (double)this.field_1688_a[var13][1] * p_1152_3_ + (double)this.field_1688_a[var13][2] * p_1152_11_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_7_ + (double)this.field_1688_a[var13][1] * p_1152_3_ + (double)this.field_1688_a[var13][2] * p_1152_11_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_1_ + (double)this.field_1688_a[var13][1] * p_1152_9_ + (double)this.field_1688_a[var13][2] * p_1152_11_ + (double)this.field_1688_a[var13][3] <= 0.0D && (double)this.field_1688_a[var13][0] * p_1152_7_ + (double)this.field_1688_a[var13][1] * p_1152_9_ + (double)this.field_1688_a[var13][2] * p_1152_11_ + (double)this.field_1688_a[var13][3] <= 0.0D) {
            return false;
         }
      }

      return true;
   }
}
