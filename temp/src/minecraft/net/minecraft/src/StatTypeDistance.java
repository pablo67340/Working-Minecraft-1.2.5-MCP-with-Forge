package net.minecraft.src;

import net.minecraft.src.IStatType;
import net.minecraft.src.StatBase;

final class StatTypeDistance implements IStatType {

   public String func_27192_a(int p_27192_1_) {
      double var3 = (double)p_27192_1_ / 100.0D;
      double var5 = var3 / 1000.0D;
      return var5 > 0.5D?StatBase.func_27081_j().format(var5) + " km":(var3 > 0.5D?StatBase.func_27081_j().format(var3) + " m":p_27192_1_ + " cm");
   }
}
