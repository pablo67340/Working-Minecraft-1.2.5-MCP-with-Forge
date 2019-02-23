package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WeightedRandom;
import net.minecraft.src.World;

public final class SpawnerAnimals {

   private static HashMap field_6544_a = new HashMap();
   protected static final Class[] field_22391_a = new Class[]{EntitySpider.class, EntityZombie.class, EntitySkeleton.class};


   protected static ChunkPosition func_4153_a(World p_4153_0_, int p_4153_1_, int p_4153_2_) {
      Chunk var3 = p_4153_0_.func_704_b(p_4153_1_, p_4153_2_);
      int var4 = p_4153_1_ * 16 + p_4153_0_.field_1037_n.nextInt(16);
      int var5 = p_4153_0_.field_1037_n.nextInt(var3 == null?128:Math.max(128, var3.func_48498_h()));
      int var6 = p_4153_2_ * 16 + p_4153_0_.field_1037_n.nextInt(16);
      return new ChunkPosition(var4, var5, var6);
   }

   public static final int func_4154_a(World p_4154_0_, boolean p_4154_1_, boolean p_4154_2_) {
      if(!p_4154_1_ && !p_4154_2_) {
         return 0;
      } else {
         field_6544_a.clear();

         int var3;
         int var6;
         for(var3 = 0; var3 < p_4154_0_.field_1040_k.size(); ++var3) {
            EntityPlayer var4 = (EntityPlayer)p_4154_0_.field_1040_k.get(var3);
            int var5 = MathHelper.func_1108_b(var4.field_611_ak / 16.0D);
            var6 = MathHelper.func_1108_b(var4.field_609_am / 16.0D);
            byte var7 = 8;

            for(int var8 = -var7; var8 <= var7; ++var8) {
               for(int var9 = -var7; var9 <= var7; ++var9) {
                  boolean var10 = var8 == -var7 || var8 == var7 || var9 == -var7 || var9 == var7;
                  ChunkCoordIntPair var11 = new ChunkCoordIntPair(var8 + var5, var9 + var6);
                  if(!var10) {
                     field_6544_a.put(var11, Boolean.valueOf(false));
                  } else if(!field_6544_a.containsKey(var11)) {
                     field_6544_a.put(var11, Boolean.valueOf(true));
                  }
               }
            }
         }

         var3 = 0;
         ChunkCoordinates var31 = p_4154_0_.func_22137_s();
         EnumCreatureType[] var32 = EnumCreatureType.values();
         var6 = var32.length;

         for(int var33 = 0; var33 < var6; ++var33) {
            EnumCreatureType var34 = var32[var33];
            if((!var34.func_21168_d() || p_4154_2_) && (var34.func_21168_d() || p_4154_1_) && p_4154_0_.func_621_b(var34.func_21170_a()) <= var34.func_21169_b() * field_6544_a.size() / 256) {
               Iterator var35 = field_6544_a.keySet().iterator();

               label108:
               while(var35.hasNext()) {
                  ChunkCoordIntPair var36 = (ChunkCoordIntPair)var35.next();
                  if(!((Boolean)field_6544_a.get(var36)).booleanValue()) {
                     ChunkPosition var37 = func_4153_a(p_4154_0_, var36.field_189_a, var36.field_188_b);
                     int var12 = var37.field_1111_a;
                     int var13 = var37.field_1110_b;
                     int var14 = var37.field_1112_c;
                     if(!p_4154_0_.func_28100_h(var12, var13, var14) && p_4154_0_.func_599_f(var12, var13, var14) == var34.func_21171_c()) {
                        int var15 = 0;
                        int var16 = 0;

                        while(var16 < 3) {
                           int var17 = var12;
                           int var18 = var13;
                           int var19 = var14;
                           byte var20 = 6;
                           SpawnListEntry var21 = null;
                           int var22 = 0;

                           while(true) {
                              if(var22 < 4) {
                                 label101: {
                                    var17 += p_4154_0_.field_1037_n.nextInt(var20) - p_4154_0_.field_1037_n.nextInt(var20);
                                    var18 += p_4154_0_.field_1037_n.nextInt(1) - p_4154_0_.field_1037_n.nextInt(1);
                                    var19 += p_4154_0_.field_1037_n.nextInt(var20) - p_4154_0_.field_1037_n.nextInt(var20);
                                    if(func_21203_a(var34, p_4154_0_, var17, var18, var19)) {
                                       float var23 = (float)var17 + 0.5F;
                                       float var24 = (float)var18;
                                       float var25 = (float)var19 + 0.5F;
                                       if(p_4154_0_.func_683_a((double)var23, (double)var24, (double)var25, 24.0D) == null) {
                                          float var26 = var23 - (float)var31.field_22395_a;
                                          float var27 = var24 - (float)var31.field_22394_b;
                                          float var28 = var25 - (float)var31.field_22396_c;
                                          float var29 = var26 * var26 + var27 * var27 + var28 * var28;
                                          if(var29 >= 576.0F) {
                                             if(var21 == null) {
                                                var21 = p_4154_0_.func_40474_a(var34, var17, var18, var19);
                                                if(var21 == null) {
                                                   break label101;
                                                }
                                             }

                                             EntityLiving var38;
                                             try {
                                                var38 = (EntityLiving)var21.field_25212_a.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_4154_0_});
                                             } catch (Exception var30) {
                                                var30.printStackTrace();
                                                return var3;
                                             }

                                             var38.func_365_c((double)var23, (double)var24, (double)var25, p_4154_0_.field_1037_n.nextFloat() * 360.0F, 0.0F);
                                             if(var38.func_433_a()) {
                                                ++var15;
                                                p_4154_0_.func_674_a(var38);
                                                func_21204_a(var38, p_4154_0_, var23, var24, var25);
                                                if(var15 >= var38.func_6391_i()) {
                                                   continue label108;
                                                }
                                             }

                                             var3 += var15;
                                          }
                                       }
                                    }

                                    ++var22;
                                    continue;
                                 }
                              }

                              ++var16;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }
   }

   public static boolean func_21203_a(EnumCreatureType p_21203_0_, World p_21203_1_, int p_21203_2_, int p_21203_3_, int p_21203_4_) {
      if(p_21203_0_.func_21171_c() == Material.field_1332_f) {
         return p_21203_1_.func_599_f(p_21203_2_, p_21203_3_, p_21203_4_).func_879_d() && !p_21203_1_.func_28100_h(p_21203_2_, p_21203_3_ + 1, p_21203_4_);
      } else {
         int var5 = p_21203_1_.func_600_a(p_21203_2_, p_21203_3_ - 1, p_21203_4_);
         return Block.func_48206_g(var5) && var5 != Block.field_403_A.field_376_bc && !p_21203_1_.func_28100_h(p_21203_2_, p_21203_3_, p_21203_4_) && !p_21203_1_.func_599_f(p_21203_2_, p_21203_3_, p_21203_4_).func_879_d() && !p_21203_1_.func_28100_h(p_21203_2_, p_21203_3_ + 1, p_21203_4_);
      }
   }

   private static void func_21204_a(EntityLiving p_21204_0_, World p_21204_1_, float p_21204_2_, float p_21204_3_, float p_21204_4_) {
      if(p_21204_0_ instanceof EntitySpider && p_21204_1_.field_1037_n.nextInt(100) == 0) {
         EntitySkeleton var7 = new EntitySkeleton(p_21204_1_);
         var7.func_365_c((double)p_21204_2_, (double)p_21204_3_, (double)p_21204_4_, p_21204_0_.field_605_aq, 0.0F);
         p_21204_1_.func_674_a(var7);
         var7.func_6377_h(p_21204_0_);
      } else if(p_21204_0_ instanceof EntitySheep) {
         ((EntitySheep)p_21204_0_).func_21071_b_(EntitySheep.func_21070_a(p_21204_1_.field_1037_n));
      } else if(p_21204_0_ instanceof EntityOcelot && p_21204_1_.field_1037_n.nextInt(7) == 0) {
         for(int var5 = 0; var5 < 2; ++var5) {
            EntityOcelot var6 = new EntityOcelot(p_21204_1_);
            var6.func_365_c((double)p_21204_2_, (double)p_21204_3_, (double)p_21204_4_, p_21204_0_.field_605_aq, 0.0F);
            var6.func_48122_d(-24000);
            p_21204_1_.func_674_a(var6);
         }
      }

   }

   public static void func_35957_a(World p_35957_0_, BiomeGenBase p_35957_1_, int p_35957_2_, int p_35957_3_, int p_35957_4_, int p_35957_5_, Random p_35957_6_) {
      List var7 = p_35957_1_.func_25063_a(EnumCreatureType.creature);
      if(!var7.isEmpty()) {
         while(p_35957_6_.nextFloat() < p_35957_1_.func_4119_a()) {
            SpawnListEntry var8 = (SpawnListEntry)WeightedRandom.func_35733_a(p_35957_0_.field_1037_n, var7);
            int var9 = var8.field_35591_b + p_35957_6_.nextInt(1 + var8.field_35592_c - var8.field_35591_b);
            int var10 = p_35957_2_ + p_35957_6_.nextInt(p_35957_4_);
            int var11 = p_35957_3_ + p_35957_6_.nextInt(p_35957_5_);
            int var12 = var10;
            int var13 = var11;

            for(int var14 = 0; var14 < var9; ++var14) {
               boolean var15 = false;

               for(int var16 = 0; !var15 && var16 < 4; ++var16) {
                  int var17 = p_35957_0_.func_4083_e(var10, var11);
                  if(func_21203_a(EnumCreatureType.creature, p_35957_0_, var10, var17, var11)) {
                     float var18 = (float)var10 + 0.5F;
                     float var19 = (float)var17;
                     float var20 = (float)var11 + 0.5F;

                     EntityLiving var21;
                     try {
                        var21 = (EntityLiving)var8.field_25212_a.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_35957_0_});
                     } catch (Exception var23) {
                        var23.printStackTrace();
                        continue;
                     }

                     var21.func_365_c((double)var18, (double)var19, (double)var20, p_35957_6_.nextFloat() * 360.0F, 0.0F);
                     p_35957_0_.func_674_a(var21);
                     func_21204_a(var21, p_35957_0_, var18, var19, var20);
                     var15 = true;
                  }

                  var10 += p_35957_6_.nextInt(5) - p_35957_6_.nextInt(5);

                  for(var11 += p_35957_6_.nextInt(5) - p_35957_6_.nextInt(5); var10 < p_35957_2_ || var10 >= p_35957_2_ + p_35957_4_ || var11 < p_35957_3_ || var11 >= p_35957_3_ + p_35957_4_; var11 = var13 + p_35957_6_.nextInt(5) - p_35957_6_.nextInt(5)) {
                     var10 = var12 + p_35957_6_.nextInt(5) - p_35957_6_.nextInt(5);
                  }
               }
            }
         }

      }
   }

}
