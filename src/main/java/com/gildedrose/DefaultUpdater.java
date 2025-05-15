package com.gildedrose;

public class DefaultUpdater implements ItemUpdater {
    @Override
    public boolean supports(Item item) {
        return true; // fallback
    }

    @Override
    public void update(Item item) {
        item.sellIn--;
        int degradation = item.sellIn < 0 ? 2 : 1;
        item.quality = Math.max(0, item.quality - degradation);
    }
}
