package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBox;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureOffset;
import org.lwjgl.opengl.GL11;

public class ModelRenderer {

   public float field_35971_a;
   public float field_35970_b;
   private int field_1399_l;
   private int field_1398_m;
   public float field_1410_a;
   public float field_1409_b;
   public float field_1408_c;
   public float field_1407_d;
   public float field_1406_e;
   public float field_1405_f;
   private boolean field_1397_n;
   private int field_1396_o;
   public boolean field_1404_g;
   public boolean field_1403_h;
   public boolean field_1402_i;
   public List field_40606_l;
   public List field_40607_m;
   public final String field_40605_n;
   private ModelBase field_40608_s;


   public ModelRenderer(ModelBase p_i554_1_, String p_i554_2_) {
      this.field_35971_a = 64.0F;
      this.field_35970_b = 32.0F;
      this.field_1397_n = false;
      this.field_1396_o = 0;
      this.field_1404_g = false;
      this.field_1403_h = true;
      this.field_1402_i = false;
      this.field_40606_l = new ArrayList();
      this.field_40608_s = p_i554_1_;
      p_i554_1_.field_35394_j.add(this);
      this.field_40605_n = p_i554_2_;
      this.func_35968_a(p_i554_1_.field_40299_l, p_i554_1_.field_40300_m);
   }

   public ModelRenderer(ModelBase p_i555_1_) {
      this(p_i555_1_, (String)null);
   }

   public ModelRenderer(ModelBase p_i556_1_, int p_i556_2_, int p_i556_3_) {
      this(p_i556_1_);
      this.func_40602_a(p_i556_2_, p_i556_3_);
   }

   public void func_35969_a(ModelRenderer p_35969_1_) {
      if(this.field_40607_m == null) {
         this.field_40607_m = new ArrayList();
      }

      this.field_40607_m.add(p_35969_1_);
   }

   public ModelRenderer func_40602_a(int p_40602_1_, int p_40602_2_) {
      this.field_1399_l = p_40602_1_;
      this.field_1398_m = p_40602_2_;
      return this;
   }

   public ModelRenderer func_40603_a(String p_40603_1_, float p_40603_2_, float p_40603_3_, float p_40603_4_, int p_40603_5_, int p_40603_6_, int p_40603_7_) {
      p_40603_1_ = this.field_40605_n + "." + p_40603_1_;
      TextureOffset var8 = this.field_40608_s.func_40297_a(p_40603_1_);
      this.func_40602_a(var8.field_40734_a, var8.field_40733_b);
      this.field_40606_l.add((new ModelBox(this, this.field_1399_l, this.field_1398_m, p_40603_2_, p_40603_3_, p_40603_4_, p_40603_5_, p_40603_6_, p_40603_7_, 0.0F)).func_40671_a(p_40603_1_));
      return this;
   }

   public ModelRenderer func_40604_a(float p_40604_1_, float p_40604_2_, float p_40604_3_, int p_40604_4_, int p_40604_5_, int p_40604_6_) {
      this.field_40606_l.add(new ModelBox(this, this.field_1399_l, this.field_1398_m, p_40604_1_, p_40604_2_, p_40604_3_, p_40604_4_, p_40604_5_, p_40604_6_, 0.0F));
      return this;
   }

   public void func_923_a(float p_923_1_, float p_923_2_, float p_923_3_, int p_923_4_, int p_923_5_, int p_923_6_, float p_923_7_) {
      this.field_40606_l.add(new ModelBox(this, this.field_1399_l, this.field_1398_m, p_923_1_, p_923_2_, p_923_3_, p_923_4_, p_923_5_, p_923_6_, p_923_7_));
   }

   public void func_925_a(float p_925_1_, float p_925_2_, float p_925_3_) {
      this.field_1410_a = p_925_1_;
      this.field_1409_b = p_925_2_;
      this.field_1408_c = p_925_3_;
   }

   public void func_922_a(float p_922_1_) {
      if(!this.field_1402_i) {
         if(this.field_1403_h) {
            if(!this.field_1397_n) {
               this.func_924_c(p_922_1_);
            }

            int var2;
            if(this.field_1407_d == 0.0F && this.field_1406_e == 0.0F && this.field_1405_f == 0.0F) {
               if(this.field_1410_a == 0.0F && this.field_1409_b == 0.0F && this.field_1408_c == 0.0F) {
                  GL11.glCallList(this.field_1396_o);
                  if(this.field_40607_m != null) {
                     for(var2 = 0; var2 < this.field_40607_m.size(); ++var2) {
                        ((ModelRenderer)this.field_40607_m.get(var2)).func_922_a(p_922_1_);
                     }
                  }
               } else {
                  GL11.glTranslatef(this.field_1410_a * p_922_1_, this.field_1409_b * p_922_1_, this.field_1408_c * p_922_1_);
                  GL11.glCallList(this.field_1396_o);
                  if(this.field_40607_m != null) {
                     for(var2 = 0; var2 < this.field_40607_m.size(); ++var2) {
                        ((ModelRenderer)this.field_40607_m.get(var2)).func_922_a(p_922_1_);
                     }
                  }

                  GL11.glTranslatef(-this.field_1410_a * p_922_1_, -this.field_1409_b * p_922_1_, -this.field_1408_c * p_922_1_);
               }
            } else {
               GL11.glPushMatrix();
               GL11.glTranslatef(this.field_1410_a * p_922_1_, this.field_1409_b * p_922_1_, this.field_1408_c * p_922_1_);
               if(this.field_1405_f != 0.0F) {
                  GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if(this.field_1406_e != 0.0F) {
                  GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if(this.field_1407_d != 0.0F) {
                  GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
               }

               GL11.glCallList(this.field_1396_o);
               if(this.field_40607_m != null) {
                  for(var2 = 0; var2 < this.field_40607_m.size(); ++var2) {
                     ((ModelRenderer)this.field_40607_m.get(var2)).func_922_a(p_922_1_);
                  }
               }

               GL11.glPopMatrix();
            }

         }
      }
   }

   public void func_25122_b(float p_25122_1_) {
      if(!this.field_1402_i) {
         if(this.field_1403_h) {
            if(!this.field_1397_n) {
               this.func_924_c(p_25122_1_);
            }

            GL11.glPushMatrix();
            GL11.glTranslatef(this.field_1410_a * p_25122_1_, this.field_1409_b * p_25122_1_, this.field_1408_c * p_25122_1_);
            if(this.field_1406_e != 0.0F) {
               GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
            }

            if(this.field_1407_d != 0.0F) {
               GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
            }

            if(this.field_1405_f != 0.0F) {
               GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glCallList(this.field_1396_o);
            GL11.glPopMatrix();
         }
      }
   }

   public void func_926_b(float p_926_1_) {
      if(!this.field_1402_i) {
         if(this.field_1403_h) {
            if(!this.field_1397_n) {
               this.func_924_c(p_926_1_);
            }

            if(this.field_1407_d == 0.0F && this.field_1406_e == 0.0F && this.field_1405_f == 0.0F) {
               if(this.field_1410_a != 0.0F || this.field_1409_b != 0.0F || this.field_1408_c != 0.0F) {
                  GL11.glTranslatef(this.field_1410_a * p_926_1_, this.field_1409_b * p_926_1_, this.field_1408_c * p_926_1_);
               }
            } else {
               GL11.glTranslatef(this.field_1410_a * p_926_1_, this.field_1409_b * p_926_1_, this.field_1408_c * p_926_1_);
               if(this.field_1405_f != 0.0F) {
                  GL11.glRotatef(this.field_1405_f * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if(this.field_1406_e != 0.0F) {
                  GL11.glRotatef(this.field_1406_e * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if(this.field_1407_d != 0.0F) {
                  GL11.glRotatef(this.field_1407_d * 57.295776F, 1.0F, 0.0F, 0.0F);
               }
            }

         }
      }
   }

   private void func_924_c(float p_924_1_) {
      this.field_1396_o = GLAllocation.func_1124_a(1);
      GL11.glNewList(this.field_1396_o, 4864);
      Tessellator var2 = Tessellator.field_1512_a;

      for(int var3 = 0; var3 < this.field_40606_l.size(); ++var3) {
         ((ModelBox)this.field_40606_l.get(var3)).func_40670_a(var2, p_924_1_);
      }

      GL11.glEndList();
      this.field_1397_n = true;
   }

   public ModelRenderer func_35968_a(int p_35968_1_, int p_35968_2_) {
      this.field_35971_a = (float)p_35968_1_;
      this.field_35970_b = (float)p_35968_2_;
      return this;
   }
}
