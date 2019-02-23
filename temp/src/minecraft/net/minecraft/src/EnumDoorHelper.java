package net.minecraft.src;

import net.minecraft.src.EnumDoor;

// $FF: synthetic class
class EnumDoorHelper {

   // $FF: synthetic field
   static final int[] field_35619_a = new int[EnumDoor.values().length];


   static {
      try {
         field_35619_a[EnumDoor.OPENING.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         field_35619_a[EnumDoor.WOOD_DOOR.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         field_35619_a[EnumDoor.GRATES.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         field_35619_a[EnumDoor.IRON_DOOR.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
