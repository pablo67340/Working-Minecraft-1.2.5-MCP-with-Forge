package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockPistonBase;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston extends TileEntitySpecialRenderer {

   private RenderBlocks field_31071_b;


   public void func_31070_a(TileEntityPiston p_31070_1_, double p_31070_2_, double p_31070_4_, double p_31070_6_, float p_31070_8_) {
      Block var9 = Block.field_345_n[p_31070_1_.func_31016_a()];
      if(var9 != null && p_31070_1_.func_31008_a(p_31070_8_) < 1.0F) {
         Tessellator var10 = Tessellator.field_1512_a;
         this.func_6507_a("/terrain.png");
         RenderHelper.func_1159_a();
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         if(Minecraft.func_22005_v()) {
            GL11.glShadeModel(7425);
         } else {
            GL11.glShadeModel(7424);
         }

         var10.func_977_b();
         var10.func_984_b((double)((float)p_31070_2_ - (float)p_31070_1_.field_823_f + p_31070_1_.func_31017_b(p_31070_8_)), (double)((float)p_31070_4_ - (float)p_31070_1_.field_822_g + p_31070_1_.func_31014_c(p_31070_8_)), (double)((float)p_31070_6_ - (float)p_31070_1_.field_821_h + p_31070_1_.func_31013_d(p_31070_8_)));
         var10.func_979_a(1, 1, 1);
         if(var9 == Block.field_9269_aa && p_31070_1_.func_31008_a(p_31070_8_) < 0.5F) {
            this.field_31071_b.func_31079_a(var9, p_31070_1_.field_823_f, p_31070_1_.field_822_g, p_31070_1_.field_821_h, false);
         } else if(p_31070_1_.func_31012_k() && !p_31070_1_.func_31015_b()) {
            Block.field_9269_aa.func_31052_a_(((BlockPistonBase)var9).func_31040_i());
            this.field_31071_b.func_31079_a(Block.field_9269_aa, p_31070_1_.field_823_f, p_31070_1_.field_822_g, p_31070_1_.field_821_h, p_31070_1_.func_31008_a(p_31070_8_) < 0.5F);
            Block.field_9269_aa.func_31051_a();
            var10.func_984_b((double)((float)p_31070_2_ - (float)p_31070_1_.field_823_f), (double)((float)p_31070_4_ - (float)p_31070_1_.field_822_g), (double)((float)p_31070_6_ - (float)p_31070_1_.field_821_h));
            this.field_31071_b.func_31078_d(var9, p_31070_1_.field_823_f, p_31070_1_.field_822_g, p_31070_1_.field_821_h);
         } else {
            this.field_31071_b.func_31075_a(var9, p_31070_1_.field_823_f, p_31070_1_.field_822_g, p_31070_1_.field_821_h);
         }

         var10.func_984_b(0.0D, 0.0D, 0.0D);
         var10.func_982_a();
         RenderHelper.func_1158_b();
      }

   }

   public void func_31069_a(World p_31069_1_) {
      this.field_31071_b = new RenderBlocks(p_31069_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_31070_a((TileEntityPiston)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
