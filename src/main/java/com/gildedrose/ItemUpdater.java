package com.gildedrose;

public interface ItemUpdater {
    boolean supports(Item item);
    void update(Item item);
}