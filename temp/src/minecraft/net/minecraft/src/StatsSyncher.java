package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import net.minecraft.src.Session;
import net.minecraft.src.StatFileWriter;
import net.minecraft.src.ThreadStatSyncherReceive;
import net.minecraft.src.ThreadStatSyncherSend;

public class StatsSyncher {

   private volatile boolean field_27438_a = false;
   private volatile Map field_27437_b = null;
   private volatile Map field_27436_c = null;
   private StatFileWriter field_27435_d;
   private File field_27434_e;
   private File field_27433_f;
   private File field_27432_g;
   private File field_27431_h;
   private File field_27430_i;
   private File field_27429_j;
   private Session field_27428_k;
   private int field_27427_l = 0;
   private int field_27426_m = 0;


   public StatsSyncher(Session p_i640_1_, StatFileWriter p_i640_2_, File p_i640_3_) {
      this.field_27434_e = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + "_unsent.dat");
      this.field_27433_f = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + ".dat");
      this.field_27430_i = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + "_unsent.old");
      this.field_27429_j = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + ".old");
      this.field_27432_g = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + "_unsent.tmp");
      this.field_27431_h = new File(p_i640_3_, "stats_" + p_i640_1_.field_1666_b.toLowerCase() + ".tmp");
      if(!p_i640_1_.field_1666_b.toLowerCase().equals(p_i640_1_.field_1666_b)) {
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + "_unsent.dat", this.field_27434_e);
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + ".dat", this.field_27433_f);
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + "_unsent.old", this.field_27430_i);
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + ".old", this.field_27429_j);
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + "_unsent.tmp", this.field_27432_g);
         this.func_28214_a(p_i640_3_, "stats_" + p_i640_1_.field_1666_b + ".tmp", this.field_27431_h);
      }

      this.field_27435_d = p_i640_2_;
      this.field_27428_k = p_i640_1_;
      if(this.field_27434_e.exists()) {
         p_i640_2_.func_27179_a(this.func_27415_a(this.field_27434_e, this.field_27432_g, this.field_27430_i));
      }

      this.func_27418_a();
   }

   private void func_28214_a(File p_28214_1_, String p_28214_2_, File p_28214_3_) {
      File var4 = new File(p_28214_1_, p_28214_2_);
      if(var4.exists() && !var4.isDirectory() && !p_28214_3_.exists()) {
         var4.renameTo(p_28214_3_);
      }

   }

   private Map func_27415_a(File p_27415_1_, File p_27415_2_, File p_27415_3_) {
      return p_27415_1_.exists()?this.func_27408_a(p_27415_1_):(p_27415_3_.exists()?this.func_27408_a(p_27415_3_):(p_27415_2_.exists()?this.func_27408_a(p_27415_2_):null));
   }

   private Map func_27408_a(File p_27408_1_) {
      BufferedReader var2 = null;

      try {
         var2 = new BufferedReader(new FileReader(p_27408_1_));
         String var3 = "";
         StringBuilder var4 = new StringBuilder();

         while((var3 = var2.readLine()) != null) {
            var4.append(var3);
         }

         Map var5 = StatFileWriter.func_27177_a(var4.toString());
         return var5;
      } catch (Exception var15) {
         var15.printStackTrace();
      } finally {
         if(var2 != null) {
            try {
               var2.close();
            } catch (Exception var14) {
               var14.printStackTrace();
            }
         }

      }

      return null;
   }

   private void func_27410_a(Map p_27410_1_, File p_27410_2_, File p_27410_3_, File p_27410_4_) throws IOException {
      PrintWriter var5 = new PrintWriter(new FileWriter(p_27410_3_, false));

      try {
         var5.print(StatFileWriter.func_27185_a(this.field_27428_k.field_1666_b, "local", p_27410_1_));
      } finally {
         var5.close();
      }

      if(p_27410_4_.exists()) {
         p_27410_4_.delete();
      }

      if(p_27410_2_.exists()) {
         p_27410_2_.renameTo(p_27410_4_);
      }

      p_27410_3_.renameTo(p_27410_2_);
   }

   public void func_27418_a() {
      if(this.field_27438_a) {
         throw new IllegalStateException("Can\'t get stats from server while StatsSyncher is busy!");
      } else {
         this.field_27427_l = 100;
         this.field_27438_a = true;
         (new ThreadStatSyncherReceive(this)).start();
      }
   }

   public void func_27424_a(Map p_27424_1_) {
      if(this.field_27438_a) {
         throw new IllegalStateException("Can\'t save stats while StatsSyncher is busy!");
      } else {
         this.field_27427_l = 100;
         this.field_27438_a = true;
         (new ThreadStatSyncherSend(this, p_27424_1_)).start();
      }
   }

   public void func_27407_b(Map p_27407_1_) {
      int var2 = 30;

      while(this.field_27438_a) {
         --var2;
         if(var2 <= 0) {
            break;
         }

         try {
            Thread.sleep(100L);
         } catch (InterruptedException var10) {
            var10.printStackTrace();
         }
      }

      this.field_27438_a = true;

      try {
         this.func_27410_a(p_27407_1_, this.field_27434_e, this.field_27432_g, this.field_27430_i);
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         this.field_27438_a = false;
      }

   }

   public boolean func_27420_b() {
      return this.field_27427_l <= 0 && !this.field_27438_a && this.field_27436_c == null;
   }

   public void func_27425_c() {
      if(this.field_27427_l > 0) {
         --this.field_27427_l;
      }

      if(this.field_27426_m > 0) {
         --this.field_27426_m;
      }

      if(this.field_27436_c != null) {
         this.field_27435_d.func_27187_c(this.field_27436_c);
         this.field_27436_c = null;
      }

      if(this.field_27437_b != null) {
         this.field_27435_d.func_27180_b(this.field_27437_b);
         this.field_27437_b = null;
      }

   }

   // $FF: synthetic method
   static Map func_27422_a(StatsSyncher p_27422_0_) {
      return p_27422_0_.field_27437_b;
   }

   // $FF: synthetic method
   static File func_27423_b(StatsSyncher p_27423_0_) {
      return p_27423_0_.field_27433_f;
   }

   // $FF: synthetic method
   static File func_27411_c(StatsSyncher p_27411_0_) {
      return p_27411_0_.field_27431_h;
   }

   // $FF: synthetic method
   static File func_27413_d(StatsSyncher p_27413_0_) {
      return p_27413_0_.field_27429_j;
   }

   // $FF: synthetic method
   static void func_27412_a(StatsSyncher p_27412_0_, Map p_27412_1_, File p_27412_2_, File p_27412_3_, File p_27412_4_) throws IOException {
      p_27412_0_.func_27410_a(p_27412_1_, p_27412_2_, p_27412_3_, p_27412_4_);
   }

   // $FF: synthetic method
   static Map func_27421_a(StatsSyncher p_27421_0_, Map p_27421_1_) {
      return p_27421_0_.field_27437_b = p_27421_1_;
   }

   // $FF: synthetic method
   static Map func_27409_a(StatsSyncher p_27409_0_, File p_27409_1_, File p_27409_2_, File p_27409_3_) {
      return p_27409_0_.func_27415_a(p_27409_1_, p_27409_2_, p_27409_3_);
   }

   // $FF: synthetic method
   static boolean func_27416_a(StatsSyncher p_27416_0_, boolean p_27416_1_) {
      return p_27416_0_.field_27438_a = p_27416_1_;
   }

   // $FF: synthetic method
   static File func_27414_e(StatsSyncher p_27414_0_) {
      return p_27414_0_.field_27434_e;
   }

   // $FF: synthetic method
   static File func_27417_f(StatsSyncher p_27417_0_) {
      return p_27417_0_.field_27432_g;
   }

   // $FF: synthetic method
   static File func_27419_g(StatsSyncher p_27419_0_) {
      return p_27419_0_.field_27430_i;
   }
}
