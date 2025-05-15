package com.gildedrose;

public class SulfurasUpdater implements ItemUpdater {
    @Override
    public boolean supports(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    @Override
    public void update(Item item) {
        // não faz nada
    }
}
