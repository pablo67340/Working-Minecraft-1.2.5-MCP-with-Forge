package net.minecraft.src;

import java.util.Collection;
import java.util.Iterator;
import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiAchievements;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiContainerCreative;
import net.minecraft.src.GuiStats;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiInventory extends GuiContainer {

   private float field_976_l;
   private float field_975_m;


   public GuiInventory(EntityPlayer p_i144_1_) {
      super(p_i144_1_.field_20069_g);
      this.field_948_f = true;
      p_i144_1_.func_25058_a(AchievementList.field_25195_b, 1);
   }

   public void func_570_g() {
      if(this.field_945_b.field_6327_b.func_35640_h()) {
         this.field_945_b.func_6272_a(new GuiContainerCreative(this.field_945_b.field_6322_g));
      }

   }

   public void func_6448_a() {
      this.field_949_e.clear();
      if(this.field_945_b.field_6327_b.func_35640_h()) {
         this.field_945_b.func_6272_a(new GuiContainerCreative(this.field_945_b.field_6322_g));
      } else {
         super.func_6448_a();
         if(!this.field_945_b.field_6322_g.func_40118_aO().isEmpty()) {
            this.field_40216_e = 160 + (this.field_951_c - this.field_971_a - 200) / 2;
         }
      }

   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.crafting"), 86, 16, 4210752);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
      this.field_976_l = (float)p_571_1_;
      this.field_975_m = (float)p_571_2_;
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/inventory.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = this.field_40216_e;
      int var6 = this.field_40215_f;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
      this.func_40218_g();
      GL11.glEnable('\u803a');
      GL11.glEnable(2903);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(var5 + 51), (float)(var6 + 75), 50.0F);
      float var7 = 30.0F;
      GL11.glScalef(-var7, var7, var7);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      float var8 = this.field_945_b.field_6322_g.field_735_n;
      float var9 = this.field_945_b.field_6322_g.field_605_aq;
      float var10 = this.field_945_b.field_6322_g.field_604_ar;
      float var11 = (float)(var5 + 51) - this.field_976_l;
      float var12 = (float)(var6 + 75 - 50) - this.field_975_m;
      GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_1158_b();
      GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-((float)Math.atan((double)(var12 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      this.field_945_b.field_6322_g.field_735_n = (float)Math.atan((double)(var11 / 40.0F)) * 20.0F;
      this.field_945_b.field_6322_g.field_605_aq = (float)Math.atan((double)(var11 / 40.0F)) * 40.0F;
      this.field_945_b.field_6322_g.field_604_ar = -((float)Math.atan((double)(var12 / 40.0F))) * 20.0F;
      this.field_945_b.field_6322_g.field_46015_bf = this.field_945_b.field_6322_g.field_605_aq;
      GL11.glTranslatef(0.0F, this.field_945_b.field_6322_g.field_9292_aO, 0.0F);
      RenderManager.field_1233_a.field_1225_i = 180.0F;
      RenderManager.field_1233_a.func_853_a(this.field_945_b.field_6322_g, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      this.field_945_b.field_6322_g.field_735_n = var8;
      this.field_945_b.field_6322_g.field_605_aq = var9;
      this.field_945_b.field_6322_g.field_604_ar = var10;
      GL11.glPopMatrix();
      RenderHelper.func_1159_a();
      GL11.glDisable('\u803a');
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_945_b.func_6272_a(new GuiAchievements(this.field_945_b.field_25001_G));
      }

      if(p_572_1_.field_938_f == 1) {
         this.field_945_b.func_6272_a(new GuiStats(this, this.field_945_b.field_25001_G));
      }

   }

   private void func_40218_g() {
      int var1 = this.field_40216_e - 124;
      int var2 = this.field_40215_f;
      int var3 = this.field_945_b.field_6315_n.func_1070_a("/gui/inventory.png");
      Collection var4 = this.field_945_b.field_6322_g.func_40118_aO();
      if(!var4.isEmpty()) {
         int var5 = 33;
         if(var4.size() > 5) {
            var5 = 132 / (var4.size() - 1);
         }

         for(Iterator var6 = this.field_945_b.field_6322_g.func_40118_aO().iterator(); var6.hasNext(); var2 += var5) {
            PotionEffect var7 = (PotionEffect)var6.next();
            Potion var8 = Potion.field_35678_a[var7.func_35799_a()];
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_945_b.field_6315_n.func_1076_b(var3);
            this.func_550_b(var1, var2, 0, this.field_974_h, 140, 32);
            if(var8.func_40617_d()) {
               int var9 = var8.func_40611_e();
               this.func_550_b(var1 + 6, var2 + 7, 0 + var9 % 8 * 18, this.field_974_h + 32 + var9 / 8 * 18, 18, 18);
            }

            String var11 = StatCollector.func_25200_a(var8.func_40623_c());
            if(var7.func_35801_c() == 1) {
               var11 = var11 + " II";
            } else if(var7.func_35801_c() == 2) {
               var11 = var11 + " III";
            } else if(var7.func_35801_c() == 3) {
               var11 = var11 + " IV";
            }

            this.field_6451_g.func_50103_a(var11, var1 + 10 + 18, var2 + 6, 16777215);
            String var10 = Potion.func_40620_a(var7);
            this.field_6451_g.func_50103_a(var10, var1 + 10 + 18, var2 + 6 + 10, 8355711);
         }

      }
   }
}
