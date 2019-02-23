package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.BlockRail;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

class RailLogic {

   private World field_1159_b;
   private int field_1165_c;
   private int field_1164_d;
   private int field_1163_e;
   private final boolean field_27212_f;
   private List field_1161_g;
   // $FF: synthetic field
   final BlockRail field_1160_a;


   public RailLogic(BlockRail p_i528_1_, World p_i528_2_, int p_i528_3_, int p_i528_4_, int p_i528_5_) {
      this.field_1160_a = p_i528_1_;
      this.field_1161_g = new ArrayList();
      this.field_1159_b = p_i528_2_;
      this.field_1165_c = p_i528_3_;
      this.field_1164_d = p_i528_4_;
      this.field_1163_e = p_i528_5_;
      int var6 = p_i528_2_.func_600_a(p_i528_3_, p_i528_4_, p_i528_5_);
      int var7 = p_i528_2_.func_602_e(p_i528_3_, p_i528_4_, p_i528_5_);
      if(BlockRail.func_27039_a((BlockRail)Block.field_345_n[var6])) {
         this.field_27212_f = true;
         var7 &= -9;
      } else {
         this.field_27212_f = false;
      }

      this.func_27211_a(var7);
   }

   private void func_27211_a(int p_27211_1_) {
      this.field_1161_g.clear();
      if(p_27211_1_ == 0) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
      } else if(p_27211_1_ == 1) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
      } else if(p_27211_1_ == 2) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e));
      } else if(p_27211_1_ == 3) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
      } else if(p_27211_1_ == 4) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
      } else if(p_27211_1_ == 5) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1));
      } else if(p_27211_1_ == 6) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
      } else if(p_27211_1_ == 7) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
      } else if(p_27211_1_ == 8) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
      } else if(p_27211_1_ == 9) {
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
         this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
      }

   }

   private void func_785_b() {
      for(int var1 = 0; var1 < this.field_1161_g.size(); ++var1) {
         RailLogic var2 = this.func_795_a((ChunkPosition)this.field_1161_g.get(var1));
         if(var2 != null && var2.func_793_b(this)) {
            this.field_1161_g.set(var1, new ChunkPosition(var2.field_1165_c, var2.field_1164_d, var2.field_1163_e));
         } else {
            this.field_1161_g.remove(var1--);
         }
      }

   }

   private boolean func_784_a(int p_784_1_, int p_784_2_, int p_784_3_) {
      return BlockRail.func_27040_h(this.field_1159_b, p_784_1_, p_784_2_, p_784_3_)?true:(BlockRail.func_27040_h(this.field_1159_b, p_784_1_, p_784_2_ + 1, p_784_3_)?true:BlockRail.func_27040_h(this.field_1159_b, p_784_1_, p_784_2_ - 1, p_784_3_));
   }

   private RailLogic func_795_a(ChunkPosition p_795_1_) {
      return BlockRail.func_27040_h(this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b, p_795_1_.field_1112_c)?new RailLogic(this.field_1160_a, this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b, p_795_1_.field_1112_c):(BlockRail.func_27040_h(this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b + 1, p_795_1_.field_1112_c)?new RailLogic(this.field_1160_a, this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b + 1, p_795_1_.field_1112_c):(BlockRail.func_27040_h(this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b - 1, p_795_1_.field_1112_c)?new RailLogic(this.field_1160_a, this.field_1159_b, p_795_1_.field_1111_a, p_795_1_.field_1110_b - 1, p_795_1_.field_1112_c):null));
   }

   private boolean func_793_b(RailLogic p_793_1_) {
      for(int var2 = 0; var2 < this.field_1161_g.size(); ++var2) {
         ChunkPosition var3 = (ChunkPosition)this.field_1161_g.get(var2);
         if(var3.field_1111_a == p_793_1_.field_1165_c && var3.field_1112_c == p_793_1_.field_1163_e) {
            return true;
         }
      }

      return false;
   }

   private boolean func_794_b(int p_794_1_, int p_794_2_, int p_794_3_) {
      for(int var4 = 0; var4 < this.field_1161_g.size(); ++var4) {
         ChunkPosition var5 = (ChunkPosition)this.field_1161_g.get(var4);
         if(var5.field_1111_a == p_794_1_ && var5.field_1112_c == p_794_3_) {
            return true;
         }
      }

      return false;
   }

   private int func_790_c() {
      int var1 = 0;
      if(this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1)) {
         ++var1;
      }

      if(this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1)) {
         ++var1;
      }

      if(this.func_784_a(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e)) {
         ++var1;
      }

      if(this.func_784_a(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e)) {
         ++var1;
      }

      return var1;
   }

   private boolean func_787_c(RailLogic p_787_1_) {
      if(this.func_793_b(p_787_1_)) {
         return true;
      } else if(this.field_1161_g.size() == 2) {
         return false;
      } else if(this.field_1161_g.size() == 0) {
         return true;
      } else {
         ChunkPosition var2 = (ChunkPosition)this.field_1161_g.get(0);
         return p_787_1_.field_1164_d == this.field_1164_d && var2.field_1110_b == this.field_1164_d?true:true;
      }
   }

   private void func_788_d(RailLogic p_788_1_) {
      this.field_1161_g.add(new ChunkPosition(p_788_1_.field_1165_c, p_788_1_.field_1164_d, p_788_1_.field_1163_e));
      boolean var2 = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
      boolean var3 = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
      boolean var4 = this.func_794_b(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
      boolean var5 = this.func_794_b(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
      byte var6 = -1;
      if(var2 || var3) {
         var6 = 0;
      }

      if(var4 || var5) {
         var6 = 1;
      }

      if(!this.field_27212_f) {
         if(var3 && var5 && !var2 && !var4) {
            var6 = 6;
         }

         if(var3 && var4 && !var2 && !var5) {
            var6 = 7;
         }

         if(var2 && var4 && !var3 && !var5) {
            var6 = 8;
         }

         if(var2 && var5 && !var3 && !var4) {
            var6 = 9;
         }
      }

      if(var6 == 0) {
         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1)) {
            var6 = 4;
         }

         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1)) {
            var6 = 5;
         }
      }

      if(var6 == 1) {
         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e)) {
            var6 = 2;
         }

         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e)) {
            var6 = 3;
         }
      }

      if(var6 < 0) {
         var6 = 0;
      }

      int var7 = var6;
      if(this.field_27212_f) {
         var7 = this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) & 8 | var6;
      }

      this.field_1159_b.func_691_b(this.field_1165_c, this.field_1164_d, this.field_1163_e, var7);
   }

   private boolean func_786_c(int p_786_1_, int p_786_2_, int p_786_3_) {
      RailLogic var4 = this.func_795_a(new ChunkPosition(p_786_1_, p_786_2_, p_786_3_));
      if(var4 == null) {
         return false;
      } else {
         var4.func_785_b();
         return var4.func_787_c(this);
      }
   }

   public void func_792_a(boolean p_792_1_, boolean p_792_2_) {
      boolean var3 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
      boolean var4 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
      boolean var5 = this.func_786_c(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
      boolean var6 = this.func_786_c(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
      byte var7 = -1;
      if((var3 || var4) && !var5 && !var6) {
         var7 = 0;
      }

      if((var5 || var6) && !var3 && !var4) {
         var7 = 1;
      }

      if(!this.field_27212_f) {
         if(var4 && var6 && !var3 && !var5) {
            var7 = 6;
         }

         if(var4 && var5 && !var3 && !var6) {
            var7 = 7;
         }

         if(var3 && var5 && !var4 && !var6) {
            var7 = 8;
         }

         if(var3 && var6 && !var4 && !var5) {
            var7 = 9;
         }
      }

      if(var7 == -1) {
         if(var3 || var4) {
            var7 = 0;
         }

         if(var5 || var6) {
            var7 = 1;
         }

         if(!this.field_27212_f) {
            if(p_792_1_) {
               if(var4 && var6) {
                  var7 = 6;
               }

               if(var5 && var4) {
                  var7 = 7;
               }

               if(var6 && var3) {
                  var7 = 9;
               }

               if(var3 && var5) {
                  var7 = 8;
               }
            } else {
               if(var3 && var5) {
                  var7 = 8;
               }

               if(var6 && var3) {
                  var7 = 9;
               }

               if(var5 && var4) {
                  var7 = 7;
               }

               if(var4 && var6) {
                  var7 = 6;
               }
            }
         }
      }

      if(var7 == 0) {
         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1)) {
            var7 = 4;
         }

         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1)) {
            var7 = 5;
         }
      }

      if(var7 == 1) {
         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e)) {
            var7 = 2;
         }

         if(BlockRail.func_27040_h(this.field_1159_b, this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e)) {
            var7 = 3;
         }
      }

      if(var7 < 0) {
         var7 = 0;
      }

      this.func_27211_a(var7);
      int var8 = var7;
      if(this.field_27212_f) {
         var8 = this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) & 8 | var7;
      }

      if(p_792_2_ || this.field_1159_b.func_602_e(this.field_1165_c, this.field_1164_d, this.field_1163_e) != var8) {
         this.field_1159_b.func_691_b(this.field_1165_c, this.field_1164_d, this.field_1163_e, var8);

         for(int var9 = 0; var9 < this.field_1161_g.size(); ++var9) {
            RailLogic var10 = this.func_795_a((ChunkPosition)this.field_1161_g.get(var9));
            if(var10 != null) {
               var10.func_785_b();
               if(var10.func_787_c(this)) {
                  var10.func_788_d(this);
               }
            }
         }
      }

   }

   // $FF: synthetic method
   static int func_791_a(RailLogic p_791_0_) {
      return p_791_0_.func_790_c();
   }
}
