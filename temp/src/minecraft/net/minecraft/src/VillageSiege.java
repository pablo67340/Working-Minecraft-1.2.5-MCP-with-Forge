package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.Vec3D;
import net.minecraft.src.Village;
import net.minecraft.src.World;

public class VillageSiege {

   private World field_48582_a;
   private boolean field_48580_b = false;
   private int field_48581_c = -1;
   private int field_48578_d;
   private int field_48579_e;
   private Village field_48576_f;
   private int field_48577_g;
   private int field_48583_h;
   private int field_48584_i;


   public VillageSiege(World p_i1005_1_) {
      this.field_48582_a = p_i1005_1_;
   }

   public void func_48573_a() {
      boolean var1 = false;
      if(var1) {
         if(this.field_48581_c == 2) {
            this.field_48578_d = 100;
            return;
         }
      } else {
         if(this.field_48582_a.func_624_b()) {
            this.field_48581_c = 0;
            return;
         }

         if(this.field_48581_c == 2) {
            return;
         }

         if(this.field_48581_c == 0) {
            float var2 = this.field_48582_a.func_619_c(0.0F);
            if((double)var2 < 0.5D || (double)var2 > 0.501D) {
               return;
            }

            this.field_48581_c = this.field_48582_a.field_1037_n.nextInt(10) == 0?1:2;
            this.field_48580_b = false;
            if(this.field_48581_c == 2) {
               return;
            }
         }
      }

      if(!this.field_48580_b) {
         if(!this.func_48574_b()) {
            return;
         }

         this.field_48580_b = true;
      }

      if(this.field_48579_e > 0) {
         --this.field_48579_e;
      } else {
         this.field_48579_e = 2;
         if(this.field_48578_d > 0) {
            this.func_48575_c();
            --this.field_48578_d;
         } else {
            this.field_48581_c = 2;
         }

      }
   }

   private boolean func_48574_b() {
      List var1 = this.field_48582_a.field_1040_k;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         EntityPlayer var3 = (EntityPlayer)var2.next();
         this.field_48576_f = this.field_48582_a.field_48465_A.func_48564_a((int)var3.field_611_ak, (int)var3.field_610_al, (int)var3.field_609_am, 1);
         if(this.field_48576_f != null && this.field_48576_f.func_48530_c() >= 10 && this.field_48576_f.func_48523_d() >= 20 && this.field_48576_f.func_48524_e() >= 20) {
            ChunkCoordinates var4 = this.field_48576_f.func_48539_a();
            float var5 = (float)this.field_48576_f.func_48531_b();
            boolean var6 = false;
            int var7 = 0;

            while(true) {
               if(var7 < 10) {
                  this.field_48577_g = var4.field_22395_a + (int)((double)(MathHelper.func_1114_b(this.field_48582_a.field_1037_n.nextFloat() * 3.1415927F * 2.0F) * var5) * 0.9D);
                  this.field_48583_h = var4.field_22394_b;
                  this.field_48584_i = var4.field_22396_c + (int)((double)(MathHelper.func_1106_a(this.field_48582_a.field_1037_n.nextFloat() * 3.1415927F * 2.0F) * var5) * 0.9D);
                  var6 = false;
                  Iterator var8 = this.field_48582_a.field_48465_A.func_48554_b().iterator();

                  while(var8.hasNext()) {
                     Village var9 = (Village)var8.next();
                     if(var9 != this.field_48576_f && var9.func_48533_a(this.field_48577_g, this.field_48583_h, this.field_48584_i)) {
                        var6 = true;
                        break;
                     }
                  }

                  if(var6) {
                     ++var7;
                     continue;
                  }
               }

               if(var6) {
                  return false;
               }

               Vec3D var10 = this.func_48572_a(this.field_48577_g, this.field_48583_h, this.field_48584_i);
               if(var10 != null) {
                  this.field_48579_e = 0;
                  this.field_48578_d = 20;
                  return true;
               }
               break;
            }
         }
      }

      return false;
   }

   private boolean func_48575_c() {
      Vec3D var1 = this.func_48572_a(this.field_48577_g, this.field_48583_h, this.field_48584_i);
      if(var1 == null) {
         return false;
      } else {
         EntityZombie var2;
         try {
            var2 = new EntityZombie(this.field_48582_a);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.func_365_c(var1.field_1776_a, var1.field_1775_b, var1.field_1779_c, this.field_48582_a.field_1037_n.nextFloat() * 360.0F, 0.0F);
         this.field_48582_a.func_674_a(var2);
         ChunkCoordinates var3 = this.field_48576_f.func_48539_a();
         var2.func_48082_b(var3.field_22395_a, var3.field_22394_b, var3.field_22396_c, this.field_48576_f.func_48531_b());
         return true;
      }
   }

   private Vec3D func_48572_a(int p_48572_1_, int p_48572_2_, int p_48572_3_) {
      for(int var4 = 0; var4 < 10; ++var4) {
         int var5 = p_48572_1_ + this.field_48582_a.field_1037_n.nextInt(16) - 8;
         int var6 = p_48572_2_ + this.field_48582_a.field_1037_n.nextInt(6) - 3;
         int var7 = p_48572_3_ + this.field_48582_a.field_1037_n.nextInt(16) - 8;
         if(this.field_48576_f.func_48533_a(var5, var6, var7) && SpawnerAnimals.func_21203_a(EnumCreatureType.monster, this.field_48582_a, var5, var6, var7)) {
            return Vec3D.func_1248_b((double)var5, (double)var6, (double)var7);
         }
      }

      return null;
   }
}
