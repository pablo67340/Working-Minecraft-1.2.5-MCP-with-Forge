package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Empty3;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentData;
import net.minecraft.src.EnchantmentModifierDamage;
import net.minecraft.src.EnchantmentModifierLiving;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IEnchantmentModifier;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.WeightedRandom;

public class EnchantmentHelper {

   private static final Random field_40649_a = new Random();
   private static final EnchantmentModifierDamage field_40647_b = new EnchantmentModifierDamage((Empty3)null);
   private static final EnchantmentModifierLiving field_40648_c = new EnchantmentModifierLiving((Empty3)null);


   public static int func_40634_b(int p_40634_0_, ItemStack p_40634_1_) {
      if(p_40634_1_ == null) {
         return 0;
      } else {
         NBTTagList var2 = p_40634_1_.func_40714_p();
         if(var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_741_a(var3)).func_745_d("id");
               short var5 = ((NBTTagCompound)var2.func_741_a(var3)).func_745_d("lvl");
               if(var4 == p_40634_0_) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   private static int func_40636_a(int p_40636_0_, ItemStack[] p_40636_1_) {
      int var2 = 0;
      ItemStack[] var3 = p_40636_1_;
      int var4 = p_40636_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         ItemStack var6 = var3[var5];
         int var7 = func_40634_b(p_40636_0_, var6);
         if(var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   private static void func_40641_a(IEnchantmentModifier p_40641_0_, ItemStack p_40641_1_) {
      if(p_40641_1_ != null) {
         NBTTagList var2 = p_40641_1_.func_40714_p();
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
               short var4 = ((NBTTagCompound)var2.func_741_a(var3)).func_745_d("id");
               short var5 = ((NBTTagCompound)var2.func_741_a(var3)).func_745_d("lvl");
               if(Enchantment.field_40504_a[var4] != null) {
                  p_40641_0_.func_40244_a(Enchantment.field_40504_a[var4], var5);
               }
            }

         }
      }
   }

   private static void func_40639_a(IEnchantmentModifier p_40639_0_, ItemStack[] p_40639_1_) {
      ItemStack[] var2 = p_40639_1_;
      int var3 = p_40639_1_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         func_40641_a(p_40639_0_, var5);
      }

   }

   public static int func_40643_a(InventoryPlayer p_40643_0_, DamageSource p_40643_1_) {
      field_40647_b.field_40246_a = 0;
      field_40647_b.field_40245_b = p_40643_1_;
      func_40639_a(field_40647_b, p_40643_0_.field_842_b);
      if(field_40647_b.field_40246_a > 25) {
         field_40647_b.field_40246_a = 25;
      }

      return (field_40647_b.field_40246_a + 1 >> 1) + field_40649_a.nextInt((field_40647_b.field_40246_a >> 1) + 1);
   }

   public static int func_40630_a(InventoryPlayer p_40630_0_, EntityLiving p_40630_1_) {
      field_40648_c.field_40248_a = 0;
      field_40648_c.field_40247_b = p_40630_1_;
      func_40641_a(field_40648_c, p_40630_0_.func_494_a());
      return field_40648_c.field_40248_a > 0?1 + field_40649_a.nextInt(field_40648_c.field_40248_a):0;
   }

   public static int func_40645_b(InventoryPlayer p_40645_0_, EntityLiving p_40645_1_) {
      return func_40634_b(Enchantment.field_40507_l.field_40516_s, p_40645_0_.func_494_a());
   }

   public static int func_40631_c(InventoryPlayer p_40631_0_, EntityLiving p_40631_1_) {
      return func_40634_b(Enchantment.field_40508_m.field_40516_s, p_40631_0_.func_494_a());
   }

   public static int func_40632_a(InventoryPlayer p_40632_0_) {
      return func_40636_a(Enchantment.field_40499_g.field_40516_s, p_40632_0_.field_842_b);
   }

   public static int func_40642_b(InventoryPlayer p_40642_0_) {
      return func_40634_b(Enchantment.field_40506_o.field_40516_s, p_40642_0_.func_494_a());
   }

   public static int func_40640_c(InventoryPlayer p_40640_0_) {
      return func_40634_b(Enchantment.field_40518_q.field_40516_s, p_40640_0_.func_494_a());
   }

   public static boolean func_40646_d(InventoryPlayer p_40646_0_) {
      return func_40634_b(Enchantment.field_40519_p.field_40516_s, p_40646_0_.func_494_a()) > 0;
   }

   public static int func_40638_e(InventoryPlayer p_40638_0_) {
      return func_40634_b(Enchantment.field_40517_r.field_40516_s, p_40638_0_.func_494_a());
   }

   public static int func_40637_f(InventoryPlayer p_40637_0_) {
      return func_40634_b(Enchantment.field_40505_n.field_40516_s, p_40637_0_.func_494_a());
   }

   public static boolean func_40633_g(InventoryPlayer p_40633_0_) {
      return func_40636_a(Enchantment.field_40511_h.field_40516_s, p_40633_0_.field_842_b) > 0;
   }

   public static int func_40629_a(Random p_40629_0_, int p_40629_1_, int p_40629_2_, ItemStack p_40629_3_) {
      Item var4 = p_40629_3_.func_1091_a();
      int var5 = var4.func_40399_b();
      if(var5 <= 0) {
         return 0;
      } else {
         if(p_40629_2_ > 30) {
            p_40629_2_ = 30;
         }

         p_40629_2_ = 1 + (p_40629_2_ >> 1) + p_40629_0_.nextInt(p_40629_2_ + 1);
         int var6 = p_40629_0_.nextInt(5) + p_40629_2_;
         return p_40629_1_ == 0?(var6 >> 1) + 1:(p_40629_1_ == 1?var6 * 2 / 3 + 1:var6);
      }
   }

   public static void func_48441_a(Random p_48441_0_, ItemStack p_48441_1_, int p_48441_2_) {
      List var3 = func_40644_a(p_48441_0_, p_48441_1_, p_48441_2_);
      if(var3 != null) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            EnchantmentData var5 = (EnchantmentData)var4.next();
            p_48441_1_.func_40705_a(var5.field_40264_a, var5.field_40263_b);
         }
      }

   }

   public static List func_40644_a(Random p_40644_0_, ItemStack p_40644_1_, int p_40644_2_) {
      Item var3 = p_40644_1_.func_1091_a();
      int var4 = var3.func_40399_b();
      if(var4 <= 0) {
         return null;
      } else {
         var4 = 1 + p_40644_0_.nextInt((var4 >> 1) + 1) + p_40644_0_.nextInt((var4 >> 1) + 1);
         int var5 = var4 + p_40644_2_;
         float var6 = (p_40644_0_.nextFloat() + p_40644_0_.nextFloat() - 1.0F) * 0.25F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         ArrayList var8 = null;
         Map var9 = func_40635_a(var7, p_40644_1_);
         if(var9 != null && !var9.isEmpty()) {
            EnchantmentData var10 = (EnchantmentData)WeightedRandom.func_35733_a(p_40644_0_, var9.values());
            if(var10 != null) {
               var8 = new ArrayList();
               var8.add(var10);

               for(int var11 = var7 >> 1; p_40644_0_.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(true) {
                        if(var15.hasNext()) {
                           EnchantmentData var16 = (EnchantmentData)var15.next();
                           if(var16.field_40264_a.func_40496_a(Enchantment.field_40504_a[var13.intValue()])) {
                              continue;
                           }

                           var14 = false;
                        }

                        if(!var14) {
                           var12.remove();
                        }
                        break;
                     }
                  }

                  if(!var9.isEmpty()) {
                     EnchantmentData var17 = (EnchantmentData)WeightedRandom.func_35733_a(p_40644_0_, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map func_40635_a(int p_40635_0_, ItemStack p_40635_1_) {
      Item var2 = p_40635_1_.func_1091_a();
      HashMap var3 = null;
      Enchantment[] var4 = Enchantment.field_40504_a;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Enchantment var7 = var4[var6];
         if(var7 != null && var7.field_40515_t.func_40650_a(var2)) {
            for(int var8 = var7.func_40493_c(); var8 <= var7.func_40491_a(); ++var8) {
               if(p_40635_0_ >= var7.func_40492_a(var8) && p_40635_0_ <= var7.func_40489_b(var8)) {
                  if(var3 == null) {
                     var3 = new HashMap();
                  }

                  var3.put(Integer.valueOf(var7.field_40516_s), new EnchantmentData(var7, var8));
               }
            }
         }
      }

      return var3;
   }

}
