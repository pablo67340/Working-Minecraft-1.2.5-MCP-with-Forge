package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.PanelCrashReport;
import net.minecraft.src.UnexpectedThrowable;

public class MinecraftAppletImpl extends Minecraft {

   // $FF: synthetic field
   final MinecraftApplet field_186_a;


   public MinecraftAppletImpl(MinecraftApplet p_i485_1_, Component p_i485_2_, Canvas p_i485_3_, MinecraftApplet p_i485_4_, int p_i485_5_, int p_i485_6_, boolean p_i485_7_) {
      super(p_i485_2_, p_i485_3_, p_i485_4_, p_i485_5_, p_i485_6_, p_i485_7_);
      this.field_186_a = p_i485_1_;
   }

   public void func_4007_a(UnexpectedThrowable p_4007_1_) {
      this.field_186_a.removeAll();
      this.field_186_a.setLayout(new BorderLayout());
      this.field_186_a.add(new PanelCrashReport(p_4007_1_), "Center");
      this.field_186_a.validate();
   }
}
