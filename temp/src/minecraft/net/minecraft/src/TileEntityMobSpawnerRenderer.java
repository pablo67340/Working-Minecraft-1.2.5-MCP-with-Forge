package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.RenderManager;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer {

   private Map field_1412_b = new HashMap();


   public void func_931_a(TileEntityMobSpawner p_931_1_, double p_931_2_, double p_931_4_, double p_931_6_, float p_931_8_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_931_2_ + 0.5F, (float)p_931_4_, (float)p_931_6_ + 0.5F);
      Entity var9 = (Entity)this.field_1412_b.get(p_931_1_.func_21099_a());
      if(var9 == null) {
         var9 = EntityList.func_1079_a(p_931_1_.func_21099_a(), (World)null);
         this.field_1412_b.put(p_931_1_.func_21099_a(), var9);
      }

      if(var9 != null) {
         var9.func_398_a(p_931_1_.field_824_e);
         float var10 = 0.4375F;
         GL11.glTranslatef(0.0F, 0.4F, 0.0F);
         GL11.glRotatef((float)(p_931_1_.field_830_d + (p_931_1_.field_831_c - p_931_1_.field_830_d) * (double)p_931_8_) * 10.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.4F, 0.0F);
         GL11.glScalef(var10, var10, var10);
         var9.func_365_c(p_931_2_, p_931_4_, p_931_6_, 0.0F, 0.0F);
         RenderManager.field_1233_a.func_853_a(var9, 0.0D, 0.0D, 0.0D, 0.0F, p_931_8_);
      }

      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_931_a((TileEntityMobSpawner)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
