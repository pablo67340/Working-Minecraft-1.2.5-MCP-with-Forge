package net.minecraft.src;

import cpw.mods.fml.client.FMLTextureFX;

public class TextureFlamesFX extends FMLTextureFX
{
    protected float[] field_1133_g = new float[320];
    protected float[] field_1132_h = new float[320];
    private int fireTileSize = 20;
    private int fireGridSize = 320;

    public TextureFlamesFX(int par1)
    {
        super(Block.fire.blockIndexInTexture + par1 * 16);
        setup();
    }

    @Override
    public void setup()
    {
        super.setup();
        fireTileSize = tileSizeBase + (tileSizeBase >> 2);
        fireGridSize = fireTileSize * tileSizeBase;
        field_1133_g = new float[fireGridSize];
        field_1132_h = new float[fireGridSize];
    }

    public void onTick()
    {
        int var3;
        float var4;
        int var6;

        float fireFactor1 = 3.0F + (float)(tileSizeBase >> 4);
        
        float fireFactor2 = 1.01F + (0.8F / tileSizeBase);

        for (int var1 = 0; var1 < tileSizeBase; ++var1)
        {
            for (int var2 = 0; var2 < fireTileSize; ++var2)
            {
                var3 = fireTileSize - (tileSizeBase >> 3);

                var4 = this.field_1133_g[var1 + (var2 + 1) % fireTileSize * tileSizeBase] * (float)var3;

                for (int var5 = var1 - 1; var5 <= var1 + 1; ++var5)
                {
                    for (var6 = var2; var6 <= var2 + 1; ++var6)
                    {
                        if (var5 >= 0 && var6 >= 0 && var5 < tileSizeBase && var6 < fireTileSize)
                        {
                            var4 += this.field_1133_g[var5 + var6 * tileSizeBase];
                        }

                        ++var3;
                    }
                }

                this.field_1132_h[var1 + var2 * tileSizeBase] = var4 / ((float)var3 * fireFactor2);

                if (var2 >= fireTileSize - (tileSizeBase >> 4))
                {
                    this.field_1132_h[var1 + var2 * tileSizeBase] = (float)(Math.random() * Math.random() * Math.random() * fireFactor1 + Math.random() * 0.1F + 0.2F);
                }
            }
        }

        float[] var13 = this.field_1132_h;
        this.field_1132_h = this.field_1133_g;
        this.field_1133_g = var13;

        for (var3 = 0; var3 < tileSizeSquare; ++var3)
        {
            var4 = this.field_1133_g[var3] * 1.8F;

            if (var4 > 1.0F)
            {
                var4 = 1.0F;
            }

            if (var4 < 0.0F)
            {
                var4 = 0.0F;
            }

            var6 = (int)(var4 * 155.0F + 100.0F);
            int var7 = (int)(var4 * var4 * 255.0F);
            int var8 = (int)(var4 * var4 * var4 * var4 * var4 * var4 * var4 * var4 * var4 * var4 * 255.0F);
            short var9 = 255;

            if (var4 < 0.5F)
            {
                var9 = 0;
            }

            float var14 = (var4 - 0.5F) * 2.0F;

            if (this.anaglyphEnabled)
            {
                int var10 = (var6 * 30 + var7 * 59 + var8 * 11) / 100;
                int var11 = (var6 * 30 + var7 * 70) / 100;
                int var12 = (var6 * 30 + var8 * 70) / 100;
                var6 = var10;
                var7 = var11;
                var8 = var12;
            }

            this.imageData[var3 * 4 + 0] = (byte)var6;
            this.imageData[var3 * 4 + 1] = (byte)var7;
            this.imageData[var3 * 4 + 2] = (byte)var8;
            this.imageData[var3 * 4 + 3] = (byte)var9;
        }
    }
}
