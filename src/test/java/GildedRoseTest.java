import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    @Test
    public void normalItemQualityDegradesByOneBeforeSellDate() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    public void normalItemQualityDegradesByTwoAfterSellDate() {
        Item[] items = new Item[] { new Item("Normal Item", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void agedBrieIncreasesQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    public void agedBrieQualityMaxesAtFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    public void sulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseByOneMoreThanTenDays() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseByTwoTenDaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseByThreeFiveDaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    public void backstagePassesDropToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void conjuredItemsDegradeAsNormalItems() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(5, items[0].quality);
    }
}