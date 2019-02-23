package net.minecraft.src;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import cpw.mods.fml.client.FMLTextureFX;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;

public class TextureWatchFX extends FMLTextureFX
{
    /**
     * Holds the game instance to retrieve information like world provider and time.
     */
    private Minecraft mc;

    /** Holds the image of the watch from items.png in rgb format. */
    private int[] watchIconImageData = new int[256];

    /** Holds the image of the dial.png in rgb format. */
    private int[] dialImageData = new int[256];
    private double field_4222_j;
    private double field_4221_k;

    public TextureWatchFX(Minecraft par1Minecraft)
    {
        super(Item.pocketSundial.getIconFromDamage(0));
        this.mc = par1Minecraft;
        this.tileImage = 1;
        setup();
    }

    @Override
    public void setup()
    {
        super.setup();
        watchIconImageData = new int[tileSizeSquare];
        dialImageData = new int[tileSizeSquare];
        try
        {
            BufferedImage var2 = ImageIO.read(mc.texturePackList.selectedTexturePack.getResourceAsStream("/gui/items.png"));
            int var3 = this.iconIndex % 16 * tileSizeBase;
            int var4 = this.iconIndex / 16 * tileSizeBase;
            var2.getRGB(var3, var4, tileSizeBase, tileSizeBase, this.watchIconImageData, 0, tileSizeBase);
            var2 = ImageIO.read(mc.texturePackList.selectedTexturePack.getResourceAsStream("/misc/dial.png"));
            if (var2.getWidth() != tileSizeBase)
            {
                BufferedImage tmp = new BufferedImage(tileSizeBase, tileSizeBase, 6);
                Graphics2D gfx = tmp.createGraphics();
                gfx.drawImage(var2, 0, 0, tileSizeBase, tileSizeBase, 0, 0, var2.getWidth(), var2.getHeight(), (ImageObserver)null);
                gfx.dispose();
                var2 = tmp;
            }
            var2.getRGB(0, 0, tileSizeBase, tileSizeBase, this.dialImageData, 0, tileSizeBase);
        }
        catch (Exception var5)
        {
            log.log(Level.WARNING, String.format("A problem occurred with the watch texture: animation will be disabled"), var5);
            setErrored(true);
        }
    }

    public void onTick()
    {
        double var1 = 0.0D;

        if (this.mc.theWorld != null && this.mc.thePlayer != null)
        {
            float var3 = this.mc.theWorld.getCelestialAngle(1.0F);
            var1 = (double)(-var3 * (float)Math.PI * 2.0F);

            if (!this.mc.theWorld.worldProvider.func_48217_e())
            {
                var1 = Math.random() * Math.PI * 2.0D;
            }
        }

        double var22;

        for (var22 = var1 - this.field_4222_j; var22 < -Math.PI; var22 += (Math.PI * 2D))
        {
            ;
        }

        while (var22 >= Math.PI)
        {
            var22 -= (Math.PI * 2D);
        }

        if (var22 < -1.0D)
        {
            var22 = -1.0D;
        }

        if (var22 > 1.0D)
        {
            var22 = 1.0D;
        }

        this.field_4221_k += var22 * 0.1D;
        this.field_4221_k *= 0.8D;
        this.field_4222_j += this.field_4221_k;
        double var5 = Math.sin(this.field_4222_j);
        double var7 = Math.cos(this.field_4222_j);

        for (int var9 = 0; var9 < tileSizeSquare; ++var9)
        {
            int var10 = this.watchIconImageData[var9] >> 24 & 255;
            int var11 = this.watchIconImageData[var9] >> 16 & 255;
            int var12 = this.watchIconImageData[var9] >> 8 & 255;
            int var13 = this.watchIconImageData[var9] >> 0 & 255;

            if (var11 == var13 && var12 == 0 && var13 > 0)
            {
                double var14 = -((double)(var9 % tileSizeBase) / tileSizeMask - 0.5D);
                double var16 = (double)(var9 / tileSizeBase) / tileSizeMask - 0.5D;
                int var18 = var11;
                int var19 = (int)((var14 * var7 + var16 * var5 + 0.5D) * tileSizeBase);
                int var20 = (int)((var16 * var7 - var14 * var5 + 0.5D) * tileSizeBase);
                int var21 = (var19 & tileSizeMask) + (var20 & tileSizeMask) * tileSizeBase;
                var10 = this.dialImageData[var21] >> 24 & 255;
                var11 = (this.dialImageData[var21] >> 16 & 255) * var11 / 255;
                var12 = (this.dialImageData[var21] >> 8 & 255) * var18 / 255;
                var13 = (this.dialImageData[var21] >> 0 & 255) * var18 / 255;
            }

            if (this.anaglyphEnabled)
            {
                int var23 = (var11 * 30 + var12 * 59 + var13 * 11) / 100;
                int var15 = (var11 * 30 + var12 * 70) / 100;
                int var24 = (var11 * 30 + var13 * 70) / 100;
                var11 = var23;
                var12 = var15;
                var13 = var24;
            }

            this.imageData[var9 * 4 + 0] = (byte)var11;
            this.imageData[var9 * 4 + 1] = (byte)var12;
            this.imageData[var9 * 4 + 2] = (byte)var13;
            this.imageData[var9 * 4 + 3] = (byte)var10;
        }
    }
}
