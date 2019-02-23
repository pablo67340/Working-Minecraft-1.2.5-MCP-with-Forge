package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class BlockDeadBush extends BlockFlower {

   protected BlockDeadBush(int p_i348_1_, int p_i348_2_) {
      super(p_i348_1_, p_i348_2_, Material.field_35495_k);
      float var3 = 0.4F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
   }

   protected boolean func_269_b(int p_269_1_) {
      return p_269_1_ == Block.field_393_F.field_376_bc;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return this.field_378_bb;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return -1;
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      if(!p_220_1_.field_1026_y && p_220_2_.func_6416_v() != null && p_220_2_.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS) {
         p_220_2_.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
         this.func_31027_a(p_220_1_, p_220_3_, p_220_4_, p_220_5_, new ItemStack(Block.field_9256_Y, 1, p_220_6_));
      } else {
         super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
      }

   }
}
