package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCloth;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesDyes {

   public void func_21157_a(CraftingManager p_21157_1_) {
      for(int var2 = 0; var2 < 16; ++var2) {
         p_21157_1_.func_21187_b(new ItemStack(Block.field_419_ac, 1, BlockCloth.func_21035_d(var2)), new Object[]{new ItemStack(Item.field_21021_aU, 1, var2), new ItemStack(Item.field_233_c[Block.field_419_ac.field_376_bc], 1, 0)});
      }

      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 11), new Object[]{Block.field_417_ae});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 1), new Object[]{Block.field_416_af});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 15), new Object[]{Item.field_21020_aV});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 9), new Object[]{new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 14), new Object[]{new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 11)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 10), new Object[]{new ItemStack(Item.field_21021_aU, 1, 2), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 8), new Object[]{new ItemStack(Item.field_21021_aU, 1, 0), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 7), new Object[]{new ItemStack(Item.field_21021_aU, 1, 8), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 7), new Object[]{new ItemStack(Item.field_21021_aU, 1, 0), new ItemStack(Item.field_21021_aU, 1, 15), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 12), new Object[]{new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 15)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 6), new Object[]{new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 2)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 5), new Object[]{new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 2, 13), new Object[]{new ItemStack(Item.field_21021_aU, 1, 5), new ItemStack(Item.field_21021_aU, 1, 9)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 3, 13), new Object[]{new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 9)});
      p_21157_1_.func_21187_b(new ItemStack(Item.field_21021_aU, 4, 13), new Object[]{new ItemStack(Item.field_21021_aU, 1, 4), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 1), new ItemStack(Item.field_21021_aU, 1, 15)});
   }
}
