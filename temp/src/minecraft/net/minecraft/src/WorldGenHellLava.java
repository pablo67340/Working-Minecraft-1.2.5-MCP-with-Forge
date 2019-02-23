package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenHellLava extends WorldGenerator {

   private int field_4158_a;


   public WorldGenHellLava(int p_i440_1_) {
      this.field_4158_a = p_i440_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      if(p_516_1_.func_600_a(p_516_3_, p_516_4_ + 1, p_516_5_) != Block.field_4053_bc.field_376_bc) {
         return false;
      } else if(p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_) != 0 && p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_) != Block.field_4053_bc.field_376_bc) {
         return false;
      } else {
         int var6 = 0;
         if(p_516_1_.func_600_a(p_516_3_ - 1, p_516_4_, p_516_5_) == Block.field_4053_bc.field_376_bc) {
            ++var6;
         }

         if(p_516_1_.func_600_a(p_516_3_ + 1, p_516_4_, p_516_5_) == Block.field_4053_bc.field_376_bc) {
            ++var6;
         }

         if(p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_ - 1) == Block.field_4053_bc.field_376_bc) {
            ++var6;
         }

         if(p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_ + 1) == Block.field_4053_bc.field_376_bc) {
            ++var6;
         }

         if(p_516_1_.func_600_a(p_516_3_, p_516_4_ - 1, p_516_5_) == Block.field_4053_bc.field_376_bc) {
            ++var6;
         }

         int var7 = 0;
         if(p_516_1_.func_20084_d(p_516_3_ - 1, p_516_4_, p_516_5_)) {
            ++var7;
         }

         if(p_516_1_.func_20084_d(p_516_3_ + 1, p_516_4_, p_516_5_)) {
            ++var7;
         }

         if(p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_ - 1)) {
            ++var7;
         }

         if(p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_ + 1)) {
            ++var7;
         }

         if(p_516_1_.func_20084_d(p_516_3_, p_516_4_ - 1, p_516_5_)) {
            ++var7;
         }

         if(var6 == 4 && var7 == 1) {
            p_516_1_.func_690_d(p_516_3_, p_516_4_, p_516_5_, this.field_4158_a);
            p_516_1_.field_4214_a = true;
            Block.field_345_n[this.field_4158_a].func_208_a(p_516_1_, p_516_3_, p_516_4_, p_516_5_, p_516_2_);
            p_516_1_.field_4214_a = false;
         }

         return true;
      }
   }
}
