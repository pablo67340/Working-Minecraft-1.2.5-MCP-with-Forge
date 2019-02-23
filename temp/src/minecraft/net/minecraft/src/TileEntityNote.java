package net.minecraft.src;

import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class TileEntityNote extends TileEntity {

   public byte field_21097_a = 0;
   public boolean field_21096_b = false;


   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      p_481_1_.func_761_a("note", this.field_21097_a);
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      this.field_21097_a = p_482_1_.func_746_c("note");
      if(this.field_21097_a < 0) {
         this.field_21097_a = 0;
      }

      if(this.field_21097_a > 24) {
         this.field_21097_a = 24;
      }

   }

   public void func_21095_a() {
      this.field_21097_a = (byte)((this.field_21097_a + 1) % 25);
      this.func_474_j_();
   }

   public void func_21094_a(World p_21094_1_, int p_21094_2_, int p_21094_3_, int p_21094_4_) {
      if(p_21094_1_.func_599_f(p_21094_2_, p_21094_3_ + 1, p_21094_4_) == Material.field_1337_a) {
         Material var5 = p_21094_1_.func_599_f(p_21094_2_, p_21094_3_ - 1, p_21094_4_);
         byte var6 = 0;
         if(var5 == Material.field_1334_d) {
            var6 = 1;
         }

         if(var5 == Material.field_1325_m) {
            var6 = 2;
         }

         if(var5 == Material.field_4263_o) {
            var6 = 3;
         }

         if(var5 == Material.field_1335_c) {
            var6 = 4;
         }

         p_21094_1_.func_21116_c(p_21094_2_, p_21094_3_, p_21094_4_, var6, this.field_21097_a);
      }
   }
}
