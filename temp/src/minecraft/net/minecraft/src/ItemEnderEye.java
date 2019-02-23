package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockEndPortalFrame;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Direction;
import net.minecraft.src.EntityEnderEye;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class ItemEnderEye extends Item {

   public ItemEnderEye(int p_i520_1_) {
      super(p_i520_1_);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
      int var9 = p_192_3_.func_602_e(p_192_4_, p_192_5_, p_192_6_);
      if(p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_) && var8 == Block.field_40202_bJ.field_376_bc && !BlockEndPortalFrame.func_40212_d(var9)) {
         if(p_192_3_.field_1026_y) {
            return true;
         } else {
            p_192_3_.func_691_b(p_192_4_, p_192_5_, p_192_6_, var9 + 4);
            --p_192_1_.field_1615_a;

            int var10;
            for(var10 = 0; var10 < 16; ++var10) {
               double var11 = (double)((float)p_192_4_ + (5.0F + field_4015_b.nextFloat() * 6.0F) / 16.0F);
               double var13 = (double)((float)p_192_5_ + 0.8125F);
               double var15 = (double)((float)p_192_6_ + (5.0F + field_4015_b.nextFloat() * 6.0F) / 16.0F);
               double var17 = 0.0D;
               double var19 = 0.0D;
               double var21 = 0.0D;
               p_192_3_.func_694_a("smoke", var11, var13, var15, var17, var19, var21);
            }

            var10 = var9 & 3;
            int var23 = 0;
            int var12 = 0;
            boolean var24 = false;
            boolean var14 = true;
            int var25 = Direction.field_35867_f[var10];

            int var16;
            int var18;
            int var20;
            int var26;
            int var27;
            for(var16 = -2; var16 <= 2; ++var16) {
               var26 = p_192_4_ + Direction.field_35871_a[var25] * var16;
               var18 = p_192_6_ + Direction.field_35870_b[var25] * var16;
               var27 = p_192_3_.func_600_a(var26, p_192_5_, var18);
               if(var27 == Block.field_40202_bJ.field_376_bc) {
                  var20 = p_192_3_.func_602_e(var26, p_192_5_, var18);
                  if(!BlockEndPortalFrame.func_40212_d(var20)) {
                     var14 = false;
                     break;
                  }

                  if(!var24) {
                     var23 = var16;
                     var12 = var16;
                     var24 = true;
                  } else {
                     var12 = var16;
                  }
               }
            }

            if(var14 && var12 == var23 + 2) {
               for(var16 = var23; var16 <= var12; ++var16) {
                  var26 = p_192_4_ + Direction.field_35871_a[var25] * var16;
                  var18 = p_192_6_ + Direction.field_35870_b[var25] * var16;
                  var26 += Direction.field_35871_a[var10] * 4;
                  var18 += Direction.field_35870_b[var10] * 4;
                  var27 = p_192_3_.func_600_a(var26, p_192_5_, var18);
                  var20 = p_192_3_.func_602_e(var26, p_192_5_, var18);
                  if(var27 != Block.field_40202_bJ.field_376_bc || !BlockEndPortalFrame.func_40212_d(var20)) {
                     var14 = false;
                     break;
                  }
               }

               for(var16 = var23 - 1; var16 <= var12 + 1; var16 += 4) {
                  for(var26 = 1; var26 <= 3; ++var26) {
                     var18 = p_192_4_ + Direction.field_35871_a[var25] * var16;
                     var27 = p_192_6_ + Direction.field_35870_b[var25] * var16;
                     var18 += Direction.field_35871_a[var10] * var26;
                     var27 += Direction.field_35870_b[var10] * var26;
                     var20 = p_192_3_.func_600_a(var18, p_192_5_, var27);
                     int var28 = p_192_3_.func_602_e(var18, p_192_5_, var27);
                     if(var20 != Block.field_40202_bJ.field_376_bc || !BlockEndPortalFrame.func_40212_d(var28)) {
                        var14 = false;
                        break;
                     }
                  }
               }

               if(var14) {
                  for(var16 = var23; var16 <= var12; ++var16) {
                     for(var26 = 1; var26 <= 3; ++var26) {
                        var18 = p_192_4_ + Direction.field_35871_a[var25] * var16;
                        var27 = p_192_6_ + Direction.field_35870_b[var25] * var16;
                        var18 += Direction.field_35871_a[var10] * var26;
                        var27 += Direction.field_35870_b[var10] * var26;
                        p_192_3_.func_690_d(var18, p_192_5_, var27, Block.field_40209_bI.field_376_bc);
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      MovingObjectPosition var4 = this.func_40402_a(p_193_2_, p_193_3_, false);
      if(var4 != null && var4.field_1167_a == EnumMovingObjectType.TILE) {
         int var5 = p_193_2_.func_600_a(var4.field_1166_b, var4.field_1172_c, var4.field_1171_d);
         if(var5 == Block.field_40202_bJ.field_376_bc) {
            return p_193_1_;
         }
      }

      if(!p_193_2_.field_1026_y) {
         ChunkPosition var7 = p_193_2_.func_40477_b("Stronghold", (int)p_193_3_.field_611_ak, (int)p_193_3_.field_610_al, (int)p_193_3_.field_609_am);
         if(var7 != null) {
            EntityEnderEye var6 = new EntityEnderEye(p_193_2_, p_193_3_.field_611_ak, p_193_3_.field_610_al + 1.62D - (double)p_193_3_.field_9292_aO, p_193_3_.field_609_am);
            var6.func_40090_a((double)var7.field_1111_a, var7.field_1110_b, (double)var7.field_1112_c);
            p_193_2_.func_674_a(var6);
            p_193_2_.func_623_a(p_193_3_, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
            p_193_2_.func_28107_a((EntityPlayer)null, 1002, (int)p_193_3_.field_611_ak, (int)p_193_3_.field_610_al, (int)p_193_3_.field_609_am, 0);
            if(!p_193_3_.field_35212_aW.field_35756_d) {
               --p_193_1_.field_1615_a;
            }
         }
      }

      return p_193_1_;
   }
}
