package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityCaveSpider;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EntityEgg;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.EntityEnderEye;
import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityMooshroom;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySilverfish;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntitySnowman;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GameSettings;
import net.minecraft.src.Item;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.ModelChicken;
import net.minecraft.src.ModelCow;
import net.minecraft.src.ModelOcelot;
import net.minecraft.src.ModelPig;
import net.minecraft.src.ModelSheep1;
import net.minecraft.src.ModelSheep2;
import net.minecraft.src.ModelSkeleton;
import net.minecraft.src.ModelSlime;
import net.minecraft.src.ModelSquid;
import net.minecraft.src.ModelWolf;
import net.minecraft.src.ModelZombie;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderArrow;
import net.minecraft.src.RenderBiped;
import net.minecraft.src.RenderBlaze;
import net.minecraft.src.RenderBoat;
import net.minecraft.src.RenderChicken;
import net.minecraft.src.RenderCow;
import net.minecraft.src.RenderCreeper;
import net.minecraft.src.RenderDragon;
import net.minecraft.src.RenderEnderCrystal;
import net.minecraft.src.RenderEnderman;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderEntity;
import net.minecraft.src.RenderFallingSand;
import net.minecraft.src.RenderFireball;
import net.minecraft.src.RenderFish;
import net.minecraft.src.RenderGhast;
import net.minecraft.src.RenderGiantZombie;
import net.minecraft.src.RenderIronGolem;
import net.minecraft.src.RenderItem;
import net.minecraft.src.RenderLightningBolt;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.RenderMagmaCube;
import net.minecraft.src.RenderMinecart;
import net.minecraft.src.RenderMooshroom;
import net.minecraft.src.RenderOcelot;
import net.minecraft.src.RenderPainting;
import net.minecraft.src.RenderPig;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.RenderSheep;
import net.minecraft.src.RenderSilverfish;
import net.minecraft.src.RenderSlime;
import net.minecraft.src.RenderSnowMan;
import net.minecraft.src.RenderSnowball;
import net.minecraft.src.RenderSpider;
import net.minecraft.src.RenderSquid;
import net.minecraft.src.RenderTNTPrimed;
import net.minecraft.src.RenderVillager;
import net.minecraft.src.RenderWolf;
import net.minecraft.src.RenderXPOrb;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderManager {

   private Map field_6501_o = new HashMap();
   public static RenderManager field_1233_a = new RenderManager();
   private FontRenderer field_1218_p;
   public static double field_1232_b;
   public static double field_1231_c;
   public static double field_1230_d;
   public RenderEngine field_1229_e;
   public ItemRenderer field_4236_f;
   public World field_1227_g;
   public EntityLiving field_22188_h;
   public float field_1225_i;
   public float field_1224_j;
   public GameSettings field_1223_k;
   public double field_1222_l;
   public double field_1221_m;
   public double field_1220_n;


   private RenderManager() {
      this.field_6501_o.put(EntitySpider.class, new RenderSpider());
      this.field_6501_o.put(EntityCaveSpider.class, new RenderSpider());
      this.field_6501_o.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
      this.field_6501_o.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
      this.field_6501_o.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
      this.field_6501_o.put(EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
      this.field_6501_o.put(EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
      this.field_6501_o.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
      this.field_6501_o.put(EntityOcelot.class, new RenderOcelot(new ModelOcelot(), 0.4F));
      this.field_6501_o.put(EntitySilverfish.class, new RenderSilverfish());
      this.field_6501_o.put(EntityCreeper.class, new RenderCreeper());
      this.field_6501_o.put(EntityEnderman.class, new RenderEnderman());
      this.field_6501_o.put(EntitySnowman.class, new RenderSnowMan());
      this.field_6501_o.put(EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
      this.field_6501_o.put(EntityBlaze.class, new RenderBlaze());
      this.field_6501_o.put(EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
      this.field_6501_o.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
      this.field_6501_o.put(EntityMagmaCube.class, new RenderMagmaCube());
      this.field_6501_o.put(EntityPlayer.class, new RenderPlayer());
      this.field_6501_o.put(EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6.0F));
      this.field_6501_o.put(EntityGhast.class, new RenderGhast());
      this.field_6501_o.put(EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
      this.field_6501_o.put(EntityVillager.class, new RenderVillager());
      this.field_6501_o.put(EntityIronGolem.class, new RenderIronGolem());
      this.field_6501_o.put(EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
      this.field_6501_o.put(EntityDragon.class, new RenderDragon());
      this.field_6501_o.put(EntityEnderCrystal.class, new RenderEnderCrystal());
      this.field_6501_o.put(Entity.class, new RenderEntity());
      this.field_6501_o.put(EntityPainting.class, new RenderPainting());
      this.field_6501_o.put(EntityArrow.class, new RenderArrow());
      this.field_6501_o.put(EntitySnowball.class, new RenderSnowball(Item.field_308_aB.func_27009_a(0)));
      this.field_6501_o.put(EntityEnderPearl.class, new RenderSnowball(Item.field_35416_bo.func_27009_a(0)));
      this.field_6501_o.put(EntityEnderEye.class, new RenderSnowball(Item.field_40420_bA.func_27009_a(0)));
      this.field_6501_o.put(EntityEgg.class, new RenderSnowball(Item.field_296_aN.func_27009_a(0)));
      this.field_6501_o.put(EntityPotion.class, new RenderSnowball(154));
      this.field_6501_o.put(EntityExpBottle.class, new RenderSnowball(Item.field_48438_bD.func_27009_a(0)));
      this.field_6501_o.put(EntityFireball.class, new RenderFireball(2.0F));
      this.field_6501_o.put(EntitySmallFireball.class, new RenderFireball(0.5F));
      this.field_6501_o.put(EntityItem.class, new RenderItem());
      this.field_6501_o.put(EntityXPOrb.class, new RenderXPOrb());
      this.field_6501_o.put(EntityTNTPrimed.class, new RenderTNTPrimed());
      this.field_6501_o.put(EntityFallingSand.class, new RenderFallingSand());
      this.field_6501_o.put(EntityMinecart.class, new RenderMinecart());
      this.field_6501_o.put(EntityBoat.class, new RenderBoat());
      this.field_6501_o.put(EntityFishHook.class, new RenderFish());
      this.field_6501_o.put(EntityLightningBolt.class, new RenderLightningBolt());
      Iterator var1 = this.field_6501_o.values().iterator();

      while(var1.hasNext()) {
         Render var2 = (Render)var1.next();
         var2.func_4009_a(this);
      }

   }

   public Render func_4117_a(Class p_4117_1_) {
      Render var2 = (Render)this.field_6501_o.get(p_4117_1_);
      if(var2 == null && p_4117_1_ != Entity.class) {
         var2 = this.func_4117_a(p_4117_1_.getSuperclass());
         this.field_6501_o.put(p_4117_1_, var2);
      }

      return var2;
   }

   public Render func_855_a(Entity p_855_1_) {
      return this.func_4117_a(p_855_1_.getClass());
   }

   public void func_22187_a(World p_22187_1_, RenderEngine p_22187_2_, FontRenderer p_22187_3_, EntityLiving p_22187_4_, GameSettings p_22187_5_, float p_22187_6_) {
      this.field_1227_g = p_22187_1_;
      this.field_1229_e = p_22187_2_;
      this.field_1223_k = p_22187_5_;
      this.field_22188_h = p_22187_4_;
      this.field_1218_p = p_22187_3_;
      if(p_22187_4_.func_22051_K()) {
         int var7 = p_22187_1_.func_600_a(MathHelper.func_1108_b(p_22187_4_.field_611_ak), MathHelper.func_1108_b(p_22187_4_.field_610_al), MathHelper.func_1108_b(p_22187_4_.field_609_am));
         if(var7 == Block.field_9262_S.field_376_bc) {
            int var8 = p_22187_1_.func_602_e(MathHelper.func_1108_b(p_22187_4_.field_611_ak), MathHelper.func_1108_b(p_22187_4_.field_610_al), MathHelper.func_1108_b(p_22187_4_.field_609_am));
            int var9 = var8 & 3;
            this.field_1225_i = (float)(var9 * 90 + 180);
            this.field_1224_j = 0.0F;
         }
      } else {
         this.field_1225_i = p_22187_4_.field_603_as + (p_22187_4_.field_605_aq - p_22187_4_.field_603_as) * p_22187_6_;
         this.field_1224_j = p_22187_4_.field_602_at + (p_22187_4_.field_604_ar - p_22187_4_.field_602_at) * p_22187_6_;
      }

      if(p_22187_5_.field_1560_x == 2) {
         this.field_1225_i += 180.0F;
      }

      this.field_1222_l = p_22187_4_.field_638_aI + (p_22187_4_.field_611_ak - p_22187_4_.field_638_aI) * (double)p_22187_6_;
      this.field_1221_m = p_22187_4_.field_637_aJ + (p_22187_4_.field_610_al - p_22187_4_.field_637_aJ) * (double)p_22187_6_;
      this.field_1220_n = p_22187_4_.field_636_aK + (p_22187_4_.field_609_am - p_22187_4_.field_636_aK) * (double)p_22187_6_;
   }

   public void func_854_a(Entity p_854_1_, float p_854_2_) {
      double var3 = p_854_1_.field_638_aI + (p_854_1_.field_611_ak - p_854_1_.field_638_aI) * (double)p_854_2_;
      double var5 = p_854_1_.field_637_aJ + (p_854_1_.field_610_al - p_854_1_.field_637_aJ) * (double)p_854_2_;
      double var7 = p_854_1_.field_636_aK + (p_854_1_.field_609_am - p_854_1_.field_636_aK) * (double)p_854_2_;
      float var9 = p_854_1_.field_603_as + (p_854_1_.field_605_aq - p_854_1_.field_603_as) * p_854_2_;
      int var10 = p_854_1_.func_35115_a(p_854_2_);
      if(p_854_1_.func_21062_U()) {
         var10 = 15728880;
      }

      int var11 = var10 % 65536;
      int var12 = var10 / 65536;
      OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var11 / 1.0F, (float)var12 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_853_a(p_854_1_, var3 - field_1232_b, var5 - field_1231_c, var7 - field_1230_d, var9, p_854_2_);
   }

   public void func_853_a(Entity p_853_1_, double p_853_2_, double p_853_4_, double p_853_6_, float p_853_8_, float p_853_9_) {
      Render var10 = this.func_855_a(p_853_1_);
      if(var10 != null) {
         var10.func_147_a(p_853_1_, p_853_2_, p_853_4_, p_853_6_, p_853_8_, p_853_9_);
         var10.func_141_b(p_853_1_, p_853_2_, p_853_4_, p_853_6_, p_853_8_, p_853_9_);
      }

   }

   public void func_852_a(World p_852_1_) {
      this.field_1227_g = p_852_1_;
   }

   public double func_851_a(double p_851_1_, double p_851_3_, double p_851_5_) {
      double var7 = p_851_1_ - this.field_1222_l;
      double var9 = p_851_3_ - this.field_1221_m;
      double var11 = p_851_5_ - this.field_1220_n;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public FontRenderer func_6500_a() {
      return this.field_1218_p;
   }

}
