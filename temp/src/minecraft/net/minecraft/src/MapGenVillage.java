package net.minecraft.src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureStart;
import net.minecraft.src.StructureVillageStart;

public class MapGenVillage extends MapGenStructure {

   public static List field_35635_a = Arrays.asList(new BiomeGenBase[]{BiomeGenBase.field_35485_c, BiomeGenBase.field_4249_h});
   private final int field_46060_f;


   public MapGenVillage(int p_i228_1_) {
      this.field_46060_f = p_i228_1_;
   }

   protected boolean func_35628_a(int p_35628_1_, int p_35628_2_) {
      byte var3 = 32;
      byte var4 = 8;
      int var5 = p_35628_1_;
      int var6 = p_35628_2_;
      if(p_35628_1_ < 0) {
         p_35628_1_ -= var3 - 1;
      }

      if(p_35628_2_ < 0) {
         p_35628_2_ -= var3 - 1;
      }

      int var7 = p_35628_1_ / var3;
      int var8 = p_35628_2_ / var3;
      Random var9 = this.field_35625_d.func_35462_u(var7, var8, 10387312);
      var7 *= var3;
      var8 *= var3;
      var7 += var9.nextInt(var3 - var4);
      var8 += var9.nextInt(var3 - var4);
      if(var5 == var7 && var6 == var8) {
         boolean var10 = this.field_35625_d.func_4075_a().func_35562_a(var5 * 16 + 8, var6 * 16 + 8, 0, field_35635_a);
         if(var10) {
            return true;
         }
      }

      return false;
   }

   protected StructureStart func_35630_b(int p_35630_1_, int p_35630_2_) {
      return new StructureVillageStart(this.field_35625_d, this.field_1305_b, p_35630_1_, p_35630_2_, this.field_46060_f);
   }

}
