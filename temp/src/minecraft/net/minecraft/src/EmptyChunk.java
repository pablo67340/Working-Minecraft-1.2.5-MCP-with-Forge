package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Chunk;
import net.minecraft.src.Entity;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class EmptyChunk extends Chunk {

   public EmptyChunk(World p_i8_1_, int p_i8_2_, int p_i8_3_) {
      super(p_i8_1_, p_i8_2_, p_i8_3_);
   }

   public boolean func_1017_a(int p_1017_1_, int p_1017_2_) {
      return p_1017_1_ == this.field_1531_j && p_1017_2_ == this.field_1530_k;
   }

   public int func_999_b(int p_999_1_, int p_999_2_) {
      return 0;
   }

   public void func_1018_b() {}

   public void func_1024_c() {}

   public void func_4143_d() {}

   public int func_1008_a(int p_1008_1_, int p_1008_2_, int p_1008_3_) {
      return 0;
   }

   public int func_48499_b(int p_48499_1_, int p_48499_2_, int p_48499_3_) {
      return 255;
   }

   public boolean func_1010_a(int p_1010_1_, int p_1010_2_, int p_1010_3_, int p_1010_4_, int p_1010_5_) {
      return true;
   }

   public boolean func_1022_a(int p_1022_1_, int p_1022_2_, int p_1022_3_, int p_1022_4_) {
      return true;
   }

   public int func_1021_b(int p_1021_1_, int p_1021_2_, int p_1021_3_) {
      return 0;
   }

   public boolean func_1009_b(int p_1009_1_, int p_1009_2_, int p_1009_3_, int p_1009_4_) {
      return false;
   }

   public int func_1025_a(EnumSkyBlock p_1025_1_, int p_1025_2_, int p_1025_3_, int p_1025_4_) {
      return 0;
   }

   public void func_1011_a(EnumSkyBlock p_1011_1_, int p_1011_2_, int p_1011_3_, int p_1011_4_, int p_1011_5_) {}

   public int func_1019_c(int p_1019_1_, int p_1019_2_, int p_1019_3_, int p_1019_4_) {
      return 0;
   }

   public void func_1000_a(Entity p_1000_1_) {}

   public void func_1015_b(Entity p_1015_1_) {}

   public void func_1016_a(Entity p_1016_1_, int p_1016_2_) {}

   public boolean func_1007_c(int p_1007_1_, int p_1007_2_, int p_1007_3_) {
      return false;
   }

   public TileEntity func_1002_d(int p_1002_1_, int p_1002_2_, int p_1002_3_) {
      return null;
   }

   public void func_1001_a(TileEntity p_1001_1_) {}

   public void func_1005_a(int p_1005_1_, int p_1005_2_, int p_1005_3_, TileEntity p_1005_4_) {}

   public void func_1023_e(int p_1023_1_, int p_1023_2_, int p_1023_3_) {}

   public void func_995_d() {}

   public void func_998_e() {}

   public void func_1006_f() {}

   public void func_994_a(Entity p_994_1_, AxisAlignedBB p_994_2_, List p_994_3_) {}

   public void func_1013_a(Class p_1013_1_, AxisAlignedBB p_1013_2_, List p_1013_3_) {}

   public boolean func_1012_a(boolean p_1012_1_) {
      return false;
   }

   public Random func_997_a(long p_997_1_) {
      return new Random(this.field_1537_d.func_22138_q() + (long)(this.field_1531_j * this.field_1531_j * 4987142) + (long)(this.field_1531_j * 5947611) + (long)(this.field_1530_k * this.field_1530_k) * 4392871L + (long)(this.field_1530_k * 389711) ^ p_997_1_);
   }

   public boolean func_21167_h() {
      return true;
   }

   public boolean func_48492_c(int p_48492_1_, int p_48492_2_) {
      return true;
   }
}
