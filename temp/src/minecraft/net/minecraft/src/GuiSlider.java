package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiSlider extends GuiButton {

   public float field_944_i = 1.0F;
   public boolean field_943_j = false;
   private EnumOptions field_942_l = null;


   public GuiSlider(int p_i173_1_, int p_i173_2_, int p_i173_3_, EnumOptions p_i173_4_, String p_i173_5_, float p_i173_6_) {
      super(p_i173_1_, p_i173_2_, p_i173_3_, 150, 20, p_i173_5_);
      this.field_942_l = p_i173_4_;
      this.field_944_i = p_i173_6_;
   }

   protected int func_558_a(boolean p_558_1_) {
      return 0;
   }

   protected void func_560_b(Minecraft p_560_1_, int p_560_2_, int p_560_3_) {
      if(this.field_936_h) {
         if(this.field_943_j) {
            this.field_944_i = (float)(p_560_2_ - (this.field_941_c + 4)) / (float)(this.field_52008_a - 8);
            if(this.field_944_i < 0.0F) {
               this.field_944_i = 0.0F;
            }

            if(this.field_944_i > 1.0F) {
               this.field_944_i = 1.0F;
            }

            p_560_1_.field_6304_y.func_1048_a(this.field_942_l, this.field_944_i);
            this.field_939_e = p_560_1_.field_6304_y.func_1043_a(this.field_942_l);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_550_b(this.field_941_c + (int)(this.field_944_i * (float)(this.field_52008_a - 8)), this.field_940_d, 0, 66, 4, 20);
         this.func_550_b(this.field_941_c + (int)(this.field_944_i * (float)(this.field_52008_a - 8)) + 4, this.field_940_d, 196, 66, 4, 20);
      }
   }

   public boolean func_562_c(Minecraft p_562_1_, int p_562_2_, int p_562_3_) {
      if(super.func_562_c(p_562_1_, p_562_2_, p_562_3_)) {
         this.field_944_i = (float)(p_562_2_ - (this.field_941_c + 4)) / (float)(this.field_52008_a - 8);
         if(this.field_944_i < 0.0F) {
            this.field_944_i = 0.0F;
         }

         if(this.field_944_i > 1.0F) {
            this.field_944_i = 1.0F;
         }

         p_562_1_.field_6304_y.func_1048_a(this.field_942_l, this.field_944_i);
         this.field_939_e = p_562_1_.field_6304_y.func_1043_a(this.field_942_l);
         this.field_943_j = true;
         return true;
      } else {
         return false;
      }
   }

   public void func_559_a(int p_559_1_, int p_559_2_) {
      this.field_943_j = false;
   }
}
