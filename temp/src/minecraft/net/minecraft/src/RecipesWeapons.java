package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesWeapons {

   private String[][] field_1100_a = new String[][]{{"X", "X", "#"}};
   private Object[][] field_1099_b;


   public RecipesWeapons() {
      this.field_1099_b = new Object[][]{{Block.field_334_y, Block.field_335_x, Item.field_223_m, Item.field_224_l, Item.field_222_n}, {Item.field_220_p, Item.field_216_t, Item.field_221_o, Item.field_212_x, Item.field_261_E}};
   }

   public void func_766_a(CraftingManager p_766_1_) {
      for(int var2 = 0; var2 < this.field_1099_b[0].length; ++var2) {
         Object var3 = this.field_1099_b[0][var2];

         for(int var4 = 0; var4 < this.field_1099_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_1099_b[var4 + 1][var2];
            p_766_1_.func_1121_a(new ItemStack(var5), new Object[]{this.field_1100_a[var4], Character.valueOf('#'), Item.field_266_B, Character.valueOf('X'), var3});
         }
      }

      p_766_1_.func_1121_a(new ItemStack(Item.field_227_i, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Item.field_253_I, Character.valueOf('#'), Item.field_266_B});
      p_766_1_.func_1121_a(new ItemStack(Item.field_226_j, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Item.field_251_J, Character.valueOf('X'), Item.field_273_an, Character.valueOf('#'), Item.field_266_B});
   }
}
