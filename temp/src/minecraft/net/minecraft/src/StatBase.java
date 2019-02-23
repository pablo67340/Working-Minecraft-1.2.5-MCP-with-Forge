package net.minecraft.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.src.AchievementMap;
import net.minecraft.src.IStatType;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.StatTypeDistance;
import net.minecraft.src.StatTypeSimple;
import net.minecraft.src.StatTypeTime;

public class StatBase {

   public final int field_25071_d;
   private final String field_25070_e;
   public boolean field_27088_g;
   public String field_25069_f;
   private final IStatType field_26902_a;
   private static NumberFormat field_26903_b = NumberFormat.getIntegerInstance(Locale.US);
   public static IStatType field_27087_i = new StatTypeSimple();
   private static DecimalFormat field_26904_c = new DecimalFormat("########0.00");
   public static IStatType field_27086_j = new StatTypeTime();
   public static IStatType field_27085_k = new StatTypeDistance();


   public StatBase(int p_i169_1_, String p_i169_2_, IStatType p_i169_3_) {
      this.field_27088_g = false;
      this.field_25071_d = p_i169_1_;
      this.field_25070_e = p_i169_2_;
      this.field_26902_a = p_i169_3_;
   }

   public StatBase(int p_i170_1_, String p_i170_2_) {
      this(p_i170_1_, p_i170_2_, field_27087_i);
   }

   public StatBase func_27082_h() {
      this.field_27088_g = true;
      return this;
   }

   public StatBase func_25068_c() {
      if(StatList.field_25169_C.containsKey(Integer.valueOf(this.field_25071_d))) {
         throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.field_25169_C.get(Integer.valueOf(this.field_25071_d))).field_25070_e + "\" and \"" + this.field_25070_e + "\" at id " + this.field_25071_d);
      } else {
         StatList.field_25188_a.add(this);
         StatList.field_25169_C.put(Integer.valueOf(this.field_25071_d), this);
         this.field_25069_f = AchievementMap.func_25208_a(this.field_25071_d);
         return this;
      }
   }

   public boolean func_25067_a() {
      return false;
   }

   public String func_27084_a(int p_27084_1_) {
      return this.field_26902_a.func_27192_a(p_27084_1_);
   }

   public String func_44020_i() {
      return this.field_25070_e;
   }

   public String toString() {
      return StatCollector.func_25200_a(this.field_25070_e);
   }

   // $FF: synthetic method
   static NumberFormat func_27083_i() {
      return field_26903_b;
   }

   // $FF: synthetic method
   static DecimalFormat func_27081_j() {
      return field_26904_c;
   }

}
