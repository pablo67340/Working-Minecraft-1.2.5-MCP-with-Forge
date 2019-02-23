package net.minecraft.src;

import net.minecraft.src.ContainerBrewingStand;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import net.minecraft.src.TileEntityBrewingStand;
import org.lwjgl.opengl.GL11;

public class GuiBrewingStand extends GuiContainer {

   private TileEntityBrewingStand field_40217_h;


   public GuiBrewingStand(InventoryPlayer p_i354_1_, TileEntityBrewingStand p_i354_2_) {
      super(new ContainerBrewingStand(p_i354_1_, p_i354_2_));
      this.field_40217_h = p_i354_2_;
   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.brewing"), 56, 6, 4210752);
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.inventory"), 8, this.field_974_h - 96 + 2, 4210752);
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/alchemy.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = (this.field_951_c - this.field_971_a) / 2;
      int var6 = (this.field_950_d - this.field_974_h) / 2;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
      int var7 = this.field_40217_h.func_40053_g();
      if(var7 > 0) {
         int var8 = (int)(28.0F * (1.0F - (float)var7 / 400.0F));
         if(var8 > 0) {
            this.func_550_b(var5 + 97, var6 + 16, 176, 0, 9, var8);
         }

         int var9 = var7 / 2 % 7;
         switch(var9) {
         case 0:
            var8 = 29;
            break;
         case 1:
            var8 = 24;
            break;
         case 2:
            var8 = 20;
            break;
         case 3:
            var8 = 16;
            break;
         case 4:
            var8 = 11;
            break;
         case 5:
            var8 = 6;
            break;
         case 6:
            var8 = 0;
         }

         if(var8 > 0) {
            this.func_550_b(var5 + 65, var6 + 14 + 29 - var8, 185, 29 - var8, 12, var8);
         }
      }

   }
}
