package net.minecraft.src;


public class ChunkCoordinates implements Comparable {

   public int field_22395_a;
   public int field_22394_b;
   public int field_22396_c;


   public ChunkCoordinates() {}

   public ChunkCoordinates(int p_i624_1_, int p_i624_2_, int p_i624_3_) {
      this.field_22395_a = p_i624_1_;
      this.field_22394_b = p_i624_2_;
      this.field_22396_c = p_i624_3_;
   }

   public ChunkCoordinates(ChunkCoordinates p_i625_1_) {
      this.field_22395_a = p_i625_1_.field_22395_a;
      this.field_22394_b = p_i625_1_.field_22394_b;
      this.field_22396_c = p_i625_1_.field_22396_c;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof ChunkCoordinates)) {
         return false;
      } else {
         ChunkCoordinates var2 = (ChunkCoordinates)p_equals_1_;
         return this.field_22395_a == var2.field_22395_a && this.field_22394_b == var2.field_22394_b && this.field_22396_c == var2.field_22396_c;
      }
   }

   public int hashCode() {
      return this.field_22395_a + this.field_22396_c << 8 + this.field_22394_b << 16;
   }

   public int func_22393_a(ChunkCoordinates p_22393_1_) {
      return this.field_22394_b == p_22393_1_.field_22394_b?(this.field_22396_c == p_22393_1_.field_22396_c?this.field_22395_a - p_22393_1_.field_22395_a:this.field_22396_c - p_22393_1_.field_22396_c):this.field_22394_b - p_22393_1_.field_22394_b;
   }

   public void func_48656_a(int p_48656_1_, int p_48656_2_, int p_48656_3_) {
      this.field_22395_a = p_48656_1_;
      this.field_22394_b = p_48656_2_;
      this.field_22396_c = p_48656_3_;
   }

   public double func_27439_a(int p_27439_1_, int p_27439_2_, int p_27439_3_) {
      int var4 = this.field_22395_a - p_27439_1_;
      int var5 = this.field_22394_b - p_27439_2_;
      int var6 = this.field_22396_c - p_27439_3_;
      return Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
   }

   public float func_48655_c(int p_48655_1_, int p_48655_2_, int p_48655_3_) {
      int var4 = this.field_22395_a - p_48655_1_;
      int var5 = this.field_22394_b - p_48655_2_;
      int var6 = this.field_22396_c - p_48655_3_;
      return (float)(var4 * var4 + var5 * var5 + var6 * var6);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_22393_a((ChunkCoordinates)p_compareTo_1_);
   }
}
