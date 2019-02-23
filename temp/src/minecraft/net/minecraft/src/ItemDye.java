package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCloth;
import net.minecraft.src.BlockCrops;
import net.minecraft.src.BlockMushroom;
import net.minecraft.src.BlockSapling;
import net.minecraft.src.BlockStem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemDye extends Item {

   public static final String[] field_21023_a = new String[]{"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
   public static final int[] field_31002_bk = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};


   public ItemDye(int p_i359_1_) {
      super(p_i359_1_);
      this.func_21015_a(true);
      this.func_21013_d(0);
   }

   public int func_27009_a(int p_27009_1_) {
      int var2 = MathHelper.func_41084_a(p_27009_1_, 0, 15);
      return this.field_4018_aZ + var2 % 8 * 16 + var2 / 8;
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      int var2 = MathHelper.func_41084_a(p_21011_1_.func_21181_i(), 0, 15);
      return super.func_20009_a() + "." + field_21023_a[var2];
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else {
         if(p_192_1_.func_21181_i() == 15) {
            int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
            if(var8 == Block.field_333_z.field_376_bc) {
               if(!p_192_3_.field_1026_y) {
                  ((BlockSapling)Block.field_333_z).func_21028_c(p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_3_.field_1037_n);
                  --p_192_1_.field_1615_a;
               }

               return true;
            }

            if(var8 == Block.field_415_ag.field_376_bc || var8 == Block.field_414_ah.field_376_bc) {
               if(!p_192_3_.field_1026_y && ((BlockMushroom)Block.field_345_n[var8]).func_35293_c(p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_3_.field_1037_n)) {
                  --p_192_1_.field_1615_a;
               }

               return true;
            }

            if(var8 == Block.field_35283_bu.field_376_bc || var8 == Block.field_35284_bt.field_376_bc) {
               if(!p_192_3_.field_1026_y) {
                  ((BlockStem)Block.field_345_n[var8]).func_35294_i(p_192_3_, p_192_4_, p_192_5_, p_192_6_);
                  --p_192_1_.field_1615_a;
               }

               return true;
            }

            if(var8 == Block.field_447_aA.field_376_bc) {
               if(!p_192_3_.field_1026_y) {
                  ((BlockCrops)Block.field_447_aA).func_21027_c_(p_192_3_, p_192_4_, p_192_5_, p_192_6_);
                  --p_192_1_.field_1615_a;
               }

               return true;
            }

            if(var8 == Block.field_337_v.field_376_bc) {
               if(!p_192_3_.field_1026_y) {
                  --p_192_1_.field_1615_a;

                  label73:
                  for(int var9 = 0; var9 < 128; ++var9) {
                     int var10 = p_192_4_;
                     int var11 = p_192_5_ + 1;
                     int var12 = p_192_6_;

                     for(int var13 = 0; var13 < var9 / 16; ++var13) {
                        var10 += field_4015_b.nextInt(3) - 1;
                        var11 += (field_4015_b.nextInt(3) - 1) * field_4015_b.nextInt(3) / 2;
                        var12 += field_4015_b.nextInt(3) - 1;
                        if(p_192_3_.func_600_a(var10, var11 - 1, var12) != Block.field_337_v.field_376_bc || p_192_3_.func_28100_h(var10, var11, var12)) {
                           continue label73;
                        }
                     }

                     if(p_192_3_.func_600_a(var10, var11, var12) == 0) {
                        if(field_4015_b.nextInt(10) != 0) {
                           p_192_3_.func_688_b(var10, var11, var12, Block.field_9257_X.field_376_bc, 1);
                        } else if(field_4015_b.nextInt(3) != 0) {
                           p_192_3_.func_690_d(var10, var11, var12, Block.field_417_ae.field_376_bc);
                        } else {
                           p_192_3_.func_690_d(var10, var11, var12, Block.field_416_af.field_376_bc);
                        }
                     }
                  }
               }

               return true;
            }
         }

         return false;
      }
   }

   public void func_4019_b(ItemStack p_4019_1_, EntityLiving p_4019_2_) {
      if(p_4019_2_ instanceof EntitySheep) {
         EntitySheep var3 = (EntitySheep)p_4019_2_;
         int var4 = BlockCloth.func_21034_c(p_4019_1_.func_21181_i());
         if(!var3.func_21072_p() && var3.func_21074_p_() != var4) {
            var3.func_21071_b_(var4);
            --p_4019_1_.field_1615_a;
         }
      }

   }

}
