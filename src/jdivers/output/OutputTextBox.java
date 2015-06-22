package jdivers.output;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import jdivers.Global;
import jdivers.textbox.BasicTextBox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class OutputTextBox extends BasicTextBox
{
	private static final Logger logger =
			Logger.getLogger(OutputTextBox.class.getName());

	private List<String> masterStringList;
	private OutputTextArray smallTextArray;

	private Font textBoxFont;

	public OutputTextBox()
	{
		super(null,
				20,
				Global.threeFourthHeight,
				Global.width - 40,
				Global.height - Global.threeFourthHeight - 20);
	}

	public OutputTextBox(final Font textBoxFont)
	{
		super(null,
				20,
				Global.threeFourthHeight,
				Global.width - 40,
				Global.height - Global.threeFourthHeight - 20);

		this.masterStringList = new LinkedList<String>();
		this.smallTextArray =
				new OutputTextArray(getBoxHeight() / 20);

		this.textBoxFont = textBoxFont;
	}

	@Override
	public void show(final Graphics g)
	{
		try
		{
			g.setLineWidth(1);
			g.setColor(new Color(255, 255, 255, 100));
			// g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
			// getBoxHeight());
			g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
					getBoxHeight());

			g.setColor(Color.black);

			for (int i = smallTextArray.size() - 1; i >= 0; --i)
			{
				if (smallTextArray.getTextValue(i) != null)
				{
					g.drawString(smallTextArray.getTextValue(i),
							getBoxPosX() + 10,
							getBoxPosY() + (20 * i));
				}
			}
		}
		catch (NullPointerException e)
		{
			System.err.println("NullPointerException " +
					"TextBox Error\n" + toString());
			System.exit(1);
		}
	}

	public void println(final String text)
	{
		addText(text);
		logger.info(text);
	}

	public void addText(final String text)
	{
		masterStringList.add(text);
		smallTextArray.add(text);
		fixTextWidthDisplay();
	}

	/**
	 * Fixes the entire text box array so that the text box does not render text
	 * past the box boundary.
	 */
	private void fixTextWidthDisplay()
	{
		OutputTextArray tempStringList = new OutputTextArray(
				smallTextArray.size());

		for (String tempWholeString : smallTextArray.getTextArray())
		{
			if (tempWholeString != null)
			{
				Collection<String> tempOneStringList = separateToFitWidth(tempWholeString);

				for (String tempOneString : tempOneStringList)
				{
					// System.out.println(tempOneString);
					tempStringList.add(tempOneString);
				}
			}
		}

		smallTextArray = tempStringList;
	}

	/**
	 * Separates one line of text into individual lines. Used to fit an entire
	 * line of text into the box.
	 * 
	 * @param text
	 *            The text to reorganize
	 * @return a list containing the separated text
	 */
	private LinkedList<String> separateToFitWidth(final String text)
	{
		final LinkedList<String> tempStringList =
				new LinkedList<String>();

		// Use scanner to separate each individual word.
		//
		try (Scanner scanner = new Scanner(text))
		{
			StringBuffer printTextBuffer = new StringBuffer();

			// Continue until there are no words left.
			//
			while (scanner.hasNext())
			{
				final String token = scanner.next();
				final String combinedText = printTextBuffer.toString() + " " + token;

				// If the text goes beyond the boundaries of the box, then add
				// the current Buffer String to the list and create a new Buffer
				// with the current token; otherwise, add the word to the
				// current buffer, separating it by spaces.
				//
				if (textBoxFont.getWidth(combinedText) > getBoxWidth())
				{
					tempStringList.add(printTextBuffer.toString().trim());
					printTextBuffer = new StringBuffer(token);
				}
				else
				{
					printTextBuffer.append(" " + token);
				}
			}

			// With no more words left, just add the current text to the list.
			//
			tempStringList.add(printTextBuffer.toString().trim());
		}

		return tempStringList;
	}
};
