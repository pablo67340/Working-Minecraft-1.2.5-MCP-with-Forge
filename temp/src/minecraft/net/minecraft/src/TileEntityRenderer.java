package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderEnchantmentTable;
import net.minecraft.src.RenderEndPortal;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityChestRenderer;
import net.minecraft.src.TileEntityEnchantmentTable;
import net.minecraft.src.TileEntityEndPortal;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntityMobSpawnerRenderer;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.TileEntityRendererPiston;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.TileEntitySignRenderer;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderer {

   private Map field_6517_m = new HashMap();
   public static TileEntityRenderer field_1554_a = new TileEntityRenderer();
   private FontRenderer field_1541_n;
   public static double field_1553_b;
   public static double field_1552_c;
   public static double field_1551_d;
   public RenderEngine field_1550_e;
   public World field_1549_f;
   public EntityLiving field_22270_g;
   public float field_22269_h;
   public float field_22268_i;
   public double field_1545_j;
   public double field_1544_k;
   public double field_1543_l;


   private TileEntityRenderer() {
      this.field_6517_m.put(TileEntitySign.class, new TileEntitySignRenderer());
      this.field_6517_m.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
      this.field_6517_m.put(TileEntityPiston.class, new TileEntityRendererPiston());
      this.field_6517_m.put(TileEntityChest.class, new TileEntityChestRenderer());
      this.field_6517_m.put(TileEntityEnchantmentTable.class, new RenderEnchantmentTable());
      this.field_6517_m.put(TileEntityEndPortal.class, new RenderEndPortal());
      Iterator var1 = this.field_6517_m.values().iterator();

      while(var1.hasNext()) {
         TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)var1.next();
         var2.func_928_a(this);
      }

   }

   public TileEntitySpecialRenderer func_4144_a(Class p_4144_1_) {
      TileEntitySpecialRenderer var2 = (TileEntitySpecialRenderer)this.field_6517_m.get(p_4144_1_);
      if(var2 == null && p_4144_1_ != TileEntity.class) {
         var2 = this.func_4144_a(p_4144_1_.getSuperclass());
         this.field_6517_m.put(p_4144_1_, var2);
      }

      return var2;
   }

   public boolean func_1028_a(TileEntity p_1028_1_) {
      return this.func_1031_b(p_1028_1_) != null;
   }

   public TileEntitySpecialRenderer func_1031_b(TileEntity p_1031_1_) {
      return p_1031_1_ == null?null:this.func_4144_a(p_1031_1_.getClass());
   }

   public void func_22267_a(World p_22267_1_, RenderEngine p_22267_2_, FontRenderer p_22267_3_, EntityLiving p_22267_4_, float p_22267_5_) {
      if(this.field_1549_f != p_22267_1_) {
         this.func_31072_a(p_22267_1_);
      }

      this.field_1550_e = p_22267_2_;
      this.field_22270_g = p_22267_4_;
      this.field_1541_n = p_22267_3_;
      this.field_22269_h = p_22267_4_.field_603_as + (p_22267_4_.field_605_aq - p_22267_4_.field_603_as) * p_22267_5_;
      this.field_22268_i = p_22267_4_.field_602_at + (p_22267_4_.field_604_ar - p_22267_4_.field_602_at) * p_22267_5_;
      this.field_1545_j = p_22267_4_.field_638_aI + (p_22267_4_.field_611_ak - p_22267_4_.field_638_aI) * (double)p_22267_5_;
      this.field_1544_k = p_22267_4_.field_637_aJ + (p_22267_4_.field_610_al - p_22267_4_.field_637_aJ) * (double)p_22267_5_;
      this.field_1543_l = p_22267_4_.field_636_aK + (p_22267_4_.field_609_am - p_22267_4_.field_636_aK) * (double)p_22267_5_;
   }

   public void func_40742_a() {}

   public void func_1030_a(TileEntity p_1030_1_, float p_1030_2_) {
      if(p_1030_1_.func_480_a(this.field_1545_j, this.field_1544_k, this.field_1543_l) < 4096.0D) {
         int var3 = this.field_1549_f.func_35451_b(p_1030_1_.field_823_f, p_1030_1_.field_822_g, p_1030_1_.field_821_h, 0);
         int var4 = var3 % 65536;
         int var5 = var3 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var4 / 1.0F, (float)var5 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_1032_a(p_1030_1_, (double)p_1030_1_.field_823_f - field_1553_b, (double)p_1030_1_.field_822_g - field_1552_c, (double)p_1030_1_.field_821_h - field_1551_d, p_1030_2_);
      }

   }

   public void func_1032_a(TileEntity p_1032_1_, double p_1032_2_, double p_1032_4_, double p_1032_6_, float p_1032_8_) {
      TileEntitySpecialRenderer var9 = this.func_1031_b(p_1032_1_);
      if(var9 != null) {
         var9.func_930_a(p_1032_1_, p_1032_2_, p_1032_4_, p_1032_6_, p_1032_8_);
      }

   }

   public void func_31072_a(World p_31072_1_) {
      this.field_1549_f = p_31072_1_;
      Iterator var2 = this.field_6517_m.values().iterator();

      while(var2.hasNext()) {
         TileEntitySpecialRenderer var3 = (TileEntitySpecialRenderer)var2.next();
         if(var3 != null) {
            var3.func_31069_a(p_31072_1_);
         }
      }

   }

   public FontRenderer func_6516_a() {
      return this.field_1541_n;
   }

}
