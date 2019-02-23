package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.PanelCrashReport;
import net.minecraft.src.UnexpectedThrowable;

public final class MinecraftImpl extends Minecraft {

   // $FF: synthetic field
   final Frame field_20919_a;


   public MinecraftImpl(Component p_i361_1_, Canvas p_i361_2_, MinecraftApplet p_i361_3_, int p_i361_4_, int p_i361_5_, boolean p_i361_6_, Frame p_i361_7_) {
      super(p_i361_1_, p_i361_2_, p_i361_3_, p_i361_4_, p_i361_5_, p_i361_6_);
      this.field_20919_a = p_i361_7_;
   }

   public void func_4007_a(UnexpectedThrowable p_4007_1_) {
      this.field_20919_a.removeAll();
      this.field_20919_a.add(new PanelCrashReport(p_4007_1_), "Center");
      this.field_20919_a.validate();
   }
}
