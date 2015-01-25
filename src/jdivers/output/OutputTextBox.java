package jdivers.output;

import java.util.LinkedList;

import jdivers.Global;
import jdivers.textbox.AbstractTextBox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class OutputTextBox extends AbstractTextBox
{
	private LinkedList<String> stringList;

	public OutputTextBox()
	{
		super(null,
				20,
				Global.threeFourthHeight,
				Global.width - 40,
				Global.height - Global.threeFourthHeight - 20);

		stringList = new LinkedList<String>();

		println("Testing");
		println("Testing");
		println("Testing");
		println("Testing");
		println("Testing");
		println("lol");
	}

	@Override
	public void show(Graphics g)
	{
		g.setLineWidth(1);
		g.setColor(new Color(255, 255, 255, 100));
		//g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());
		g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());

		g.setColor(Color.black);

		for (int i = stringList.size() - 1; i >= 0; --i)
		{
			g.drawString(stringList.get(i),
					getBoxPosX() + 10,
					getBoxPosY() + getBoxHeight() - (20 + (20 * i)));
		}
	}

	public void println(final String text)
	{
		addText(text);
		System.out.println(text);
	}

	public void addText(final String text)
	{
		if ((stringList.size() * 20) + 20 > getBoxHeight())
		{
			stringList.removeFirst();
		}
		stringList.addFirst(text);
	}
};