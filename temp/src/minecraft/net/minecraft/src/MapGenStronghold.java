package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ComponentStrongholdStairs2;
import net.minecraft.src.MapGenStructure;
import net.minecraft.src.StructureStart;
import net.minecraft.src.StructureStrongholdStart;

public class MapGenStronghold extends MapGenStructure {

   private BiomeGenBase[] field_35634_a;
   private boolean field_35632_f;
   private ChunkCoordIntPair[] field_35633_g;


   public MapGenStronghold() {
      this.field_35634_a = new BiomeGenBase[]{BiomeGenBase.field_4249_h, BiomeGenBase.field_4253_d, BiomeGenBase.field_35483_e, BiomeGenBase.field_4255_b, BiomeGenBase.field_4250_g, BiomeGenBase.field_40257_n, BiomeGenBase.field_40258_o, BiomeGenBase.field_46049_s, BiomeGenBase.field_46048_t, BiomeGenBase.field_46046_v, BiomeGenBase.field_48416_w, BiomeGenBase.field_48417_x};
      this.field_35633_g = new ChunkCoordIntPair[3];
   }

   protected boolean func_35628_a(int p_35628_1_, int p_35628_2_) {
      if(!this.field_35632_f) {
         Random var3 = new Random();
         var3.setSeed(this.field_35625_d.func_22138_q());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;

         for(int var6 = 0; var6 < this.field_35633_g.length; ++var6) {
            double var7 = (1.25D + var3.nextDouble()) * 32.0D;
            int var9 = (int)Math.round(Math.cos(var4) * var7);
            int var10 = (int)Math.round(Math.sin(var4) * var7);
            ArrayList var11 = new ArrayList();
            BiomeGenBase[] var12 = this.field_35634_a;
            int var13 = var12.length;

            for(int var14 = 0; var14 < var13; ++var14) {
               BiomeGenBase var15 = var12[var14];
               var11.add(var15);
            }

            ChunkPosition var19 = this.field_35625_d.func_4075_a().func_35556_a((var9 << 4) + 8, (var10 << 4) + 8, 112, var11, var3);
            if(var19 != null) {
               var9 = var19.field_1111_a >> 4;
               var10 = var19.field_1112_c >> 4;
            } else {
               System.out.println("Placed stronghold in INVALID biome at (" + var9 + ", " + var10 + ")");
            }

            this.field_35633_g[var6] = new ChunkCoordIntPair(var9, var10);
            var4 += 6.283185307179586D / (double)this.field_35633_g.length;
         }

         this.field_35632_f = true;
      }

      ChunkCoordIntPair[] var16 = this.field_35633_g;
      int var17 = var16.length;

      for(int var5 = 0; var5 < var17; ++var5) {
         ChunkCoordIntPair var18 = var16[var5];
         if(p_35628_1_ == var18.field_189_a && p_35628_2_ == var18.field_188_b) {
            System.out.println(p_35628_1_ + ", " + p_35628_2_);
            return true;
         }
      }

      return false;
   }

   protected List func_40482_a() {
      ArrayList var1 = new ArrayList();
      ChunkCoordIntPair[] var2 = this.field_35633_g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ChunkCoordIntPair var5 = var2[var4];
         if(var5 != null) {
            var1.add(var5.func_40737_a(64));
         }
      }

      return var1;
   }

   protected StructureStart func_35630_b(int p_35630_1_, int p_35630_2_) {
      StructureStrongholdStart var3;
      for(var3 = new StructureStrongholdStart(this.field_35625_d, this.field_1305_b, p_35630_1_, p_35630_2_); var3.func_40560_b().isEmpty() || ((ComponentStrongholdStairs2)var3.func_40560_b().get(0)).field_40009_b == null; var3 = new StructureStrongholdStart(this.field_35625_d, this.field_1305_b, p_35630_1_, p_35630_2_)) {
         ;
      }

      return var3;
   }
}
