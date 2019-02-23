package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiScreenAddServer;
import net.minecraft.src.GuiScreenServerList;
import net.minecraft.src.GuiSlotServer;
import net.minecraft.src.GuiYesNo;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Packet;
import net.minecraft.src.ServerNBTStorage;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;
import org.lwjgl.input.Keyboard;

public class GuiMultiplayer extends GuiScreen {

   private static int field_35344_a = 0;
   private static Object field_35343_b = new Object();
   private GuiScreen field_968_a;
   private GuiSlotServer field_35342_d;
   private List field_35340_f = new ArrayList();
   private int field_35341_g = -1;
   private GuiButton field_35347_h;
   private GuiButton field_35348_i;
   private GuiButton field_35345_j;
   private boolean field_35346_k = false;
   private boolean field_35353_s = false;
   private boolean field_35352_t = false;
   private boolean field_35351_u = false;
   private String field_35350_v = null;
   private ServerNBTStorage field_35349_w = null;


   public GuiMultiplayer(GuiScreen p_i17_1_) {
      this.field_968_a = p_i17_1_;
   }

   public void func_570_g() {}

   public void func_6448_a() {
      this.func_35324_p();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.clear();
      this.field_35342_d = new GuiSlotServer(this);
      this.func_35337_c();
   }

   private void func_35324_p() {
      try {
         NBTTagCompound var1 = CompressedStreamTools.func_35622_a(new File(this.field_945_b.field_6297_D, "servers.dat"));
         NBTTagList var2 = var1.func_753_l("servers");
         this.field_35340_f.clear();

         for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
            this.field_35340_f.add(ServerNBTStorage.func_35788_a((NBTTagCompound)var2.func_741_a(var3)));
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   private void func_35323_q() {
      try {
         NBTTagList var1 = new NBTTagList();

         for(int var2 = 0; var2 < this.field_35340_f.size(); ++var2) {
            var1.func_742_a(((ServerNBTStorage)this.field_35340_f.get(var2)).func_35789_a());
         }

         NBTTagCompound var4 = new NBTTagCompound();
         var4.func_762_a("servers", var1);
         CompressedStreamTools.func_35621_a(var4, new File(this.field_945_b.field_6297_D, "servers.dat"));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public void func_35337_c() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.add(this.field_35347_h = new GuiButton(7, this.field_951_c / 2 - 154, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectServer.edit")));
      this.field_949_e.add(this.field_35345_j = new GuiButton(2, this.field_951_c / 2 - 74, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectServer.delete")));
      this.field_949_e.add(this.field_35348_i = new GuiButton(1, this.field_951_c / 2 - 154, this.field_950_d - 52, 100, 20, var1.func_20163_a("selectServer.select")));
      this.field_949_e.add(new GuiButton(4, this.field_951_c / 2 - 50, this.field_950_d - 52, 100, 20, var1.func_20163_a("selectServer.direct")));
      this.field_949_e.add(new GuiButton(3, this.field_951_c / 2 + 4 + 50, this.field_950_d - 52, 100, 20, var1.func_20163_a("selectServer.add")));
      this.field_949_e.add(new GuiButton(8, this.field_951_c / 2 + 4, this.field_950_d - 28, 70, 20, var1.func_20163_a("selectServer.refresh")));
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 + 4 + 76, this.field_950_d - 28, 75, 20, var1.func_20163_a("gui.cancel")));
      boolean var2 = this.field_35341_g >= 0 && this.field_35341_g < this.field_35342_d.func_22249_a();
      this.field_35348_i.field_937_g = var2;
      this.field_35347_h.field_937_g = var2;
      this.field_35345_j.field_937_g = var2;
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 2) {
            String var2 = ((ServerNBTStorage)this.field_35340_f.get(this.field_35341_g)).field_35795_a;
            if(var2 != null) {
               this.field_35346_k = true;
               StringTranslate var3 = StringTranslate.func_20162_a();
               String var4 = var3.func_20163_a("selectServer.deleteQuestion");
               String var5 = "\'" + var2 + "\' " + var3.func_20163_a("selectServer.deleteWarning");
               String var6 = var3.func_20163_a("selectServer.deleteButton");
               String var7 = var3.func_20163_a("gui.cancel");
               GuiYesNo var8 = new GuiYesNo(this, var4, var5, var6, var7, this.field_35341_g);
               this.field_945_b.func_6272_a(var8);
            }
         } else if(p_572_1_.field_938_f == 1) {
            this.func_35322_a(this.field_35341_g);
         } else if(p_572_1_.field_938_f == 4) {
            this.field_35351_u = true;
            this.field_945_b.func_6272_a(new GuiScreenServerList(this, this.field_35349_w = new ServerNBTStorage(StatCollector.func_25200_a("selectServer.defaultName"), "")));
         } else if(p_572_1_.field_938_f == 3) {
            this.field_35353_s = true;
            this.field_945_b.func_6272_a(new GuiScreenAddServer(this, this.field_35349_w = new ServerNBTStorage(StatCollector.func_25200_a("selectServer.defaultName"), "")));
         } else if(p_572_1_.field_938_f == 7) {
            this.field_35352_t = true;
            ServerNBTStorage var9 = (ServerNBTStorage)this.field_35340_f.get(this.field_35341_g);
            this.field_945_b.func_6272_a(new GuiScreenAddServer(this, this.field_35349_w = new ServerNBTStorage(var9.field_35795_a, var9.field_35793_b)));
         } else if(p_572_1_.field_938_f == 0) {
            this.field_945_b.func_6272_a(this.field_968_a);
         } else if(p_572_1_.field_938_f == 8) {
            this.field_945_b.func_6272_a(new GuiMultiplayer(this.field_968_a));
         } else {
            this.field_35342_d.func_22241_a(p_572_1_);
         }

      }
   }

   public void func_568_a(boolean p_568_1_, int p_568_2_) {
      if(this.field_35346_k) {
         this.field_35346_k = false;
         if(p_568_1_) {
            this.field_35340_f.remove(p_568_2_);
            this.func_35323_q();
         }

         this.field_945_b.func_6272_a(this);
      } else if(this.field_35351_u) {
         this.field_35351_u = false;
         if(p_568_1_) {
            this.func_35330_a(this.field_35349_w);
         } else {
            this.field_945_b.func_6272_a(this);
         }
      } else if(this.field_35353_s) {
         this.field_35353_s = false;
         if(p_568_1_) {
            this.field_35340_f.add(this.field_35349_w);
            this.func_35323_q();
         }

         this.field_945_b.func_6272_a(this);
      } else if(this.field_35352_t) {
         this.field_35352_t = false;
         if(p_568_1_) {
            ServerNBTStorage var3 = (ServerNBTStorage)this.field_35340_f.get(this.field_35341_g);
            var3.field_35795_a = this.field_35349_w.field_35795_a;
            var3.field_35793_b = this.field_35349_w.field_35793_b;
            this.func_35323_q();
         }

         this.field_945_b.func_6272_a(this);
      }

   }

   private int func_4067_a(String p_4067_1_, int p_4067_2_) {
      try {
         return Integer.parseInt(p_4067_1_.trim());
      } catch (Exception var4) {
         return p_4067_2_;
      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_1_ == 13) {
         this.func_572_a((GuiButton)this.field_949_e.get(2));
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.field_35350_v = null;
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_578_i();
      this.field_35342_d.func_22243_a(p_571_1_, p_571_2_, p_571_3_);
      this.func_548_a(this.field_6451_g, var4.func_20163_a("multiplayer.title"), this.field_951_c / 2, 20, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
      if(this.field_35350_v != null) {
         this.func_35325_a(this.field_35350_v, p_571_1_, p_571_2_);
      }

   }

   private void func_35322_a(int p_35322_1_) {
      this.func_35330_a((ServerNBTStorage)this.field_35340_f.get(p_35322_1_));
   }

   private void func_35330_a(ServerNBTStorage p_35330_1_) {
      String var2 = p_35330_1_.field_35793_b;
      String[] var3 = var2.split(":");
      if(var2.startsWith("[")) {
         int var4 = var2.indexOf("]");
         if(var4 > 0) {
            String var5 = var2.substring(1, var4);
            String var6 = var2.substring(var4 + 1).trim();
            if(var6.startsWith(":") && var6.length() > 0) {
               var6 = var6.substring(1);
               var3 = new String[]{var5, var6};
            } else {
               var3 = new String[]{var5};
            }
         }
      }

      if(var3.length > 2) {
         var3 = new String[]{var2};
      }

      this.field_945_b.func_6272_a(new GuiConnecting(this.field_945_b, var3[0], var3.length > 1?this.func_4067_a(var3[1], 25565):25565));
   }

   private void func_35328_b(ServerNBTStorage p_35328_1_) throws IOException {
      String var2 = p_35328_1_.field_35793_b;
      String[] var3 = var2.split(":");
      if(var2.startsWith("[")) {
         int var4 = var2.indexOf("]");
         if(var4 > 0) {
            String var5 = var2.substring(1, var4);
            String var6 = var2.substring(var4 + 1).trim();
            if(var6.startsWith(":") && var6.length() > 0) {
               var6 = var6.substring(1);
               var3 = new String[]{var5, var6};
            } else {
               var3 = new String[]{var5};
            }
         }
      }

      if(var3.length > 2) {
         var3 = new String[]{var2};
      }

      String var29 = var3[0];
      int var30 = var3.length > 1?this.func_4067_a(var3[1], 25565):25565;
      Socket var31 = null;
      DataInputStream var7 = null;
      DataOutputStream var8 = null;

      try {
         var31 = new Socket();
         var31.setSoTimeout(3000);
         var31.setTcpNoDelay(true);
         var31.setTrafficClass(18);
         var31.connect(new InetSocketAddress(var29, var30), 3000);
         var7 = new DataInputStream(var31.getInputStream());
         var8 = new DataOutputStream(var31.getOutputStream());
         var8.write(254);
         if(var7.read() != 255) {
            throw new IOException("Bad message");
         }

         String var9 = Packet.func_27048_a(var7, 256);
         char[] var10 = var9.toCharArray();

         int var11;
         for(var11 = 0; var11 < var10.length; ++var11) {
            if(var10[var11] != 167 && ChatAllowedCharacters.field_20157_a.indexOf(var10[var11]) < 0) {
               var10[var11] = 63;
            }
         }

         var9 = new String(var10);
         var3 = var9.split("\u00a7");
         var9 = var3[0];
         var11 = -1;
         int var12 = -1;

         try {
            var11 = Integer.parseInt(var3[1]);
            var12 = Integer.parseInt(var3[2]);
         } catch (Exception var27) {
            ;
         }

         p_35328_1_.field_35791_d = "\u00a77" + var9;
         if(var11 >= 0 && var12 > 0) {
            p_35328_1_.field_35794_c = "\u00a77" + var11 + "\u00a78/\u00a77" + var12;
         } else {
            p_35328_1_.field_35794_c = "\u00a78???";
         }
      } finally {
         try {
            if(var7 != null) {
               var7.close();
            }
         } catch (Throwable var26) {
            ;
         }

         try {
            if(var8 != null) {
               var8.close();
            }
         } catch (Throwable var25) {
            ;
         }

         try {
            if(var31 != null) {
               var31.close();
            }
         } catch (Throwable var24) {
            ;
         }

      }

   }

   protected void func_35325_a(String p_35325_1_, int p_35325_2_, int p_35325_3_) {
      if(p_35325_1_ != null) {
         int var4 = p_35325_2_ + 12;
         int var5 = p_35325_3_ - 12;
         int var6 = this.field_6451_g.func_871_a(p_35325_1_);
         this.func_549_a(var4 - 3, var5 - 3, var4 + var6 + 3, var5 + 8 + 3, -1073741824, -1073741824);
         this.field_6451_g.func_50103_a(p_35325_1_, var4, var5, -1);
      }
   }

   // $FF: synthetic method
   static List func_35320_a(GuiMultiplayer p_35320_0_) {
      return p_35320_0_.field_35340_f;
   }

   // $FF: synthetic method
   static int func_35326_a(GuiMultiplayer p_35326_0_, int p_35326_1_) {
      return p_35326_0_.field_35341_g = p_35326_1_;
   }

   // $FF: synthetic method
   static int func_35333_b(GuiMultiplayer p_35333_0_) {
      return p_35333_0_.field_35341_g;
   }

   // $FF: synthetic method
   static GuiButton func_35329_c(GuiMultiplayer p_35329_0_) {
      return p_35329_0_.field_35348_i;
   }

   // $FF: synthetic method
   static GuiButton func_35334_d(GuiMultiplayer p_35334_0_) {
      return p_35334_0_.field_35347_h;
   }

   // $FF: synthetic method
   static GuiButton func_35339_e(GuiMultiplayer p_35339_0_) {
      return p_35339_0_.field_35345_j;
   }

   // $FF: synthetic method
   static void func_35332_b(GuiMultiplayer p_35332_0_, int p_35332_1_) {
      p_35332_0_.func_35322_a(p_35332_1_);
   }

   // $FF: synthetic method
   static Object func_35321_g() {
      return field_35343_b;
   }

   // $FF: synthetic method
   static int func_35338_m() {
      return field_35344_a;
   }

   // $FF: synthetic method
   static int func_35331_n() {
      return field_35344_a++;
   }

   // $FF: synthetic method
   static void func_35336_a(GuiMultiplayer p_35336_0_, ServerNBTStorage p_35336_1_) throws IOException {
      p_35336_0_.func_35328_b(p_35336_1_);
   }

   // $FF: synthetic method
   static int func_35335_o() {
      return field_35344_a--;
   }

   // $FF: synthetic method
   static String func_35327_a(GuiMultiplayer p_35327_0_, String p_35327_1_) {
      return p_35327_0_.field_35350_v = p_35327_1_;
   }

}
