package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AchievementList;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBed;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Container;
import net.minecraft.src.ContainerPlayer;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.FoodStats;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PlayerCapabilities;
import net.minecraft.src.Potion;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatList;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class EntityPlayer extends EntityLiving {

   public InventoryPlayer field_778_b = new InventoryPlayer(this);
   public Container field_20069_g;
   public Container field_20068_h;
   protected FoodStats field_35217_av = new FoodStats();
   protected int field_35216_aw = 0;
   public byte field_9371_f = 0;
   public int field_9370_g = 0;
   public float field_775_e;
   public float field_774_f;
   public boolean field_9369_j = false;
   public int field_9368_k = 0;
   public String field_771_i;
   public int field_4129_m;
   public String field_20067_q;
   public int field_35214_aG = 0;
   public double field_20066_r;
   public double field_20065_s;
   public double field_20064_t;
   public double field_20063_u;
   public double field_20062_v;
   public double field_20061_w;
   protected boolean field_21901_a;
   public ChunkCoordinates field_21908_b;
   private int field_21907_c;
   public float field_22063_x;
   public float field_22062_y;
   public float field_22061_z;
   private ChunkCoordinates field_24900_bi;
   private ChunkCoordinates field_26907_d;
   public int field_28024_y = 20;
   protected boolean field_28023_z = false;
   public float field_28026_A;
   public float field_28025_B;
   public PlayerCapabilities field_35212_aW = new PlayerCapabilities();
   public int field_35210_aY;
   public int field_35209_aZ;
   public float field_35211_aX;
   private ItemStack field_34907_d;
   private int field_34906_e;
   protected float field_35215_ba = 0.1F;
   protected float field_35213_bb = 0.02F;
   public EntityFishHook field_4128_n = null;


   public EntityPlayer(World p_i710_1_) {
      super(p_i710_1_);
      this.field_20069_g = new ContainerPlayer(this.field_778_b, !p_i710_1_.field_1026_y);
      this.field_20068_h = this.field_20069_g;
      this.field_9292_aO = 1.62F;
      ChunkCoordinates var2 = p_i710_1_.func_22137_s();
      this.func_365_c((double)var2.field_22395_a + 0.5D, (double)(var2.field_22394_b + 1), (double)var2.field_22396_c + 0.5D, 0.0F, 0.0F);
      this.field_9351_C = "humanoid";
      this.field_9353_B = 180.0F;
      this.field_9310_bf = 20;
      this.field_9357_z = "/mob/char.png";
   }

   public int func_40117_c() {
      return 20;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
      this.field_21064_bx.func_21124_a(17, Byte.valueOf((byte)0));
   }

   public ItemStack func_35195_X() {
      return this.field_34907_d;
   }

   public int func_35205_Y() {
      return this.field_34906_e;
   }

   public boolean func_35196_Z() {
      return this.field_34907_d != null;
   }

   public int func_35192_aa() {
      return this.func_35196_Z()?this.field_34907_d.func_35866_m() - this.field_34906_e:0;
   }

   public void func_35206_ab() {
      if(this.field_34907_d != null) {
         this.field_34907_d.func_35862_a(this.field_615_ag, this, this.field_34906_e);
      }

      this.func_35207_ac();
   }

   public void func_35207_ac() {
      this.field_34907_d = null;
      this.field_34906_e = 0;
      if(!this.field_615_ag.field_1026_y) {
         this.func_35116_d(false);
      }

   }

   public boolean func_35162_ad() {
      return this.func_35196_Z() && Item.field_233_c[this.field_34907_d.field_1617_c].func_35412_b(this.field_34907_d) == EnumAction.block;
   }

   public void func_370_e_() {
      if(this.field_34907_d != null) {
         ItemStack var1 = this.field_778_b.func_494_a();
         if(var1 != this.field_34907_d) {
            this.func_35207_ac();
         } else {
            if(this.field_34906_e <= 25 && this.field_34906_e % 4 == 0) {
               this.func_35201_a(var1, 5);
            }

            if(--this.field_34906_e == 0 && !this.field_615_ag.field_1026_y) {
               this.func_35208_ae();
            }
         }
      }

      if(this.field_35214_aG > 0) {
         --this.field_35214_aG;
      }

      if(this.func_22051_K()) {
         ++this.field_21907_c;
         if(this.field_21907_c > 100) {
            this.field_21907_c = 100;
         }

         if(!this.field_615_ag.field_1026_y) {
            if(!this.func_22057_q()) {
               this.func_22056_a(true, true, false);
            } else if(this.field_615_ag.func_624_b()) {
               this.func_22056_a(false, true, true);
            }
         }
      } else if(this.field_21907_c > 0) {
         ++this.field_21907_c;
         if(this.field_21907_c >= 110) {
            this.field_21907_c = 0;
         }
      }

      super.func_370_e_();
      if(!this.field_615_ag.field_1026_y && this.field_20068_h != null && !this.field_20068_h.func_20120_b(this)) {
         this.func_20059_m();
         this.field_20068_h = this.field_20069_g;
      }

      if(this.field_35212_aW.field_35757_b) {
         for(int var9 = 0; var9 < 8; ++var9) {
            ;
         }
      }

      if(this.func_21062_U() && this.field_35212_aW.field_35759_a) {
         this.func_40045_B();
      }

      this.field_20066_r = this.field_20063_u;
      this.field_20065_s = this.field_20062_v;
      this.field_20064_t = this.field_20061_w;
      double var10 = this.field_611_ak - this.field_20063_u;
      double var3 = this.field_610_al - this.field_20062_v;
      double var5 = this.field_609_am - this.field_20061_w;
      double var7 = 10.0D;
      if(var10 > var7) {
         this.field_20066_r = this.field_20063_u = this.field_611_ak;
      }

      if(var5 > var7) {
         this.field_20064_t = this.field_20061_w = this.field_609_am;
      }

      if(var3 > var7) {
         this.field_20065_s = this.field_20062_v = this.field_610_al;
      }

      if(var10 < -var7) {
         this.field_20066_r = this.field_20063_u = this.field_611_ak;
      }

      if(var5 < -var7) {
         this.field_20064_t = this.field_20061_w = this.field_609_am;
      }

      if(var3 < -var7) {
         this.field_20065_s = this.field_20062_v = this.field_610_al;
      }

      this.field_20063_u += var10 * 0.25D;
      this.field_20061_w += var5 * 0.25D;
      this.field_20062_v += var3 * 0.25D;
      this.func_25058_a(StatList.field_25179_j, 1);
      if(this.field_616_af == null) {
         this.field_26907_d = null;
      }

      if(!this.field_615_ag.field_1026_y) {
         this.field_35217_av.func_35768_a(this);
      }

   }

   protected void func_35201_a(ItemStack p_35201_1_, int p_35201_2_) {
      if(p_35201_1_.func_35865_n() == EnumAction.drink) {
         this.field_615_ag.func_623_a(this, "random.drink", 0.5F, this.field_615_ag.field_1037_n.nextFloat() * 0.1F + 0.9F);
      }

      if(p_35201_1_.func_35865_n() == EnumAction.eat) {
         for(int var3 = 0; var3 < p_35201_2_; ++var3) {
            Vec3D var4 = Vec3D.func_1248_b(((double)this.field_9312_bd.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
            var4.func_1258_a(-this.field_604_ar * 3.1415927F / 180.0F);
            var4.func_1249_b(-this.field_605_aq * 3.1415927F / 180.0F);
            Vec3D var5 = Vec3D.func_1248_b(((double)this.field_9312_bd.nextFloat() - 0.5D) * 0.3D, (double)(-this.field_9312_bd.nextFloat()) * 0.6D - 0.3D, 0.6D);
            var5.func_1258_a(-this.field_604_ar * 3.1415927F / 180.0F);
            var5.func_1249_b(-this.field_605_aq * 3.1415927F / 180.0F);
            var5 = var5.func_1257_c(this.field_611_ak, this.field_610_al + (double)this.func_373_s(), this.field_609_am);
            this.field_615_ag.func_694_a("iconcrack_" + p_35201_1_.func_1091_a().field_291_aS, var5.field_1776_a, var5.field_1775_b, var5.field_1779_c, var4.field_1776_a, var4.field_1775_b + 0.05D, var4.field_1779_c);
         }

         this.field_615_ag.func_623_a(this, "random.eat", 0.5F + 0.5F * (float)this.field_9312_bd.nextInt(2), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
      }

   }

   protected void func_35208_ae() {
      if(this.field_34907_d != null) {
         this.func_35201_a(this.field_34907_d, 16);
         int var1 = this.field_34907_d.field_1615_a;
         ItemStack var2 = this.field_34907_d.func_35863_b(this.field_615_ag, this);
         if(var2 != this.field_34907_d || var2 != null && var2.field_1615_a != var1) {
            this.field_778_b.field_843_a[this.field_778_b.field_847_d] = var2;
            if(var2.field_1615_a == 0) {
               this.field_778_b.field_843_a[this.field_778_b.field_847_d] = null;
            }
         }

         this.func_35207_ac();
      }

   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 9) {
         this.func_35208_ae();
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   protected boolean func_22049_v() {
      return this.func_40114_aH() <= 0 || this.func_22051_K();
   }

   protected void func_20059_m() {
      this.field_20068_h = this.field_20069_g;
   }

   public void func_20046_s() {
      this.field_20067_q = "http://s3.amazonaws.com/MinecraftCloaks/" + this.field_771_i + ".png";
      this.field_622_aY = this.field_20067_q;
   }

   public void func_350_p() {
      double var1 = this.field_611_ak;
      double var3 = this.field_610_al;
      double var5 = this.field_609_am;
      super.func_350_p();
      this.field_775_e = this.field_774_f;
      this.field_774_f = 0.0F;
      this.func_27024_i(this.field_611_ak - var1, this.field_610_al - var3, this.field_609_am - var5);
   }

   public void func_374_q() {
      this.field_9292_aO = 1.62F;
      this.func_371_a(0.6F, 1.8F);
      super.func_374_q();
      this.func_40121_k(this.func_40117_c());
      this.field_712_J = 0;
   }

   private int func_35202_aE() {
      return this.func_35160_a(Potion.field_35675_e)?6 - (1 + this.func_35167_b(Potion.field_35675_e).func_35801_c()) * 1:(this.func_35160_a(Potion.field_35672_f)?6 + (1 + this.func_35167_b(Potion.field_35672_f).func_35801_c()) * 2:6);
   }

   protected void func_418_b_() {
      int var1 = this.func_35202_aE();
      if(this.field_9369_j) {
         ++this.field_9368_k;
         if(this.field_9368_k >= var1) {
            this.field_9368_k = 0;
            this.field_9369_j = false;
         }
      } else {
         this.field_9368_k = 0;
      }

      this.field_9339_I = (float)this.field_9368_k / (float)var1;
   }

   public void func_425_j() {
      if(this.field_35216_aw > 0) {
         --this.field_35216_aw;
      }

      if(this.field_615_ag.field_1039_l == 0 && this.func_40114_aH() < this.func_40117_c() && this.field_9311_be % 20 * 12 == 0) {
         this.func_432_b(1);
      }

      this.field_778_b.func_511_b();
      this.field_775_e = this.field_774_f;
      super.func_425_j();
      this.field_35169_bv = this.field_35215_ba;
      this.field_35168_bw = this.field_35213_bb;
      if(this.func_35117_Q()) {
         this.field_35169_bv = (float)((double)this.field_35169_bv + (double)this.field_35215_ba * 0.3D);
         this.field_35168_bw = (float)((double)this.field_35168_bw + (double)this.field_35213_bb * 0.3D);
      }

      float var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
      float var2 = (float)Math.atan(-this.field_607_ao * 0.20000000298023224D) * 15.0F;
      if(var1 > 0.1F) {
         var1 = 0.1F;
      }

      if(!this.field_9298_aH || this.func_40114_aH() <= 0) {
         var1 = 0.0F;
      }

      if(this.field_9298_aH || this.func_40114_aH() <= 0) {
         var2 = 0.0F;
      }

      this.field_774_f += (var1 - this.field_774_f) * 0.4F;
      this.field_9328_R += (var2 - this.field_9328_R) * 0.8F;
      if(this.func_40114_aH() > 0) {
         List var3 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(1.0D, 0.0D, 1.0D));
         if(var3 != null) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               Entity var5 = (Entity)var3.get(var4);
               if(!var5.field_646_aA) {
                  this.func_451_h(var5);
               }
            }
         }
      }

   }

   private void func_451_h(Entity p_451_1_) {
      p_451_1_.func_6378_b(this);
   }

   public int func_6417_t() {
      return this.field_9370_g;
   }

   public void func_419_b(DamageSource p_419_1_) {
      super.func_419_b(p_419_1_);
      this.func_371_a(0.2F, 0.2F);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_607_ao = 0.10000000149011612D;
      if(this.field_771_i.equals("Notch")) {
         this.func_48151_a(new ItemStack(Item.field_228_h, 1), true);
      }

      this.field_778_b.func_503_g();
      if(p_419_1_ != null) {
         this.field_608_an = (double)(-MathHelper.func_1114_b((this.field_9331_N + this.field_605_aq) * 3.1415927F / 180.0F) * 0.1F);
         this.field_606_ap = (double)(-MathHelper.func_1106_a((this.field_9331_N + this.field_605_aq) * 3.1415927F / 180.0F) * 0.1F);
      } else {
         this.field_608_an = this.field_606_ap = 0.0D;
      }

      this.field_9292_aO = 0.1F;
      this.func_25058_a(StatList.field_25163_u, 1);
   }

   public void func_364_b(Entity p_364_1_, int p_364_2_) {
      this.field_9370_g += p_364_2_;
      if(p_364_1_ instanceof EntityPlayer) {
         this.func_25058_a(StatList.field_25161_w, 1);
      } else {
         this.func_25058_a(StatList.field_25162_v, 1);
      }

   }

   protected int func_40116_f(int p_40116_1_) {
      int var2 = EnchantmentHelper.func_40632_a(this.field_778_b);
      return var2 > 0 && this.field_9312_bd.nextInt(var2 + 1) > 0?p_40116_1_:super.func_40116_f(p_40116_1_);
   }

   public EntityItem func_48152_as() {
      return this.func_48151_a(this.field_778_b.func_473_a(this.field_778_b.field_847_d, 1), false);
   }

   public EntityItem func_48153_a(ItemStack p_48153_1_) {
      return this.func_48151_a(p_48153_1_, false);
   }

   public EntityItem func_48151_a(ItemStack p_48151_1_, boolean p_48151_2_) {
      if(p_48151_1_ == null) {
         return null;
      } else {
         EntityItem var3 = new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al - 0.30000001192092896D + (double)this.func_373_s(), this.field_609_am, p_48151_1_);
         var3.field_805_c = 40;
         float var4 = 0.1F;
         float var5;
         if(p_48151_2_) {
            var5 = this.field_9312_bd.nextFloat() * 0.5F;
            float var6 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
            var3.field_608_an = (double)(-MathHelper.func_1106_a(var6) * var5);
            var3.field_606_ap = (double)(MathHelper.func_1114_b(var6) * var5);
            var3.field_607_ao = 0.20000000298023224D;
         } else {
            var4 = 0.3F;
            var3.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var4);
            var3.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var4);
            var3.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F) * var4 + 0.1F);
            var4 = 0.02F;
            var5 = this.field_9312_bd.nextFloat() * 3.1415927F * 2.0F;
            var4 *= this.field_9312_bd.nextFloat();
            var3.field_608_an += Math.cos((double)var5) * (double)var4;
            var3.field_607_ao += (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.1F);
            var3.field_606_ap += Math.sin((double)var5) * (double)var4;
         }

         this.func_446_a(var3);
         this.func_25058_a(StatList.field_25168_r, 1);
         return var3;
      }
   }

   protected void func_446_a(EntityItem p_446_1_) {
      this.field_615_ag.func_674_a(p_446_1_);
   }

   public float func_450_a(Block p_450_1_) {
      float var2 = this.field_778_b.func_508_a(p_450_1_);
      float var3 = var2;
      int var4 = EnchantmentHelper.func_40642_b(this.field_778_b);
      if(var4 > 0 && this.field_778_b.func_509_b(p_450_1_)) {
         var3 = var2 + (float)(var4 * var4 + 1);
      }

      if(this.func_35160_a(Potion.field_35675_e)) {
         var3 *= 1.0F + (float)(this.func_35167_b(Potion.field_35675_e).func_35801_c() + 1) * 0.2F;
      }

      if(this.func_35160_a(Potion.field_35672_f)) {
         var3 *= 1.0F - (float)(this.func_35167_b(Potion.field_35672_f).func_35801_c() + 1) * 0.2F;
      }

      if(this.func_393_a(Material.field_1332_f) && !EnchantmentHelper.func_40633_g(this.field_778_b)) {
         var3 /= 5.0F;
      }

      if(!this.field_9298_aH) {
         var3 /= 5.0F;
      }

      return var3;
   }

   public boolean func_454_b(Block p_454_1_) {
      return this.field_778_b.func_509_b(p_454_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      NBTTagList var2 = p_357_1_.func_753_l("Inventory");
      this.field_778_b.func_513_b(var2);
      this.field_4129_m = p_357_1_.func_756_e("Dimension");
      this.field_21901_a = p_357_1_.func_760_m("Sleeping");
      this.field_21907_c = p_357_1_.func_745_d("SleepTimer");
      this.field_35211_aX = p_357_1_.func_752_g("XpP");
      this.field_35210_aY = p_357_1_.func_756_e("XpLevel");
      this.field_35209_aZ = p_357_1_.func_756_e("XpTotal");
      if(this.field_21901_a) {
         this.field_21908_b = new ChunkCoordinates(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
         this.func_22056_a(true, true, false);
      }

      if(p_357_1_.func_751_b("SpawnX") && p_357_1_.func_751_b("SpawnY") && p_357_1_.func_751_b("SpawnZ")) {
         this.field_24900_bi = new ChunkCoordinates(p_357_1_.func_756_e("SpawnX"), p_357_1_.func_756_e("SpawnY"), p_357_1_.func_756_e("SpawnZ"));
      }

      this.field_35217_av.func_35766_a(p_357_1_);
      this.field_35212_aW.func_40600_b(p_357_1_);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_762_a("Inventory", this.field_778_b.func_493_a(new NBTTagList()));
      p_352_1_.func_758_a("Dimension", this.field_4129_m);
      p_352_1_.func_748_a("Sleeping", this.field_21901_a);
      p_352_1_.func_749_a("SleepTimer", (short)this.field_21907_c);
      p_352_1_.func_744_a("XpP", this.field_35211_aX);
      p_352_1_.func_758_a("XpLevel", this.field_35210_aY);
      p_352_1_.func_758_a("XpTotal", this.field_35209_aZ);
      if(this.field_24900_bi != null) {
         p_352_1_.func_758_a("SpawnX", this.field_24900_bi.field_22395_a);
         p_352_1_.func_758_a("SpawnY", this.field_24900_bi.field_22394_b);
         p_352_1_.func_758_a("SpawnZ", this.field_24900_bi.field_22396_c);
      }

      this.field_35217_av.func_35763_b(p_352_1_);
      this.field_35212_aW.func_40601_a(p_352_1_);
   }

   public void func_452_a(IInventory p_452_1_) {}

   public void func_40181_c(int p_40181_1_, int p_40181_2_, int p_40181_3_) {}

   public void func_445_l(int p_445_1_, int p_445_2_, int p_445_3_) {}

   public void func_443_a_(Entity p_443_1_, int p_443_2_) {}

   public float func_373_s() {
      return 0.12F;
   }

   protected void func_22058_C() {
      this.field_9292_aO = 1.62F;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(this.field_35212_aW.field_35759_a && !p_396_1_.func_35529_d()) {
         return false;
      } else {
         this.field_9344_ag = 0;
         if(this.func_40114_aH() <= 0) {
            return false;
         } else {
            if(this.func_22051_K() && !this.field_615_ag.field_1026_y) {
               this.func_22056_a(true, true, false);
            }

            Entity var3 = p_396_1_.func_35532_a();
            if(var3 instanceof EntityMob || var3 instanceof EntityArrow) {
               if(this.field_615_ag.field_1039_l == 0) {
                  p_396_2_ = 0;
               }

               if(this.field_615_ag.field_1039_l == 1) {
                  p_396_2_ = p_396_2_ / 2 + 1;
               }

               if(this.field_615_ag.field_1039_l == 3) {
                  p_396_2_ = p_396_2_ * 3 / 2;
               }
            }

            if(p_396_2_ == 0) {
               return false;
            } else {
               Entity var4 = var3;
               if(var3 instanceof EntityArrow && ((EntityArrow)var3).field_682_g != null) {
                  var4 = ((EntityArrow)var3).field_682_g;
               }

               if(var4 instanceof EntityLiving) {
                  this.func_25055_a((EntityLiving)var4, false);
               }

               this.func_25058_a(StatList.field_25165_t, p_396_2_);
               return super.func_396_a(p_396_1_, p_396_2_);
            }
         }
      }
   }

   protected int func_40128_b(DamageSource p_40128_1_, int p_40128_2_) {
      int var3 = super.func_40128_b(p_40128_1_, p_40128_2_);
      if(var3 <= 0) {
         return 0;
      } else {
         int var4 = EnchantmentHelper.func_40643_a(this.field_778_b, p_40128_1_);
         if(var4 > 20) {
            var4 = 20;
         }

         if(var4 > 0 && var4 <= 20) {
            int var5 = 25 - var4;
            int var6 = var3 * var5 + this.field_40129_bA;
            var3 = var6 / 25;
            this.field_40129_bA = var6 % 25;
         }

         return var3;
      }
   }

   protected boolean func_27025_G() {
      return false;
   }

   protected void func_25055_a(EntityLiving p_25055_1_, boolean p_25055_2_) {
      if(!(p_25055_1_ instanceof EntityCreeper) && !(p_25055_1_ instanceof EntityGhast)) {
         if(p_25055_1_ instanceof EntityWolf) {
            EntityWolf var3 = (EntityWolf)p_25055_1_;
            if(var3.func_48139_F_() && this.field_771_i.equals(var3.func_48145_ag())) {
               return;
            }
         }

         if(!(p_25055_1_ instanceof EntityPlayer) || this.func_27025_G()) {
            List var7 = this.field_615_ag.func_657_a(EntityWolf.class, AxisAlignedBB.func_1161_b(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_611_ak + 1.0D, this.field_610_al + 1.0D, this.field_609_am + 1.0D).func_1177_b(16.0D, 4.0D, 16.0D));
            Iterator var4 = var7.iterator();

            while(var4.hasNext()) {
               Entity var5 = (Entity)var4.next();
               EntityWolf var6 = (EntityWolf)var5;
               if(var6.func_48139_F_() && var6.func_25030_F() == null && this.field_771_i.equals(var6.func_48145_ag()) && (!p_25055_2_ || !var6.func_48141_af())) {
                  var6.func_48140_f(false);
                  var6.func_25032_c(p_25055_1_);
               }
            }

         }
      }
   }

   protected void func_40125_g(int p_40125_1_) {
      this.field_778_b.func_507_e(p_40125_1_);
   }

   public int func_40119_ar() {
      return this.field_778_b.func_506_f();
   }

   protected void func_4044_a(DamageSource p_4044_1_, int p_4044_2_) {
      if(!p_4044_1_.func_35534_b() && this.func_35162_ad()) {
         p_4044_2_ = 1 + p_4044_2_ >> 1;
      }

      p_4044_2_ = this.func_40115_d(p_4044_1_, p_4044_2_);
      p_4044_2_ = this.func_40128_b(p_4044_1_, p_4044_2_);
      this.func_35198_d(p_4044_1_.func_35533_c());
      this.field_9337_J -= p_4044_2_;
   }

   public void func_453_a(TileEntityFurnace p_453_1_) {}

   public void func_21092_a(TileEntityDispenser p_21092_1_) {}

   public void func_4052_a(TileEntitySign p_4052_1_) {}

   public void func_40180_a(TileEntityBrewingStand p_40180_1_) {}

   public void func_6415_a_(Entity p_6415_1_) {
      if(!p_6415_1_.func_353_a(this)) {
         ItemStack var2 = this.func_6416_v();
         if(var2 != null && p_6415_1_ instanceof EntityLiving) {
            var2.func_1100_b((EntityLiving)p_6415_1_);
            if(var2.field_1615_a <= 0) {
               var2.func_1097_a(this);
               this.func_448_u();
            }
         }

      }
   }

   public ItemStack func_6416_v() {
      return this.field_778_b.func_494_a();
   }

   public void func_448_u() {
      this.field_778_b.func_472_a(this.field_778_b.field_847_d, (ItemStack)null);
   }

   public double func_388_v() {
      return (double)(this.field_9292_aO - 0.5F);
   }

   public void func_457_w() {
      if(!this.field_9369_j || this.field_9368_k >= this.func_35202_aE() / 2 || this.field_9368_k < 0) {
         this.field_9368_k = -1;
         this.field_9369_j = true;
      }

   }

   public void func_463_a(Entity p_463_1_) {
      if(p_463_1_.func_48080_j()) {
         int var2 = this.field_778_b.func_502_a(p_463_1_);
         if(this.func_35160_a(Potion.field_35673_g)) {
            var2 += 3 << this.func_35167_b(Potion.field_35673_g).func_35801_c();
         }

         if(this.func_35160_a(Potion.field_35690_t)) {
            var2 -= 2 << this.func_35167_b(Potion.field_35690_t).func_35801_c();
         }

         int var3 = 0;
         int var4 = 0;
         if(p_463_1_ instanceof EntityLiving) {
            var4 = EnchantmentHelper.func_40630_a(this.field_778_b, (EntityLiving)p_463_1_);
            var3 += EnchantmentHelper.func_40645_b(this.field_778_b, (EntityLiving)p_463_1_);
         }

         if(this.func_35117_Q()) {
            ++var3;
         }

         if(var2 > 0 || var4 > 0) {
            boolean var5 = this.field_9288_aU > 0.0F && !this.field_9298_aH && !this.func_429_A() && !this.func_27013_ag() && !this.func_35160_a(Potion.field_35693_q) && this.field_616_af == null && p_463_1_ instanceof EntityLiving;
            if(var5) {
               var2 += this.field_9312_bd.nextInt(var2 / 2 + 2);
            }

            var2 += var4;
            boolean var6 = p_463_1_.func_396_a(DamageSource.func_35527_a(this), var2);
            if(var6) {
               if(var3 > 0) {
                  p_463_1_.func_348_f((double)(-MathHelper.func_1106_a(this.field_605_aq * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.func_1114_b(this.field_605_aq * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
                  this.field_608_an *= 0.6D;
                  this.field_606_ap *= 0.6D;
                  this.func_35113_c(false);
               }

               if(var5) {
                  this.func_35200_b(p_463_1_);
               }

               if(var4 > 0) {
                  this.func_40183_c(p_463_1_);
               }

               if(var2 >= 18) {
                  this.func_27026_a(AchievementList.field_40459_E);
               }

               this.func_48089_l(p_463_1_);
            }

            ItemStack var7 = this.func_6416_v();
            if(var7 != null && p_463_1_ instanceof EntityLiving) {
               var7.func_1092_a((EntityLiving)p_463_1_, this);
               if(var7.field_1615_a <= 0) {
                  var7.func_1097_a(this);
                  this.func_448_u();
               }
            }

            if(p_463_1_ instanceof EntityLiving) {
               if(p_463_1_.func_354_B()) {
                  this.func_25055_a((EntityLiving)p_463_1_, true);
               }

               this.func_25058_a(StatList.field_25167_s, var2);
               int var8 = EnchantmentHelper.func_40631_c(this.field_778_b, (EntityLiving)p_463_1_);
               if(var8 > 0) {
                  p_463_1_.func_40046_d(var8 * 4);
               }
            }

            this.func_35198_d(0.3F);
         }

      }
   }

   public void func_35200_b(Entity p_35200_1_) {}

   public void func_40183_c(Entity p_40183_1_) {}

   public void func_9367_r() {}

   public abstract void func_6420_o();

   public void func_20058_b(ItemStack p_20058_1_) {}

   public void func_395_F() {
      super.func_395_F();
      this.field_20069_g.func_1104_a(this);
      if(this.field_20068_h != null) {
         this.field_20068_h.func_1104_a(this);
      }

   }

   public boolean func_345_I() {
      return !this.field_21901_a && super.func_345_I();
   }

   public EnumStatus func_22053_b(int p_22053_1_, int p_22053_2_, int p_22053_3_) {
      if(!this.field_615_ag.field_1026_y) {
         if(this.func_22051_K() || !this.func_354_B()) {
            return EnumStatus.OTHER_PROBLEM;
         }

         if(!this.field_615_ag.field_4209_q.func_48217_e()) {
            return EnumStatus.NOT_POSSIBLE_HERE;
         }

         if(this.field_615_ag.func_624_b()) {
            return EnumStatus.NOT_POSSIBLE_NOW;
         }

         if(Math.abs(this.field_611_ak - (double)p_22053_1_) > 3.0D || Math.abs(this.field_610_al - (double)p_22053_2_) > 2.0D || Math.abs(this.field_609_am - (double)p_22053_3_) > 3.0D) {
            return EnumStatus.TOO_FAR_AWAY;
         }

         double var4 = 8.0D;
         double var6 = 5.0D;
         List var8 = this.field_615_ag.func_657_a(EntityMob.class, AxisAlignedBB.func_1161_b((double)p_22053_1_ - var4, (double)p_22053_2_ - var6, (double)p_22053_3_ - var4, (double)p_22053_1_ + var4, (double)p_22053_2_ + var6, (double)p_22053_3_ + var4));
         if(!var8.isEmpty()) {
            return EnumStatus.NOT_SAFE;
         }
      }

      this.func_371_a(0.2F, 0.2F);
      this.field_9292_aO = 0.2F;
      if(this.field_615_ag.func_630_d(p_22053_1_, p_22053_2_, p_22053_3_)) {
         int var9 = this.field_615_ag.func_602_e(p_22053_1_, p_22053_2_, p_22053_3_);
         int var5 = BlockBed.func_48216_a(var9);
         float var10 = 0.5F;
         float var7 = 0.5F;
         switch(var5) {
         case 0:
            var7 = 0.9F;
            break;
         case 1:
            var10 = 0.1F;
            break;
         case 2:
            var7 = 0.1F;
            break;
         case 3:
            var10 = 0.9F;
         }

         this.func_22052_e(var5);
         this.func_347_a((double)((float)p_22053_1_ + var10), (double)((float)p_22053_2_ + 0.9375F), (double)((float)p_22053_3_ + var7));
      } else {
         this.func_347_a((double)((float)p_22053_1_ + 0.5F), (double)((float)p_22053_2_ + 0.9375F), (double)((float)p_22053_3_ + 0.5F));
      }

      this.field_21901_a = true;
      this.field_21907_c = 0;
      this.field_21908_b = new ChunkCoordinates(p_22053_1_, p_22053_2_, p_22053_3_);
      this.field_608_an = this.field_606_ap = this.field_607_ao = 0.0D;
      if(!this.field_615_ag.field_1026_y) {
         this.field_615_ag.func_22140_w();
      }

      return EnumStatus.OK;
   }

   private void func_22052_e(int p_22052_1_) {
      this.field_22063_x = 0.0F;
      this.field_22061_z = 0.0F;
      switch(p_22052_1_) {
      case 0:
         this.field_22061_z = -1.8F;
         break;
      case 1:
         this.field_22063_x = 1.8F;
         break;
      case 2:
         this.field_22061_z = 1.8F;
         break;
      case 3:
         this.field_22063_x = -1.8F;
      }

   }

   public void func_22056_a(boolean p_22056_1_, boolean p_22056_2_, boolean p_22056_3_) {
      this.func_371_a(0.6F, 1.8F);
      this.func_22058_C();
      ChunkCoordinates var4 = this.field_21908_b;
      ChunkCoordinates var5 = this.field_21908_b;
      if(var4 != null && this.field_615_ag.func_600_a(var4.field_22395_a, var4.field_22394_b, var4.field_22396_c) == Block.field_9262_S.field_376_bc) {
         BlockBed.func_22031_a(this.field_615_ag, var4.field_22395_a, var4.field_22394_b, var4.field_22396_c, false);
         var5 = BlockBed.func_22028_g(this.field_615_ag, var4.field_22395_a, var4.field_22394_b, var4.field_22396_c, 0);
         if(var5 == null) {
            var5 = new ChunkCoordinates(var4.field_22395_a, var4.field_22394_b + 1, var4.field_22396_c);
         }

         this.func_347_a((double)((float)var5.field_22395_a + 0.5F), (double)((float)var5.field_22394_b + this.field_9292_aO + 0.1F), (double)((float)var5.field_22396_c + 0.5F));
      }

      this.field_21901_a = false;
      if(!this.field_615_ag.field_1026_y && p_22056_2_) {
         this.field_615_ag.func_22140_w();
      }

      if(p_22056_1_) {
         this.field_21907_c = 0;
      } else {
         this.field_21907_c = 100;
      }

      if(p_22056_3_) {
         this.func_25061_a(this.field_21908_b);
      }

   }

   private boolean func_22057_q() {
      return this.field_615_ag.func_600_a(this.field_21908_b.field_22395_a, this.field_21908_b.field_22394_b, this.field_21908_b.field_22396_c) == Block.field_9262_S.field_376_bc;
   }

   public static ChunkCoordinates func_25060_a(World p_25060_0_, ChunkCoordinates p_25060_1_) {
      IChunkProvider var2 = p_25060_0_.func_21118_q();
      var2.func_538_d(p_25060_1_.field_22395_a - 3 >> 4, p_25060_1_.field_22396_c - 3 >> 4);
      var2.func_538_d(p_25060_1_.field_22395_a + 3 >> 4, p_25060_1_.field_22396_c - 3 >> 4);
      var2.func_538_d(p_25060_1_.field_22395_a - 3 >> 4, p_25060_1_.field_22396_c + 3 >> 4);
      var2.func_538_d(p_25060_1_.field_22395_a + 3 >> 4, p_25060_1_.field_22396_c + 3 >> 4);
      if(p_25060_0_.func_600_a(p_25060_1_.field_22395_a, p_25060_1_.field_22394_b, p_25060_1_.field_22396_c) != Block.field_9262_S.field_376_bc) {
         return null;
      } else {
         ChunkCoordinates var3 = BlockBed.func_22028_g(p_25060_0_, p_25060_1_.field_22395_a, p_25060_1_.field_22394_b, p_25060_1_.field_22396_c, 0);
         return var3;
      }
   }

   public float func_22059_J() {
      if(this.field_21908_b != null) {
         int var1 = this.field_615_ag.func_602_e(this.field_21908_b.field_22395_a, this.field_21908_b.field_22394_b, this.field_21908_b.field_22396_c);
         int var2 = BlockBed.func_48216_a(var1);
         switch(var2) {
         case 0:
            return 90.0F;
         case 1:
            return 0.0F;
         case 2:
            return 270.0F;
         case 3:
            return 180.0F;
         }
      }

      return 0.0F;
   }

   public boolean func_22051_K() {
      return this.field_21901_a;
   }

   public boolean func_22054_L() {
      return this.field_21901_a && this.field_21907_c >= 100;
   }

   public int func_22060_M() {
      return this.field_21907_c;
   }

   public void func_22055_b(String p_22055_1_) {}

   public ChunkCoordinates func_25059_P() {
      return this.field_24900_bi;
   }

   public void func_25061_a(ChunkCoordinates p_25061_1_) {
      if(p_25061_1_ != null) {
         this.field_24900_bi = new ChunkCoordinates(p_25061_1_);
      } else {
         this.field_24900_bi = null;
      }

   }

   public void func_27026_a(StatBase p_27026_1_) {
      this.func_25058_a(p_27026_1_, 1);
   }

   public void func_25058_a(StatBase p_25058_1_, int p_25058_2_) {}

   protected void func_424_C() {
      super.func_424_C();
      this.func_25058_a(StatList.field_25171_q, 1);
      if(this.func_35117_Q()) {
         this.func_35198_d(0.8F);
      } else {
         this.func_35198_d(0.2F);
      }

   }

   public void func_435_b(float p_435_1_, float p_435_2_) {
      double var3 = this.field_611_ak;
      double var5 = this.field_610_al;
      double var7 = this.field_609_am;
      if(this.field_35212_aW.field_35757_b) {
         double var9 = this.field_607_ao;
         float var11 = this.field_35168_bw;
         this.field_35168_bw = 0.05F;
         super.func_435_b(p_435_1_, p_435_2_);
         this.field_607_ao = var9 * 0.6D;
         this.field_35168_bw = var11;
      } else {
         super.func_435_b(p_435_1_, p_435_2_);
      }

      this.func_25056_h(this.field_611_ak - var3, this.field_610_al - var5, this.field_609_am - var7);
   }

   public void func_25056_h(double p_25056_1_, double p_25056_3_, double p_25056_5_) {
      if(this.field_616_af == null) {
         int var7;
         if(this.func_393_a(Material.field_1332_f)) {
            var7 = Math.round(MathHelper.func_1109_a(p_25056_1_ * p_25056_1_ + p_25056_3_ * p_25056_3_ + p_25056_5_ * p_25056_5_) * 100.0F);
            if(var7 > 0) {
               this.func_25058_a(StatList.field_25173_p, var7);
               this.func_35198_d(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.func_27013_ag()) {
            var7 = Math.round(MathHelper.func_1109_a(p_25056_1_ * p_25056_1_ + p_25056_5_ * p_25056_5_) * 100.0F);
            if(var7 > 0) {
               this.func_25058_a(StatList.field_25177_l, var7);
               this.func_35198_d(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.func_429_A()) {
            if(p_25056_3_ > 0.0D) {
               this.func_25058_a(StatList.field_25175_n, (int)Math.round(p_25056_3_ * 100.0D));
            }
         } else if(this.field_9298_aH) {
            var7 = Math.round(MathHelper.func_1109_a(p_25056_1_ * p_25056_1_ + p_25056_5_ * p_25056_5_) * 100.0F);
            if(var7 > 0) {
               this.func_25058_a(StatList.field_25178_k, var7);
               if(this.func_35117_Q()) {
                  this.func_35198_d(0.099999994F * (float)var7 * 0.01F);
               } else {
                  this.func_35198_d(0.01F * (float)var7 * 0.01F);
               }
            }
         } else {
            var7 = Math.round(MathHelper.func_1109_a(p_25056_1_ * p_25056_1_ + p_25056_5_ * p_25056_5_) * 100.0F);
            if(var7 > 25) {
               this.func_25058_a(StatList.field_25174_o, var7);
            }
         }

      }
   }

   private void func_27024_i(double p_27024_1_, double p_27024_3_, double p_27024_5_) {
      if(this.field_616_af != null) {
         int var7 = Math.round(MathHelper.func_1109_a(p_27024_1_ * p_27024_1_ + p_27024_3_ * p_27024_3_ + p_27024_5_ * p_27024_5_) * 100.0F);
         if(var7 > 0) {
            if(this.field_616_af instanceof EntityMinecart) {
               this.func_25058_a(StatList.field_27364_r, var7);
               if(this.field_26907_d == null) {
                  this.field_26907_d = new ChunkCoordinates(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
               } else if(this.field_26907_d.func_27439_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) >= 1000.0D) {
                  this.func_25058_a(AchievementList.field_27379_q, 1);
               }
            } else if(this.field_616_af instanceof EntityBoat) {
               this.func_25058_a(StatList.field_27363_s, var7);
            } else if(this.field_616_af instanceof EntityPig) {
               this.func_25058_a(StatList.field_27362_t, var7);
            }
         }
      }

   }

   protected void func_400_c(float p_400_1_) {
      if(!this.field_35212_aW.field_35758_c) {
         if(p_400_1_ >= 2.0F) {
            this.func_25058_a(StatList.field_25176_m, (int)Math.round((double)p_400_1_ * 100.0D));
         }

         super.func_400_c(p_400_1_);
      }
   }

   public void func_27015_a(EntityLiving p_27015_1_) {
      if(p_27015_1_ instanceof EntityMob) {
         this.func_27026_a(AchievementList.field_27377_s);
      }

   }

   public int func_28021_c(ItemStack p_28021_1_, int p_28021_2_) {
      int var3 = super.func_28021_c(p_28021_1_, p_28021_2_);
      if(p_28021_1_.field_1617_c == Item.field_4024_aP.field_291_aS && this.field_4128_n != null) {
         var3 = p_28021_1_.func_1088_b() + 16;
      } else {
         if(p_28021_1_.func_1091_a().func_46058_c()) {
            return p_28021_1_.func_1091_a().func_46057_a(p_28021_1_.func_21181_i(), p_28021_2_);
         }

         if(this.field_34907_d != null && p_28021_1_.field_1617_c == Item.field_227_i.field_291_aS) {
            int var4 = p_28021_1_.func_35866_m() - this.field_34906_e;
            if(var4 >= 18) {
               return 133;
            }

            if(var4 > 13) {
               return 117;
            }

            if(var4 > 0) {
               return 101;
            }
         }
      }

      return var3;
   }

   public void func_4039_q() {
      if(this.field_28024_y > 0) {
         this.field_28024_y = 10;
      } else {
         this.field_28023_z = true;
      }
   }

   public void func_35204_c(int p_35204_1_) {
      this.field_9370_g += p_35204_1_;
      int var2 = Integer.MAX_VALUE - this.field_35209_aZ;
      if(p_35204_1_ > var2) {
         p_35204_1_ = var2;
      }

      this.field_35211_aX += (float)p_35204_1_ / (float)this.func_35193_as();

      for(this.field_35209_aZ += p_35204_1_; this.field_35211_aX >= 1.0F; this.field_35211_aX /= (float)this.func_35193_as()) {
         this.field_35211_aX = (this.field_35211_aX - 1.0F) * (float)this.func_35193_as();
         this.func_35203_aG();
      }

   }

   public void func_40184_i(int p_40184_1_) {
      this.field_35210_aY -= p_40184_1_;
      if(this.field_35210_aY < 0) {
         this.field_35210_aY = 0;
      }

   }

   public int func_35193_as() {
      return 7 + (this.field_35210_aY * 7 >> 1);
   }

   private void func_35203_aG() {
      ++this.field_35210_aY;
   }

   public void func_35198_d(float p_35198_1_) {
      if(!this.field_35212_aW.field_35759_a) {
         if(!this.field_615_ag.field_1026_y) {
            this.field_35217_av.func_35762_a(p_35198_1_);
         }

      }
   }

   public FoodStats func_35191_at() {
      return this.field_35217_av;
   }

   public boolean func_35197_b(boolean p_35197_1_) {
      return (p_35197_1_ || this.field_35217_av.func_35770_c()) && !this.field_35212_aW.field_35759_a;
   }

   public boolean func_35194_au() {
      return this.func_40114_aH() > 0 && this.func_40114_aH() < this.func_40117_c();
   }

   public void func_35199_b(ItemStack p_35199_1_, int p_35199_2_) {
      if(p_35199_1_ != this.field_34907_d) {
         this.field_34907_d = p_35199_1_;
         this.field_34906_e = p_35199_2_;
         if(!this.field_615_ag.field_1026_y) {
            this.func_35116_d(true);
         }

      }
   }

   public boolean func_35190_e(int p_35190_1_, int p_35190_2_, int p_35190_3_) {
      return true;
   }

   protected int func_36001_a(EntityPlayer p_36001_1_) {
      int var2 = this.field_35210_aY * 7;
      return var2 > 100?100:var2;
   }

   protected boolean func_35163_av() {
      return true;
   }

   public void func_40182_b(int p_40182_1_) {}

   public void func_41014_d(EntityPlayer p_41014_1_) {
      this.field_778_b.func_41022_a(p_41014_1_.field_778_b);
      this.field_9337_J = p_41014_1_.field_9337_J;
      this.field_35217_av = p_41014_1_.field_35217_av;
      this.field_35210_aY = p_41014_1_.field_35210_aY;
      this.field_35209_aZ = p_41014_1_.field_35209_aZ;
      this.field_35211_aX = p_41014_1_.field_35211_aX;
      this.field_9370_g = p_41014_1_.field_9370_g;
   }

   protected boolean func_25021_m() {
      return !this.field_35212_aW.field_35757_b;
   }

   public void func_50009_aI() {}
}
