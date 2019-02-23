package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLog extends Block {

   protected BlockLog(int p_i521_1_) {
      super(p_i521_1_, Material.field_1335_c);
      this.field_378_bb = 20;
   }

   public int func_229_a(Random p_229_1_) {
      return 1;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_385_K.field_376_bc;
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      byte var5 = 4;
      int var6 = var5 + 1;
      if(p_214_1_.func_640_a(p_214_2_ - var6, p_214_3_ - var6, p_214_4_ - var6, p_214_2_ + var6, p_214_3_ + var6, p_214_4_ + var6)) {
         for(int var7 = -var5; var7 <= var5; ++var7) {
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  int var10 = p_214_1_.func_600_a(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9);
                  if(var10 == Block.field_384_L.field_376_bc) {
                     int var11 = p_214_1_.func_602_e(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9);
                     if((var11 & 8) == 0) {
                        p_214_1_.func_635_c(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9, var11 | 8);
                     }
                  }
               }
            }
         }
      }

   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?21:(p_232_1_ == 0?21:(p_232_2_ == 1?116:(p_232_2_ == 2?117:(p_232_2_ == 3?153:20))));
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_;
   }
}
