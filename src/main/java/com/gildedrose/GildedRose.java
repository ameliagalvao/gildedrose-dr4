package com.gildedrose;

import java.util.Arrays;
import java.util.List;

public class GildedRose {
    private List<ItemUpdater> updaters = Arrays.asList(
            new SulfurasUpdater(),
            new AgedBrieUpdater(),
            new BackstagePassUpdater(),
            new ConjuredItemUpdater(),
            new DefaultUpdater()
    );
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            for (ItemUpdater updater : updaters) {
                if (updater.supports(item)) {
                    updater.update(item);
                    break;
                }
            }
        }
    }
}
