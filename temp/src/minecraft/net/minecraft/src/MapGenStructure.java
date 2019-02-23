package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.StructureBoundingBox;
import net.minecraft.src.StructureComponent;
import net.minecraft.src.StructureStart;
import net.minecraft.src.World;

public abstract class MapGenStructure extends MapGenBase {

   protected HashMap field_35631_e = new HashMap();


   public void func_867_a(IChunkProvider p_867_1_, World p_867_2_, int p_867_3_, int p_867_4_, byte[] p_867_5_) {
      super.func_867_a(p_867_1_, p_867_2_, p_867_3_, p_867_4_, p_867_5_);
   }

   protected void func_868_a(World p_868_1_, int p_868_2_, int p_868_3_, int p_868_4_, int p_868_5_, byte[] p_868_6_) {
      if(!this.field_35631_e.containsKey(Long.valueOf(ChunkCoordIntPair.func_22011_a(p_868_2_, p_868_3_)))) {
         this.field_1305_b.nextInt();
         if(this.func_35628_a(p_868_2_, p_868_3_)) {
            StructureStart var7 = this.func_35630_b(p_868_2_, p_868_3_);
            this.field_35631_e.put(Long.valueOf(ChunkCoordIntPair.func_22011_a(p_868_2_, p_868_3_)), var7);
         }

      }
   }

   public boolean func_35629_a(World p_35629_1_, Random p_35629_2_, int p_35629_3_, int p_35629_4_) {
      int var5 = (p_35629_3_ << 4) + 8;
      int var6 = (p_35629_4_ << 4) + 8;
      boolean var7 = false;
      Iterator var8 = this.field_35631_e.values().iterator();

      while(var8.hasNext()) {
         StructureStart var9 = (StructureStart)var8.next();
         if(var9.func_35715_c() && var9.func_35712_a().func_35746_a(var5, var6, var5 + 15, var6 + 15)) {
            var9.func_35711_a(p_35629_1_, p_35629_2_, new StructureBoundingBox(var5, var6, var5 + 15, var6 + 15));
            var7 = true;
         }
      }

      return var7;
   }

   public boolean func_40483_a(int p_40483_1_, int p_40483_2_, int p_40483_3_) {
      Iterator var4 = this.field_35631_e.values().iterator();

      while(var4.hasNext()) {
         StructureStart var5 = (StructureStart)var4.next();
         if(var5.func_35715_c() && var5.func_35712_a().func_35746_a(p_40483_1_, p_40483_3_, p_40483_1_, p_40483_3_)) {
            Iterator var6 = var5.func_40560_b().iterator();

            while(var6.hasNext()) {
               StructureComponent var7 = (StructureComponent)var6.next();
               if(var7.func_35021_b().func_35742_b(p_40483_1_, p_40483_2_, p_40483_3_)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public ChunkPosition func_40484_a(World p_40484_1_, int p_40484_2_, int p_40484_3_, int p_40484_4_) {
      this.field_35625_d = p_40484_1_;
      this.field_1305_b.setSeed(p_40484_1_.func_22138_q());
      long var5 = this.field_1305_b.nextLong();
      long var7 = this.field_1305_b.nextLong();
      long var9 = (long)(p_40484_2_ >> 4) * var5;
      long var11 = (long)(p_40484_4_ >> 4) * var7;
      this.field_1305_b.setSeed(var9 ^ var11 ^ p_40484_1_.func_22138_q());
      this.func_868_a(p_40484_1_, p_40484_2_ >> 4, p_40484_4_ >> 4, 0, 0, (byte[])null);
      double var13 = Double.MAX_VALUE;
      ChunkPosition var15 = null;
      Iterator var16 = this.field_35631_e.values().iterator();

      ChunkPosition var19;
      int var20;
      int var21;
      int var22;
      double var23;
      while(var16.hasNext()) {
         StructureStart var17 = (StructureStart)var16.next();
         if(var17.func_35715_c()) {
            StructureComponent var18 = (StructureComponent)var17.func_40560_b().get(0);
            var19 = var18.func_40008_a_();
            var20 = var19.field_1111_a - p_40484_2_;
            var21 = var19.field_1110_b - p_40484_3_;
            var22 = var19.field_1112_c - p_40484_4_;
            var23 = (double)(var20 + var20 * var21 * var21 + var22 * var22);
            if(var23 < var13) {
               var13 = var23;
               var15 = var19;
            }
         }
      }

      if(var15 != null) {
         return var15;
      } else {
         List var25 = this.func_40482_a();
         if(var25 != null) {
            ChunkPosition var26 = null;
            Iterator var27 = var25.iterator();

            while(var27.hasNext()) {
               var19 = (ChunkPosition)var27.next();
               var20 = var19.field_1111_a - p_40484_2_;
               var21 = var19.field_1110_b - p_40484_3_;
               var22 = var19.field_1112_c - p_40484_4_;
               var23 = (double)(var20 + var20 * var21 * var21 + var22 * var22);
               if(var23 < var13) {
                  var13 = var23;
                  var26 = var19;
               }
            }

            return var26;
         } else {
            return null;
         }
      }
   }

   protected List func_40482_a() {
      return null;
   }

   protected abstract boolean func_35628_a(int var1, int var2);

   protected abstract StructureStart func_35630_b(int var1, int var2);
}
