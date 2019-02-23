package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBook;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class RenderEnchantmentTable extends TileEntitySpecialRenderer {

   private ModelBook field_40450_a = new ModelBook();


   public void func_40449_a(TileEntityEnchantmentTable p_40449_1_, double p_40449_2_, double p_40449_4_, double p_40449_6_, float p_40449_8_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_40449_2_ + 0.5F, (float)p_40449_4_ + 0.75F, (float)p_40449_6_ + 0.5F);
      float var9 = (float)p_40449_1_.field_40068_a + p_40449_8_;
      GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_1106_a(var9 * 0.1F) * 0.01F, 0.0F);

      float var10;
      for(var10 = p_40449_1_.field_40069_h - p_40449_1_.field_40067_p; var10 >= 3.1415927F; var10 -= 6.2831855F) {
         ;
      }

      while(var10 < -3.1415927F) {
         var10 += 6.2831855F;
      }

      float var11 = p_40449_1_.field_40067_p + var10 * p_40449_8_;
      GL11.glRotatef(-var11 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
      this.func_6507_a("/item/book.png");
      float var12 = p_40449_1_.field_40065_c + (p_40449_1_.field_40063_b - p_40449_1_.field_40065_c) * p_40449_8_ + 0.25F;
      float var13 = p_40449_1_.field_40065_c + (p_40449_1_.field_40063_b - p_40449_1_.field_40065_c) * p_40449_8_ + 0.75F;
      var12 = (var12 - (float)MathHelper.func_40346_b((double)var12)) * 1.6F - 0.3F;
      var13 = (var13 - (float)MathHelper.func_40346_b((double)var13)) * 1.6F - 0.3F;
      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      if(var13 < 0.0F) {
         var13 = 0.0F;
      }

      if(var12 > 1.0F) {
         var12 = 1.0F;
      }

      if(var13 > 1.0F) {
         var13 = 1.0F;
      }

      float var14 = p_40449_1_.field_40060_g + (p_40449_1_.field_40059_f - p_40449_1_.field_40060_g) * p_40449_8_;
      this.field_40450_a.func_864_b((Entity)null, var9, var12, var13, var14, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_40449_a((TileEntityEnchantmentTable)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
