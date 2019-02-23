package net.minecraft.src;

import net.minecraft.src.ContainerWorkbench;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class GuiCrafting extends GuiContainer {

   public GuiCrafting(InventoryPlayer p_i67_1_, World p_i67_2_, int p_i67_3_, int p_i67_4_, int p_i67_5_) {
      super(new ContainerWorkbench(p_i67_1_, p_i67_2_, p_i67_3_, p_i67_4_, p_i67_5_));
   }

   public void func_6449_h() {
      super.func_6449_h();
   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.crafting"), 28, 6, 4210752);
      this.field_6451_g.func_873_b(StatCollector.func_25200_a("container.inventory"), 8, this.field_974_h - 96 + 2, 4210752);
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/crafting.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = (this.field_951_c - this.field_971_a) / 2;
      int var6 = (this.field_950_d - this.field_974_h) / 2;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_974_h);
   }
}
