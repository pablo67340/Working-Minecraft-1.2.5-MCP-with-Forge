package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.ContainerEnchantment;
import net.minecraft.src.EnchantmentNameParts;
import net.minecraft.src.Entity;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBook;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiEnchantment extends GuiContainer {

   private static ModelBook field_40220_w = new ModelBook();
   private Random field_40230_x = new Random();
   private ContainerEnchantment field_40228_y;
   public int field_40227_h;
   public float field_40229_i;
   public float field_40225_j;
   public float field_40226_k;
   public float field_40223_l;
   public float field_40224_m;
   public float field_40221_n;
   ItemStack field_40222_o;


   public GuiEnchantment(InventoryPlayer p_i594_1_, World p_i594_2_, int p_i594_3_, int p_i594_4_, int p_i594_5_) {
      super(new ContainerEnchantment(p_i594_1_, p_i594_2_, p_i594_3_, p_i594_4_, p_i594_5_));
      this.field_40228_y = (ContainerEnchantment)this.field_973_i;
   }

   public void func_6449_h() {
      super.func_6449_h();
   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.enchant"), 12, 6, 4210752);
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.inventory"), 8, this.field_974_h - 96 + 2, 4210752);
   }

   public void func_570_g() {
      super.func_570_g();
      this.func_40219_x_();
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      int var4 = (this.field_951_c - this.field_971_a) / 2;
      int var5 = (this.field_950_d - this.field_974_h) / 2;

      for(int var6 = 0; var6 < 3; ++var6) {
         int var7 = p_565_1_ - (var4 + 60);
         int var8 = p_565_2_ - (var5 + 14 + 19 * var6);
         if(var7 >= 0 && var8 >= 0 && var7 < 108 && var8 < 19 && this.field_40228_y.func_40233_a(this.field_945_b.field_6322_g, var6)) {
            this.field_945_b.field_6327_b.func_40593_a(this.field_40228_y.field_1618_c, var6);
         }
      }

   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/enchant.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = (this.field_951_c - this.field_971_a) / 2;
      int var6 = (this.field_950_d - this.field_974_h) / 2;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
      GL11.glPushMatrix();
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      ScaledResolution var7 = new ScaledResolution(this.field_945_b.field_6304_y, this.field_945_b.field_6326_c, this.field_945_b.field_6325_d);
      GL11.glViewport((var7.func_903_a() - 320) / 2 * var7.field_1368_a, (var7.func_902_b() - 240) / 2 * var7.field_1368_a, 320 * var7.field_1368_a, 240 * var7.field_1368_a);
      GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
      GLU.gluPerspective(90.0F, 1.3333334F, 9.0F, 80.0F);
      float var8 = 1.0F;
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      RenderHelper.func_1158_b();
      GL11.glTranslatef(0.0F, 3.3F, -16.0F);
      GL11.glScalef(var8, var8, var8);
      float var9 = 5.0F;
      GL11.glScalef(var9, var9, var9);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(this.field_945_b.field_6315_n.func_1070_a("/item/book.png"));
      GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
      float var10 = this.field_40221_n + (this.field_40224_m - this.field_40221_n) * p_589_1_;
      GL11.glTranslatef((1.0F - var10) * 0.2F, (1.0F - var10) * 0.1F, (1.0F - var10) * 0.25F);
      GL11.glRotatef(-(1.0F - var10) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      float var11 = this.field_40225_j + (this.field_40229_i - this.field_40225_j) * p_589_1_ + 0.25F;
      float var12 = this.field_40225_j + (this.field_40229_i - this.field_40225_j) * p_589_1_ + 0.75F;
      var11 = (var11 - (float)MathHelper.func_40346_b((double)var11)) * 1.6F - 0.3F;
      var12 = (var12 - (float)MathHelper.func_40346_b((double)var12)) * 1.6F - 0.3F;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      if(var11 > 1.0F) {
         var11 = 1.0F;
      }

      if(var12 > 1.0F) {
         var12 = 1.0F;
      }

      GL11.glEnable('\u803a');
      field_40220_w.func_864_b((Entity)null, 0.0F, var11, var12, var10, 0.0F, 0.0625F);
      GL11.glDisable('\u803a');
      RenderHelper.func_1159_a();
      GL11.glMatrixMode(5889);
      GL11.glViewport(0, 0, this.field_945_b.field_6326_c, this.field_945_b.field_6325_d);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      RenderHelper.func_1159_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      EnchantmentNameParts.field_40253_a.func_40250_a(this.field_40228_y.field_40234_b);

      for(int var13 = 0; var13 < 3; ++var13) {
         String var14 = EnchantmentNameParts.field_40253_a.func_40249_a();
         this.field_923_k = 0.0F;
         this.field_945_b.field_6315_n.func_1076_b(var4);
         int var15 = this.field_40228_y.field_40235_c[var13];
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         if(var15 == 0) {
            this.func_550_b(var5 + 60, var6 + 14 + 19 * var13, 0, 185, 108, 19);
         } else {
            String var16 = "" + var15;
            FontRenderer var17 = this.field_945_b.field_40007_r;
            int var18 = 6839882;
            if(this.field_945_b.field_6322_g.field_35210_aY < var15 && !this.field_945_b.field_6322_g.field_35212_aW.field_35756_d) {
               this.func_550_b(var5 + 60, var6 + 14 + 19 * var13, 0, 185, 108, 19);
               var17.func_27278_a(var14, var5 + 62, var6 + 16 + 19 * var13, 104, (var18 & 16711422) >> 1);
               var17 = this.field_945_b.field_6314_o;
               var18 = 4226832;
               var17.func_50103_a(var16, var5 + 62 + 104 - var17.func_871_a(var16), var6 + 16 + 19 * var13 + 7, var18);
            } else {
               int var19 = p_589_2_ - (var5 + 60);
               int var20 = p_589_3_ - (var6 + 14 + 19 * var13);
               if(var19 >= 0 && var20 >= 0 && var19 < 108 && var20 < 19) {
                  this.func_550_b(var5 + 60, var6 + 14 + 19 * var13, 0, 204, 108, 19);
                  var18 = 16777088;
               } else {
                  this.func_550_b(var5 + 60, var6 + 14 + 19 * var13, 0, 166, 108, 19);
               }

               var17.func_27278_a(var14, var5 + 62, var6 + 16 + 19 * var13, 104, var18);
               var17 = this.field_945_b.field_6314_o;
               var18 = 8453920;
               var17.func_50103_a(var16, var5 + 62 + 104 - var17.func_871_a(var16), var6 + 16 + 19 * var13 + 7, var18);
            }
         }
      }

   }

   public void func_40219_x_() {
      ItemStack var1 = this.field_973_i.func_20118_a(0).func_777_b();
      if(!ItemStack.func_20107_a(var1, this.field_40222_o)) {
         this.field_40222_o = var1;

         do {
            this.field_40226_k += (float)(this.field_40230_x.nextInt(4) - this.field_40230_x.nextInt(4));
         } while(this.field_40229_i <= this.field_40226_k + 1.0F && this.field_40229_i >= this.field_40226_k - 1.0F);
      }

      ++this.field_40227_h;
      this.field_40225_j = this.field_40229_i;
      this.field_40221_n = this.field_40224_m;
      boolean var2 = false;

      for(int var3 = 0; var3 < 3; ++var3) {
         if(this.field_40228_y.field_40235_c[var3] != 0) {
            var2 = true;
         }
      }

      if(var2) {
         this.field_40224_m += 0.2F;
      } else {
         this.field_40224_m -= 0.2F;
      }

      if(this.field_40224_m < 0.0F) {
         this.field_40224_m = 0.0F;
      }

      if(this.field_40224_m > 1.0F) {
         this.field_40224_m = 1.0F;
      }

      float var5 = (this.field_40226_k - this.field_40229_i) * 0.4F;
      float var4 = 0.2F;
      if(var5 < -var4) {
         var5 = -var4;
      }

      if(var5 > var4) {
         var5 = var4;
      }

      this.field_40223_l += (var5 - this.field_40223_l) * 0.9F;
      this.field_40229_i += this.field_40223_l;
   }

}
