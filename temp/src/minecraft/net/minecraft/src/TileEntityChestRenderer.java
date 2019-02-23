package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockChest;
import net.minecraft.src.ModelChest;
import net.minecraft.src.ModelLargeChest;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer {

   private ModelChest field_35377_b = new ModelChest();
   private ModelChest field_35378_c = new ModelLargeChest();


   public void func_35376_a(TileEntityChest p_35376_1_, double p_35376_2_, double p_35376_4_, double p_35376_6_, float p_35376_8_) {
      int var9;
      if(p_35376_1_.field_824_e == null) {
         var9 = 0;
      } else {
         Block var10 = p_35376_1_.func_478_g();
         var9 = p_35376_1_.func_479_f();
         if(var10 != null && var9 == 0) {
            ((BlockChest)var10).func_35306_h(p_35376_1_.field_824_e, p_35376_1_.field_823_f, p_35376_1_.field_822_g, p_35376_1_.field_821_h);
            var9 = p_35376_1_.func_479_f();
         }

         p_35376_1_.func_35147_g();
      }

      if(p_35376_1_.field_35152_b == null && p_35376_1_.field_35150_d == null) {
         ModelChest var14;
         if(p_35376_1_.field_35153_c == null && p_35376_1_.field_35151_e == null) {
            var14 = this.field_35377_b;
            this.func_6507_a("/item/chest.png");
         } else {
            var14 = this.field_35378_c;
            this.func_6507_a("/item/largechest.png");
         }

         GL11.glPushMatrix();
         GL11.glEnable('\u803a');
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glTranslatef((float)p_35376_2_, (float)p_35376_4_ + 1.0F, (float)p_35376_6_ + 1.0F);
         GL11.glScalef(1.0F, -1.0F, -1.0F);
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         short var11 = 0;
         if(var9 == 2) {
            var11 = 180;
         }

         if(var9 == 3) {
            var11 = 0;
         }

         if(var9 == 4) {
            var11 = 90;
         }

         if(var9 == 5) {
            var11 = -90;
         }

         if(var9 == 2 && p_35376_1_.field_35153_c != null) {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
         }

         if(var9 == 5 && p_35376_1_.field_35151_e != null) {
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
         }

         GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         float var12 = p_35376_1_.field_35149_g + (p_35376_1_.field_35148_f - p_35376_1_.field_35149_g) * p_35376_8_;
         float var13;
         if(p_35376_1_.field_35152_b != null) {
            var13 = p_35376_1_.field_35152_b.field_35149_g + (p_35376_1_.field_35152_b.field_35148_f - p_35376_1_.field_35152_b.field_35149_g) * p_35376_8_;
            if(var13 > var12) {
               var12 = var13;
            }
         }

         if(p_35376_1_.field_35150_d != null) {
            var13 = p_35376_1_.field_35150_d.field_35149_g + (p_35376_1_.field_35150_d.field_35148_f - p_35376_1_.field_35150_d.field_35149_g) * p_35376_8_;
            if(var13 > var12) {
               var12 = var13;
            }
         }

         var12 = 1.0F - var12;
         var12 = 1.0F - var12 * var12 * var12;
         var14.field_35405_a.field_1407_d = -(var12 * 3.1415927F / 2.0F);
         var14.func_35402_a();
         GL11.glDisable('\u803a');
         GL11.glPopMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_35376_a((TileEntityChest)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
