package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemBow extends Item {

   public ItemBow(int p_i459_1_) {
      super(p_i459_1_);
      this.field_290_aT = 1;
      this.func_21013_d(384);
   }

   public void func_35414_a(ItemStack p_35414_1_, World p_35414_2_, EntityPlayer p_35414_3_, int p_35414_4_) {
      boolean var5 = p_35414_3_.field_35212_aW.field_35756_d || EnchantmentHelper.func_40634_b(Enchantment.field_46042_v.field_40516_s, p_35414_1_) > 0;
      if(var5 || p_35414_3_.field_778_b.func_35157_d(Item.field_226_j.field_291_aS)) {
         int var6 = this.func_35411_c(p_35414_1_) - p_35414_4_;
         float var7 = (float)var6 / 20.0F;
         var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
         if((double)var7 < 0.1D) {
            return;
         }

         if(var7 > 1.0F) {
            var7 = 1.0F;
         }

         EntityArrow var8 = new EntityArrow(p_35414_2_, p_35414_3_, var7 * 2.0F);
         if(var7 == 1.0F) {
            var8.field_35140_d = true;
         }

         int var9 = EnchantmentHelper.func_40634_b(Enchantment.field_46045_s.field_40516_s, p_35414_1_);
         if(var9 > 0) {
            var8.func_46024_b(var8.func_46025_l() + (double)var9 * 0.5D + 0.5D);
         }

         int var10 = EnchantmentHelper.func_40634_b(Enchantment.field_46044_t.field_40516_s, p_35414_1_);
         if(var10 > 0) {
            var8.func_46023_b(var10);
         }

         if(EnchantmentHelper.func_40634_b(Enchantment.field_46043_u.field_40516_s, p_35414_1_) > 0) {
            var8.func_40046_d(100);
         }

         p_35414_1_.func_25190_a(1, p_35414_3_);
         p_35414_2_.func_623_a(p_35414_3_, "random.bow", 1.0F, 1.0F / (field_4015_b.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
         if(!var5) {
            p_35414_3_.field_778_b.func_510_b(Item.field_226_j.field_291_aS);
         } else {
            var8.field_28020_a = false;
         }

         if(!p_35414_2_.field_1026_y) {
            p_35414_2_.func_674_a(var8);
         }
      }

   }

   public ItemStack func_35413_b(ItemStack p_35413_1_, World p_35413_2_, EntityPlayer p_35413_3_) {
      return p_35413_1_;
   }

   public int func_35411_c(ItemStack p_35411_1_) {
      return 72000;
   }

   public EnumAction func_35412_b(ItemStack p_35412_1_) {
      return EnumAction.bow;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      if(p_193_3_.field_35212_aW.field_35756_d || p_193_3_.field_778_b.func_35157_d(Item.field_226_j.field_291_aS)) {
         p_193_3_.func_35199_b(p_193_1_, this.func_35411_c(p_193_1_));
      }

      return p_193_1_;
   }

   public int func_40399_b() {
      return 1;
   }
}
