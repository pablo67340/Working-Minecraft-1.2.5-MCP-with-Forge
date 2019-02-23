package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

public class ItemPotion extends Item {

   private HashMap field_40435_a = new HashMap();


   public ItemPotion(int p_i301_1_) {
      super(p_i301_1_);
      this.func_21009_c(1);
      this.func_21015_a(true);
      this.func_21013_d(0);
   }

   public List func_40434_a_(ItemStack p_40434_1_) {
      return this.func_40431_c_(p_40434_1_.func_21181_i());
   }

   public List func_40431_c_(int p_40431_1_) {
      List var2 = (List)this.field_40435_a.get(Integer.valueOf(p_40431_1_));
      if(var2 == null) {
         var2 = PotionHelper.func_40360_b(p_40431_1_, false);
         this.field_40435_a.put(Integer.valueOf(p_40431_1_), var2);
      }

      return var2;
   }

   public ItemStack func_35413_b(ItemStack p_35413_1_, World p_35413_2_, EntityPlayer p_35413_3_) {
      --p_35413_1_.field_1615_a;
      if(!p_35413_2_.field_1026_y) {
         List var4 = this.func_40434_a_(p_35413_1_);
         if(var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               PotionEffect var6 = (PotionEffect)var5.next();
               p_35413_3_.func_35165_a(new PotionEffect(var6));
            }
         }
      }

      if(p_35413_1_.field_1615_a <= 0) {
         return new ItemStack(Item.field_40416_bt);
      } else {
         p_35413_3_.field_778_b.func_504_a(new ItemStack(Item.field_40416_bt));
         return p_35413_1_;
      }
   }

   public int func_35411_c(ItemStack p_35411_1_) {
      return 32;
   }

   public EnumAction func_35412_b(ItemStack p_35412_1_) {
      return EnumAction.drink;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      if(func_40433_c(p_193_1_.func_21181_i())) {
         --p_193_1_.field_1615_a;
         p_193_2_.func_623_a(p_193_3_, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
         if(!p_193_2_.field_1026_y) {
            p_193_2_.func_674_a(new EntityPotion(p_193_2_, p_193_3_, p_193_1_.func_21181_i()));
         }

         return p_193_1_;
      } else {
         p_193_3_.func_35199_b(p_193_1_, this.func_35411_c(p_193_1_));
         return p_193_1_;
      }
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      return false;
   }

   public int func_27009_a(int p_27009_1_) {
      return func_40433_c(p_27009_1_)?154:140;
   }

   public int func_46057_a(int p_46057_1_, int p_46057_2_) {
      return p_46057_2_ == 0?141:super.func_46057_a(p_46057_1_, p_46057_2_);
   }

   public static boolean func_40433_c(int p_40433_0_) {
      return (p_40433_0_ & 16384) != 0;
   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      return p_27010_2_ > 0?16777215:PotionHelper.func_40358_a(p_27010_1_, false);
   }

   public boolean func_46058_c() {
      return true;
   }

   public boolean func_40432_e(int p_40432_1_) {
      List var2 = this.func_40431_c_(p_40432_1_);
      if(var2 != null && !var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         PotionEffect var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (PotionEffect)var3.next();
         } while(!Potion.field_35678_a[var4.func_35799_a()].func_40622_b());

         return true;
      } else {
         return false;
      }
   }

   public String func_40397_d(ItemStack p_40397_1_) {
      if(p_40397_1_.func_21181_i() == 0) {
         return StatCollector.func_25200_a("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if(func_40433_c(p_40397_1_.func_21181_i())) {
            var2 = StatCollector.func_25200_a("potion.prefix.grenade").trim() + " ";
         }

         List var3 = Item.field_40413_bs.func_40434_a_(p_40397_1_);
         String var4;
         if(var3 != null && !var3.isEmpty()) {
            var4 = ((PotionEffect)var3.get(0)).func_40468_d();
            var4 = var4 + ".postfix";
            return var2 + StatCollector.func_25200_a(var4).trim();
         } else {
            var4 = PotionHelper.func_40359_b(p_40397_1_.func_21181_i());
            return StatCollector.func_25200_a(var4).trim() + " " + super.func_40397_d(p_40397_1_);
         }
      }
   }

   public void func_40404_a(ItemStack p_40404_1_, List p_40404_2_) {
      if(p_40404_1_.func_21181_i() != 0) {
         List var3 = Item.field_40413_bs.func_40434_a_(p_40404_1_);
         if(var3 != null && !var3.isEmpty()) {
            Iterator var7 = var3.iterator();

            while(var7.hasNext()) {
               PotionEffect var5 = (PotionEffect)var7.next();
               String var6 = StatCollector.func_25200_a(var5.func_40468_d()).trim();
               if(var5.func_35801_c() > 0) {
                  var6 = var6 + " " + StatCollector.func_25200_a("potion.potency." + var5.func_35801_c()).trim();
               }

               if(var5.func_35802_b() > 20) {
                  var6 = var6 + " (" + Potion.func_40620_a(var5) + ")";
               }

               if(Potion.field_35678_a[var5.func_35799_a()].func_40615_f()) {
                  p_40404_2_.add("\u00a7c" + var6);
               } else {
                  p_40404_2_.add("\u00a77" + var6);
               }
            }
         } else {
            String var4 = StatCollector.func_25200_a("potion.empty").trim();
            p_40404_2_.add("\u00a77" + var4);
         }

      }
   }

   public boolean func_40403_e(ItemStack p_40403_1_) {
      List var2 = this.func_40434_a_(p_40403_1_);
      return var2 != null && !var2.isEmpty();
   }
}
