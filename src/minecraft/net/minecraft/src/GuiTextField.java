package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiTextField extends Gui
{
    /**
     * Have the font renderer from GuiScreen to render the textbox text into the screen.
     */
    private final FontRenderer fontRenderer;
    private final int xPos;
    private final int yPos;

    /** The width of this text field. */
    private final int width;
    private final int height;

    /** Have the current text beign edited on the textbox. */
    private String text = "";
    private int maxStringLength = 32;
    private int cursorCounter;
    private boolean enableBackgroundDrawing = true;

    /**
     * if true the textbox can lose focus by clicking elsewhere on the screen
     */
    private boolean canLoseFocus = true;

    /**
     * If this value is true along isEnabled, keyTyped will process the keys.
     */
    private boolean isFocused = false;

    /**
     * If this value is true along isFocused, keyTyped will process the keys.
     */
    private boolean isEnabled = true;
    private int field_50041_n = 0;
    private int field_50042_o = 0;
    private int field_50048_p = 0;
    private int enabledColor = 14737632;
    private int disabledColor = 7368816;

    public GuiTextField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5)
    {
        this.fontRenderer = par1FontRenderer;
        this.xPos = par2;
        this.yPos = par3;
        this.width = par4;
        this.height = par5;
    }

    /**
     * Increments the cursor counter
     */
    public void updateCursorCounter()
    {
        ++this.cursorCounter;
    }

    /**
     * Sets the text of the textbox.
     */
    public void setText(String par1Str)
    {
        if (par1Str.length() > this.maxStringLength)
        {
            this.text = par1Str.substring(0, this.maxStringLength);
        }
        else
        {
            this.text = par1Str;
        }

        this.func_50038_e();
    }

    /**
     * Returns the text beign edited on the textbox.
     */
    public String getText()
    {
        return this.text;
    }

    public String func_50039_c()
    {
        int var1 = this.field_50042_o < this.field_50048_p ? this.field_50042_o : this.field_50048_p;
        int var2 = this.field_50042_o < this.field_50048_p ? this.field_50048_p : this.field_50042_o;
        return this.text.substring(var1, var2);
    }

    public void func_50031_b(String par1Str)
    {
        String var2 = "";
        String var3 = ChatAllowedCharacters.filerAllowedCharacters(par1Str);
        int var4 = this.field_50042_o < this.field_50048_p ? this.field_50042_o : this.field_50048_p;
        int var5 = this.field_50042_o < this.field_50048_p ? this.field_50048_p : this.field_50042_o;
        int var6 = this.maxStringLength - this.text.length() - (var4 - this.field_50048_p);
        boolean var7 = false;

        if (this.text.length() > 0)
        {
            var2 = var2 + this.text.substring(0, var4);
        }

        int var8;

        if (var6 < var3.length())
        {
            var2 = var2 + var3.substring(0, var6);
            var8 = var6;
        }
        else
        {
            var2 = var2 + var3;
            var8 = var3.length();
        }

        if (this.text.length() > 0 && var5 < this.text.length())
        {
            var2 = var2 + this.text.substring(var5);
        }

        this.text = var2;
        this.func_50023_d(var4 - this.field_50048_p + var8);
    }

    public void func_50021_a(int par1)
    {
        if (this.text.length() != 0)
        {
            if (this.field_50048_p != this.field_50042_o)
            {
                this.func_50031_b("");
            }
            else
            {
                this.func_50020_b(this.func_50028_c(par1) - this.field_50042_o);
            }
        }
    }

    public void func_50020_b(int par1)
    {
        if (this.text.length() != 0)
        {
            if (this.field_50048_p != this.field_50042_o)
            {
                this.func_50031_b("");
            }
            else
            {
                boolean var2 = par1 < 0;
                int var3 = var2 ? this.field_50042_o + par1 : this.field_50042_o;
                int var4 = var2 ? this.field_50042_o : this.field_50042_o + par1;
                String var5 = "";

                if (var3 >= 0)
                {
                    var5 = this.text.substring(0, var3);
                }

                if (var4 < this.text.length())
                {
                    var5 = var5 + this.text.substring(var4);
                }

                this.text = var5;

                if (var2)
                {
                    this.func_50023_d(par1);
                }
            }
        }
    }

    public int func_50028_c(int par1)
    {
        return this.func_50024_a(par1, this.func_50035_h());
    }

    public int func_50024_a(int par1, int par2)
    {
        int var3 = par2;
        boolean var4 = par1 < 0;
        int var5 = Math.abs(par1);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            if (var4)
            {
                while (var3 > 0 && this.text.charAt(var3 - 1) == 32)
                {
                    --var3;
                }

                while (var3 > 0 && this.text.charAt(var3 - 1) != 32)
                {
                    --var3;
                }
            }
            else
            {
                int var7 = this.text.length();
                var3 = this.text.indexOf(32, var3);

                if (var3 == -1)
                {
                    var3 = var7;
                }
                else
                {
                    while (var3 < var7 && this.text.charAt(var3) == 32)
                    {
                        ++var3;
                    }
                }
            }
        }

        return var3;
    }

    public void func_50023_d(int par1)
    {
        this.func_50030_e(this.field_50048_p + par1);
    }

    public void func_50030_e(int par1)
    {
        this.field_50042_o = par1;
        int var2 = this.text.length();

        if (this.field_50042_o < 0)
        {
            this.field_50042_o = 0;
        }

        if (this.field_50042_o > var2)
        {
            this.field_50042_o = var2;
        }

        this.func_50032_g(this.field_50042_o);
    }

    public void func_50034_d()
    {
        this.func_50030_e(0);
    }

    public void func_50038_e()
    {
        this.func_50030_e(this.text.length());
    }

    /**
     * Call this method from you GuiScreen to process the keys into textbox.
     */
    public boolean textboxKeyTyped(char par1, int par2)
    {
        if (this.isEnabled && this.isFocused)
        {
            switch (par1)
            {
                case 1:
                    this.func_50038_e();
                    this.func_50032_g(0);
                    return true;
                case 3:
                    GuiScreen.setClipboardString(this.func_50039_c());
                    return true;
                case 22:
                    this.func_50031_b(GuiScreen.getClipboardString());
                    return true;
                case 24:
                    GuiScreen.setClipboardString(this.func_50039_c());
                    this.func_50031_b("");
                    return true;
                default:
                    switch (par2)
                    {
                        case 14:
                            if (GuiScreen.isCtrlKeyDown())
                            {
                                this.func_50021_a(-1);
                            }
                            else
                            {
                                this.func_50020_b(-1);
                            }

                            return true;
                        case 199:
                            if (GuiScreen.isShiftKeyDown())
                            {
                                this.func_50032_g(0);
                            }
                            else
                            {
                                this.func_50034_d();
                            }

                            return true;
                        case 203:
                            if (GuiScreen.isShiftKeyDown())
                            {
                                if (GuiScreen.isCtrlKeyDown())
                                {
                                    this.func_50032_g(this.func_50024_a(-1, this.func_50036_k()));
                                }
                                else
                                {
                                    this.func_50032_g(this.func_50036_k() - 1);
                                }
                            }
                            else if (GuiScreen.isCtrlKeyDown())
                            {
                                this.func_50030_e(this.func_50028_c(-1));
                            }
                            else
                            {
                                this.func_50023_d(-1);
                            }

                            return true;
                        case 205:
                            if (GuiScreen.isShiftKeyDown())
                            {
                                if (GuiScreen.isCtrlKeyDown())
                                {
                                    this.func_50032_g(this.func_50024_a(1, this.func_50036_k()));
                                }
                                else
                                {
                                    this.func_50032_g(this.func_50036_k() + 1);
                                }
                            }
                            else if (GuiScreen.isCtrlKeyDown())
                            {
                                this.func_50030_e(this.func_50028_c(1));
                            }
                            else
                            {
                                this.func_50023_d(1);
                            }

                            return true;
                        case 207:
                            if (GuiScreen.isShiftKeyDown())
                            {
                                this.func_50032_g(this.text.length());
                            }
                            else
                            {
                                this.func_50038_e();
                            }

                            return true;
                        case 211:
                            if (GuiScreen.isCtrlKeyDown())
                            {
                                this.func_50021_a(1);
                            }
                            else
                            {
                                this.func_50020_b(1);
                            }

                            return true;
                        default:
                            if (ChatAllowedCharacters.isAllowedCharacter(par1))
                            {
                                this.func_50031_b(Character.toString(par1));
                                return true;
                            }
                            else
                            {
                                return false;
                            }
                    }
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Args: x, y, buttonClicked
     */
    public void mouseClicked(int par1, int par2, int par3)
    {
        boolean var4 = par1 >= this.xPos && par1 < this.xPos + this.width && par2 >= this.yPos && par2 < this.yPos + this.height;

        if (this.canLoseFocus)
        {
            this.setFocused(this.isEnabled && var4);
        }

        if (this.isFocused && par3 == 0)
        {
            int var5 = par1 - this.xPos;

            if (this.enableBackgroundDrawing)
            {
                var5 -= 4;
            }

            String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_50041_n), this.func_50019_l());
            this.func_50030_e(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.field_50041_n);
        }
    }

    /**
     * Draws the textbox
     */
    public void drawTextBox()
    {
        if (this.getEnableBackgroundDrawing())
        {
            drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
            drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
        }

        int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
        int var2 = this.field_50042_o - this.field_50041_n;
        int var3 = this.field_50048_p - this.field_50041_n;
        String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_50041_n), this.func_50019_l());
        boolean var5 = var2 >= 0 && var2 <= var4.length();
        boolean var6 = this.isFocused && this.cursorCounter / 6 % 2 == 0 && var5;
        int var7 = this.enableBackgroundDrawing ? this.xPos + 4 : this.xPos;
        int var8 = this.enableBackgroundDrawing ? this.yPos + (this.height - 8) / 2 : this.yPos;
        int var9 = var7;

        if (var3 > var4.length())
        {
            var3 = var4.length();
        }

        if (var4.length() > 0)
        {
            String var10 = var5 ? var4.substring(0, var2) : var4;
            var9 = this.fontRenderer.drawStringWithShadow(var10, var7, var8, var1);
        }

        boolean var13 = this.field_50042_o < this.text.length() || this.text.length() >= this.func_50040_g();
        int var11 = var9;

        if (!var5)
        {
            var11 = var2 > 0 ? var7 + this.width : var7;
        }
        else if (var13)
        {
            var11 = var9 - 1;
            --var9;
        }

        if (var4.length() > 0 && var5 && var2 < var4.length())
        {
            this.fontRenderer.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
        }

        if (var6)
        {
            if (var13)
            {
                Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
            }
            else
            {
                this.fontRenderer.drawStringWithShadow("_", var11, var8, var1);
            }
        }

        if (var3 != var2)
        {
            int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
            this.func_50029_c(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT);
        }
    }

    private void func_50029_c(int par1, int par2, int par3, int par4)
    {
        int var5;

        if (par1 < par3)
        {
            var5 = par1;
            par1 = par3;
            par3 = var5;
        }

        if (par2 < par4)
        {
            var5 = par2;
            par2 = par4;
            par4 = var5;
        }

        Tessellator var6 = Tessellator.instance;
        GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_COLOR_LOGIC_OP);
        GL11.glLogicOp(GL11.GL_OR_REVERSE);
        var6.startDrawingQuads();
        var6.addVertex((double)par1, (double)par4, 0.0D);
        var6.addVertex((double)par3, (double)par4, 0.0D);
        var6.addVertex((double)par3, (double)par2, 0.0D);
        var6.addVertex((double)par1, (double)par2, 0.0D);
        var6.draw();
        GL11.glDisable(GL11.GL_COLOR_LOGIC_OP);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    public void setMaxStringLength(int par1)
    {
        this.maxStringLength = par1;

        if (this.text.length() > par1)
        {
            this.text = this.text.substring(0, par1);
        }
    }

    public int func_50040_g()
    {
        return this.maxStringLength;
    }

    public int func_50035_h()
    {
        return this.field_50042_o;
    }

    /**
     * get enable drawing background and outline
     */
    public boolean getEnableBackgroundDrawing()
    {
        return this.enableBackgroundDrawing;
    }

    /**
     * enable drawing background and outline
     */
    public void setEnableBackgroundDrawing(boolean par1)
    {
        this.enableBackgroundDrawing = par1;
    }

    /**
     * setter for the focused field
     */
    public void setFocused(boolean par1)
    {
        if (par1 && !this.isFocused)
        {
            this.cursorCounter = 0;
        }

        this.isFocused = par1;
    }

    /**
     * getter for the focused field
     */
    public boolean getIsFocused()
    {
        return this.isFocused;
    }

    public int func_50036_k()
    {
        return this.field_50048_p;
    }

    public int func_50019_l()
    {
        return this.getEnableBackgroundDrawing() ? this.width - 8 : this.width;
    }

    public void func_50032_g(int par1)
    {
        int var2 = this.text.length();

        if (par1 > var2)
        {
            par1 = var2;
        }

        if (par1 < 0)
        {
            par1 = 0;
        }

        this.field_50048_p = par1;

        if (this.fontRenderer != null)
        {
            if (this.field_50041_n > var2)
            {
                this.field_50041_n = var2;
            }

            int var3 = this.func_50019_l();
            String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.field_50041_n), var3);
            int var5 = var4.length() + this.field_50041_n;

            if (par1 == this.field_50041_n)
            {
                this.field_50041_n -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
            }

            if (par1 > var5)
            {
                this.field_50041_n += par1 - var5;
            }
            else if (par1 <= this.field_50041_n)
            {
                this.field_50041_n -= this.field_50041_n - par1;
            }

            if (this.field_50041_n < 0)
            {
                this.field_50041_n = 0;
            }

            if (this.field_50041_n > var2)
            {
                this.field_50041_n = var2;
            }
        }
    }

    /**
     * if true the textbox can lose focus by clicking elsewhere on the screen
     */
    public void setCanLoseFocus(boolean par1)
    {
        this.canLoseFocus = par1;
    }
}
