package net.minecraft.src;

public abstract class GuiConfirmOpenLink extends GuiYesNo
{
    private String field_50054_a;
    private String field_50053_b;

    public GuiConfirmOpenLink(GuiScreen par1GuiScreen, String par2Str, int par3)
    {
        super(par1GuiScreen, StringTranslate.getInstance().translateKey("chat.link.confirm"), par2Str, par3);
        StringTranslate var4 = StringTranslate.getInstance();
        this.buttonText1 = var4.translateKey("gui.yes");
        this.buttonText2 = var4.translateKey("gui.no");
        this.field_50053_b = var4.translateKey("chat.copy");
        this.field_50054_a = var4.translateKey("chat.link.warning");
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.controlList.add(new GuiButton(0, this.width / 3 - 83 + 0, this.height / 6 + 96, 100, 20, this.buttonText1));
        this.controlList.add(new GuiButton(2, this.width / 3 - 83 + 105, this.height / 6 + 96, 100, 20, this.field_50053_b));
        this.controlList.add(new GuiButton(1, this.width / 3 - 83 + 210, this.height / 6 + 96, 100, 20, this.buttonText2));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 2)
        {
            this.func_50052_d();
            super.actionPerformed((GuiButton)this.controlList.get(1));
        }
        else
        {
            super.actionPerformed(par1GuiButton);
        }
    }

    public abstract void func_50052_d();

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRenderer, this.field_50054_a, this.width / 2, 110, 16764108);
    }
}
