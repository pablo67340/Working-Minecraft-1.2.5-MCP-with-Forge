package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySilverfish;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSilverfish extends Block {

   public BlockSilverfish(int p_i101_1_) {
      super(p_i101_1_, 1, Material.field_1316_v);
      this.func_222_c(0.0F);
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_2_ == 1?Block.field_335_x.field_378_bb:(p_232_2_ == 2?Block.field_35285_bn.field_378_bb:Block.field_338_u.field_378_bb);
   }

   public void func_252_b(World p_252_1_, int p_252_2_, int p_252_3_, int p_252_4_, int p_252_5_) {
      if(!p_252_1_.field_1026_y) {
         EntitySilverfish var6 = new EntitySilverfish(p_252_1_);
         var6.func_365_c((double)p_252_2_ + 0.5D, (double)p_252_3_, (double)p_252_4_ + 0.5D, 0.0F, 0.0F);
         p_252_1_.func_674_a(var6);
         var6.func_415_z();
      }

      super.func_252_b(p_252_1_, p_252_2_, p_252_3_, p_252_4_, p_252_5_);
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public static boolean func_35305_d(int p_35305_0_) {
      return p_35305_0_ == Block.field_338_u.field_376_bc || p_35305_0_ == Block.field_335_x.field_376_bc || p_35305_0_ == Block.field_35285_bn.field_376_bc;
   }

   public static int func_35304_f(int p_35304_0_) {
      return p_35304_0_ == Block.field_335_x.field_376_bc?1:(p_35304_0_ == Block.field_35285_bn.field_376_bc?2:0);
   }

   protected ItemStack func_41049_c_(int p_41049_1_) {
      Block var2 = Block.field_338_u;
      if(p_41049_1_ == 1) {
         var2 = Block.field_335_x;
      }

      if(p_41049_1_ == 2) {
         var2 = Block.field_35285_bn;
      }

      return new ItemStack(var2);
   }
}
