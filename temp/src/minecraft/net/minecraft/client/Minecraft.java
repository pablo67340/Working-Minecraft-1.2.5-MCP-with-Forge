package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.AchievementList;
import net.minecraft.src.AnvilSaveConverter;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderLoadOrGenerate;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.ColorizerWater;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.EnumOS2;
import net.minecraft.src.EnumOSMappingHelper;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GameWindowListener;
import net.minecraft.src.GuiAchievement;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConflictWarning;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiErrorScreen;
import net.minecraft.src.GuiGameOver;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiMemoryErrorScreen;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSleepMP;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.MinecraftImpl;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.MouseHelper;
import net.minecraft.src.MovementInputFromOptions;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.OpenGlCapsChecker;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.PlayerController;
import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.Profiler;
import net.minecraft.src.ProfilerResult;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ScreenShotHelper;
import net.minecraft.src.Session;
import net.minecraft.src.SoundManager;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatFileWriter;
import net.minecraft.src.StatList;
import net.minecraft.src.StatStringFormatKeyInv;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Teleporter;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureCompassFX;
import net.minecraft.src.TextureFlamesFX;
import net.minecraft.src.TextureLavaFX;
import net.minecraft.src.TextureLavaFlowFX;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.TexturePortalFX;
import net.minecraft.src.TextureWatchFX;
import net.minecraft.src.TextureWaterFX;
import net.minecraft.src.TextureWaterFlowFX;
import net.minecraft.src.ThreadCheckHasPaid;
import net.minecraft.src.ThreadClientSleep;
import net.minecraft.src.ThreadDownloadResources;
import net.minecraft.src.Timer;
import net.minecraft.src.UnexpectedThrowable;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldRenderer;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable {

   public static byte[] field_28006_b = new byte[10485760];
   private static Minecraft field_21900_a;
   public PlayerController field_6327_b;
   private boolean field_185_a = false;
   private boolean field_28004_R = false;
   public int field_6326_c;
   public int field_6325_d;
   private OpenGlCapsChecker field_6286_O;
   private Timer field_9237_P = new Timer(20.0F);
   public World field_6324_e;
   public RenderGlobal field_6323_f;
   public EntityPlayerSP field_6322_g;
   public EntityLiving field_22009_h;
   public EffectRenderer field_6321_h;
   public Session field_6320_i = null;
   public String field_6319_j;
   public Canvas field_9244_k;
   public boolean field_6317_l = false;
   public volatile boolean field_6316_m = false;
   public RenderEngine field_6315_n;
   public FontRenderer field_6314_o;
   public FontRenderer field_40007_r;
   public GuiScreen field_6313_p = null;
   public LoadingScreenRenderer field_6312_q;
   public EntityRenderer field_9243_r;
   private ThreadDownloadResources field_6284_Q;
   private int field_6283_R = 0;
   private int field_6282_S = 0;
   private int field_9236_T;
   private int field_9235_U;
   public GuiAchievement field_25002_t = new GuiAchievement(this);
   public GuiIngame field_6308_u;
   public boolean field_6307_v = false;
   public ModelBiped field_9242_w = new ModelBiped(0.0F);
   public MovingObjectPosition field_6305_x = null;
   public GameSettings field_6304_y;
   protected MinecraftApplet field_9241_z;
   public SoundManager field_6301_A = new SoundManager();
   public MouseHelper field_6299_B;
   public TexturePackList field_6298_C;
   public File field_6297_D;
   private ISaveFormat field_22008_V;
   public static long[] field_9240_E = new long[512];
   public static long[] field_9239_F = new long[512];
   public static int field_9238_G = 0;
   public static long field_28005_H = 0L;
   private int field_35001_ab = 0;
   public StatFileWriter field_25001_G;
   private String field_9234_V;
   private int field_9233_W;
   private TextureWaterFX field_9232_X = new TextureWaterFX();
   private TextureLavaFX field_9231_Y = new TextureLavaFX();
   private static File field_6275_Z = null;
   public volatile boolean field_6293_H = true;
   public String field_6292_I = "";
   long field_40004_N = System.currentTimeMillis();
   int field_40005_O = 0;
   boolean field_6291_J = false;
   long field_6290_K = -1L;
   private String field_40006_ak = "root";
   public boolean field_6289_L = false;
   public boolean field_6288_M = false;
   long field_6287_N = System.currentTimeMillis();
   private int field_6300_ab = 0;


   public Minecraft(Component p_i777_1_, Canvas p_i777_2_, MinecraftApplet p_i777_3_, int p_i777_4_, int p_i777_5_, boolean p_i777_6_) {
      StatList.func_27360_a();
      this.field_9235_U = p_i777_5_;
      this.field_185_a = p_i777_6_;
      this.field_9241_z = p_i777_3_;
      Packet3Chat.field_52010_b = 32767;
      new ThreadClientSleep(this, "Timer hack thread");
      this.field_9244_k = p_i777_2_;
      this.field_6326_c = p_i777_4_;
      this.field_6325_d = p_i777_5_;
      this.field_185_a = p_i777_6_;
      if(p_i777_3_ == null || "true".equals(p_i777_3_.getParameter("stand-alone"))) {
         this.field_6317_l = false;
      }

      field_21900_a = this;
   }

   public void func_28003_b(UnexpectedThrowable p_28003_1_) {
      this.field_28004_R = true;
      this.func_4007_a(p_28003_1_);
   }

   public abstract void func_4007_a(UnexpectedThrowable var1);

   public void func_6258_a(String p_6258_1_, int p_6258_2_) {
      this.field_9234_V = p_6258_1_;
      this.field_9233_W = p_6258_2_;
   }

   public void func_6271_a() throws LWJGLException {
      if(this.field_9244_k != null) {
         Graphics var1 = this.field_9244_k.getGraphics();
         if(var1 != null) {
            var1.setColor(Color.BLACK);
            var1.fillRect(0, 0, this.field_6326_c, this.field_6325_d);
            var1.dispose();
         }

         Display.setParent(this.field_9244_k);
      } else if(this.field_185_a) {
         Display.setFullscreen(true);
         this.field_6326_c = Display.getDisplayMode().getWidth();
         this.field_6325_d = Display.getDisplayMode().getHeight();
         if(this.field_6326_c <= 0) {
            this.field_6326_c = 1;
         }

         if(this.field_6325_d <= 0) {
            this.field_6325_d = 1;
         }
      } else {
         Display.setDisplayMode(new DisplayMode(this.field_6326_c, this.field_6325_d));
      }

      Display.setTitle("Minecraft Minecraft 1.2.5");
      System.out.println("LWJGL Version: " + Sys.getVersion());

      try {
         PixelFormat var7 = new PixelFormat();
         var7 = var7.withDepthBits(24);
         Display.create(var7);
      } catch (LWJGLException var6) {
         var6.printStackTrace();

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var5) {
            ;
         }

         Display.create();
      }

      OpenGlHelper.func_40453_a();
      this.field_6297_D = func_6240_b();
      this.field_22008_V = new AnvilSaveConverter(new File(this.field_6297_D, "saves"));
      this.field_6304_y = new GameSettings(this, this.field_6297_D);
      this.field_6298_C = new TexturePackList(this, this.field_6297_D);
      this.field_6315_n = new RenderEngine(this.field_6298_C, this.field_6304_y);
      this.func_6257_q();
      this.field_6314_o = new FontRenderer(this.field_6304_y, "/font/default.png", this.field_6315_n, false);
      this.field_40007_r = new FontRenderer(this.field_6304_y, "/font/alternate.png", this.field_6315_n, false);
      if(this.field_6304_y.field_44018_Q != null) {
         StringTranslate.func_20162_a().func_44023_a(this.field_6304_y.field_44018_Q);
         this.field_6314_o.func_44032_a(StringTranslate.func_20162_a().func_46110_d());
         this.field_6314_o.func_46123_b(StringTranslate.func_46109_d(this.field_6304_y.field_44018_Q));
      }

      ColorizerWater.func_28182_a(this.field_6315_n.func_28149_a("/misc/watercolor.png"));
      ColorizerGrass.func_28181_a(this.field_6315_n.func_28149_a("/misc/grasscolor.png"));
      ColorizerFoliage.func_28152_a(this.field_6315_n.func_28149_a("/misc/foliagecolor.png"));
      this.field_9243_r = new EntityRenderer(this);
      RenderManager.field_1233_a.field_4236_f = new ItemRenderer(this);
      this.field_25001_G = new StatFileWriter(this.field_6320_i, this.field_6297_D);
      AchievementList.field_25195_b.func_27092_a(new StatStringFormatKeyInv(this));
      this.func_6257_q();
      Mouse.create();
      this.field_6299_B = new MouseHelper(this.field_9244_k);

      try {
         Controllers.create();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      func_52004_D();
      this.func_6250_c("Pre startup");
      GL11.glEnable(3553);
      GL11.glShadeModel(7425);
      GL11.glClearDepth(1.0D);
      GL11.glEnable(2929);
      GL11.glDepthFunc(515);
      GL11.glEnable(3008);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glCullFace(1029);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glMatrixMode(5888);
      this.func_6250_c("Startup");
      this.field_6286_O = new OpenGlCapsChecker();
      this.field_6301_A.func_340_a(this.field_6304_y);
      this.field_6315_n.func_1066_a(this.field_9231_Y);
      this.field_6315_n.func_1066_a(this.field_9232_X);
      this.field_6315_n.func_1066_a(new TexturePortalFX());
      this.field_6315_n.func_1066_a(new TextureCompassFX(this));
      this.field_6315_n.func_1066_a(new TextureWatchFX(this));
      this.field_6315_n.func_1066_a(new TextureWaterFlowFX());
      this.field_6315_n.func_1066_a(new TextureLavaFlowFX());
      this.field_6315_n.func_1066_a(new TextureFlamesFX(0));
      this.field_6315_n.func_1066_a(new TextureFlamesFX(1));
      this.field_6323_f = new RenderGlobal(this, this.field_6315_n);
      GL11.glViewport(0, 0, this.field_6326_c, this.field_6325_d);
      this.field_6321_h = new EffectRenderer(this.field_6324_e, this.field_6315_n);

      try {
         this.field_6284_Q = new ThreadDownloadResources(this.field_6297_D, this);
         this.field_6284_Q.start();
      } catch (Exception var3) {
         ;
      }

      this.func_6250_c("Post startup");
      this.field_6308_u = new GuiIngame(this);
      if(this.field_9234_V != null) {
         this.func_6272_a(new GuiConnecting(this, this.field_9234_V, this.field_9233_W));
      } else {
         this.func_6272_a(new GuiMainMenu());
      }

      this.field_6312_q = new LoadingScreenRenderer(this);
   }

   private void func_6257_q() throws LWJGLException {
      ScaledResolution var1 = new ScaledResolution(this.field_6304_y, this.field_6326_c, this.field_6325_d);
      GL11.glClear(16640);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, var1.field_25121_a, var1.field_25120_b, 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
      GL11.glViewport(0, 0, this.field_6326_c, this.field_6325_d);
      GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      Tessellator var2 = Tessellator.field_1512_a;
      GL11.glDisable(2896);
      GL11.glEnable(3553);
      GL11.glDisable(2912);
      GL11.glBindTexture(3553, this.field_6315_n.func_1070_a("/title/mojang.png"));
      var2.func_977_b();
      var2.func_990_b(16777215);
      var2.func_983_a(0.0D, (double)this.field_6325_d, 0.0D, 0.0D, 0.0D);
      var2.func_983_a((double)this.field_6326_c, (double)this.field_6325_d, 0.0D, 0.0D, 0.0D);
      var2.func_983_a((double)this.field_6326_c, 0.0D, 0.0D, 0.0D, 0.0D);
      var2.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      var2.func_982_a();
      short var3 = 256;
      short var4 = 256;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var2.func_990_b(16777215);
      this.func_6274_a((var1.func_903_a() - var3) / 2, (var1.func_902_b() - var4) / 2, 0, 0, var3, var4);
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      GL11.glEnable(3008);
      GL11.glAlphaFunc(516, 0.1F);
      Display.swapBuffers();
   }

   public void func_6274_a(int p_6274_1_, int p_6274_2_, int p_6274_3_, int p_6274_4_, int p_6274_5_, int p_6274_6_) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.field_1512_a;
      var9.func_977_b();
      var9.func_983_a((double)(p_6274_1_ + 0), (double)(p_6274_2_ + p_6274_6_), 0.0D, (double)((float)(p_6274_3_ + 0) * var7), (double)((float)(p_6274_4_ + p_6274_6_) * var8));
      var9.func_983_a((double)(p_6274_1_ + p_6274_5_), (double)(p_6274_2_ + p_6274_6_), 0.0D, (double)((float)(p_6274_3_ + p_6274_5_) * var7), (double)((float)(p_6274_4_ + p_6274_6_) * var8));
      var9.func_983_a((double)(p_6274_1_ + p_6274_5_), (double)(p_6274_2_ + 0), 0.0D, (double)((float)(p_6274_3_ + p_6274_5_) * var7), (double)((float)(p_6274_4_ + 0) * var8));
      var9.func_983_a((double)(p_6274_1_ + 0), (double)(p_6274_2_ + 0), 0.0D, (double)((float)(p_6274_3_ + 0) * var7), (double)((float)(p_6274_4_ + 0) * var8));
      var9.func_982_a();
   }

   public static File func_6240_b() {
      if(field_6275_Z == null) {
         field_6275_Z = func_6264_a("minecraft");
      }

      return field_6275_Z;
   }

   public static File func_6264_a(String p_6264_0_) {
      String var1 = System.getProperty("user.home", ".");
      File var2;
      switch(EnumOSMappingHelper.field_1585_a[func_6267_r().ordinal()]) {
      case 1:
      case 2:
         var2 = new File(var1, '.' + p_6264_0_ + '/');
         break;
      case 3:
         String var3 = System.getenv("APPDATA");
         if(var3 != null) {
            var2 = new File(var3, "." + p_6264_0_ + '/');
         } else {
            var2 = new File(var1, '.' + p_6264_0_ + '/');
         }
         break;
      case 4:
         var2 = new File(var1, "Library/Application Support/" + p_6264_0_);
         break;
      default:
         var2 = new File(var1, p_6264_0_ + '/');
      }

      if(!var2.exists() && !var2.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + var2);
      } else {
         return var2;
      }
   }

   private static EnumOS2 func_6267_r() {
      String var0 = System.getProperty("os.name").toLowerCase();
      return var0.contains("win")?EnumOS2.windows:(var0.contains("mac")?EnumOS2.macos:(var0.contains("solaris")?EnumOS2.solaris:(var0.contains("sunos")?EnumOS2.solaris:(var0.contains("linux")?EnumOS2.linux:(var0.contains("unix")?EnumOS2.linux:EnumOS2.unknown)))));
   }

   public ISaveFormat func_22004_c() {
      return this.field_22008_V;
   }

   public void func_6272_a(GuiScreen p_6272_1_) {
      if(!(this.field_6313_p instanceof GuiErrorScreen)) {
         if(this.field_6313_p != null) {
            this.field_6313_p.func_6449_h();
         }

         if(p_6272_1_ instanceof GuiMainMenu) {
            this.field_25001_G.func_27175_b();
         }

         this.field_25001_G.func_27182_c();
         if(p_6272_1_ == null && this.field_6324_e == null) {
            p_6272_1_ = new GuiMainMenu();
         } else if(p_6272_1_ == null && this.field_6322_g.func_40114_aH() <= 0) {
            p_6272_1_ = new GuiGameOver();
         }

         if(p_6272_1_ instanceof GuiMainMenu) {
            this.field_6304_y.field_22276_A = false;
            this.field_6308_u.func_28097_b();
         }

         this.field_6313_p = (GuiScreen)p_6272_1_;
         if(p_6272_1_ != null) {
            this.func_6273_f();
            ScaledResolution var2 = new ScaledResolution(this.field_6304_y, this.field_6326_c, this.field_6325_d);
            int var3 = var2.func_903_a();
            int var4 = var2.func_902_b();
            ((GuiScreen)p_6272_1_).func_6447_a(this, var3, var4);
            this.field_6307_v = false;
         } else {
            this.func_6259_e();
         }

      }
   }

   private void func_6250_c(String p_6250_1_) {
      int var2 = GL11.glGetError();
      if(var2 != 0) {
         String var3 = GLU.gluErrorString(var2);
         System.out.println("########## GL ERROR ##########");
         System.out.println("@ " + p_6250_1_);
         System.out.println(var2 + ": " + var3);
      }

   }

   public void func_6266_c() {
      try {
         this.field_25001_G.func_27175_b();
         this.field_25001_G.func_27182_c();
         if(this.field_9241_z != null) {
            this.field_9241_z.func_6231_c();
         }

         try {
            if(this.field_6284_Q != null) {
               this.field_6284_Q.func_1208_b();
            }
         } catch (Exception var9) {
            ;
         }

         System.out.println("Stopping!");

         try {
            this.func_6261_a((World)null);
         } catch (Throwable var8) {
            ;
         }

         try {
            GLAllocation.func_1126_a();
         } catch (Throwable var7) {
            ;
         }

         this.field_6301_A.func_330_b();
         Mouse.destroy();
         Keyboard.destroy();
      } finally {
         Display.destroy();
         if(!this.field_28004_R) {
            System.exit(0);
         }

      }

      System.gc();
   }

   public void run() {
      this.field_6293_H = true;

      try {
         this.func_6271_a();
      } catch (Exception var11) {
         var11.printStackTrace();
         this.func_28003_b(new UnexpectedThrowable("Failed to start game", var11));
         return;
      }

      try {
         while(this.field_6293_H) {
            try {
               this.func_40001_x();
            } catch (MinecraftException var9) {
               this.field_6324_e = null;
               this.func_6261_a((World)null);
               this.func_6272_a(new GuiConflictWarning());
            } catch (OutOfMemoryError var10) {
               this.func_28002_e();
               this.func_6272_a(new GuiMemoryErrorScreen());
               System.gc();
            }
         }
      } catch (MinecraftError var12) {
         ;
      } catch (Throwable var13) {
         this.func_28002_e();
         var13.printStackTrace();
         this.func_28003_b(new UnexpectedThrowable("Unexpected error", var13));
      } finally {
         this.func_6266_c();
      }

   }

   private void func_40001_x() {
      if(this.field_9241_z != null && !this.field_9241_z.isActive()) {
         this.field_6293_H = false;
      } else {
         AxisAlignedBB.func_4149_a();
         Vec3D.func_1259_a();
         Profiler.func_40663_a("root");
         if(this.field_9244_k == null && Display.isCloseRequested()) {
            this.func_6244_d();
         }

         if(this.field_6316_m && this.field_6324_e != null) {
            float var1 = this.field_9237_P.field_1378_c;
            this.field_9237_P.func_904_a();
            this.field_9237_P.field_1378_c = var1;
         } else {
            this.field_9237_P.func_904_a();
         }

         long var6 = System.nanoTime();
         Profiler.func_40663_a("tick");

         for(int var3 = 0; var3 < this.field_9237_P.field_1379_b; ++var3) {
            ++this.field_6283_R;

            try {
               this.func_6246_i();
            } catch (MinecraftException var5) {
               this.field_6324_e = null;
               this.func_6261_a((World)null);
               this.func_6272_a(new GuiConflictWarning());
            }
         }

         Profiler.func_40662_b();
         long var7 = System.nanoTime() - var6;
         this.func_6250_c("Pre render");
         RenderBlocks.field_27406_a = this.field_6304_y.field_1576_i;
         Profiler.func_40663_a("sound");
         this.field_6301_A.func_338_a(this.field_6322_g, this.field_9237_P.field_1378_c);
         Profiler.func_40661_c("updatelights");
         if(this.field_6324_e != null) {
            this.field_6324_e.func_6465_g();
         }

         Profiler.func_40662_b();
         Profiler.func_40663_a("render");
         Profiler.func_40663_a("display");
         GL11.glEnable(3553);
         if(!Keyboard.isKeyDown(65)) {
            Display.update();
         }

         if(this.field_6322_g != null && this.field_6322_g.func_345_I()) {
            this.field_6304_y.field_1560_x = 0;
         }

         Profiler.func_40662_b();
         if(!this.field_6307_v) {
            Profiler.func_40663_a("gameMode");
            if(this.field_6327_b != null) {
               this.field_6327_b.func_6467_a(this.field_9237_P.field_1378_c);
            }

            Profiler.func_40661_c("gameRenderer");
            this.field_9243_r.func_4136_b(this.field_9237_P.field_1378_c);
            Profiler.func_40662_b();
         }

         GL11.glFlush();
         Profiler.func_40662_b();
         if(!Display.isActive() && this.field_185_a) {
            this.func_6270_h();
         }

         Profiler.func_40662_b();
         if(this.field_6304_y.field_22276_A && this.field_6304_y.field_50119_G) {
            if(!Profiler.field_40669_a) {
               Profiler.func_40660_a();
            }

            Profiler.field_40669_a = true;
            this.func_6238_a(var7);
         } else {
            Profiler.field_40669_a = false;
            this.field_6290_K = System.nanoTime();
         }

         this.field_25002_t.func_25080_a();
         Profiler.func_40663_a("root");
         Thread.yield();
         if(Keyboard.isKeyDown(65)) {
            Display.update();
         }

         this.func_6248_s();
         if(this.field_9244_k != null && !this.field_185_a && (this.field_9244_k.getWidth() != this.field_6326_c || this.field_9244_k.getHeight() != this.field_6325_d)) {
            this.field_6326_c = this.field_9244_k.getWidth();
            this.field_6325_d = this.field_9244_k.getHeight();
            if(this.field_6326_c <= 0) {
               this.field_6326_c = 1;
            }

            if(this.field_6325_d <= 0) {
               this.field_6325_d = 1;
            }

            this.func_6249_a(this.field_6326_c, this.field_6325_d);
         }

         this.func_6250_c("Post render");
         ++this.field_40005_O;

         for(this.field_6316_m = !this.func_6260_j() && this.field_6313_p != null && this.field_6313_p.func_6450_b(); System.currentTimeMillis() >= this.field_40004_N + 1000L; this.field_40005_O = 0) {
            this.field_6292_I = this.field_40005_O + " fps, " + WorldRenderer.field_1762_b + " chunk updates";
            WorldRenderer.field_1762_b = 0;
            this.field_40004_N += 1000L;
         }

         Profiler.func_40662_b();
      }
   }

   public void func_28002_e() {
      try {
         field_28006_b = new byte[0];
         this.field_6323_f.func_28137_f();
      } catch (Throwable var4) {
         ;
      }

      try {
         System.gc();
         AxisAlignedBB.func_28196_a();
         Vec3D.func_28215_a();
      } catch (Throwable var3) {
         ;
      }

      try {
         System.gc();
         this.func_6261_a((World)null);
      } catch (Throwable var2) {
         ;
      }

      System.gc();
   }

   private void func_6248_s() {
      if(Keyboard.isKeyDown(60)) {
         if(!this.field_6291_J) {
            this.field_6291_J = true;
            this.field_6308_u.func_552_a(ScreenShotHelper.func_4148_a(field_6275_Z, this.field_6326_c, this.field_6325_d));
         }
      } else {
         this.field_6291_J = false;
      }

   }

   private void func_40003_b(int p_40003_1_) {
      List var2 = Profiler.func_40664_b(this.field_40006_ak);
      if(var2 != null && var2.size() != 0) {
         ProfilerResult var3 = (ProfilerResult)var2.remove(0);
         if(p_40003_1_ == 0) {
            if(var3.field_40703_c.length() > 0) {
               int var4 = this.field_40006_ak.lastIndexOf(".");
               if(var4 >= 0) {
                  this.field_40006_ak = this.field_40006_ak.substring(0, var4);
               }
            }
         } else {
            --p_40003_1_;
            if(p_40003_1_ < var2.size() && !((ProfilerResult)var2.get(p_40003_1_)).field_40703_c.equals("unspecified")) {
               if(this.field_40006_ak.length() > 0) {
                  this.field_40006_ak = this.field_40006_ak + ".";
               }

               this.field_40006_ak = this.field_40006_ak + ((ProfilerResult)var2.get(p_40003_1_)).field_40703_c;
            }
         }

      }
   }

   private void func_6238_a(long p_6238_1_) {
      List var3 = Profiler.func_40664_b(this.field_40006_ak);
      ProfilerResult var4 = (ProfilerResult)var3.remove(0);
      long var5 = 16666666L;
      if(this.field_6290_K == -1L) {
         this.field_6290_K = System.nanoTime();
      }

      long var7 = System.nanoTime();
      field_9239_F[field_9238_G & field_9240_E.length - 1] = p_6238_1_;
      field_9240_E[field_9238_G++ & field_9240_E.length - 1] = var7 - this.field_6290_K;
      this.field_6290_K = var7;
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glEnable(2903);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, (double)this.field_6326_c, (double)this.field_6325_d, 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(3553);
      Tessellator var9 = Tessellator.field_1512_a;
      var9.func_992_a(7);
      int var10 = (int)(var5 / 200000L);
      var9.func_990_b(536870912);
      var9.func_991_a(0.0D, (double)(this.field_6325_d - var10), 0.0D);
      var9.func_991_a(0.0D, (double)this.field_6325_d, 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)this.field_6325_d, 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var10), 0.0D);
      var9.func_990_b(538968064);
      var9.func_991_a(0.0D, (double)(this.field_6325_d - var10 * 2), 0.0D);
      var9.func_991_a(0.0D, (double)(this.field_6325_d - var10), 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var10), 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var10 * 2), 0.0D);
      var9.func_982_a();
      long var11 = 0L;

      int var13;
      for(var13 = 0; var13 < field_9240_E.length; ++var13) {
         var11 += field_9240_E[var13];
      }

      var13 = (int)(var11 / 200000L / (long)field_9240_E.length);
      var9.func_992_a(7);
      var9.func_990_b(541065216);
      var9.func_991_a(0.0D, (double)(this.field_6325_d - var13), 0.0D);
      var9.func_991_a(0.0D, (double)this.field_6325_d, 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)this.field_6325_d, 0.0D);
      var9.func_991_a((double)field_9240_E.length, (double)(this.field_6325_d - var13), 0.0D);
      var9.func_982_a();
      var9.func_992_a(1);

      int var15;
      int var16;
      for(int var14 = 0; var14 < field_9240_E.length; ++var14) {
         var15 = (var14 - field_9238_G & field_9240_E.length - 1) * 255 / field_9240_E.length;
         var16 = var15 * var15 / 255;
         var16 = var16 * var16 / 255;
         int var17 = var16 * var16 / 255;
         var17 = var17 * var17 / 255;
         if(field_9240_E[var14] > var5) {
            var9.func_990_b(-16777216 + var16 * 65536);
         } else {
            var9.func_990_b(-16777216 + var16 * 256);
         }

         long var18 = field_9240_E[var14] / 200000L;
         long var20 = field_9239_F[var14] / 200000L;
         var9.func_991_a((double)((float)var14 + 0.5F), (double)((float)((long)this.field_6325_d - var18) + 0.5F), 0.0D);
         var9.func_991_a((double)((float)var14 + 0.5F), (double)((float)this.field_6325_d + 0.5F), 0.0D);
         var9.func_990_b(-16777216 + var16 * 65536 + var16 * 256 + var16 * 1);
         var9.func_991_a((double)((float)var14 + 0.5F), (double)((float)((long)this.field_6325_d - var18) + 0.5F), 0.0D);
         var9.func_991_a((double)((float)var14 + 0.5F), (double)((float)((long)this.field_6325_d - (var18 - var20)) + 0.5F), 0.0D);
      }

      var9.func_982_a();
      short var26 = 160;
      var15 = this.field_6326_c - var26 - 10;
      var16 = this.field_6325_d - var26 * 2;
      GL11.glEnable(3042);
      var9.func_977_b();
      var9.func_6513_a(0, 200);
      var9.func_991_a((double)((float)var15 - (float)var26 * 1.1F), (double)((float)var16 - (float)var26 * 0.6F - 16.0F), 0.0D);
      var9.func_991_a((double)((float)var15 - (float)var26 * 1.1F), (double)(var16 + var26 * 2), 0.0D);
      var9.func_991_a((double)((float)var15 + (float)var26 * 1.1F), (double)(var16 + var26 * 2), 0.0D);
      var9.func_991_a((double)((float)var15 + (float)var26 * 1.1F), (double)((float)var16 - (float)var26 * 0.6F - 16.0F), 0.0D);
      var9.func_982_a();
      GL11.glDisable(3042);
      double var27 = 0.0D;

      int var21;
      for(int var19 = 0; var19 < var3.size(); ++var19) {
         ProfilerResult var29 = (ProfilerResult)var3.get(var19);
         var21 = MathHelper.func_1108_b(var29.field_40704_a / 4.0D) + 1;
         var9.func_992_a(6);
         var9.func_990_b(var29.func_40700_a());
         var9.func_991_a((double)var15, (double)var16, 0.0D);

         int var22;
         float var23;
         float var24;
         float var25;
         for(var22 = var21; var22 >= 0; --var22) {
            var23 = (float)((var27 + var29.field_40704_a * (double)var22 / (double)var21) * 3.1415927410125732D * 2.0D / 100.0D);
            var24 = MathHelper.func_1106_a(var23) * (float)var26;
            var25 = MathHelper.func_1114_b(var23) * (float)var26 * 0.5F;
            var9.func_991_a((double)((float)var15 + var24), (double)((float)var16 - var25), 0.0D);
         }

         var9.func_982_a();
         var9.func_992_a(5);
         var9.func_990_b((var29.func_40700_a() & 16711422) >> 1);

         for(var22 = var21; var22 >= 0; --var22) {
            var23 = (float)((var27 + var29.field_40704_a * (double)var22 / (double)var21) * 3.1415927410125732D * 2.0D / 100.0D);
            var24 = MathHelper.func_1106_a(var23) * (float)var26;
            var25 = MathHelper.func_1114_b(var23) * (float)var26 * 0.5F;
            var9.func_991_a((double)((float)var15 + var24), (double)((float)var16 - var25), 0.0D);
            var9.func_991_a((double)((float)var15 + var24), (double)((float)var16 - var25 + 10.0F), 0.0D);
         }

         var9.func_982_a();
         var27 += var29.field_40704_a;
      }

      DecimalFormat var28 = new DecimalFormat("##0.00");
      GL11.glEnable(3553);
      String var30 = "";
      if(!var4.field_40703_c.equals("unspecified")) {
         var30 = var30 + "[0] ";
      }

      if(var4.field_40703_c.length() == 0) {
         var30 = var30 + "ROOT ";
      } else {
         var30 = var30 + var4.field_40703_c + " ";
      }

      var21 = 16777215;
      this.field_6314_o.func_50103_a(var30, var15 - var26, var16 - var26 / 2 - 16, var21);
      this.field_6314_o.func_50103_a(var30 = var28.format(var4.field_40702_b) + "%", var15 + var26 - this.field_6314_o.func_871_a(var30), var16 - var26 / 2 - 16, var21);

      for(int var32 = 0; var32 < var3.size(); ++var32) {
         ProfilerResult var31 = (ProfilerResult)var3.get(var32);
         String var33 = "";
         if(!var31.field_40703_c.equals("unspecified")) {
            var33 = var33 + "[" + (var32 + 1) + "] ";
         } else {
            var33 = var33 + "[?] ";
         }

         var33 = var33 + var31.field_40703_c;
         this.field_6314_o.func_50103_a(var33, var15 - var26, var16 + var26 / 2 + var32 * 8 + 20, var31.func_40700_a());
         this.field_6314_o.func_50103_a(var33 = var28.format(var31.field_40704_a) + "%", var15 + var26 - 50 - this.field_6314_o.func_871_a(var33), var16 + var26 / 2 + var32 * 8 + 20, var31.func_40700_a());
         this.field_6314_o.func_50103_a(var33 = var28.format(var31.field_40702_b) + "%", var15 + var26 - this.field_6314_o.func_871_a(var33), var16 + var26 / 2 + var32 * 8 + 20, var31.func_40700_a());
      }

   }

   public void func_6244_d() {
      this.field_6293_H = false;
   }

   public void func_6259_e() {
      if(Display.isActive()) {
         if(!this.field_6289_L) {
            this.field_6289_L = true;
            this.field_6299_B.func_774_a();
            this.func_6272_a((GuiScreen)null);
            this.field_6282_S = 10000;
         }
      }
   }

   public void func_6273_f() {
      if(this.field_6289_L) {
         KeyBinding.func_35959_a();
         this.field_6289_L = false;
         this.field_6299_B.func_773_b();
      }
   }

   public void func_6252_g() {
      if(this.field_6313_p == null) {
         this.func_6272_a(new GuiIngameMenu());
      }
   }

   private void func_6254_a(int p_6254_1_, boolean p_6254_2_) {
      if(!p_6254_2_) {
         this.field_6282_S = 0;
      }

      if(p_6254_1_ != 0 || this.field_6282_S <= 0) {
         if(p_6254_2_ && this.field_6305_x != null && this.field_6305_x.field_1167_a == EnumMovingObjectType.TILE && p_6254_1_ == 0) {
            int var3 = this.field_6305_x.field_1166_b;
            int var4 = this.field_6305_x.field_1172_c;
            int var5 = this.field_6305_x.field_1171_d;
            this.field_6327_b.func_6470_c(var3, var4, var5, this.field_6305_x.field_1170_e);
            if(this.field_6322_g.func_35190_e(var3, var4, var5)) {
               this.field_6321_h.func_1191_a(var3, var4, var5, this.field_6305_x.field_1170_e);
               this.field_6322_g.func_457_w();
            }
         } else {
            this.field_6327_b.func_6468_a();
         }

      }
   }

   private void func_6243_a(int p_6243_1_) {
      if(p_6243_1_ != 0 || this.field_6282_S <= 0) {
         if(p_6243_1_ == 0) {
            this.field_6322_g.func_457_w();
         }

         if(p_6243_1_ == 1) {
            this.field_35001_ab = 4;
         }

         boolean var2 = true;
         ItemStack var3 = this.field_6322_g.field_778_b.func_494_a();
         if(this.field_6305_x == null) {
            if(p_6243_1_ == 0 && this.field_6327_b.func_35641_g()) {
               this.field_6282_S = 10;
            }
         } else if(this.field_6305_x.field_1167_a == EnumMovingObjectType.ENTITY) {
            if(p_6243_1_ == 0) {
               this.field_6327_b.func_6472_b(this.field_6322_g, this.field_6305_x.field_1168_g);
            }

            if(p_6243_1_ == 1) {
               this.field_6327_b.func_6475_a(this.field_6322_g, this.field_6305_x.field_1168_g);
            }
         } else if(this.field_6305_x.field_1167_a == EnumMovingObjectType.TILE) {
            int var4 = this.field_6305_x.field_1166_b;
            int var5 = this.field_6305_x.field_1172_c;
            int var6 = this.field_6305_x.field_1171_d;
            int var7 = this.field_6305_x.field_1170_e;
            if(p_6243_1_ == 0) {
               this.field_6327_b.func_719_a(var4, var5, var6, this.field_6305_x.field_1170_e);
            } else {
               int var9 = var3 != null?var3.field_1615_a:0;
               if(this.field_6327_b.func_722_a(this.field_6322_g, this.field_6324_e, var3, var4, var5, var6, var7)) {
                  var2 = false;
                  this.field_6322_g.func_457_w();
               }

               if(var3 == null) {
                  return;
               }

               if(var3.field_1615_a == 0) {
                  this.field_6322_g.field_778_b.field_843_a[this.field_6322_g.field_778_b.field_847_d] = null;
               } else if(var3.field_1615_a != var9 || this.field_6327_b.func_35640_h()) {
                  this.field_9243_r.field_1395_a.func_9449_b();
               }
            }
         }

         if(var2 && p_6243_1_ == 1) {
            ItemStack var10 = this.field_6322_g.field_778_b.func_494_a();
            if(var10 != null && this.field_6327_b.func_6471_a(this.field_6322_g, this.field_6324_e, var10)) {
               this.field_9243_r.field_1395_a.func_9450_c();
            }
         }

      }
   }

   public void func_6270_h() {
      try {
         this.field_185_a = !this.field_185_a;
         if(this.field_185_a) {
            Display.setDisplayMode(Display.getDesktopDisplayMode());
            this.field_6326_c = Display.getDisplayMode().getWidth();
            this.field_6325_d = Display.getDisplayMode().getHeight();
            if(this.field_6326_c <= 0) {
               this.field_6326_c = 1;
            }

            if(this.field_6325_d <= 0) {
               this.field_6325_d = 1;
            }
         } else {
            if(this.field_9244_k != null) {
               this.field_6326_c = this.field_9244_k.getWidth();
               this.field_6325_d = this.field_9244_k.getHeight();
            } else {
               this.field_6326_c = this.field_9236_T;
               this.field_6325_d = this.field_9235_U;
            }

            if(this.field_6326_c <= 0) {
               this.field_6326_c = 1;
            }

            if(this.field_6325_d <= 0) {
               this.field_6325_d = 1;
            }
         }

         if(this.field_6313_p != null) {
            this.func_6249_a(this.field_6326_c, this.field_6325_d);
         }

         Display.setFullscreen(this.field_185_a);
         Display.update();
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   private void func_6249_a(int p_6249_1_, int p_6249_2_) {
      if(p_6249_1_ <= 0) {
         p_6249_1_ = 1;
      }

      if(p_6249_2_ <= 0) {
         p_6249_2_ = 1;
      }

      this.field_6326_c = p_6249_1_;
      this.field_6325_d = p_6249_2_;
      if(this.field_6313_p != null) {
         ScaledResolution var3 = new ScaledResolution(this.field_6304_y, p_6249_1_, p_6249_2_);
         int var4 = var3.func_903_a();
         int var5 = var3.func_902_b();
         this.field_6313_p.func_6447_a(this, var4, var5);
      }

   }

   private void func_28001_B() {
      (new ThreadCheckHasPaid(this)).start();
   }

   public void func_6246_i() {
      if(this.field_35001_ab > 0) {
         --this.field_35001_ab;
      }

      if(this.field_6283_R == 6000) {
         this.func_28001_B();
      }

      Profiler.func_40663_a("stats");
      this.field_25001_G.func_27178_d();
      Profiler.func_40661_c("gui");
      if(!this.field_6316_m) {
         this.field_6308_u.func_555_a();
      }

      Profiler.func_40661_c("pick");
      this.field_9243_r.func_910_a(1.0F);
      Profiler.func_40661_c("centerChunkSource");
      int var3;
      if(this.field_6322_g != null) {
         IChunkProvider var1 = this.field_6324_e.func_21118_q();
         if(var1 instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var2 = (ChunkProviderLoadOrGenerate)var1;
            var3 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_611_ak)) >> 4;
            int var4 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_609_am)) >> 4;
            var2.func_21110_c(var3, var4);
         }
      }

      Profiler.func_40661_c("gameMode");
      if(!this.field_6316_m && this.field_6324_e != null) {
         this.field_6327_b.func_6474_c();
      }

      GL11.glBindTexture(3553, this.field_6315_n.func_1070_a("/terrain.png"));
      Profiler.func_40661_c("textures");
      if(!this.field_6316_m) {
         this.field_6315_n.func_1067_a();
      }

      if(this.field_6313_p == null && this.field_6322_g != null) {
         if(this.field_6322_g.func_40114_aH() <= 0) {
            this.func_6272_a((GuiScreen)null);
         } else if(this.field_6322_g.func_22051_K() && this.field_6324_e != null && this.field_6324_e.field_1026_y) {
            this.func_6272_a(new GuiSleepMP());
         }
      } else if(this.field_6313_p != null && this.field_6313_p instanceof GuiSleepMP && !this.field_6322_g.func_22051_K()) {
         this.func_6272_a((GuiScreen)null);
      }

      if(this.field_6313_p != null) {
         this.field_6282_S = 10000;
      }

      if(this.field_6313_p != null) {
         this.field_6313_p.func_564_d();
         if(this.field_6313_p != null) {
            this.field_6313_p.field_25091_h.func_25088_a();
            this.field_6313_p.func_570_g();
         }
      }

      if(this.field_6313_p == null || this.field_6313_p.field_948_f) {
         Profiler.func_40661_c("mouse");

         while(Mouse.next()) {
            KeyBinding.func_35963_a(Mouse.getEventButton() - 100, Mouse.getEventButtonState());
            if(Mouse.getEventButtonState()) {
               KeyBinding.func_35960_a(Mouse.getEventButton() - 100);
            }

            long var5 = System.currentTimeMillis() - this.field_6287_N;
            if(var5 <= 200L) {
               var3 = Mouse.getEventDWheel();
               if(var3 != 0) {
                  this.field_6322_g.field_778_b.func_498_a(var3);
                  if(this.field_6304_y.field_22275_C) {
                     if(var3 > 0) {
                        var3 = 1;
                     }

                     if(var3 < 0) {
                        var3 = -1;
                     }

                     this.field_6304_y.field_22272_F += (float)var3 * 0.25F;
                  }
               }

               if(this.field_6313_p == null) {
                  if(!this.field_6289_L && Mouse.getEventButtonState()) {
                     this.func_6259_e();
                  }
               } else if(this.field_6313_p != null) {
                  this.field_6313_p.func_566_e();
               }
            }
         }

         if(this.field_6282_S > 0) {
            --this.field_6282_S;
         }

         Profiler.func_40661_c("keyboard");

         while(Keyboard.next()) {
            KeyBinding.func_35963_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
            if(Keyboard.getEventKeyState()) {
               KeyBinding.func_35960_a(Keyboard.getEventKey());
            }

            if(Keyboard.getEventKeyState()) {
               if(Keyboard.getEventKey() == 87) {
                  this.func_6270_h();
               } else {
                  if(this.field_6313_p != null) {
                     this.field_6313_p.func_569_f();
                  } else {
                     if(Keyboard.getEventKey() == 1) {
                        this.func_6252_g();
                     }

                     if(Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                        this.func_6242_u();
                     }

                     if(Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
                        this.field_6315_n.func_1065_b();
                     }

                     if(Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61)) {
                        boolean var6 = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                        this.field_6304_y.func_1045_b(EnumOptions.RENDER_DISTANCE, var6?-1:1);
                     }

                     if(Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61)) {
                        this.field_6323_f.func_958_a();
                     }

                     if(Keyboard.getEventKey() == 59) {
                        this.field_6304_y.field_22277_y = !this.field_6304_y.field_22277_y;
                     }

                     if(Keyboard.getEventKey() == 61) {
                        this.field_6304_y.field_22276_A = !this.field_6304_y.field_22276_A;
                        this.field_6304_y.field_50119_G = !GuiScreen.func_50049_m();
                     }

                     if(Keyboard.getEventKey() == 63) {
                        ++this.field_6304_y.field_1560_x;
                        if(this.field_6304_y.field_1560_x > 2) {
                           this.field_6304_y.field_1560_x = 0;
                        }
                     }

                     if(Keyboard.getEventKey() == 66) {
                        this.field_6304_y.field_22274_D = !this.field_6304_y.field_22274_D;
                     }
                  }

                  int var7;
                  for(var7 = 0; var7 < 9; ++var7) {
                     if(Keyboard.getEventKey() == 2 + var7) {
                        this.field_6322_g.field_778_b.field_847_d = var7;
                     }
                  }

                  if(this.field_6304_y.field_22276_A && this.field_6304_y.field_50119_G) {
                     if(Keyboard.getEventKey() == 11) {
                        this.func_40003_b(0);
                     }

                     for(var7 = 0; var7 < 9; ++var7) {
                        if(Keyboard.getEventKey() == 2 + var7) {
                           this.func_40003_b(var7 + 1);
                        }
                     }
                  }
               }
            }
         }

         while(this.field_6304_y.field_1570_o.func_35962_c()) {
            this.func_6272_a(new GuiInventory(this.field_6322_g));
         }

         while(this.field_6304_y.field_6523_q.func_35962_c()) {
            this.field_6322_g.func_48152_as();
         }

         while(this.func_6260_j() && this.field_6304_y.field_6521_r.func_35962_c()) {
            this.func_6272_a(new GuiChat());
         }

         if(this.func_6260_j() && this.field_6313_p == null && (Keyboard.isKeyDown(53) || Keyboard.isKeyDown(181))) {
            this.func_6272_a(new GuiChat("/"));
         }

         if(this.field_6322_g.func_35196_Z()) {
            if(!this.field_6304_y.field_35381_w.field_35965_e) {
               this.field_6327_b.func_35638_c(this.field_6322_g);
            }

            label320:
            while(true) {
               if(!this.field_6304_y.field_35382_v.func_35962_c()) {
                  while(this.field_6304_y.field_35381_w.func_35962_c()) {
                     ;
                  }

                  while(true) {
                     if(this.field_6304_y.field_35383_y.func_35962_c()) {
                        continue;
                     }
                     break label320;
                  }
               }
            }
         } else {
            while(this.field_6304_y.field_35382_v.func_35962_c()) {
               this.func_6243_a(0);
            }

            while(this.field_6304_y.field_35381_w.func_35962_c()) {
               this.func_6243_a(1);
            }

            while(this.field_6304_y.field_35383_y.func_35962_c()) {
               this.func_6265_t();
            }
         }

         if(this.field_6304_y.field_35381_w.field_35965_e && this.field_35001_ab == 0 && !this.field_6322_g.func_35196_Z()) {
            this.func_6243_a(1);
         }

         this.func_6254_a(0, this.field_6313_p == null && this.field_6304_y.field_35382_v.field_35965_e && this.field_6289_L);
      }

      if(this.field_6324_e != null) {
         if(this.field_6322_g != null) {
            ++this.field_6300_ab;
            if(this.field_6300_ab == 30) {
               this.field_6300_ab = 0;
               this.field_6324_e.func_705_f(this.field_6322_g);
            }
         }

         if(this.field_6324_e.func_22144_v().func_40724_s()) {
            this.field_6324_e.field_1039_l = 3;
         } else {
            this.field_6324_e.field_1039_l = this.field_6304_y.field_1561_w;
         }

         if(this.field_6324_e.field_1026_y) {
            this.field_6324_e.field_1039_l = 1;
         }

         Profiler.func_40661_c("gameRenderer");
         if(!this.field_6316_m) {
            this.field_9243_r.func_911_a();
         }

         Profiler.func_40661_c("levelRenderer");
         if(!this.field_6316_m) {
            this.field_6323_f.func_945_d();
         }

         Profiler.func_40661_c("level");
         if(!this.field_6316_m) {
            if(this.field_6324_e.field_27172_i > 0) {
               --this.field_6324_e.field_27172_i;
            }

            this.field_6324_e.func_633_c();
         }

         if(!this.field_6316_m || this.func_6260_j()) {
            this.field_6324_e.func_21114_a(this.field_6324_e.field_1039_l > 0, true);
            this.field_6324_e.func_649_g();
         }

         Profiler.func_40661_c("animateTick");
         if(!this.field_6316_m && this.field_6324_e != null) {
            this.field_6324_e.func_677_m(MathHelper.func_1108_b(this.field_6322_g.field_611_ak), MathHelper.func_1108_b(this.field_6322_g.field_610_al), MathHelper.func_1108_b(this.field_6322_g.field_609_am));
         }

         Profiler.func_40661_c("particles");
         if(!this.field_6316_m) {
            this.field_6321_h.func_1193_a();
         }
      }

      Profiler.func_40662_b();
      this.field_6287_N = System.currentTimeMillis();
   }

   private void func_6242_u() {
      System.out.println("FORCING RELOAD!");
      this.field_6301_A = new SoundManager();
      this.field_6301_A.func_340_a(this.field_6304_y);
      this.field_6284_Q.func_1210_a();
   }

   public boolean func_6260_j() {
      return this.field_6324_e != null && this.field_6324_e.field_1026_y;
   }

   public void func_6247_b(String p_6247_1_, String p_6247_2_, WorldSettings p_6247_3_) {
      this.func_6261_a((World)null);
      System.gc();
      if(this.field_22008_V.func_22175_a(p_6247_1_)) {
         this.func_22002_b(p_6247_1_, p_6247_2_);
      } else {
         if(this.field_6312_q != null) {
            this.field_6312_q.func_596_a(StatCollector.func_25200_a("menu.switchingLevel"));
            this.field_6312_q.func_595_d("");
         }

         ISaveHandler var4 = this.field_22008_V.func_22174_a(p_6247_1_, false);
         World var5 = null;
         var5 = new World(var4, p_6247_2_, p_6247_3_);
         if(var5.field_1033_r) {
            this.field_25001_G.func_25100_a(StatList.field_25183_f, 1);
            this.field_25001_G.func_25100_a(StatList.field_25184_e, 1);
            this.func_6263_a(var5, StatCollector.func_25200_a("menu.generatingLevel"));
         } else {
            this.field_25001_G.func_25100_a(StatList.field_25182_g, 1);
            this.field_25001_G.func_25100_a(StatList.field_25184_e, 1);
            this.func_6263_a(var5, StatCollector.func_25200_a("menu.loadingLevel"));
         }
      }

   }

   public void func_6237_k(int p_6237_1_) {
      int var2 = this.field_6322_g.field_4129_m;
      this.field_6322_g.field_4129_m = p_6237_1_;
      this.field_6324_e.func_607_d(this.field_6322_g);
      this.field_6322_g.field_646_aA = false;
      double var3 = this.field_6322_g.field_611_ak;
      double var5 = this.field_6322_g.field_609_am;
      double var7 = 1.0D;
      if(var2 > -1 && this.field_6322_g.field_4129_m == -1) {
         var7 = 0.125D;
      } else if(var2 == -1 && this.field_6322_g.field_4129_m > -1) {
         var7 = 8.0D;
      }

      var3 *= var7;
      var5 *= var7;
      World var9;
      if(this.field_6322_g.field_4129_m == -1) {
         this.field_6322_g.func_365_c(var3, this.field_6322_g.field_610_al, var5, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
         if(this.field_6322_g.func_354_B()) {
            this.field_6324_e.func_4084_a(this.field_6322_g, false);
         }

         var9 = null;
         var9 = new World(this.field_6324_e, WorldProvider.func_4101_a(this.field_6322_g.field_4129_m));
         this.func_6256_a(var9, "Entering the Nether", this.field_6322_g);
      } else if(this.field_6322_g.field_4129_m == 0) {
         if(this.field_6322_g.func_354_B()) {
            this.field_6322_g.func_365_c(var3, this.field_6322_g.field_610_al, var5, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
            this.field_6324_e.func_4084_a(this.field_6322_g, false);
         }

         var9 = null;
         var9 = new World(this.field_6324_e, WorldProvider.func_4101_a(this.field_6322_g.field_4129_m));
         if(var2 == -1) {
            this.func_6256_a(var9, "Leaving the Nether", this.field_6322_g);
         } else {
            this.func_6256_a(var9, "Leaving the End", this.field_6322_g);
         }
      } else {
         var9 = null;
         var9 = new World(this.field_6324_e, WorldProvider.func_4101_a(this.field_6322_g.field_4129_m));
         ChunkCoordinates var10 = var9.func_40472_j();
         var3 = (double)var10.field_22395_a;
         this.field_6322_g.field_610_al = (double)var10.field_22394_b;
         var5 = (double)var10.field_22396_c;
         this.field_6322_g.func_365_c(var3, this.field_6322_g.field_610_al, var5, 90.0F, 0.0F);
         if(this.field_6322_g.func_354_B()) {
            var9.func_4084_a(this.field_6322_g, false);
         }

         this.func_6256_a(var9, "Entering the End", this.field_6322_g);
      }

      this.field_6322_g.field_615_ag = this.field_6324_e;
      System.out.println("Teleported to " + this.field_6324_e.field_4209_q.field_4218_e);
      if(this.field_6322_g.func_354_B() && var2 < 1) {
         this.field_6322_g.func_365_c(var3, this.field_6322_g.field_610_al, var5, this.field_6322_g.field_605_aq, this.field_6322_g.field_604_ar);
         this.field_6324_e.func_4084_a(this.field_6322_g, false);
         (new Teleporter()).func_4107_a(this.field_6324_e, this.field_6322_g);
      }

   }

   public void func_40002_b(String p_40002_1_) {
      this.field_6324_e = null;
      this.func_6263_a((World)null, p_40002_1_);
   }

   public void func_6261_a(World p_6261_1_) {
      this.func_6263_a(p_6261_1_, "");
   }

   public void func_6263_a(World p_6263_1_, String p_6263_2_) {
      this.func_6256_a(p_6263_1_, p_6263_2_, (EntityPlayer)null);
   }

   public void func_6256_a(World p_6256_1_, String p_6256_2_, EntityPlayer p_6256_3_) {
      this.field_25001_G.func_27175_b();
      this.field_25001_G.func_27182_c();
      this.field_22009_h = null;
      if(this.field_6312_q != null) {
         this.field_6312_q.func_596_a(p_6256_2_);
         this.field_6312_q.func_595_d("");
      }

      this.field_6301_A.func_331_a((String)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      if(this.field_6324_e != null) {
         this.field_6324_e.func_651_a(this.field_6312_q);
      }

      this.field_6324_e = p_6256_1_;
      if(p_6256_1_ != null) {
         if(this.field_6327_b != null) {
            this.field_6327_b.func_717_a(p_6256_1_);
         }

         if(!this.func_6260_j()) {
            if(p_6256_3_ == null) {
               this.field_6322_g = (EntityPlayerSP)p_6256_1_.func_4085_a(EntityPlayerSP.class);
            }
         } else if(this.field_6322_g != null) {
            this.field_6322_g.func_374_q();
            if(p_6256_1_ != null) {
               p_6256_1_.func_674_a(this.field_6322_g);
            }
         }

         if(!p_6256_1_.field_1026_y) {
            this.func_6255_d(p_6256_2_);
         }

         if(this.field_6322_g == null) {
            this.field_6322_g = (EntityPlayerSP)this.field_6327_b.func_4087_b(p_6256_1_);
            this.field_6322_g.func_374_q();
            this.field_6327_b.func_6476_a(this.field_6322_g);
         }

         this.field_6322_g.field_787_a = new MovementInputFromOptions(this.field_6304_y);
         if(this.field_6323_f != null) {
            this.field_6323_f.func_946_a(p_6256_1_);
         }

         if(this.field_6321_h != null) {
            this.field_6321_h.func_1188_a(p_6256_1_);
         }

         if(p_6256_3_ != null) {
            p_6256_1_.func_6464_c();
         }

         IChunkProvider var4 = p_6256_1_.func_21118_q();
         if(var4 instanceof ChunkProviderLoadOrGenerate) {
            ChunkProviderLoadOrGenerate var5 = (ChunkProviderLoadOrGenerate)var4;
            int var6 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_611_ak)) >> 4;
            int var7 = MathHelper.func_1110_d((float)((int)this.field_6322_g.field_609_am)) >> 4;
            var5.func_21110_c(var6, var7);
         }

         p_6256_1_.func_608_a(this.field_6322_g);
         this.field_6327_b.func_6473_b(this.field_6322_g);
         if(p_6256_1_.field_1033_r) {
            p_6256_1_.func_651_a(this.field_6312_q);
         }

         this.field_22009_h = this.field_6322_g;
      } else {
         this.field_22008_V.func_22177_c();
         this.field_6322_g = null;
      }

      System.gc();
      this.field_6287_N = 0L;
   }

   private void func_22002_b(String p_22002_1_, String p_22002_2_) {
      this.field_6312_q.func_596_a("Converting World to " + this.field_22008_V.func_22178_a());
      this.field_6312_q.func_595_d("This may take a while :)");
      this.field_22008_V.func_22171_a(p_22002_1_, this.field_6312_q);
      this.func_6247_b(p_22002_1_, p_22002_2_, new WorldSettings(0L, 0, true, false, WorldType.field_48635_b));
   }

   private void func_6255_d(String p_6255_1_) {
      if(this.field_6312_q != null) {
         this.field_6312_q.func_596_a(p_6255_1_);
         this.field_6312_q.func_595_d(StatCollector.func_25200_a("menu.generatingTerrain"));
      }

      short var2 = 128;
      if(this.field_6327_b.func_35643_e()) {
         var2 = 64;
      }

      int var3 = 0;
      int var4 = var2 * 2 / 16 + 1;
      var4 *= var4;
      IChunkProvider var5 = this.field_6324_e.func_21118_q();
      ChunkCoordinates var6 = this.field_6324_e.func_22137_s();
      if(this.field_6322_g != null) {
         var6.field_22395_a = (int)this.field_6322_g.field_611_ak;
         var6.field_22396_c = (int)this.field_6322_g.field_609_am;
      }

      if(var5 instanceof ChunkProviderLoadOrGenerate) {
         ChunkProviderLoadOrGenerate var7 = (ChunkProviderLoadOrGenerate)var5;
         var7.func_21110_c(var6.field_22395_a >> 4, var6.field_22396_c >> 4);
      }

      for(int var10 = -var2; var10 <= var2; var10 += 16) {
         for(int var8 = -var2; var8 <= var2; var8 += 16) {
            if(this.field_6312_q != null) {
               this.field_6312_q.func_593_a(var3++ * 100 / var4);
            }

            this.field_6324_e.func_600_a(var6.field_22395_a + var10, 64, var6.field_22396_c + var8);
            if(!this.field_6327_b.func_35643_e()) {
               while(true) {
                  if(this.field_6324_e.func_6465_g()) {
                     continue;
                  }
               }
            }
         }
      }

      if(!this.field_6327_b.func_35643_e()) {
         if(this.field_6312_q != null) {
            this.field_6312_q.func_595_d(StatCollector.func_25200_a("menu.simulating"));
         }

         boolean var9 = true;
         this.field_6324_e.func_656_j();
      }

   }

   public void func_6268_a(String p_6268_1_, File p_6268_2_) {
      int var3 = p_6268_1_.indexOf("/");
      String var4 = p_6268_1_.substring(0, var3);
      p_6268_1_ = p_6268_1_.substring(var3 + 1);
      if(var4.equalsIgnoreCase("sound")) {
         this.field_6301_A.func_6372_a(p_6268_1_, p_6268_2_);
      } else if(var4.equalsIgnoreCase("newsound")) {
         this.field_6301_A.func_6372_a(p_6268_1_, p_6268_2_);
      } else if(var4.equalsIgnoreCase("streaming")) {
         this.field_6301_A.func_6373_b(p_6268_1_, p_6268_2_);
      } else if(var4.equalsIgnoreCase("music")) {
         this.field_6301_A.func_6374_c(p_6268_1_, p_6268_2_);
      } else if(var4.equalsIgnoreCase("newmusic")) {
         this.field_6301_A.func_6374_c(p_6268_1_, p_6268_2_);
      }

   }

   public String func_6241_m() {
      return this.field_6323_f.func_953_b();
   }

   public String func_6262_n() {
      return this.field_6323_f.func_957_c();
   }

   public String func_21002_o() {
      return this.field_6324_e.func_21119_g();
   }

   public String func_6245_o() {
      return "P: " + this.field_6321_h.func_1190_b() + ". T: " + this.field_6324_e.func_687_d();
   }

   public void func_6239_p(boolean p_6239_1_, int p_6239_2_, boolean p_6239_3_) {
      if(!this.field_6324_e.field_1026_y && !this.field_6324_e.field_4209_q.func_6477_d()) {
         this.func_6237_k(0);
      }

      ChunkCoordinates var4 = null;
      ChunkCoordinates var5 = null;
      boolean var6 = true;
      if(this.field_6322_g != null && !p_6239_1_) {
         var4 = this.field_6322_g.func_25059_P();
         if(var4 != null) {
            var5 = EntityPlayer.func_25060_a(this.field_6324_e, var4);
            if(var5 == null) {
               this.field_6322_g.func_22055_b("tile.bed.notValid");
            }
         }
      }

      if(var5 == null) {
         var5 = this.field_6324_e.func_22137_s();
         var6 = false;
      }

      IChunkProvider var7 = this.field_6324_e.func_21118_q();
      if(var7 instanceof ChunkProviderLoadOrGenerate) {
         ChunkProviderLoadOrGenerate var8 = (ChunkProviderLoadOrGenerate)var7;
         var8.func_21110_c(var5.field_22395_a >> 4, var5.field_22396_c >> 4);
      }

      this.field_6324_e.func_4076_b();
      this.field_6324_e.func_9424_o();
      int var10 = 0;
      if(this.field_6322_g != null) {
         var10 = this.field_6322_g.field_620_ab;
         this.field_6324_e.func_607_d(this.field_6322_g);
      }

      EntityPlayerSP var9 = this.field_6322_g;
      this.field_22009_h = null;
      this.field_6322_g = (EntityPlayerSP)this.field_6327_b.func_4087_b(this.field_6324_e);
      if(p_6239_3_) {
         this.field_6322_g.func_41014_d(var9);
      }

      this.field_6322_g.field_4129_m = p_6239_2_;
      this.field_22009_h = this.field_6322_g;
      this.field_6322_g.func_374_q();
      if(var6) {
         this.field_6322_g.func_25061_a(var4);
         this.field_6322_g.func_365_c((double)((float)var5.field_22395_a + 0.5F), (double)((float)var5.field_22394_b + 0.1F), (double)((float)var5.field_22396_c + 0.5F), 0.0F, 0.0F);
      }

      this.field_6327_b.func_6476_a(this.field_6322_g);
      this.field_6324_e.func_608_a(this.field_6322_g);
      this.field_6322_g.field_787_a = new MovementInputFromOptions(this.field_6304_y);
      this.field_6322_g.field_620_ab = var10;
      this.field_6322_g.func_6420_o();
      this.field_6327_b.func_6473_b(this.field_6322_g);
      this.func_6255_d(StatCollector.func_25200_a("menu.respawning"));
      if(this.field_6313_p instanceof GuiGameOver) {
         this.func_6272_a((GuiScreen)null);
      }

   }

   public static void func_6269_a(String p_6269_0_, String p_6269_1_) {
      func_6253_a(p_6269_0_, p_6269_1_, (String)null);
   }

   public static void func_6253_a(String p_6253_0_, String p_6253_1_, String p_6253_2_) {
      boolean var3 = false;
      Frame var5 = new Frame("Minecraft");
      Canvas var6 = new Canvas();
      var5.setLayout(new BorderLayout());
      var5.add(var6, "Center");
      var6.setPreferredSize(new Dimension(854, 480));
      var5.pack();
      var5.setLocationRelativeTo((Component)null);
      MinecraftImpl var7 = new MinecraftImpl(var5, var6, (MinecraftApplet)null, 854, 480, var3, var5);
      Thread var8 = new Thread(var7, "Minecraft main thread");
      var8.setPriority(10);
      var7.field_6319_j = "www.minecraft.net";
      if(p_6253_0_ != null && p_6253_1_ != null) {
         var7.field_6320_i = new Session(p_6253_0_, p_6253_1_);
      } else {
         var7.field_6320_i = new Session("Player" + System.currentTimeMillis() % 1000L, "");
      }

      if(p_6253_2_ != null) {
         String[] var9 = p_6253_2_.split(":");
         var7.func_6258_a(var9[0], Integer.parseInt(var9[1]));
      }

      var5.setVisible(true);
      var5.addWindowListener(new GameWindowListener(var7, var8));
      var8.start();
   }

   public NetClientHandler func_20001_q() {
      return this.field_6322_g instanceof EntityClientPlayerMP?((EntityClientPlayerMP)this.field_6322_g).field_797_bg:null;
   }

   public static void main(String[] p_main_0_) {
      String var1 = null;
      String var2 = null;
      var1 = "Player" + System.currentTimeMillis() % 1000L;
      if(p_main_0_.length > 0) {
         var1 = p_main_0_[0];
      }

      var2 = "-";
      if(p_main_0_.length > 1) {
         var2 = p_main_0_[1];
      }

      func_6269_a(var1, var2);
   }

   public static boolean func_22006_t() {
      return field_21900_a == null || !field_21900_a.field_6304_y.field_22277_y;
   }

   public static boolean func_22001_u() {
      return field_21900_a != null && field_21900_a.field_6304_y.field_1576_i;
   }

   public static boolean func_22005_v() {
      return field_21900_a != null && field_21900_a.field_6304_y.field_22278_j;
   }

   public static boolean func_22007_w() {
      return field_21900_a != null && field_21900_a.field_6304_y.field_22276_A;
   }

   public boolean func_22003_b(String p_22003_1_) {
      if(p_22003_1_.startsWith("/")) {
         ;
      }

      return false;
   }

   private void func_6265_t() {
      if(this.field_6305_x != null) {
         boolean var1 = this.field_6322_g.field_35212_aW.field_35756_d;
         int var2 = this.field_6324_e.func_600_a(this.field_6305_x.field_1166_b, this.field_6305_x.field_1172_c, this.field_6305_x.field_1171_d);
         if(!var1) {
            if(var2 == Block.field_337_v.field_376_bc) {
               var2 = Block.field_336_w.field_376_bc;
            }

            if(var2 == Block.field_411_ak.field_376_bc) {
               var2 = Block.field_410_al.field_376_bc;
            }

            if(var2 == Block.field_403_A.field_376_bc) {
               var2 = Block.field_338_u.field_376_bc;
            }
         }

         int var3 = 0;
         boolean var4 = false;
         if(Item.field_233_c[var2] != null && Item.field_233_c[var2].func_21010_e()) {
            var3 = this.field_6324_e.func_602_e(this.field_6305_x.field_1166_b, this.field_6305_x.field_1172_c, this.field_6305_x.field_1171_d);
            var4 = true;
         }

         if(Item.field_233_c[var2] != null && Item.field_233_c[var2] instanceof ItemBlock) {
            Block var5 = Block.field_345_n[var2];
            int var6 = var5.func_240_a(var3, this.field_6322_g.field_615_ag.field_1037_n, 0);
            if(var6 > 0) {
               var2 = var6;
            }
         }

         this.field_6322_g.field_778_b.func_496_a(var2, var3, var4, var1);
         if(var1) {
            int var7 = this.field_6322_g.field_20069_g.field_20122_e.size() - 9 + this.field_6322_g.field_778_b.field_847_d;
            this.field_6327_b.func_35637_a(this.field_6322_g.field_778_b.func_468_c(this.field_6322_g.field_778_b.field_847_d), var7);
         }
      }

   }

   public static String func_52003_C() {
      return "1.2.5";
   }

   public static void func_52004_D() {
      PlayerUsageSnooper var0 = new PlayerUsageSnooper("client");
      var0.func_52022_a("version", func_52003_C());
      var0.func_52022_a("os_name", System.getProperty("os.name"));
      var0.func_52022_a("os_version", System.getProperty("os.version"));
      var0.func_52022_a("os_architecture", System.getProperty("os.arch"));
      var0.func_52022_a("memory_total", Long.valueOf(Runtime.getRuntime().totalMemory()));
      var0.func_52022_a("memory_max", Long.valueOf(Runtime.getRuntime().maxMemory()));
      var0.func_52022_a("java_version", System.getProperty("java.version"));
      var0.func_52022_a("opengl_version", GL11.glGetString(7938));
      var0.func_52022_a("opengl_vendor", GL11.glGetString(7936));
      var0.func_52021_a();
   }

}
