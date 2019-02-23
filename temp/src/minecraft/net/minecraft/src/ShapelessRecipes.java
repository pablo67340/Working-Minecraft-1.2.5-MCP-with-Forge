package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public class ShapelessRecipes implements IRecipe {

   private final ItemStack field_21144_a;
   private final List field_21143_b;


   public ShapelessRecipes(ItemStack p_i140_1_, List p_i140_2_) {
      this.field_21144_a = p_i140_1_;
      this.field_21143_b = p_i140_2_;
   }

   public ItemStack func_25117_b() {
      return this.field_21144_a;
   }

   public boolean func_21135_a(InventoryCrafting p_21135_1_) {
      ArrayList var2 = new ArrayList(this.field_21143_b);

      for(int var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 3; ++var4) {
            ItemStack var5 = p_21135_1_.func_21103_b(var4, var3);
            if(var5 != null) {
               boolean var6 = false;
               Iterator var7 = var2.iterator();

               while(var7.hasNext()) {
                  ItemStack var8 = (ItemStack)var7.next();
                  if(var5.field_1617_c == var8.field_1617_c && (var8.func_21181_i() == -1 || var5.func_21181_i() == var8.func_21181_i())) {
                     var6 = true;
                     var2.remove(var8);
                     break;
                  }
               }

               if(!var6) {
                  return false;
               }
            }
         }
      }

      return var2.isEmpty();
   }

   public ItemStack func_21136_b(InventoryCrafting p_21136_1_) {
      return this.field_21144_a.func_1102_e();
   }

   public int func_1184_a() {
      return this.field_21143_b.size();
   }
}
