package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public abstract class Container {

   public List field_20123_d = new ArrayList();
   public List field_20122_e = new ArrayList();
   public int field_1618_c = 0;
   private short field_20917_a = 0;
   protected List field_20121_g = new ArrayList();
   private Set field_20918_b = new HashSet();


   protected void func_20117_a(Slot p_20117_1_) {
      p_20117_1_.field_20007_a = this.field_20122_e.size();
      this.field_20122_e.add(p_20117_1_);
      this.field_20123_d.add((Object)null);
   }

   public void func_20114_a() {
      for(int var1 = 0; var1 < this.field_20122_e.size(); ++var1) {
         ItemStack var2 = ((Slot)this.field_20122_e.get(var1)).func_777_b();
         ItemStack var3 = (ItemStack)this.field_20123_d.get(var1);
         if(!ItemStack.func_20107_a(var3, var2)) {
            var3 = var2 == null?null:var2.func_1102_e();
            this.field_20123_d.set(var1, var3);

            for(int var4 = 0; var4 < this.field_20121_g.size(); ++var4) {
               ((ICrafting)this.field_20121_g.get(var4)).func_20159_a(this, var1, var3);
            }
         }
      }

   }

   public boolean func_40233_a(EntityPlayer p_40233_1_, int p_40233_2_) {
      return false;
   }

   public Slot func_20118_a(int p_20118_1_) {
      return (Slot)this.field_20122_e.get(p_20118_1_);
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      Slot var2 = (Slot)this.field_20122_e.get(p_27279_1_);
      return var2 != null?var2.func_777_b():null;
   }

   public ItemStack func_27280_a(int p_27280_1_, int p_27280_2_, boolean p_27280_3_, EntityPlayer p_27280_4_) {
      ItemStack var5 = null;
      if(p_27280_2_ > 1) {
         return null;
      } else {
         if(p_27280_2_ == 0 || p_27280_2_ == 1) {
            InventoryPlayer var6 = p_27280_4_.field_778_b;
            if(p_27280_1_ == -999) {
               if(var6.func_20075_i() != null && p_27280_1_ == -999) {
                  if(p_27280_2_ == 0) {
                     p_27280_4_.func_48153_a(var6.func_20075_i());
                     var6.func_20076_b((ItemStack)null);
                  }

                  if(p_27280_2_ == 1) {
                     p_27280_4_.func_48153_a(var6.func_20075_i().func_1085_a(1));
                     if(var6.func_20075_i().field_1615_a == 0) {
                        var6.func_20076_b((ItemStack)null);
                     }
                  }
               }
            } else if(p_27280_3_) {
               ItemStack var7 = this.func_27279_a(p_27280_1_);
               if(var7 != null) {
                  int var8 = var7.field_1617_c;
                  var5 = var7.func_1102_e();
                  Slot var9 = (Slot)this.field_20122_e.get(p_27280_1_);
                  if(var9 != null && var9.func_777_b() != null && var9.func_777_b().field_1617_c == var8) {
                     this.func_35373_b(p_27280_1_, p_27280_2_, p_27280_3_, p_27280_4_);
                  }
               }
            } else {
               if(p_27280_1_ < 0) {
                  return null;
               }

               Slot var12 = (Slot)this.field_20122_e.get(p_27280_1_);
               if(var12 != null) {
                  var12.func_779_d();
                  ItemStack var13 = var12.func_777_b();
                  ItemStack var14 = var6.func_20075_i();
                  if(var13 != null) {
                     var5 = var13.func_1102_e();
                  }

                  int var10;
                  if(var13 == null) {
                     if(var14 != null && var12.func_4105_a(var14)) {
                        var10 = p_27280_2_ == 0?var14.field_1615_a:1;
                        if(var10 > var12.func_4104_e()) {
                           var10 = var12.func_4104_e();
                        }

                        var12.func_776_b(var14.func_1085_a(var10));
                        if(var14.field_1615_a == 0) {
                           var6.func_20076_b((ItemStack)null);
                        }
                     }
                  } else if(var14 == null) {
                     var10 = p_27280_2_ == 0?var13.field_1615_a:(var13.field_1615_a + 1) / 2;
                     ItemStack var11 = var12.func_20004_a(var10);
                     var6.func_20076_b(var11);
                     if(var13.field_1615_a == 0) {
                        var12.func_776_b((ItemStack)null);
                     }

                     var12.func_4103_a(var6.func_20075_i());
                  } else if(var12.func_4105_a(var14)) {
                     if(var13.field_1617_c == var14.field_1617_c && (!var13.func_21183_f() || var13.func_21181_i() == var14.func_21181_i()) && ItemStack.func_46154_a(var13, var14)) {
                        var10 = p_27280_2_ == 0?var14.field_1615_a:1;
                        if(var10 > var12.func_4104_e() - var13.field_1615_a) {
                           var10 = var12.func_4104_e() - var13.field_1615_a;
                        }

                        if(var10 > var14.func_1089_c() - var13.field_1615_a) {
                           var10 = var14.func_1089_c() - var13.field_1615_a;
                        }

                        var14.func_1085_a(var10);
                        if(var14.field_1615_a == 0) {
                           var6.func_20076_b((ItemStack)null);
                        }

                        var13.field_1615_a += var10;
                     } else if(var14.field_1615_a <= var12.func_4104_e()) {
                        var12.func_776_b(var14);
                        var6.func_20076_b(var13);
                     }
                  } else if(var13.field_1617_c == var14.field_1617_c && var14.func_1089_c() > 1 && (!var13.func_21183_f() || var13.func_21181_i() == var14.func_21181_i()) && ItemStack.func_46154_a(var13, var14)) {
                     var10 = var13.field_1615_a;
                     if(var10 > 0 && var10 + var14.field_1615_a <= var14.func_1089_c()) {
                        var14.field_1615_a += var10;
                        var13 = var12.func_20004_a(var10);
                        if(var13.field_1615_a == 0) {
                           var12.func_776_b((ItemStack)null);
                        }

                        var12.func_4103_a(var6.func_20075_i());
                     }
                  }
               }
            }
         }

         return var5;
      }
   }

   protected void func_35373_b(int p_35373_1_, int p_35373_2_, boolean p_35373_3_, EntityPlayer p_35373_4_) {
      this.func_27280_a(p_35373_1_, p_35373_2_, p_35373_3_, p_35373_4_);
   }

   public void func_1104_a(EntityPlayer p_1104_1_) {
      InventoryPlayer var2 = p_1104_1_.field_778_b;
      if(var2.func_20075_i() != null) {
         p_1104_1_.func_48153_a(var2.func_20075_i());
         var2.func_20076_b((ItemStack)null);
      }

   }

   public void func_1103_a(IInventory p_1103_1_) {
      this.func_20114_a();
   }

   public void func_20119_a(int p_20119_1_, ItemStack p_20119_2_) {
      this.func_20118_a(p_20119_1_).func_776_b(p_20119_2_);
   }

   public void func_20115_a(ItemStack[] p_20115_1_) {
      for(int var2 = 0; var2 < p_20115_1_.length; ++var2) {
         this.func_20118_a(var2).func_776_b(p_20115_1_[var2]);
      }

   }

   public void func_20112_a(int p_20112_1_, int p_20112_2_) {}

   public short func_20111_a(InventoryPlayer p_20111_1_) {
      ++this.field_20917_a;
      return this.field_20917_a;
   }

   public void func_20113_a(short p_20113_1_) {}

   public void func_20110_b(short p_20110_1_) {}

   public abstract boolean func_20120_b(EntityPlayer var1);

   protected boolean func_28125_a(ItemStack p_28125_1_, int p_28125_2_, int p_28125_3_, boolean p_28125_4_) {
      boolean var5 = false;
      int var6 = p_28125_2_;
      if(p_28125_4_) {
         var6 = p_28125_3_ - 1;
      }

      Slot var7;
      ItemStack var8;
      if(p_28125_1_.func_21180_d()) {
         while(p_28125_1_.field_1615_a > 0 && (!p_28125_4_ && var6 < p_28125_3_ || p_28125_4_ && var6 >= p_28125_2_)) {
            var7 = (Slot)this.field_20122_e.get(var6);
            var8 = var7.func_777_b();
            if(var8 != null && var8.field_1617_c == p_28125_1_.field_1617_c && (!p_28125_1_.func_21183_f() || p_28125_1_.func_21181_i() == var8.func_21181_i()) && ItemStack.func_46154_a(p_28125_1_, var8)) {
               int var9 = var8.field_1615_a + p_28125_1_.field_1615_a;
               if(var9 <= p_28125_1_.func_1089_c()) {
                  p_28125_1_.field_1615_a = 0;
                  var8.field_1615_a = var9;
                  var7.func_779_d();
                  var5 = true;
               } else if(var8.field_1615_a < p_28125_1_.func_1089_c()) {
                  p_28125_1_.field_1615_a -= p_28125_1_.func_1089_c() - var8.field_1615_a;
                  var8.field_1615_a = p_28125_1_.func_1089_c();
                  var7.func_779_d();
                  var5 = true;
               }
            }

            if(p_28125_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if(p_28125_1_.field_1615_a > 0) {
         if(p_28125_4_) {
            var6 = p_28125_3_ - 1;
         } else {
            var6 = p_28125_2_;
         }

         while(!p_28125_4_ && var6 < p_28125_3_ || p_28125_4_ && var6 >= p_28125_2_) {
            var7 = (Slot)this.field_20122_e.get(var6);
            var8 = var7.func_777_b();
            if(var8 == null) {
               var7.func_776_b(p_28125_1_.func_1102_e());
               var7.func_779_d();
               p_28125_1_.field_1615_a = 0;
               var5 = true;
               break;
            }

            if(p_28125_4_) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }
}
