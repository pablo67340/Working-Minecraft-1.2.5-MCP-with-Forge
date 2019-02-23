package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.src.AnvilChunkLoaderPending;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.ExtendedBlockStorage;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IThreadedFileIO;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NextTickListEntry;
import net.minecraft.src.NibbleArray;
import net.minecraft.src.RegionFileCache;
import net.minecraft.src.ThreadedFileIOBase;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class AnvilChunkLoader implements IThreadedFileIO, IChunkLoader {

   private List field_48451_a = new ArrayList();
   private Set field_48449_b = new HashSet();
   private Object field_48450_c = new Object();
   private final File field_48448_d;


   public AnvilChunkLoader(File p_i1014_1_) {
      this.field_48448_d = p_i1014_1_;
   }

   public Chunk func_813_a(World p_813_1_, int p_813_2_, int p_813_3_) throws IOException {
      NBTTagCompound var4 = null;
      ChunkCoordIntPair var5 = new ChunkCoordIntPair(p_813_2_, p_813_3_);
      Object var6 = this.field_48450_c;
      synchronized(this.field_48450_c) {
         if(this.field_48449_b.contains(var5)) {
            for(int var7 = 0; var7 < this.field_48451_a.size(); ++var7) {
               if(((AnvilChunkLoaderPending)this.field_48451_a.get(var7)).field_48427_a.equals(var5)) {
                  var4 = ((AnvilChunkLoaderPending)this.field_48451_a.get(var7)).field_48426_b;
                  break;
               }
            }
         }
      }

      if(var4 == null) {
         DataInputStream var10 = RegionFileCache.func_22194_c(this.field_48448_d, p_813_2_, p_813_3_);
         if(var10 == null) {
            return null;
         }

         var4 = CompressedStreamTools.func_1141_a(var10);
      }

      return this.func_48443_a(p_813_1_, p_813_2_, p_813_3_, var4);
   }

   protected Chunk func_48443_a(World p_48443_1_, int p_48443_2_, int p_48443_3_, NBTTagCompound p_48443_4_) {
      if(!p_48443_4_.func_751_b("Level")) {
         System.out.println("Chunk file at " + p_48443_2_ + "," + p_48443_3_ + " is missing level data, skipping");
         return null;
      } else if(!p_48443_4_.func_743_k("Level").func_751_b("Sections")) {
         System.out.println("Chunk file at " + p_48443_2_ + "," + p_48443_3_ + " is missing block data, skipping");
         return null;
      } else {
         Chunk var5 = this.func_48444_a(p_48443_1_, p_48443_4_.func_743_k("Level"));
         if(!var5.func_1017_a(p_48443_2_, p_48443_3_)) {
            System.out.println("Chunk file at " + p_48443_2_ + "," + p_48443_3_ + " is in the wrong location; relocating. (Expected " + p_48443_2_ + ", " + p_48443_3_ + ", got " + var5.field_1531_j + ", " + var5.field_1530_k + ")");
            p_48443_4_.func_758_a("xPos", p_48443_2_);
            p_48443_4_.func_758_a("zPos", p_48443_3_);
            var5 = this.func_48444_a(p_48443_1_, p_48443_4_.func_743_k("Level"));
         }

         var5.func_25124_i();
         return var5;
      }
   }

   public void func_812_a(World p_812_1_, Chunk p_812_2_) throws IOException {
      p_812_1_.func_663_l();

      try {
         NBTTagCompound var3 = new NBTTagCompound();
         NBTTagCompound var4 = new NBTTagCompound();
         var3.func_762_a("Level", var4);
         this.func_48445_a(p_812_2_, p_812_1_, var4);
         this.func_48446_a(p_812_2_.func_40740_k(), var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected void func_48446_a(ChunkCoordIntPair p_48446_1_, NBTTagCompound p_48446_2_) {
      Object var3 = this.field_48450_c;
      synchronized(this.field_48450_c) {
         if(this.field_48449_b.contains(p_48446_1_)) {
            for(int var4 = 0; var4 < this.field_48451_a.size(); ++var4) {
               if(((AnvilChunkLoaderPending)this.field_48451_a.get(var4)).field_48427_a.equals(p_48446_1_)) {
                  this.field_48451_a.set(var4, new AnvilChunkLoaderPending(p_48446_1_, p_48446_2_));
                  return;
               }
            }
         }

         this.field_48451_a.add(new AnvilChunkLoaderPending(p_48446_1_, p_48446_2_));
         this.field_48449_b.add(p_48446_1_);
         ThreadedFileIOBase.field_40573_a.func_40567_a(this);
      }
   }

   public boolean func_40550_A_() {
      AnvilChunkLoaderPending var1 = null;
      Object var2 = this.field_48450_c;
      synchronized(this.field_48450_c) {
         if(this.field_48451_a.size() <= 0) {
            return false;
         }

         var1 = (AnvilChunkLoaderPending)this.field_48451_a.remove(0);
         this.field_48449_b.remove(var1.field_48427_a);
      }

      if(var1 != null) {
         try {
            this.func_48447_a(var1);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return true;
   }

   private void func_48447_a(AnvilChunkLoaderPending p_48447_1_) throws IOException {
      DataOutputStream var2 = RegionFileCache.func_22190_d(this.field_48448_d, p_48447_1_.field_48427_a.field_189_a, p_48447_1_.field_48427_a.field_188_b);
      CompressedStreamTools.func_1139_a(p_48447_1_.field_48426_b, var2);
      var2.close();
   }

   public void func_815_b(World p_815_1_, Chunk p_815_2_) throws IOException {}

   public void func_814_a() {}

   public void func_811_b() {}

   private void func_48445_a(Chunk p_48445_1_, World p_48445_2_, NBTTagCompound p_48445_3_) {
      p_48445_2_.func_663_l();
      p_48445_3_.func_758_a("xPos", p_48445_1_.field_1531_j);
      p_48445_3_.func_758_a("zPos", p_48445_1_.field_1530_k);
      p_48445_3_.func_750_a("LastUpdate", p_48445_2_.func_22139_r());
      p_48445_3_.func_48183_a("HeightMap", p_48445_1_.field_48501_f);
      p_48445_3_.func_748_a("TerrainPopulated", p_48445_1_.field_1527_n);
      ExtendedBlockStorage[] var4 = p_48445_1_.func_48495_i();
      NBTTagList var5 = new NBTTagList("Sections");
      ExtendedBlockStorage[] var6 = var4;
      int var7 = var4.length;

      NBTTagCompound var10;
      for(int var8 = 0; var8 < var7; ++var8) {
         ExtendedBlockStorage var9 = var6[var8];
         if(var9 != null && var9.func_48700_f() != 0) {
            var10 = new NBTTagCompound();
            var10.func_761_a("Y", (byte)(var9.func_48707_c() >> 4 & 255));
            var10.func_747_a("Blocks", var9.func_48692_g());
            if(var9.func_48704_i() != null) {
               var10.func_747_a("Add", var9.func_48704_i().field_1109_a);
            }

            var10.func_747_a("Data", var9.func_48697_j().field_1109_a);
            var10.func_747_a("SkyLight", var9.func_48714_l().field_1109_a);
            var10.func_747_a("BlockLight", var9.func_48705_k().field_1109_a);
            var5.func_742_a(var10);
         }
      }

      p_48445_3_.func_762_a("Sections", var5);
      p_48445_3_.func_747_a("Biomes", p_48445_1_.func_48493_m());
      p_48445_1_.field_1523_r = false;
      NBTTagList var15 = new NBTTagList();

      Iterator var17;
      for(var7 = 0; var7 < p_48445_1_.field_48502_j.length; ++var7) {
         var17 = p_48445_1_.field_48502_j[var7].iterator();

         while(var17.hasNext()) {
            Entity var19 = (Entity)var17.next();
            p_48445_1_.field_1523_r = true;
            var10 = new NBTTagCompound();
            if(var19.func_358_c(var10)) {
               var15.func_742_a(var10);
            }
         }
      }

      p_48445_3_.func_762_a("Entities", var15);
      NBTTagList var16 = new NBTTagList();
      var17 = p_48445_1_.field_1529_l.values().iterator();

      while(var17.hasNext()) {
         TileEntity var20 = (TileEntity)var17.next();
         var10 = new NBTTagCompound();
         var20.func_481_b(var10);
         var16.func_742_a(var10);
      }

      p_48445_3_.func_762_a("TileEntities", var16);
      List var18 = p_48445_2_.func_41081_a(p_48445_1_, false);
      if(var18 != null) {
         long var21 = p_48445_2_.func_22139_r();
         NBTTagList var11 = new NBTTagList();
         Iterator var12 = var18.iterator();

         while(var12.hasNext()) {
            NextTickListEntry var13 = (NextTickListEntry)var12.next();
            NBTTagCompound var14 = new NBTTagCompound();
            var14.func_758_a("i", var13.field_1365_d);
            var14.func_758_a("x", var13.field_1361_a);
            var14.func_758_a("y", var13.field_1360_b);
            var14.func_758_a("z", var13.field_1366_c);
            var14.func_758_a("t", (int)(var13.field_1364_e - var21));
            var11.func_742_a(var14);
         }

         p_48445_3_.func_762_a("TileTicks", var11);
      }

   }

   private Chunk func_48444_a(World p_48444_1_, NBTTagCompound p_48444_2_) {
      int var3 = p_48444_2_.func_756_e("xPos");
      int var4 = p_48444_2_.func_756_e("zPos");
      Chunk var5 = new Chunk(p_48444_1_, var3, var4);
      var5.field_48501_f = p_48444_2_.func_48182_l("HeightMap");
      var5.field_1527_n = p_48444_2_.func_760_m("TerrainPopulated");
      NBTTagList var6 = p_48444_2_.func_753_l("Sections");
      byte var7 = 16;
      ExtendedBlockStorage[] var8 = new ExtendedBlockStorage[var7];

      for(int var9 = 0; var9 < var6.func_740_c(); ++var9) {
         NBTTagCompound var10 = (NBTTagCompound)var6.func_741_a(var9);
         byte var11 = var10.func_746_c("Y");
         ExtendedBlockStorage var12 = new ExtendedBlockStorage(var11 << 4);
         var12.func_48706_a(var10.func_759_j("Blocks"));
         if(var10.func_751_b("Add")) {
            var12.func_48710_a(new NibbleArray(var10.func_759_j("Add"), 4));
         }

         var12.func_48701_b(new NibbleArray(var10.func_759_j("Data"), 4));
         var12.func_48713_d(new NibbleArray(var10.func_759_j("SkyLight"), 4));
         var12.func_48695_c(new NibbleArray(var10.func_759_j("BlockLight"), 4));
         var12.func_48708_d();
         var8[var11] = var12;
      }

      var5.func_48500_a(var8);
      if(p_48444_2_.func_751_b("Biomes")) {
         var5.func_48497_a(p_48444_2_.func_759_j("Biomes"));
      }

      NBTTagList var14 = p_48444_2_.func_753_l("Entities");
      if(var14 != null) {
         for(int var15 = 0; var15 < var14.func_740_c(); ++var15) {
            NBTTagCompound var17 = (NBTTagCompound)var14.func_741_a(var15);
            Entity var19 = EntityList.func_1081_a(var17, p_48444_1_);
            var5.field_1523_r = true;
            if(var19 != null) {
               var5.func_1000_a(var19);
            }
         }
      }

      NBTTagList var16 = p_48444_2_.func_753_l("TileEntities");
      if(var16 != null) {
         for(int var18 = 0; var18 < var16.func_740_c(); ++var18) {
            NBTTagCompound var21 = (NBTTagCompound)var16.func_741_a(var18);
            TileEntity var13 = TileEntity.func_477_c(var21);
            if(var13 != null) {
               var5.func_1001_a(var13);
            }
         }
      }

      if(p_48444_2_.func_751_b("TileTicks")) {
         NBTTagList var20 = p_48444_2_.func_753_l("TileTicks");
         if(var20 != null) {
            for(int var22 = 0; var22 < var20.func_740_c(); ++var22) {
               NBTTagCompound var23 = (NBTTagCompound)var20.func_741_a(var22);
               p_48444_1_.func_41083_e(var23.func_756_e("x"), var23.func_756_e("y"), var23.func_756_e("z"), var23.func_756_e("i"), var23.func_756_e("t"));
            }
         }
      }

      return var5;
   }
}
