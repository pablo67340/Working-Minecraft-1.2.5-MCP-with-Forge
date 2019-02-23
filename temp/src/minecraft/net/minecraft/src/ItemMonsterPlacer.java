package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;

public class ItemMonsterPlacer extends Item {

   public ItemMonsterPlacer(int p_i25_1_) {
      super(p_i25_1_);
      this.func_21015_a(true);
   }

   public String func_40397_d(ItemStack p_40397_1_) {
      String var2 = ("" + StatCollector.func_25200_a(this.func_20009_a() + ".name")).trim();
      String var3 = EntityList.func_44040_a(p_40397_1_.func_21181_i());
      if(var3 != null) {
         var2 = var2 + " " + StatCollector.func_25200_a("entity." + var3 + ".name");
      }

      return var2;
   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      EntityEggInfo var3 = (EntityEggInfo)EntityList.field_44041_a.get(Integer.valueOf(p_27010_1_));
      return var3 != null?(p_27010_2_ == 0?var3.field_46061_b:var3.field_46062_c):16777215;
   }

   public boolean func_46058_c() {
      return true;
   }

   public int func_46057_a(int p_46057_1_, int p_46057_2_) {
      return p_46057_2_ > 0?super.func_46057_a(p_46057_1_, p_46057_2_) + 16:super.func_46057_a(p_46057_1_, p_46057_2_);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_3_.field_1026_y) {
         return true;
      } else {
         int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
         p_192_4_ += Facing.field_31056_b[p_192_7_];
         p_192_5_ += Facing.field_31059_c[p_192_7_];
         p_192_6_ += Facing.field_31058_d[p_192_7_];
         double var9 = 0.0D;
         if(p_192_7_ == 1 && var8 == Block.field_4057_ba.field_376_bc || var8 == Block.field_40207_bC.field_376_bc) {
            var9 = 0.5D;
         }

         if(func_48440_a(p_192_3_, p_192_1_.func_21181_i(), (double)p_192_4_ + 0.5D, (double)p_192_5_ + var9, (double)p_192_6_ + 0.5D) && !p_192_2_.field_35212_aW.field_35756_d) {
            --p_192_1_.field_1615_a;
         }

         return true;
      }
   }

   public static boolean func_48440_a(World p_48440_0_, int p_48440_1_, double p_48440_2_, double p_48440_4_, double p_48440_6_) {
      if(!EntityList.field_44041_a.containsKey(Integer.valueOf(p_48440_1_))) {
         return false;
      } else {
         Entity var8 = EntityList.func_1084_a(p_48440_1_, p_48440_0_);
         if(var8 != null) {
            var8.func_365_c(p_48440_2_, p_48440_4_, p_48440_6_, p_48440_0_.field_1037_n.nextFloat() * 360.0F, 0.0F);
            p_48440_0_.func_674_a(var8);
            ((EntityLiving)var8).func_22050_O();
         }

         return var8 != null;
      }
   }
}
