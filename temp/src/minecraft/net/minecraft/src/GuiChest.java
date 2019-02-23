package net.minecraft.src;

import net.minecraft.src.ContainerChest;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiChest extends GuiContainer {

   private IInventory field_982_j;
   private IInventory field_981_l;
   private int field_980_m = 0;


   public GuiChest(IInventory p_i721_1_, IInventory p_i721_2_) {
      super(new ContainerChest(p_i721_1_, p_i721_2_));
      this.field_982_j = p_i721_1_;
      this.field_981_l = p_i721_2_;
      this.field_948_f = false;
      short var3 = 222;
      int var4 = var3 - 108;
      this.field_980_m = p_i721_2_.func_469_c() / 9;
      this.field_974_h = var4 + this.field_980_m * 18;
   }

   protected void func_587_j() {
      this.field_6451_g.func_873_b(StatCollector.func_25200_a(this.field_981_l.func_471_d()), 8, 6, 4210752);
      this.field_6451_g.func_873_b(StatCollector.func_25200_a(this.field_982_j.func_471_d()), 8, this.field_974_h - 96 + 2, 4210752);
   }

   protected void func_589_a(float p_589_1_, int p_589_2_, int p_589_3_) {
      int var4 = this.field_945_b.field_6315_n.func_1070_a("/gui/container.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var4);
      int var5 = (this.field_951_c - this.field_971_a) / 2;
      int var6 = (this.field_950_d - this.field_974_h) / 2;
      this.func_550_b(var5, var6, 0, 0, this.field_971_a, this.field_980_m * 18 + 17);
      this.func_550_b(var5, var6 + this.field_980_m * 18 + 17, 0, 126, this.field_971_a, 96);
   }
}
