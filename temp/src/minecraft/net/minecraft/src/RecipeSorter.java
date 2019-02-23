package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.IRecipe;
import net.minecraft.src.ShapedRecipes;
import net.minecraft.src.ShapelessRecipes;

class RecipeSorter implements Comparator {

   // $FF: synthetic field
   final CraftingManager field_1557_a;


   RecipeSorter(CraftingManager p_i366_1_) {
      this.field_1557_a = p_i366_1_;
   }

   public int func_1040_a(IRecipe p_1040_1_, IRecipe p_1040_2_) {
      return p_1040_1_ instanceof ShapelessRecipes && p_1040_2_ instanceof ShapedRecipes?1:(p_1040_2_ instanceof ShapelessRecipes && p_1040_1_ instanceof ShapedRecipes?-1:(p_1040_2_.func_1184_a() < p_1040_1_.func_1184_a()?-1:(p_1040_2_.func_1184_a() > p_1040_1_.func_1184_a()?1:0)));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_1040_a((IRecipe)p_compare_1_, (IRecipe)p_compare_2_);
   }
}
