package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Village;
import net.minecraft.src.VillageDoorInfo;
import net.minecraft.src.World;

public class VillageCollection {

   private World field_48570_a;
   private final List field_48568_b = new ArrayList();
   private final List field_48569_c = new ArrayList();
   private final List field_48566_d = new ArrayList();
   private int field_48567_e = 0;


   public VillageCollection(World p_i1052_1_) {
      this.field_48570_a = p_i1052_1_;
   }

   public void func_48565_a(int p_48565_1_, int p_48565_2_, int p_48565_3_) {
      if(this.field_48568_b.size() <= 64) {
         if(!this.func_48561_d(p_48565_1_, p_48565_2_, p_48565_3_)) {
            this.field_48568_b.add(new ChunkCoordinates(p_48565_1_, p_48565_2_, p_48565_3_));
         }

      }
   }

   public void func_48558_a() {
      ++this.field_48567_e;
      Iterator var1 = this.field_48566_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         var2.func_48522_a(this.field_48567_e);
      }

      this.func_48563_c();
      this.func_48557_d();
      this.func_48560_e();
   }

   private void func_48563_c() {
      Iterator var1 = this.field_48566_d.iterator();

      while(var1.hasNext()) {
         Village var2 = (Village)var1.next();
         if(var2.func_48529_g()) {
            var1.remove();
         }
      }

   }

   public List func_48554_b() {
      return this.field_48566_d;
   }

   public Village func_48564_a(int p_48564_1_, int p_48564_2_, int p_48564_3_, int p_48564_4_) {
      Village var5 = null;
      float var6 = Float.MAX_VALUE;
      Iterator var7 = this.field_48566_d.iterator();

      while(var7.hasNext()) {
         Village var8 = (Village)var7.next();
         float var9 = var8.func_48539_a().func_48655_c(p_48564_1_, p_48564_2_, p_48564_3_);
         if(var9 < var6) {
            int var10 = p_48564_4_ + var8.func_48531_b();
            if(var9 <= (float)(var10 * var10)) {
               var5 = var8;
               var6 = var9;
            }
         }
      }

      return var5;
   }

   private void func_48557_d() {
      if(!this.field_48568_b.isEmpty()) {
         this.func_48559_a((ChunkCoordinates)this.field_48568_b.remove(0));
      }
   }

   private void func_48560_e() {
      int var1 = 0;

      while(var1 < this.field_48569_c.size()) {
         VillageDoorInfo var2 = (VillageDoorInfo)this.field_48569_c.get(var1);
         boolean var3 = false;
         Iterator var4 = this.field_48566_d.iterator();

         while(true) {
            if(var4.hasNext()) {
               Village var5 = (Village)var4.next();
               int var6 = (int)var5.func_48539_a().func_27439_a(var2.field_48600_a, var2.field_48598_b, var2.field_48599_c);
               if(var6 > 32 + var5.func_48531_b()) {
                  continue;
               }

               var5.func_48538_a(var2);
               var3 = true;
            }

            if(!var3) {
               Village var7 = new Village(this.field_48570_a);
               var7.func_48538_a(var2);
               this.field_48566_d.add(var7);
            }

            ++var1;
            break;
         }
      }

      this.field_48569_c.clear();
   }

   private void func_48559_a(ChunkCoordinates p_48559_1_) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = p_48559_1_.field_22395_a - var2; var5 < p_48559_1_.field_22395_a + var2; ++var5) {
         for(int var6 = p_48559_1_.field_22394_b - var3; var6 < p_48559_1_.field_22394_b + var3; ++var6) {
            for(int var7 = p_48559_1_.field_22396_c - var4; var7 < p_48559_1_.field_22396_c + var4; ++var7) {
               if(this.func_48555_e(var5, var6, var7)) {
                  VillageDoorInfo var8 = this.func_48562_b(var5, var6, var7);
                  if(var8 == null) {
                     this.func_48556_c(var5, var6, var7);
                  } else {
                     var8.field_48594_f = this.field_48567_e;
                  }
               }
            }
         }
      }

   }

   private VillageDoorInfo func_48562_b(int p_48562_1_, int p_48562_2_, int p_48562_3_) {
      Iterator var4 = this.field_48569_c.iterator();

      VillageDoorInfo var5;
      do {
         if(!var4.hasNext()) {
            var4 = this.field_48566_d.iterator();

            VillageDoorInfo var6;
            do {
               if(!var4.hasNext()) {
                  return null;
               }

               Village var7 = (Village)var4.next();
               var6 = var7.func_48526_d(p_48562_1_, p_48562_2_, p_48562_3_);
            } while(var6 == null);

            return var6;
         }

         var5 = (VillageDoorInfo)var4.next();
      } while(var5.field_48600_a != p_48562_1_ || var5.field_48599_c != p_48562_3_ || Math.abs(var5.field_48598_b - p_48562_2_) > 1);

      return var5;
   }

   private void func_48556_c(int p_48556_1_, int p_48556_2_, int p_48556_3_) {
      int var4 = ((BlockDoor)Block.field_442_aF).func_48214_g(this.field_48570_a, p_48556_1_, p_48556_2_, p_48556_3_);
      int var5;
      int var6;
      if(var4 != 0 && var4 != 2) {
         var5 = 0;

         for(var6 = -5; var6 < 0; ++var6) {
            if(this.field_48570_a.func_647_i(p_48556_1_, p_48556_2_, p_48556_3_ + var6)) {
               --var5;
            }
         }

         for(var6 = 1; var6 <= 5; ++var6) {
            if(this.field_48570_a.func_647_i(p_48556_1_, p_48556_2_, p_48556_3_ + var6)) {
               ++var5;
            }
         }

         if(var5 != 0) {
            this.field_48569_c.add(new VillageDoorInfo(p_48556_1_, p_48556_2_, p_48556_3_, 0, var5 > 0?-2:2, this.field_48567_e));
         }
      } else {
         var5 = 0;

         for(var6 = -5; var6 < 0; ++var6) {
            if(this.field_48570_a.func_647_i(p_48556_1_ + var6, p_48556_2_, p_48556_3_)) {
               --var5;
            }
         }

         for(var6 = 1; var6 <= 5; ++var6) {
            if(this.field_48570_a.func_647_i(p_48556_1_ + var6, p_48556_2_, p_48556_3_)) {
               ++var5;
            }
         }

         if(var5 != 0) {
            this.field_48569_c.add(new VillageDoorInfo(p_48556_1_, p_48556_2_, p_48556_3_, var5 > 0?-2:2, 0, this.field_48567_e));
         }
      }

   }

   private boolean func_48561_d(int p_48561_1_, int p_48561_2_, int p_48561_3_) {
      Iterator var4 = this.field_48568_b.iterator();

      ChunkCoordinates var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (ChunkCoordinates)var4.next();
      } while(var5.field_22395_a != p_48561_1_ || var5.field_22394_b != p_48561_2_ || var5.field_22396_c != p_48561_3_);

      return true;
   }

   private boolean func_48555_e(int p_48555_1_, int p_48555_2_, int p_48555_3_) {
      int var4 = this.field_48570_a.func_600_a(p_48555_1_, p_48555_2_, p_48555_3_);
      return var4 == Block.field_442_aF.field_376_bc;
   }
}
