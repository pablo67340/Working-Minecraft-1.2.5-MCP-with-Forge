package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Achievement;
import net.minecraft.src.Block;
import net.minecraft.src.Item;

public class AchievementList {

   public static int field_27392_a;
   public static int field_27391_b;
   public static int field_27390_c;
   public static int field_27389_d;
   public static List field_27388_e = new ArrayList();
   public static Achievement field_25195_b = (new Achievement(0, "openInventory", 0, 0, Item.field_4028_aJ, (Achievement)null)).func_27089_a().func_27091_c();
   public static Achievement field_25198_c = (new Achievement(1, "mineWood", 2, 1, Block.field_385_K, field_25195_b)).func_27091_c();
   public static Achievement field_25197_d = (new Achievement(2, "buildWorkBench", 4, -1, Block.field_387_az, field_25198_c)).func_27091_c();
   public static Achievement field_27387_i = (new Achievement(3, "buildPickaxe", 4, 2, Item.field_218_r, field_25197_d)).func_27091_c();
   public static Achievement field_27386_j = (new Achievement(4, "buildFurnace", 3, 4, Block.field_444_aD, field_27387_i)).func_27091_c();
   public static Achievement field_27385_k = (new Achievement(5, "acquireIron", 1, 4, Item.field_223_m, field_27386_j)).func_27091_c();
   public static Achievement field_27384_l = (new Achievement(6, "buildHoe", 2, -3, Item.field_249_L, field_25197_d)).func_27091_c();
   public static Achievement field_27383_m = (new Achievement(7, "makeBread", -1, -3, Item.field_242_S, field_27384_l)).func_27091_c();
   public static Achievement field_27382_n = (new Achievement(8, "bakeCake", 0, -5, Item.field_21022_aX, field_27384_l)).func_27091_c();
   public static Achievement field_27381_o = (new Achievement(9, "buildBetterPickaxe", 6, 2, Item.field_214_v, field_27387_i)).func_27091_c();
   public static Achievement field_27380_p = (new Achievement(10, "cookFish", 2, 6, Item.field_4020_aT, field_27386_j)).func_27091_c();
   public static Achievement field_27379_q = (new Achievement(11, "onARail", 2, 3, Block.field_440_aH, field_27385_k)).func_27094_b().func_27091_c();
   public static Achievement field_27378_r = (new Achievement(12, "buildSword", 6, -1, Item.field_220_p, field_25197_d)).func_27091_c();
   public static Achievement field_27377_s = (new Achievement(13, "killEnemy", 8, -1, Item.field_21020_aV, field_27378_r)).func_27091_c();
   public static Achievement field_27376_t = (new Achievement(14, "killCow", 7, -3, Item.field_306_aD, field_27378_r)).func_27091_c();
   public static Achievement field_27375_u = (new Achievement(15, "flyPig", 8, -4, Item.field_254_ay, field_27376_t)).func_27094_b().func_27091_c();
   public static Achievement field_35608_v = (new Achievement(16, "snipeSkeleton", 7, 0, Item.field_227_i, field_27377_s)).func_27094_b().func_27091_c();
   public static Achievement field_40464_w = (new Achievement(17, "diamonds", -1, 5, Item.field_224_l, field_27385_k)).func_27091_c();
   public static Achievement field_40467_x = (new Achievement(18, "portal", -1, 7, Block.field_405_aq, field_40464_w)).func_27091_c();
   public static Achievement field_40466_y = (new Achievement(19, "ghast", -4, 8, Item.field_40418_bp, field_40467_x)).func_27094_b().func_27091_c();
   public static Achievement field_40465_z = (new Achievement(20, "blazeRod", 0, 9, Item.field_40417_bo, field_40467_x)).func_27091_c();
   public static Achievement field_40461_A = (new Achievement(21, "potion", 2, 8, Item.field_40413_bs, field_40465_z)).func_27091_c();
   public static Achievement field_40462_B = (new Achievement(22, "theEnd", 3, 10, Item.field_40420_bA, field_40465_z)).func_27094_b().func_27091_c();
   public static Achievement field_40463_C = (new Achievement(23, "theEnd2", 4, 13, Block.field_41050_bK, field_40462_B)).func_27094_b().func_27091_c();
   public static Achievement field_40458_D = (new Achievement(24, "enchantments", -4, 4, Block.field_40210_bF, field_40464_w)).func_27091_c();
   public static Achievement field_40459_E = (new Achievement(25, "overkill", -4, 1, Item.field_212_x, field_40458_D)).func_27094_b().func_27091_c();
   public static Achievement field_40460_F = (new Achievement(26, "bookcase", -3, 6, Block.field_407_ao, field_40458_D)).func_27091_c();


   public static void func_27374_a() {}

   static {
      System.out.println(field_27388_e.size() + " achievements");
   }
}
