package net.minecraft.src;

import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public class ShapedRecipes implements IRecipe {

   private int field_21138_b;
   private int field_21142_c;
   private ItemStack[] field_21141_d;
   private ItemStack field_21140_e;
   public final int field_21139_a;


   public ShapedRecipes(int p_i738_1_, int p_i738_2_, ItemStack[] p_i738_3_, ItemStack p_i738_4_) {
      this.field_21139_a = p_i738_4_.field_1617_c;
      this.field_21138_b = p_i738_1_;
      this.field_21142_c = p_i738_2_;
      this.field_21141_d = p_i738_3_;
      this.field_21140_e = p_i738_4_;
   }

   public ItemStack func_25117_b() {
      return this.field_21140_e;
   }

   public boolean func_21135_a(InventoryCrafting p_21135_1_) {
      for(int var2 = 0; var2 <= 3 - this.field_21138_b; ++var2) {
         for(int var3 = 0; var3 <= 3 - this.field_21142_c; ++var3) {
            if(this.func_21137_a(p_21135_1_, var2, var3, true)) {
               return true;
            }

            if(this.func_21137_a(p_21135_1_, var2, var3, false)) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean func_21137_a(InventoryCrafting p_21137_1_, int p_21137_2_, int p_21137_3_, boolean p_21137_4_) {
      for(int var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 3; ++var6) {
            int var7 = var5 - p_21137_2_;
            int var8 = var6 - p_21137_3_;
            ItemStack var9 = null;
            if(var7 >= 0 && var8 >= 0 && var7 < this.field_21138_b && var8 < this.field_21142_c) {
               if(p_21137_4_) {
                  var9 = this.field_21141_d[this.field_21138_b - var7 - 1 + var8 * this.field_21138_b];
               } else {
                  var9 = this.field_21141_d[var7 + var8 * this.field_21138_b];
               }
            }

            ItemStack var10 = p_21137_1_.func_21103_b(var5, var6);
            if(var10 != null || var9 != null) {
               if(var10 == null && var9 != null || var10 != null && var9 == null) {
                  return false;
               }

               if(var9.field_1617_c != var10.field_1617_c) {
                  return false;
               }

               if(var9.func_21181_i() != -1 && var9.func_21181_i() != var10.func_21181_i()) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   public ItemStack func_21136_b(InventoryCrafting p_21136_1_) {
      return new ItemStack(this.field_21140_e.field_1617_c, this.field_21140_e.field_1615_a, this.field_21140_e.func_21181_i());
   }

   public int func_1184_a() {
      return this.field_21138_b * this.field_21142_c;
   }
}
