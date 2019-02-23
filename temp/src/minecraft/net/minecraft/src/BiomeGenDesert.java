package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenDesertWells;

public class BiomeGenDesert extends BiomeGenBase {

   public BiomeGenDesert(int p_i128_1_) {
      super(p_i128_1_);
      this.field_25065_s.clear();
      this.field_4242_o = (byte)Block.field_393_F.field_376_bc;
      this.field_4241_p = (byte)Block.field_393_F.field_376_bc;
      this.field_35488_u.field_35911_r = -999;
      this.field_35488_u.field_35908_u = 2;
      this.field_35488_u.field_35906_w = 50;
      this.field_35488_u.field_35916_x = 10;
   }

   public void func_35477_a(World p_35477_1_, Random p_35477_2_, int p_35477_3_, int p_35477_4_) {
      super.func_35477_a(p_35477_1_, p_35477_2_, p_35477_3_, p_35477_4_);
      if(p_35477_2_.nextInt(1000) == 0) {
         int var5 = p_35477_3_ + p_35477_2_.nextInt(16) + 8;
         int var6 = p_35477_4_ + p_35477_2_.nextInt(16) + 8;
         WorldGenDesertWells var7 = new WorldGenDesertWells();
         var7.func_516_a(p_35477_1_, p_35477_2_, var5, p_35477_1_.func_666_c(var5, var6) + 1, var6);
      }

   }
}
