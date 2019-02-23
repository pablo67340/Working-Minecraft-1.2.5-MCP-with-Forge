package net.minecraft.src;

import net.minecraft.src.GameSettings;

public class ScaledResolution {

   private int field_1367_b;
   private int field_1369_c;
   public double field_25121_a;
   public double field_25120_b;
   public int field_1368_a;


   public ScaledResolution(GameSettings p_i100_1_, int p_i100_2_, int p_i100_3_) {
      this.field_1367_b = p_i100_2_;
      this.field_1369_c = p_i100_3_;
      this.field_1368_a = 1;
      int var4 = p_i100_1_.field_25148_H;
      if(var4 == 0) {
         var4 = 1000;
      }

      while(this.field_1368_a < var4 && this.field_1367_b / (this.field_1368_a + 1) >= 320 && this.field_1369_c / (this.field_1368_a + 1) >= 240) {
         ++this.field_1368_a;
      }

      this.field_25121_a = (double)this.field_1367_b / (double)this.field_1368_a;
      this.field_25120_b = (double)this.field_1369_c / (double)this.field_1368_a;
      this.field_1367_b = (int)Math.ceil(this.field_25121_a);
      this.field_1369_c = (int)Math.ceil(this.field_25120_b);
   }

   public int func_903_a() {
      return this.field_1367_b;
   }

   public int func_902_b() {
      return this.field_1369_c;
   }
}
