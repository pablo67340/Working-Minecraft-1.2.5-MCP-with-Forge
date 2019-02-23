package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFX;
import net.minecraft.src.MathHelper;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class EntityPickupFX extends EntityFX {

   private Entity field_675_a;
   private Entity field_679_o;
   private int field_678_p = 0;
   private int field_677_q = 0;
   private float field_676_r;


   public EntityPickupFX(World p_i665_1_, Entity p_i665_2_, Entity p_i665_3_, float p_i665_4_) {
      super(p_i665_1_, p_i665_2_.field_611_ak, p_i665_2_.field_610_al, p_i665_2_.field_609_am, p_i665_2_.field_608_an, p_i665_2_.field_607_ao, p_i665_2_.field_606_ap);
      this.field_675_a = p_i665_2_;
      this.field_679_o = p_i665_3_;
      this.field_677_q = 3;
      this.field_676_r = p_i665_4_;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_678_p + p_406_2_) / (float)this.field_677_q;
      var8 *= var8;
      double var9 = this.field_675_a.field_611_ak;
      double var11 = this.field_675_a.field_610_al;
      double var13 = this.field_675_a.field_609_am;
      double var15 = this.field_679_o.field_638_aI + (this.field_679_o.field_611_ak - this.field_679_o.field_638_aI) * (double)p_406_2_;
      double var17 = this.field_679_o.field_637_aJ + (this.field_679_o.field_610_al - this.field_679_o.field_637_aJ) * (double)p_406_2_ + (double)this.field_676_r;
      double var19 = this.field_679_o.field_636_aK + (this.field_679_o.field_609_am - this.field_679_o.field_636_aK) * (double)p_406_2_;
      double var21 = var9 + (var15 - var9) * (double)var8;
      double var23 = var11 + (var17 - var11) * (double)var8;
      double var25 = var13 + (var19 - var13) * (double)var8;
      int var27 = MathHelper.func_1108_b(var21);
      int var28 = MathHelper.func_1108_b(var23 + (double)(this.field_9292_aO / 2.0F));
      int var29 = MathHelper.func_1108_b(var25);
      int var30 = this.func_35115_a(p_406_2_);
      int var31 = var30 % 65536;
      int var32 = var30 / 65536;
      OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var31 / 1.0F, (float)var32 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var21 -= field_660_l;
      var23 -= field_659_m;
      var25 -= field_658_n;
      RenderManager.field_1233_a.func_853_a(this.field_675_a, (double)((float)var21), (double)((float)var23), (double)((float)var25), this.field_675_a.field_605_aq, p_406_2_);
   }

   public void func_370_e_() {
      ++this.field_678_p;
      if(this.field_678_p == this.field_677_q) {
         this.func_395_F();
      }

   }

   public int func_404_c() {
      return 3;
   }
}
