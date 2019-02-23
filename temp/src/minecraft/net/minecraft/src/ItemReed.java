package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemReed extends Item {

   private int field_320_a;


   public ItemReed(int p_i20_1_, Block p_i20_2_) {
      super(p_i20_1_);
      this.field_320_a = p_i20_2_.field_376_bc;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
      if(var8 == Block.field_428_aT.field_376_bc) {
         p_192_7_ = 1;
      } else if(var8 != Block.field_35278_bv.field_376_bc && var8 != Block.field_9257_X.field_376_bc && var8 != Block.field_9256_Y.field_376_bc) {
         if(p_192_7_ == 0) {
            --p_192_5_;
         }

         if(p_192_7_ == 1) {
            ++p_192_5_;
         }

         if(p_192_7_ == 2) {
            --p_192_6_;
         }

         if(p_192_7_ == 3) {
            ++p_192_6_;
         }

         if(p_192_7_ == 4) {
            --p_192_4_;
         }

         if(p_192_7_ == 5) {
            ++p_192_4_;
         }
      }

      if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else if(p_192_1_.field_1615_a == 0) {
         return false;
      } else {
         if(p_192_3_.func_695_a(this.field_320_a, p_192_4_, p_192_5_, p_192_6_, false, p_192_7_)) {
            Block var9 = Block.field_345_n[this.field_320_a];
            if(p_192_3_.func_690_d(p_192_4_, p_192_5_, p_192_6_, this.field_320_a)) {
               if(p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_) == this.field_320_a) {
                  Block.field_345_n[this.field_320_a].func_258_d(p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_7_);
                  Block.field_345_n[this.field_320_a].func_4026_a(p_192_3_, p_192_4_, p_192_5_, p_192_6_, p_192_2_);
               }

               p_192_3_.func_684_a((double)((float)p_192_4_ + 0.5F), (double)((float)p_192_5_ + 0.5F), (double)((float)p_192_6_ + 0.5F), var9.field_358_bl.func_1145_d(), (var9.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var9.field_358_bl.func_1144_c() * 0.8F);
               --p_192_1_.field_1615_a;
            }
         }

         return true;
      }
   }
}
