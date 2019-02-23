package net.minecraft.src;

import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemSword;
import net.minecraft.src.ItemTool;

public enum EnumEnchantmentType {

   all("all", 0),
   armor("armor", 1),
   armor_feet("armor_feet", 2),
   armor_legs("armor_legs", 3),
   armor_torso("armor_torso", 4),
   armor_head("armor_head", 5),
   weapon("weapon", 6),
   digger("digger", 7),
   bow("bow", 8);
   // $FF: synthetic field
   private static final EnumEnchantmentType[] $VALUES = new EnumEnchantmentType[]{all, armor, armor_feet, armor_legs, armor_torso, armor_head, weapon, digger, bow};


   private EnumEnchantmentType(String p_i445_1_, int p_i445_2_) {}

   public boolean func_40650_a(Item p_40650_1_) {
      if(this == all) {
         return true;
      } else if(p_40650_1_ instanceof ItemArmor) {
         if(this == armor) {
            return true;
         } else {
            ItemArmor var2 = (ItemArmor)p_40650_1_;
            return var2.field_313_aX == 0?this == armor_head:(var2.field_313_aX == 2?this == armor_legs:(var2.field_313_aX == 1?this == armor_torso:(var2.field_313_aX == 3?this == armor_feet:false)));
         }
      } else {
         return p_40650_1_ instanceof ItemSword?this == weapon:(p_40650_1_ instanceof ItemTool?this == digger:(p_40650_1_ instanceof ItemBow?this == bow:false));
      }
   }

}
