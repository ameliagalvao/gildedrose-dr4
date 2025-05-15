package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public boolean supports(Item item) {
        return "Aged Brie".equals(item.name);
    }

    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
