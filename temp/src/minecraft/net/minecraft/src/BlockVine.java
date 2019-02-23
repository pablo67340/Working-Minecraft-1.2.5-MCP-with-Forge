package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.Direction;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class BlockVine extends Block {

   public BlockVine(int p_i66_1_) {
      super(p_i66_1_, 143, Material.field_35495_k);
      this.func_253_b(true);
   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int func_210_f() {
      return 20;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var6 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
      float var7 = 1.0F;
      float var8 = 1.0F;
      float var9 = 1.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = var6 > 0;
      if((var6 & 2) != 0) {
         var10 = Math.max(var10, 0.0625F);
         var7 = 0.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 8) != 0) {
         var7 = Math.min(var7, 0.9375F);
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 4) != 0) {
         var12 = Math.max(var12, 0.0625F);
         var9 = 0.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if((var6 & 1) != 0) {
         var9 = Math.min(var9, 0.9375F);
         var12 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if(!var13 && this.func_35302_d(p_238_1_.func_600_a(p_238_2_, p_238_3_ + 1, p_238_4_))) {
         var8 = Math.min(var8, 0.9375F);
         var11 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
      }

      this.func_213_a(var7, var8, var9, var10, var11, var12);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      switch(p_28030_5_) {
      case 1:
         return this.func_35302_d(p_28030_1_.func_600_a(p_28030_2_, p_28030_3_ + 1, p_28030_4_));
      case 2:
         return this.func_35302_d(p_28030_1_.func_600_a(p_28030_2_, p_28030_3_, p_28030_4_ + 1));
      case 3:
         return this.func_35302_d(p_28030_1_.func_600_a(p_28030_2_, p_28030_3_, p_28030_4_ - 1));
      case 4:
         return this.func_35302_d(p_28030_1_.func_600_a(p_28030_2_ + 1, p_28030_3_, p_28030_4_));
      case 5:
         return this.func_35302_d(p_28030_1_.func_600_a(p_28030_2_ - 1, p_28030_3_, p_28030_4_));
      default:
         return false;
      }
   }

   private boolean func_35302_d(int p_35302_1_) {
      if(p_35302_1_ == 0) {
         return false;
      } else {
         Block var2 = Block.field_345_n[p_35302_1_];
         return var2.func_242_c() && var2.field_356_bn.func_880_c();
      }
   }

   private boolean func_35301_h(World p_35301_1_, int p_35301_2_, int p_35301_3_, int p_35301_4_) {
      int var5 = p_35301_1_.func_602_e(p_35301_2_, p_35301_3_, p_35301_4_);
      int var6 = var5;
      if(var5 > 0) {
         for(int var7 = 0; var7 <= 3; ++var7) {
            int var8 = 1 << var7;
            if((var5 & var8) != 0 && !this.func_35302_d(p_35301_1_.func_600_a(p_35301_2_ + Direction.field_35871_a[var7], p_35301_3_, p_35301_4_ + Direction.field_35870_b[var7])) && (p_35301_1_.func_600_a(p_35301_2_, p_35301_3_ + 1, p_35301_4_) != this.field_376_bc || (p_35301_1_.func_602_e(p_35301_2_, p_35301_3_ + 1, p_35301_4_) & var8) == 0)) {
               var6 &= ~var8;
            }
         }
      }

      if(var6 == 0 && !this.func_35302_d(p_35301_1_.func_600_a(p_35301_2_, p_35301_3_ + 1, p_35301_4_))) {
         return false;
      } else {
         if(var6 != var5) {
            p_35301_1_.func_691_b(p_35301_2_, p_35301_3_, p_35301_4_, var6);
         }

         return true;
      }
   }

   public int func_35274_i() {
      return ColorizerFoliage.func_31073_c();
   }

   public int func_31030_b(int p_31030_1_) {
      return ColorizerFoliage.func_31073_c();
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      return p_207_1_.func_48454_a(p_207_2_, p_207_4_).func_48412_k();
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y && !this.func_35301_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
         this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y && p_208_1_.field_1037_n.nextInt(4) == 0) {
         byte var6 = 4;
         int var7 = 5;
         boolean var8 = false;

         int var9;
         int var10;
         int var11;
         label138:
         for(var9 = p_208_2_ - var6; var9 <= p_208_2_ + var6; ++var9) {
            for(var10 = p_208_4_ - var6; var10 <= p_208_4_ + var6; ++var10) {
               for(var11 = p_208_3_ - 1; var11 <= p_208_3_ + 1; ++var11) {
                  if(p_208_1_.func_600_a(var9, var11, var10) == this.field_376_bc) {
                     --var7;
                     if(var7 <= 0) {
                        var8 = true;
                        break label138;
                     }
                  }
               }
            }
         }

         var9 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         var10 = p_208_1_.field_1037_n.nextInt(6);
         var11 = Direction.field_35869_d[var10];
         int var12;
         int var13;
         if(var10 == 1 && p_208_3_ < 255 && p_208_1_.func_20084_d(p_208_2_, p_208_3_ + 1, p_208_4_)) {
            if(var8) {
               return;
            }

            var12 = p_208_1_.field_1037_n.nextInt(16) & var9;
            if(var12 > 0) {
               for(var13 = 0; var13 <= 3; ++var13) {
                  if(!this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var13], p_208_3_ + 1, p_208_4_ + Direction.field_35870_b[var13]))) {
                     var12 &= ~(1 << var13);
                  }
               }

               if(var12 > 0) {
                  p_208_1_.func_688_b(p_208_2_, p_208_3_ + 1, p_208_4_, this.field_376_bc, var12);
               }
            }
         } else {
            int var14;
            if(var10 >= 2 && var10 <= 5 && (var9 & 1 << var11) == 0) {
               if(var8) {
                  return;
               }

               var12 = p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var11], p_208_3_, p_208_4_ + Direction.field_35870_b[var11]);
               if(var12 != 0 && Block.field_345_n[var12] != null) {
                  if(Block.field_345_n[var12].field_356_bn.func_28126_h() && Block.field_345_n[var12].func_242_c()) {
                     p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var9 | 1 << var11);
                  }
               } else {
                  var13 = var11 + 1 & 3;
                  var14 = var11 + 3 & 3;
                  if((var9 & 1 << var13) != 0 && this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var13], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var13]))) {
                     p_208_1_.func_688_b(p_208_2_ + Direction.field_35871_a[var11], p_208_3_, p_208_4_ + Direction.field_35870_b[var11], this.field_376_bc, 1 << var13);
                  } else if((var9 & 1 << var14) != 0 && this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var14], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var14]))) {
                     p_208_1_.func_688_b(p_208_2_ + Direction.field_35871_a[var11], p_208_3_, p_208_4_ + Direction.field_35870_b[var11], this.field_376_bc, 1 << var14);
                  } else if((var9 & 1 << var13) != 0 && p_208_1_.func_20084_d(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var13], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var13]) && this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var13], p_208_3_, p_208_4_ + Direction.field_35870_b[var13]))) {
                     p_208_1_.func_688_b(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var13], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var13], this.field_376_bc, 1 << (var11 + 2 & 3));
                  } else if((var9 & 1 << var14) != 0 && p_208_1_.func_20084_d(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var14], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var14]) && this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var14], p_208_3_, p_208_4_ + Direction.field_35870_b[var14]))) {
                     p_208_1_.func_688_b(p_208_2_ + Direction.field_35871_a[var11] + Direction.field_35871_a[var14], p_208_3_, p_208_4_ + Direction.field_35870_b[var11] + Direction.field_35870_b[var14], this.field_376_bc, 1 << (var11 + 2 & 3));
                  } else if(this.func_35302_d(p_208_1_.func_600_a(p_208_2_ + Direction.field_35871_a[var11], p_208_3_ + 1, p_208_4_ + Direction.field_35870_b[var11]))) {
                     p_208_1_.func_688_b(p_208_2_ + Direction.field_35871_a[var11], p_208_3_, p_208_4_ + Direction.field_35870_b[var11], this.field_376_bc, 0);
                  }
               }
            } else if(p_208_3_ > 1) {
               var12 = p_208_1_.func_600_a(p_208_2_, p_208_3_ - 1, p_208_4_);
               if(var12 == 0) {
                  var13 = p_208_1_.field_1037_n.nextInt(16) & var9;
                  if(var13 > 0) {
                     p_208_1_.func_688_b(p_208_2_, p_208_3_ - 1, p_208_4_, this.field_376_bc, var13);
                  }
               } else if(var12 == this.field_376_bc) {
                  var13 = p_208_1_.field_1037_n.nextInt(16) & var9;
                  var14 = p_208_1_.func_602_e(p_208_2_, p_208_3_ - 1, p_208_4_);
                  if(var14 != (var14 | var13)) {
                     p_208_1_.func_691_b(p_208_2_, p_208_3_ - 1, p_208_4_, var14 | var13);
                  }
               }
            }
         }
      }

   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      byte var6 = 0;
      switch(p_258_5_) {
      case 2:
         var6 = 1;
         break;
      case 3:
         var6 = 4;
         break;
      case 4:
         var6 = 8;
         break;
      case 5:
         var6 = 2;
      }

      if(var6 != 0) {
         p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6);
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return 0;
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      if(!p_220_1_.field_1026_y && p_220_2_.func_6416_v() != null && p_220_2_.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS) {
         p_220_2_.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
         this.func_31027_a(p_220_1_, p_220_3_, p_220_4_, p_220_5_, new ItemStack(Block.field_35278_bv, 1, 0));
      } else {
         super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
      }

   }
}
