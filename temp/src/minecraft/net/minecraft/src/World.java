package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCache;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ChunkProvider;
import net.minecraft.src.ChunkProviderLoadOrGenerate;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Explosion;
import net.minecraft.src.ExtendedBlockStorage;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.MapStorage;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NextTickListEntry;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathFinder;
import net.minecraft.src.Profiler;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.ThreadedFileIOBase;
import net.minecraft.src.TileEntity;
import net.minecraft.src.Vec3D;
import net.minecraft.src.VillageCollection;
import net.minecraft.src.VillageSiege;
import net.minecraft.src.WeightedRandom;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldSavedData;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public class World implements IBlockAccess {

   public boolean field_4214_a;
   public List field_1050_a;
   private List field_1024_A;
   private TreeSet field_1058_B;
   private Set field_1056_C;
   public List field_1049_b;
   private List field_30900_E;
   private List field_34900_Q;
   public List field_1040_k;
   public List field_27173_e;
   private long field_1019_F;
   public int field_1046_e;
   protected int field_9437_g;
   protected final int field_9436_h;
   protected float field_26901_B;
   protected float field_27171_C;
   protected float field_27170_D;
   protected float field_27169_E;
   protected int field_27168_F;
   public int field_27172_i;
   public boolean field_1043_h;
   private long field_1054_E;
   protected int field_9435_j;
   public int field_1039_l;
   public Random field_1037_n;
   public boolean field_1033_r;
   public final WorldProvider field_4209_q;
   protected List field_9434_r;
   protected IChunkProvider field_1017_H;
   protected final ISaveHandler field_22147_p;
   protected WorldInfo field_22145_q;
   public boolean field_9430_x;
   private boolean field_22146_A;
   public MapStorage field_28108_z;
   public final VillageCollection field_48465_A;
   private final VillageSiege field_48466_O;
   private ArrayList field_9428_I;
   private boolean field_31055_L;
   protected boolean field_21121_K;
   protected boolean field_21120_L;
   protected Set field_9427_K;
   private int field_9426_L;
   int[] field_35466_H;
   private List field_1012_M;
   public boolean field_1026_y;


   public BiomeGenBase func_48454_a(int p_48454_1_, int p_48454_2_) {
      if(this.func_630_d(p_48454_1_, 0, p_48454_2_)) {
         Chunk var3 = this.func_673_a(p_48454_1_, p_48454_2_);
         if(var3 != null) {
            return var3.func_48490_a(p_48454_1_ & 15, p_48454_2_ & 15, this.field_4209_q.field_4215_b);
         }
      }

      return this.field_4209_q.field_4215_b.func_4073_a(p_48454_1_, p_48454_2_);
   }

   public WorldChunkManager func_4075_a() {
      return this.field_4209_q.field_4215_b;
   }

   public World(ISaveHandler p_i674_1_, String p_i674_2_, WorldProvider p_i674_3_, WorldSettings p_i674_4_) {
      this.field_4214_a = false;
      this.field_1050_a = new ArrayList();
      this.field_1024_A = new ArrayList();
      this.field_1058_B = new TreeSet();
      this.field_1056_C = new HashSet();
      this.field_1049_b = new ArrayList();
      this.field_30900_E = new ArrayList();
      this.field_34900_Q = new ArrayList();
      this.field_1040_k = new ArrayList();
      this.field_27173_e = new ArrayList();
      this.field_1019_F = 16777215L;
      this.field_1046_e = 0;
      this.field_9437_g = (new Random()).nextInt();
      this.field_9436_h = 1013904223;
      this.field_27168_F = 0;
      this.field_27172_i = 0;
      this.field_1043_h = false;
      this.field_1054_E = System.currentTimeMillis();
      this.field_9435_j = 40;
      this.field_1037_n = new Random();
      this.field_1033_r = false;
      this.field_9434_r = new ArrayList();
      this.field_48465_A = new VillageCollection(this);
      this.field_48466_O = new VillageSiege(this);
      this.field_9428_I = new ArrayList();
      this.field_21121_K = true;
      this.field_21120_L = true;
      this.field_9427_K = new HashSet();
      this.field_9426_L = this.field_1037_n.nextInt(12000);
      this.field_35466_H = new int['\u8000'];
      this.field_1012_M = new ArrayList();
      this.field_1026_y = false;
      this.field_22147_p = p_i674_1_;
      this.field_22145_q = new WorldInfo(p_i674_4_, p_i674_2_);
      this.field_4209_q = p_i674_3_;
      this.field_28108_z = new MapStorage(p_i674_1_);
      p_i674_3_.func_4095_a(this);
      this.field_1017_H = this.func_4081_a();
      this.func_644_f();
      this.func_27163_E();
   }

   public World(World p_i675_1_, WorldProvider p_i675_2_) {
      this.field_4214_a = false;
      this.field_1050_a = new ArrayList();
      this.field_1024_A = new ArrayList();
      this.field_1058_B = new TreeSet();
      this.field_1056_C = new HashSet();
      this.field_1049_b = new ArrayList();
      this.field_30900_E = new ArrayList();
      this.field_34900_Q = new ArrayList();
      this.field_1040_k = new ArrayList();
      this.field_27173_e = new ArrayList();
      this.field_1019_F = 16777215L;
      this.field_1046_e = 0;
      this.field_9437_g = (new Random()).nextInt();
      this.field_9436_h = 1013904223;
      this.field_27168_F = 0;
      this.field_27172_i = 0;
      this.field_1043_h = false;
      this.field_1054_E = System.currentTimeMillis();
      this.field_9435_j = 40;
      this.field_1037_n = new Random();
      this.field_1033_r = false;
      this.field_9434_r = new ArrayList();
      this.field_48465_A = new VillageCollection(this);
      this.field_48466_O = new VillageSiege(this);
      this.field_9428_I = new ArrayList();
      this.field_21121_K = true;
      this.field_21120_L = true;
      this.field_9427_K = new HashSet();
      this.field_9426_L = this.field_1037_n.nextInt(12000);
      this.field_35466_H = new int['\u8000'];
      this.field_1012_M = new ArrayList();
      this.field_1026_y = false;
      this.field_1054_E = p_i675_1_.field_1054_E;
      this.field_22147_p = p_i675_1_.field_22147_p;
      this.field_22145_q = new WorldInfo(p_i675_1_.field_22145_q);
      this.field_28108_z = new MapStorage(this.field_22147_p);
      this.field_4209_q = p_i675_2_;
      p_i675_2_.func_4095_a(this);
      this.field_1017_H = this.func_4081_a();
      this.func_644_f();
      this.func_27163_E();
   }

   public World(ISaveHandler p_i676_1_, String p_i676_2_, WorldSettings p_i676_3_) {
      this(p_i676_1_, p_i676_2_, p_i676_3_, (WorldProvider)null);
   }

   public World(ISaveHandler p_i677_1_, String p_i677_2_, WorldSettings p_i677_3_, WorldProvider p_i677_4_) {
      this.field_4214_a = false;
      this.field_1050_a = new ArrayList();
      this.field_1024_A = new ArrayList();
      this.field_1058_B = new TreeSet();
      this.field_1056_C = new HashSet();
      this.field_1049_b = new ArrayList();
      this.field_30900_E = new ArrayList();
      this.field_34900_Q = new ArrayList();
      this.field_1040_k = new ArrayList();
      this.field_27173_e = new ArrayList();
      this.field_1019_F = 16777215L;
      this.field_1046_e = 0;
      this.field_9437_g = (new Random()).nextInt();
      this.field_9436_h = 1013904223;
      this.field_27168_F = 0;
      this.field_27172_i = 0;
      this.field_1043_h = false;
      this.field_1054_E = System.currentTimeMillis();
      this.field_9435_j = 40;
      this.field_1037_n = new Random();
      this.field_1033_r = false;
      this.field_9434_r = new ArrayList();
      this.field_48465_A = new VillageCollection(this);
      this.field_48466_O = new VillageSiege(this);
      this.field_9428_I = new ArrayList();
      this.field_21121_K = true;
      this.field_21120_L = true;
      this.field_9427_K = new HashSet();
      this.field_9426_L = this.field_1037_n.nextInt(12000);
      this.field_35466_H = new int['\u8000'];
      this.field_1012_M = new ArrayList();
      this.field_1026_y = false;
      this.field_22147_p = p_i677_1_;
      this.field_28108_z = new MapStorage(p_i677_1_);
      this.field_22145_q = p_i677_1_.func_22151_c();
      this.field_1033_r = this.field_22145_q == null;
      if(p_i677_4_ != null) {
         this.field_4209_q = p_i677_4_;
      } else if(this.field_22145_q != null && this.field_22145_q.func_22290_i() != 0) {
         this.field_4209_q = WorldProvider.func_4101_a(this.field_22145_q.func_22290_i());
      } else {
         this.field_4209_q = WorldProvider.func_4101_a(0);
      }

      boolean var5 = false;
      if(this.field_22145_q == null) {
         this.field_22145_q = new WorldInfo(p_i677_3_, p_i677_2_);
         var5 = true;
      } else {
         this.field_22145_q.func_22287_a(p_i677_2_);
      }

      this.field_4209_q.func_4095_a(this);
      this.field_1017_H = this.func_4081_a();
      if(var5) {
         this.func_25098_c();
      }

      this.func_644_f();
      this.func_27163_E();
   }

   protected IChunkProvider func_4081_a() {
      IChunkLoader var1 = this.field_22147_p.func_22149_a(this.field_4209_q);
      return new ChunkProvider(this, var1, this.field_4209_q.func_4094_c());
   }

   protected void func_25098_c() {
      if(!this.field_4209_q.func_6477_d()) {
         this.field_22145_q.func_22292_a(0, this.field_4209_q.func_46066_g(), 0);
      } else {
         this.field_9430_x = true;
         WorldChunkManager var1 = this.field_4209_q.field_4215_b;
         List var2 = var1.func_35559_a();
         Random var3 = new Random(this.func_22138_q());
         ChunkPosition var4 = var1.func_35556_a(0, 0, 256, var2, var3);
         int var5 = 0;
         int var6 = this.field_4209_q.func_46066_g();
         int var7 = 0;
         if(var4 != null) {
            var5 = var4.field_1111_a;
            var7 = var4.field_1112_c;
         } else {
            System.out.println("Unable to find spawn biome");
         }

         int var8 = 0;

         while(!this.field_4209_q.func_4102_a(var5, var7)) {
            var5 += var3.nextInt(64) - var3.nextInt(64);
            var7 += var3.nextInt(64) - var3.nextInt(64);
            ++var8;
            if(var8 == 1000) {
               break;
            }
         }

         this.field_22145_q.func_22292_a(var5, var6, var7);
         this.field_9430_x = false;
      }
   }

   public ChunkCoordinates func_40472_j() {
      return this.field_4209_q.func_40469_f();
   }

   public void func_4076_b() {
      if(this.field_22145_q.func_22295_d() <= 0) {
         this.field_22145_q.func_22308_b(64);
      }

      int var1 = this.field_22145_q.func_22293_c();
      int var2 = this.field_22145_q.func_22300_e();
      int var3 = 0;

      while(this.func_614_g(var1, var2) == 0) {
         var1 += this.field_1037_n.nextInt(8) - this.field_1037_n.nextInt(8);
         var2 += this.field_1037_n.nextInt(8) - this.field_1037_n.nextInt(8);
         ++var3;
         if(var3 == 10000) {
            break;
         }
      }

      this.field_22145_q.func_22294_a(var1);
      this.field_22145_q.func_22298_c(var2);
   }

   public int func_614_g(int p_614_1_, int p_614_2_) {
      int var3;
      for(var3 = 63; !this.func_20084_d(p_614_1_, var3 + 1, p_614_2_); ++var3) {
         ;
      }

      return this.func_600_a(p_614_1_, var3, p_614_2_);
   }

   public void func_6464_c() {}

   public void func_608_a(EntityPlayer p_608_1_) {
      try {
         NBTTagCompound var2 = this.field_22145_q.func_22303_h();
         if(var2 != null) {
            p_608_1_.func_368_e(var2);
            this.field_22145_q.func_22309_a((NBTTagCompound)null);
         }

         if(this.field_1017_H instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var3 = (ChunkProviderLoadOrGenerate)this.field_1017_H;
            int var4 = MathHelper.func_1110_d((float)((int)p_608_1_.field_611_ak)) >> 4;
            int var5 = MathHelper.func_1110_d((float)((int)p_608_1_.field_609_am)) >> 4;
            var3.func_21110_c(var4, var5);
         }

         this.func_674_a(p_608_1_);
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public void func_639_a(boolean p_639_1_, IProgressUpdate p_639_2_) {
      if(this.field_1017_H.func_536_b()) {
         if(p_639_2_ != null) {
            p_639_2_.func_594_b("Saving level");
         }

         this.func_669_m();
         if(p_639_2_ != null) {
            p_639_2_.func_595_d("Saving chunks");
         }

         this.field_1017_H.func_535_a(p_639_1_, p_639_2_);
      }
   }

   private void func_669_m() {
      this.func_663_l();
      this.field_22147_p.func_22148_a(this.field_22145_q, this.field_1040_k);
      this.field_28108_z.func_28188_a();
   }

   public boolean func_650_a(int p_650_1_) {
      if(!this.field_1017_H.func_536_b()) {
         return true;
      } else {
         if(p_650_1_ == 0) {
            this.func_669_m();
         }

         return this.field_1017_H.func_535_a(false, (IProgressUpdate)null);
      }
   }

   public int func_600_a(int p_600_1_, int p_600_2_, int p_600_3_) {
      return p_600_1_ >= -30000000 && p_600_3_ >= -30000000 && p_600_1_ < 30000000 && p_600_3_ < 30000000?(p_600_2_ < 0?0:(p_600_2_ >= 256?0:this.func_704_b(p_600_1_ >> 4, p_600_3_ >> 4).func_1008_a(p_600_1_ & 15, p_600_2_, p_600_3_ & 15))):0;
   }

   public int func_48462_d(int p_48462_1_, int p_48462_2_, int p_48462_3_) {
      return p_48462_1_ >= -30000000 && p_48462_3_ >= -30000000 && p_48462_1_ < 30000000 && p_48462_3_ < 30000000?(p_48462_2_ < 0?0:(p_48462_2_ >= 256?0:this.func_704_b(p_48462_1_ >> 4, p_48462_3_ >> 4).func_48499_b(p_48462_1_ & 15, p_48462_2_, p_48462_3_ & 15))):0;
   }

   public boolean func_20084_d(int p_20084_1_, int p_20084_2_, int p_20084_3_) {
      return this.func_600_a(p_20084_1_, p_20084_2_, p_20084_3_) == 0;
   }

   public boolean func_630_d(int p_630_1_, int p_630_2_, int p_630_3_) {
      return p_630_2_ >= 0 && p_630_2_ < 256?this.func_620_h(p_630_1_ >> 4, p_630_3_ >> 4):false;
   }

   public boolean func_21117_a(int p_21117_1_, int p_21117_2_, int p_21117_3_, int p_21117_4_) {
      return this.func_640_a(p_21117_1_ - p_21117_4_, p_21117_2_ - p_21117_4_, p_21117_3_ - p_21117_4_, p_21117_1_ + p_21117_4_, p_21117_2_ + p_21117_4_, p_21117_3_ + p_21117_4_);
   }

   public boolean func_640_a(int p_640_1_, int p_640_2_, int p_640_3_, int p_640_4_, int p_640_5_, int p_640_6_) {
      if(p_640_5_ >= 0 && p_640_2_ < 256) {
         p_640_1_ >>= 4;
         p_640_3_ >>= 4;
         p_640_4_ >>= 4;
         p_640_6_ >>= 4;

         for(int var7 = p_640_1_; var7 <= p_640_4_; ++var7) {
            for(int var8 = p_640_3_; var8 <= p_640_6_; ++var8) {
               if(!this.func_620_h(var7, var8)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean func_620_h(int p_620_1_, int p_620_2_) {
      return this.field_1017_H.func_537_a(p_620_1_, p_620_2_);
   }

   public Chunk func_673_a(int p_673_1_, int p_673_2_) {
      return this.func_704_b(p_673_1_ >> 4, p_673_2_ >> 4);
   }

   public Chunk func_704_b(int p_704_1_, int p_704_2_) {
      return this.field_1017_H.func_533_b(p_704_1_, p_704_2_);
   }

   public boolean func_643_a(int p_643_1_, int p_643_2_, int p_643_3_, int p_643_4_, int p_643_5_) {
      if(p_643_1_ >= -30000000 && p_643_3_ >= -30000000 && p_643_1_ < 30000000 && p_643_3_ < 30000000) {
         if(p_643_2_ < 0) {
            return false;
         } else if(p_643_2_ >= 256) {
            return false;
         } else {
            Chunk var6 = this.func_704_b(p_643_1_ >> 4, p_643_3_ >> 4);
            boolean var7 = var6.func_1010_a(p_643_1_ & 15, p_643_2_, p_643_3_ & 15, p_643_4_, p_643_5_);
            Profiler.func_40663_a("checkLight");
            this.func_35463_p(p_643_1_, p_643_2_, p_643_3_);
            Profiler.func_40662_b();
            return var7;
         }
      } else {
         return false;
      }
   }

   public boolean func_634_a(int p_634_1_, int p_634_2_, int p_634_3_, int p_634_4_) {
      if(p_634_1_ >= -30000000 && p_634_3_ >= -30000000 && p_634_1_ < 30000000 && p_634_3_ < 30000000) {
         if(p_634_2_ < 0) {
            return false;
         } else if(p_634_2_ >= 256) {
            return false;
         } else {
            Chunk var5 = this.func_704_b(p_634_1_ >> 4, p_634_3_ >> 4);
            boolean var6 = var5.func_1022_a(p_634_1_ & 15, p_634_2_, p_634_3_ & 15, p_634_4_);
            Profiler.func_40663_a("checkLight");
            this.func_35463_p(p_634_1_, p_634_2_, p_634_3_);
            Profiler.func_40662_b();
            return var6;
         }
      } else {
         return false;
      }
   }

   public Material func_599_f(int p_599_1_, int p_599_2_, int p_599_3_) {
      int var4 = this.func_600_a(p_599_1_, p_599_2_, p_599_3_);
      return var4 == 0?Material.field_1337_a:Block.field_345_n[var4].field_356_bn;
   }

   public int func_602_e(int p_602_1_, int p_602_2_, int p_602_3_) {
      if(p_602_1_ >= -30000000 && p_602_3_ >= -30000000 && p_602_1_ < 30000000 && p_602_3_ < 30000000) {
         if(p_602_2_ < 0) {
            return 0;
         } else if(p_602_2_ >= 256) {
            return 0;
         } else {
            Chunk var4 = this.func_704_b(p_602_1_ >> 4, p_602_3_ >> 4);
            p_602_1_ &= 15;
            p_602_3_ &= 15;
            return var4.func_1021_b(p_602_1_, p_602_2_, p_602_3_);
         }
      } else {
         return 0;
      }
   }

   public void func_691_b(int p_691_1_, int p_691_2_, int p_691_3_, int p_691_4_) {
      if(this.func_635_c(p_691_1_, p_691_2_, p_691_3_, p_691_4_)) {
         int var5 = this.func_600_a(p_691_1_, p_691_2_, p_691_3_);
         if(Block.field_28032_t[var5 & 4095]) {
            this.func_617_e(p_691_1_, p_691_2_, p_691_3_, var5);
         } else {
            this.func_611_g(p_691_1_, p_691_2_, p_691_3_, var5);
         }
      }

   }

   public boolean func_635_c(int p_635_1_, int p_635_2_, int p_635_3_, int p_635_4_) {
      if(p_635_1_ >= -30000000 && p_635_3_ >= -30000000 && p_635_1_ < 30000000 && p_635_3_ < 30000000) {
         if(p_635_2_ < 0) {
            return false;
         } else if(p_635_2_ >= 256) {
            return false;
         } else {
            Chunk var5 = this.func_704_b(p_635_1_ >> 4, p_635_3_ >> 4);
            p_635_1_ &= 15;
            p_635_3_ &= 15;
            return var5.func_1009_b(p_635_1_, p_635_2_, p_635_3_, p_635_4_);
         }
      } else {
         return false;
      }
   }

   public boolean func_690_d(int p_690_1_, int p_690_2_, int p_690_3_, int p_690_4_) {
      if(this.func_634_a(p_690_1_, p_690_2_, p_690_3_, p_690_4_)) {
         this.func_617_e(p_690_1_, p_690_2_, p_690_3_, p_690_4_);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_688_b(int p_688_1_, int p_688_2_, int p_688_3_, int p_688_4_, int p_688_5_) {
      if(this.func_643_a(p_688_1_, p_688_2_, p_688_3_, p_688_4_, p_688_5_)) {
         this.func_617_e(p_688_1_, p_688_2_, p_688_3_, p_688_4_);
         return true;
      } else {
         return false;
      }
   }

   public void func_665_h(int p_665_1_, int p_665_2_, int p_665_3_) {
      for(int var4 = 0; var4 < this.field_9434_r.size(); ++var4) {
         ((IWorldAccess)this.field_9434_r.get(var4)).func_934_a(p_665_1_, p_665_2_, p_665_3_);
      }

   }

   public void func_617_e(int p_617_1_, int p_617_2_, int p_617_3_, int p_617_4_) {
      this.func_665_h(p_617_1_, p_617_2_, p_617_3_);
      this.func_611_g(p_617_1_, p_617_2_, p_617_3_, p_617_4_);
   }

   public void func_680_f(int p_680_1_, int p_680_2_, int p_680_3_, int p_680_4_) {
      int var5;
      if(p_680_3_ > p_680_4_) {
         var5 = p_680_4_;
         p_680_4_ = p_680_3_;
         p_680_3_ = var5;
      }

      if(!this.field_4209_q.field_6478_e) {
         for(var5 = p_680_3_; var5 <= p_680_4_; ++var5) {
            this.func_35459_c(EnumSkyBlock.Sky, p_680_1_, var5, p_680_2_);
         }
      }

      this.func_701_b(p_680_1_, p_680_3_, p_680_2_, p_680_1_, p_680_4_, p_680_2_);
   }

   public void func_21115_j(int p_21115_1_, int p_21115_2_, int p_21115_3_) {
      for(int var4 = 0; var4 < this.field_9434_r.size(); ++var4) {
         ((IWorldAccess)this.field_9434_r.get(var4)).func_937_b(p_21115_1_, p_21115_2_, p_21115_3_, p_21115_1_, p_21115_2_, p_21115_3_);
      }

   }

   public void func_701_b(int p_701_1_, int p_701_2_, int p_701_3_, int p_701_4_, int p_701_5_, int p_701_6_) {
      for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
         ((IWorldAccess)this.field_9434_r.get(var7)).func_937_b(p_701_1_, p_701_2_, p_701_3_, p_701_4_, p_701_5_, p_701_6_);
      }

   }

   public void func_611_g(int p_611_1_, int p_611_2_, int p_611_3_, int p_611_4_) {
      this.func_655_l(p_611_1_ - 1, p_611_2_, p_611_3_, p_611_4_);
      this.func_655_l(p_611_1_ + 1, p_611_2_, p_611_3_, p_611_4_);
      this.func_655_l(p_611_1_, p_611_2_ - 1, p_611_3_, p_611_4_);
      this.func_655_l(p_611_1_, p_611_2_ + 1, p_611_3_, p_611_4_);
      this.func_655_l(p_611_1_, p_611_2_, p_611_3_ - 1, p_611_4_);
      this.func_655_l(p_611_1_, p_611_2_, p_611_3_ + 1, p_611_4_);
   }

   private void func_655_l(int p_655_1_, int p_655_2_, int p_655_3_, int p_655_4_) {
      if(!this.field_1043_h && !this.field_1026_y) {
         Block var5 = Block.field_345_n[this.func_600_a(p_655_1_, p_655_2_, p_655_3_)];
         if(var5 != null) {
            var5.func_226_a(this, p_655_1_, p_655_2_, p_655_3_, p_655_4_);
         }

      }
   }

   public boolean func_647_i(int p_647_1_, int p_647_2_, int p_647_3_) {
      return this.func_704_b(p_647_1_ >> 4, p_647_3_ >> 4).func_1007_c(p_647_1_ & 15, p_647_2_, p_647_3_ & 15);
   }

   public int func_28104_m(int p_28104_1_, int p_28104_2_, int p_28104_3_) {
      if(p_28104_2_ < 0) {
         return 0;
      } else {
         if(p_28104_2_ >= 256) {
            p_28104_2_ = 255;
         }

         return this.func_704_b(p_28104_1_ >> 4, p_28104_3_ >> 4).func_1019_c(p_28104_1_ & 15, p_28104_2_, p_28104_3_ & 15, 0);
      }
   }

   public int func_618_j(int p_618_1_, int p_618_2_, int p_618_3_) {
      return this.func_699_a(p_618_1_, p_618_2_, p_618_3_, true);
   }

   public int func_699_a(int p_699_1_, int p_699_2_, int p_699_3_, boolean p_699_4_) {
      if(p_699_1_ >= -30000000 && p_699_3_ >= -30000000 && p_699_1_ < 30000000 && p_699_3_ < 30000000) {
         if(p_699_4_) {
            int var5 = this.func_600_a(p_699_1_, p_699_2_, p_699_3_);
            if(var5 == Block.field_410_al.field_376_bc || var5 == Block.field_446_aB.field_376_bc || var5 == Block.field_4069_aI.field_376_bc || var5 == Block.field_4059_au.field_376_bc) {
               int var6 = this.func_699_a(p_699_1_, p_699_2_ + 1, p_699_3_, false);
               int var7 = this.func_699_a(p_699_1_ + 1, p_699_2_, p_699_3_, false);
               int var8 = this.func_699_a(p_699_1_ - 1, p_699_2_, p_699_3_, false);
               int var9 = this.func_699_a(p_699_1_, p_699_2_, p_699_3_ + 1, false);
               int var10 = this.func_699_a(p_699_1_, p_699_2_, p_699_3_ - 1, false);
               if(var7 > var6) {
                  var6 = var7;
               }

               if(var8 > var6) {
                  var6 = var8;
               }

               if(var9 > var6) {
                  var6 = var9;
               }

               if(var10 > var6) {
                  var6 = var10;
               }

               return var6;
            }
         }

         if(p_699_2_ < 0) {
            return 0;
         } else {
            if(p_699_2_ >= 256) {
               p_699_2_ = 255;
            }

            Chunk var11 = this.func_704_b(p_699_1_ >> 4, p_699_3_ >> 4);
            p_699_1_ &= 15;
            p_699_3_ &= 15;
            return var11.func_1019_c(p_699_1_, p_699_2_, p_699_3_, this.field_1046_e);
         }
      } else {
         return 15;
      }
   }

   public int func_666_c(int p_666_1_, int p_666_2_) {
      if(p_666_1_ >= -30000000 && p_666_2_ >= -30000000 && p_666_1_ < 30000000 && p_666_2_ < 30000000) {
         if(!this.func_620_h(p_666_1_ >> 4, p_666_2_ >> 4)) {
            return 0;
         } else {
            Chunk var3 = this.func_704_b(p_666_1_ >> 4, p_666_2_ >> 4);
            return var3.func_999_b(p_666_1_ & 15, p_666_2_ & 15);
         }
      } else {
         return 0;
      }
   }

   public int func_35457_a(EnumSkyBlock p_35457_1_, int p_35457_2_, int p_35457_3_, int p_35457_4_) {
      if(this.field_4209_q.field_6478_e && p_35457_1_ == EnumSkyBlock.Sky) {
         return 0;
      } else {
         if(p_35457_3_ < 0) {
            p_35457_3_ = 0;
         }

         if(p_35457_3_ >= 256) {
            return p_35457_1_.field_1722_c;
         } else if(p_35457_2_ >= -30000000 && p_35457_4_ >= -30000000 && p_35457_2_ < 30000000 && p_35457_4_ < 30000000) {
            int var5 = p_35457_2_ >> 4;
            int var6 = p_35457_4_ >> 4;
            if(!this.func_620_h(var5, var6)) {
               return p_35457_1_.field_1722_c;
            } else if(Block.field_40201_bL[this.func_600_a(p_35457_2_, p_35457_3_, p_35457_4_)]) {
               int var12 = this.func_641_a(p_35457_1_, p_35457_2_, p_35457_3_ + 1, p_35457_4_);
               int var8 = this.func_641_a(p_35457_1_, p_35457_2_ + 1, p_35457_3_, p_35457_4_);
               int var9 = this.func_641_a(p_35457_1_, p_35457_2_ - 1, p_35457_3_, p_35457_4_);
               int var10 = this.func_641_a(p_35457_1_, p_35457_2_, p_35457_3_, p_35457_4_ + 1);
               int var11 = this.func_641_a(p_35457_1_, p_35457_2_, p_35457_3_, p_35457_4_ - 1);
               if(var8 > var12) {
                  var12 = var8;
               }

               if(var9 > var12) {
                  var12 = var9;
               }

               if(var10 > var12) {
                  var12 = var10;
               }

               if(var11 > var12) {
                  var12 = var11;
               }

               return var12;
            } else {
               Chunk var7 = this.func_704_b(var5, var6);
               return var7.func_1025_a(p_35457_1_, p_35457_2_ & 15, p_35457_3_, p_35457_4_ & 15);
            }
         } else {
            return p_35457_1_.field_1722_c;
         }
      }
   }

   public int func_641_a(EnumSkyBlock p_641_1_, int p_641_2_, int p_641_3_, int p_641_4_) {
      if(p_641_3_ < 0) {
         p_641_3_ = 0;
      }

      if(p_641_3_ >= 256) {
         p_641_3_ = 255;
      }

      if(p_641_2_ >= -30000000 && p_641_4_ >= -30000000 && p_641_2_ < 30000000 && p_641_4_ < 30000000) {
         int var5 = p_641_2_ >> 4;
         int var6 = p_641_4_ >> 4;
         if(!this.func_620_h(var5, var6)) {
            return p_641_1_.field_1722_c;
         } else {
            Chunk var7 = this.func_704_b(var5, var6);
            return var7.func_1025_a(p_641_1_, p_641_2_ & 15, p_641_3_, p_641_4_ & 15);
         }
      } else {
         return p_641_1_.field_1722_c;
      }
   }

   public void func_664_b(EnumSkyBlock p_664_1_, int p_664_2_, int p_664_3_, int p_664_4_, int p_664_5_) {
      if(p_664_2_ >= -30000000 && p_664_4_ >= -30000000 && p_664_2_ < 30000000 && p_664_4_ < 30000000) {
         if(p_664_3_ >= 0) {
            if(p_664_3_ < 256) {
               if(this.func_620_h(p_664_2_ >> 4, p_664_4_ >> 4)) {
                  Chunk var6 = this.func_704_b(p_664_2_ >> 4, p_664_4_ >> 4);
                  var6.func_1011_a(p_664_1_, p_664_2_ & 15, p_664_3_, p_664_4_ & 15, p_664_5_);

                  for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
                     ((IWorldAccess)this.field_9434_r.get(var7)).func_48180_b(p_664_2_, p_664_3_, p_664_4_);
                  }

               }
            }
         }
      }
   }

   public void func_48464_p(int p_48464_1_, int p_48464_2_, int p_48464_3_) {
      for(int var4 = 0; var4 < this.field_9434_r.size(); ++var4) {
         ((IWorldAccess)this.field_9434_r.get(var4)).func_48180_b(p_48464_1_, p_48464_2_, p_48464_3_);
      }

   }

   public int func_35451_b(int p_35451_1_, int p_35451_2_, int p_35451_3_, int p_35451_4_) {
      int var5 = this.func_35457_a(EnumSkyBlock.Sky, p_35451_1_, p_35451_2_, p_35451_3_);
      int var6 = this.func_35457_a(EnumSkyBlock.Block, p_35451_1_, p_35451_2_, p_35451_3_);
      if(var6 < p_35451_4_) {
         var6 = p_35451_4_;
      }

      return var5 << 20 | var6 << 4;
   }

   public float func_28099_a(int p_28099_1_, int p_28099_2_, int p_28099_3_, int p_28099_4_) {
      int var5 = this.func_618_j(p_28099_1_, p_28099_2_, p_28099_3_);
      if(var5 < p_28099_4_) {
         var5 = p_28099_4_;
      }

      return this.field_4209_q.field_4219_d[var5];
   }

   public float func_598_c(int p_598_1_, int p_598_2_, int p_598_3_) {
      return this.field_4209_q.field_4219_d[this.func_618_j(p_598_1_, p_598_2_, p_598_3_)];
   }

   public boolean func_624_b() {
      return this.field_1046_e < 4;
   }

   public MovingObjectPosition func_645_a(Vec3D p_645_1_, Vec3D p_645_2_) {
      return this.func_28105_a(p_645_1_, p_645_2_, false, false);
   }

   public MovingObjectPosition func_642_a(Vec3D p_642_1_, Vec3D p_642_2_, boolean p_642_3_) {
      return this.func_28105_a(p_642_1_, p_642_2_, p_642_3_, false);
   }

   public MovingObjectPosition func_28105_a(Vec3D p_28105_1_, Vec3D p_28105_2_, boolean p_28105_3_, boolean p_28105_4_) {
      if(!Double.isNaN(p_28105_1_.field_1776_a) && !Double.isNaN(p_28105_1_.field_1775_b) && !Double.isNaN(p_28105_1_.field_1779_c)) {
         if(!Double.isNaN(p_28105_2_.field_1776_a) && !Double.isNaN(p_28105_2_.field_1775_b) && !Double.isNaN(p_28105_2_.field_1779_c)) {
            int var5 = MathHelper.func_1108_b(p_28105_2_.field_1776_a);
            int var6 = MathHelper.func_1108_b(p_28105_2_.field_1775_b);
            int var7 = MathHelper.func_1108_b(p_28105_2_.field_1779_c);
            int var8 = MathHelper.func_1108_b(p_28105_1_.field_1776_a);
            int var9 = MathHelper.func_1108_b(p_28105_1_.field_1775_b);
            int var10 = MathHelper.func_1108_b(p_28105_1_.field_1779_c);
            int var11 = this.func_600_a(var8, var9, var10);
            int var12 = this.func_602_e(var8, var9, var10);
            Block var13 = Block.field_345_n[var11];
            if((!p_28105_4_ || var13 == null || var13.func_221_d(this, var8, var9, var10) != null) && var11 > 0 && var13.func_224_a(var12, p_28105_3_)) {
               MovingObjectPosition var14 = var13.func_255_a(this, var8, var9, var10, p_28105_1_, p_28105_2_);
               if(var14 != null) {
                  return var14;
               }
            }

            var11 = 200;

            while(var11-- >= 0) {
               if(Double.isNaN(p_28105_1_.field_1776_a) || Double.isNaN(p_28105_1_.field_1775_b) || Double.isNaN(p_28105_1_.field_1779_c)) {
                  return null;
               }

               if(var8 == var5 && var9 == var6 && var10 == var7) {
                  return null;
               }

               boolean var39 = true;
               boolean var40 = true;
               boolean var41 = true;
               double var15 = 999.0D;
               double var17 = 999.0D;
               double var19 = 999.0D;
               if(var5 > var8) {
                  var15 = (double)var8 + 1.0D;
               } else if(var5 < var8) {
                  var15 = (double)var8 + 0.0D;
               } else {
                  var39 = false;
               }

               if(var6 > var9) {
                  var17 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var17 = (double)var9 + 0.0D;
               } else {
                  var40 = false;
               }

               if(var7 > var10) {
                  var19 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var19 = (double)var10 + 0.0D;
               } else {
                  var41 = false;
               }

               double var21 = 999.0D;
               double var23 = 999.0D;
               double var25 = 999.0D;
               double var27 = p_28105_2_.field_1776_a - p_28105_1_.field_1776_a;
               double var29 = p_28105_2_.field_1775_b - p_28105_1_.field_1775_b;
               double var31 = p_28105_2_.field_1779_c - p_28105_1_.field_1779_c;
               if(var39) {
                  var21 = (var15 - p_28105_1_.field_1776_a) / var27;
               }

               if(var40) {
                  var23 = (var17 - p_28105_1_.field_1775_b) / var29;
               }

               if(var41) {
                  var25 = (var19 - p_28105_1_.field_1779_c) / var31;
               }

               boolean var33 = false;
               byte var42;
               if(var21 < var23 && var21 < var25) {
                  if(var5 > var8) {
                     var42 = 4;
                  } else {
                     var42 = 5;
                  }

                  p_28105_1_.field_1776_a = var15;
                  p_28105_1_.field_1775_b += var29 * var21;
                  p_28105_1_.field_1779_c += var31 * var21;
               } else if(var23 < var25) {
                  if(var6 > var9) {
                     var42 = 0;
                  } else {
                     var42 = 1;
                  }

                  p_28105_1_.field_1776_a += var27 * var23;
                  p_28105_1_.field_1775_b = var17;
                  p_28105_1_.field_1779_c += var31 * var23;
               } else {
                  if(var7 > var10) {
                     var42 = 2;
                  } else {
                     var42 = 3;
                  }

                  p_28105_1_.field_1776_a += var27 * var25;
                  p_28105_1_.field_1775_b += var29 * var25;
                  p_28105_1_.field_1779_c = var19;
               }

               Vec3D var34 = Vec3D.func_1248_b(p_28105_1_.field_1776_a, p_28105_1_.field_1775_b, p_28105_1_.field_1779_c);
               var8 = (int)(var34.field_1776_a = (double)MathHelper.func_1108_b(p_28105_1_.field_1776_a));
               if(var42 == 5) {
                  --var8;
                  ++var34.field_1776_a;
               }

               var9 = (int)(var34.field_1775_b = (double)MathHelper.func_1108_b(p_28105_1_.field_1775_b));
               if(var42 == 1) {
                  --var9;
                  ++var34.field_1775_b;
               }

               var10 = (int)(var34.field_1779_c = (double)MathHelper.func_1108_b(p_28105_1_.field_1779_c));
               if(var42 == 3) {
                  --var10;
                  ++var34.field_1779_c;
               }

               int var35 = this.func_600_a(var8, var9, var10);
               int var36 = this.func_602_e(var8, var9, var10);
               Block var37 = Block.field_345_n[var35];
               if((!p_28105_4_ || var37 == null || var37.func_221_d(this, var8, var9, var10) != null) && var35 > 0 && var37.func_224_a(var36, p_28105_3_)) {
                  MovingObjectPosition var38 = var37.func_255_a(this, var8, var9, var10, p_28105_1_, p_28105_2_);
                  if(var38 != null) {
                     return var38;
                  }
               }
            }

            return null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void func_623_a(Entity p_623_1_, String p_623_2_, float p_623_3_, float p_623_4_) {
      for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
         ((IWorldAccess)this.field_9434_r.get(var5)).func_940_a(p_623_2_, p_623_1_.field_611_ak, p_623_1_.field_610_al - (double)p_623_1_.field_9292_aO, p_623_1_.field_609_am, p_623_3_, p_623_4_);
      }

   }

   public void func_684_a(double p_684_1_, double p_684_3_, double p_684_5_, String p_684_7_, float p_684_8_, float p_684_9_) {
      for(int var10 = 0; var10 < this.field_9434_r.size(); ++var10) {
         ((IWorldAccess)this.field_9434_r.get(var10)).func_940_a(p_684_7_, p_684_1_, p_684_3_, p_684_5_, p_684_8_, p_684_9_);
      }

   }

   public void func_670_a(String p_670_1_, int p_670_2_, int p_670_3_, int p_670_4_) {
      for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
         ((IWorldAccess)this.field_9434_r.get(var5)).func_933_a(p_670_1_, p_670_2_, p_670_3_, p_670_4_);
      }

   }

   public void func_694_a(String p_694_1_, double p_694_2_, double p_694_4_, double p_694_6_, double p_694_8_, double p_694_10_, double p_694_12_) {
      for(int var14 = 0; var14 < this.field_9434_r.size(); ++var14) {
         ((IWorldAccess)this.field_9434_r.get(var14)).func_939_a(p_694_1_, p_694_2_, p_694_4_, p_694_6_, p_694_8_, p_694_10_, p_694_12_);
      }

   }

   public boolean func_27159_a(Entity p_27159_1_) {
      this.field_27173_e.add(p_27159_1_);
      return true;
   }

   public boolean func_674_a(Entity p_674_1_) {
      int var2 = MathHelper.func_1108_b(p_674_1_.field_611_ak / 16.0D);
      int var3 = MathHelper.func_1108_b(p_674_1_.field_609_am / 16.0D);
      boolean var4 = false;
      if(p_674_1_ instanceof EntityPlayer) {
         var4 = true;
      }

      if(!var4 && !this.func_620_h(var2, var3)) {
         return false;
      } else {
         if(p_674_1_ instanceof EntityPlayer) {
            EntityPlayer var5 = (EntityPlayer)p_674_1_;
            this.field_1040_k.add(var5);
            this.func_22140_w();
         }

         this.func_704_b(var2, var3).func_1000_a(p_674_1_);
         this.field_1050_a.add(p_674_1_);
         this.func_606_b(p_674_1_);
         return true;
      }
   }

   protected void func_606_b(Entity p_606_1_) {
      for(int var2 = 0; var2 < this.field_9434_r.size(); ++var2) {
         ((IWorldAccess)this.field_9434_r.get(var2)).func_941_a(p_606_1_);
      }

   }

   protected void func_678_c(Entity p_678_1_) {
      for(int var2 = 0; var2 < this.field_9434_r.size(); ++var2) {
         ((IWorldAccess)this.field_9434_r.get(var2)).func_938_b(p_678_1_);
      }

   }

   public void func_607_d(Entity p_607_1_) {
      if(p_607_1_.field_617_ae != null) {
         p_607_1_.field_617_ae.func_6377_h((Entity)null);
      }

      if(p_607_1_.field_616_af != null) {
         p_607_1_.func_6377_h((Entity)null);
      }

      p_607_1_.func_395_F();
      if(p_607_1_ instanceof EntityPlayer) {
         this.field_1040_k.remove((EntityPlayer)p_607_1_);
         this.func_22140_w();
      }

   }

   public void func_613_a(IWorldAccess p_613_1_) {
      this.field_9434_r.add(p_613_1_);
   }

   public void func_672_b(IWorldAccess p_672_1_) {
      this.field_9434_r.remove(p_672_1_);
   }

   public List func_697_a(Entity p_697_1_, AxisAlignedBB p_697_2_) {
      this.field_9428_I.clear();
      int var3 = MathHelper.func_1108_b(p_697_2_.field_1698_a);
      int var4 = MathHelper.func_1108_b(p_697_2_.field_1703_d + 1.0D);
      int var5 = MathHelper.func_1108_b(p_697_2_.field_1697_b);
      int var6 = MathHelper.func_1108_b(p_697_2_.field_1702_e + 1.0D);
      int var7 = MathHelper.func_1108_b(p_697_2_.field_1704_c);
      int var8 = MathHelper.func_1108_b(p_697_2_.field_1701_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var7; var10 < var8; ++var10) {
            if(this.func_630_d(var9, 64, var10)) {
               for(int var11 = var5 - 1; var11 < var6; ++var11) {
                  Block var12 = Block.field_345_n[this.func_600_a(var9, var11, var10)];
                  if(var12 != null) {
                     var12.func_230_a(this, var9, var11, var10, p_697_2_, this.field_9428_I);
                  }
               }
            }
         }
      }

      double var14 = 0.25D;
      List var15 = this.func_659_b(p_697_1_, p_697_2_.func_1177_b(var14, var14, var14));

      for(int var16 = 0; var16 < var15.size(); ++var16) {
         AxisAlignedBB var13 = ((Entity)var15.get(var16)).func_372_f_();
         if(var13 != null && var13.func_1178_a(p_697_2_)) {
            this.field_9428_I.add(var13);
         }

         var13 = p_697_1_.func_383_b_((Entity)var15.get(var16));
         if(var13 != null && var13.func_1178_a(p_697_2_)) {
            this.field_9428_I.add(var13);
         }
      }

      return this.field_9428_I;
   }

   public int func_671_a(float p_671_1_) {
      float var2 = this.func_619_c(p_671_1_);
      float var3 = 1.0F - (MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_27162_g(p_671_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_27166_f(p_671_1_) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float func_35464_b(float p_35464_1_) {
      float var2 = this.func_619_c(p_35464_1_);
      float var3 = 1.0F - (MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_27162_g(p_35464_1_) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.func_27166_f(p_35464_1_) * 5.0F) / 16.0D));
      return var3 * 0.8F + 0.2F;
   }

   public Vec3D func_4079_a(Entity p_4079_1_, float p_4079_2_) {
      float var3 = this.func_619_c(p_4079_2_);
      float var4 = MathHelper.func_1114_b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      int var5 = MathHelper.func_1108_b(p_4079_1_.field_611_ak);
      int var6 = MathHelper.func_1108_b(p_4079_1_.field_609_am);
      BiomeGenBase var7 = this.func_48454_a(var5, var6);
      float var8 = var7.func_48411_i();
      int var9 = var7.func_4126_a(var8);
      float var10 = (float)(var9 >> 16 & 255) / 255.0F;
      float var11 = (float)(var9 >> 8 & 255) / 255.0F;
      float var12 = (float)(var9 & 255) / 255.0F;
      var10 *= var4;
      var11 *= var4;
      var12 *= var4;
      float var13 = this.func_27162_g(p_4079_2_);
      float var14;
      float var15;
      if(var13 > 0.0F) {
         var14 = (var10 * 0.3F + var11 * 0.59F + var12 * 0.11F) * 0.6F;
         var15 = 1.0F - var13 * 0.75F;
         var10 = var10 * var15 + var14 * (1.0F - var15);
         var11 = var11 * var15 + var14 * (1.0F - var15);
         var12 = var12 * var15 + var14 * (1.0F - var15);
      }

      var14 = this.func_27166_f(p_4079_2_);
      if(var14 > 0.0F) {
         var15 = (var10 * 0.3F + var11 * 0.59F + var12 * 0.11F) * 0.2F;
         float var16 = 1.0F - var14 * 0.75F;
         var10 = var10 * var16 + var15 * (1.0F - var16);
         var11 = var11 * var16 + var15 * (1.0F - var16);
         var12 = var12 * var16 + var15 * (1.0F - var16);
      }

      if(this.field_27172_i > 0) {
         var15 = (float)this.field_27172_i - p_4079_2_;
         if(var15 > 1.0F) {
            var15 = 1.0F;
         }

         var15 *= 0.45F;
         var10 = var10 * (1.0F - var15) + 0.8F * var15;
         var11 = var11 * (1.0F - var15) + 0.8F * var15;
         var12 = var12 * (1.0F - var15) + 1.0F * var15;
      }

      return Vec3D.func_1248_b((double)var10, (double)var11, (double)var12);
   }

   public float func_619_c(float p_619_1_) {
      return this.field_4209_q.func_4100_a(this.field_22145_q.func_22304_f(), p_619_1_);
   }

   public int func_40475_d(float p_40475_1_) {
      return this.field_4209_q.func_40470_b(this.field_22145_q.func_22304_f(), p_40475_1_);
   }

   public float func_35456_d(float p_35456_1_) {
      float var2 = this.func_619_c(p_35456_1_);
      return var2 * 3.1415927F * 2.0F;
   }

   public Vec3D func_628_d(float p_628_1_) {
      float var2 = this.func_619_c(p_628_1_);
      float var3 = MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = (float)(this.field_1019_F >> 16 & 255L) / 255.0F;
      float var5 = (float)(this.field_1019_F >> 8 & 255L) / 255.0F;
      float var6 = (float)(this.field_1019_F & 255L) / 255.0F;
      float var7 = this.func_27162_g(p_628_1_);
      float var8;
      float var9;
      if(var7 > 0.0F) {
         var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
         var9 = 1.0F - var7 * 0.95F;
         var4 = var4 * var9 + var8 * (1.0F - var9);
         var5 = var5 * var9 + var8 * (1.0F - var9);
         var6 = var6 * var9 + var8 * (1.0F - var9);
      }

      var4 *= var3 * 0.9F + 0.1F;
      var5 *= var3 * 0.9F + 0.1F;
      var6 *= var3 * 0.85F + 0.15F;
      var8 = this.func_27166_f(p_628_1_);
      if(var8 > 0.0F) {
         var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
         float var10 = 1.0F - var8 * 0.95F;
         var4 = var4 * var10 + var9 * (1.0F - var10);
         var5 = var5 * var10 + var9 * (1.0F - var10);
         var6 = var6 * var10 + var9 * (1.0F - var10);
      }

      return Vec3D.func_1248_b((double)var4, (double)var5, (double)var6);
   }

   public Vec3D func_4082_d(float p_4082_1_) {
      float var2 = this.func_619_c(p_4082_1_);
      return this.field_4209_q.func_4096_a(var2, p_4082_1_);
   }

   public int func_35461_e(int p_35461_1_, int p_35461_2_) {
      return this.func_673_a(p_35461_1_, p_35461_2_).func_35840_c(p_35461_1_ & 15, p_35461_2_ & 15);
   }

   public int func_4083_e(int p_4083_1_, int p_4083_2_) {
      Chunk var3 = this.func_673_a(p_4083_1_, p_4083_2_);
      int var4 = var3.func_48498_h() + 16;
      p_4083_1_ &= 15;

      for(p_4083_2_ &= 15; var4 > 0; --var4) {
         int var5 = var3.func_1008_a(p_4083_1_, var4, p_4083_2_);
         if(var5 != 0 && Block.field_345_n[var5].field_356_bn.func_880_c() && Block.field_345_n[var5].field_356_bn != Material.field_4265_h) {
            return var4 + 1;
         }
      }

      return -1;
   }

   public float func_679_f(float p_679_1_) {
      float var2 = this.func_619_c(p_679_1_);
      float var3 = 1.0F - (MathHelper.func_1114_b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.75F);
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      return var3 * var3 * 0.5F;
   }

   public void func_22136_c(int p_22136_1_, int p_22136_2_, int p_22136_3_, int p_22136_4_, int p_22136_5_) {
      NextTickListEntry var6 = new NextTickListEntry(p_22136_1_, p_22136_2_, p_22136_3_, p_22136_4_);
      byte var7 = 8;
      if(this.field_4214_a) {
         if(this.func_640_a(var6.field_1361_a - var7, var6.field_1360_b - var7, var6.field_1366_c - var7, var6.field_1361_a + var7, var6.field_1360_b + var7, var6.field_1366_c + var7)) {
            int var8 = this.func_600_a(var6.field_1361_a, var6.field_1360_b, var6.field_1366_c);
            if(var8 == var6.field_1365_d && var8 > 0) {
               Block.field_345_n[var8].func_208_a(this, var6.field_1361_a, var6.field_1360_b, var6.field_1366_c, this.field_1037_n);
            }
         }

      } else {
         if(this.func_640_a(p_22136_1_ - var7, p_22136_2_ - var7, p_22136_3_ - var7, p_22136_1_ + var7, p_22136_2_ + var7, p_22136_3_ + var7)) {
            if(p_22136_4_ > 0) {
               var6.func_900_a((long)p_22136_5_ + this.field_22145_q.func_22304_f());
            }

            if(!this.field_1056_C.contains(var6)) {
               this.field_1056_C.add(var6);
               this.field_1058_B.add(var6);
            }
         }

      }
   }

   public void func_41083_e(int p_41083_1_, int p_41083_2_, int p_41083_3_, int p_41083_4_, int p_41083_5_) {
      NextTickListEntry var6 = new NextTickListEntry(p_41083_1_, p_41083_2_, p_41083_3_, p_41083_4_);
      if(p_41083_4_ > 0) {
         var6.func_900_a((long)p_41083_5_ + this.field_22145_q.func_22304_f());
      }

      if(!this.field_1056_C.contains(var6)) {
         this.field_1056_C.add(var6);
         this.field_1058_B.add(var6);
      }

   }

   public void func_633_c() {
      Profiler.func_40663_a("entities");
      Profiler.func_40663_a("global");

      int var1;
      Entity var2;
      for(var1 = 0; var1 < this.field_27173_e.size(); ++var1) {
         var2 = (Entity)this.field_27173_e.get(var1);
         var2.func_370_e_();
         if(var2.field_646_aA) {
            this.field_27173_e.remove(var1--);
         }
      }

      Profiler.func_40661_c("remove");
      this.field_1050_a.removeAll(this.field_1024_A);

      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
         var2 = (Entity)this.field_1024_A.get(var1);
         var3 = var2.field_657_ba;
         var4 = var2.field_654_bc;
         if(var2.field_621_aZ && this.func_620_h(var3, var4)) {
            this.func_704_b(var3, var4).func_1015_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
         this.func_678_c((Entity)this.field_1024_A.get(var1));
      }

      this.field_1024_A.clear();
      Profiler.func_40661_c("regular");

      for(var1 = 0; var1 < this.field_1050_a.size(); ++var1) {
         var2 = (Entity)this.field_1050_a.get(var1);
         if(var2.field_616_af != null) {
            if(!var2.field_616_af.field_646_aA && var2.field_616_af.field_617_ae == var2) {
               continue;
            }

            var2.field_616_af.field_617_ae = null;
            var2.field_616_af = null;
         }

         if(!var2.field_646_aA) {
            this.func_667_e(var2);
         }

         Profiler.func_40663_a("remove");
         if(var2.field_646_aA) {
            var3 = var2.field_657_ba;
            var4 = var2.field_654_bc;
            if(var2.field_621_aZ && this.func_620_h(var3, var4)) {
               this.func_704_b(var3, var4).func_1015_b(var2);
            }

            this.field_1050_a.remove(var1--);
            this.func_678_c(var2);
         }

         Profiler.func_40662_b();
      }

      Profiler.func_40661_c("tileEntities");
      this.field_31055_L = true;
      Iterator var10 = this.field_1049_b.iterator();

      while(var10.hasNext()) {
         TileEntity var5 = (TileEntity)var10.next();
         if(!var5.func_31006_g() && var5.field_824_e != null && this.func_630_d(var5.field_823_f, var5.field_822_g, var5.field_821_h)) {
            var5.func_475_b();
         }

         if(var5.func_31006_g()) {
            var10.remove();
            if(this.func_620_h(var5.field_823_f >> 4, var5.field_821_h >> 4)) {
               Chunk var7 = this.func_704_b(var5.field_823_f >> 4, var5.field_821_h >> 4);
               if(var7 != null) {
                  var7.func_1023_e(var5.field_823_f & 15, var5.field_822_g, var5.field_821_h & 15);
               }
            }
         }
      }

      this.field_31055_L = false;
      if(!this.field_34900_Q.isEmpty()) {
         this.field_1049_b.removeAll(this.field_34900_Q);
         this.field_34900_Q.clear();
      }

      Profiler.func_40661_c("pendingTileEntities");
      if(!this.field_30900_E.isEmpty()) {
         Iterator var6 = this.field_30900_E.iterator();

         while(var6.hasNext()) {
            TileEntity var8 = (TileEntity)var6.next();
            if(!var8.func_31006_g()) {
               if(!this.field_1049_b.contains(var8)) {
                  this.field_1049_b.add(var8);
               }

               if(this.func_620_h(var8.field_823_f >> 4, var8.field_821_h >> 4)) {
                  Chunk var9 = this.func_704_b(var8.field_823_f >> 4, var8.field_821_h >> 4);
                  if(var9 != null) {
                     var9.func_1005_a(var8.field_823_f & 15, var8.field_822_g, var8.field_821_h & 15, var8);
                  }
               }

               this.func_665_h(var8.field_823_f, var8.field_822_g, var8.field_821_h);
            }
         }

         this.field_30900_E.clear();
      }

      Profiler.func_40662_b();
      Profiler.func_40662_b();
   }

   public void func_31054_a(Collection p_31054_1_) {
      if(this.field_31055_L) {
         this.field_30900_E.addAll(p_31054_1_);
      } else {
         this.field_1049_b.addAll(p_31054_1_);
      }

   }

   public void func_667_e(Entity p_667_1_) {
      this.func_4084_a(p_667_1_, true);
   }

   public void func_4084_a(Entity p_4084_1_, boolean p_4084_2_) {
      int var3 = MathHelper.func_1108_b(p_4084_1_.field_611_ak);
      int var4 = MathHelper.func_1108_b(p_4084_1_.field_609_am);
      byte var5 = 32;
      if(!p_4084_2_ || this.func_640_a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5)) {
         p_4084_1_.field_638_aI = p_4084_1_.field_611_ak;
         p_4084_1_.field_637_aJ = p_4084_1_.field_610_al;
         p_4084_1_.field_636_aK = p_4084_1_.field_609_am;
         p_4084_1_.field_603_as = p_4084_1_.field_605_aq;
         p_4084_1_.field_602_at = p_4084_1_.field_604_ar;
         if(p_4084_2_ && p_4084_1_.field_621_aZ) {
            if(p_4084_1_.field_616_af != null) {
               p_4084_1_.func_350_p();
            } else {
               p_4084_1_.func_370_e_();
            }
         }

         Profiler.func_40663_a("chunkCheck");
         if(Double.isNaN(p_4084_1_.field_611_ak) || Double.isInfinite(p_4084_1_.field_611_ak)) {
            p_4084_1_.field_611_ak = p_4084_1_.field_638_aI;
         }

         if(Double.isNaN(p_4084_1_.field_610_al) || Double.isInfinite(p_4084_1_.field_610_al)) {
            p_4084_1_.field_610_al = p_4084_1_.field_637_aJ;
         }

         if(Double.isNaN(p_4084_1_.field_609_am) || Double.isInfinite(p_4084_1_.field_609_am)) {
            p_4084_1_.field_609_am = p_4084_1_.field_636_aK;
         }

         if(Double.isNaN((double)p_4084_1_.field_604_ar) || Double.isInfinite((double)p_4084_1_.field_604_ar)) {
            p_4084_1_.field_604_ar = p_4084_1_.field_602_at;
         }

         if(Double.isNaN((double)p_4084_1_.field_605_aq) || Double.isInfinite((double)p_4084_1_.field_605_aq)) {
            p_4084_1_.field_605_aq = p_4084_1_.field_603_as;
         }

         int var6 = MathHelper.func_1108_b(p_4084_1_.field_611_ak / 16.0D);
         int var7 = MathHelper.func_1108_b(p_4084_1_.field_610_al / 16.0D);
         int var8 = MathHelper.func_1108_b(p_4084_1_.field_609_am / 16.0D);
         if(!p_4084_1_.field_621_aZ || p_4084_1_.field_657_ba != var6 || p_4084_1_.field_656_bb != var7 || p_4084_1_.field_654_bc != var8) {
            if(p_4084_1_.field_621_aZ && this.func_620_h(p_4084_1_.field_657_ba, p_4084_1_.field_654_bc)) {
               this.func_704_b(p_4084_1_.field_657_ba, p_4084_1_.field_654_bc).func_1016_a(p_4084_1_, p_4084_1_.field_656_bb);
            }

            if(this.func_620_h(var6, var8)) {
               p_4084_1_.field_621_aZ = true;
               this.func_704_b(var6, var8).func_1000_a(p_4084_1_);
            } else {
               p_4084_1_.field_621_aZ = false;
            }
         }

         Profiler.func_40662_b();
         if(p_4084_2_ && p_4084_1_.field_621_aZ && p_4084_1_.field_617_ae != null) {
            if(!p_4084_1_.field_617_ae.field_646_aA && p_4084_1_.field_617_ae.field_616_af == p_4084_1_) {
               this.func_667_e(p_4084_1_.field_617_ae);
            } else {
               p_4084_1_.field_617_ae.field_616_af = null;
               p_4084_1_.field_617_ae = null;
            }
         }

      }
   }

   public boolean func_604_a(AxisAlignedBB p_604_1_) {
      List var2 = this.func_659_b((Entity)null, p_604_1_);

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         Entity var4 = (Entity)var2.get(var3);
         if(!var4.field_646_aA && var4.field_618_ad) {
            return false;
         }
      }

      return true;
   }

   public boolean func_662_b(AxisAlignedBB p_662_1_) {
      int var2 = MathHelper.func_1108_b(p_662_1_.field_1698_a);
      int var3 = MathHelper.func_1108_b(p_662_1_.field_1703_d + 1.0D);
      int var4 = MathHelper.func_1108_b(p_662_1_.field_1697_b);
      int var5 = MathHelper.func_1108_b(p_662_1_.field_1702_e + 1.0D);
      int var6 = MathHelper.func_1108_b(p_662_1_.field_1704_c);
      int var7 = MathHelper.func_1108_b(p_662_1_.field_1701_f + 1.0D);
      if(p_662_1_.field_1698_a < 0.0D) {
         --var2;
      }

      if(p_662_1_.field_1697_b < 0.0D) {
         --var4;
      }

      if(p_662_1_.field_1704_c < 0.0D) {
         --var6;
      }

      for(int var8 = var2; var8 < var3; ++var8) {
         for(int var9 = var4; var9 < var5; ++var9) {
            for(int var10 = var6; var10 < var7; ++var10) {
               Block var11 = Block.field_345_n[this.func_600_a(var8, var9, var10)];
               if(var11 != null && var11.field_356_bn.func_879_d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_605_c(AxisAlignedBB p_605_1_) {
      int var2 = MathHelper.func_1108_b(p_605_1_.field_1698_a);
      int var3 = MathHelper.func_1108_b(p_605_1_.field_1703_d + 1.0D);
      int var4 = MathHelper.func_1108_b(p_605_1_.field_1697_b);
      int var5 = MathHelper.func_1108_b(p_605_1_.field_1702_e + 1.0D);
      int var6 = MathHelper.func_1108_b(p_605_1_.field_1704_c);
      int var7 = MathHelper.func_1108_b(p_605_1_.field_1701_f + 1.0D);
      if(this.func_640_a(var2, var4, var6, var3, var5, var7)) {
         for(int var8 = var2; var8 < var3; ++var8) {
            for(int var9 = var4; var9 < var5; ++var9) {
               for(int var10 = var6; var10 < var7; ++var10) {
                  int var11 = this.func_600_a(var8, var9, var10);
                  if(var11 == Block.field_402_as.field_376_bc || var11 == Block.field_397_D.field_376_bc || var11 == Block.field_395_E.field_376_bc) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean func_682_a(AxisAlignedBB p_682_1_, Material p_682_2_, Entity p_682_3_) {
      int var4 = MathHelper.func_1108_b(p_682_1_.field_1698_a);
      int var5 = MathHelper.func_1108_b(p_682_1_.field_1703_d + 1.0D);
      int var6 = MathHelper.func_1108_b(p_682_1_.field_1697_b);
      int var7 = MathHelper.func_1108_b(p_682_1_.field_1702_e + 1.0D);
      int var8 = MathHelper.func_1108_b(p_682_1_.field_1704_c);
      int var9 = MathHelper.func_1108_b(p_682_1_.field_1701_f + 1.0D);
      if(!this.func_640_a(var4, var6, var8, var5, var7, var9)) {
         return false;
      } else {
         boolean var10 = false;
         Vec3D var11 = Vec3D.func_1248_b(0.0D, 0.0D, 0.0D);

         for(int var12 = var4; var12 < var5; ++var12) {
            for(int var13 = var6; var13 < var7; ++var13) {
               for(int var14 = var8; var14 < var9; ++var14) {
                  Block var15 = Block.field_345_n[this.func_600_a(var12, var13, var14)];
                  if(var15 != null && var15.field_356_bn == p_682_2_) {
                     double var16 = (double)((float)(var13 + 1) - BlockFluid.func_288_b(this.func_602_e(var12, var13, var14)));
                     if((double)var7 >= var16) {
                        var10 = true;
                        var15.func_257_a(this, var12, var13, var14, p_682_3_, var11);
                     }
                  }
               }
            }
         }

         if(var11.func_1253_c() > 0.0D) {
            var11 = var11.func_1252_b();
            double var18 = 0.014D;
            p_682_3_.field_608_an += var11.field_1776_a * var18;
            p_682_3_.field_607_ao += var11.field_1775_b * var18;
            p_682_3_.field_606_ap += var11.field_1779_c * var18;
         }

         return var10;
      }
   }

   public boolean func_689_a(AxisAlignedBB p_689_1_, Material p_689_2_) {
      int var3 = MathHelper.func_1108_b(p_689_1_.field_1698_a);
      int var4 = MathHelper.func_1108_b(p_689_1_.field_1703_d + 1.0D);
      int var5 = MathHelper.func_1108_b(p_689_1_.field_1697_b);
      int var6 = MathHelper.func_1108_b(p_689_1_.field_1702_e + 1.0D);
      int var7 = MathHelper.func_1108_b(p_689_1_.field_1704_c);
      int var8 = MathHelper.func_1108_b(p_689_1_.field_1701_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               Block var12 = Block.field_345_n[this.func_600_a(var9, var10, var11)];
               if(var12 != null && var12.field_356_bn == p_689_2_) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean func_707_b(AxisAlignedBB p_707_1_, Material p_707_2_) {
      int var3 = MathHelper.func_1108_b(p_707_1_.field_1698_a);
      int var4 = MathHelper.func_1108_b(p_707_1_.field_1703_d + 1.0D);
      int var5 = MathHelper.func_1108_b(p_707_1_.field_1697_b);
      int var6 = MathHelper.func_1108_b(p_707_1_.field_1702_e + 1.0D);
      int var7 = MathHelper.func_1108_b(p_707_1_.field_1704_c);
      int var8 = MathHelper.func_1108_b(p_707_1_.field_1701_f + 1.0D);

      for(int var9 = var3; var9 < var4; ++var9) {
         for(int var10 = var5; var10 < var6; ++var10) {
            for(int var11 = var7; var11 < var8; ++var11) {
               Block var12 = Block.field_345_n[this.func_600_a(var9, var10, var11)];
               if(var12 != null && var12.field_356_bn == p_707_2_) {
                  int var13 = this.func_602_e(var9, var10, var11);
                  double var14 = (double)(var10 + 1);
                  if(var13 < 8) {
                     var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
                  }

                  if(var14 >= p_707_1_.field_1697_b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public Explosion func_12243_a(Entity p_12243_1_, double p_12243_2_, double p_12243_4_, double p_12243_6_, float p_12243_8_) {
      return this.func_12244_a(p_12243_1_, p_12243_2_, p_12243_4_, p_12243_6_, p_12243_8_, false);
   }

   public Explosion func_12244_a(Entity p_12244_1_, double p_12244_2_, double p_12244_4_, double p_12244_6_, float p_12244_8_, boolean p_12244_9_) {
      Explosion var10 = new Explosion(this, p_12244_1_, p_12244_2_, p_12244_4_, p_12244_6_, p_12244_8_);
      var10.field_12257_a = p_12244_9_;
      var10.func_12248_a();
      var10.func_12247_b(true);
      return var10;
   }

   public float func_675_a(Vec3D p_675_1_, AxisAlignedBB p_675_2_) {
      double var3 = 1.0D / ((p_675_2_.field_1703_d - p_675_2_.field_1698_a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((p_675_2_.field_1702_e - p_675_2_.field_1697_b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((p_675_2_.field_1701_f - p_675_2_.field_1704_c) * 2.0D + 1.0D);
      int var9 = 0;
      int var10 = 0;

      for(float var11 = 0.0F; var11 <= 1.0F; var11 = (float)((double)var11 + var3)) {
         for(float var12 = 0.0F; var12 <= 1.0F; var12 = (float)((double)var12 + var5)) {
            for(float var13 = 0.0F; var13 <= 1.0F; var13 = (float)((double)var13 + var7)) {
               double var14 = p_675_2_.field_1698_a + (p_675_2_.field_1703_d - p_675_2_.field_1698_a) * (double)var11;
               double var16 = p_675_2_.field_1697_b + (p_675_2_.field_1702_e - p_675_2_.field_1697_b) * (double)var12;
               double var18 = p_675_2_.field_1704_c + (p_675_2_.field_1701_f - p_675_2_.field_1704_c) * (double)var13;
               if(this.func_645_a(Vec3D.func_1248_b(var14, var16, var18), p_675_1_) == null) {
                  ++var9;
               }

               ++var10;
            }
         }
      }

      return (float)var9 / (float)var10;
   }

   public boolean func_48457_a(EntityPlayer p_48457_1_, int p_48457_2_, int p_48457_3_, int p_48457_4_, int p_48457_5_) {
      if(p_48457_5_ == 0) {
         --p_48457_3_;
      }

      if(p_48457_5_ == 1) {
         ++p_48457_3_;
      }

      if(p_48457_5_ == 2) {
         --p_48457_4_;
      }

      if(p_48457_5_ == 3) {
         ++p_48457_4_;
      }

      if(p_48457_5_ == 4) {
         --p_48457_2_;
      }

      if(p_48457_5_ == 5) {
         ++p_48457_2_;
      }

      if(this.func_600_a(p_48457_2_, p_48457_3_, p_48457_4_) == Block.field_402_as.field_376_bc) {
         this.func_28107_a(p_48457_1_, 1004, p_48457_2_, p_48457_3_, p_48457_4_, 0);
         this.func_690_d(p_48457_2_, p_48457_3_, p_48457_4_, 0);
         return true;
      } else {
         return false;
      }
   }

   public Entity func_4085_a(Class p_4085_1_) {
      return null;
   }

   public String func_687_d() {
      return "All: " + this.field_1050_a.size();
   }

   public String func_21119_g() {
      return this.field_1017_H.func_21109_c();
   }

   public TileEntity func_603_b(int p_603_1_, int p_603_2_, int p_603_3_) {
      if(p_603_2_ >= 256) {
         return null;
      } else {
         Chunk var4 = this.func_704_b(p_603_1_ >> 4, p_603_3_ >> 4);
         if(var4 == null) {
            return null;
         } else {
            TileEntity var5 = var4.func_1002_d(p_603_1_ & 15, p_603_2_, p_603_3_ & 15);
            if(var5 == null) {
               Iterator var6 = this.field_30900_E.iterator();

               while(var6.hasNext()) {
                  TileEntity var7 = (TileEntity)var6.next();
                  if(!var7.func_31006_g() && var7.field_823_f == p_603_1_ && var7.field_822_g == p_603_2_ && var7.field_821_h == p_603_3_) {
                     var5 = var7;
                     break;
                  }
               }
            }

            return var5;
         }
      }
   }

   public void func_654_a(int p_654_1_, int p_654_2_, int p_654_3_, TileEntity p_654_4_) {
      if(p_654_4_ != null && !p_654_4_.func_31006_g()) {
         if(this.field_31055_L) {
            p_654_4_.field_823_f = p_654_1_;
            p_654_4_.field_822_g = p_654_2_;
            p_654_4_.field_821_h = p_654_3_;
            this.field_30900_E.add(p_654_4_);
         } else {
            this.field_1049_b.add(p_654_4_);
            Chunk var5 = this.func_704_b(p_654_1_ >> 4, p_654_3_ >> 4);
            if(var5 != null) {
               var5.func_1005_a(p_654_1_ & 15, p_654_2_, p_654_3_ & 15, p_654_4_);
            }
         }
      }

   }

   public void func_692_l(int p_692_1_, int p_692_2_, int p_692_3_) {
      TileEntity var4 = this.func_603_b(p_692_1_, p_692_2_, p_692_3_);
      if(var4 != null && this.field_31055_L) {
         var4.func_31005_i();
         this.field_30900_E.remove(var4);
      } else {
         if(var4 != null) {
            this.field_30900_E.remove(var4);
            this.field_1049_b.remove(var4);
         }

         Chunk var5 = this.func_704_b(p_692_1_ >> 4, p_692_3_ >> 4);
         if(var5 != null) {
            var5.func_1023_e(p_692_1_ & 15, p_692_2_, p_692_3_ & 15);
         }
      }

   }

   public void func_35455_a(TileEntity p_35455_1_) {
      this.field_34900_Q.add(p_35455_1_);
   }

   public boolean func_601_g(int p_601_1_, int p_601_2_, int p_601_3_) {
      Block var4 = Block.field_345_n[this.func_600_a(p_601_1_, p_601_2_, p_601_3_)];
      return var4 == null?false:var4.func_217_b();
   }

   public boolean func_28100_h(int p_28100_1_, int p_28100_2_, int p_28100_3_) {
      return Block.func_48206_g(this.func_600_a(p_28100_1_, p_28100_2_, p_28100_3_));
   }

   public boolean func_41082_b(int p_41082_1_, int p_41082_2_, int p_41082_3_, boolean p_41082_4_) {
      if(p_41082_1_ >= -30000000 && p_41082_3_ >= -30000000 && p_41082_1_ < 30000000 && p_41082_3_ < 30000000) {
         Chunk var5 = this.field_1017_H.func_533_b(p_41082_1_ >> 4, p_41082_3_ >> 4);
         if(var5 != null && !var5.func_21167_h()) {
            Block var6 = Block.field_345_n[this.func_600_a(p_41082_1_, p_41082_2_, p_41082_3_)];
            return var6 == null?false:var6.field_356_bn.func_28126_h() && var6.func_242_c();
         } else {
            return p_41082_4_;
         }
      } else {
         return p_41082_4_;
      }
   }

   public void func_651_a(IProgressUpdate p_651_1_) {
      this.func_639_a(true, p_651_1_);

      try {
         ThreadedFileIOBase.field_40573_a.func_40566_a();
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      }

   }

   public void func_644_f() {
      int var1 = this.func_671_a(1.0F);
      if(var1 != this.field_1046_e) {
         this.field_1046_e = var1;
      }

   }

   public void func_21114_a(boolean p_21114_1_, boolean p_21114_2_) {
      this.field_21121_K = p_21114_1_;
      this.field_21120_L = p_21114_2_;
   }

   public void func_649_g() {
      if(this.func_22144_v().func_40724_s() && this.field_1039_l < 3) {
         this.field_1039_l = 3;
      }

      this.field_4209_q.field_4215_b.func_35561_b();
      this.func_27165_m();
      long var2;
      if(this.func_22142_y()) {
         boolean var1 = false;
         if(this.field_21121_K && this.field_1039_l >= 1) {
            ;
         }

         if(!var1) {
            var2 = this.field_22145_q.func_22304_f() + 24000L;
            this.field_22145_q.func_22307_a(var2 - var2 % 24000L);
            this.func_22141_x();
         }
      }

      Profiler.func_40663_a("mobSpawner");
      SpawnerAnimals.func_4154_a(this, this.field_21121_K, this.field_21120_L && this.field_22145_q.func_22304_f() % 400L == 0L);
      Profiler.func_40661_c("chunkSource");
      this.field_1017_H.func_532_a();
      int var4 = this.func_671_a(1.0F);
      if(var4 != this.field_1046_e) {
         this.field_1046_e = var4;
      }

      var2 = this.field_22145_q.func_22304_f() + 1L;
      if(var2 % (long)this.field_9435_j == 0L) {
         Profiler.func_40661_c("save");
         this.func_639_a(false, (IProgressUpdate)null);
      }

      this.field_22145_q.func_22307_a(var2);
      Profiler.func_40661_c("tickPending");
      this.func_700_a(false);
      Profiler.func_40661_c("tickTiles");
      this.func_4080_j();
      Profiler.func_40661_c("village");
      this.field_48465_A.func_48558_a();
      this.field_48466_O.func_48573_a();
      Profiler.func_40662_b();
   }

   private void func_27163_E() {
      if(this.field_22145_q.func_27397_o()) {
         this.field_27171_C = 1.0F;
         if(this.field_22145_q.func_27396_m()) {
            this.field_27169_E = 1.0F;
         }
      }

   }

   protected void func_27165_m() {
      if(!this.field_4209_q.field_6478_e) {
         if(this.field_27168_F > 0) {
            --this.field_27168_F;
         }

         int var1 = this.field_22145_q.func_27400_n();
         if(var1 <= 0) {
            if(this.field_22145_q.func_27396_m()) {
               this.field_22145_q.func_27399_e(this.field_1037_n.nextInt(12000) + 3600);
            } else {
               this.field_22145_q.func_27399_e(this.field_1037_n.nextInt(168000) + 12000);
            }
         } else {
            --var1;
            this.field_22145_q.func_27399_e(var1);
            if(var1 <= 0) {
               this.field_22145_q.func_27398_a(!this.field_22145_q.func_27396_m());
            }
         }

         int var2 = this.field_22145_q.func_27393_p();
         if(var2 <= 0) {
            if(this.field_22145_q.func_27397_o()) {
               this.field_22145_q.func_27395_f(this.field_1037_n.nextInt(12000) + 12000);
            } else {
               this.field_22145_q.func_27395_f(this.field_1037_n.nextInt(168000) + 12000);
            }
         } else {
            --var2;
            this.field_22145_q.func_27395_f(var2);
            if(var2 <= 0) {
               this.field_22145_q.func_27394_b(!this.field_22145_q.func_27397_o());
            }
         }

         this.field_26901_B = this.field_27171_C;
         if(this.field_22145_q.func_27397_o()) {
            this.field_27171_C = (float)((double)this.field_27171_C + 0.01D);
         } else {
            this.field_27171_C = (float)((double)this.field_27171_C - 0.01D);
         }

         if(this.field_27171_C < 0.0F) {
            this.field_27171_C = 0.0F;
         }

         if(this.field_27171_C > 1.0F) {
            this.field_27171_C = 1.0F;
         }

         this.field_27170_D = this.field_27169_E;
         if(this.field_22145_q.func_27396_m()) {
            this.field_27169_E = (float)((double)this.field_27169_E + 0.01D);
         } else {
            this.field_27169_E = (float)((double)this.field_27169_E - 0.01D);
         }

         if(this.field_27169_E < 0.0F) {
            this.field_27169_E = 0.0F;
         }

         if(this.field_27169_E > 1.0F) {
            this.field_27169_E = 1.0F;
         }

      }
   }

   private void func_27164_F() {
      this.field_22145_q.func_27395_f(0);
      this.field_22145_q.func_27394_b(false);
      this.field_22145_q.func_27399_e(0);
      this.field_22145_q.func_27398_a(false);
   }

   protected void func_48461_r() {
      this.field_9427_K.clear();
      Profiler.func_40663_a("buildList");

      int var1;
      EntityPlayer var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_1040_k.size(); ++var1) {
         var2 = (EntityPlayer)this.field_1040_k.get(var1);
         var3 = MathHelper.func_1108_b(var2.field_611_ak / 16.0D);
         var4 = MathHelper.func_1108_b(var2.field_609_am / 16.0D);
         byte var5 = 7;

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.field_9427_K.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
            }
         }
      }

      Profiler.func_40662_b();
      if(this.field_9426_L > 0) {
         --this.field_9426_L;
      }

      Profiler.func_40663_a("playerCheckLight");
      if(!this.field_1040_k.isEmpty()) {
         var1 = this.field_1037_n.nextInt(this.field_1040_k.size());
         var2 = (EntityPlayer)this.field_1040_k.get(var1);
         var3 = MathHelper.func_1108_b(var2.field_611_ak) + this.field_1037_n.nextInt(11) - 5;
         var4 = MathHelper.func_1108_b(var2.field_610_al) + this.field_1037_n.nextInt(11) - 5;
         int var8 = MathHelper.func_1108_b(var2.field_609_am) + this.field_1037_n.nextInt(11) - 5;
         this.func_35463_p(var3, var4, var8);
      }

      Profiler.func_40662_b();
   }

   protected void func_48458_a(int p_48458_1_, int p_48458_2_, Chunk p_48458_3_) {
      Profiler.func_40661_c("tickChunk");
      p_48458_3_.func_35841_j();
      Profiler.func_40661_c("moodSound");
      if(this.field_9426_L == 0) {
         this.field_9437_g = this.field_9437_g * 3 + 1013904223;
         int var4 = this.field_9437_g >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 127;
         int var8 = p_48458_3_.func_1008_a(var5, var7, var6);
         var5 += p_48458_1_;
         var6 += p_48458_2_;
         if(var8 == 0 && this.func_28104_m(var5, var7, var6) <= this.field_1037_n.nextInt(8) && this.func_641_a(EnumSkyBlock.Sky, var5, var7, var6) <= 0) {
            EntityPlayer var9 = this.func_683_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var9 != null && var9.func_360_d((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.func_684_a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.field_1037_n.nextFloat() * 0.2F);
               this.field_9426_L = this.field_1037_n.nextInt(12000) + 6000;
            }
         }
      }

      Profiler.func_40661_c("checkLight");
      p_48458_3_.func_48491_o();
   }

   protected void func_4080_j() {
      this.func_48461_r();
      int var1 = 0;
      int var2 = 0;
      Iterator var3 = this.field_9427_K.iterator();

      while(var3.hasNext()) {
         ChunkCoordIntPair var4 = (ChunkCoordIntPair)var3.next();
         int var5 = var4.field_189_a * 16;
         int var6 = var4.field_188_b * 16;
         Profiler.func_40663_a("getChunk");
         Chunk var7 = this.func_704_b(var4.field_189_a, var4.field_188_b);
         this.func_48458_a(var5, var6, var7);
         Profiler.func_40661_c("thunder");
         int var8;
         int var9;
         int var10;
         int var11;
         if(this.field_1037_n.nextInt(100000) == 0 && this.func_27161_C() && this.func_27160_B()) {
            this.field_9437_g = this.field_9437_g * 3 + 1013904223;
            var8 = this.field_9437_g >> 2;
            var9 = var5 + (var8 & 15);
            var10 = var6 + (var8 >> 8 & 15);
            var11 = this.func_35461_e(var9, var10);
            if(this.func_27167_r(var9, var11, var10)) {
               this.func_27159_a(new EntityLightningBolt(this, (double)var9, (double)var11, (double)var10));
               this.field_27168_F = 2;
            }
         }

         Profiler.func_40661_c("iceandsnow");
         if(this.field_1037_n.nextInt(16) == 0) {
            this.field_9437_g = this.field_9437_g * 3 + 1013904223;
            var8 = this.field_9437_g >> 2;
            var9 = var8 & 15;
            var10 = var8 >> 8 & 15;
            var11 = this.func_35461_e(var9 + var5, var10 + var6);
            if(this.func_40481_q(var9 + var5, var11 - 1, var10 + var6)) {
               this.func_690_d(var9 + var5, var11 - 1, var10 + var6, Block.field_4063_aU.field_376_bc);
            }

            if(this.func_27161_C() && this.func_40478_r(var9 + var5, var11, var10 + var6)) {
               this.func_690_d(var9 + var5, var11, var10 + var6, Block.field_428_aT.field_376_bc);
            }
         }

         Profiler.func_40661_c("tickTiles");
         ExtendedBlockStorage[] var19 = var7.func_48495_i();
         var9 = var19.length;

         for(var10 = 0; var10 < var9; ++var10) {
            ExtendedBlockStorage var20 = var19[var10];
            if(var20 != null && var20.func_48698_b()) {
               for(int var12 = 0; var12 < 3; ++var12) {
                  this.field_9437_g = this.field_9437_g * 3 + 1013904223;
                  int var13 = this.field_9437_g >> 2;
                  int var14 = var13 & 15;
                  int var15 = var13 >> 8 & 15;
                  int var16 = var13 >> 16 & 15;
                  int var17 = var20.func_48703_a(var14, var16, var15);
                  ++var2;
                  Block var18 = Block.field_345_n[var17];
                  if(var18 != null && var18.func_48203_o()) {
                     ++var1;
                     var18.func_208_a(this, var14 + var5, var16 + var20.func_48707_c(), var15 + var6, this.field_1037_n);
                  }
               }
            }
         }

         Profiler.func_40662_b();
      }

   }

   public boolean func_40471_p(int p_40471_1_, int p_40471_2_, int p_40471_3_) {
      return this.func_40476_b(p_40471_1_, p_40471_2_, p_40471_3_, false);
   }

   public boolean func_40481_q(int p_40481_1_, int p_40481_2_, int p_40481_3_) {
      return this.func_40476_b(p_40481_1_, p_40481_2_, p_40481_3_, true);
   }

   public boolean func_40476_b(int p_40476_1_, int p_40476_2_, int p_40476_3_, boolean p_40476_4_) {
      BiomeGenBase var5 = this.func_48454_a(p_40476_1_, p_40476_3_);
      float var6 = var5.func_48411_i();
      if(var6 > 0.15F) {
         return false;
      } else {
         if(p_40476_2_ >= 0 && p_40476_2_ < 256 && this.func_641_a(EnumSkyBlock.Block, p_40476_1_, p_40476_2_, p_40476_3_) < 10) {
            int var7 = this.func_600_a(p_40476_1_, p_40476_2_, p_40476_3_);
            if((var7 == Block.field_399_C.field_376_bc || var7 == Block.field_401_B.field_376_bc) && this.func_602_e(p_40476_1_, p_40476_2_, p_40476_3_) == 0) {
               if(!p_40476_4_) {
                  return true;
               }

               boolean var8 = true;
               if(var8 && this.func_599_f(p_40476_1_ - 1, p_40476_2_, p_40476_3_) != Material.field_1332_f) {
                  var8 = false;
               }

               if(var8 && this.func_599_f(p_40476_1_ + 1, p_40476_2_, p_40476_3_) != Material.field_1332_f) {
                  var8 = false;
               }

               if(var8 && this.func_599_f(p_40476_1_, p_40476_2_, p_40476_3_ - 1) != Material.field_1332_f) {
                  var8 = false;
               }

               if(var8 && this.func_599_f(p_40476_1_, p_40476_2_, p_40476_3_ + 1) != Material.field_1332_f) {
                  var8 = false;
               }

               if(!var8) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean func_40478_r(int p_40478_1_, int p_40478_2_, int p_40478_3_) {
      BiomeGenBase var4 = this.func_48454_a(p_40478_1_, p_40478_3_);
      float var5 = var4.func_48411_i();
      if(var5 > 0.15F) {
         return false;
      } else {
         if(p_40478_2_ >= 0 && p_40478_2_ < 256 && this.func_641_a(EnumSkyBlock.Block, p_40478_1_, p_40478_2_, p_40478_3_) < 10) {
            int var6 = this.func_600_a(p_40478_1_, p_40478_2_ - 1, p_40478_3_);
            int var7 = this.func_600_a(p_40478_1_, p_40478_2_, p_40478_3_);
            if(var7 == 0 && Block.field_428_aT.func_243_a(this, p_40478_1_, p_40478_2_, p_40478_3_) && var6 != 0 && var6 != Block.field_4063_aU.field_376_bc && Block.field_345_n[var6].field_356_bn.func_880_c()) {
               return true;
            }
         }

         return false;
      }
   }

   public void func_35463_p(int p_35463_1_, int p_35463_2_, int p_35463_3_) {
      if(!this.field_4209_q.field_6478_e) {
         this.func_35459_c(EnumSkyBlock.Sky, p_35463_1_, p_35463_2_, p_35463_3_);
      }

      this.func_35459_c(EnumSkyBlock.Block, p_35463_1_, p_35463_2_, p_35463_3_);
   }

   private int func_35460_a(int p_35460_1_, int p_35460_2_, int p_35460_3_, int p_35460_4_, int p_35460_5_, int p_35460_6_) {
      int var7 = 0;
      if(this.func_647_i(p_35460_2_, p_35460_3_, p_35460_4_)) {
         var7 = 15;
      } else {
         if(p_35460_6_ == 0) {
            p_35460_6_ = 1;
         }

         int var8 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_ - 1, p_35460_3_, p_35460_4_) - p_35460_6_;
         int var9 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_ + 1, p_35460_3_, p_35460_4_) - p_35460_6_;
         int var10 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_, p_35460_3_ - 1, p_35460_4_) - p_35460_6_;
         int var11 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_, p_35460_3_ + 1, p_35460_4_) - p_35460_6_;
         int var12 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_, p_35460_3_, p_35460_4_ - 1) - p_35460_6_;
         int var13 = this.func_641_a(EnumSkyBlock.Sky, p_35460_2_, p_35460_3_, p_35460_4_ + 1) - p_35460_6_;
         if(var8 > var7) {
            var7 = var8;
         }

         if(var9 > var7) {
            var7 = var9;
         }

         if(var10 > var7) {
            var7 = var10;
         }

         if(var11 > var7) {
            var7 = var11;
         }

         if(var12 > var7) {
            var7 = var12;
         }

         if(var13 > var7) {
            var7 = var13;
         }
      }

      return var7;
   }

   private int func_35458_d(int p_35458_1_, int p_35458_2_, int p_35458_3_, int p_35458_4_, int p_35458_5_, int p_35458_6_) {
      int var7 = Block.field_339_t[p_35458_5_];
      int var8 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_ - 1, p_35458_3_, p_35458_4_) - p_35458_6_;
      int var9 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_ + 1, p_35458_3_, p_35458_4_) - p_35458_6_;
      int var10 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_, p_35458_3_ - 1, p_35458_4_) - p_35458_6_;
      int var11 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_, p_35458_3_ + 1, p_35458_4_) - p_35458_6_;
      int var12 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_, p_35458_3_, p_35458_4_ - 1) - p_35458_6_;
      int var13 = this.func_641_a(EnumSkyBlock.Block, p_35458_2_, p_35458_3_, p_35458_4_ + 1) - p_35458_6_;
      if(var8 > var7) {
         var7 = var8;
      }

      if(var9 > var7) {
         var7 = var9;
      }

      if(var10 > var7) {
         var7 = var10;
      }

      if(var11 > var7) {
         var7 = var11;
      }

      if(var12 > var7) {
         var7 = var12;
      }

      if(var13 > var7) {
         var7 = var13;
      }

      return var7;
   }

   public void func_35459_c(EnumSkyBlock p_35459_1_, int p_35459_2_, int p_35459_3_, int p_35459_4_) {
      if(this.func_21117_a(p_35459_2_, p_35459_3_, p_35459_4_, 17)) {
         int var5 = 0;
         int var6 = 0;
         Profiler.func_40663_a("getBrightness");
         int var7 = this.func_641_a(p_35459_1_, p_35459_2_, p_35459_3_, p_35459_4_);
         boolean var8 = false;
         int var10 = this.func_600_a(p_35459_2_, p_35459_3_, p_35459_4_);
         int var11 = this.func_48462_d(p_35459_2_, p_35459_3_, p_35459_4_);
         if(var11 == 0) {
            var11 = 1;
         }

         boolean var12 = false;
         int var25;
         if(p_35459_1_ == EnumSkyBlock.Sky) {
            var25 = this.func_35460_a(var7, p_35459_2_, p_35459_3_, p_35459_4_, var10, var11);
         } else {
            var25 = this.func_35458_d(var7, p_35459_2_, p_35459_3_, p_35459_4_, var10, var11);
         }

         int var9;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         if(var25 > var7) {
            this.field_35466_H[var6++] = 133152;
         } else if(var25 < var7) {
            if(p_35459_1_ != EnumSkyBlock.Block) {
               ;
            }

            this.field_35466_H[var6++] = 133152 + (var7 << 18);

            while(var5 < var6) {
               var9 = this.field_35466_H[var5++];
               var10 = (var9 & 63) - 32 + p_35459_2_;
               var11 = (var9 >> 6 & 63) - 32 + p_35459_3_;
               var25 = (var9 >> 12 & 63) - 32 + p_35459_4_;
               var13 = var9 >> 18 & 15;
               var14 = this.func_641_a(p_35459_1_, var10, var11, var25);
               if(var14 == var13) {
                  this.func_664_b(p_35459_1_, var10, var11, var25, 0);
                  if(var13 > 0) {
                     var15 = var10 - p_35459_2_;
                     var16 = var11 - p_35459_3_;
                     var17 = var25 - p_35459_4_;
                     if(var15 < 0) {
                        var15 = -var15;
                     }

                     if(var16 < 0) {
                        var16 = -var16;
                     }

                     if(var17 < 0) {
                        var17 = -var17;
                     }

                     if(var15 + var16 + var17 < 17) {
                        for(int var18 = 0; var18 < 6; ++var18) {
                           int var19 = var18 % 2 * 2 - 1;
                           int var20 = var10 + var18 / 2 % 3 / 2 * var19;
                           int var21 = var11 + (var18 / 2 + 1) % 3 / 2 * var19;
                           int var22 = var25 + (var18 / 2 + 2) % 3 / 2 * var19;
                           var14 = this.func_641_a(p_35459_1_, var20, var21, var22);
                           int var23 = Block.field_341_r[this.func_600_a(var20, var21, var22)];
                           if(var23 == 0) {
                              var23 = 1;
                           }

                           if(var14 == var13 - var23 && var6 < this.field_35466_H.length) {
                              this.field_35466_H[var6++] = var20 - p_35459_2_ + 32 + (var21 - p_35459_3_ + 32 << 6) + (var22 - p_35459_4_ + 32 << 12) + (var13 - var23 << 18);
                           }
                        }
                     }
                  }
               }
            }

            var5 = 0;
         }

         Profiler.func_40662_b();
         Profiler.func_40663_a("tcp < tcc");

         while(var5 < var6) {
            var7 = this.field_35466_H[var5++];
            int var24 = (var7 & 63) - 32 + p_35459_2_;
            var9 = (var7 >> 6 & 63) - 32 + p_35459_3_;
            var10 = (var7 >> 12 & 63) - 32 + p_35459_4_;
            var11 = this.func_641_a(p_35459_1_, var24, var9, var10);
            var25 = this.func_600_a(var24, var9, var10);
            var13 = Block.field_341_r[var25];
            if(var13 == 0) {
               var13 = 1;
            }

            boolean var26 = false;
            if(p_35459_1_ == EnumSkyBlock.Sky) {
               var14 = this.func_35460_a(var11, var24, var9, var10, var25, var13);
            } else {
               var14 = this.func_35458_d(var11, var24, var9, var10, var25, var13);
            }

            if(var14 != var11) {
               this.func_664_b(p_35459_1_, var24, var9, var10, var14);
               if(var14 > var11) {
                  var15 = var24 - p_35459_2_;
                  var16 = var9 - p_35459_3_;
                  var17 = var10 - p_35459_4_;
                  if(var15 < 0) {
                     var15 = -var15;
                  }

                  if(var16 < 0) {
                     var16 = -var16;
                  }

                  if(var17 < 0) {
                     var17 = -var17;
                  }

                  if(var15 + var16 + var17 < 17 && var6 < this.field_35466_H.length - 6) {
                     if(this.func_641_a(p_35459_1_, var24 - 1, var9, var10) < var14) {
                        this.field_35466_H[var6++] = var24 - 1 - p_35459_2_ + 32 + (var9 - p_35459_3_ + 32 << 6) + (var10 - p_35459_4_ + 32 << 12);
                     }

                     if(this.func_641_a(p_35459_1_, var24 + 1, var9, var10) < var14) {
                        this.field_35466_H[var6++] = var24 + 1 - p_35459_2_ + 32 + (var9 - p_35459_3_ + 32 << 6) + (var10 - p_35459_4_ + 32 << 12);
                     }

                     if(this.func_641_a(p_35459_1_, var24, var9 - 1, var10) < var14) {
                        this.field_35466_H[var6++] = var24 - p_35459_2_ + 32 + (var9 - 1 - p_35459_3_ + 32 << 6) + (var10 - p_35459_4_ + 32 << 12);
                     }

                     if(this.func_641_a(p_35459_1_, var24, var9 + 1, var10) < var14) {
                        this.field_35466_H[var6++] = var24 - p_35459_2_ + 32 + (var9 + 1 - p_35459_3_ + 32 << 6) + (var10 - p_35459_4_ + 32 << 12);
                     }

                     if(this.func_641_a(p_35459_1_, var24, var9, var10 - 1) < var14) {
                        this.field_35466_H[var6++] = var24 - p_35459_2_ + 32 + (var9 - p_35459_3_ + 32 << 6) + (var10 - 1 - p_35459_4_ + 32 << 12);
                     }

                     if(this.func_641_a(p_35459_1_, var24, var9, var10 + 1) < var14) {
                        this.field_35466_H[var6++] = var24 - p_35459_2_ + 32 + (var9 - p_35459_3_ + 32 << 6) + (var10 + 1 - p_35459_4_ + 32 << 12);
                     }
                  }
               }
            }
         }

         Profiler.func_40662_b();
      }
   }

   public boolean func_700_a(boolean p_700_1_) {
      int var2 = this.field_1058_B.size();
      if(var2 != this.field_1056_C.size()) {
         throw new IllegalStateException("TickNextTick list out of synch");
      } else {
         if(var2 > 1000) {
            var2 = 1000;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            NextTickListEntry var4 = (NextTickListEntry)this.field_1058_B.first();
            if(!p_700_1_ && var4.field_1364_e > this.field_22145_q.func_22304_f()) {
               break;
            }

            this.field_1058_B.remove(var4);
            this.field_1056_C.remove(var4);
            byte var5 = 8;
            if(this.func_640_a(var4.field_1361_a - var5, var4.field_1360_b - var5, var4.field_1366_c - var5, var4.field_1361_a + var5, var4.field_1360_b + var5, var4.field_1366_c + var5)) {
               int var6 = this.func_600_a(var4.field_1361_a, var4.field_1360_b, var4.field_1366_c);
               if(var6 == var4.field_1365_d && var6 > 0) {
                  Block.field_345_n[var6].func_208_a(this, var4.field_1361_a, var4.field_1360_b, var4.field_1366_c, this.field_1037_n);
               }
            }
         }

         return this.field_1058_B.size() != 0;
      }
   }

   public List func_41081_a(Chunk p_41081_1_, boolean p_41081_2_) {
      ArrayList var3 = null;
      ChunkCoordIntPair var4 = p_41081_1_.func_40740_k();
      int var5 = var4.field_189_a << 4;
      int var6 = var5 + 16;
      int var7 = var4.field_188_b << 4;
      int var8 = var7 + 16;
      Iterator var9 = this.field_1056_C.iterator();

      while(var9.hasNext()) {
         NextTickListEntry var10 = (NextTickListEntry)var9.next();
         if(var10.field_1361_a >= var5 && var10.field_1361_a < var6 && var10.field_1366_c >= var7 && var10.field_1366_c < var8) {
            if(p_41081_2_) {
               this.field_1058_B.remove(var10);
               var9.remove();
            }

            if(var3 == null) {
               var3 = new ArrayList();
            }

            var3.add(var10);
         }
      }

      return var3;
   }

   public void func_677_m(int p_677_1_, int p_677_2_, int p_677_3_) {
      byte var4 = 16;
      Random var5 = new Random();

      for(int var6 = 0; var6 < 1000; ++var6) {
         int var7 = p_677_1_ + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
         int var8 = p_677_2_ + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
         int var9 = p_677_3_ + this.field_1037_n.nextInt(var4) - this.field_1037_n.nextInt(var4);
         int var10 = this.func_600_a(var7, var8, var9);
         if(var10 == 0 && this.field_1037_n.nextInt(8) > var8 && this.field_4209_q.func_46064_i()) {
            this.func_694_a("depthsuspend", (double)((float)var7 + this.field_1037_n.nextFloat()), (double)((float)var8 + this.field_1037_n.nextFloat()), (double)((float)var9 + this.field_1037_n.nextFloat()), 0.0D, 0.0D, 0.0D);
         } else if(var10 > 0) {
            Block.field_345_n[var10].func_247_b(this, var7, var8, var9, var5);
         }
      }

   }

   public List func_659_b(Entity p_659_1_, AxisAlignedBB p_659_2_) {
      this.field_1012_M.clear();
      int var3 = MathHelper.func_1108_b((p_659_2_.field_1698_a - 2.0D) / 16.0D);
      int var4 = MathHelper.func_1108_b((p_659_2_.field_1703_d + 2.0D) / 16.0D);
      int var5 = MathHelper.func_1108_b((p_659_2_.field_1704_c - 2.0D) / 16.0D);
      int var6 = MathHelper.func_1108_b((p_659_2_.field_1701_f + 2.0D) / 16.0D);

      for(int var7 = var3; var7 <= var4; ++var7) {
         for(int var8 = var5; var8 <= var6; ++var8) {
            if(this.func_620_h(var7, var8)) {
               this.func_704_b(var7, var8).func_994_a(p_659_1_, p_659_2_, this.field_1012_M);
            }
         }
      }

      return this.field_1012_M;
   }

   public List func_657_a(Class p_657_1_, AxisAlignedBB p_657_2_) {
      int var3 = MathHelper.func_1108_b((p_657_2_.field_1698_a - 2.0D) / 16.0D);
      int var4 = MathHelper.func_1108_b((p_657_2_.field_1703_d + 2.0D) / 16.0D);
      int var5 = MathHelper.func_1108_b((p_657_2_.field_1704_c - 2.0D) / 16.0D);
      int var6 = MathHelper.func_1108_b((p_657_2_.field_1701_f + 2.0D) / 16.0D);
      ArrayList var7 = new ArrayList();

      for(int var8 = var3; var8 <= var4; ++var8) {
         for(int var9 = var5; var9 <= var6; ++var9) {
            if(this.func_620_h(var8, var9)) {
               this.func_704_b(var8, var9).func_1013_a(p_657_1_, p_657_2_, var7);
            }
         }
      }

      return var7;
   }

   public Entity func_48459_a(Class p_48459_1_, AxisAlignedBB p_48459_2_, Entity p_48459_3_) {
      List var4 = this.func_657_a(p_48459_1_, p_48459_2_);
      Entity var5 = null;
      double var6 = Double.MAX_VALUE;
      Iterator var8 = var4.iterator();

      while(var8.hasNext()) {
         Entity var9 = (Entity)var8.next();
         if(var9 != p_48459_3_) {
            double var10 = p_48459_3_.func_387_e(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public List func_658_i() {
      return this.field_1050_a;
   }

   public void func_698_b(int p_698_1_, int p_698_2_, int p_698_3_, TileEntity p_698_4_) {
      if(this.func_630_d(p_698_1_, p_698_2_, p_698_3_)) {
         this.func_673_a(p_698_1_, p_698_3_).func_1006_f();
      }

      for(int var5 = 0; var5 < this.field_9434_r.size(); ++var5) {
         ((IWorldAccess)this.field_9434_r.get(var5)).func_935_a(p_698_1_, p_698_2_, p_698_3_, p_698_4_);
      }

   }

   public int func_621_b(Class p_621_1_) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.field_1050_a.size(); ++var3) {
         Entity var4 = (Entity)this.field_1050_a.get(var3);
         if(p_621_1_.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }

      return var2;
   }

   public void func_636_a(List p_636_1_) {
      this.field_1050_a.addAll(p_636_1_);

      for(int var2 = 0; var2 < p_636_1_.size(); ++var2) {
         this.func_606_b((Entity)p_636_1_.get(var2));
      }

   }

   public void func_632_b(List p_632_1_) {
      this.field_1024_A.addAll(p_632_1_);
   }

   public void func_656_j() {
      while(this.field_1017_H.func_532_a()) {
         ;
      }

   }

   public boolean func_695_a(int p_695_1_, int p_695_2_, int p_695_3_, int p_695_4_, boolean p_695_5_, int p_695_6_) {
      int var7 = this.func_600_a(p_695_2_, p_695_3_, p_695_4_);
      Block var8 = Block.field_345_n[var7];
      Block var9 = Block.field_345_n[p_695_1_];
      AxisAlignedBB var10 = var9.func_221_d(this, p_695_2_, p_695_3_, p_695_4_);
      if(p_695_5_) {
         var10 = null;
      }

      if(var10 != null && !this.func_604_a(var10)) {
         return false;
      } else {
         if(var8 != null && (var8 == Block.field_401_B || var8 == Block.field_399_C || var8 == Block.field_397_D || var8 == Block.field_395_E || var8 == Block.field_402_as || var8.field_356_bn.func_27283_g())) {
            var8 = null;
         }

         return p_695_1_ > 0 && var8 == null && var9.func_28030_e(this, p_695_2_, p_695_3_, p_695_4_, p_695_6_);
      }
   }

   public PathEntity func_48463_a(Entity p_48463_1_, Entity p_48463_2_, float p_48463_3_, boolean p_48463_4_, boolean p_48463_5_, boolean p_48463_6_, boolean p_48463_7_) {
      Profiler.func_40663_a("pathfind");
      int var8 = MathHelper.func_1108_b(p_48463_1_.field_611_ak);
      int var9 = MathHelper.func_1108_b(p_48463_1_.field_610_al + 1.0D);
      int var10 = MathHelper.func_1108_b(p_48463_1_.field_609_am);
      int var11 = (int)(p_48463_3_ + 16.0F);
      int var12 = var8 - var11;
      int var13 = var9 - var11;
      int var14 = var10 - var11;
      int var15 = var8 + var11;
      int var16 = var9 + var11;
      int var17 = var10 + var11;
      ChunkCache var18 = new ChunkCache(this, var12, var13, var14, var15, var16, var17);
      PathEntity var19 = (new PathFinder(var18, p_48463_4_, p_48463_5_, p_48463_6_, p_48463_7_)).func_1137_a(p_48463_1_, p_48463_2_, p_48463_3_);
      Profiler.func_40662_b();
      return var19;
   }

   public PathEntity func_48460_a(Entity p_48460_1_, int p_48460_2_, int p_48460_3_, int p_48460_4_, float p_48460_5_, boolean p_48460_6_, boolean p_48460_7_, boolean p_48460_8_, boolean p_48460_9_) {
      Profiler.func_40663_a("pathfind");
      int var10 = MathHelper.func_1108_b(p_48460_1_.field_611_ak);
      int var11 = MathHelper.func_1108_b(p_48460_1_.field_610_al);
      int var12 = MathHelper.func_1108_b(p_48460_1_.field_609_am);
      int var13 = (int)(p_48460_5_ + 8.0F);
      int var14 = var10 - var13;
      int var15 = var11 - var13;
      int var16 = var12 - var13;
      int var17 = var10 + var13;
      int var18 = var11 + var13;
      int var19 = var12 + var13;
      ChunkCache var20 = new ChunkCache(this, var14, var15, var16, var17, var18, var19);
      PathEntity var21 = (new PathFinder(var20, p_48460_6_, p_48460_7_, p_48460_8_, p_48460_9_)).func_1131_a(p_48460_1_, p_48460_2_, p_48460_3_, p_48460_4_, p_48460_5_);
      Profiler.func_40662_b();
      return var21;
   }

   public boolean func_668_j(int p_668_1_, int p_668_2_, int p_668_3_, int p_668_4_) {
      int var5 = this.func_600_a(p_668_1_, p_668_2_, p_668_3_);
      return var5 == 0?false:Block.field_345_n[var5].func_228_c(this, p_668_1_, p_668_2_, p_668_3_, p_668_4_);
   }

   public boolean func_646_n(int p_646_1_, int p_646_2_, int p_646_3_) {
      return this.func_668_j(p_646_1_, p_646_2_ - 1, p_646_3_, 0)?true:(this.func_668_j(p_646_1_, p_646_2_ + 1, p_646_3_, 1)?true:(this.func_668_j(p_646_1_, p_646_2_, p_646_3_ - 1, 2)?true:(this.func_668_j(p_646_1_, p_646_2_, p_646_3_ + 1, 3)?true:(this.func_668_j(p_646_1_ - 1, p_646_2_, p_646_3_, 4)?true:this.func_668_j(p_646_1_ + 1, p_646_2_, p_646_3_, 5)))));
   }

   public boolean func_706_k(int p_706_1_, int p_706_2_, int p_706_3_, int p_706_4_) {
      if(this.func_28100_h(p_706_1_, p_706_2_, p_706_3_)) {
         return this.func_646_n(p_706_1_, p_706_2_, p_706_3_);
      } else {
         int var5 = this.func_600_a(p_706_1_, p_706_2_, p_706_3_);
         return var5 == 0?false:Block.field_345_n[var5].func_231_b(this, p_706_1_, p_706_2_, p_706_3_, p_706_4_);
      }
   }

   public boolean func_625_o(int p_625_1_, int p_625_2_, int p_625_3_) {
      return this.func_706_k(p_625_1_, p_625_2_ - 1, p_625_3_, 0)?true:(this.func_706_k(p_625_1_, p_625_2_ + 1, p_625_3_, 1)?true:(this.func_706_k(p_625_1_, p_625_2_, p_625_3_ - 1, 2)?true:(this.func_706_k(p_625_1_, p_625_2_, p_625_3_ + 1, 3)?true:(this.func_706_k(p_625_1_ - 1, p_625_2_, p_625_3_, 4)?true:this.func_706_k(p_625_1_ + 1, p_625_2_, p_625_3_, 5)))));
   }

   public EntityPlayer func_609_a(Entity p_609_1_, double p_609_2_) {
      return this.func_683_a(p_609_1_.field_611_ak, p_609_1_.field_610_al, p_609_1_.field_609_am, p_609_2_);
   }

   public EntityPlayer func_683_a(double p_683_1_, double p_683_3_, double p_683_5_, double p_683_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_1040_k.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_1040_k.get(var12);
         double var14 = var13.func_360_d(p_683_1_, p_683_3_, p_683_5_);
         if((p_683_7_ < 0.0D || var14 < p_683_7_ * p_683_7_) && (var9 == -1.0D || var14 < var9)) {
            var9 = var14;
            var11 = var13;
         }
      }

      return var11;
   }

   public EntityPlayer func_48456_a(double p_48456_1_, double p_48456_3_, double p_48456_5_) {
      double var7 = -1.0D;
      EntityPlayer var9 = null;

      for(int var10 = 0; var10 < this.field_1040_k.size(); ++var10) {
         EntityPlayer var11 = (EntityPlayer)this.field_1040_k.get(var10);
         double var12 = var11.func_360_d(p_48456_1_, var11.field_610_al, p_48456_3_);
         if((p_48456_5_ < 0.0D || var12 < p_48456_5_ * p_48456_5_) && (var7 == -1.0D || var12 < var7)) {
            var7 = var12;
            var9 = var11;
         }
      }

      return var9;
   }

   public EntityPlayer func_40480_b(Entity p_40480_1_, double p_40480_2_) {
      return this.func_40473_b(p_40480_1_.field_611_ak, p_40480_1_.field_610_al, p_40480_1_.field_609_am, p_40480_2_);
   }

   public EntityPlayer func_40473_b(double p_40473_1_, double p_40473_3_, double p_40473_5_, double p_40473_7_) {
      double var9 = -1.0D;
      EntityPlayer var11 = null;

      for(int var12 = 0; var12 < this.field_1040_k.size(); ++var12) {
         EntityPlayer var13 = (EntityPlayer)this.field_1040_k.get(var12);
         if(!var13.field_35212_aW.field_35759_a) {
            double var14 = var13.func_360_d(p_40473_1_, p_40473_3_, p_40473_5_);
            if((p_40473_7_ < 0.0D || var14 < p_40473_7_ * p_40473_7_) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public EntityPlayer func_25099_a(String p_25099_1_) {
      for(int var2 = 0; var2 < this.field_1040_k.size(); ++var2) {
         if(p_25099_1_.equals(((EntityPlayer)this.field_1040_k.get(var2)).field_771_i)) {
            return (EntityPlayer)this.field_1040_k.get(var2);
         }
      }

      return null;
   }

   public void func_660_k() {}

   public void func_663_l() {
      this.field_22147_p.func_22150_b();
   }

   public void func_648_a(long p_648_1_) {
      this.field_22145_q.func_22307_a(p_648_1_);
   }

   public long func_22138_q() {
      return this.field_22145_q.func_22288_b();
   }

   public long func_22139_r() {
      return this.field_22145_q.func_22304_f();
   }

   public ChunkCoordinates func_22137_s() {
      return new ChunkCoordinates(this.field_22145_q.func_22293_c(), this.field_22145_q.func_22295_d(), this.field_22145_q.func_22300_e());
   }

   public void func_22143_a(ChunkCoordinates p_22143_1_) {
      this.field_22145_q.func_22292_a(p_22143_1_.field_22395_a, p_22143_1_.field_22394_b, p_22143_1_.field_22396_c);
   }

   public void func_705_f(Entity p_705_1_) {
      int var2 = MathHelper.func_1108_b(p_705_1_.field_611_ak / 16.0D);
      int var3 = MathHelper.func_1108_b(p_705_1_.field_609_am / 16.0D);
      byte var4 = 2;

      for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
         for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
            this.func_704_b(var5, var6);
         }
      }

      if(!this.field_1050_a.contains(p_705_1_)) {
         this.field_1050_a.add(p_705_1_);
      }

   }

   public boolean func_6466_a(EntityPlayer p_6466_1_, int p_6466_2_, int p_6466_3_, int p_6466_4_) {
      return true;
   }

   public void func_9425_a(Entity p_9425_1_, byte p_9425_2_) {}

   public void func_9424_o() {
      this.field_1050_a.removeAll(this.field_1024_A);

      int var1;
      Entity var2;
      int var3;
      int var4;
      for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
         var2 = (Entity)this.field_1024_A.get(var1);
         var3 = var2.field_657_ba;
         var4 = var2.field_654_bc;
         if(var2.field_621_aZ && this.func_620_h(var3, var4)) {
            this.func_704_b(var3, var4).func_1015_b(var2);
         }
      }

      for(var1 = 0; var1 < this.field_1024_A.size(); ++var1) {
         this.func_678_c((Entity)this.field_1024_A.get(var1));
      }

      this.field_1024_A.clear();

      for(var1 = 0; var1 < this.field_1050_a.size(); ++var1) {
         var2 = (Entity)this.field_1050_a.get(var1);
         if(var2.field_616_af != null) {
            if(!var2.field_616_af.field_646_aA && var2.field_616_af.field_617_ae == var2) {
               continue;
            }

            var2.field_616_af.field_617_ae = null;
            var2.field_616_af = null;
         }

         if(var2.field_646_aA) {
            var3 = var2.field_657_ba;
            var4 = var2.field_654_bc;
            if(var2.field_621_aZ && this.func_620_h(var3, var4)) {
               this.func_704_b(var3, var4).func_1015_b(var2);
            }

            this.field_1050_a.remove(var1--);
            this.func_678_c(var2);
         }
      }

   }

   public IChunkProvider func_21118_q() {
      return this.field_1017_H;
   }

   public void func_21116_c(int p_21116_1_, int p_21116_2_, int p_21116_3_, int p_21116_4_, int p_21116_5_) {
      int var6 = this.func_600_a(p_21116_1_, p_21116_2_, p_21116_3_);
      if(var6 > 0) {
         Block.field_345_n[var6].func_21024_a(this, p_21116_1_, p_21116_2_, p_21116_3_, p_21116_4_, p_21116_5_);
      }

   }

   public ISaveHandler func_40479_y() {
      return this.field_22147_p;
   }

   public WorldInfo func_22144_v() {
      return this.field_22145_q;
   }

   public void func_22140_w() {
      this.field_22146_A = !this.field_1040_k.isEmpty();
      Iterator var1 = this.field_1040_k.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         if(!var2.func_22051_K()) {
            this.field_22146_A = false;
            break;
         }
      }

   }

   protected void func_22141_x() {
      this.field_22146_A = false;
      Iterator var1 = this.field_1040_k.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         if(var2.func_22051_K()) {
            var2.func_22056_a(false, false, true);
         }
      }

      this.func_27164_F();
   }

   public boolean func_22142_y() {
      if(this.field_22146_A && !this.field_1026_y) {
         Iterator var1 = this.field_1040_k.iterator();

         EntityPlayer var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (EntityPlayer)var1.next();
         } while(var2.func_22054_L());

         return false;
      } else {
         return false;
      }
   }

   public float func_27166_f(float p_27166_1_) {
      return (this.field_27170_D + (this.field_27169_E - this.field_27170_D) * p_27166_1_) * this.func_27162_g(p_27166_1_);
   }

   public float func_27162_g(float p_27162_1_) {
      return this.field_26901_B + (this.field_27171_C - this.field_26901_B) * p_27162_1_;
   }

   public void func_27158_h(float p_27158_1_) {
      this.field_26901_B = p_27158_1_;
      this.field_27171_C = p_27158_1_;
   }

   public boolean func_27160_B() {
      return (double)this.func_27166_f(1.0F) > 0.9D;
   }

   public boolean func_27161_C() {
      return (double)this.func_27162_g(1.0F) > 0.2D;
   }

   public boolean func_27167_r(int p_27167_1_, int p_27167_2_, int p_27167_3_) {
      if(!this.func_27161_C()) {
         return false;
      } else if(!this.func_647_i(p_27167_1_, p_27167_2_, p_27167_3_)) {
         return false;
      } else if(this.func_35461_e(p_27167_1_, p_27167_3_) > p_27167_2_) {
         return false;
      } else {
         BiomeGenBase var4 = this.func_48454_a(p_27167_1_, p_27167_3_);
         return var4.func_27078_c()?false:var4.func_27077_d();
      }
   }

   public boolean func_48455_z(int p_48455_1_, int p_48455_2_, int p_48455_3_) {
      BiomeGenBase var4 = this.func_48454_a(p_48455_1_, p_48455_3_);
      return var4.func_48413_d();
   }

   public void func_28102_a(String p_28102_1_, WorldSavedData p_28102_2_) {
      this.field_28108_z.func_28184_a(p_28102_1_, p_28102_2_);
   }

   public WorldSavedData func_28103_a(Class p_28103_1_, String p_28103_2_) {
      return this.field_28108_z.func_28185_a(p_28103_1_, p_28103_2_);
   }

   public int func_28101_b(String p_28101_1_) {
      return this.field_28108_z.func_28186_a(p_28101_1_);
   }

   public void func_28106_e(int p_28106_1_, int p_28106_2_, int p_28106_3_, int p_28106_4_, int p_28106_5_) {
      this.func_28107_a((EntityPlayer)null, p_28106_1_, p_28106_2_, p_28106_3_, p_28106_4_, p_28106_5_);
   }

   public void func_28107_a(EntityPlayer p_28107_1_, int p_28107_2_, int p_28107_3_, int p_28107_4_, int p_28107_5_, int p_28107_6_) {
      for(int var7 = 0; var7 < this.field_9434_r.size(); ++var7) {
         ((IWorldAccess)this.field_9434_r.get(var7)).func_28136_a(p_28107_1_, p_28107_2_, p_28107_3_, p_28107_4_, p_28107_5_, p_28107_6_);
      }

   }

   public int func_48453_b() {
      return 256;
   }

   public Random func_35462_u(int p_35462_1_, int p_35462_2_, int p_35462_3_) {
      long var4 = (long)p_35462_1_ * 341873128712L + (long)p_35462_2_ * 132897987541L + this.func_22144_v().func_22288_b() + (long)p_35462_3_;
      this.field_1037_n.setSeed(var4);
      return this.field_1037_n;
   }

   public boolean func_6465_g() {
      return false;
   }

   public SpawnListEntry func_40474_a(EnumCreatureType p_40474_1_, int p_40474_2_, int p_40474_3_, int p_40474_4_) {
      List var5 = this.func_21118_q().func_40377_a(p_40474_1_, p_40474_2_, p_40474_3_, p_40474_4_);
      return var5 != null && !var5.isEmpty()?(SpawnListEntry)WeightedRandom.func_35733_a(this.field_1037_n, var5):null;
   }

   public ChunkPosition func_40477_b(String p_40477_1_, int p_40477_2_, int p_40477_3_, int p_40477_4_) {
      return this.func_21118_q().func_40376_a(this, p_40477_1_, p_40477_2_, p_40477_3_, p_40477_4_);
   }

   public boolean func_48452_a() {
      return false;
   }

   public double func_46068_G() {
      return this.field_22145_q.func_46133_t() == WorldType.field_48636_c?0.0D:63.0D;
   }
}
