package studio.dreamys.minesense.component.sub;

import studio.dreamys.minesense.component.Component;
import studio.dreamys.minesense.component.Window;
import studio.dreamys.minesense.util.RenderUtils;

import java.awt.Color;

public class Checkbox extends Component {
    private Window window;
    private double width;
    private double height;
    private double x;
    private double y;
    private String label;

    //relative to window, aka x,y passed in constructor
    private double relativeX;
    private double relativeY;

    private boolean toggled;

    public Checkbox(double width, double height, double x, double y, String label) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public void render(int mouseX, int mouseY) {
        //update position
        x = window.x + relativeX;
        y = window.y + relativeY;

        Color color = toggled ? window.color : Color.DARK_GRAY;

        //the box itself + label next to it
        RenderUtils.drawGradientRect(x, y, x + width, y + height, color, color.darker().darker());
        RenderUtils.drawScaledString(label, x + width * 2, y, 0.5f,  Color.WHITE);
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (hovered(mouseX, mouseY) && mouseButton == 0) {
            toggled = !toggled;
        }
    }

    private boolean hovered(double x, double y) {
        return x > this.x && x < this.x + width && y > this.y && y < this.y + height;
    }

    public void setWindow(Window window) {
        this.window = window;
        relativeX = x;
        relativeY = y;
    }
}