package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.VillageAgressor;
import net.minecraft.src.VillageDoorInfo;
import net.minecraft.src.World;

public class Village {

   private final World field_48548_a;
   private final List field_48546_b = new ArrayList();
   private final ChunkCoordinates field_48547_c = new ChunkCoordinates(0, 0, 0);
   private final ChunkCoordinates field_48544_d = new ChunkCoordinates(0, 0, 0);
   private int field_48545_e = 0;
   private int field_48542_f = 0;
   private int field_48543_g = 0;
   private int field_48550_h = 0;
   private List field_48551_i = new ArrayList();
   private int field_48549_j = 0;


   public Village(World p_i1048_1_) {
      this.field_48548_a = p_i1048_1_;
   }

   public void func_48522_a(int p_48522_1_) {
      this.field_48543_g = p_48522_1_;
      this.func_48520_k();
      this.func_48528_j();
      if(p_48522_1_ % 20 == 0) {
         this.func_48535_i();
      }

      if(p_48522_1_ % 30 == 0) {
         this.func_48541_h();
      }

      int var2 = this.field_48550_h / 16;
      if(this.field_48549_j < var2 && this.field_48546_b.size() > 20 && this.field_48548_a.field_1037_n.nextInt(7000) == 0) {
         Vec3D var3 = this.func_48532_a(MathHelper.func_1110_d((float)this.field_48544_d.field_22395_a), MathHelper.func_1110_d((float)this.field_48544_d.field_22394_b), MathHelper.func_1110_d((float)this.field_48544_d.field_22396_c), 2, 4, 2);
         if(var3 != null) {
            EntityIronGolem var4 = new EntityIronGolem(this.field_48548_a);
            var4.func_347_a(var3.field_1776_a, var3.field_1775_b, var3.field_1779_c);
            this.field_48548_a.func_674_a(var4);
            ++this.field_48549_j;
         }
      }

   }

   private Vec3D func_48532_a(int p_48532_1_, int p_48532_2_, int p_48532_3_, int p_48532_4_, int p_48532_5_, int p_48532_6_) {
      for(int var7 = 0; var7 < 10; ++var7) {
         int var8 = p_48532_1_ + this.field_48548_a.field_1037_n.nextInt(16) - 8;
         int var9 = p_48532_2_ + this.field_48548_a.field_1037_n.nextInt(6) - 3;
         int var10 = p_48532_3_ + this.field_48548_a.field_1037_n.nextInt(16) - 8;
         if(this.func_48533_a(var8, var9, var10) && this.func_48525_b(var8, var9, var10, p_48532_4_, p_48532_5_, p_48532_6_)) {
            return Vec3D.func_1248_b((double)var8, (double)var9, (double)var10);
         }
      }

      return null;
   }

   private boolean func_48525_b(int p_48525_1_, int p_48525_2_, int p_48525_3_, int p_48525_4_, int p_48525_5_, int p_48525_6_) {
      if(!this.field_48548_a.func_28100_h(p_48525_1_, p_48525_2_ - 1, p_48525_3_)) {
         return false;
      } else {
         int var7 = p_48525_1_ - p_48525_4_ / 2;
         int var8 = p_48525_3_ - p_48525_6_ / 2;

         for(int var9 = var7; var9 < var7 + p_48525_4_; ++var9) {
            for(int var10 = p_48525_2_; var10 < p_48525_2_ + p_48525_5_; ++var10) {
               for(int var11 = var8; var11 < var8 + p_48525_6_; ++var11) {
                  if(this.field_48548_a.func_28100_h(var9, var10, var11)) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private void func_48541_h() {
      List var1 = this.field_48548_a.func_657_a(EntityIronGolem.class, AxisAlignedBB.func_1161_b((double)(this.field_48544_d.field_22395_a - this.field_48545_e), (double)(this.field_48544_d.field_22394_b - 4), (double)(this.field_48544_d.field_22396_c - this.field_48545_e), (double)(this.field_48544_d.field_22395_a + this.field_48545_e), (double)(this.field_48544_d.field_22394_b + 4), (double)(this.field_48544_d.field_22396_c + this.field_48545_e)));
      this.field_48549_j = var1.size();
   }

   private void func_48535_i() {
      List var1 = this.field_48548_a.func_657_a(EntityVillager.class, AxisAlignedBB.func_1161_b((double)(this.field_48544_d.field_22395_a - this.field_48545_e), (double)(this.field_48544_d.field_22394_b - 4), (double)(this.field_48544_d.field_22396_c - this.field_48545_e), (double)(this.field_48544_d.field_22395_a + this.field_48545_e), (double)(this.field_48544_d.field_22394_b + 4), (double)(this.field_48544_d.field_22396_c + this.field_48545_e)));
      this.field_48550_h = var1.size();
   }

   public ChunkCoordinates func_48539_a() {
      return this.field_48544_d;
   }

   public int func_48531_b() {
      return this.field_48545_e;
   }

   public int func_48530_c() {
      return this.field_48546_b.size();
   }

   public int func_48523_d() {
      return this.field_48543_g - this.field_48542_f;
   }

   public int func_48524_e() {
      return this.field_48550_h;
   }

   public boolean func_48533_a(int p_48533_1_, int p_48533_2_, int p_48533_3_) {
      return this.field_48544_d.func_48655_c(p_48533_1_, p_48533_2_, p_48533_3_) < (float)(this.field_48545_e * this.field_48545_e);
   }

   public List func_48521_f() {
      return this.field_48546_b;
   }

   public VillageDoorInfo func_48527_b(int p_48527_1_, int p_48527_2_, int p_48527_3_) {
      VillageDoorInfo var4 = null;
      int var5 = Integer.MAX_VALUE;
      Iterator var6 = this.field_48546_b.iterator();

      while(var6.hasNext()) {
         VillageDoorInfo var7 = (VillageDoorInfo)var6.next();
         int var8 = var7.func_48588_a(p_48527_1_, p_48527_2_, p_48527_3_);
         if(var8 < var5) {
            var4 = var7;
            var5 = var8;
         }
      }

      return var4;
   }

   public VillageDoorInfo func_48540_c(int p_48540_1_, int p_48540_2_, int p_48540_3_) {
      VillageDoorInfo var4 = null;
      int var5 = Integer.MAX_VALUE;
      Iterator var6 = this.field_48546_b.iterator();

      while(var6.hasNext()) {
         VillageDoorInfo var7 = (VillageDoorInfo)var6.next();
         int var8 = var7.func_48588_a(p_48540_1_, p_48540_2_, p_48540_3_);
         if(var8 > 256) {
            var8 *= 1000;
         } else {
            var8 = var7.func_48587_f();
         }

         if(var8 < var5) {
            var4 = var7;
            var5 = var8;
         }
      }

      return var4;
   }

   public VillageDoorInfo func_48526_d(int p_48526_1_, int p_48526_2_, int p_48526_3_) {
      if(this.field_48544_d.func_48655_c(p_48526_1_, p_48526_2_, p_48526_3_) > (float)(this.field_48545_e * this.field_48545_e)) {
         return null;
      } else {
         Iterator var4 = this.field_48546_b.iterator();

         VillageDoorInfo var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (VillageDoorInfo)var4.next();
         } while(var5.field_48600_a != p_48526_1_ || var5.field_48599_c != p_48526_3_ || Math.abs(var5.field_48598_b - p_48526_2_) > 1);

         return var5;
      }
   }

   public void func_48538_a(VillageDoorInfo p_48538_1_) {
      this.field_48546_b.add(p_48538_1_);
      this.field_48547_c.field_22395_a += p_48538_1_.field_48600_a;
      this.field_48547_c.field_22394_b += p_48538_1_.field_48598_b;
      this.field_48547_c.field_22396_c += p_48538_1_.field_48599_c;
      this.func_48536_l();
      this.field_48542_f = p_48538_1_.field_48594_f;
   }

   public boolean func_48529_g() {
      return this.field_48546_b.isEmpty();
   }

   public void func_48534_a(EntityLiving p_48534_1_) {
      Iterator var2 = this.field_48551_i.iterator();

      VillageAgressor var3;
      do {
         if(!var2.hasNext()) {
            this.field_48551_i.add(new VillageAgressor(this, p_48534_1_, this.field_48543_g));
            return;
         }

         var3 = (VillageAgressor)var2.next();
      } while(var3.field_48515_a != p_48534_1_);

      var3.field_48513_b = this.field_48543_g;
   }

   public EntityLiving func_48537_b(EntityLiving p_48537_1_) {
      double var2 = Double.MAX_VALUE;
      VillageAgressor var4 = null;

      for(int var5 = 0; var5 < this.field_48551_i.size(); ++var5) {
         VillageAgressor var6 = (VillageAgressor)this.field_48551_i.get(var5);
         double var7 = var6.field_48515_a.func_387_e(p_48537_1_);
         if(var7 <= var2) {
            var4 = var6;
            var2 = var7;
         }
      }

      return var4 != null?var4.field_48515_a:null;
   }

   private void func_48528_j() {
      Iterator var1 = this.field_48551_i.iterator();

      while(var1.hasNext()) {
         VillageAgressor var2 = (VillageAgressor)var1.next();
         if(!var2.field_48515_a.func_354_B() || Math.abs(this.field_48543_g - var2.field_48513_b) > 300) {
            var1.remove();
         }
      }

   }

   private void func_48520_k() {
      boolean var1 = false;
      boolean var2 = this.field_48548_a.field_1037_n.nextInt(50) == 0;
      Iterator var3 = this.field_48546_b.iterator();

      while(var3.hasNext()) {
         VillageDoorInfo var4 = (VillageDoorInfo)var3.next();
         if(var2) {
            var4.func_48585_d();
         }

         if(!this.func_48519_e(var4.field_48600_a, var4.field_48598_b, var4.field_48599_c) || Math.abs(this.field_48543_g - var4.field_48594_f) > 1200) {
            this.field_48547_c.field_22395_a -= var4.field_48600_a;
            this.field_48547_c.field_22394_b -= var4.field_48598_b;
            this.field_48547_c.field_22396_c -= var4.field_48599_c;
            var1 = true;
            var4.field_48595_g = true;
            var3.remove();
         }
      }

      if(var1) {
         this.func_48536_l();
      }

   }

   private boolean func_48519_e(int p_48519_1_, int p_48519_2_, int p_48519_3_) {
      int var4 = this.field_48548_a.func_600_a(p_48519_1_, p_48519_2_, p_48519_3_);
      return var4 <= 0?false:var4 == Block.field_442_aF.field_376_bc;
   }

   private void func_48536_l() {
      int var1 = this.field_48546_b.size();
      if(var1 == 0) {
         this.field_48544_d.func_48656_a(0, 0, 0);
         this.field_48545_e = 0;
      } else {
         this.field_48544_d.func_48656_a(this.field_48547_c.field_22395_a / var1, this.field_48547_c.field_22394_b / var1, this.field_48547_c.field_22396_c / var1);
         int var2 = 0;

         VillageDoorInfo var4;
         for(Iterator var3 = this.field_48546_b.iterator(); var3.hasNext(); var2 = Math.max(var4.func_48588_a(this.field_48544_d.field_22395_a, this.field_48544_d.field_22394_b, this.field_48544_d.field_22396_c), var2)) {
            var4 = (VillageDoorInfo)var3.next();
         }

         this.field_48545_e = Math.max(32, (int)Math.sqrt((double)var2) + 1);
      }
   }
}
