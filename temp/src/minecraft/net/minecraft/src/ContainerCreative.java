package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiContainerCreative;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class ContainerCreative extends Container {

   public List field_35375_a = new ArrayList();


   public ContainerCreative(EntityPlayer p_i500_1_) {
      Block[] var2 = new Block[]{Block.field_335_x, Block.field_338_u, Block.field_391_ax, Block.field_390_H, Block.field_388_I, Block.field_386_J, Block.field_9267_N, Block.field_433_aO, Block.field_35285_bn, Block.field_35285_bn, Block.field_35285_bn, Block.field_35285_bn, Block.field_424_aX, Block.field_389_ay, Block.field_413_ai, Block.field_412_aj, Block.field_403_A, Block.field_9266_O, Block.field_409_am, Block.field_406_ap, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_410_al, Block.field_405_aq, Block.field_4053_bc, Block.field_4051_bd, Block.field_4049_be, Block.field_385_K, Block.field_385_K, Block.field_385_K, Block.field_385_K, Block.field_384_L, Block.field_384_L, Block.field_384_L, Block.field_384_L, Block.field_336_w, Block.field_337_v, Block.field_393_F, Block.field_9264_Q, Block.field_9264_Q, Block.field_9264_Q, Block.field_392_G, Block.field_9258_W, Block.field_334_y, Block.field_334_y, Block.field_334_y, Block.field_334_y, Block.field_333_z, Block.field_333_z, Block.field_333_z, Block.field_333_z, Block.field_9256_Y, Block.field_383_M, Block.field_4063_aU, Block.field_426_aV, Block.field_417_ae, Block.field_416_af, Block.field_415_ag, Block.field_414_ah, Block.field_425_aW, Block.field_35281_bs, Block.field_4055_bb, Block.field_4045_bg, Block.field_35278_bv, Block.field_35288_bq, Block.field_35282_br, Block.field_40206_bB, Block.field_40207_bC, Block.field_40204_bD, Block.field_40203_bK, Block.field_40199_bz, Block.field_40200_bA, Block.field_9257_X, Block.field_9257_X, Block.field_396_av, Block.field_387_az, Block.field_382_N, Block.field_408_an, Block.field_407_ao, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_419_ac, Block.field_9265_P, Block.field_445_aC, Block.field_9263_R, Block.field_422_aZ, Block.field_9259_V, Block.field_9255_Z, Block.field_4057_ba, Block.field_35277_bw, Block.field_441_aG, Block.field_440_aH, Block.field_9261_T, Block.field_9260_U, Block.field_404_ar, Block.field_4059_au, Block.field_4069_aI, Block.field_35280_bx, Block.field_35279_by, Block.field_4067_aK, Block.field_4066_aL, Block.field_4065_aN, Block.field_430_aR, Block.field_4064_aS, Block.field_28033_bl, Block.field_40210_bF, Block.field_48209_bL};
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 1;

      int var12;
      int var13;
      for(var12 = 0; var12 < var2.length; ++var12) {
         var13 = 0;
         if(var2[var12] == Block.field_419_ac) {
            var13 = var3++;
         } else if(var2[var12] == Block.field_410_al) {
            var13 = var4++;
         } else if(var2[var12] == Block.field_385_K) {
            var13 = var5++;
         } else if(var2[var12] == Block.field_334_y) {
            var13 = var6++;
         } else if(var2[var12] == Block.field_333_z) {
            var13 = var7++;
         } else if(var2[var12] == Block.field_35285_bn) {
            var13 = var8++;
         } else if(var2[var12] == Block.field_9264_Q) {
            var13 = var9++;
         } else if(var2[var12] == Block.field_9257_X) {
            var13 = var11++;
         } else if(var2[var12] == Block.field_384_L) {
            var13 = var10++;
         }

         this.field_35375_a.add(new ItemStack(var2[var12], 1, var13));
      }

      for(var12 = 256; var12 < Item.field_233_c.length; ++var12) {
         if(Item.field_233_c[var12] != null && Item.field_233_c[var12].field_291_aS != Item.field_40413_bs.field_291_aS && Item.field_233_c[var12].field_291_aS != Item.field_44019_bC.field_291_aS) {
            this.field_35375_a.add(new ItemStack(Item.field_233_c[var12]));
         }
      }

      for(var12 = 1; var12 < 16; ++var12) {
         this.field_35375_a.add(new ItemStack(Item.field_21021_aU.field_291_aS, 1, var12));
      }

      Iterator var15 = EntityList.field_44041_a.keySet().iterator();

      while(var15.hasNext()) {
         Integer var17 = (Integer)var15.next();
         this.field_35375_a.add(new ItemStack(Item.field_44019_bC.field_291_aS, 1, var17.intValue()));
      }

      InventoryPlayer var16 = p_i500_1_.field_778_b;

      for(var13 = 0; var13 < 9; ++var13) {
         for(int var14 = 0; var14 < 8; ++var14) {
            this.func_20117_a(new Slot(GuiContainerCreative.func_35310_g(), var14 + var13 * 8, 8 + var14 * 18, 18 + var13 * 18));
         }
      }

      for(var13 = 0; var13 < 9; ++var13) {
         this.func_20117_a(new Slot(var16, var13, 8 + var13 * 18, 184));
      }

      this.func_35374_a(0.0F);
   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return true;
   }

   public void func_35374_a(float p_35374_1_) {
      int var2 = this.field_35375_a.size() / 8 - 8 + 1;
      int var3 = (int)((double)(p_35374_1_ * (float)var2) + 0.5D);
      if(var3 < 0) {
         var3 = 0;
      }

      for(int var4 = 0; var4 < 9; ++var4) {
         for(int var5 = 0; var5 < 8; ++var5) {
            int var6 = var5 + (var4 + var3) * 8;
            if(var6 >= 0 && var6 < this.field_35375_a.size()) {
               GuiContainerCreative.func_35310_g().func_472_a(var5 + var4 * 8, (ItemStack)this.field_35375_a.get(var6));
            } else {
               GuiContainerCreative.func_35310_g().func_472_a(var5 + var4 * 8, (ItemStack)null);
            }
         }
      }

   }

   protected void func_35373_b(int p_35373_1_, int p_35373_2_, boolean p_35373_3_, EntityPlayer p_35373_4_) {}
}
