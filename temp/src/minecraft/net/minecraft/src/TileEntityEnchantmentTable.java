package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;

public class TileEntityEnchantmentTable extends TileEntity {

   public int field_40068_a;
   public float field_40063_b;
   public float field_40065_c;
   public float field_40061_d;
   public float field_40062_e;
   public float field_40059_f;
   public float field_40060_g;
   public float field_40069_h;
   public float field_40067_p;
   public float field_40066_q;
   private static Random field_40064_r = new Random();


   public void func_475_b() {
      super.func_475_b();
      this.field_40060_g = this.field_40059_f;
      this.field_40067_p = this.field_40069_h;
      EntityPlayer var1 = this.field_824_e.func_683_a((double)((float)this.field_823_f + 0.5F), (double)((float)this.field_822_g + 0.5F), (double)((float)this.field_821_h + 0.5F), 3.0D);
      if(var1 != null) {
         double var2 = var1.field_611_ak - (double)((float)this.field_823_f + 0.5F);
         double var4 = var1.field_609_am - (double)((float)this.field_821_h + 0.5F);
         this.field_40066_q = (float)Math.atan2(var4, var2);
         this.field_40059_f += 0.1F;
         if(this.field_40059_f < 0.5F || field_40064_r.nextInt(40) == 0) {
            float var6 = this.field_40061_d;

            do {
               this.field_40061_d += (float)(field_40064_r.nextInt(4) - field_40064_r.nextInt(4));
            } while(var6 == this.field_40061_d);
         }
      } else {
         this.field_40066_q += 0.02F;
         this.field_40059_f -= 0.1F;
      }

      while(this.field_40069_h >= 3.1415927F) {
         this.field_40069_h -= 6.2831855F;
      }

      while(this.field_40069_h < -3.1415927F) {
         this.field_40069_h += 6.2831855F;
      }

      while(this.field_40066_q >= 3.1415927F) {
         this.field_40066_q -= 6.2831855F;
      }

      while(this.field_40066_q < -3.1415927F) {
         this.field_40066_q += 6.2831855F;
      }

      float var7;
      for(var7 = this.field_40066_q - this.field_40069_h; var7 >= 3.1415927F; var7 -= 6.2831855F) {
         ;
      }

      while(var7 < -3.1415927F) {
         var7 += 6.2831855F;
      }

      this.field_40069_h += var7 * 0.4F;
      if(this.field_40059_f < 0.0F) {
         this.field_40059_f = 0.0F;
      }

      if(this.field_40059_f > 1.0F) {
         this.field_40059_f = 1.0F;
      }

      ++this.field_40068_a;
      this.field_40065_c = this.field_40063_b;
      float var3 = (this.field_40061_d - this.field_40063_b) * 0.4F;
      float var8 = 0.2F;
      if(var3 < -var8) {
         var3 = -var8;
      }

      if(var3 > var8) {
         var3 = var8;
      }

      this.field_40062_e += (var3 - this.field_40062_e) * 0.9F;
      this.field_40063_b += this.field_40062_e;
   }

}
