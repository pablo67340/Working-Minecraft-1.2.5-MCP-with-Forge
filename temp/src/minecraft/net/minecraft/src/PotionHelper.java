package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;

public class PotionHelper {

   public static final String field_40367_a = null;
   public static final String field_40365_b;
   public static final String field_40366_c = "+0-1-2-3&4-4+13";
   public static final String field_40363_d;
   public static final String field_40364_e;
   public static final String field_40361_f;
   public static final String field_40362_g;
   public static final String field_40374_h;
   public static final String field_40375_i;
   public static final String field_40372_j;
   public static final String field_40373_k;
   private static final HashMap field_40370_l = new HashMap();
   private static final HashMap field_40371_m = new HashMap();
   private static final HashMap field_40368_n;
   private static final String[] field_40369_o;


   public static boolean func_40357_a(int p_40357_0_, int p_40357_1_) {
      return (p_40357_0_ & 1 << p_40357_1_) != 0;
   }

   private static int func_40349_b(int p_40349_0_, int p_40349_1_) {
      return func_40357_a(p_40349_0_, p_40349_1_)?1:0;
   }

   private static int func_40353_c(int p_40353_0_, int p_40353_1_) {
      return func_40357_a(p_40353_0_, p_40353_1_)?0:1;
   }

   public static int func_40352_a(int p_40352_0_) {
      return func_40351_a(p_40352_0_, 5, 4, 3, 2, 1);
   }

   public static int func_40354_a(Collection p_40354_0_) {
      int var1 = 3694022;
      if(p_40354_0_ != null && !p_40354_0_.isEmpty()) {
         float var2 = 0.0F;
         float var3 = 0.0F;
         float var4 = 0.0F;
         float var5 = 0.0F;
         Iterator var6 = p_40354_0_.iterator();

         while(var6.hasNext()) {
            PotionEffect var7 = (PotionEffect)var6.next();
            int var8 = Potion.field_35678_a[var7.func_35799_a()].func_40621_j();

            for(int var9 = 0; var9 <= var7.func_35801_c(); ++var9) {
               var2 += (float)(var8 >> 16 & 255) / 255.0F;
               var3 += (float)(var8 >> 8 & 255) / 255.0F;
               var4 += (float)(var8 >> 0 & 255) / 255.0F;
               ++var5;
            }
         }

         var2 = var2 / var5 * 255.0F;
         var3 = var3 / var5 * 255.0F;
         var4 = var4 / var5 * 255.0F;
         return (int)var2 << 16 | (int)var3 << 8 | (int)var4;
      } else {
         return var1;
      }
   }

   public static int func_40358_a(int p_40358_0_, boolean p_40358_1_) {
      if(!p_40358_1_) {
         if(field_40368_n.containsKey(Integer.valueOf(p_40358_0_))) {
            return ((Integer)field_40368_n.get(Integer.valueOf(p_40358_0_))).intValue();
         } else {
            int var2 = func_40354_a(func_40360_b(p_40358_0_, false));
            field_40368_n.put(Integer.valueOf(p_40358_0_), Integer.valueOf(var2));
            return var2;
         }
      } else {
         return func_40354_a(func_40360_b(p_40358_0_, p_40358_1_));
      }
   }

   public static String func_40359_b(int p_40359_0_) {
      int var1 = func_40352_a(p_40359_0_);
      return field_40369_o[var1];
   }

   private static int func_40347_a(boolean p_40347_0_, boolean p_40347_1_, boolean p_40347_2_, int p_40347_3_, int p_40347_4_, int p_40347_5_, int p_40347_6_) {
      int var7 = 0;
      if(p_40347_0_) {
         var7 = func_40353_c(p_40347_6_, p_40347_4_);
      } else if(p_40347_3_ != -1) {
         if(p_40347_3_ == 0 && func_40348_c(p_40347_6_) == p_40347_4_) {
            var7 = 1;
         } else if(p_40347_3_ == 1 && func_40348_c(p_40347_6_) > p_40347_4_) {
            var7 = 1;
         } else if(p_40347_3_ == 2 && func_40348_c(p_40347_6_) < p_40347_4_) {
            var7 = 1;
         }
      } else {
         var7 = func_40349_b(p_40347_6_, p_40347_4_);
      }

      if(p_40347_1_) {
         var7 *= p_40347_5_;
      }

      if(p_40347_2_) {
         var7 *= -1;
      }

      return var7;
   }

   private static int func_40348_c(int p_40348_0_) {
      int var1;
      for(var1 = 0; p_40348_0_ > 0; ++var1) {
         p_40348_0_ &= p_40348_0_ - 1;
      }

      return var1;
   }

   private static int func_40355_a(String p_40355_0_, int p_40355_1_, int p_40355_2_, int p_40355_3_) {
      if(p_40355_1_ < p_40355_0_.length() && p_40355_2_ >= 0 && p_40355_1_ < p_40355_2_) {
         int var4 = p_40355_0_.indexOf(124, p_40355_1_);
         int var5;
         int var17;
         if(var4 >= 0 && var4 < p_40355_2_) {
            var5 = func_40355_a(p_40355_0_, p_40355_1_, var4 - 1, p_40355_3_);
            if(var5 > 0) {
               return var5;
            } else {
               var17 = func_40355_a(p_40355_0_, var4 + 1, p_40355_2_, p_40355_3_);
               return var17 > 0?var17:0;
            }
         } else {
            var5 = p_40355_0_.indexOf(38, p_40355_1_);
            if(var5 >= 0 && var5 < p_40355_2_) {
               var17 = func_40355_a(p_40355_0_, p_40355_1_, var5 - 1, p_40355_3_);
               if(var17 <= 0) {
                  return 0;
               } else {
                  int var18 = func_40355_a(p_40355_0_, var5 + 1, p_40355_2_, p_40355_3_);
                  return var18 <= 0?0:(var17 > var18?var17:var18);
               }
            } else {
               boolean var6 = false;
               boolean var7 = false;
               boolean var8 = false;
               boolean var9 = false;
               boolean var10 = false;
               byte var11 = -1;
               int var12 = 0;
               int var13 = 0;
               int var14 = 0;

               for(int var15 = p_40355_1_; var15 < p_40355_2_; ++var15) {
                  char var16 = p_40355_0_.charAt(var15);
                  if(var16 >= 48 && var16 <= 57) {
                     if(var6) {
                        var13 = var16 - 48;
                        var7 = true;
                     } else {
                        var12 *= 10;
                        var12 += var16 - 48;
                        var8 = true;
                     }
                  } else if(var16 == 42) {
                     var6 = true;
                  } else if(var16 == 33) {
                     if(var8) {
                        var14 += func_40347_a(var9, var7, var10, var11, var12, var13, p_40355_3_);
                        var9 = false;
                        var10 = false;
                        var6 = false;
                        var7 = false;
                        var8 = false;
                        var13 = 0;
                        var12 = 0;
                        var11 = -1;
                     }

                     var9 = true;
                  } else if(var16 == 45) {
                     if(var8) {
                        var14 += func_40347_a(var9, var7, var10, var11, var12, var13, p_40355_3_);
                        var9 = false;
                        var10 = false;
                        var6 = false;
                        var7 = false;
                        var8 = false;
                        var13 = 0;
                        var12 = 0;
                        var11 = -1;
                     }

                     var10 = true;
                  } else if(var16 != 61 && var16 != 60 && var16 != 62) {
                     if(var16 == 43 && var8) {
                        var14 += func_40347_a(var9, var7, var10, var11, var12, var13, p_40355_3_);
                        var9 = false;
                        var10 = false;
                        var6 = false;
                        var7 = false;
                        var8 = false;
                        var13 = 0;
                        var12 = 0;
                        var11 = -1;
                     }
                  } else {
                     if(var8) {
                        var14 += func_40347_a(var9, var7, var10, var11, var12, var13, p_40355_3_);
                        var9 = false;
                        var10 = false;
                        var6 = false;
                        var7 = false;
                        var8 = false;
                        var13 = 0;
                        var12 = 0;
                        var11 = -1;
                     }

                     if(var16 == 61) {
                        var11 = 0;
                     } else if(var16 == 60) {
                        var11 = 2;
                     } else if(var16 == 62) {
                        var11 = 1;
                     }
                  }
               }

               if(var8) {
                  var14 += func_40347_a(var9, var7, var10, var11, var12, var13, p_40355_3_);
               }

               return var14;
            }
         }
      } else {
         return 0;
      }
   }

   public static List func_40360_b(int p_40360_0_, boolean p_40360_1_) {
      ArrayList var2 = null;
      Potion[] var3 = Potion.field_35678_a;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Potion var6 = var3[var5];
         if(var6 != null && (!var6.func_40612_i() || p_40360_1_)) {
            String var7 = (String)field_40370_l.get(Integer.valueOf(var6.func_40619_a()));
            if(var7 != null) {
               int var8 = func_40355_a(var7, 0, var7.length(), p_40360_0_);
               if(var8 > 0) {
                  int var9 = 0;
                  String var10 = (String)field_40371_m.get(Integer.valueOf(var6.func_40619_a()));
                  if(var10 != null) {
                     var9 = func_40355_a(var10, 0, var10.length(), p_40360_0_);
                     if(var9 < 0) {
                        var9 = 0;
                     }
                  }

                  if(var6.func_40622_b()) {
                     var8 = 1;
                  } else {
                     var8 = 1200 * (var8 * 3 + (var8 - 1) * 2);
                     var8 >>= var9;
                     var8 = (int)Math.round((double)var8 * var6.func_40610_g());
                     if((p_40360_0_ & 16384) != 0) {
                        var8 = (int)Math.round((double)var8 * 0.75D + 0.5D);
                     }
                  }

                  if(var2 == null) {
                     var2 = new ArrayList();
                  }

                  var2.add(new PotionEffect(var6.func_40619_a(), var8, var9));
               }
            }
         }
      }

      return var2;
   }

   private static int func_40350_a(int p_40350_0_, int p_40350_1_, boolean p_40350_2_, boolean p_40350_3_, boolean p_40350_4_) {
      if(p_40350_4_) {
         if(!func_40357_a(p_40350_0_, p_40350_1_)) {
            return 0;
         }
      } else if(p_40350_2_) {
         p_40350_0_ &= ~(1 << p_40350_1_);
      } else if(p_40350_3_) {
         if((p_40350_0_ & 1 << p_40350_1_) != 0) {
            p_40350_0_ &= ~(1 << p_40350_1_);
         } else {
            p_40350_0_ |= 1 << p_40350_1_;
         }
      } else {
         p_40350_0_ |= 1 << p_40350_1_;
      }

      return p_40350_0_;
   }

   public static int func_40356_a(int p_40356_0_, String p_40356_1_) {
      byte var2 = 0;
      int var3 = p_40356_1_.length();
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      int var8 = 0;

      for(int var9 = var2; var9 < var3; ++var9) {
         char var10 = p_40356_1_.charAt(var9);
         if(var10 >= 48 && var10 <= 57) {
            var8 *= 10;
            var8 += var10 - 48;
            var4 = true;
         } else if(var10 == 33) {
            if(var4) {
               p_40356_0_ = func_40350_a(p_40356_0_, var8, var6, var5, var7);
               var7 = false;
               var5 = false;
               var6 = false;
               var4 = false;
               var8 = 0;
            }

            var5 = true;
         } else if(var10 == 45) {
            if(var4) {
               p_40356_0_ = func_40350_a(p_40356_0_, var8, var6, var5, var7);
               var7 = false;
               var5 = false;
               var6 = false;
               var4 = false;
               var8 = 0;
            }

            var6 = true;
         } else if(var10 == 43) {
            if(var4) {
               p_40356_0_ = func_40350_a(p_40356_0_, var8, var6, var5, var7);
               var7 = false;
               var5 = false;
               var6 = false;
               var4 = false;
               var8 = 0;
            }
         } else if(var10 == 38) {
            if(var4) {
               p_40356_0_ = func_40350_a(p_40356_0_, var8, var6, var5, var7);
               var7 = false;
               var5 = false;
               var6 = false;
               var4 = false;
               var8 = 0;
            }

            var7 = true;
         }
      }

      if(var4) {
         p_40356_0_ = func_40350_a(p_40356_0_, var8, var6, var5, var7);
      }

      return p_40356_0_ & 32767;
   }

   public static int func_40351_a(int p_40351_0_, int p_40351_1_, int p_40351_2_, int p_40351_3_, int p_40351_4_, int p_40351_5_) {
      return (func_40357_a(p_40351_0_, p_40351_1_)?16:0) | (func_40357_a(p_40351_0_, p_40351_2_)?8:0) | (func_40357_a(p_40351_0_, p_40351_3_)?4:0) | (func_40357_a(p_40351_0_, p_40351_4_)?2:0) | (func_40357_a(p_40351_0_, p_40351_5_)?1:0);
   }

   static {
      field_40370_l.put(Integer.valueOf(Potion.field_35681_l.func_40619_a()), "0 & !1 & !2 & !3 & 0+6");
      field_40365_b = "-0+1-2-3&4-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35677_c.func_40619_a()), "!0 & 1 & !2 & !3 & 1+6");
      field_40374_h = "+0+1-2-3&4-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35679_n.func_40619_a()), "0 & 1 & !2 & !3 & 0+6");
      field_40361_f = "+0-1+2-3&4-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35685_h.func_40619_a()), "0 & !1 & 2 & !3");
      field_40363_d = "-0-1+2-3&4-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35689_u.func_40619_a()), "!0 & !1 & 2 & !3 & 2+6");
      field_40364_e = "-0+3-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35690_t.func_40619_a()), "!0 & !1 & !2 & 3 & 3+6");
      field_40370_l.put(Integer.valueOf(Potion.field_35686_i.func_40619_a()), "!0 & !1 & 2 & 3");
      field_40370_l.put(Integer.valueOf(Potion.field_35674_d.func_40619_a()), "!0 & 1 & !2 & 3 & 3+6");
      field_40362_g = "+0-1-2+3&4-4+13";
      field_40370_l.put(Integer.valueOf(Potion.field_35673_g.func_40619_a()), "0 & !1 & !2 & 3 & 3+6");
      field_40372_j = "+5-6-7";
      field_40371_m.put(Integer.valueOf(Potion.field_35677_c.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35675_e.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35673_g.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35681_l.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35686_i.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35685_h.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35682_m.func_40619_a()), "5");
      field_40371_m.put(Integer.valueOf(Potion.field_35689_u.func_40619_a()), "5");
      field_40375_i = "-5+6-7";
      field_40373_k = "+14&13-13";
      field_40368_n = new HashMap();
      field_40369_o = new String[]{"potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky"};
   }
}
