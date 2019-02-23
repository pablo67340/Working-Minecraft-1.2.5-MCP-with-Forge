package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.IRecipe;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RecipeSorter;
import net.minecraft.src.RecipesArmor;
import net.minecraft.src.RecipesCrafting;
import net.minecraft.src.RecipesDyes;
import net.minecraft.src.RecipesFood;
import net.minecraft.src.RecipesIngots;
import net.minecraft.src.RecipesTools;
import net.minecraft.src.RecipesWeapons;
import net.minecraft.src.ShapedRecipes;
import net.minecraft.src.ShapelessRecipes;

public class CraftingManager {

   private static final CraftingManager field_6541_a = new CraftingManager();
   private List field_1662_b = new ArrayList();


   public static final CraftingManager func_1120_a() {
      return field_6541_a;
   }

   private CraftingManager() {
      (new RecipesTools()).func_1122_a(this);
      (new RecipesWeapons()).func_766_a(this);
      (new RecipesIngots()).func_810_a(this);
      (new RecipesFood()).func_976_a(this);
      (new RecipesCrafting()).func_1051_a(this);
      (new RecipesArmor()).func_1148_a(this);
      (new RecipesDyes()).func_21157_a(this);
      this.func_1121_a(new ItemStack(Item.field_4029_aI, 3), new Object[]{"###", Character.valueOf('#'), Item.field_302_aH});
      this.func_1121_a(new ItemStack(Item.field_4028_aJ, 1), new Object[]{"#", "#", "#", Character.valueOf('#'), Item.field_4029_aI});
      this.func_1121_a(new ItemStack(Block.field_4057_ba, 2), new Object[]{"###", "###", Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Block.field_40207_bC, 6), new Object[]{"###", "###", Character.valueOf('#'), Block.field_40206_bB});
      this.func_1121_a(new ItemStack(Block.field_35277_bw, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Item.field_266_B, Character.valueOf('W'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_422_aZ, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_334_y, Character.valueOf('X'), Item.field_224_l});
      this.func_1121_a(new ItemStack(Block.field_9263_R, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_334_y, Character.valueOf('X'), Item.field_309_aA});
      this.func_1121_a(new ItemStack(Block.field_407_ao, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Block.field_334_y, Character.valueOf('X'), Item.field_4028_aJ});
      this.func_1121_a(new ItemStack(Block.field_426_aV, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_308_aB});
      this.func_1121_a(new ItemStack(Block.field_424_aX, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_303_aG});
      this.func_1121_a(new ItemStack(Block.field_409_am, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_4030_aF});
      this.func_1121_a(new ItemStack(Block.field_4049_be, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_4022_aR});
      this.func_1121_a(new ItemStack(Block.field_419_ac, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_253_I});
      this.func_1121_a(new ItemStack(Block.field_408_an, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Item.field_250_K, Character.valueOf('#'), Block.field_393_F});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 3), new Object[]{"###", Character.valueOf('#'), Block.field_335_x});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 0), new Object[]{"###", Character.valueOf('#'), Block.field_338_u});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 1), new Object[]{"###", Character.valueOf('#'), Block.field_9264_Q});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 2), new Object[]{"###", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 4), new Object[]{"###", Character.valueOf('#'), Block.field_409_am});
      this.func_1121_a(new ItemStack(Block.field_410_al, 6, 5), new Object[]{"###", Character.valueOf('#'), Block.field_35285_bn});
      this.func_1121_a(new ItemStack(Block.field_441_aG, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Item.field_265_at, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_28033_bl, 2), new Object[]{"###", "###", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Item.field_252_az, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Item.field_223_m});
      this.func_1121_a(new ItemStack(Item.field_267_as, 1), new Object[]{"###", "###", " X ", Character.valueOf('#'), Block.field_334_y, Character.valueOf('X'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Item.field_21022_aX, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Item.field_305_aE, Character.valueOf('B'), Item.field_21019_aW, Character.valueOf('C'), Item.field_243_R, Character.valueOf('E'), Item.field_296_aN});
      this.func_1121_a(new ItemStack(Item.field_21019_aW, 1), new Object[]{"#", Character.valueOf('#'), Item.field_302_aH});
      this.func_1121_a(new ItemStack(Block.field_334_y, 4, 0), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_385_K, 1, 0)});
      this.func_1121_a(new ItemStack(Block.field_334_y, 4, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_385_K, 1, 1)});
      this.func_1121_a(new ItemStack(Block.field_334_y, 4, 2), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_385_K, 1, 2)});
      this.func_1121_a(new ItemStack(Block.field_334_y, 4, 3), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_385_K, 1, 3)});
      this.func_1121_a(new ItemStack(Item.field_266_B, 4), new Object[]{"#", "#", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_404_ar, 4), new Object[]{"X", "#", Character.valueOf('X'), Item.field_225_k, Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Block.field_404_ar, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Item.field_225_k, 1, 1), Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Item.field_264_C, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Item.field_40416_bt, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_382_N});
      this.func_1121_a(new ItemStack(Block.field_440_aH, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Item.field_223_m, Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Block.field_9261_T, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_222_n, Character.valueOf('R'), Item.field_309_aA, Character.valueOf('#'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Block.field_9260_U, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_223_m, Character.valueOf('R'), Item.field_309_aA, Character.valueOf('#'), Block.field_4066_aL});
      this.func_1121_a(new ItemStack(Item.field_256_ax, 1), new Object[]{"# #", "###", Character.valueOf('#'), Item.field_223_m});
      this.func_1121_a(new ItemStack(Item.field_40408_bz, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Item.field_223_m});
      this.func_1121_a(new ItemStack(Item.field_40411_by, 1), new Object[]{" B ", "###", Character.valueOf('#'), Block.field_335_x, Character.valueOf('B'), Item.field_40417_bo});
      this.func_1121_a(new ItemStack(Block.field_4045_bg, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_4055_bb, Character.valueOf('B'), Block.field_404_ar});
      this.func_1121_a(new ItemStack(Item.field_4027_aL, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_396_av, Character.valueOf('B'), Item.field_256_ax});
      this.func_1121_a(new ItemStack(Item.field_4026_aM, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_445_aC, Character.valueOf('B'), Item.field_256_ax});
      this.func_1121_a(new ItemStack(Item.field_4031_aC, 1), new Object[]{"# #", "###", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Item.field_262_au, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Item.field_223_m});
      this.func_1121_a(new ItemStack(Item.field_4014_g, 1), new Object[]{"A ", " B", Character.valueOf('A'), Item.field_223_m, Character.valueOf('B'), Item.field_273_an});
      this.func_1121_a(new ItemStack(Item.field_242_S, 1), new Object[]{"###", Character.valueOf('#'), Item.field_243_R});
      this.func_1121_a(new ItemStack(Block.field_4059_au, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Item.field_4024_aP, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Item.field_266_B, Character.valueOf('X'), Item.field_253_I});
      this.func_1121_a(new ItemStack(Block.field_4069_aI, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_335_x});
      this.func_1121_a(new ItemStack(Block.field_35280_bx, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_409_am});
      this.func_1121_a(new ItemStack(Block.field_35279_by, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_35285_bn});
      this.func_1121_a(new ItemStack(Block.field_40204_bD, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_40206_bB});
      this.func_1121_a(new ItemStack(Item.field_270_aq, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_266_B, Character.valueOf('X'), Block.field_419_ac});
      this.func_1121_a(new ItemStack(Item.field_269_ar, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_40419_bq, Character.valueOf('X'), Item.field_228_h});
      this.func_1121_a(new ItemStack(Block.field_4067_aK, 1), new Object[]{"X", "#", Character.valueOf('#'), Block.field_335_x, Character.valueOf('X'), Item.field_266_B});
      this.func_1121_a(new ItemStack(Block.field_430_aR, 1), new Object[]{"X", "#", Character.valueOf('#'), Item.field_266_B, Character.valueOf('X'), Item.field_309_aA});
      this.func_1121_a(new ItemStack(Item.field_22018_aZ, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Block.field_430_aR, Character.valueOf('X'), Item.field_309_aA, Character.valueOf('I'), Block.field_338_u});
      this.func_1121_a(new ItemStack(Item.field_4023_aQ, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_222_n, Character.valueOf('X'), Item.field_309_aA});
      this.func_1121_a(new ItemStack(Item.field_4025_aO, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_223_m, Character.valueOf('X'), Item.field_309_aA});
      this.func_1121_a(new ItemStack(Item.field_28010_bb, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_4029_aI, Character.valueOf('X'), Item.field_4025_aO});
      this.func_1121_a(new ItemStack(Block.field_4064_aS, 1), new Object[]{"#", "#", Character.valueOf('#'), Block.field_338_u});
      this.func_1121_a(new ItemStack(Block.field_4066_aL, 1), new Object[]{"##", Character.valueOf('#'), Block.field_338_u});
      this.func_1121_a(new ItemStack(Block.field_4065_aN, 1), new Object[]{"##", Character.valueOf('#'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_9265_P, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Block.field_335_x, Character.valueOf('X'), Item.field_227_i, Character.valueOf('R'), Item.field_309_aA});
      this.func_1121_a(new ItemStack(Block.field_9255_Z, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Block.field_335_x, Character.valueOf('X'), Item.field_223_m, Character.valueOf('R'), Item.field_309_aA, Character.valueOf('T'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_9259_V, 1), new Object[]{"S", "P", Character.valueOf('S'), Item.field_299_aK, Character.valueOf('P'), Block.field_9255_Z});
      this.func_1121_a(new ItemStack(Item.field_22019_aY, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Block.field_419_ac, Character.valueOf('X'), Block.field_334_y});
      this.func_1121_a(new ItemStack(Block.field_40210_bF, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Block.field_405_aq, Character.valueOf('B'), Item.field_4028_aJ, Character.valueOf('D'), Item.field_224_l});
      this.func_21187_b(new ItemStack(Item.field_40420_bA, 1), new Object[]{Item.field_35416_bo, Item.field_40409_bw});
      this.func_21187_b(new ItemStack(Item.field_48439_bE, 3), new Object[]{Item.field_250_K, Item.field_40409_bw, Item.field_225_k});
      this.func_21187_b(new ItemStack(Item.field_48439_bE, 3), new Object[]{Item.field_250_K, Item.field_40409_bw, new ItemStack(Item.field_225_k, 1, 1)});
      Collections.sort(this.field_1662_b, new RecipeSorter(this));
      System.out.println(this.field_1662_b.size() + " recipes");
   }

   void func_1121_a(ItemStack p_1121_1_, Object ... p_1121_2_) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(p_1121_2_[var4] instanceof String[]) {
         String[] var7 = (String[])((String[])p_1121_2_[var4++]);

         for(int var8 = 0; var8 < var7.length; ++var8) {
            String var9 = var7[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(p_1121_2_[var4] instanceof String) {
            String var11 = (String)p_1121_2_[var4++];
            ++var6;
            var5 = var11.length();
            var3 = var3 + var11;
         }
      }

      HashMap var12;
      for(var12 = new HashMap(); var4 < p_1121_2_.length; var4 += 2) {
         Character var13 = (Character)p_1121_2_[var4];
         ItemStack var15 = null;
         if(p_1121_2_[var4 + 1] instanceof Item) {
            var15 = new ItemStack((Item)p_1121_2_[var4 + 1]);
         } else if(p_1121_2_[var4 + 1] instanceof Block) {
            var15 = new ItemStack((Block)p_1121_2_[var4 + 1], 1, -1);
         } else if(p_1121_2_[var4 + 1] instanceof ItemStack) {
            var15 = (ItemStack)p_1121_2_[var4 + 1];
         }

         var12.put(var13, var15);
      }

      ItemStack[] var14 = new ItemStack[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var14[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).func_1102_e();
         } else {
            var14[var16] = null;
         }
      }

      this.field_1662_b.add(new ShapedRecipes(var5, var6, var14, p_1121_1_));
   }

   void func_21187_b(ItemStack p_21187_1_, Object ... p_21187_2_) {
      ArrayList var3 = new ArrayList();
      Object[] var4 = p_21187_2_;
      int var5 = p_21187_2_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).func_1102_e());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new RuntimeException("Invalid shapeless recipy!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.field_1662_b.add(new ShapelessRecipes(p_21187_1_, var3));
   }

   public ItemStack func_21188_a(InventoryCrafting p_21188_1_) {
      int var2 = 0;
      ItemStack var3 = null;
      ItemStack var4 = null;

      int var5;
      for(var5 = 0; var5 < p_21188_1_.func_469_c(); ++var5) {
         ItemStack var6 = p_21188_1_.func_468_c(var5);
         if(var6 != null) {
            if(var2 == 0) {
               var3 = var6;
            }

            if(var2 == 1) {
               var4 = var6;
            }

            ++var2;
         }
      }

      if(var2 == 2 && var3.field_1617_c == var4.field_1617_c && var3.field_1615_a == 1 && var4.field_1615_a == 1 && Item.field_233_c[var3.field_1617_c].func_25007_g()) {
         Item var10 = Item.field_233_c[var3.field_1617_c];
         int var12 = var10.func_197_c() - var3.func_21179_h();
         int var7 = var10.func_197_c() - var4.func_21179_h();
         int var8 = var12 + var7 + var10.func_197_c() * 10 / 100;
         int var9 = var10.func_197_c() - var8;
         if(var9 < 0) {
            var9 = 0;
         }

         return new ItemStack(var3.field_1617_c, 1, var9);
      } else {
         for(var5 = 0; var5 < this.field_1662_b.size(); ++var5) {
            IRecipe var11 = (IRecipe)this.field_1662_b.get(var5);
            if(var11.func_21135_a(p_21188_1_)) {
               return var11.func_21136_b(p_21188_1_);
            }
         }

         return null;
      }
   }

   public List func_25193_b() {
      return this.field_1662_b;
   }

}
