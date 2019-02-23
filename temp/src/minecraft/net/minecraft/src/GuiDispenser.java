package net.minecraft.src;

import net.minecraft.src.ContainerDispenser;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import net.minecraft.src.TileEntityDispenser;
import org.lwjgl.opengl.GL11;

public class GuiDispenser extends GuiContainer {

   public GuiDispenser(InventoryPlayer p_i314_1_, TileEntityDispenser p_i314_2_) {
      super(new ContainerDispenser(p_i314_1_, p_i314_2_));
   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.dispenser"), 60, 6, 4210752);
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.inventory"), 8, this.field_974_h - 96 + 2, 4210752);
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/trap.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = (this.field_951_c - this.field_971_a) / 2;
      int var6 = (this.field_950_d - this.field_974_h) / 2;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
   }
}
