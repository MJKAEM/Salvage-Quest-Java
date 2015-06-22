package jdivers.output;

public class OutputTextArray
{
	private String[] textArray;

	public OutputTextArray(final int size)
	{
		this.textArray = new String[size];
	}

	public void add(final String text)
	{
		add(getTextArray().length - 1, text);
	}

	public void add(int index, final String text)
	{
		for (int i = 1; i <= index; ++i)
		{
			setTextValue(i - 1, getTextValue(i));
		}

		setTextValue(index, text);
	}

	public int count()
	{
		int count = 0;

		for (String s : textArray)
		{
			if (s != null)
			{
				++count;
			}
		}

		return count;
	}

	public int size()
	{
		int size = textArray.length;

		return size;
	}

	//
	// Getters / Setters
	//

	public String[] getTextArray()
	{
		return this.textArray;
	}

	public String getTextValue(final int index)
	{
		return this.textArray[index];
	}

	public void setTextValue(final int index, final String text)
	{
		this.textArray[index] = text;
	}
};
