package net.minecraft.src;

import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.WorldGenSpikes;
import net.minecraft.src.WorldGenerator;

public class BiomeEndDecorator extends BiomeDecorator {

   protected WorldGenerator field_40723_L;


   public BiomeEndDecorator(BiomeGenBase p_i29_1_) {
      super(p_i29_1_);
      this.field_40723_L = new WorldGenSpikes(Block.field_40203_bK.field_376_bc);
   }

   protected void func_35882_b() {
      this.func_35880_a();
      if(this.field_35890_C.nextInt(5) == 0) {
         int var1 = this.field_35885_D + this.field_35890_C.nextInt(16) + 8;
         int var2 = this.field_35886_E + this.field_35890_C.nextInt(16) + 8;
         int var3 = this.field_35889_B.func_4083_e(var1, var2);
         if(var3 > 0) {
            ;
         }

         this.field_40723_L.func_516_a(this.field_35889_B, this.field_35890_C, var1, var3, var2);
      }

      if(this.field_35885_D == 0 && this.field_35886_E == 0) {
         EntityDragon var4 = new EntityDragon(this.field_35889_B);
         var4.func_365_c(0.0D, 128.0D, 0.0D, this.field_35890_C.nextFloat() * 360.0F, 0.0F);
         this.field_35889_B.func_674_a(var4);
      }

   }
}
