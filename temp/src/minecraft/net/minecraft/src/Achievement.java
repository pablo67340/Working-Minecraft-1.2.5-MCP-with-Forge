package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.IStatStringFormat;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatCollector;

public class Achievement extends StatBase {

   public final int field_25075_a;
   public final int field_25074_b;
   public final Achievement field_25076_c;
   private final String field_27096_l;
   private IStatStringFormat field_27095_m;
   public final ItemStack field_27097_d;
   private boolean field_27098_n;


   public Achievement(int p_i55_1_, String p_i55_2_, int p_i55_3_, int p_i55_4_, Item p_i55_5_, Achievement p_i55_6_) {
      this(p_i55_1_, p_i55_2_, p_i55_3_, p_i55_4_, new ItemStack(p_i55_5_), p_i55_6_);
   }

   public Achievement(int p_i56_1_, String p_i56_2_, int p_i56_3_, int p_i56_4_, Block p_i56_5_, Achievement p_i56_6_) {
      this(p_i56_1_, p_i56_2_, p_i56_3_, p_i56_4_, new ItemStack(p_i56_5_), p_i56_6_);
   }

   public Achievement(int p_i57_1_, String p_i57_2_, int p_i57_3_, int p_i57_4_, ItemStack p_i57_5_, Achievement p_i57_6_) {
      super(5242880 + p_i57_1_, "achievement." + p_i57_2_);
      this.field_27097_d = p_i57_5_;
      this.field_27096_l = "achievement." + p_i57_2_ + ".desc";
      this.field_25075_a = p_i57_3_;
      this.field_25074_b = p_i57_4_;
      if(p_i57_3_ < AchievementList.field_27392_a) {
         AchievementList.field_27392_a = p_i57_3_;
      }

      if(p_i57_4_ < AchievementList.field_27391_b) {
         AchievementList.field_27391_b = p_i57_4_;
      }

      if(p_i57_3_ > AchievementList.field_27390_c) {
         AchievementList.field_27390_c = p_i57_3_;
      }

      if(p_i57_4_ > AchievementList.field_27389_d) {
         AchievementList.field_27389_d = p_i57_4_;
      }

      this.field_25076_c = p_i57_6_;
   }

   public Achievement func_27089_a() {
      this.field_27088_g = true;
      return this;
   }

   public Achievement func_27094_b() {
      this.field_27098_n = true;
      return this;
   }

   public Achievement func_27091_c() {
      super.func_25068_c();
      AchievementList.field_27388_e.add(this);
      return this;
   }

   public boolean func_25067_a() {
      return true;
   }

   public String func_27090_e() {
      return this.field_27095_m != null?this.field_27095_m.func_27343_a(StatCollector.func_25200_a(this.field_27096_l)):StatCollector.func_25200_a(this.field_27096_l);
   }

   public Achievement func_27092_a(IStatStringFormat p_27092_1_) {
      this.field_27095_m = p_27092_1_;
      return this;
   }

   public boolean func_27093_f() {
      return this.field_27098_n;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public StatBase func_25068_c() {
      return this.func_27091_c();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public StatBase func_27082_h() {
      return this.func_27089_a();
   }
}
