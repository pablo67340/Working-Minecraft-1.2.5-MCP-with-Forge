package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockStep;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSlab extends ItemBlock {

   public ItemSlab(int p_i666_1_) {
      super(p_i666_1_);
      this.func_21013_d(0);
      this.func_21015_a(true);
   }

   public int func_27009_a(int p_27009_1_) {
      return Block.field_410_al.func_232_a(2, p_27009_1_);
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_;
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      int var2 = p_21011_1_.func_21181_i();
      if(var2 < 0 || var2 >= BlockStep.field_22037_a.length) {
         var2 = 0;
      }

      return super.func_20009_a() + "." + BlockStep.field_22037_a[var2];
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_1_.field_1615_a == 0) {
         return false;
      } else if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else {
         int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
         int var9 = p_192_3_.func_602_e(p_192_4_, p_192_5_, p_192_6_);
         int var10 = var9 & 7;
         boolean var11 = (var9 & 8) != 0;
         if((p_192_7_ == 1 && !var11 || p_192_7_ == 0 && var11) && var8 == Block.field_410_al.field_376_bc && var10 == p_192_1_.func_21181_i()) {
            if(p_192_3_.func_604_a(Block.field_411_ak.func_221_d(p_192_3_, p_192_4_, p_192_5_, p_192_6_)) && p_192_3_.func_688_b(p_192_4_, p_192_5_, p_192_6_, Block.field_411_ak.field_376_bc, var10)) {
               p_192_3_.func_684_a((double)((float)p_192_4_ + 0.5F), (double)((float)p_192_5_ + 0.5F), (double)((float)p_192_6_ + 0.5F), Block.field_411_ak.field_358_bl.func_1145_d(), (Block.field_411_ak.field_358_bl.func_1147_b() + 1.0F) / 2.0F, Block.field_411_ak.field_358_bl.func_1144_c() * 0.8F);
               --p_192_1_.field_1615_a;
            }

            return true;
         } else {
            return func_50087_b(p_192_1_, p_192_2_, p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_7_)?true:super.func_192_a(p_192_1_, p_192_2_, p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_7_);
         }
      }
   }

   private static boolean func_50087_b(ItemStack p_50087_0_, EntityPlayer p_50087_1_, World p_50087_2_, int p_50087_3_, int p_50087_4_, int p_50087_5_, int p_50087_6_) {
      if(p_50087_6_ == 0) {
         --p_50087_4_;
      }

      if(p_50087_6_ == 1) {
         ++p_50087_4_;
      }

      if(p_50087_6_ == 2) {
         --p_50087_5_;
      }

      if(p_50087_6_ == 3) {
         ++p_50087_5_;
      }

      if(p_50087_6_ == 4) {
         --p_50087_3_;
      }

      if(p_50087_6_ == 5) {
         ++p_50087_3_;
      }

      int var7 = p_50087_2_.func_600_a(p_50087_3_, p_50087_4_, p_50087_5_);
      int var8 = p_50087_2_.func_602_e(p_50087_3_, p_50087_4_, p_50087_5_);
      int var9 = var8 & 7;
      if(var7 == Block.field_410_al.field_376_bc && var9 == p_50087_0_.func_21181_i()) {
         if(p_50087_2_.func_604_a(Block.field_411_ak.func_221_d(p_50087_2_, p_50087_3_, p_50087_4_, p_50087_5_)) && p_50087_2_.func_688_b(p_50087_3_, p_50087_4_, p_50087_5_, Block.field_411_ak.field_376_bc, var9)) {
            p_50087_2_.func_684_a((double)((float)p_50087_3_ + 0.5F), (double)((float)p_50087_4_ + 0.5F), (double)((float)p_50087_5_ + 0.5F), Block.field_411_ak.field_358_bl.func_1145_d(), (Block.field_411_ak.field_358_bl.func_1147_b() + 1.0F) / 2.0F, Block.field_411_ak.field_358_bl.func_1144_c() * 0.8F);
            --p_50087_0_.field_1615_a;
         }

         return true;
      } else {
         return false;
      }
   }
}
