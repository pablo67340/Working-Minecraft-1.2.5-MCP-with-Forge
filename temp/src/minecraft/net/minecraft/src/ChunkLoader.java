package net.minecraft.src;

import net.minecraft.src.AnvilConverterData;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NibbleArray;
import net.minecraft.src.NibbleArrayReader;
import net.minecraft.src.WorldChunkManager;

public class ChunkLoader {

   public static AnvilConverterData func_48485_a(NBTTagCompound p_48485_0_) {
      int var1 = p_48485_0_.func_756_e("xPos");
      int var2 = p_48485_0_.func_756_e("zPos");
      AnvilConverterData var3 = new AnvilConverterData(var1, var2);
      var3.field_48603_g = p_48485_0_.func_759_j("Blocks");
      var3.field_48602_f = new NibbleArrayReader(p_48485_0_.func_759_j("Data"), 7);
      var3.field_48605_e = new NibbleArrayReader(p_48485_0_.func_759_j("SkyLight"), 7);
      var3.field_48604_d = new NibbleArrayReader(p_48485_0_.func_759_j("BlockLight"), 7);
      var3.field_48607_c = p_48485_0_.func_759_j("HeightMap");
      var3.field_48606_b = p_48485_0_.func_760_m("TerrainPopulated");
      var3.field_48612_h = p_48485_0_.func_753_l("Entities");
      var3.field_48613_i = p_48485_0_.func_753_l("TileEntities");
      var3.field_48610_j = p_48485_0_.func_753_l("TileTicks");

      try {
         var3.field_48608_a = p_48485_0_.func_764_f("LastUpdate");
      } catch (ClassCastException var5) {
         var3.field_48608_a = (long)p_48485_0_.func_756_e("LastUpdate");
      }

      return var3;
   }

   public static void func_48486_a(AnvilConverterData p_48486_0_, NBTTagCompound p_48486_1_, WorldChunkManager p_48486_2_) {
      p_48486_1_.func_758_a("xPos", p_48486_0_.field_48611_k);
      p_48486_1_.func_758_a("zPos", p_48486_0_.field_48609_l);
      p_48486_1_.func_750_a("LastUpdate", p_48486_0_.field_48608_a);
      int[] var3 = new int[p_48486_0_.field_48607_c.length];

      for(int var4 = 0; var4 < p_48486_0_.field_48607_c.length; ++var4) {
         var3[var4] = p_48486_0_.field_48607_c[var4];
      }

      p_48486_1_.func_48183_a("HeightMap", var3);
      p_48486_1_.func_748_a("TerrainPopulated", p_48486_0_.field_48606_b);
      NBTTagList var16 = new NBTTagList("Sections");

      int var7;
      for(int var5 = 0; var5 < 8; ++var5) {
         boolean var6 = true;

         for(var7 = 0; var7 < 16 && var6; ++var7) {
            int var8 = 0;

            while(var8 < 16 && var6) {
               int var9 = 0;

               while(true) {
                  if(var9 < 16) {
                     int var10 = var7 << 11 | var9 << 7 | var8 + (var5 << 4);
                     byte var11 = p_48486_0_.field_48603_g[var10];
                     if(var11 == 0) {
                        ++var9;
                        continue;
                     }

                     var6 = false;
                  }

                  ++var8;
                  break;
               }
            }
         }

         if(!var6) {
            byte[] var19 = new byte[4096];
            NibbleArray var20 = new NibbleArray(var19.length, 4);
            NibbleArray var21 = new NibbleArray(var19.length, 4);
            NibbleArray var22 = new NibbleArray(var19.length, 4);

            for(int var23 = 0; var23 < 16; ++var23) {
               for(int var12 = 0; var12 < 16; ++var12) {
                  for(int var13 = 0; var13 < 16; ++var13) {
                     int var14 = var23 << 11 | var13 << 7 | var12 + (var5 << 4);
                     byte var15 = p_48486_0_.field_48603_g[var14];
                     var19[var12 << 8 | var13 << 4 | var23] = (byte)(var15 & 255);
                     var20.func_770_a(var23, var12, var13, p_48486_0_.field_48602_f.func_48508_a(var23, var12 + (var5 << 4), var13));
                     var21.func_770_a(var23, var12, var13, p_48486_0_.field_48605_e.func_48508_a(var23, var12 + (var5 << 4), var13));
                     var22.func_770_a(var23, var12, var13, p_48486_0_.field_48604_d.func_48508_a(var23, var12 + (var5 << 4), var13));
                  }
               }
            }

            NBTTagCompound var24 = new NBTTagCompound();
            var24.func_761_a("Y", (byte)(var5 & 255));
            var24.func_747_a("Blocks", var19);
            var24.func_747_a("Data", var20.field_1109_a);
            var24.func_747_a("SkyLight", var21.field_1109_a);
            var24.func_747_a("BlockLight", var22.field_1109_a);
            var16.func_742_a(var24);
         }
      }

      p_48486_1_.func_762_a("Sections", var16);
      byte[] var17 = new byte[256];

      for(int var18 = 0; var18 < 16; ++var18) {
         for(var7 = 0; var7 < 16; ++var7) {
            var17[var7 << 4 | var18] = (byte)(p_48486_2_.func_4073_a(p_48486_0_.field_48611_k << 4 | var18, p_48486_0_.field_48609_l << 4 | var7).field_35494_y & 255);
         }
      }

      p_48486_1_.func_747_a("Biomes", var17);
      p_48486_1_.func_762_a("Entities", p_48486_0_.field_48612_h);
      p_48486_1_.func_762_a("TileEntities", p_48486_0_.field_48613_i);
      if(p_48486_0_.field_48610_j != null) {
         p_48486_1_.func_762_a("TileTicks", p_48486_0_.field_48610_j);
      }

   }
}
