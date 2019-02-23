package net.minecraft.src;

import java.util.List;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.GuiTexturePacks;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.opengl.GL11;

class GuiTexturePackSlot extends GuiSlot {

   // $FF: synthetic field
   final GuiTexturePacks field_22265_a;


   public GuiTexturePackSlot(GuiTexturePacks p_i267_1_) {
      super(GuiTexturePacks.func_22124_a(p_i267_1_), p_i267_1_.field_951_c, p_i267_1_.field_950_d, 32, p_i267_1_.field_950_d - 55 + 4, 36);
      this.field_22265_a = p_i267_1_;
   }

   protected int func_22249_a() {
      List var1 = GuiTexturePacks.func_22126_b(this.field_22265_a).field_6298_C.func_6530_b();
      return var1.size();
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {
      List var3 = GuiTexturePacks.func_22119_c(this.field_22265_a).field_6298_C.func_6530_b();

      try {
         GuiTexturePacks.func_22122_d(this.field_22265_a).field_6298_C.func_6531_a((TexturePackBase)var3.get(p_22247_1_));
         GuiTexturePacks.func_22117_e(this.field_22265_a).field_6315_n.func_1065_b();
      } catch (Exception var5) {
         GuiTexturePacks.func_35307_f(this.field_22265_a).field_6298_C.func_6531_a((TexturePackBase)var3.get(0));
         GuiTexturePacks.func_35308_g(this.field_22265_a).field_6315_n.func_1065_b();
      }

   }

   protected boolean func_22246_a(int p_22246_1_) {
      List var2 = GuiTexturePacks.func_22118_f(this.field_22265_a).field_6298_C.func_6530_b();
      return GuiTexturePacks.func_22116_g(this.field_22265_a).field_6298_C.field_6534_a == var2.get(p_22246_1_);
   }

   protected int func_22245_b() {
      return this.func_22249_a() * 36;
   }

   protected void func_22248_c() {
      this.field_22265_a.func_578_i();
   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      TexturePackBase var6 = (TexturePackBase)GuiTexturePacks.func_22121_h(this.field_22265_a).field_6298_C.func_6530_b().get(p_22242_1_);
      var6.func_6483_c(GuiTexturePacks.func_22123_i(this.field_22265_a));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      p_22242_5_.func_977_b();
      p_22242_5_.func_990_b(16777215);
      p_22242_5_.func_983_a((double)p_22242_2_, (double)(p_22242_3_ + p_22242_4_), 0.0D, 0.0D, 1.0D);
      p_22242_5_.func_983_a((double)(p_22242_2_ + 32), (double)(p_22242_3_ + p_22242_4_), 0.0D, 1.0D, 1.0D);
      p_22242_5_.func_983_a((double)(p_22242_2_ + 32), (double)p_22242_3_, 0.0D, 1.0D, 0.0D);
      p_22242_5_.func_983_a((double)p_22242_2_, (double)p_22242_3_, 0.0D, 0.0D, 0.0D);
      p_22242_5_.func_982_a();
      this.field_22265_a.func_547_b(GuiTexturePacks.func_22127_j(this.field_22265_a), var6.field_6487_a, p_22242_2_ + 32 + 2, p_22242_3_ + 1, 16777215);
      this.field_22265_a.func_547_b(GuiTexturePacks.func_22120_k(this.field_22265_a), var6.field_6486_b, p_22242_2_ + 32 + 2, p_22242_3_ + 12, 8421504);
      this.field_22265_a.func_547_b(GuiTexturePacks.func_22125_l(this.field_22265_a), var6.field_6489_c, p_22242_2_ + 32 + 2, p_22242_3_ + 12 + 10, 8421504);
   }
}
