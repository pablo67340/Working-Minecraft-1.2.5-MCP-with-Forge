package net.minecraft.src;

import net.minecraft.src.GuiMultiplayer;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.ServerNBTStorage;
import net.minecraft.src.Tessellator;
import net.minecraft.src.ThreadPollServers;
import org.lwjgl.opengl.GL11;

class GuiSlotServer extends GuiSlot {

   // $FF: synthetic field
   final GuiMultiplayer field_35410_a;


   public GuiSlotServer(GuiMultiplayer p_i543_1_) {
      super(p_i543_1_.field_945_b, p_i543_1_.field_951_c, p_i543_1_.field_950_d, 32, p_i543_1_.field_950_d - 64, 36);
      this.field_35410_a = p_i543_1_;
   }

   protected int func_22249_a() {
      return GuiMultiplayer.func_35320_a(this.field_35410_a).size();
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {
      GuiMultiplayer.func_35326_a(this.field_35410_a, p_22247_1_);
      boolean var3 = GuiMultiplayer.func_35333_b(this.field_35410_a) >= 0 && GuiMultiplayer.func_35333_b(this.field_35410_a) < this.func_22249_a();
      GuiMultiplayer.func_35329_c(this.field_35410_a).field_937_g = var3;
      GuiMultiplayer.func_35334_d(this.field_35410_a).field_937_g = var3;
      GuiMultiplayer.func_35339_e(this.field_35410_a).field_937_g = var3;
      if(p_22247_2_ && var3) {
         GuiMultiplayer.func_35332_b(this.field_35410_a, p_22247_1_);
      }

   }

   protected boolean func_22246_a(int p_22246_1_) {
      return p_22246_1_ == GuiMultiplayer.func_35333_b(this.field_35410_a);
   }

   protected int func_22245_b() {
      return GuiMultiplayer.func_35320_a(this.field_35410_a).size() * 36;
   }

   protected void func_22248_c() {
      this.field_35410_a.func_578_i();
   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      ServerNBTStorage var6 = (ServerNBTStorage)GuiMultiplayer.func_35320_a(this.field_35410_a).get(p_22242_1_);
      synchronized(GuiMultiplayer.func_35321_g()) {
         if(GuiMultiplayer.func_35338_m() < 5 && !var6.field_35790_f) {
            var6.field_35790_f = true;
            var6.field_35792_e = -2L;
            var6.field_35791_d = "";
            var6.field_35794_c = "";
            GuiMultiplayer.func_35331_n();
            (new ThreadPollServers(this, var6)).start();
         }
      }

      this.field_35410_a.func_547_b(this.field_35410_a.field_6451_g, var6.field_35795_a, p_22242_2_ + 2, p_22242_3_ + 1, 16777215);
      this.field_35410_a.func_547_b(this.field_35410_a.field_6451_g, var6.field_35791_d, p_22242_2_ + 2, p_22242_3_ + 12, 8421504);
      this.field_35410_a.func_547_b(this.field_35410_a.field_6451_g, var6.field_35794_c, p_22242_2_ + 215 - this.field_35410_a.field_6451_g.func_871_a(var6.field_35794_c), p_22242_3_ + 12, 8421504);
      this.field_35410_a.func_547_b(this.field_35410_a.field_6451_g, var6.field_35793_b, p_22242_2_ + 2, p_22242_3_ + 12 + 11, 3158064);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_35410_a.field_945_b.field_6315_n.func_1076_b(this.field_35410_a.field_945_b.field_6315_n.func_1070_a("/gui/icons.png"));
      String var9 = "";
      byte var7;
      int var8;
      if(var6.field_35790_f && var6.field_35792_e != -2L) {
         var7 = 0;
         boolean var12 = false;
         if(var6.field_35792_e < 0L) {
            var8 = 5;
         } else if(var6.field_35792_e < 150L) {
            var8 = 0;
         } else if(var6.field_35792_e < 300L) {
            var8 = 1;
         } else if(var6.field_35792_e < 600L) {
            var8 = 2;
         } else if(var6.field_35792_e < 1000L) {
            var8 = 3;
         } else {
            var8 = 4;
         }

         if(var6.field_35792_e < 0L) {
            var9 = "(no connection)";
         } else {
            var9 = var6.field_35792_e + "ms";
         }
      } else {
         var7 = 1;
         var8 = (int)(System.currentTimeMillis() / 100L + (long)(p_22242_1_ * 2) & 7L);
         if(var8 > 4) {
            var8 = 8 - var8;
         }

         var9 = "Polling..";
      }

      this.field_35410_a.func_550_b(p_22242_2_ + 205, p_22242_3_, 0 + var7 * 10, 176 + var8 * 8, 10, 8);
      byte var10 = 4;
      if(this.field_35409_k >= p_22242_2_ + 205 - var10 && this.field_35408_l >= p_22242_3_ - var10 && this.field_35409_k <= p_22242_2_ + 205 + 10 + var10 && this.field_35408_l <= p_22242_3_ + 8 + var10) {
         GuiMultiplayer.func_35327_a(this.field_35410_a, var9);
      }

   }
}
