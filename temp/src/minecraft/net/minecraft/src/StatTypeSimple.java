package net.minecraft.src;

import net.minecraft.src.IStatType;
import net.minecraft.src.StatBase;

final class StatTypeSimple implements IStatType {

   public String func_27192_a(int p_27192_1_) {
      return StatBase.func_27083_i().format((long)p_27192_1_);
   }
}
