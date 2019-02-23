package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.StringTranslate;

public class GuiDownloadTerrain extends GuiScreen {

   private NetClientHandler field_983_a;
   private int field_984_h = 0;


   public GuiDownloadTerrain(NetClientHandler p_i311_1_) {
      this.field_983_a = p_i311_1_;
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   public void func_6448_a() {
      this.field_949_e.clear();
   }

   public void func_570_g() {
      ++this.field_984_h;
      if(this.field_984_h % 20 == 0) {
         this.field_983_a.func_847_a(new Packet0KeepAlive());
      }

      if(this.field_983_a != null) {
         this.field_983_a.func_848_a();
      }

   }

   protected void func_572_a(GuiButton p_572_1_) {}

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_579_b(0);
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("multiplayer.downloadingTerrain"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
