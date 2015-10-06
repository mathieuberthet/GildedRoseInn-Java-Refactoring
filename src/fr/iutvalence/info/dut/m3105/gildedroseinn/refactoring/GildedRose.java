package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQuality();
		updateSellIn();
		updateQualitybySellIn();
	}

	/*
	 * Pour tous les items, on va sous certaines conditions, baisser la qualité ou bien il va l'augmenter
	 */
	public static void updateQuality()
	{
		for (int i = 0; i < items.size(); i++)
		{
			if (("Aged Brie".equals(items.get(i).getName())) 
				|| "Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) 
			{
				if (items.get(i).getQuality() < 50)
				{
					items.get(i).setQuality(items.get(i).getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
					{
						if (items.get(i).getSellIn() < 11)
						{
							if (items.get(i).getQuality() < 50)
							{
								items.get(i).setQuality(items.get(i).getQuality() + 2);
							}
						}

						if (items.get(i).getSellIn() < 6)
						{
							if (items.get(i).getQuality() < 50)
							{
								items.get(i).setQuality(items.get(i).getQuality() + 3);
							}
						}
					}
				}
			} 
			else 
			{
				if (items.get(i).getQuality() > 0)
				{
					if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
					{
						items.get(i).setQuality(items.get(i).getQuality() - 1);
					}
				}
			}
		}
	}
	/*
	 * Décrémentation de la date limite pour chaque item
	 */
	public static void updateSellIn()
	{
		for (int j = 0; j < items.size(); j++)
		{

			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(j).getName()))
			{
				items.get(j).setSellIn(items.get(j).getSellIn() - 1);
			}
		}
	}
	
	/*
	 * Mise a jour de la qualité quand la date limite est dépassé pour chaque item
	 */
	public static void updateQualitybySellIn()
	{
		for (int k = 0; k < items.size(); k++)
		{

			if (items.get(k).getSellIn() < 0)
			{
				if ("Aged Brie".equals(items.get(k).getName())) 
				{
					if (items.get(k).getQuality() < 50)
					{
						items.get(k).setQuality(items.get(k).getQuality() + 1);
					}
				} 
				else 
				{
					if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(k).getName())) 
					{
						items.get(k).setQuality(items.get(k).getQuality() - items.get(k).getQuality());
					} 
					else 
					{
						if (items.get(k).getQuality() > 0)
						{
							if (!"Sulfuras, Hand of Ragnaros".equals(items.get(k).getName()))
							{
								items.get(k).setQuality(items.get(k).getQuality() - 2);
							}
						}
					}
				}
			}
		}
	}
	
	public static void conjuratedItem(boolean conjurate)
	{
		for (int l = 0; l < items.size(); l++)
		{
			if (conjurate == true)
			{
				if (!"Sulfuras, Hand of Ragnaros".equals(items.get(l).getName()))
				{
					items.get(l).setQuality(items.get(l).getQuality() -2);
				}
			}
			else
			{
				if (!"Sulfuras, Hand of Ragnaros".equals(items.get(l).getName()))
				{
					items.get(l).setQuality(items.get(l).getQuality() -1);
				}
			}
		}
	}
}