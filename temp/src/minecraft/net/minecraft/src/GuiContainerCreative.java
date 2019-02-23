package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.ContainerCreative;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiAchievements;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiStats;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.StatCollector;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiContainerCreative extends GuiContainer {

   private static InventoryBasic field_35311_f = new InventoryBasic("tmp", 72);
   private float field_35312_g = 0.0F;
   private boolean field_35313_h = false;
   private boolean field_35314_i;


   public GuiContainerCreative(EntityPlayer p_i599_1_) {
      super(new ContainerCreative(p_i599_1_));
      p_i599_1_.field_20068_h = this.field_973_i;
      this.field_948_f = true;
      p_i599_1_.func_25058_a(AchievementList.field_25195_b, 1);
      this.field_974_h = 208;
   }

   public void func_570_g() {
      if(!this.field_945_b.field_6327_b.func_35640_h()) {
         this.field_945_b.func_6272_a(new GuiInventory(this.field_945_b.field_6322_g));
      }

   }

   protected void func_35309_a(Slot p_35309_1_, int p_35309_2_, int p_35309_3_, boolean p_35309_4_) {
      InventoryPlayer var5;
      ItemStack var6;
      if(p_35309_1_ != null) {
         if(p_35309_1_.field_1118_b == field_35311_f) {
            var5 = this.field_945_b.field_6322_g.field_778_b;
            var6 = var5.func_20075_i();
            ItemStack var7 = p_35309_1_.func_777_b();
            if(var6 != null && var7 != null && var6.field_1617_c == var7.field_1617_c) {
               if(p_35309_3_ == 0) {
                  if(p_35309_4_) {
                     var6.field_1615_a = var6.func_1089_c();
                  } else if(var6.field_1615_a < var6.func_1089_c()) {
                     ++var6.field_1615_a;
                  }
               } else if(var6.field_1615_a <= 1) {
                  var5.func_20076_b((ItemStack)null);
               } else {
                  --var6.field_1615_a;
               }
            } else if(var6 != null) {
               var5.func_20076_b((ItemStack)null);
            } else if(var7 == null) {
               var5.func_20076_b((ItemStack)null);
            } else if(var6 == null || var6.field_1617_c != var7.field_1617_c) {
               var5.func_20076_b(ItemStack.func_30010_b(var7));
               var6 = var5.func_20075_i();
               if(p_35309_4_) {
                  var6.field_1615_a = var6.func_1089_c();
               }
            }
         } else {
            this.field_973_i.func_27280_a(p_35309_1_.field_20007_a, p_35309_3_, p_35309_4_, this.field_945_b.field_6322_g);
            ItemStack var8 = this.field_973_i.func_20118_a(p_35309_1_.field_20007_a).func_777_b();
            this.field_945_b.field_6327_b.func_35637_a(var8, p_35309_1_.field_20007_a - this.field_973_i.field_20122_e.size() + 9 + 36);
         }
      } else {
         var5 = this.field_945_b.field_6322_g.field_778_b;
         if(var5.func_20075_i() != null) {
            if(p_35309_3_ == 0) {
               this.field_945_b.field_6322_g.func_48153_a(var5.func_20075_i());
               this.field_945_b.field_6327_b.func_35639_a(var5.func_20075_i());
               var5.func_20076_b((ItemStack)null);
            }

            if(p_35309_3_ == 1) {
               var6 = var5.func_20075_i().func_1085_a(1);
               this.field_945_b.field_6322_g.func_48153_a(var6);
               this.field_945_b.field_6327_b.func_35639_a(var6);
               if(var5.func_20075_i().field_1615_a == 0) {
                  var5.func_20076_b((ItemStack)null);
               }
            }
         }
      }

   }

   public void func_6448_a() {
      if(!this.field_945_b.field_6327_b.func_35640_h()) {
         this.field_945_b.func_6272_a(new GuiInventory(this.field_945_b.field_6322_g));
      } else {
         super.func_6448_a();
         this.field_949_e.clear();
      }

   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.creative"), 8, 6, 4210752);
   }

   public void func_566_e() {
      super.func_566_e();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0) {
         int var2 = ((ContainerCreative)this.field_973_i).field_35375_a.size() / 8 - 8 + 1;
         if(var1 > 0) {
            var1 = 1;
         }

         if(var1 < 0) {
            var1 = -1;
         }

         this.field_35312_g = (float)((double)this.field_35312_g - (double)var1 / (double)var2);
         if(this.field_35312_g < 0.0F) {
            this.field_35312_g = 0.0F;
         }

         if(this.field_35312_g > 1.0F) {
            this.field_35312_g = 1.0F;
         }

         ((ContainerCreative)this.field_973_i).func_35374_a(this.field_35312_g);
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      boolean var4 = Mouse.isButtonDown(0);
      int var5 = this.field_40216_e;
      int var6 = this.field_40215_f;
      int var7 = var5 + 155;
      int var8 = var6 + 17;
      int var9 = var7 + 14;
      int var10 = var8 + 160 + 2;
      if(!this.field_35314_i && var4 && p_571_1_ >= var7 && p_571_2_ >= var8 && p_571_1_ < var9 && p_571_2_ < var10) {
         this.field_35313_h = true;
      }

      if(!var4) {
         this.field_35313_h = false;
      }

      this.field_35314_i = var4;
      if(this.field_35313_h) {
         this.field_35312_g = (float)(p_571_2_ - (var8 + 8)) / ((float)(var10 - var8) - 16.0F);
         if(this.field_35312_g < 0.0F) {
            this.field_35312_g = 0.0F;
         }

         if(this.field_35312_g > 1.0F) {
            this.field_35312_g = 1.0F;
         }

         ((ContainerCreative)this.field_973_i).func_35374_a(this.field_35312_g);
      }

      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/allitems.png");
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = this.field_40216_e;
      int var6 = this.field_40215_f;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
      int var7 = var5 + 155;
      int var8 = var6 + 17;
      int var9 = var8 + 160 + 2;
      this.func_550_b(var5 + 154, var6 + 17 + (int)((float)(var9 - var8 - 17) * this.field_35312_g), 0, 208, 16, 16);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_945_b.func_6272_a(new GuiAchievements(this.field_945_b.field_25001_G));
      }

      if(p_572_1_.field_938_f == 1) {
         this.field_945_b.func_6272_a(new GuiStats(this, this.field_945_b.field_25001_G));
      }

   }

   // $FF: synthetic method
   static InventoryBasic func_35310_g() {
      return field_35311_f;
   }

}
