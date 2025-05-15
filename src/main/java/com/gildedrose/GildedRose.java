package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item)) {
                updateSulfuras(item);
            } else if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if (isBackstagePass(item)) {
                updateBackstagePass(item);
            } else {
                updateNormalItem(item);
            }
        }
    }

    // Condição para identificar Sulfuras, que não muda
    private boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    // Condição para identificar Aged Brie
    private boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.name);
    }

    // Condição para identificar Backstage passes
    private boolean isBackstagePass(Item item) {
        return item.name.startsWith("Backstage passes");
    }

    // Lógica extraída para Sulfuras (sem alteração)
    private void updateSulfuras(Item item) {
        // Sulfuras não tem sellIn nem qualidade alterados
    }

    // Lógica extraída para Aged Brie
    private void updateAgedBrie(Item item) {
        decrementSellIn(item);
        if (item.quality < 50) {
            item.quality++;
        }
    }

    // Lógica extraída para Backstage passes
    private void updateBackstagePass(Item item) {
        decrementSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        increaseQuality(item);
        if (item.sellIn < 10) {
            increaseQuality(item);
        }
        if (item.sellIn < 5) {
            increaseQuality(item);
        }
    }

    // Lógica extraída para itens normais (inclui Conjured conforme legado)
    private void updateNormalItem(Item item) {
        decrementSellIn(item);
        int degradation = item.sellIn < 0 ? 2 : 1;
        reduceQuality(item, degradation);
    }

    // Métodos auxiliares
    private void decrementSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void reduceQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
