package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.src.IThreadedFileIO;

public class ThreadedFileIOBase implements Runnable {

   public static final ThreadedFileIOBase field_40573_a = new ThreadedFileIOBase();
   private List field_40571_b = Collections.synchronizedList(new ArrayList());
   private volatile long field_40572_c = 0L;
   private volatile long field_40569_d = 0L;
   private volatile boolean field_40570_e = false;


   private ThreadedFileIOBase() {
      Thread var1 = new Thread(this, "File IO Thread");
      var1.setPriority(1);
      var1.start();
   }

   public void run() {
      this.func_40568_b();
   }

   private void func_40568_b() {
      for(int var1 = 0; var1 < this.field_40571_b.size(); ++var1) {
         IThreadedFileIO var2 = (IThreadedFileIO)this.field_40571_b.get(var1);
         boolean var3 = var2.func_40550_A_();
         if(!var3) {
            this.field_40571_b.remove(var1--);
            ++this.field_40569_d;
         }

         try {
            if(!this.field_40570_e) {
               Thread.sleep(10L);
            } else {
               Thread.sleep(0L);
            }
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }
      }

      if(this.field_40571_b.isEmpty()) {
         try {
            Thread.sleep(25L);
         } catch (InterruptedException var5) {
            var5.printStackTrace();
         }
      }

   }

   public void func_40567_a(IThreadedFileIO p_40567_1_) {
      if(!this.field_40571_b.contains(p_40567_1_)) {
         ++this.field_40572_c;
         this.field_40571_b.add(p_40567_1_);
      }
   }

   public void func_40566_a() throws InterruptedException {
      this.field_40570_e = true;

      while(this.field_40572_c != this.field_40569_d) {
         Thread.sleep(10L);
      }

      this.field_40570_e = false;
   }

}
