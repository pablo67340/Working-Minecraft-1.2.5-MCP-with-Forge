package net.minecraft.src;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Container;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityCrit2FX;
import net.minecraft.src.EntityEgg;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.EntityEnderEye;
import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityOtherPlayerMP;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPickupFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.Explosion;
import net.minecraft.src.GuiDisconnected;
import net.minecraft.src.GuiDownloadTerrain;
import net.minecraft.src.GuiPlayerInfo;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiWinGame;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.InventoryBasic;
import net.minecraft.src.Item;
import net.minecraft.src.ItemMap;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapStorage;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.Packet100OpenWindow;
import net.minecraft.src.Packet101CloseWindow;
import net.minecraft.src.Packet103SetSlot;
import net.minecraft.src.Packet104WindowItems;
import net.minecraft.src.Packet105UpdateProgressbar;
import net.minecraft.src.Packet106Transaction;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet130UpdateSign;
import net.minecraft.src.Packet131MapData;
import net.minecraft.src.Packet132TileEntityData;
import net.minecraft.src.Packet17Sleep;
import net.minecraft.src.Packet18Animation;
import net.minecraft.src.Packet1Login;
import net.minecraft.src.Packet200Statistic;
import net.minecraft.src.Packet201PlayerInfo;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet20NamedEntitySpawn;
import net.minecraft.src.Packet21PickupSpawn;
import net.minecraft.src.Packet22Collect;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Packet24MobSpawn;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Packet25EntityPainting;
import net.minecraft.src.Packet26EntityExpOrb;
import net.minecraft.src.Packet28EntityVelocity;
import net.minecraft.src.Packet29DestroyEntity;
import net.minecraft.src.Packet2Handshake;
import net.minecraft.src.Packet30Entity;
import net.minecraft.src.Packet34EntityTeleport;
import net.minecraft.src.Packet35EntityHeadRotation;
import net.minecraft.src.Packet38EntityStatus;
import net.minecraft.src.Packet39AttachEntity;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet40EntityMetadata;
import net.minecraft.src.Packet41EntityEffect;
import net.minecraft.src.Packet42RemoveEntityEffect;
import net.minecraft.src.Packet43Experience;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet50PreChunk;
import net.minecraft.src.Packet51MapChunk;
import net.minecraft.src.Packet52MultiBlockChange;
import net.minecraft.src.Packet53BlockChange;
import net.minecraft.src.Packet54PlayNoteBlock;
import net.minecraft.src.Packet5PlayerInventory;
import net.minecraft.src.Packet60Explosion;
import net.minecraft.src.Packet61DoorChange;
import net.minecraft.src.Packet6SpawnPosition;
import net.minecraft.src.Packet70Bed;
import net.minecraft.src.Packet71Weather;
import net.minecraft.src.Packet8UpdateHealth;
import net.minecraft.src.Packet9Respawn;
import net.minecraft.src.PlayerControllerMP;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.StatList;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityBrewingStand;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;
import net.minecraft.src.WorldClient;
import net.minecraft.src.WorldProviderSurface;
import net.minecraft.src.WorldSettings;

public class NetClientHandler extends NetHandler {

   private boolean field_1214_c = false;
   private NetworkManager field_1213_d;
   public String field_1209_a;
   private Minecraft field_1212_e;
   private WorldClient field_1211_f;
   private boolean field_1210_g = false;
   public MapStorage field_28118_b = new MapStorage((ISaveHandler)null);
   private Map field_35787_k = new HashMap();
   public List field_35786_c = new ArrayList();
   public int field_35785_d = 20;
   Random field_1208_b = new Random();


   public NetClientHandler(Minecraft p_i42_1_, String p_i42_2_, int p_i42_3_) throws UnknownHostException, IOException {
      this.field_1212_e = p_i42_1_;
      Socket var4 = new Socket(InetAddress.getByName(p_i42_2_), p_i42_3_);
      this.field_1213_d = new NetworkManager(var4, "Client", this);
   }

   public void func_848_a() {
      if(!this.field_1214_c) {
         this.field_1213_d.func_967_a();
      }

      this.field_1213_d.func_28139_a();
   }

   public void func_4115_a(Packet1Login p_4115_1_) {
      this.field_1212_e.field_6327_b = new PlayerControllerMP(this.field_1212_e, this);
      this.field_1212_e.field_25001_G.func_25100_a(StatList.field_25181_h, 1);
      this.field_1211_f = new WorldClient(this, new WorldSettings(0L, p_4115_1_.field_35249_d, false, false, p_4115_1_.field_46032_d), p_4115_1_.field_48170_e, p_4115_1_.field_35247_f);
      this.field_1211_f.field_1026_y = true;
      this.field_1212_e.func_6261_a(this.field_1211_f);
      this.field_1212_e.field_6322_g.field_4129_m = p_4115_1_.field_48170_e;
      this.field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
      this.field_1212_e.field_6322_g.field_620_ab = p_4115_1_.field_519_a;
      this.field_35785_d = p_4115_1_.field_35251_h;
      ((PlayerControllerMP)this.field_1212_e.field_6327_b).func_35648_a(p_4115_1_.field_35249_d == 1);
   }

   public void func_832_a(Packet21PickupSpawn p_832_1_) {
      double var2 = (double)p_832_1_.field_530_b / 32.0D;
      double var4 = (double)p_832_1_.field_529_c / 32.0D;
      double var6 = (double)p_832_1_.field_528_d / 32.0D;
      EntityItem var8 = new EntityItem(this.field_1211_f, var2, var4, var6, new ItemStack(p_832_1_.field_524_h, p_832_1_.field_523_i, p_832_1_.field_21052_l));
      var8.field_608_an = (double)p_832_1_.field_527_e / 128.0D;
      var8.field_607_ao = (double)p_832_1_.field_526_f / 128.0D;
      var8.field_606_ap = (double)p_832_1_.field_525_g / 128.0D;
      var8.field_9303_br = p_832_1_.field_530_b;
      var8.field_9302_bs = p_832_1_.field_529_c;
      var8.field_9301_bt = p_832_1_.field_528_d;
      this.field_1211_f.func_712_a(p_832_1_.field_531_a, var8);
   }

   public void func_835_a(Packet23VehicleSpawn p_835_1_) {
      double var2 = (double)p_835_1_.field_499_b / 32.0D;
      double var4 = (double)p_835_1_.field_503_c / 32.0D;
      double var6 = (double)p_835_1_.field_502_d / 32.0D;
      Object var8 = null;
      if(p_835_1_.field_501_e == 10) {
         var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 0);
      } else if(p_835_1_.field_501_e == 11) {
         var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 1);
      } else if(p_835_1_.field_501_e == 12) {
         var8 = new EntityMinecart(this.field_1211_f, var2, var4, var6, 2);
      } else if(p_835_1_.field_501_e == 90) {
         var8 = new EntityFishHook(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 60) {
         var8 = new EntityArrow(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 61) {
         var8 = new EntitySnowball(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 65) {
         var8 = new EntityEnderPearl(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 72) {
         var8 = new EntityEnderEye(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 63) {
         var8 = new EntityFireball(this.field_1211_f, var2, var4, var6, (double)p_835_1_.field_28047_e / 8000.0D, (double)p_835_1_.field_28046_f / 8000.0D, (double)p_835_1_.field_28045_g / 8000.0D);
         p_835_1_.field_28044_i = 0;
      } else if(p_835_1_.field_501_e == 64) {
         var8 = new EntitySmallFireball(this.field_1211_f, var2, var4, var6, (double)p_835_1_.field_28047_e / 8000.0D, (double)p_835_1_.field_28046_f / 8000.0D, (double)p_835_1_.field_28045_g / 8000.0D);
         p_835_1_.field_28044_i = 0;
      } else if(p_835_1_.field_501_e == 62) {
         var8 = new EntityEgg(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 73) {
         var8 = new EntityPotion(this.field_1211_f, var2, var4, var6, p_835_1_.field_28044_i);
         p_835_1_.field_28044_i = 0;
      } else if(p_835_1_.field_501_e == 75) {
         var8 = new EntityExpBottle(this.field_1211_f, var2, var4, var6);
         p_835_1_.field_28044_i = 0;
      } else if(p_835_1_.field_501_e == 1) {
         var8 = new EntityBoat(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 50) {
         var8 = new EntityTNTPrimed(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 51) {
         var8 = new EntityEnderCrystal(this.field_1211_f, var2, var4, var6);
      } else if(p_835_1_.field_501_e == 70) {
         var8 = new EntityFallingSand(this.field_1211_f, var2, var4, var6, Block.field_393_F.field_376_bc);
      } else if(p_835_1_.field_501_e == 71) {
         var8 = new EntityFallingSand(this.field_1211_f, var2, var4, var6, Block.field_392_G.field_376_bc);
      } else if(p_835_1_.field_501_e == 74) {
         var8 = new EntityFallingSand(this.field_1211_f, var2, var4, var6, Block.field_41050_bK.field_376_bc);
      }

      if(var8 != null) {
         ((Entity)var8).field_9303_br = p_835_1_.field_499_b;
         ((Entity)var8).field_9302_bs = p_835_1_.field_503_c;
         ((Entity)var8).field_9301_bt = p_835_1_.field_502_d;
         ((Entity)var8).field_605_aq = 0.0F;
         ((Entity)var8).field_604_ar = 0.0F;
         Entity[] var9 = ((Entity)var8).func_40048_X();
         if(var9 != null) {
            int var10 = p_835_1_.field_500_a - ((Entity)var8).field_620_ab;

            for(int var11 = 0; var11 < var9.length; ++var11) {
               var9[var11].field_620_ab += var10;
            }
         }

         ((Entity)var8).field_620_ab = p_835_1_.field_500_a;
         this.field_1211_f.func_712_a(p_835_1_.field_500_a, (Entity)var8);
         if(p_835_1_.field_28044_i > 0) {
            if(p_835_1_.field_501_e == 60) {
               Entity var12 = this.func_12246_a(p_835_1_.field_28044_i);
               if(var12 instanceof EntityLiving) {
                  ((EntityArrow)var8).field_682_g = (EntityLiving)var12;
               }
            }

            ((Entity)var8).func_6375_a((double)p_835_1_.field_28047_e / 8000.0D, (double)p_835_1_.field_28046_f / 8000.0D, (double)p_835_1_.field_28045_g / 8000.0D);
         }
      }

   }

   public void func_35778_a(Packet26EntityExpOrb p_35778_1_) {
      EntityXPOrb var2 = new EntityXPOrb(this.field_1211_f, (double)p_35778_1_.field_35239_b, (double)p_35778_1_.field_35240_c, (double)p_35778_1_.field_35237_d, p_35778_1_.field_35238_e);
      var2.field_9303_br = p_35778_1_.field_35239_b;
      var2.field_9302_bs = p_35778_1_.field_35240_c;
      var2.field_9301_bt = p_35778_1_.field_35237_d;
      var2.field_605_aq = 0.0F;
      var2.field_604_ar = 0.0F;
      var2.field_620_ab = p_35778_1_.field_35241_a;
      this.field_1211_f.func_712_a(p_35778_1_.field_35241_a, var2);
   }

   public void func_27246_a(Packet71Weather p_27246_1_) {
      double var2 = (double)p_27246_1_.field_27053_b / 32.0D;
      double var4 = (double)p_27246_1_.field_27057_c / 32.0D;
      double var6 = (double)p_27246_1_.field_27056_d / 32.0D;
      EntityLightningBolt var8 = null;
      if(p_27246_1_.field_27055_e == 1) {
         var8 = new EntityLightningBolt(this.field_1211_f, var2, var4, var6);
      }

      if(var8 != null) {
         var8.field_9303_br = p_27246_1_.field_27053_b;
         var8.field_9302_bs = p_27246_1_.field_27057_c;
         var8.field_9301_bt = p_27246_1_.field_27056_d;
         var8.field_605_aq = 0.0F;
         var8.field_604_ar = 0.0F;
         var8.field_620_ab = p_27246_1_.field_27054_a;
         this.field_1211_f.func_27159_a(var8);
      }

   }

   public void func_21146_a(Packet25EntityPainting p_21146_1_) {
      EntityPainting var2 = new EntityPainting(this.field_1211_f, p_21146_1_.field_21041_b, p_21146_1_.field_21046_c, p_21146_1_.field_21045_d, p_21146_1_.field_21044_e, p_21146_1_.field_21043_f);
      this.field_1211_f.func_712_a(p_21146_1_.field_21042_a, var2);
   }

   public void func_6498_a(Packet28EntityVelocity p_6498_1_) {
      Entity var2 = this.func_12246_a(p_6498_1_.field_6367_a);
      if(var2 != null) {
         var2.func_6375_a((double)p_6498_1_.field_6366_b / 8000.0D, (double)p_6498_1_.field_6369_c / 8000.0D, (double)p_6498_1_.field_6368_d / 8000.0D);
      }
   }

   public void func_21148_a(Packet40EntityMetadata p_21148_1_) {
      Entity var2 = this.func_12246_a(p_21148_1_.field_21049_a);
      if(var2 != null && p_21148_1_.func_21047_b() != null) {
         var2.func_21061_O().func_21126_a(p_21148_1_.func_21047_b());
      }

   }

   public void func_820_a(Packet20NamedEntitySpawn p_820_1_) {
      double var2 = (double)p_820_1_.field_540_c / 32.0D;
      double var4 = (double)p_820_1_.field_539_d / 32.0D;
      double var6 = (double)p_820_1_.field_538_e / 32.0D;
      float var8 = (float)(p_820_1_.field_537_f * 360) / 256.0F;
      float var9 = (float)(p_820_1_.field_536_g * 360) / 256.0F;
      EntityOtherPlayerMP var10 = new EntityOtherPlayerMP(this.field_1212_e.field_6324_e, p_820_1_.field_533_b);
      var10.field_9285_at = var10.field_638_aI = (double)(var10.field_9303_br = p_820_1_.field_540_c);
      var10.field_9284_au = var10.field_637_aJ = (double)(var10.field_9302_bs = p_820_1_.field_539_d);
      var10.field_9283_av = var10.field_636_aK = (double)(var10.field_9301_bt = p_820_1_.field_538_e);
      int var11 = p_820_1_.field_535_h;
      if(var11 == 0) {
         var10.field_778_b.field_843_a[var10.field_778_b.field_847_d] = null;
      } else {
         var10.field_778_b.field_843_a[var10.field_778_b.field_847_d] = new ItemStack(var11, 1, 0);
      }

      var10.func_399_b(var2, var4, var6, var8, var9);
      this.field_1211_f.func_712_a(p_820_1_.field_534_a, var10);
   }

   public void func_829_a(Packet34EntityTeleport p_829_1_) {
      Entity var2 = this.func_12246_a(p_829_1_.field_509_a);
      if(var2 != null) {
         var2.field_9303_br = p_829_1_.field_508_b;
         var2.field_9302_bs = p_829_1_.field_513_c;
         var2.field_9301_bt = p_829_1_.field_512_d;
         double var3 = (double)var2.field_9303_br / 32.0D;
         double var5 = (double)var2.field_9302_bs / 32.0D + 0.015625D;
         double var7 = (double)var2.field_9301_bt / 32.0D;
         float var9 = (float)(p_829_1_.field_511_e * 360) / 256.0F;
         float var10 = (float)(p_829_1_.field_510_f * 360) / 256.0F;
         var2.func_378_a(var3, var5, var7, var9, var10, 3);
      }
   }

   public void func_827_a(Packet30Entity p_827_1_) {
      Entity var2 = this.func_12246_a(p_827_1_.field_485_a);
      if(var2 != null) {
         var2.field_9303_br += p_827_1_.field_484_b;
         var2.field_9302_bs += p_827_1_.field_490_c;
         var2.field_9301_bt += p_827_1_.field_489_d;
         double var3 = (double)var2.field_9303_br / 32.0D;
         double var5 = (double)var2.field_9302_bs / 32.0D;
         double var7 = (double)var2.field_9301_bt / 32.0D;
         float var9 = p_827_1_.field_486_g?(float)(p_827_1_.field_488_e * 360) / 256.0F:var2.field_605_aq;
         float var10 = p_827_1_.field_486_g?(float)(p_827_1_.field_487_f * 360) / 256.0F:var2.field_604_ar;
         var2.func_378_a(var3, var5, var7, var9, var10, 3);
      }
   }

   public void func_48488_a(Packet35EntityHeadRotation p_48488_1_) {
      Entity var2 = this.func_12246_a(p_48488_1_.field_48160_a);
      if(var2 != null) {
         float var3 = (float)(p_48488_1_.field_48159_b * 360) / 256.0F;
         var2.func_48079_f(var3);
      }
   }

   public void func_839_a(Packet29DestroyEntity p_839_1_) {
      this.field_1211_f.func_710_c(p_839_1_.field_507_a);
   }

   public void func_837_a(Packet10Flying p_837_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      double var3 = var2.field_611_ak;
      double var5 = var2.field_610_al;
      double var7 = var2.field_609_am;
      float var9 = var2.field_605_aq;
      float var10 = var2.field_604_ar;
      if(p_837_1_.field_554_h) {
         var3 = p_837_1_.field_561_a;
         var5 = p_837_1_.field_560_b;
         var7 = p_837_1_.field_559_c;
      }

      if(p_837_1_.field_553_i) {
         var9 = p_837_1_.field_557_e;
         var10 = p_837_1_.field_556_f;
      }

      var2.field_9287_aY = 0.0F;
      var2.field_608_an = var2.field_607_ao = var2.field_606_ap = 0.0D;
      var2.func_399_b(var3, var5, var7, var9, var10);
      p_837_1_.field_561_a = var2.field_611_ak;
      p_837_1_.field_560_b = var2.field_601_au.field_1697_b;
      p_837_1_.field_559_c = var2.field_609_am;
      p_837_1_.field_558_d = var2.field_610_al;
      this.field_1213_d.func_972_a(p_837_1_);
      if(!this.field_1210_g) {
         this.field_1212_e.field_6322_g.field_9285_at = this.field_1212_e.field_6322_g.field_611_ak;
         this.field_1212_e.field_6322_g.field_9284_au = this.field_1212_e.field_6322_g.field_610_al;
         this.field_1212_e.field_6322_g.field_9283_av = this.field_1212_e.field_6322_g.field_609_am;
         this.field_1210_g = true;
         this.field_1212_e.func_6272_a((GuiScreen)null);
      }

   }

   public void func_826_a(Packet50PreChunk p_826_1_) {
      this.field_1211_f.func_713_a(p_826_1_.field_505_a, p_826_1_.field_504_b, p_826_1_.field_506_c);
   }

   public void func_824_a(Packet52MultiBlockChange p_824_1_) {
      int var2 = p_824_1_.field_479_a * 16;
      int var3 = p_824_1_.field_478_b * 16;
      if(p_824_1_.field_481_e != null) {
         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(p_824_1_.field_481_e));

         try {
            for(int var5 = 0; var5 < p_824_1_.field_480_f; ++var5) {
               short var6 = var4.readShort();
               short var7 = var4.readShort();
               int var8 = (var7 & 4095) >> 4;
               int var9 = var7 & 15;
               int var10 = var6 >> 12 & 15;
               int var11 = var6 >> 8 & 15;
               int var12 = var6 & 255;
               this.field_1211_f.func_714_c(var10 + var2, var12, var11 + var3, var8, var9);
            }
         } catch (IOException var13) {
            ;
         }

      }
   }

   public void func_48487_a(Packet51MapChunk p_48487_1_) {
      this.field_1211_f.func_711_c(p_48487_1_.field_48177_a << 4, 0, p_48487_1_.field_48175_b << 4, (p_48487_1_.field_48177_a << 4) + 15, 256, (p_48487_1_.field_48175_b << 4) + 15);
      Chunk var2 = this.field_1211_f.func_704_b(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b);
      if(p_48487_1_.field_48171_f && var2 == null) {
         this.field_1211_f.func_713_a(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b, true);
         var2 = this.field_1211_f.func_704_b(p_48487_1_.field_48177_a, p_48487_1_.field_48175_b);
      }

      if(var2 != null) {
         var2.func_48494_a(p_48487_1_.field_48174_e, p_48487_1_.field_48176_c, p_48487_1_.field_48173_d, p_48487_1_.field_48171_f);
         this.field_1211_f.func_701_b(p_48487_1_.field_48177_a << 4, 0, p_48487_1_.field_48175_b << 4, (p_48487_1_.field_48177_a << 4) + 15, 256, (p_48487_1_.field_48175_b << 4) + 15);
         if(!p_48487_1_.field_48171_f || !(this.field_1211_f.field_4209_q instanceof WorldProviderSurface)) {
            var2.func_48496_n();
         }
      }

   }

   public void func_822_a(Packet53BlockChange p_822_1_) {
      this.field_1211_f.func_714_c(p_822_1_.field_492_a, p_822_1_.field_491_b, p_822_1_.field_495_c, p_822_1_.field_494_d, p_822_1_.field_493_e);
   }

   public void func_844_a(Packet255KickDisconnect p_844_1_) {
      this.field_1213_d.func_974_a("disconnect.kicked", new Object[0]);
      this.field_1214_c = true;
      this.field_1212_e.func_6261_a((World)null);
      this.field_1212_e.func_6272_a(new GuiDisconnected("disconnect.disconnected", "disconnect.genericReason", new Object[]{p_844_1_.field_582_a}));
   }

   public void func_823_a(String p_823_1_, Object[] p_823_2_) {
      if(!this.field_1214_c) {
         this.field_1214_c = true;
         this.field_1212_e.func_6261_a((World)null);
         this.field_1212_e.func_6272_a(new GuiDisconnected("disconnect.lost", p_823_1_, p_823_2_));
      }
   }

   public void func_28117_a(Packet p_28117_1_) {
      if(!this.field_1214_c) {
         this.field_1213_d.func_972_a(p_28117_1_);
         this.field_1213_d.func_28142_c();
      }
   }

   public void func_847_a(Packet p_847_1_) {
      if(!this.field_1214_c) {
         this.field_1213_d.func_972_a(p_847_1_);
      }
   }

   public void func_834_a(Packet22Collect p_834_1_) {
      Entity var2 = this.func_12246_a(p_834_1_.field_581_a);
      Object var3 = (EntityLiving)this.func_12246_a(p_834_1_.field_580_b);
      if(var3 == null) {
         var3 = this.field_1212_e.field_6322_g;
      }

      if(var2 != null) {
         if(var2 instanceof EntityXPOrb) {
            this.field_1211_f.func_623_a(var2, "random.orb", 0.2F, ((this.field_1208_b.nextFloat() - this.field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         } else {
            this.field_1211_f.func_623_a(var2, "random.pop", 0.2F, ((this.field_1208_b.nextFloat() - this.field_1208_b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
         }

         this.field_1212_e.field_6321_h.func_1192_a(new EntityPickupFX(this.field_1212_e.field_6324_e, var2, (Entity)var3, -0.5F));
         this.field_1211_f.func_710_c(p_834_1_.field_581_a);
      }

   }

   public void func_4113_a(Packet3Chat p_4113_1_) {
      this.field_1212_e.field_6308_u.func_552_a(p_4113_1_.field_517_a);
   }

   public void func_825_a(Packet18Animation p_825_1_) {
      Entity var2 = this.func_12246_a(p_825_1_.field_522_a);
      if(var2 != null) {
         EntityPlayer var3;
         if(p_825_1_.field_521_b == 1) {
            var3 = (EntityPlayer)var2;
            var3.func_457_w();
         } else if(p_825_1_.field_521_b == 2) {
            var2.func_9280_g();
         } else if(p_825_1_.field_521_b == 3) {
            var3 = (EntityPlayer)var2;
            var3.func_22056_a(false, false, false);
         } else if(p_825_1_.field_521_b == 4) {
            var3 = (EntityPlayer)var2;
            var3.func_6420_o();
         } else if(p_825_1_.field_521_b == 6) {
            this.field_1212_e.field_6321_h.func_1192_a(new EntityCrit2FX(this.field_1212_e.field_6324_e, var2));
         } else if(p_825_1_.field_521_b == 7) {
            EntityCrit2FX var4 = new EntityCrit2FX(this.field_1212_e.field_6324_e, var2, "magicCrit");
            this.field_1212_e.field_6321_h.func_1192_a(var4);
         } else if(p_825_1_.field_521_b == 5 && var2 instanceof EntityOtherPlayerMP) {
            ;
         }

      }
   }

   public void func_22186_a(Packet17Sleep p_22186_1_) {
      Entity var2 = this.func_12246_a(p_22186_1_.field_22045_a);
      if(var2 != null) {
         if(p_22186_1_.field_22046_e == 0) {
            EntityPlayer var3 = (EntityPlayer)var2;
            var3.func_22053_b(p_22186_1_.field_22044_b, p_22186_1_.field_22048_c, p_22186_1_.field_22047_d);
         }

      }
   }

   public void func_838_a(Packet2Handshake p_838_1_) {
      boolean var2 = true;
      String var3 = p_838_1_.field_532_a;
      if(var3 != null && var3.trim().length() != 0) {
         if(!var3.equals("-")) {
            try {
               Long.parseLong(var3, 16);
            } catch (NumberFormatException var8) {
               var2 = false;
            }
         }
      } else {
         var2 = false;
      }

      if(!var2) {
         this.field_1213_d.func_974_a("disconnect.genericReason", new Object[]{"The server responded with an invalid server key"});
      } else if(p_838_1_.field_532_a.equals("-")) {
         this.func_847_a(new Packet1Login(this.field_1212_e.field_6320_i.field_1666_b, 29));
      } else {
         try {
            URL var4 = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + this.field_1212_e.field_6320_i.field_1666_b + "&sessionId=" + this.field_1212_e.field_6320_i.field_6543_c + "&serverId=" + p_838_1_.field_532_a);
            BufferedReader var5 = new BufferedReader(new InputStreamReader(var4.openStream()));
            String var6 = var5.readLine();
            var5.close();
            if(var6.equalsIgnoreCase("ok")) {
               this.func_847_a(new Packet1Login(this.field_1212_e.field_6320_i.field_1666_b, 29));
            } else {
               this.field_1213_d.func_974_a("disconnect.loginFailedInfo", new Object[]{var6});
            }
         } catch (Exception var7) {
            var7.printStackTrace();
            this.field_1213_d.func_974_a("disconnect.genericReason", new Object[]{"Internal client error: " + var7.toString()});
         }
      }

   }

   public void func_849_b() {
      this.field_1214_c = true;
      this.field_1213_d.func_28139_a();
      this.field_1213_d.func_974_a("disconnect.closed", new Object[0]);
   }

   public void func_828_a(Packet24MobSpawn p_828_1_) {
      double var2 = (double)p_828_1_.field_552_c / 32.0D;
      double var4 = (double)p_828_1_.field_551_d / 32.0D;
      double var6 = (double)p_828_1_.field_550_e / 32.0D;
      float var8 = (float)(p_828_1_.field_549_f * 360) / 256.0F;
      float var9 = (float)(p_828_1_.field_548_g * 360) / 256.0F;
      EntityLiving var10 = (EntityLiving)EntityList.func_1084_a(p_828_1_.field_546_b, this.field_1212_e.field_6324_e);
      var10.field_9303_br = p_828_1_.field_552_c;
      var10.field_9302_bs = p_828_1_.field_551_d;
      var10.field_9301_bt = p_828_1_.field_550_e;
      var10.field_46015_bf = (float)(p_828_1_.field_48169_h * 360) / 256.0F;
      Entity[] var11 = var10.func_40048_X();
      if(var11 != null) {
         int var12 = p_828_1_.field_547_a - var10.field_620_ab;

         for(int var13 = 0; var13 < var11.length; ++var13) {
            var11[var13].field_620_ab += var12;
         }
      }

      var10.field_620_ab = p_828_1_.field_547_a;
      var10.func_399_b(var2, var4, var6, var8, var9);
      this.field_1211_f.func_712_a(p_828_1_.field_547_a, var10);
      List var14 = p_828_1_.func_21053_b();
      if(var14 != null) {
         var10.func_21061_O().func_21126_a(var14);
      }

   }

   public void func_846_a(Packet4UpdateTime p_846_1_) {
      this.field_1212_e.field_6324_e.func_648_a(p_846_1_.field_564_a);
   }

   public void func_845_a(Packet6SpawnPosition p_845_1_) {
      this.field_1212_e.field_6322_g.func_25061_a(new ChunkCoordinates(p_845_1_.field_515_a, p_845_1_.field_514_b, p_845_1_.field_516_c));
      this.field_1212_e.field_6324_e.func_22144_v().func_22292_a(p_845_1_.field_515_a, p_845_1_.field_514_b, p_845_1_.field_516_c);
   }

   public void func_6497_a(Packet39AttachEntity p_6497_1_) {
      Object var2 = this.func_12246_a(p_6497_1_.field_6365_a);
      Entity var3 = this.func_12246_a(p_6497_1_.field_6364_b);
      if(p_6497_1_.field_6365_a == this.field_1212_e.field_6322_g.field_620_ab) {
         var2 = this.field_1212_e.field_6322_g;
      }

      if(var2 != null) {
         ((Entity)var2).func_6377_h(var3);
      }
   }

   public void func_9447_a(Packet38EntityStatus p_9447_1_) {
      Entity var2 = this.func_12246_a(p_9447_1_.field_9274_a);
      if(var2 != null) {
         var2.func_9282_a(p_9447_1_.field_9273_b);
      }

   }

   private Entity func_12246_a(int p_12246_1_) {
      return (Entity)(p_12246_1_ == this.field_1212_e.field_6322_g.field_620_ab?this.field_1212_e.field_6322_g:this.field_1211_f.func_709_b(p_12246_1_));
   }

   public void func_9446_a(Packet8UpdateHealth p_9446_1_) {
      this.field_1212_e.field_6322_g.func_9372_a_(p_9446_1_.field_9275_a);
      this.field_1212_e.field_6322_g.func_35191_at().func_35764_a(p_9446_1_.field_35231_b);
      this.field_1212_e.field_6322_g.func_35191_at().func_35767_b(p_9446_1_.field_35232_c);
   }

   public void func_35777_a(Packet43Experience p_35777_1_) {
      this.field_1212_e.field_6322_g.func_35219_c(p_35777_1_.field_35230_a, p_35777_1_.field_35228_b, p_35777_1_.field_35229_c);
   }

   public void func_9448_a(Packet9Respawn p_9448_1_) {
      if(p_9448_1_.field_35244_b != this.field_1212_e.field_6322_g.field_4129_m) {
         this.field_1210_g = false;
         this.field_1211_f = new WorldClient(this, new WorldSettings(0L, p_9448_1_.field_35243_e, false, false, p_9448_1_.field_46031_f), p_9448_1_.field_35244_b, p_9448_1_.field_35245_c);
         this.field_1211_f.field_1026_y = true;
         this.field_1212_e.func_6261_a(this.field_1211_f);
         this.field_1212_e.field_6322_g.field_4129_m = p_9448_1_.field_35244_b;
         this.field_1212_e.func_6272_a(new GuiDownloadTerrain(this));
      }

      this.field_1212_e.func_6239_p(true, p_9448_1_.field_35244_b, false);
      ((PlayerControllerMP)this.field_1212_e.field_6327_b).func_35648_a(p_9448_1_.field_35243_e == 1);
   }

   public void func_12245_a(Packet60Explosion p_12245_1_) {
      Explosion var2 = new Explosion(this.field_1212_e.field_6324_e, (Entity)null, p_12245_1_.field_12236_a, p_12245_1_.field_12235_b, p_12245_1_.field_12239_c, p_12245_1_.field_12238_d);
      var2.field_12251_g = p_12245_1_.field_12237_e;
      var2.func_12247_b(true);
   }

   public void func_20087_a(Packet100OpenWindow p_20087_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      switch(p_20087_1_.field_20037_b) {
      case 0:
         var2.func_452_a(new InventoryBasic(p_20087_1_.field_20040_c, p_20087_1_.field_20039_d));
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
         break;
      case 1:
         var2.func_445_l(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
         break;
      case 2:
         var2.func_453_a(new TileEntityFurnace());
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
         break;
      case 3:
         var2.func_21092_a(new TileEntityDispenser());
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
         break;
      case 4:
         var2.func_40181_c(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
         break;
      case 5:
         var2.func_40180_a(new TileEntityBrewingStand());
         var2.field_20068_h.field_1618_c = p_20087_1_.field_20038_a;
      }

   }

   public void func_20088_a(Packet103SetSlot p_20088_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      if(p_20088_1_.field_20042_a == -1) {
         var2.field_778_b.func_20076_b(p_20088_1_.field_20043_c);
      } else if(p_20088_1_.field_20042_a == 0 && p_20088_1_.field_20041_b >= 36 && p_20088_1_.field_20041_b < 45) {
         ItemStack var3 = var2.field_20069_g.func_20118_a(p_20088_1_.field_20041_b).func_777_b();
         if(p_20088_1_.field_20043_c != null && (var3 == null || var3.field_1615_a < p_20088_1_.field_20043_c.field_1615_a)) {
            p_20088_1_.field_20043_c.field_1614_b = 5;
         }

         var2.field_20069_g.func_20119_a(p_20088_1_.field_20041_b, p_20088_1_.field_20043_c);
      } else if(p_20088_1_.field_20042_a == var2.field_20068_h.field_1618_c) {
         var2.field_20068_h.func_20119_a(p_20088_1_.field_20041_b, p_20088_1_.field_20043_c);
      }

   }

   public void func_20089_a(Packet106Transaction p_20089_1_) {
      Container var2 = null;
      EntityPlayerSP var3 = this.field_1212_e.field_6322_g;
      if(p_20089_1_.field_20029_a == 0) {
         var2 = var3.field_20069_g;
      } else if(p_20089_1_.field_20029_a == var3.field_20068_h.field_1618_c) {
         var2 = var3.field_20068_h;
      }

      if(var2 != null) {
         if(p_20089_1_.field_20030_c) {
            var2.func_20113_a(p_20089_1_.field_20028_b);
         } else {
            var2.func_20110_b(p_20089_1_.field_20028_b);
            this.func_847_a(new Packet106Transaction(p_20089_1_.field_20029_a, p_20089_1_.field_20028_b, true));
         }
      }

   }

   public void func_20094_a(Packet104WindowItems p_20094_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      if(p_20094_1_.field_20036_a == 0) {
         var2.field_20069_g.func_20115_a(p_20094_1_.field_20035_b);
      } else if(p_20094_1_.field_20036_a == var2.field_20068_h.field_1618_c) {
         var2.field_20068_h.func_20115_a(p_20094_1_.field_20035_b);
      }

   }

   public void func_20093_a(Packet130UpdateSign p_20093_1_) {
      if(this.field_1212_e.field_6324_e.func_630_d(p_20093_1_.field_20020_a, p_20093_1_.field_20019_b, p_20093_1_.field_20022_c)) {
         TileEntity var2 = this.field_1212_e.field_6324_e.func_603_b(p_20093_1_.field_20020_a, p_20093_1_.field_20019_b, p_20093_1_.field_20022_c);
         if(var2 instanceof TileEntitySign) {
            TileEntitySign var3 = (TileEntitySign)var2;
            if(var3.func_50007_a()) {
               for(int var4 = 0; var4 < 4; ++var4) {
                  var3.field_826_a[var4] = p_20093_1_.field_20021_d[var4];
               }

               var3.func_474_j_();
            }
         }
      }

   }

   public void func_48489_a(Packet132TileEntityData p_48489_1_) {
      if(this.field_1212_e.field_6324_e.func_630_d(p_48489_1_.field_48167_a, p_48489_1_.field_48165_b, p_48489_1_.field_48166_c)) {
         TileEntity var2 = this.field_1212_e.field_6324_e.func_603_b(p_48489_1_.field_48167_a, p_48489_1_.field_48165_b, p_48489_1_.field_48166_c);
         if(var2 != null && p_48489_1_.field_48163_d == 1 && var2 instanceof TileEntityMobSpawner) {
            ((TileEntityMobSpawner)var2).func_21098_a(EntityList.func_44040_a(p_48489_1_.field_48164_e));
         }
      }

   }

   public void func_20090_a(Packet105UpdateProgressbar p_20090_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      this.func_4114_b(p_20090_1_);
      if(var2.field_20068_h != null && var2.field_20068_h.field_1618_c == p_20090_1_.field_20032_a) {
         var2.field_20068_h.func_20112_a(p_20090_1_.field_20031_b, p_20090_1_.field_20033_c);
      }

   }

   public void func_843_a(Packet5PlayerInventory p_843_1_) {
      Entity var2 = this.func_12246_a(p_843_1_.field_571_a);
      if(var2 != null) {
         var2.func_20045_c(p_843_1_.field_21056_b, p_843_1_.field_570_b, p_843_1_.field_20044_c);
      }

   }

   public void func_20092_a(Packet101CloseWindow p_20092_1_) {
      this.field_1212_e.field_6322_g.func_20059_m();
   }

   public void func_21145_a(Packet54PlayNoteBlock p_21145_1_) {
      this.field_1212_e.field_6324_e.func_21116_c(p_21145_1_.field_21037_a, p_21145_1_.field_21036_b, p_21145_1_.field_21040_c, p_21145_1_.field_21039_d, p_21145_1_.field_21038_e);
   }

   public void func_25118_a(Packet70Bed p_25118_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      int var3 = p_25118_1_.field_25019_b;
      if(var3 >= 0 && var3 < Packet70Bed.field_25020_a.length && Packet70Bed.field_25020_a[var3] != null) {
         var2.func_22055_b(Packet70Bed.field_25020_a[var3]);
      }

      if(var3 == 1) {
         this.field_1211_f.func_22144_v().func_27394_b(true);
         this.field_1211_f.func_27158_h(1.0F);
      } else if(var3 == 2) {
         this.field_1211_f.func_22144_v().func_27394_b(false);
         this.field_1211_f.func_27158_h(0.0F);
      } else if(var3 == 3) {
         ((PlayerControllerMP)this.field_1212_e.field_6327_b).func_35648_a(p_25118_1_.field_35262_c == 1);
      } else if(var3 == 4) {
         this.field_1212_e.func_6272_a(new GuiWinGame());
      }

   }

   public void func_28116_a(Packet131MapData p_28116_1_) {
      if(p_28116_1_.field_28055_a == Item.field_28010_bb.field_291_aS) {
         ItemMap.func_28013_a(p_28116_1_.field_28054_b, this.field_1212_e.field_6324_e).func_28171_a(p_28116_1_.field_28056_c);
      } else {
         System.out.println("Unknown itemid: " + p_28116_1_.field_28054_b);
      }

   }

   public void func_28115_a(Packet61DoorChange p_28115_1_) {
      this.field_1212_e.field_6324_e.func_28106_e(p_28115_1_.field_28050_a, p_28115_1_.field_28053_c, p_28115_1_.field_28052_d, p_28115_1_.field_28051_e, p_28115_1_.field_28049_b);
   }

   public void func_27245_a(Packet200Statistic p_27245_1_) {
      ((EntityClientPlayerMP)this.field_1212_e.field_6322_g).func_27027_b(StatList.func_27361_a(p_27245_1_.field_27052_a), p_27245_1_.field_27051_b);
   }

   public void func_35780_a(Packet41EntityEffect p_35780_1_) {
      Entity var2 = this.func_12246_a(p_35780_1_.field_35261_a);
      if(var2 != null && var2 instanceof EntityLiving) {
         ((EntityLiving)var2).func_35165_a(new PotionEffect(p_35780_1_.field_35259_b, p_35780_1_.field_35258_d, p_35780_1_.field_35260_c));
      }
   }

   public void func_35783_a(Packet42RemoveEntityEffect p_35783_1_) {
      Entity var2 = this.func_12246_a(p_35783_1_.field_35253_a);
      if(var2 != null && var2 instanceof EntityLiving) {
         ((EntityLiving)var2).func_36002_f(p_35783_1_.field_35252_b);
      }
   }

   public boolean func_27247_c() {
      return false;
   }

   public void func_35779_a(Packet201PlayerInfo p_35779_1_) {
      GuiPlayerInfo var2 = (GuiPlayerInfo)this.field_35787_k.get(p_35779_1_.field_35257_a);
      if(var2 == null && p_35779_1_.field_35255_b) {
         var2 = new GuiPlayerInfo(p_35779_1_.field_35257_a);
         this.field_35787_k.put(p_35779_1_.field_35257_a, var2);
         this.field_35786_c.add(var2);
      }

      if(var2 != null && !p_35779_1_.field_35255_b) {
         this.field_35787_k.remove(p_35779_1_.field_35257_a);
         this.field_35786_c.remove(var2);
      }

      if(p_35779_1_.field_35255_b && var2 != null) {
         var2.field_35623_b = p_35779_1_.field_35256_c;
      }

   }

   public void func_35784_a(Packet0KeepAlive p_35784_1_) {
      this.func_847_a(new Packet0KeepAlive(p_35784_1_.field_35254_a));
   }

   public void func_50100_a(Packet202PlayerAbilities p_50100_1_) {
      EntityPlayerSP var2 = this.field_1212_e.field_6322_g;
      var2.field_35212_aW.field_35757_b = p_50100_1_.field_50070_b;
      var2.field_35212_aW.field_35756_d = p_50100_1_.field_50069_d;
      var2.field_35212_aW.field_35759_a = p_50100_1_.field_50072_a;
      var2.field_35212_aW.field_35758_c = p_50100_1_.field_50071_c;
   }
}
