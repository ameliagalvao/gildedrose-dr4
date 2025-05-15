package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public boolean supports(Item item) {
        return item.name.toLowerCase().startsWith("conjured");
    }

    @Override
    public void update(Item item) {
        item.sellIn--;
        int degradation = item.sellIn < 0 ? 4 : 2;
        item.quality = Math.max(0, item.quality - degradation);
    }
}
