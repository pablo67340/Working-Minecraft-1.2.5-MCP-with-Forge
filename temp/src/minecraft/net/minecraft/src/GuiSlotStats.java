package net.minecraft.src;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.GuiStats;
import net.minecraft.src.Item;
import net.minecraft.src.StatCrafting;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import org.lwjgl.input.Mouse;

abstract class GuiSlotStats extends GuiSlot {

   protected int field_27268_b;
   protected List field_27273_c;
   protected Comparator field_27272_d;
   protected int field_27271_e;
   protected int field_27270_f;
   // $FF: synthetic field
   final GuiStats field_27269_g;


   protected GuiSlotStats(GuiStats p_i347_1_) {
      super(GuiStats.func_27143_f(p_i347_1_), p_i347_1_.field_951_c, p_i347_1_.field_950_d, 32, p_i347_1_.field_950_d - 64, 20);
      this.field_27269_g = p_i347_1_;
      this.field_27268_b = -1;
      this.field_27271_e = -1;
      this.field_27270_f = 0;
      this.func_27258_a(false);
      this.func_27259_a(true, 20);
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {}

   protected boolean func_22246_a(int p_22246_1_) {
      return false;
   }

   protected void func_22248_c() {
      this.field_27269_g.func_578_i();
   }

   protected void func_27260_a(int p_27260_1_, int p_27260_2_, Tessellator p_27260_3_) {
      if(!Mouse.isButtonDown(0)) {
         this.field_27268_b = -1;
      }

      if(this.field_27268_b == 0) {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 115 - 18, p_27260_2_ + 1, 0, 0);
      } else {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 115 - 18, p_27260_2_ + 1, 0, 18);
      }

      if(this.field_27268_b == 1) {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 165 - 18, p_27260_2_ + 1, 0, 0);
      } else {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 165 - 18, p_27260_2_ + 1, 0, 18);
      }

      if(this.field_27268_b == 2) {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 215 - 18, p_27260_2_ + 1, 0, 0);
      } else {
         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + 215 - 18, p_27260_2_ + 1, 0, 18);
      }

      if(this.field_27271_e != -1) {
         short var4 = 79;
         byte var5 = 18;
         if(this.field_27271_e == 1) {
            var4 = 129;
         } else if(this.field_27271_e == 2) {
            var4 = 179;
         }

         if(this.field_27270_f == 1) {
            var5 = 36;
         }

         GuiStats.func_27128_a(this.field_27269_g, p_27260_1_ + var4, p_27260_2_ + 1, var5, 0);
      }

   }

   protected void func_27255_a(int p_27255_1_, int p_27255_2_) {
      this.field_27268_b = -1;
      if(p_27255_1_ >= 79 && p_27255_1_ < 115) {
         this.field_27268_b = 0;
      } else if(p_27255_1_ >= 129 && p_27255_1_ < 165) {
         this.field_27268_b = 1;
      } else if(p_27255_1_ >= 179 && p_27255_1_ < 215) {
         this.field_27268_b = 2;
      }

      if(this.field_27268_b >= 0) {
         this.func_27266_c(this.field_27268_b);
         GuiStats.func_27149_g(this.field_27269_g).field_6301_A.func_337_a("random.click", 1.0F, 1.0F);
      }

   }

   protected final int func_22249_a() {
      return this.field_27273_c.size();
   }

   protected final StatCrafting func_27264_b(int p_27264_1_) {
      return (StatCrafting)this.field_27273_c.get(p_27264_1_);
   }

   protected abstract String func_27263_a(int var1);

   protected void func_27265_a(StatCrafting p_27265_1_, int p_27265_2_, int p_27265_3_, boolean p_27265_4_) {
      String var5;
      if(p_27265_1_ != null) {
         var5 = p_27265_1_.func_27084_a(GuiStats.func_27142_c(this.field_27269_g).func_27184_a(p_27265_1_));
         this.field_27269_g.func_547_b(GuiStats.func_27133_h(this.field_27269_g), var5, p_27265_2_ - GuiStats.func_27137_i(this.field_27269_g).func_871_a(var5), p_27265_3_ + 5, p_27265_4_?16777215:9474192);
      } else {
         var5 = "-";
         this.field_27269_g.func_547_b(GuiStats.func_27132_j(this.field_27269_g), var5, p_27265_2_ - GuiStats.func_27134_k(this.field_27269_g).func_871_a(var5), p_27265_3_ + 5, p_27265_4_?16777215:9474192);
      }

   }

   protected void func_27257_b(int p_27257_1_, int p_27257_2_) {
      if(p_27257_2_ >= this.field_22261_d && p_27257_2_ <= this.field_22260_e) {
         int var3 = this.func_27256_c(p_27257_1_, p_27257_2_);
         int var4 = this.field_27269_g.field_951_c / 2 - 92 - 16;
         if(var3 >= 0) {
            if(p_27257_1_ < var4 + 40 || p_27257_1_ > var4 + 40 + 20) {
               return;
            }

            StatCrafting var5 = this.func_27264_b(var3);
            this.func_27267_a(var5, p_27257_1_, p_27257_2_);
         } else {
            String var9 = "";
            if(p_27257_1_ >= var4 + 115 - 18 && p_27257_1_ <= var4 + 115) {
               var9 = this.func_27263_a(0);
            } else if(p_27257_1_ >= var4 + 165 - 18 && p_27257_1_ <= var4 + 165) {
               var9 = this.func_27263_a(1);
            } else {
               if(p_27257_1_ < var4 + 215 - 18 || p_27257_1_ > var4 + 215) {
                  return;
               }

               var9 = this.func_27263_a(2);
            }

            var9 = ("" + StringTranslate.func_20162_a().func_20163_a(var9)).trim();
            if(var9.length() > 0) {
               int var6 = p_27257_1_ + 12;
               int var7 = p_27257_2_ - 12;
               int var8 = GuiStats.func_27139_l(this.field_27269_g).func_871_a(var9);
               GuiStats.func_27129_a(this.field_27269_g, var6 - 3, var7 - 3, var6 + var8 + 3, var7 + 8 + 3, -1073741824, -1073741824);
               GuiStats.func_27144_m(this.field_27269_g).func_50103_a(var9, var6, var7, -1);
            }
         }

      }
   }

   protected void func_27267_a(StatCrafting p_27267_1_, int p_27267_2_, int p_27267_3_) {
      if(p_27267_1_ != null) {
         Item var4 = Item.field_233_c[p_27267_1_.func_25072_b()];
         String var5 = ("" + StringTranslate.func_20162_a().func_20161_b(var4.func_20009_a())).trim();
         if(var5.length() > 0) {
            int var6 = p_27267_2_ + 12;
            int var7 = p_27267_3_ - 12;
            int var8 = GuiStats.func_27127_n(this.field_27269_g).func_871_a(var5);
            GuiStats.func_27135_b(this.field_27269_g, var6 - 3, var7 - 3, var6 + var8 + 3, var7 + 8 + 3, -1073741824, -1073741824);
            GuiStats.func_27131_o(this.field_27269_g).func_50103_a(var5, var6, var7, -1);
         }

      }
   }

   protected void func_27266_c(int p_27266_1_) {
      if(p_27266_1_ != this.field_27271_e) {
         this.field_27271_e = p_27266_1_;
         this.field_27270_f = -1;
      } else if(this.field_27270_f == -1) {
         this.field_27270_f = 1;
      } else {
         this.field_27271_e = -1;
         this.field_27270_f = 0;
      }

      Collections.sort(this.field_27273_c, this.field_27272_d);
   }
}
