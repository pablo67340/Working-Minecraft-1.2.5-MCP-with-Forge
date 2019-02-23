package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesTools {

   private String[][] field_1665_a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] field_1664_b;


   public RecipesTools() {
      this.field_1664_b = new Object[][]{{Block.field_334_y, Block.field_335_x, Item.field_223_m, Item.field_224_l, Item.field_222_n}, {Item.field_218_r, Item.field_214_v, Item.field_231_e, Item.field_210_z, Item.field_257_G}, {Item.field_219_q, Item.field_215_u, Item.field_232_d, Item.field_211_y, Item.field_259_F}, {Item.field_217_s, Item.field_213_w, Item.field_230_f, Item.field_268_A, Item.field_255_H}, {Item.field_249_L, Item.field_248_M, Item.field_247_N, Item.field_246_O, Item.field_245_P}};
   }

   public void func_1122_a(CraftingManager p_1122_1_) {
      for(int var2 = 0; var2 < this.field_1664_b[0].length; ++var2) {
         Object var3 = this.field_1664_b[0][var2];

         for(int var4 = 0; var4 < this.field_1664_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_1664_b[var4 + 1][var2];
            p_1122_1_.func_1121_a(new ItemStack(var5), new Object[]{this.field_1665_a[var4], Character.valueOf('#'), Item.field_266_B, Character.valueOf('X'), var3});
         }
      }

      p_1122_1_.func_1121_a(new ItemStack(Item.field_31001_bc), new Object[]{" #", "# ", Character.valueOf('#'), Item.field_223_m});
   }
}
