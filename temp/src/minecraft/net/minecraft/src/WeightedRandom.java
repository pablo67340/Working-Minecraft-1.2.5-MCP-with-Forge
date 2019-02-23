package net.minecraft.src;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.src.WeightedRandomChoice;

public class WeightedRandom {

   public static int func_35736_a(Collection p_35736_0_) {
      int var1 = 0;

      WeightedRandomChoice var3;
      for(Iterator var2 = p_35736_0_.iterator(); var2.hasNext(); var1 += var3.field_35590_d) {
         var3 = (WeightedRandomChoice)var2.next();
      }

      return var1;
   }

   public static WeightedRandomChoice func_35734_a(Random p_35734_0_, Collection p_35734_1_, int p_35734_2_) {
      if(p_35734_2_ <= 0) {
         throw new IllegalArgumentException();
      } else {
         int var3 = p_35734_0_.nextInt(p_35734_2_);
         Iterator var4 = p_35734_1_.iterator();

         WeightedRandomChoice var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (WeightedRandomChoice)var4.next();
            var3 -= var5.field_35590_d;
         } while(var3 >= 0);

         return var5;
      }
   }

   public static WeightedRandomChoice func_35733_a(Random p_35733_0_, Collection p_35733_1_) {
      return func_35734_a(p_35733_0_, p_35733_1_, func_35736_a(p_35733_1_));
   }

   public static int func_35737_a(WeightedRandomChoice[] p_35737_0_) {
      int var1 = 0;
      WeightedRandomChoice[] var2 = p_35737_0_;
      int var3 = p_35737_0_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         WeightedRandomChoice var5 = var2[var4];
         var1 += var5.field_35590_d;
      }

      return var1;
   }

   public static WeightedRandomChoice func_35732_a(Random p_35732_0_, WeightedRandomChoice[] p_35732_1_, int p_35732_2_) {
      if(p_35732_2_ <= 0) {
         throw new IllegalArgumentException();
      } else {
         int var3 = p_35732_0_.nextInt(p_35732_2_);
         WeightedRandomChoice[] var4 = p_35732_1_;
         int var5 = p_35732_1_.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            WeightedRandomChoice var7 = var4[var6];
            var3 -= var7.field_35590_d;
            if(var3 < 0) {
               return var7;
            }
         }

         return null;
      }
   }

   public static WeightedRandomChoice func_35735_a(Random p_35735_0_, WeightedRandomChoice[] p_35735_1_) {
      return func_35732_a(p_35735_0_, p_35735_1_, func_35737_a(p_35735_1_));
   }
}
